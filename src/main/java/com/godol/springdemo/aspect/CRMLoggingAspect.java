package com.godol.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    // 로거 설치하기
    private Logger myLogger = Logger.getLogger(getClass().getName());
    // pointCut 선언하기
    @Pointcut("execution(* com.godol.springdemo.controller.*.*(..))")
    private void forControllerPackage(){}

    // dao 에 같은 서비스 추가하기
    @Pointcut("execution(* com.godol.springdemo.service.*.*(..))")
    private void forServicePackage(){}
    @Pointcut("execution(* com.godol.springdemo.dao.*.*(..))")
    private void forDAOPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() ||forDAOPackage()")
    private void forAppFlow(){}

    // @Before 추가
    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){

        // 메서드 불리는 걸 보여주기
        String theMethod = theJoinPoint.getSignature().toLongString();
        myLogger.info("========>  @Before : 메서드 불러오는 중  : " + theMethod);
        // arguments 를 보여주기
        Object[] args = theJoinPoint.getArgs();

        for (Object tempArg: args){
            myLogger.info("========> argument: " + tempArg);

        }
    }

    // @AfterReturning 추가
    @AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
    public void afterReturning(JoinPoint theJoinPoint, Object theResult){
        // 반환 메서드 보여주기
        String theMethod = theJoinPoint.getSignature().toLongString();
        myLogger.info("========>  @AfterReturning : 메서드 불러오는 중  : " + theMethod);
        //  반환 값 보여주기
        myLogger.info("========> result : " + theResult);
    }
}
