package com.sky.aspect;

import com.sky.annotation.AutoFill;
import com.sky.context.BaseContext;
import com.sky.enumeration.OperationType;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.nio.file.OpenOption;
import java.time.LocalDateTime;

/*
* 自定义切面 实现公共字段自动填充
* */
@Aspect
@Component
@Slf4j
public class AutoFillAspect {
    /*切入点*/
    @Pointcut("execution(* com.sky.mapper.*.*(..)) && @annotation(com.sky.annotation.AutoFill)")
    public void autoFillPointCut(){

    }

    @Before("autoFillPointCut()")
    public void autoFillBefore(JoinPoint joinPoint){

        log.info("自动填充切入点");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        AutoFill autoFill = signature.getMethod().getAnnotation(AutoFill.class);
        OperationType operationType = autoFill.value();

        Object[] args = joinPoint.getArgs();
        if(args.length == 0 || args == null){
                return;
        }

        Object arg = args[0];
        LocalDateTime now = LocalDateTime.now();
        Long currentId = BaseContext.getCurrentId();
        if(operationType == OperationType.INSERT){
            try{
                arg.getClass().getDeclaredMethod("setCreateTime", LocalDateTime.class).invoke(arg, now);
                arg.getClass().getDeclaredMethod("setCreateUser", Long.class).invoke(arg, currentId);
                arg.getClass().getDeclaredMethod("setUpdateTime", LocalDateTime.class).invoke(arg, now);
                arg.getClass().getDeclaredMethod("setUpdateUser", Long.class).invoke(arg, currentId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else if(operationType == OperationType.UPDATE){
            try{
                arg.getClass().getDeclaredMethod("setUpdateTime", LocalDateTime.class).invoke(arg, now);
                arg.getClass().getDeclaredMethod("setUpdateUser", Long.class).invoke(arg, currentId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
