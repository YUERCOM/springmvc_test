package com.yuer.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yuer.spring.annotation.ServiceLog;
@Service
public class IndexService{

	@ServiceLog(abc = "ddddddddddd")
	public List<String> getNames() {
		List<String> list = new ArrayList<>();
		list.add("zhangsan");
		list.add("lisi");
		System.out.println("00000000000000000000000000");
		return list;
	}

}
