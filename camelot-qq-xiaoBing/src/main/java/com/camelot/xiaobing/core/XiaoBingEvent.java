package com.camelot.xiaobing.core;

import org.springframework.context.ApplicationEvent;

public class XiaoBingEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public XiaoBingEvent(RuntimeException source) {
        super(source);
    }
}
