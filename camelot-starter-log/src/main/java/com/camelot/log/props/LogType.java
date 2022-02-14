package com.camelot.log.props;

/**
 * <p>Description: [记录日志类型]</p>
 * Created on 2022/1/18
 *
 * @author <a href="mailto: majianwei@camelotchina.com">马建伟</a>
 * @version 1.0
 * Copyright (c) 2017 北京柯莱特科技有限公司 交付部
 */
public enum LogType {

    /**
     * 记录日志到本地
     */
    LOGGER,
    /**
     * 记录日志到数据库
     */
    DB,
    /**
     * 记录日志到KAFKA
     */
    KAFKA,
    ;

}
