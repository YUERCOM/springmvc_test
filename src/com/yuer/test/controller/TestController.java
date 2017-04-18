package com.yuer.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yuer.test.model.UserModel;

@Controller
@RequestMapping(value = "/test")
public class TestController {

	@RequestMapping(value = "/test1",method = RequestMethod.GET)
	public String test1(Model model){
		System.out.println("test1");
		model.addAttribute("aaaaa", "bbbbb");
		return "success";
	}
	
	@RequestMapping(value = "/test2",method = RequestMethod.GET)
	public String test2(ModelMap model){
		model.addAttribute("userList", getUserModelList());
		return "userExcel";
	}
	
	@RequestMapping(value = "/user",method = RequestMethod.GET)
	public String user1(Integer userId){
		return "success";
	}
	
	private List<UserModel> getUserModelList(){
		List<UserModel> list = new ArrayList<>();
		{
			UserModel um = new UserModel();
			um.setId(1);
			um.setName("张三");
			um.setEmail("zhangsan@163.com");
			list.add(um);
		}
		{
			UserModel um = new UserModel();
			um.setId(1);
			um.setName("张三");
			um.setEmail("zhangsan@163.com");
			list.add(um);
		}
		{
			UserModel um = new UserModel();
			um.setId(1);
			um.setName("张三");
			um.setEmail("zhangsan@163.com");
			list.add(um);
		}
		{
			UserModel um = new UserModel();
			um.setId(1);
			um.setName("张三");
			um.setEmail("zhangsan@163.com");
			list.add(um);
		}
		return list;
	}
	
}
