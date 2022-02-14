package com.camelot.log.config;

import com.camelot.log.aspect.LogAspect;
import com.camelot.log.event.LogListener;
import com.camelot.log.props.LogProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * <p>Description: [日志配置中心]</p>
 * Created on 2022/1/18
 *
 * @author <a href="mailto: majianwei@camelotchina.com">马建伟</a>
 * @version 1.0
 * Copyright (c) 2017 北京柯莱特科技有限公司 交付部
 */
@EnableAsync
@Configuration
@RequiredArgsConstructor
@ConditionalOnWebApplication
@EnableConfigurationProperties(value = LogProperties.class)
public class LogConfiguration {

    private final LogProperties logProperties;

    @Bean
    public LogListener sysLogListener() {

        return new LogListener(logProperties);

    }

    @Bean
    public LogAspect logAspect(ApplicationContext applicationContext){
        return new LogAspect(applicationContext);
    }
}
