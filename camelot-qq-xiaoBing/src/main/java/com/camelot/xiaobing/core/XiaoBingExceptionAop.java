package com.camelot.xiaobing.core;

import com.camelot.xiaobing.props.XiaoBingProperties;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
public class XiaoBingExceptionAop {

    @Autowired
    private final ApplicationContext applicationContext;

    public XiaoBingExceptionAop(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @After("@annotation(org.springframework.web.bind.annotation.ExceptionHandler)")
    public void before(JoinPoint point) {
        Object[] args = point.getArgs();
        RuntimeException runtimeException = (RuntimeException) args[0];
        try {
            applicationContext.publishEvent(new XiaoBingEvent(runtimeException));
//            XiaoBingSendMsg.getInstance().sendError(xiaoBingProperties.getInstance(), runtimeException);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
    }
}
