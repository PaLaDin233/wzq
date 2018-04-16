<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	<link rel="stylesheet" type="text/css" href="../css/semantic.min.css">
	<script src="../css/semantic.min.js"></script>
	<script src="../css/jquery.min.js"></script>
	
	<title>五子棋OnLine</title>
	<style type="text/css">
	   body {
	     background-color: #DADADA;
	   }
	   body > .grid {
	     height: 100%;
	   }
	   .image {
	     margin-top: -100px;
	   }
	   .column {
	     max-width: 450px;
	   }
	</style>
</head>

<body>
	<div class="ui message" style="display:display;">${sessionScope.msg }</div>
	<a href="#" onClick="javascript :history.back(-1);">返回</a>
	

</body>
</html>
