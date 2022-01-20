package ${package}.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
* <p>Description: [${table.tableDesc}映射数据源实体类]</p>
* Created on ${date}
* @author  <a href="mailto: ${email}">${author}</a>
* @version 1.0
* Copyright (c) 2022 北京柯莱特科技有限公司 交付部
*/
@Data
@TableName("${table.dbName}")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class ${className}Dto implements Serializable {

private static final long serialVersionUID = 1L;

<#list table.columns as column>
    /**
    * ${column.label}
    */
    private ${column.type} ${column.name};
</#list>

}