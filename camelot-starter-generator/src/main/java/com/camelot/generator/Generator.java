package com.camelot.generator;


import com.camelot.generator.common.Column;
import com.camelot.generator.common.Table;
import com.camelot.generator.utils.CamelCaseUtils;
import com.camelot.generator.utils.FileHelper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

@Slf4j
public class Generator {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private Properties properties = null;

    public Generator() throws Exception {
        properties = new Properties();
        String fileDir = getClass().getClassLoader().getResource("generator.xml").getFile();
        properties.loadFromXML(new FileInputStream(fileDir));
    }

    public Table parseTable(String tableName) throws Exception {
        String driverName = properties.getProperty("jdbc.driver");
        String userName = properties.getProperty("jdbc.username");
        String userPwd = properties.getProperty("jdbc.password");
        String dbURL = properties.getProperty("jdbc.url");

        String catalog = properties.getProperty("jdbc.catalog");
        String schema = properties.getProperty("jdbc.schema");
        schema = schema == null ? "%" : schema;
        String column = "%";

        logger.debug("driver>>" + driverName);
        logger.debug("url>>" + dbURL);
        logger.debug("name>>" + userName);
        logger.debug("password>>" + userPwd);
        logger.debug("catalog>>" + catalog);
        logger.debug("schema>>" + schema);

        Class.forName(driverName);
        Connection conn = java.sql.DriverManager.getConnection(dbURL, userName, userPwd);
        DatabaseMetaData dmd = conn.getMetaData();

        ResultSet rs = dmd.getColumns(catalog, schema, tableName, column);
        List<Column> columns = new ArrayList<Column>();
        while (rs.next()) {
            Column c = new Column();

            c.setLabel(rs.getString("REMARKS"));

            String name = rs.getString("COLUMN_NAME");
            c.setName(CamelCaseUtils.toCamelCase(name));
            c.setDbName(name);

            String dbType = rs.getString("TYPE_NAME");
            String type = properties.getProperty(dbType);
            c.setDbType(dbType);
            c.setType(type == null ? "String" : type);

            c.setLength(rs.getInt("COLUMN_SIZE"));
            c.setDecimalDigits(rs.getInt("DECIMAL_DIGITS"));
            c.setNullable(rs.getBoolean("NULLABLE"));
            columns.add(c);
        }

        List<Column> pkColumns = new ArrayList<Column>();
        ResultSet pkrs = dmd.getPrimaryKeys(catalog, schema, tableName);
        while (pkrs.next()) {
            Column c = new Column();
            String name = pkrs.getString("COLUMN_NAME");
            c.setName(CamelCaseUtils.toCamelCase(name));
            c.setDbName(name);
            pkColumns.add(c);
        }

        conn.close();

        Table t = new Table();

        String prefiex = properties.getProperty("tableRemovePrefixes");
        String name = tableName;
        if (prefiex != null && !"".equals(prefiex)) {
            name = tableName.split(prefiex)[0];
        }
        t.setName(CamelCaseUtils.toCamelCase(name));
        t.setDbName(tableName);
        t.setColumns(columns);
        t.setPkColumns(pkColumns);
        return t;
    }

    /**
     * <p>Discription:[生成映射文件和实体类]</p>
     * Created on 2015年2月4日
     *
     * @param tableName 要声称映射文件和实体类的表名称
     * @param tableDesc 表描述
     * @throws Exception
     */
    public void gen(String tableName, String tableDesc) throws Exception {
        Configuration cfg = new Configuration();

        String outRoot = properties.getProperty("outRoot");
        String basepackage = properties.getProperty("basepackage");
        //获取当前日期
        SimpleDateFormat sm_date = new SimpleDateFormat("yyyy年MM月dd日");
        SimpleDateFormat sm_year = new SimpleDateFormat("yyyy年");

        Map<String, Object> root = new HashMap<String, Object>();
        Table t = parseTable(tableName);
        t.setTableDesc(tableDesc);
        root.put("table", t);
        root.put("className", t.getNameUpper());
        root.put("classNameLower", t.getName());
        root.put("package", basepackage);
        root.put("date", sm_date.format(new Date()));
        root.put("year", sm_year.format(new Date()));

        root.put("author", "majianwei");
        root.put("email", "majianwei@camelotchina.com");

        String templateDir = getClass().getClassLoader().getResource("templates").getPath();

        File tdf = new File(templateDir);
        List<File> files = FileHelper.findAllFile(tdf);

        for (File f : files) {
            String parentDir = "";
            if (f.getParentFile().compareTo(tdf) != 0) {
                parentDir = f.getParent().split("templates")[1];
            }
            cfg.setClassForTemplateLoading(getClass(), "/templates" + parentDir);

            Template template = cfg.getTemplate(f.getName());
            template.setEncoding("UTF-8");
            String parentFileDir = FileHelper.genFileDir(parentDir, root);
            parentFileDir = parentFileDir.replace(".", "/");
            String file = FileHelper.genFileDir(f.getName(), root).replace(".ftl", ".java");
            System.out.println(file);

            File newFile = FileHelper.makeFile(outRoot + parentFileDir + "/" + file);
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile), "UTF-8"));
            template.process(root, out);
            logger.debug("已生成文件：" + outRoot + parentFileDir + "/" + file);
        }
    }

    public static void main(String[] args) throws Exception {
        Generator g = new Generator();
        Map<String, String> map = new HashMap<>();

        map.put("common_request_log", "请求日志表");

        Iterator<Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, String> e = it.next();
            g.gen(e.getKey(), e.getValue());
        }
        System.out.println("模版文件生成完毕……");
    }
}
