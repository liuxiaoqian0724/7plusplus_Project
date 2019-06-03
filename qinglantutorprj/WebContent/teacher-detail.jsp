<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%-- <%
	String rootpath=application.getRealPath("/");
	System.out.println(rootpath);
%> --%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>老师详情页</title>
	<!-- ZUI 标准版压缩后的 CSS 文件 -->
	<base href="<%=basePath%>">
<link rel="stylesheet" href="dist/css/zui.min.css">
<link rel="stylesheet" type="text/css" href="css/personal-center.css">
<link rel="stylesheet" type="text/css" href="css/teacher-detail.css">
<link rel="stylesheet" type="text/css" href="css/header.css"/>
<link rel="stylesheet" type="text/css" href="css/footer.css"/>
<link rel="stylesheet" type="text/css" href="css/register_login.css"/>

<!-- zui -->
	<script src="js/jquery-3.2.1.js"></script>
	<link rel="stylesheet" href="dist/css/zui.css" />
	<!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
	<!-- <script src="dist/lib/jquery/jquery.js"></script> -->
	<!-- ZUI Javascript组件 -->
	<script type="text/javascript" src="dist/js/zui.js"></script>
	
	<link rel="stylesheet" href="css/verify.css" />
	<script type="text/javascript" src="js/verify.js"></script>
    <script type="text/javascript" src="js/verify.min.js"></script>
    <script type="text/javascript" src="js/header.js"></script>
 	<script type="text/javascript" src="js/nav.js"></script>
 	
 	<!-- semantic -->
	<link rel="stylesheet" type="text/css" href="Semantic/components/message.css"/>

<meta charset="utf-8">
</head>
<body style="background-color: #F8F8F8;">
<!-- 头部 -->
<jsp:include page="header.jsp"></jsp:include>
<!-- 中部 -->
<div id="out" class="pannel">
			<div class="pannel-body">
				<div id="blank"></div>
				<div id="toptop">
					<p>${article.title}</p>
				</div>
				<div id="top" style="height:150px; width:780.5; background-color: #fff;">
					<div id="left">
						<!-- 上部头像 -->
						<img id="img-circle1" src="images/idphotocircle1.png" width="80px" height="80px" alt="圆形图片">
						<!-- 对该教师加关注 -->
						<div id="follow">
							<ul style="list-style-type:none;  background-color: #fff;">
								<li style="margin-bottom: 6px; background-color: #fff; font-size: 18px;"><span id="teachername">${article.title }</span><span style="background-color: #fff;"><button class="btn" type="button" id="button-follow" style="margin-right: 20px;"><i class="icon icon-plus"></i>关注</button></span></li>
								<li style="margin-bottom: 6px; background-color: #fff; font-size: 18px;">${article.sendTime }&nbsp;&nbsp;&nbsp;阅读:${article.likeCount }&nbsp;&nbsp;&nbsp;点赞:${article.likeCount }</li>
							</ul>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</div>
					</div>
					<div id="right">
						<ul style="list-style-type:none; background-color: #fff;">
							<li style=" background-color: #fff; font-size: 20px;">标签:</li>
							<li style="margin-bottom: 3px; background-color: #fff;"><button class="btn" type="button">${article.user.grade}</button><button class="btn" type="button" style="margin-left: 6px;">${article.user.major}</button></li>
							<li style="margin-bottom: 3px; background-color: #fff;"><button class="btn" type="button" style="margin-top: 4px;">${article.user.address}</button></li>
							<li style="margin-bottom: 3px; background-color: #fff;"><button class="btn" type="button" style="margin-top: 4px;">提分密集</button></li>
						</ul>
					</div>
				</div>
				<div id="blank"></div>
				<!-- 正文部分 -->
				<div id="Middletop">
					<p id="word">${article.content }</p>
				</div>
				<!-- 收藏点赞分享 -->
				<!-- <div id="blank"></div>
				<div id="MiddleMiddle">
					<button class="btn btn-success " type="button" id="buttonid1">点赞</button>
					<button class="btn btn-info " type="button" id="buttonid1">收藏</button>
					<button class="btn btn-warning " type="button" id="buttonid1">分享</button>
				</div> -->
				<div id="blank"></div>
				<div id="Middlebottom">
					<p id="comment">评论</p><hr>
					<c:forEach items="${article.userReviewSet }" var="onearticle">
					<div id="introduce">
						<img src="images/idphotocircle1.png" width="90px" height="90px" id="img-circle2" alt="圆形图片">
						<p id="name">${article.user.id }</p>
						<p style="background-color: #fff;" id="introducep">${onearticle.rContent }</p>
						<button class="btn" type="button" id="reply">回复</button>
						<p id="replytimess"> ${onearticle.rTime }</p>
					</div>
					</c:forEach>
					<!-- 分页数 -->
					<ul class="pager" id="pager">
					  <li class="previous"><a href="#">上一页</a></li>
					  <li><a href="#">1</a></li>
					  <li class="active"><a href="#">2</a></li>
					  <li><a href="#">3</a></li>
					  <li><a href="#">4</a></li>
					  <li><a href="#">5</a></li>
					  <li class="next"><a href="#">下一页</a></li>
					</ul>
				</div>
				<div id="blank"></div>
				<div id="bottom">
					<img src="images/idphotocircle1.png" width="90px" height="90px" id="img-circle" alt="圆形图片">
					<textarea value="content" id="bottomtextarea" rows="2" placeholder="撰写评论..."></textarea>
					<div id="row">
						<button class="btn" type="button" id="replyok" name="articlecontent" value="articlecontent">发表回复</button>
					</div>
				</div>
				<div id="blank"></div>
			</div>
		</div>


<!-- 底部 -->
 <jsp:include page="footer.jsp"></jsp:include>
 <script type="text/javascript" src="js/checkLogin_regist.js"></script>
</body>
</html>