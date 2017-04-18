package com.yuer.util;

import java.util.HashMap;
import java.util.Map;

public class YuerTagUtils {

	public static Boolean getButton(String param){
		Map<String, Object> map = setButton();
		if(map.get(param) != null){
			return true;
		}
		return false;
	}
	
	
	public static Map<String, Object> setButton(){
		Map<String, Object> map = new HashMap<>();
		map.put("success_add_1", "111");
		map.put("success_add_2", "222");
		map.put("success_add_3", "333");
		
		map.put("success_update_1", "111");
		map.put("success_update_3", "333");
		
		map.put("success_delete_1", "111");
		
		return map;
	}
	
	
}
