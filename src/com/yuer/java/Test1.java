package com.yuer.java;

public class Test1 {
	
	public static void main(String[] args) {
//		int num = 16;
//		String str = Integer.toBinaryString(num);
//		System.out.println(str);
		
		String str = "中";
		byte[] bs = str.getBytes();
		for(int i=0;i<bs.length;i++){
			System.out.print(Integer.toBinaryString(bs[i]&0xff));
		}
		
		
	}
	
	
}
