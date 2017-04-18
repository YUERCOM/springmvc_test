<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="yuertag" uri="/tlds/yuertag" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${staticRoot}/static/js/jquery-3.1.1.min.js"></script>
<title>springMVC</title>
</head>
<body>
	success  ${model1.a },${model1.b }
	
	<yuertag:tag core="add" module="success">添加</yuertag:tag>
	<yuertag:tag core="update" module="success">修改</yuertag:tag>
	<yuertag:tag core="delete" module="success">删除</yuertag:tag>
	
</body>
</html>