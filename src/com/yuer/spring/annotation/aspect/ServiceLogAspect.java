package com.yuer.spring.annotation.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.yuer.spring.annotation.ServiceLog;

@Aspect
@Component
public class ServiceLogAspect {

	@Pointcut("@annotation(com.yuer.spring.annotation.ServiceLog)")
	public void serviceLog(){
		System.out.println("================================");
		System.out.println("我是一个切入点");
	}
	
	@Around("serviceLog()")
	public Object aroundExec(ProceedingJoinPoint point) throws Throwable{
		System.out.println("================================");
		System.out.println("aroundExec");
		MethodSignature ms = (MethodSignature) point.getSignature();
		Method method = ms.getMethod();
		System.out.println(method.getAnnotation(ServiceLog.class).abc());
		return point.proceed();
	}
	
	
}
