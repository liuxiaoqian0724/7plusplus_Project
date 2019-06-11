<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
   <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/header.css"/>
		<link rel="stylesheet" type="text/css" href="css/footer.css"/>
		<link rel="stylesheet" type="text/css" href="css/detail.css">
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
		<title></title>
	</head>
	<body>
		
		<div id="main">
		<!-- 头部 -->
		<jsp:include page="header.jsp"></jsp:include>
		<!-- 中部 -->
			<div id="d1">
				
				<!-- 个人资料 -->
				<c:forEach  items="${usr }" var="u">
				<div class="usr">
				
					<div id="name">
						<div class="to">
							<img id="imh" src="${u.stuImg}" alt="头像">
						</div>
						<div id="username">用户名称${u.userName}</div>
						<div id="follower">粉丝数&nbsp;&nbsp;</div>
					</div>
					<div id="infor">
						<ul>
							<div class="label1">${u.major}</div>
							<div class="label1">${u.school}</div>
							
						</ul>
					</div>
					<div id="score">
						<div id="s1">
							学员评分
						</div>
						<div id="star"></div>
						<div  class="label2" ><a href="#" > 查看详情</a></div>
					</div>
					<div id="message">
						<ul>
							<div class="message">+关注</div>
							<div class="message">发消息</div>
							
						</ul>
					</div>
					 
				</div>
				<!-- 个人资料 -->
				
				<!-- 个人简介 -->
				
				<div id="profile">
					<div id="p1">个人简介</div>
					<div id="p2">
						<p><span id="td">&nbsp;&nbsp;&nbsp;&nbsp;${u.introduce}</span></p>
					</div>
				</div>
				<!-- 个人简介 -->
				</c:forEach>
				<!-- 回答/文章切换 -->
				<div class="btn-group1">
				  <button type="button" class="btn_btn-lg1" id="answer">他的文章</button>
				  <button type="button" class="btn_btn-lg1" id="mytext">他的回答</button>
				</div>
				<!-- 回答/文章切换 -->
				<c:forEach items="${answer}" var="r">
				<!-- 回答/文章页面 -->
				<div id="content">
					<div class="usr1">
						<div class="im"><img src="" alt=""> </div>
						<div class="text">
							<div class="title">The Is Tiltle</div>
							<div class="content"><p>${r.rContent }</p></div>
							<div class="time">${r.rTime }</div>
							<div class="comment">
								<img src="images/right.jpg" class="like" alt="">&nbsp;&nbsp;19 
								<img src="images/comm.png" class="comm" alt="">&nbsp;&nbsp;19
							</div>
						</div>
					</div>
					
					
					
				</div>
				</c:forEach>
				<!-- 文章 -->
				
				<div id="content1">
				<c:forEach items="${article}" var="a">
					<div class="usr1">
						
						<div class="text1">
							<div class="title">${a.title }</div>
							<div class="content1"><p>${a.content }</p></div>
							<div class="time">${a.sendTime }</div>
							<div class="comment">
								<img src="images/right.jpg" class="like" alt="">&nbsp;&nbsp;${a.likeCount } 
								<img src="images/comm.png" class="comm" alt="">&nbsp;&nbsp;19
							</div>
						</div>
					</div>
					
					
				</c:forEach>
				</div>
				
				<!-- 回答/文章页面 -->
				
				<!-- 分页 -->
				<ul class="pager" style="position:absolute;bottom:0;left:300px;margin-bottom:10px;" >
       			<c:choose>
       				<c:when test="${page == 1 }">
       					<li class="previous disabled"><a href="jump">«</a></li>
       				</c:when>
       				<c:otherwise>
       					<li class="previous"><a href="courseJump?page=${page-1 }">«</a></li>
       				</c:otherwise>
       			</c:choose>
			  	<li><div style="width:105px;height:30px;text-align:center;padding-top:2px;font-size:18px;">第${page }/${pagenum }页</div></li>
			  	<c:choose>
       				<c:when test="${page == pagenum}">
       					<li class="previous disabled"><a href="jump">»</a></li>
       				</c:when>
       				<c:otherwise>
       					<li class="next"><a href="courseJump?page=${page+1 }">»</a></li>
       				</c:otherwise>
       			</c:choose>
			  
			</ul>
				
				
			</div>
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</body>
	
  <script type="text/javascript" src="js/checkLogin_regist.js"></script>
	<script type="text/javascript">
		var answer= document.getElementById('answer');
		var mytext= document.getElementById('mytext');
		var con=document.getElementById('content');
		var con1=document.getElementById('content1');
		answer.onclick = function () {
			con.style.display="block";
			con1.style.display="none";
		}
		mytext.onclick=	function () {
			con1.style.display="block";
			con.style.display="none";
		}
		
	// body...

	</script>
</html>
