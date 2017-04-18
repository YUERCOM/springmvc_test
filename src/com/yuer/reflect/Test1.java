package com.yuer.reflect;

import java.lang.reflect.Method;

public class Test1 {
	
	public static void main(String[] args) {
		
		try {
			
			Class<?> class1 = Class.forName("com.yuer.test.controller.IndexController");
			Method[] methods = class1.getDeclaredMethods();
			for(int i=0;i<methods.length;i++){
				System.out.println(methods[i].toString());
			}
			System.out.println("====================================");
			Method[] methods1 = class1.getMethods();
			for(int i=0;i<methods1.length;i++){
				System.out.println(methods1[i].toString());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
