package com.yuer.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TestInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
		System.out.println("*************Test****************");
		System.out.println(request.getRequestURI());
		System.out.println("**********************************");
		return true;
	}
	
}
