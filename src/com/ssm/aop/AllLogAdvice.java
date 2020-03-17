package com.ssm.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//申明切面类
@Aspect

//在spring中注册bean容器
@Component

public class AllLogAdvice {

    //定义切入点表达式,匹配UserDaoImpl下的所有方法
    @Pointcut("execution( * com.ssm.dao.impl.UserDaoImpl.*(..))")

    //定义一个空方法定义切入点
    public void allMethod(){}

    //编写前置通知方法
    @Before("allMethod()")
    public void beforeAdvice(JoinPoint joinPoint){

        //获取目标参数
        List<Object> args = Arrays.asList(joinPoint.getArgs());

        //获取目标方法名
        String targetMethodName = joinPoint.getSignature().getName();

        //日志格式化输出
        String txt = "前置通知:\n"
                + "用户在" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
                + " 开始执行 " + targetMethodName + " 方法。";
        System.out.println(txt + "\n");

    }

    //编写返回通知方法
    @After("allMethod()")
    public void returnAdvice(JoinPoint joinPoint){

        //获取目标参数
        List<Object> args = Arrays.asList(joinPoint.getArgs());

        //获取目标方法名
        String targetMethodName = joinPoint.getSignature().getName();

        //日志格式化输出
        String txt = "返回通知:\n"
                + "用户在" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
                + " 执行完成 " + targetMethodName + " 方法。";
        System.out.println(txt + "\n");

    }

    //编写异常通知方法
    @AfterThrowing(value = "allMethod()", throwing = "e")
    public void throwAdvice(JoinPoint joinPoint, Exception e){

        //获取目标参数
        List<Object> args = Arrays.asList(joinPoint.getArgs());

        //获取目标类名
        String targetClassName = joinPoint.getTarget().getClass().getName();

        //获取目标方法名
        String targetMethodName = joinPoint.getSignature().getName();

        //日志格式化输出
        String txt = "异常通知:\n"
                + "调用 " + targetClassName
                + " 类的" + targetMethodName
                + " 方法时发生异常";
        System.out.println(txt + "\n");


    }

    //编写环绕通知方法
    @Around("allMethod()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        Object res = null;

        long beginTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();

        res = proceedingJoinPoint.proceed();

        String targetClassName = proceedingJoinPoint.getTarget().getClass().getName();
        String targetMethodName = proceedingJoinPoint.getSignature().getName();

        String txt = "环绕通知:\n"
                + "调用 " + targetClassName
                + " 的 " + targetMethodName
                + " 方法\n"
                + "开始时间: " + beginTime + "\n"
                + "完成时间: " + endTime;
        System.out.println(txt + "\n");
        return res;

    }

}
