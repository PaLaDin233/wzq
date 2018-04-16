<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
request.setAttribute("path", basePath);  
%>  
<html>
<head>
<!-- Standard Meta -->
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

<!-- Site Properties -->
<title>在线五子棋系统</title>

<script>
	function submit(a){
		var fo=document.getElementById("form");
		var num=document.getElementById("test");
		
		if(a==0)num.value=1;
		else if(a==1||a==-1)num.value=parseInt(num.value)+a;
		else num.value=a;
		
		fo.submit();
	}
</script>
</head>
<body>
	<form action="${path }t" id="form" method="get">
		<input type="text" name="test" id="test" value="${sessionScope.test }">
		<a href="#" onclick="submit(1)">hello1</a>
		<a href="#" onclick="submit(-1)">hello-1</a>
		<a href="#" onclick="submit(0)">hello0</a>
		<a href="#" onclick="submit(2333)">hello2333</a>
		<input type="submit">
	</form>
</body>
</html>
