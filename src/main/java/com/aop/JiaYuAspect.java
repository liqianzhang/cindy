package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @MethodName: $
 * @Description: TODO
 * @Param: $
 * @Return: $
 * @Author: zhangliqian
 * @Date: $
 */
@Aspect
@Component
public class JiaYuAspect {
    @Pointcut("execution(* com.jiayu.*.*(..))")
    public void yuPointCut() {
    }

    @Around("yuPointCut()")
    public void doAround() {
        System.out.println("AopTest");

    }
}
