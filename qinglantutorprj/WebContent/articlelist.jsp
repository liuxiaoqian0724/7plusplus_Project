<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>文章列表</title>
		<!--本地css-->
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/articlelist.css">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/header.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/footer.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/register_login.css" />
		<!-- zui -->
		<link rel="stylesheet" href="<%=basePath%>/dist/css/zui.css" />
		<link rel="stylesheet" href="<%=basePath%>/css/verify.css" />
		<!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
		<script src="<%=basePath%>/js/jquery-3.2.1.js"></script>
		<!-- ZUI Javascript组件 -->
		<script type="text/javascript" src="<%=basePath%>/dist/js/zui.js"></script>
		<script src="<%=basePath%>/js/verify.js"></script>
		<script src="<%=basePath%>/js/verify.min.js"></script>
		<!--  js功能代码 -->
		<script src="<%=basePath%>/js/header.js"></script>
		<script src="<%=basePath%>/js/articlelist.js"></script>
		<script src="<%=basePath%>/js/nav.js"></script>
	</head>
	<body>
		<jsp:include page="header.jsp" />
		<div class="panel">
			<div class="panel-body">
				<div id="all">
					<!--推荐文章-->
					<div id="recommend">
						<button class="btn btn-primary" type="button" style="float: right; position: relative; margin-top:2%;">查看更多</button>
						<h2>推荐文章</h2>
						<hr />
						<div id="articlel">

						</div>
					</div>
					<br />
					<!--标签导航-->
					<div id="lablenavigation" style="border:1px solid #8abcd1; padding-top:1%; padding-bottom:1%;">
						<ul class="nav nav-tabs" style="width:100%;height:auto;">
							<li class="active"><a href="#">最新发布</a></li>
							<li><a href="#">最多阅读</a></li>
							<li><a href="#">数学</a></li>
							<li><a href="#">语文</a></li>
							<li><a href="#">英语</a></li>
							<li><a href="#">物理</a></li>
							<li><a href="#">化学</a></li>
							<li><a href="#">生物</a></li>
							<li><a href="#">政治</a></li>
							<li><a href="#">历史</a></li>
							<li><a href="#">地理</a></li>
							<li><a href="#">高一</a></li>
							<li><a href="#">高二</a></li>
							<li>
								<a class="dropdown-toggle" data-toggle="dropdown" href="your/nice/url">更多 <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#">高三</a></li>
									<li><a href="#">初一</a></li>
									<li><a href="#">初二</a></li>
									<li><a href="#">初三</a></li>
									<li><a href="#">音乐</a></li>
									<li><a href="#">美术</a></li>
									<li><a href="#">体育</a></li>
								</ul>
							</li>
						</ul>
					</div>
					<!--文章列表-->
					<div id="articlelist">

					</div>
					<!--分页条-->
					<ul class="pager" id="pager4" style="position:relative; left:45%;">
						
					</ul>
				</div>
			</div>
			<script type="text/javascript" src="<%=basePath%>/js/index.js"></script>
			<script type="text/javascript" src="<%=basePath%>/js/checkLogin_regist.js"></script>
			<jsp:include page="footer.jsp" />
	</body>
</html>
