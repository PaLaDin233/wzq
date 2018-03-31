<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
request.setAttribute("path", basePath);  
double d=Math.random();
String rand = Double.toString(d);  
session.setAttribute("rand",rand);
%>  
<html>
<head>
  <!-- Standard Meta -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

  <!-- Site Properties -->
  <title>五子棋OnLine</title>
  
  <link rel="stylesheet" type="text/css" href="${path}dist/components/reset.css">
  <link rel="stylesheet" type="text/css" href="${path}dist/components/site.css">

  <link rel="stylesheet" type="text/css" href="${path}dist/components/container.css">
  <link rel="stylesheet" type="text/css" href="${path}dist/components/grid.css">
  <link rel="stylesheet" type="text/css" href="${path}dist/components/header.css">
  <link rel="stylesheet" type="text/css" href="${path}dist/components/image.css">
  <link rel="stylesheet" type="text/css" href="${path}dist/components/menu.css">

  <link rel="stylesheet" type="text/css" href="${path}dist/components/divider.css">
  <link rel="stylesheet" type="text/css" href="${path}dist/components/segment.css">
  <link rel="stylesheet" type="text/css" href="${path}dist/components/form.css">
  <link rel="stylesheet" type="text/css" href="${path}dist/components/input.css">
  <link rel="stylesheet" type="text/css" href="${path}dist/components/button.css">
  <link rel="stylesheet" type="text/css" href="${path}dist/components/list.css">
  <link rel="stylesheet" type="text/css" href="${path}dist/components/message.css">
  <link rel="stylesheet" type="text/css" href="${path}dist/components/icon.css">

  <script src="${path}page/assets/library/jquery.min.js"></script>
  <script src="${path}dist/components/form.js"></script>
  <script src="${path}dist/components/transition.js"></script>

 	<link rel="stylesheet" type="text/css" href="${path }dist/semantic.css"/>
 	<link rel="stylesheet" type="text/css" href="${path}dist/components/message.css"/>
 	
	<script src="${path }dist/semantic.min.js"></script>
	<script src="${path }dist/jquery.min.js"></script>
	
	<script src="${path}page/assets/library/jquery.min.js"></script>
	<script src="${path}dist/components/form.js"></script>
 	<script src="${path}dist/components/transition.js"></script>

 	
  <style type="text/css">
    body {
      background-color: #DADADA;
      background-image: url("<%=path%>/images/bg.jpg");
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
 <script>
 $(document)
 .ready(function() {
   $('.ui.form').form
   ({
       fields: {
         us102: {
           rules: [
             {
               type   : 'empty',
               prompt : '请输入用户名'
             }
           ]
         },
         password: {
           identifier  : 'us103',
           rules: [
             {
               type   : 'empty',
               prompt : '请输入密码'
             }
           ]
         }
       }
     })
   ;
 })
;
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
		  return true;
	  }
	};
  </script>
</head>
<body>

<div class="ui middle aligned center aligned grid">
  <div class="column ui message" style="opacity:0.8;" id="loginbox" onmouseover="fun1();" onmouseout="fun2();">
    <h2 class="ui teal image header">
      <img src="${path}images/logo.png" class="image">
      <div>
        	<div style="background: linear-gradient(to right, #000000, #00000f);
        	-webkit-background-clip: text;
        	color: transparent;">五子棋<i>ONLINE</i></div>
      </div>
    </h2>
    <form class="ui large form" action="${path }login.html" id="loginForm" method="post" onsubmit="return checkForm(this)">
      <div class="ui stacked segment">
        <div class="field">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <input type="text" name="us102" placeholder="用户名">
          </div>
        </div>
        <div class="field">
          <div class="ui left icon input">
            <i class="lock icon"></i>
            <input type="password" name="us103" placeholder="密码">
          </div>
        </div>
        <div class="ui fluid large teal submit button" style="background-color: #111111;color: white">登录</div>
      </div>
	   <input type="hidden" name="rand" value="<%=rand%>">  
      <div class="ui error message"></div>
      <%-- <div class="ui message" style="display:display;">${sessionScope.msg }</div> --%>
    </form>

    <div class="ui message">
      	没有账号? <a href="#">注册</a>
    </div>
  </div>
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

</script>

</html>
