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
      <!-- 引入 Bootstrap -->
      <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
 
      <!-- HTML5 Shiv 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
      <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
      <!--[if lt IE 9]>
         <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
         <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
      <![endif]-->

	<title>五子棋OnLine</title>
	
</head>
<body>
	<div class="container">
		<div class="col-xs-2">
			<ul class="nav">
				<li class="active"><a href="#" target="blank">首页</a></li>
			</ul>
			<ul class="nav">
				<li class="active"><a href="#" target="blank">开始游戏</a></li>
			</ul>
			<ul class="nav">
				<li class="active"><a href="${path }personal.html?us101=${sessionScope.user}" target="blank">个人中心</a></li>
			</ul>
			<ul class="nav">
				<li class="active"><a href="#" target="blank">首页</a></li>
			</ul>
			<ul class="nav">
				<li class="active"><a href="#" target="blank">首页</a></li>
			</ul>
			<ul class="nav">
				<li class="active"><a href="#" target="blank">首页</a></li>
			</ul>
		</div>
		<div class="col-xs-6" ><iframe name="blank" style="height: 100%;width: 100%"></iframe></div>
		<div class="col-xs-4">a</div>
	</div>
</body>
</html>
