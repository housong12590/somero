package com.somero.deploy.component;


import com.somero.deploy.utils.JSON;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Order(1)
public class WebLogAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    private ThreadLocal<Long> startTime = new ThreadLocal<>();


    //申明一个切点 里面是 execution表达式
    @Pointcut("execution(public * com.somero.deploy.controller.*.*(..))")
    private void webLog() {
    }


    //请求method前打印内容
    @Before(value = "webLog()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //打印请求内容
        logger.info("===============请求内容===============");
        logger.info("请求地址: " + request.getRequestURL().toString());
        logger.info("请求方式: " + request.getMethod());
        logger.info("请求类方法: " + joinPoint.getSignature());
        logger.info("请求类方法参数: " + Arrays.toString(joinPoint.getArgs()));
    }


    //在方法执行完结后打印返回内容
    @AfterReturning(returning = "o", pointcut = "webLog()")
    public void doAfterReturning(Object o) {
        logger.info("Response: " + JSON.toJsonString(o));
        logger.info("处理时间: " + (System.currentTimeMillis() - startTime.get()) + "ms");
    }

}
