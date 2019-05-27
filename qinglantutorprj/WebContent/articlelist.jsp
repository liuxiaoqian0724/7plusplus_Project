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
		<link rel="stylesheet" type="text/css" href="css/articlelist.css">
		<!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
		<script src="js/jquery-3.2.1.js"></script>
		<!-- zui -->
		<link rel="stylesheet" href="dist/css/zui.css" />
		<script type="text/javascript" src="dist/js/zui.js"></script>
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<div class="panel">
			<div class="panel-body">
				<!--推荐文章-->
				<div id="recommend">
					<button class="btn btn-primary" type="button" style="float: right; position: relative; margin-top:2%;">查看更多</button>
					<h2>推荐文章</h2>
					<hr />
					<div class="cards cards-borderless" id="articlerec">
						<div class="col-md-4 col-sm-6 col-lg-3">
							<a class="card" href="###">
								<img src="images/img2.jpg" alt="">
								<div class="card-heading"><strong>快速提升物理成绩的方法大全</strong></div>
								<div class="pull-right"><i class="icon-thumbs-o-up"></i> 520</div>
							</a>
						</div>
						<div class="col-md-4 col-sm-6 col-lg-3">
							<a class="card" href="###">
								<img src="images/img2.jpg" alt="">
								<div class="card-heading"><strong>快速提升物理成绩的方法大全</strong></div>
								<div class="pull-right"><i class="icon-thumbs-o-up"></i> 520</div>
							</a>
						</div>
						<div class="col-md-4 col-sm-6 col-lg-3">
							<a class="card" href="###">
								<img src="images/img2.jpg" alt="">
								<div class="card-heading"><strong>快速提升物理成绩的方法大全</strong></div>
								<div class="pull-right"><i class="icon-thumbs-o-up"></i> 520</div>
							</a>
						</div>
						<div class="col-md-4 col-sm-6 col-lg-3">
							<a class="card" href="###">
								<img src="images/img2.jpg" alt="">
								<div class="card-heading"><strong>快速提升物理成绩的方法大全</strong></div>
								<div class="pull-right"><i class="icon-thumbs-o-up"></i> 520</div>
							</a>
						</div>
					</div>
				</div>
				<!--标签导航-->
				<div id="lablenavigation">
					<ul class="nav nav-tabs">
						<li class="active"><a href="your/noce/url">最新发布</a></li>
						<li><a href="your/noce/url">最多阅读</a></li>
						<li><a href="your/noce/url">数学</a></li>
						<li><a href="your/noce/url">语文</a></li>
						<li><a href="your/noce/url">英语</a></li>
						<li><a href="your/noce/url">物理</a></li>
						<li><a href="your/noce/url">化学</a></li>
						<li><a href="your/noce/url">生物</a></li>
						<li><a href="your/noce/url">政治</a></li>
						<li><a href="your/noce/url">历史</a></li>
						<li><a href="your/noce/url">地理</a></li>
						<li><a href="your/noce/url">高一</a></li>
						<li><a href="your/noce/url">高二</a></li>
						<li>
							<a class="dropdown-toggle" data-toggle="dropdown" href="your/nice/url">更多 <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="your/nice/url">高三</a></li>
								<li><a href="your/nice/url">初一</a></li>
								<li><a href="your/nice/url">初二</a></li>
								<li><a href="your/nice/url">初三</a></li>
								<li><a href="your/nice/url">音乐</a></li>
								<li><a href="your/nice/url">美术</a></li>
								<li><a href="your/nice/url">体育</a></li>
							</ul>
						</li>
					</ul>
				</div>
				<!--文章列表-->
				<div id="articlelist">
					<div class="articlecard">
						<img src="images/img2.jpg" class="img-rounded" alt="圆角图片" style="position:relative; margin:1%; width:15%;">
						<div class="card-heading" style="position: relative; margin-top:-11%; left:20%; width:80%;"><strong>快速提升生物成绩的方法——妈妈再也不用担心我的生物啦</strong></div>
						<div class="card-content text-muted" style="position: relative; left:20%; width:75%;">
							分析和综合的方法分析就是把知识的一个整体分解成各个部分来进行考察的一种思维方法，综合是把知识的各个部分联合成一个整体来进行考察的一种思维方
							法，分析和综合是生物学学习中经常使用的重要方法，两者密切联系，不可分割。只分析不综合，就会见木而不见林;只综合不分析……
						</div>
						<div class="author">
							<img src="images/idphotocircle1.png" style="position: relative; width: 4%; left:20%; margin:1%;" />
							<div style="position: relative; left: 26%; margin-top:-4%; margin-bottom: 1%; width:30%;">Alexander</div>
							<div style="position:relative; left: 35%; margin-top:-3%; margin-bottom: 1%; width:30%;"> 2019.01.01</div>
							<div class="pull-right" style="position:relative; margin-top:-3%; right:2%;"><i class="icon-comment-alt"></i> 19</div>
							<div class="pull-right" style="position:relative; margin-top:-3%; right:6%;"><i class="icon-thumbs-o-up"></i> 19</div>
							<div class="pull-right" style="position:relative; margin-top:-3%; right:10%;"><i class="icon-star-empty"></i> 19</div>
						</div>
					</div>
					<div class="articlecard">
						<img src="images/img2.jpg" class="img-rounded" alt="圆角图片" style="position:relative; margin:1%; width:15%;">
						<div class="card-heading" style="position: relative; margin-top:-11%; left:20%; width:80%;"><strong>快速提升生物成绩的方法——妈妈再也不用担心我的生物啦</strong></div>
						<div class="card-content text-muted" style="position: relative; left:20%; width:75%;">
							分析和综合的方法分析就是把知识的一个整体分解成各个部分来进行考察的一种思维方法，综合是把知识的各个部分联合成一个整体来进行考察的一种思维方
							法，分析和综合是生物学学习中经常使用的重要方法，两者密切联系，不可分割。只分析不综合，就会见木而不见林;只综合不分析……
						</div>
						<div class="author">
							<img src="images/idphotocircle1.png" style="position: relative; width: 4%; left:20%; margin:1%;" />
							<div style="position: relative; left: 26%; margin-top:-4%; margin-bottom: 1%; width:30%;">Alexander</div>
							<div style="position:relative; left: 35%; margin-top:-3%; margin-bottom: 1%; width:30%;"> 2019.01.01</div>
							<div class="pull-right" style="position:relative; margin-top:-3%; right:2%;"><i class="icon-comment-alt"></i> 19</div>
							<div class="pull-right" style="position:relative; margin-top:-3%; right:6%;"><i class="icon-thumbs-o-up"></i> 19</div>
							<div class="pull-right" style="position:relative; margin-top:-3%; right:10%;"><i class="icon-star-empty"></i> 19</div>
						</div>
					</div>
					<div class="articlecard">
						<img src="images/img2.jpg" class="img-rounded" alt="圆角图片" style="position:relative; margin:1%; width:15%;">
						<div class="card-heading" style="position: relative; margin-top:-11%; left:20%; width:80%;"><strong>快速提升生物成绩的方法——妈妈再也不用担心我的生物啦</strong></div>
						<div class="card-content text-muted" style="position: relative; left:20%; width:75%;">
							分析和综合的方法分析就是把知识的一个整体分解成各个部分来进行考察的一种思维方法，综合是把知识的各个部分联合成一个整体来进行考察的一种思维方
							法，分析和综合是生物学学习中经常使用的重要方法，两者密切联系，不可分割。只分析不综合，就会见木而不见林;只综合不分析……
						</div>
						<div class="author">
							<img src="images/idphotocircle1.png" style="position: relative; width: 4%; left:20%; margin:1%;" />
							<div style="position: relative; left: 26%; margin-top:-4%; margin-bottom: 1%; width:30%;">Alexander</div>
							<div style="position:relative; left: 35%; margin-top:-3%; margin-bottom: 1%; width:30%;"> 2019.01.01</div>
							<div class="pull-right" style="position:relative; margin-top:-3%; right:2%;"><i class="icon-comment-alt"></i> 19</div>
							<div class="pull-right" style="position:relative; margin-top:-3%; right:6%;"><i class="icon-thumbs-o-up"></i> 19</div>
							<div class="pull-right" style="position:relative; margin-top:-3%; right:10%;"><i class="icon-star-empty"></i> 19</div>
						</div>
					</div>
					<div class="articlecard">
						<img src="images/img2.jpg" class="img-rounded" alt="圆角图片" style="position:relative; margin:1%; width:15%;">
						<div class="card-heading" style="position: relative; margin-top:-11%; left:20%; width:80%;"><strong>快速提升生物成绩的方法——妈妈再也不用担心我的生物啦</strong></div>
						<div class="card-content text-muted" style="position: relative; left:20%; width:75%;">
							分析和综合的方法分析就是把知识的一个整体分解成各个部分来进行考察的一种思维方法，综合是把知识的各个部分联合成一个整体来进行考察的一种思维方
							法，分析和综合是生物学学习中经常使用的重要方法，两者密切联系，不可分割。只分析不综合，就会见木而不见林;只综合不分析……
						</div>
						<div class="author">
							<img src="images/idphotocircle1.png" style="position: relative; width: 4%; left:20%; margin:1%;" />
							<div style="position: relative; left: 26%; margin-top:-4%; margin-bottom: 1%; width:30%;">Alexander</div>
							<div style="position:relative; left: 35%; margin-top:-3%; margin-bottom: 1%; width:30%;"> 2019.01.01</div>
							<div class="pull-right" style="position:relative; margin-top:-3%; right:2%;"><i class="icon-comment-alt"></i> 19</div>
							<div class="pull-right" style="position:relative; margin-top:-3%; right:6%;"><i class="icon-thumbs-o-up"></i> 19</div>
							<div class="pull-right" style="position:relative; margin-top:-3%; right:10%;"><i class="icon-star-empty"></i> 19</div>
						</div>
					</div>
					<div class="articlecard">
						<img src="images/img2.jpg" class="img-rounded" alt="圆角图片" style="position:relative; margin:1%; width:15%;">
						<div class="card-heading" style="position: relative; margin-top:-11%; left:20%; width:80%;"><strong>快速提升生物成绩的方法——妈妈再也不用担心我的生物啦</strong></div>
						<div class="card-content text-muted" style="position: relative; left:20%; width:75%;">
							分析和综合的方法分析就是把知识的一个整体分解成各个部分来进行考察的一种思维方法，综合是把知识的各个部分联合成一个整体来进行考察的一种思维方
							法，分析和综合是生物学学习中经常使用的重要方法，两者密切联系，不可分割。只分析不综合，就会见木而不见林;只综合不分析……
						</div>
						<div class="author">
							<img src="images/idphotocircle1.png" style="position: relative; width: 4%; left:20%; margin:1%;" />
							<div style="position: relative; left: 26%; margin-top:-4%; margin-bottom: 1%; width:30%;">Alexander</div>
							<div style="position:relative; left: 35%; margin-top:-3%; margin-bottom: 1%; width:30%;"> 2019.01.01</div>
							<div class="pull-right" style="position:relative; margin-top:-3%; right:2%;"><i class="icon-comment-alt"></i> 19</div>
							<div class="pull-right" style="position:relative; margin-top:-3%; right:6%;"><i class="icon-thumbs-o-up"></i> 19</div>
							<div class="pull-right" style="position:relative; margin-top:-3%; right:10%;"><i class="icon-star-empty"></i> 19</div>
						</div>
					</div>
				</div>
				<!--分页条-->
				<div id="pages">
					<ul class="pager">
					  <li class="previous"><a href="your/nice/url">«</a></li>
					  <li><a href="your/nice/url">1</a></li>
					  <li class="active"><a href="your/nice/url">2</a></li>
					  <li><a href="your/nice/url">3</a></li>
					  <li><a href="your/nice/url">4</a></li>
					  <li><a href="your/nice/url">5</a></li>
					  <li class="next"><a href="your/nice/url">»</a></li>
					</ul>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="<%=basePath%>/js/index.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/checkLogin_regist.js"></script>
		<jsp:include page="footer.jsp" />
	</body>
</html>