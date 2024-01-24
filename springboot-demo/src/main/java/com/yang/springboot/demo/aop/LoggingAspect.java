package com.yang.springboot.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.yang.springboot.demo.aop.KkCustomsService.saveKkCustoms(..))")
    public void logBeforeMethodExecution(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();

        // 获取调用方的类名和方法名
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        String callerClassName = method.getDeclaringClass().getName();
        String callerMethodName = method.getName();

        System.out.println("Executing method " + methodName + " in class " + className);
        System.out.println("Called by method " + callerMethodName + " in class " + callerClassName);
    }
}
