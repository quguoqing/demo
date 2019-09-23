package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author: chunmu
 * @Date: 2019/9/20 19:33
 * @Description:
 */
@Aspect
@Component
public class AspectDemo {

    @Around("execution(* com.example.demo.aop..*(..))")
    public Object addLog(ProceedingJoinPoint jp) throws Throwable{
        System.out.println("切面开始");
        Object result = jp.proceed();
        System.out.println("切面结束");
        return result;
    }
}
