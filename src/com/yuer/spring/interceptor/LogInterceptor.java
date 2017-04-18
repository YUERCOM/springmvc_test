package com.yuer.spring.interceptor;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yuer.test.model.LogModel;

public class LogInterceptor extends HandlerInterceptorAdapter {
	
	private static final ThreadLocal<LogModel> thread = new ThreadLocal<>();
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
		LogModel logModel = new LogModel();
		Long beginTime = System.currentTimeMillis();
		Map<String, String> map = new HashMap<>();
		Enumeration<String> keys = request.getParameterNames();
		while(keys.hasMoreElements()){
			String key = keys.nextElement();
			String value = request.getParameter(key);
			map.put(key, value);
			System.out.println(key + "====" + value);
		}
		logModel.setBeginTime(beginTime);
		logModel.setRequestParam(map.toString());
		logModel.setRequestUrl(request.getRequestURI());
		thread.set(logModel);
		return true;
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o,  
            ModelAndView mav) throws Exception {
		System.out.println("============================ postHandle");
		if(mav != null){
			LogModel logModel = thread.get();
			logModel.setResponseValue(mav.getModel().toString());
			System.out.println(mav.getModel().toString());
		}
		System.out.println("============================");
	}
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
			Object handler, Exception ex) throws Exception {
		LogModel logModel = thread.get();
		Long endTime = System.currentTimeMillis();
		logModel.setEndTime(endTime);
		logModel.setInterval(endTime - logModel.getBeginTime());
		System.out.println(logModel.toString());
	}
	
	
	
}
