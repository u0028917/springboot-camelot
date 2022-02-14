package com.camelot.log.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>Description: [日志配置]</p>
 * Created on 2022/1/18
 *
 * @author <a href="mailto: majianwei@camelotchina.com">马建伟</a>
 * @version 1.0
 * Copyright (c) 2017 北京柯莱特科技有限公司 交付部
 */
@Getter
@Setter
@ConfigurationProperties(LogProperties.PREFIX)
public class LogProperties {
    /**
     * 前缀
     */
    public static final String PREFIX = "camelot.kafka";

    /**
     * 是否启用
     */
    private Boolean enable = false;

    /**
     * 记录日志类型
     */
    private LogType logType = LogType.DB;

}
