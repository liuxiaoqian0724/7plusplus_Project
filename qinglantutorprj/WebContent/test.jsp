<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>青蓝家教</h1>
	<h1>小组名：7++</h1>
	<h2>主页展示和家教信息发布模块</h2>
	<a href="">主页</a><br/>
	<a href="">家教信息发布</a>
	<h2>家教展示模块</h2>
	<a href="/qinglantutorprj/tutorlist/conditions/0">家教列表页</a><br/>
	<a href="tutorDetail/showtutorDetail/1">家教详情展示页面</a><br/>
	<h2>个人中心模块</h2>
	<a href="HomeWorkShow">个人中心-作业模块</a><br/>
	<a href="courseInformation">个人中心-课程</a><br/>
	<a href="teachPlanInformation">个人中心-教案</a><br/>
	<a href="jumptoReview?email=zhangsan@qq.com">个人中心-评论页面</a><br/>
	<a href="jumptoNews?email=zhangsan@qq.com">个人中心-消息页面</a><br/>
</body>
</html>