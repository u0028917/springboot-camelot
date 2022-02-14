package com.camelot.log.config;

import org.slf4j.TransmitLocalMDCAdapter;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * <p>Description: [初始化TransmitLocalMDCAdapter，并替换MDC中的adapter对象]</p>
 * Created on 2022/1/18
 *
 * @author <a href="mailto: majianwei@camelotchina.com">马建伟</a>
 * @version 1.0
 * Copyright (c) 2017 北京柯莱特科技有限公司 交付部
 */
public class TransmitLocalMDCInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        //加载TtlMDCAdapter实例
        TransmitLocalMDCAdapter.getInstance();
    }
}
