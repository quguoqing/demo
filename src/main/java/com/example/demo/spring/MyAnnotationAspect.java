package com.example.demo.spring;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author: chunmu
 * @Date: 2020/6/9 14:26
 * @Description:
 */
@Aspect
@Component
public class MyAnnotationAspect {

    @Pointcut("@annotation(com.example.demo.spring.MyAnnotation)")
    public void myAnnotationPointCut(){};


    @Around("myAnnotationPointCut()")
    public void myAnnotationAround(ProceedingJoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
        if(null == annotation){
            //获取类上注解
            annotation = joinPoint.getTarget().getClass().getAnnotation(MyAnnotation.class);
            if(null == annotation){
                //获取接口上注解
                Class<?>[] inerfaces = joinPoint.getTarget().getClass().getInterfaces();
                for(Class<?> cls : inerfaces){
                    annotation = cls.getAnnotation(MyAnnotation.class);
                    if(null != annotation){
                        //多个接口都配置了MyAnnotation注解，任意取一个
                        break;
                    }
                }
            }
        }
        if(null != annotation){
            String value = annotation.value();
            int age = annotation.age();
            //TODO 业务操作
        }

        //执行真正方法
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        //切面结束

    }

}
