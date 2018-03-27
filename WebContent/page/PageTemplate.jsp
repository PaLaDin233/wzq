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
	
	<link rel="stylesheet" type="text/css" href="pathcss/semantic.min.css">
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
  </script>
</head>
<body>
<div class="ui pointing menu">
  <a class="item" href="login.jsp" target="main">Home </a>
  <a class="item">Messages </a>
  <a class="item active">好友 </a>
  <div class="right menu">
    <div class="item">
      <div class="ui transparent icon input">
        <input placeholder="Search..." type="text">
        <i class="search link icon"></i>
      </div>
    </div>
  </div>
</div>
<div class="ui segment">
  <p></p>
</div>
</body>
</html>
