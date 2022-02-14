package com.camelot.log.event;

import com.camelot.atom.dto.CommonRequestLogDto;
import org.springframework.context.ApplicationEvent;

/**
 * <p>Description: [日志事件]</p>
 * Created on 2022/1/18
 *
 * @author <a href="mailto: majianwei@camelotchina.com">马建伟</a>
 * @version 1.0
 * Copyright (c) 2017 北京柯莱特科技有限公司 交付部
 */
public class LogEvent extends ApplicationEvent {

    public LogEvent(CommonRequestLogDto source) {
        super(source);
    }
}
