package com.king.controller;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

@Aspect
@Component
public class MyAspect {

    // .. 不能缺少，否则带参方法不进入切面
    @Pointcut(value = "execution(* com.king.service.FundServiceImpl.*(..))")
    private void anyMethod(){}//定义一个切入点

    @Before("anyMethod()")
    public void doAccessCheck(){
        System.out.println("前置通知");
    }
    @AfterReturning("anyMethod()")
    public void doAfter(){
    System.out.println("后置通知");
    }
    @After("anyMethod()")
    public void after(){
    System.out.println("最终通知");
    }
    //异常通知
    @AfterThrowing("anyMethod()")
    public void afterThrowing() {
        System.out.println("异常通知");
    }
    @Around("anyMethod()")
    public Object doBaiscProfiling(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("进入环绕通知");
        Object object = pjp.proceed();
        String method = pjp.getSignature().getDeclaringTypeName()+"#"+pjp.getSignature().getName();
        System.out.println("method = " + method);
        // 获取方法参数
        //获取参数的值
        Object[] nameAndArgs = pjp.getArgs();
        for (Object obj : nameAndArgs){
            System.out.println("value = " + obj.toString());
        }
        System.out.println("退出方法");
        return object;
    }
}
