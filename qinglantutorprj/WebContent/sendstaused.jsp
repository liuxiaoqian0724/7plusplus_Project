<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="<%=basePath%>/dist/css/zui.css" />
		<link rel="stylesheet" href="<%=basePath%>/dist/lib/datetimepicker/datetimepicker.css" />
		<link rel="stylesheet" href="<%=basePath%>/dist/lib/datetimepicker/datetimepicker.min.css" />
		<link rel="stylesheet" href="<%=basePath%>/css/sendstaused.css" />
		  <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/header.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/register_login.css"/>
    <!-- zui -->
    <link rel="stylesheet" href="<%=basePath%>/css/verify.css" />
		<!--js引入-->
		<script type="text/javascript" src="<%=basePath%>/js/jquery-3.2.1.js"></script>
		<script type="text/javascript" src="<%=basePath%>/dist/js/zui.js"></script>
		<script type="text/javascript" src="<%=basePath%>/dist/lib/datetimepicker/datetimepicker.js"></script>
		<script type="text/javascript" src="<%=basePath%>/dist/lib/datetimepicker/datetimepicker.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>/dist/js/zui.js"></script>
    <script src="<%=basePath%>/js/verify.js"></script>
    <script src="<%=basePath%>/js/verify.min.js"></script>
    <script src="<%=basePath%>/js/header.js"></script>
    <script src="<%=basePath%>/js/nav.js"></script>
		<title>信息发布审核</title>
	</head>

	<body>
		<!--导航栏开始-->
			<jsp:include page="header.jsp"></jsp:include>
		<!-- 导航栏END-->
		<div class="container-fixed-md" style="position:relative; top:100px;">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h2>发布状态</h2>
				</div>
				<div class="panel-body">
					<div class="main">
						<div class="pic">
							<img src="<%=basePath%>/images/zhuangyuan.png" style="width: 30%;height: 60%;" />
						</div>
						<div>
							<div class="sendstaus">
								<h1>您的信息发布成功，正在进行审核</h2>
								<p>
								预计在3个工作日内审核完毕，请您关注站内信息。
								</p>
								<p>页面将在<span id="totalSecond" style="color: red; font-size: 25px;">5</span>s内跳转到个人中心，如未跳转请单击按钮。</p>
							</div>
							<div class="btn-group">
								<a href="<%=basePath%>/personal-center-evaluation.jsp"><button class="btn btn-lg ">返回个人中心</button></a>
								<a href="<%=basePath%>/index.jsp"><button class="btn btn-lg">返回首页</button></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- footer -->
		<jsp:include page="footer.jsp"></jsp:include>
		<script type="text/javascript" src="<%=basePath%>/js/checkLogin_regist.js"></script>
		<!-- //footer结束 -->
	</body>
<script language="javascript" type="text/javascript"> 
	var second = totalSecond.innerText;
   	setInterval("redirect()", 1000);
   	function redirect() {
   		totalSecond.innerText = --second;
   		if(second <= 0) location.href = 'index.jsp';
   	}
	</script>
</html>