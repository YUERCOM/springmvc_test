<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="yuertag" uri="/tlds/yuertag" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>springMVC</title>
</head>
<script type="text/javascript" src="${staticRoot}/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	function ajaxA1(){
		$.ajax({
			type: "GET",
			url:"/springmvc/index/index10/10",
			dataType:"json",
			success: function (data) {
	            if(data.status == "success"){
	            	alert("操作成功");
	            }else{
	            	alert("操作失败");
	            }
	        }
		});
	}
</script>
<body>
	矩阵变量演示<br>
	1、<a href="/springmvc/index/index1/1;a=2">index1/1</a><br>
	2、<a href="/springmvc/index/index2/1;a=2;b=3">index2/1;a=2;b=3</a><br>
	3、<a href="/springmvc/index/index3/1;a=11/index3/2;a=22">index3/1;a=11/index3/2;a=22</a><br>
	4、<a href="/springmvc/index/index4/1;a=1;b=2/index3/2;a=11;b=22">index4/1;a=1;b=2/index3/2;a=11;b=22</a><br>
	普通参数演示<br>
	5、<a href="/springmvc/index/index5?a=1&b=2">index5?a=1&b=2</a><br>
	6、<a href="/springmvc/index/index6?a=11&b=22">index6?a=11&b=22</a><br>
	7、<a href="/springmvc/index/index7">cookie</a><br>
	8、<a href="/springmvc/index/index8">header</a><br>
	拦截器<br>
	9、<a href="/springmvc/test/test1">被TestInterceptor拦截</a><br>
	Ajax<br>
	10、<a href="javascript:void(0)" onclick="ajaxA1()">ajaxA1</a><br>
	Excel<br>
	11、<a href="/springmvc/test/test2">Excel导出</a><br>
	12、<a href="/springmvc/index/index9">使用同一URL获取不同形式的返回内容 </a><br>
	13、<a href="/springmvc/index/index9?content=json">使用同一URL获取不同形式的返回内容 json</a><br>
	14、<a href="/springmvc/index/index9?content=xml">使用同一URL获取不同形式的返回内容xml</a><br>
	自定义标签<br>
	15、<a href="/springmvc/test/user?userId=1">user_1</a><br>
	16、<a href="/springmvc/test/user?userId=2">user_2</a><br>
	17、<a href="/springmvc/test/user?userId=3">user_3</a><br>
</body>
</html>