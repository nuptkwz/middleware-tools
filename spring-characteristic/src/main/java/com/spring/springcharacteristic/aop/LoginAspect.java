package com.spring.springcharacteristic.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;

import java.lang.reflect.Method;

/**
 * Description
 * Date 2020/5/24 0:18
 * Created by kwz
 */
@Aspect
@Component
@Slf4j
public class LoginAspect {

    @Around("@annotation(com.spring.springcharacteristic.aop.LoginAnnotation)")
    public Object aroundOperateLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Signature signature = proceedingJoinPoint.getSignature();
        if (!(signature instanceof MethodSignature)) {
            return new Object();
        }
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();
        targetMethod.setAccessible(true);
        Object resVal = null;
        log.info("方法执行前，方法名:[{}]", targetMethod.getName());
        try {
            resVal = proceedingJoinPoint.proceed();
            log.info("方法执行成功，结果为:[{}]", resVal.toString());
        } catch (Throwable throwable) {
            log.error("方法执行失败", throwable.toString());
        }
        return resVal;
    }
}
