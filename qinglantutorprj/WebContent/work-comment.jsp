<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<meta charset="utf-8">
	<base href="<%=basePath%>">
	
	<link rel="stylesheet" type="text/css" href="css/footer.css"/>
	<link rel="stylesheet" type="text/css" href="css/header.css"/>
	<link rel="stylesheet" href="dist/css/zui.min.css">
	<script type="text/javascript" src="dist/lib/jquery/jquery.js"></script>
	<script type="text/javascript" src="dist/js/zui.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/work-complete.css">

    <link rel="stylesheet" type="text/css" href="css/register_login.css"/>
    <!-- zui -->
    <link rel="stylesheet" href="dist/css/zui.css" />
    <link rel="stylesheet" href="css/verify.css" />
    <!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
    <!-- ZUI Javascript组件 -->
    <script type="text/javascript" src="dist/js/zui.js"></script>
    <script src="js/verify.js"></script>
    <script src="js/verify.min.js"></script>
    <!--  js功能代码 -->
    <script src="js/header.js"></script>
    <script src="js/nav.js"></script>
    <!-- semantic -->
    <link rel="stylesheet" type="text/css" href="Semantic/components/message.css"/>
	
		

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<!-- 作业完成页面 -->
	<div id="d1" style="height: 1100px;">
		<div id="c1"><h2>作业评价</h2></div>
	<c:forEach items="${homework}" var="h">
		<div id="c2">任务   <br>
			<p style="font-size: 16px;margin-top:10px;font-weight: normal;width: 500px;color: #999;">${h.getTeachRelation().getUser().getUserName()}老师 发布于${h.tstartTime}</p>
		</div>
		<div id="c3">${h.sstatus}</div>
		<div id="c4">${h.tcontent}</div>
		<div class="c5">作业内容：</div>
		<p style="font-size: 13px;margin-top:60px;margin-left:-110px;font-weight: normal;width: 500px;float: left;">${h.getClassRelation().getUser().getUserName()}完成于${h.sfinishTime}</p>
		

		<!-- 作业内容 -->
		<div  style="	width: 800px;height: 200px;float: left;overflow-y:auto;overflow-x: hidden;
				border:1px solid #c0c0c0;margin-left: 47px;">${h.scontent}</div>
		<!-- 作业疑问 -->
		<div  class="c5" style="margin-left: 27px;">作业疑问：</div>
		<div  style="width: 800px;height: 110px;float: left;overflow-y:auto;overflow-x: hidden;
					border:1px solid #c0c0c0;margin-top: -15px;margin-left: 47px;">${h.question}</div>		
	
			<!-- 作业耗时与完成情况 -->
			<c:if test="${not empty hid}">
			<form action="Upload" method="post"  >
			<c:if test="${not empty ts}">
				<div id="time1" > 
					<div  class="c7" style="height: 20px;width: 75px;">分数</div>
					<div  class="t2" ><input type="text" style="width:40px;"  name="score"  value="${h.score }" disabled="disabled">  </div>
					<div style="float: left;margin-left: 190px;margin-top:-20px;width: 50px;"><p>分</p></div>
					<input name="hid" type="hidden" value="${hid}">
				</div>
		<!-- 	作业评语表单提交 -->
				<div  class="c7" style="margin-left: 170px;">作业评语</div>
				<textarea  placeholder="${h.workReview }" style="resize: none;width: 430px;height: 125px;margin-left:-80px ;margin-top: 40px;float: left;border:1px dashed #c0c0c0;" name="comment" disabled="disabled"></textarea>
				<input type="submit" value="提交"  class="btn-submit" style="float: right;margin-right: 47px;"  disabled="disabled"/>
			</c:if>
			<c:if test="${ empty ts}">
				<div id="time1" > 
					<div  class="c7" style="height: 20px;width: 75px;">分数</div>
					<div  class="t2" ><input type="text" style="width:40px;"  name="score">  </div>
					<div style="float: left;margin-left: 190px;margin-top:-20px;width: 50px;"><p>分</p></div>
						<input name="hid" type="hidden" value="${hid}">
				</div>
		<!-- 	作业评语表单提交 -->
				<div  class="c7" style="margin-left: 170px;">作业评语</div>
				<textarea style="resize: none;width: 430px;height: 125px;margin-left:-80px ;margin-top: 40px;float: left;border:1px dashed #c0c0c0;" name="comment"></textarea>
				<input type="submit" value="提交"  class="btn-submit" style="float: right;margin-right: 47px;" />
			</c:if>
			</form>
		</c:if>
		</c:forEach>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript" src="js/checkLogin_regist.js"></script>
	
</body>

</html>