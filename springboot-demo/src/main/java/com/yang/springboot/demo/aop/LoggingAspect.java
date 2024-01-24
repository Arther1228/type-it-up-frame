package com.yang.springboot.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.yang.springboot.demo.aop.KkCustomsService.saveKkCustoms(..)) && args(model, method)")
    public void logBeforeMethodExecution(JoinPoint joinPoint, String model, String method) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();

        System.out.println("Executing method " + methodName + " in class " + className);
        System.out.println("Method parameters: model=" + model + ", method=" + method);
    }
}
