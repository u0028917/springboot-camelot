package com.camelot.atom.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
* <p>Description: [请求日志表映射数据源实体类]</p>
* Created on 2022年01月21日
* @author  <a href="mailto: majianwei@camelotchina.com">majianwei</a>
* @version 1.0
* Copyright (c) 2022 北京柯莱特科技有限公司 交付部
*/
@Data
@TableName("common_request_log")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class CommonRequestLogDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * 主键
    */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
    * 日志类型
    */
    private String type;
    /**
    * 跟踪ID
    */
    private String traceid;
    /**
    * 日志标题
    */
    private String title;
    /**
    * 
    */
    private String operation;
    /**
    * 执行方法
    */
    private String method;
    /**
    * 请求路径
    */
    private String url;
    /**
    * 参数
    */
    private String params;
    /**
    * ip地址
    */
    private String ip;
    /**
    * 耗时
    */
    private Long executeTime;
    /**
    * 地区
    */
    private String location;
    /**
    * 创建人
    */
    private String createBy;
    /**
    * 创建时间
    */
    private java.util.Date createTime;
    /**
    * 异常信息
    */
    private String exception;

}