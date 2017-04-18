package com.yuer.spring.annotation.aspect;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JavaType;
import com.yuer.spring.annotation.Log;

import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

@Aspect
@Component
public class LogAspect {
	
	ThreadLocal<Long> time = new ThreadLocal<Long>();
	
	@Pointcut("@annotation(com.yuer.spring.annotation.Log)")
	public void log(){
		System.out.println("================================");
		System.out.println("我是一个切入点");
	}
	
//	@Before("log()")
	public void beforeExec(JoinPoint point){
		System.out.println("================================");
		System.out.println("beforeExec");
	}
	
	@Around("log()")
	public Object aroundExec(ProceedingJoinPoint point) throws Throwable{
		System.out.println("================================");
		System.out.println("aroundExec");
//		getJavaType(point);
		MethodSignature ms = (MethodSignature) point.getSignature();
		Method method = ms.getMethod();
		System.out.println(method.getAnnotation(Log.class).name());
		return point.proceed();
	}
	
//	@After("log()")
	public void afterExec(JoinPoint point){
		System.out.println("================================");
		System.out.println("afterExec");
	}
	
//	public JavaType getJavaType(ProceedingJoinPoint point){
//		MethodSignature ms = (MethodSignature) point.getSignature();
//		Method method = ms.getMethod();
//		Class returnType = method.getReturnType();
//		String returnTypeName = returnType.getName();
//		System.out.println(returnTypeName);
//		
//		if(returnTypeName.startsWith("java.util.List")){
//			Type type = method.getGenericReturnType();
//			if(type instanceof ParameterizedTypeImpl){
//				try {
//					ParameterizedTypeImpl pti = (ParameterizedTypeImpl) type;
//					String listName = pti.getRawType().getName();
//                    Type[] argsType = pti.getActualTypeArguments();
//                    String beanName = argsType[0].getTypeName();
//                    Class listType = Class.forName(listName);
//                    Class beanType = Class.forName(beanName);
//                    
//                    System.out.println(listName);
//                    System.out.println(beanName);
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//			}
//		}
//		
//		return null;
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
