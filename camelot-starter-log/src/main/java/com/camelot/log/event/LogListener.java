package com.camelot.log.event;

import com.camelot.atom.dto.CommonRequestLogDto;
import com.camelot.atom.service.CommonRequestLogAtomService;
import com.camelot.log.props.LogProperties;
import com.camelot.log.props.LogType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

/**
 * <p>Description: [注解形式，异步监听事件]</p>
 * Created on 2022/1/18
 *
 * @author <a href="mailto: majianwei@camelotchina.com">马建伟</a>
 * @version 1.0
 * Copyright (c) 2017 北京柯莱特科技有限公司 交付部
 */
@Slf4j
public class LogListener {

    @Autowired
    private CommonRequestLogAtomService commonRequestLogAtomService;
    private LogProperties logProperties;
    public LogListener(){

    }
    public LogListener(LogProperties logProperties) {
        this.logProperties = logProperties;
    }

    @Async
    @Order
    @EventListener(LogEvent.class)
    public void saveSysLog(LogEvent event) {
        CommonRequestLogDto commonLog = (CommonRequestLogDto) event.getSource();
        // 发送日志到kafka
        log.info("发送日志:{}", commonLog);
        if (logProperties.getLogType().equals(LogType.KAFKA)) {
        } else {
            commonRequestLogAtomService.save(commonLog);
        }
    }

}
