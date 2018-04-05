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
<script language='javascript' src='${path }js/md5.js'></script><!--引入MD5加密-->  

<title>五子棋OnLine</title>	
<style type="text/css">
    .image {
      height: 50px;
    }
    .form-signin,{
      max-width: 450px;
      background-color: #DADADA;
    }
    .btn{
    	background-color: black;
    	color: white;
    }
    .center-vertical {
    position:relative;
    top:20%;
    }
    
	.title{
     	color:white;
	}
	
	body {
      background-color: #DADADA;
      background-image: url("<%=path%>/images/bg.jpg");
    }
</style>
</head>
<body>
<div class="container" >
	<div class="col-xs-3"></div>
	<div class="col-xs-6" style="opacity:0.8;" id="loginbox" onmouseover="fun1();" onmouseout="fun2();">
		<div class="row center-block center-vertical" style="height: 60%">
			<form class="form-signin" action="${path }login.html" id="loginForm"
							 method="post" onsubmit="return checkForm(this)">
				<div class="title">
				<h2 class="from-signin-heading text-center">
				    	<img src="${path}images/logo.png" class="image">
				      	五子棋<i>ONLINE</i>
			   	</h2></div>
			   	<div class="row">
				   	<label class="sr-only" for="" >用户名</label>
					<input class="form-control" type="text" name="us102" placeholder="用户名">
				</div>
				<br>
				<div class="row">
					<input class="form-control" type="password" name="us103" placeholder="密码">
				</div>
				<br>
				<div class="row">
					<input class="btn btn-block" type="submit" value="登陆">
				</div>
			</form>
			<div class="row text-right">没有账号?<a href="#">注册</a></div>
		</div>
		
		
	</div>
	<div class="col-xs-3"></div>
</div>
</body>

<script type="text/javascript">

var a=document.getElementById("loginbox");
function fun1(){
	a.setAttribute("style", "opacity:0.9;");
	alert(checkSubmitFlg);
}
function fun2(){
	a.setAttribute("style", "opacity:0.7;")
}
function checkForm(a) {
	  with(a){
		  if(us102.value==null||us102.value==''){
			  alert("请输入用户名");
			  return false;
		  }
		  if(us103.value==null||us103.value==''){
			  alert("请输入密码");
			  return false;
		  }
		  us103.value=hexMD5(us103.value);
		  return true;
	  }
	};
</script>
</html>
