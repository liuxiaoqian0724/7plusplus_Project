<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/img.css">
</head>
<body>
	<div class="all">
	  	<h2>选中家教对比图</h2>
	  	<div class="img">${radarimage }</div>
  	</div>
  	<div class="return">
  		<a href="<%=basePath%>/tutorlist/conditions/0/0">返回家教页</a>	
  	</div>
</body>
</html>