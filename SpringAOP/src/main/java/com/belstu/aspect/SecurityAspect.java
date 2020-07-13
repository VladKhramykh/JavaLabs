package com.belstu.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution( public * com.belstu.controller.MainController.*(..))")
    public void mainControllerMethod(){
    }

    @Around("mainControllerMethod()")
    public Object aroundMainContrMethod(ProceedingJoinPoint pjp) throws Throwable {
        return pjp.proceed();
    }
}
