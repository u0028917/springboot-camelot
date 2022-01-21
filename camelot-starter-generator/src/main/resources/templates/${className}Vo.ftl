package ${package}.dto;

import lombok.Data;

import java.io.Serializable;

/**
* <p>Description: [${table.tableDesc}映射数据源实体类]</p>
* Created on ${date}
* @author  <a href="mailto: ${email}">${author}</a>
* @version 1.0
* Copyright (c) 2022 北京柯莱特科技有限公司 交付部
*/
@Data
public class ${className}Dto implements Serializable {

private static final long serialVersionUID = 1L;

<#list table.columns as column>
    /**
    * ${column.label}
    */
    private ${column.type} ${column.name};
</#list>

}