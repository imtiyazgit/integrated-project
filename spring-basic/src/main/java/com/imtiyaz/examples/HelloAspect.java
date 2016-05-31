package com.imtiyaz.examples;
/*

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class HelloAspect {

    public HelloAspect() {
        System.out.println("Test");
    }

    @Around("execution(* com.imtiyaz.examples.HelloService.*(..))")
    public void aroundExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around before is running!" + joinPoint.getSignature().getName());
        joinPoint.proceed(); //continue on the intercepted method
        System.out.println("Around after completed");
    }

}
*/

public class HelloAspect {}