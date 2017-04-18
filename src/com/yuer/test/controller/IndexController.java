package com.yuer.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuer.spring.annotation.Log;
import com.yuer.spring.annotation.ServiceLog;
import com.yuer.test.model.Model1;
import com.yuer.test.model.UserModel;
import com.yuer.test.service.impl.IndexService;
import com.yuer.util.CoreUtils;

@Controller
@RequestMapping(value = "/index")
public class IndexController {
	
	@Autowired
	private IndexService indexService;
	
//	@ServiceLog(abc = "aaaaaaaaaaa")
	@RequestMapping(value = "/index1/{id}",method = RequestMethod.GET)
	public String index1(@PathVariable(value = "id")Integer id,Model model){
		indexService.getNames();
		System.out.println("====================");
		System.out.println("id : " + id);
		System.out.println(CoreUtils.getProperty("core.email.linlei"));
		System.out.println(CoreUtils.getProperty("abc.email.linlei"));
		model.addAttribute("aaaaa", "bbbbb");
		return "success";
	}
	
	@Log()
	@RequestMapping(value = "/index2/{id}",method = RequestMethod.GET)
	public String index2(@PathVariable(value = "id")Integer id,
			@MatrixVariable(value = "a",pathVar = "id")Integer a,
			@MatrixVariable(value = "b",pathVar = "id")Integer b,Model model){
		System.out.println("======================");
		System.out.println("id : " + id);
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		model.addAttribute("aaaaa", "bbbbb");
		return "success";
	}
	@RequestMapping(value = "/index3/{id1}/index3/{id2}",method = RequestMethod.GET)
	public String index3(
			@PathVariable(value = "id1")Integer id1,
			@PathVariable(value = "id2")Integer id2,
			@MatrixVariable(value = "a",pathVar = "id1")Integer a1,
			@MatrixVariable(value = "a",pathVar = "id2")Integer a2,Model model){
		System.out.println("======================");
		System.out.println("id1 : " + id1);
		System.out.println("id2 : " + id2);
		System.out.println("a1 : " + a1);
		System.out.println("a2 : " + a2);
		model.addAttribute("aaaaa", "bbbbb");
		return "success";
	}
	
	@RequestMapping(value = "/index4/{id1}/index3/{id2}",method = RequestMethod.GET)
	public String index4(
			@PathVariable(value = "id1")Integer id1,
			@PathVariable(value = "id2")Integer id2,
			@MatrixVariable Map<String, String> matrixVars,
			@MatrixVariable(pathVar = "id2") Map<String, String> matrixVar,Model model){
		System.out.println("======================");
		System.out.println("id1 : " + id1);
		System.out.println("id2 : " + id2);
		System.out.println("matrixVars : " + matrixVars.toString());
		System.out.println("matrixVar : " + matrixVar.toString());
		model.addAttribute("aaaaa", "bbbbb");
		return "success";
	}
	
	@RequestMapping(value = "/index5",method = RequestMethod.GET)
	public String index5(Integer a,Integer b,Model model){
		System.out.println("======================");
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		model.addAttribute("aaaaa", "bbbbb");
		return "success";
	}
	
	@RequestMapping(value = "/index6",method = RequestMethod.GET)
	public String index6(Model1 model1,Model model){
		System.out.println("======================");
		System.out.println("a : " + model1.getA());
		System.out.println("b : " + model1.getB());
		model1.setA(111);
		model.addAttribute("aaaaa", "bbbbb");
		return "success";
	}
	
	@RequestMapping(value = "/index7",method = RequestMethod.GET)
	public String index7(@CookieValue("JSESSIONID") String cookie,Model model){
		System.out.println("=======================");
		System.out.println("cookie : " + cookie);
		model.addAttribute("aaaaa", "bbbbb");
		return "success";
	}
	
	@RequestMapping(value = "/index8",method = RequestMethod.GET)
	public String index8(
			@RequestHeader("Host")String host,
			@RequestHeader("Accept")String accept,
			@RequestHeader("Accept-Language")String acceptLanguage,
			@RequestHeader("Accept-Encoding")String acceptEncoding,
			@RequestHeader("User-Agent")String userAgent,Model model){
		System.out.println("=======================");
		System.out.println("host : " + host);
		System.out.println("accept : " + accept);
		System.out.println("acceptLanguage : " + acceptLanguage);
		System.out.println("acceptEncoding : " + acceptEncoding);
		System.out.println("userAgent : " + userAgent);
		model.addAttribute("aaaaa", "bbbbb");
		return "success";
	}
	
	@RequestMapping(value = "/index9",method = RequestMethod.GET)
	public String index9(Model model){
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
		model.addAttribute("userList", list);
		return "success";
	}
	
	@RequestMapping(value = "/index10/{id}",method = RequestMethod.GET)
	public @ResponseBody String index10(@PathVariable(value = "id")Integer id) throws JsonProcessingException{
		Map<String, String> map = new HashMap<>();
		map.put("status", "success");
		map.put("a", "aaa");
		map.put("b", "bbb");
		ObjectMapper mapper = new ObjectMapper();
		
		return mapper.writeValueAsString(map);
	}
	
	
}
