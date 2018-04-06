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
<title></title>
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
	
<script src='${path }js/md5.js'></script><!--引入MD5加密-->
<script type="text/javascript">

function checkForm() {
	var us103=document.getElementById("oldPassword");
	var newus103=document.getElementById("newPassword");
	var qus103=document.getElementById("newPassword2");
	  if(us103.value==null||us103.value==''){
		  alert("请输入原密码");
		  return false;
	  }
	  else if(newus103.value==null||newus103.value==''){
		  alert("请输入新密码");
		  return false;
	  }
	  else if(qus103.value==null||qus103.value==''){
		  alert("请输入确认密码");
		  return false;
	  }
	  else if(newus103.value!=qus103.value){
		  alert("密码不一致")
		  return false;
	  }
	  else{us103.value=hexMD5(us103.value);
		  newus103.value=hexMD5(newus103.value);
		  qus103.value=hexMD5(qus103.value);
		  
		  return true;
	  }
	  return false;
	};
</script>
</head>
<body>
<div class="container">
	
<form class="form-horizontal" role="form" onsubmit="return checkForm()" 
		action="${path }ModPassword.html" method="post">
<input name="us101" type="text"  value="${sessionScope.user }" readonly="readonly" hidden="hidden">
  <div class="form-group">
    <label for="oldPassword" class="col-sm-2 control-label">原密码</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="oldPassword" name="us103" placeholder="请输入原密码">
    </div>
  </div>
  <div class="form-group">
    <label for="newPassword" class="col-sm-2 control-label">新密码</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="newPassword" name="newus103" placeholder="请输入新密码">
    </div>
  </div>
  <div class="form-group">
    <label for="newPassword2" class="col-sm-2 control-label">确认密码</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="newPassword2" placeholder="请再次输入新密码">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <input class="btn btn-block" type="submit" value="修改">
    </div>
  </div>
</form>
</div>
</body>
</html>
