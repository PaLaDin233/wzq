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
	<div class="container-fruid" style="padding: 0px;">
		<div class="col-xs-1" style="padding: 0px;">
			<ul class="nav">
				<li class="active"><a href="${path }page/notice.jsp" target="blank">首页</a></li>
			
				<li class="active"><a href="${path }page/ToBeContinue.jsp" target="blank">开始游戏</a></li>
			
				<li class="active"><a href="${path }page/ToBeContinue.jsp" target="blank">好友管理</a></li>
		
				<li class="active"><a href="${path }personal.html?us101=${sessionScope.user}" target="blank">个人中心</a></li>
			
				<li class="active"><a href="${path }page/ToBeContinue.jsp" target="blank">安全中心</a></li>
			
				<li class="active"><a href="${path }page/ToBeContinue.jsp" target="blank">系统设置</a></li>
				<li class="active"><a href="${path }page/ToBeContinue.jsp" target="blank">关于我们</a></li>
				<li class="active"><a href="${path }GameOnline.html">注销</a></li>
			</ul>
		</div>
		<div class="col-xs-8" ><iframe name="blank" src="${path }page/notice.jsp" style="height: 100%;width: 100%;border: medium;"></iframe></div>
		<div class="col-xs-3">
			<iframe name="" src="${path }page/playerListFrame.jsp" style="height: 40%;width: 100%;"></iframe>
			<iframe name="" src="${path }page/chatFrame.jsp" style="height: 60%;width: 100%;"></iframe>
		</div>
	</div>
</body>
</html>
