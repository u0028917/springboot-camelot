package com.camelot.common.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: [ ]</p>
 * Created on 2022/1/10
 *
 * @author <a href="mailto:sunshaobo@camelotchina.com">孙少波</a>
 * @version 1.0
 */
@Component
@Aspect
@Slf4j
public class RequestParameterAop {

    /**
     * @Description: 定义需要拦截的切面
     * @Return: void
     **/
    @Pointcut("execution(* com.camelot.accrual.controller.*.*.*(..))")
    public void methodArgs() {
    }

    @Before("methodArgs()")
    public void invoke(JoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        // 方法名
        String methodName = signature.getName();
        // 类名
        String serviceName = signature.getDeclaringTypeName();
        MethodSignature methodSignature = (MethodSignature) signature;
        // 参数名数组
        String[] parameterNames = methodSignature.getParameterNames();
        // 构造参数组集合
        List<Object> argList = new ArrayList<>();
        for (Object arg : joinPoint.getArgs()) {
            if (arg == null){
                continue;
            }
            // request/response无法使用toJSON
            if (arg instanceof HttpServletRequest) {
                argList.add("request");
            } else if (arg instanceof HttpServletResponse) {
                argList.add("response");
            } else if (arg instanceof MultipartFile) {
                argList.add("file");
            } else {
                log.info("参数类型 {}", arg.getClass().getName());
                argList.add(JSON.toJSON(arg));
            }
        }
        try {
            log.info("{} -> 方法({}) \n -> 参数:{} - {}", serviceName, methodName, JSON.toJSON(parameterNames), JSON.toJSON(argList));
        } catch (Exception e) {
            log.error("参数获取失败: {}", e.getMessage());
        }
    }
}
