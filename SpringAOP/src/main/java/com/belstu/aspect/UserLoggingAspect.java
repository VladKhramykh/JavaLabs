package com.belstu.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class UserLoggingAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution( public * com.belstu.service.UserService.loadUserByUsername(..))")
    public void loadDataAboutUser(){
        logger.info("before loadInfoAboutUser exec");
    }

    @Before("loadDataAboutUser()")
    public void beforeLoad(JoinPoint joinPoint) {
        String args = Arrays.stream(joinPoint.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));
        logger.info("\tbefore {} args = [{}]", joinPoint.toString(), args);
    }

    @After("loadDataAboutUser()")
    public void afterLoad(JoinPoint jp){
        logger.info("\tafter " + jp.toString());
    }

    @AfterThrowing(pointcut = "loadDataAboutUser()", throwing = "exception")
    public void afterThrowingFromEndpoint(JoinPoint joinPoint, Throwable exception) {
        logger.error("{} thrown exception {}", joinPoint.toString(), exception.getMessage());
    }
}
