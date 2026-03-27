package com.example.core.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Around("execution(* com.example.core.aop.AopTargetService.*(..))")
    public Object log(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("  [AOP] Before: " + jp.getSignature().getName());
        Object result = jp.proceed();
        System.out.println("  [AOP] After: " + jp.getSignature().getName());
        return result;
    }
}
