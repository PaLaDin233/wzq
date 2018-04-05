<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
request.setAttribute("path", basePath);  
%>  
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<title>个人中心</title>
	<!-- 引入 Bootstrap -->
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"> 
	<!-- 可选的Bootstrap主题文件（一般不使用） -->
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script> 
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script> 
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    <!-- HTML5 Shiv 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
	<!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
	<![endif]-->
	
	<link href="${path }/css/main.css" rel="stylesheet"> 
	<style type="text/css">
		table{
			border: medium;
		}
		body{
			background:linear-gradient(to right,#ffffff,#00ccff);
		}
	</style>
</head>
<body>
<br><br><br><br>
<form action="${path }modinfo.html" method="get">
	<table class="table-striped">
		<tr>
			<td>玩家编号</td>
			<td><input type="text" name="us201" value="${sessionScope.userinfo.us201}" readonly="readonly"></td>
			<td>状态</td>
		</tr>
		<tr>
			<td>玩家名称</td>
			<td><input type="text" name="us202" value="${sessionScope.userinfo.us202}"></td>
			<td><button>修改</button></td>
		</tr>
		<tr>
			<td>玩家性别</td>
			<td>男<input type="radio" name="us203" value="01">女<input type="radio" name="us203" value="00">${sessionScope.userinfo.us203}</td>
			<td>状态</td>
		</tr>
		<tr>
			<td>玩家积分</td>
			<td>${sessionScope.userinfo.us204}</td>
			<td>状态</td>
		</tr>
		<tr>
			<td>注册时间</td>
			<td>${sessionScope.userinfo.us206}</td>
			<td>状态</td>
		</tr>
		<tr>
			<td>玩家经验</td>
			<td>${sessionScope.userinfo.us209}</td>
			<td>状态</td>
		</tr>
	</table>
	
</form>
</body>
</html>
