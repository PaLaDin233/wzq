<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
request.setAttribute("path", basePath);  
%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  


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
	<style type="text/css">
		.btn{
			background-color: rgb(233,233,233);
			/* height: 30px;
			text-align: center;
			line-height: 100%; */
			 /* background: linear-gradient(white,rgb(192,192,192));  */
		}
		th,td{
			text-align: center;
			moz-user-select: -moz-none; 
			-moz-user-select: none; 
			-o-user-select:none; 
			-khtml-user-select:none; 
			-webkit-user-select:none; 
			-ms-user-select:none; 
			user-select:none;
			cursor: default;
		}
		.row{
			margin-bottom: 10px;
		}
	</style>
	
	<script type="text/javascript">
		function checkform(a){
			with(a){
				if(
						(us210.value==null || us210.value=="")&& 
						(us201.value==null || us201.value=="")&&
						(us202.value==null || us202.value=="")	
				){
					alert("请输入至少一个条件");
					return false;
				}
			}
			return true;
		}
	</script>
	
</head>
<body>
<form action="${path }userList.html" method="get" onsubmit="return checkform(this)" id="form">
<div class="container" style="border-bottom:dotted thin;">
<br><br>
	
		<div class="row">
			<div class="col-xs-4">
				<label for="us210" class="sr-only">用户编号</label>
				<input type="text" class="form-control" name="us210" id="us210" placeholder="请输入要查找的用户编号" 
				value="${sessionScope.us210 }">
			</div>
			<div class="col-xs-4">
				<label for="us210" class="sr-only">玩家编号</label>
				<input type="text" class="form-control" name="us201" id="us201" placeholder="请输入要查找的玩家编号"
				value="${sessionScope.us201 }">
			</div>
			<div class="col-xs-4">
				<label for="us202" class="sr-only">用户名</label>
				<input type="text" class="form-control" name="us202" id="us202" placeholder="请输入要查找的用户名"
				value="${sessionScope.us202 }">
			</div>
		</div>
		<div class="row" style="padding-left: 0px;">
			<div class="col-xs-1 col-xs-offset-11">		
				<button type="submit" class="btn">查找用户</button>
			</div>
		</div>
	
</div>

<table style="width: 100%">
	<tr>
		<th><label>用户编号</label></th>
		<th>玩家编号</th>
		<th>玩家名称</th>
		<th>玩家经验</th>
		<th>玩家积分</th>
		<th>玩家状态</th>
		<th>所在房间</th>
	</tr>
	
	
	<!-- 迭代数据 -->
          <c:choose>
              <c:when test="${not empty requestScope.pageBean.pageData}">
                  <c:forEach var="u" items="${requestScope.pageBean.pageData}" varStatus="vs">
                      <tr>
							<td>${u.us210 }</td>
							<td>${u.us201 }</td>
							<td>${u.us202 }</td>
							<td>${u.us209 }</td>
							<td>${u.us210 }</td>
							<td>${u.us208 }</td>
							<td>${u.us211 }</td>
                      </tr>
                  </c:forEach>
              </c:when>
          </c:choose>
          
          <tr>
              <td colspan="3" align="center">
                  当前${requestScope.pageBean.currentPage }/${requestScope.pageBean.totalPage }页     &nbsp;&nbsp;
                  <input type="hidden" value="${requestScope.pageBean.currentPage}" name="currentPage" id="currentPage">
                  <input type="hidden" value="${requestScope.pageBean.totalPage}" name="totalPage" id="totalPage">
                  
                  <a href="#" onclick="subm(0)">首页</a>
                  <a href="#" onclick="subm(-1)">上一页 </a>
                  <a href="#" onclick="subm(1)">下一页 </a>
                  <a href="#" onclick="subm(${requestScope.pageBean.totalPage})">末页</a>
              </td>
          </tr>

</table>
</form>
</body>

<script type="text/javascript">
function subm(a){
	var page=document.getElementById("currentPage");
	
	if(a==0)page.value=1;
	else if(a==1||a==-1)page.value=parseInt(page.value)+a;
	else page.value=a;
	
	var f=document.getElementById("form");
	if(checkform(f))
		f.submit();
}

</script>
</html>
