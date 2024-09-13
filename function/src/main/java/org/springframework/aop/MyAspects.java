package org.springframework.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspects {

    @Pointcut("execution(public Integer org.springframework.aop.MathService.*(..))")
    public void pointCut() {

    }

//    @Before("pointCut()")
//    public void logBefore(ProceedingJoinPoint point) {
//        Object[] args = point.getArgs();
//        for (Object arg : args) {
//            System.out.println(arg);
//        }
//        System.out.println("前置通知");
//    }
//
//    @After("pointCut()")
//    public void logAfter(ProceedingJoinPoint point) {
//        System.out.println("后置通知");
//    }
//
//    @AfterThrowing("pointCut()")
//    public void logAfterThrowing(ProceedingJoinPoint point) {
//        System.out.println("异常通知");
//    }

//    @AfterReturning("pointCut()")
//    public void logAfterReturn(ProceedingJoinPoint point) {
//        System.out.println("返回通知");
//    }


    @Around("pointCut()")
    public void logAfterReturn(ProceedingJoinPoint point) {
        Object[] args = point.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
        }
        System.out.println("around通知");
    }

}
