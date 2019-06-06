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
		<title>Index</title>
		<!-- css -->
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/index.css">
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
		<script src="<%=basePath%>/js/nav.js"></script>
		<!-- semantic -->
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/Semantic/components/card.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/Semantic/components/input.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/Semantic/components/message.css" />
	</head>

	<body>
		<jsp:include page="header.jsp" />
		<div class="container-fixed">
			<!--轮播图myNiceCarousel-->
			<div id="myNiceCarousel" class="carousel slide" data-ride="carousel" style="margin-top:-38px;">
				<!-- 圆点指示器 -->
				<ol class="carousel-indicators">
					<li data-target="#myNiceCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myNiceCarousel" data-slide-to="1"></li>
					<li data-target="#myNiceCarousel" data-slide-to="2"></li>
				</ol>
				<!-- 轮播项目 -->
				<div class="carousel-inner">
					<div class="item active">
						<img alt="First slide" src="<%=basePath%>/images/banner1.png">
						<div class="carousel-caption"></div>
					</div>
					<div class="item">
						<img alt="Second slide" src="<%=basePath%>/images/banner2.png">
						<div class="carousel-caption"></div>
					</div>
					<div class="item">
						<img alt="Third slide" src="<%=basePath%>/images/banner3.png">
						<div class="carousel-caption"></div>
					</div>
				</div>
				<!-- 项目切换按钮 -->
				<a class="left carousel-control" href="#myNiceCarousel" data-slide="prev">
					<span class="icon icon-chevron-left"></span>
				</a>
				<a class="right carousel-control" href="#myNiceCarousel" data-slide="next">
					<span class="icon icon-chevron-right"></span>
				</a>
			</div>
			<!--轮播图end-->

			<!--家教信息图片tutor_information_pic-->
			<div class="tutor_information_pic" style="position:relative; top:100px; z-index:999;">
				<img src="<%=basePath%>/images/hr.png" style="position:relative; width:408px; margin-left:0px; margin-top:50px; display:inline;" />
				<img src="<%=basePath%>/images/tutorinf.png" style="position:relative; margin-top:25px; margin-left:50px;" />
				<img src="<%=basePath%>/images/hr.png" style="position:relative; width:408px; margin-left:730px; margin-top:-70px;" />
			</div>
			<!--家教信息tutor_information-->
			<div class="tutor_information">
				<!--按钮choose_button-->
				<div class="btn-group" id="choose_button">
					<button type="button" class="btn btn-info">兼职家教</button>
					<button type="button" class="btn btn-info">专职家教</button>
					<button type="button" class="btn btn-info">推荐家教</button>
				</div>
				<!--个人信息personal_information-->
				<div class="cards cards-borderless" id="personal_information" style="width:100%; height:auto;">
					<!-- 教师简介 -->
					<div class="ui link cards" id="personal_name_introduce_school">

					</div>
					<!-- 分页器 -->
					<ul class="pager" id="pager1" style="width:300px; position:relative; left:41%;">

					</ul>
				</div>
			</div>
			<!--家教信息end-->

			<!--学习社区图片-->
			<div class="studycommunity">
				<img src="<%=basePath%>/images/hr.png" style="position:relative; width:408px; margin-left:0px; margin-top:50px; display:inline;" />
				<img src="<%=basePath%>/images/studycommunity.png" style="position:relative; margin-top:25px; margin-left:50px;" />
				<img src="<%=basePath%>/images/hr.png" style="position:relative; width:408px; margin-left:730px; margin-top:-70px;" />
			</div>
			<!--学习社区learning_community-->
			<div id="learning_community" class="panel">
				<!--按钮choose_button-->
				<div class="btn-group" id="choose_buttons" style="position:relative; margin-top:20px; left:40%;">
					<button type="button" class="btn btn-info" id="opt1" onclick="learning_experienceDis()">学习经验</button>
					<button type="button" class="btn btn-info" id="opt2" onclick="course_questionDis()">课程问答</button>
					<button type="button" class="btn btn-info" id="opt3" onclick="community_authorDis()">社区作者</button>
				</div>
				<!--学习经验-->
				<div id="learning_experience" class="panel" style="display:block; height:auto;">
					<div id="box1">
					
					</div>
					<!--分页-->
					<ul class="pager" id="pager2" style="margin-left:500px; width:auto;">
	
					</ul>
				</div>
				<!--课程问答-->
				<div id="course_question" style="display:none;">
					<!--问题与回答-->
					<div id="question_answer">
						<div class="items items-hover" id="qanda">
							<div class="item">
								<div class="item-heading">
									<div class="pull-right label label-success">物理</div>
									<h4><a href="###">问：请问初三物理有哪些重点</a></h4>
								</div>
								<div class="item-content">
									<div class="text" style="position: relative; padding: 5px;">电学和力学毋庸置疑是中考物理的两大重点，其中电学包括基础的电压、电流、电阻、电路知识，欧姆定律，电功率相关问题以及电学试验，大题和试验电学部分是必考考点；力学部分重点在压力压强以……</div>
								</div>
								<div class="item-footer">
									<span class="text-muted">2013-11-11 16:14:37</span>
									&nbsp;&nbsp;&nbsp;
									<span class="text-muted"><a href="#">24</a>个回答</span>
									&nbsp;&nbsp;&nbsp;
									<span class="text-muted">回答者：<a href="#">刘强</a></span>&nbsp;&nbsp;&nbsp;
									<span class="text-muted"><a href="#"><i class="icon icon-thumbs-o-up"></i>108</a></span>
								</div>
							</div>
						</div>
						<div class="items items-hover" id="qanda">
							<div class="item">
								<div class="item-heading">
									<div class="pull-right label label-success">化学</div>
									<h4><a href="###">问：请问化学方程式配平有什么好的方法</a></h4>
								</div>
								<div class="item-content">
									<div class="text">观察法适用于简单的氧化-还原方程式配平。配平关键是观察反应前后原子个数变化，找出关键是观察反应前后原子个数相等。有的氧化-还原方程看似复杂，也可根据原子数和守恒的思想利用观察法配平。经观察，由出现次数……</div>
								</div>
								<div class="item-footer">
									<span class="text-muted">2013-11-11 16:14:37</span>
									&nbsp;&nbsp;&nbsp;
									<span class="text-muted"><a href="#">24</a>个回答</span>
									&nbsp;&nbsp;&nbsp;
									<span class="text-muted">回答者：<a href="#">刘强</a></span>&nbsp;&nbsp;&nbsp;
									<span class="text-muted"><a href="#"><i class="icon icon-thumbs-o-up"></i>108</a></span>
								</div>
							</div>
						</div>
						<div class="items items-hover" id="qanda">
							<div class="item">
								<div class="item-heading">
									<div class="pull-right label label-success">生物</div>
									<h4><a href="###">问：请问蛋白质的形成</a></h4>
								</div>
								<div class="item-content">
									<div class="text">蛋白质合成不仅要有合成的场所，而且还必须有mRNA、tRNA、20种氨基酸原料和一些蛋白质因子及酶。Mg、K+离子等参与，并由ATP、GTP提供能量，合成中mRNA是编码2合成蛋白质的模板，tRNA是识别密码子，转……</div>
								</div>
								<div class="item-footer">
									<span class="text-muted">2013-11-11 16:14:37</span>
									&nbsp;&nbsp;&nbsp;
									<span class="text-muted"><a href="#">24</a>个回答</span>
									&nbsp;&nbsp;&nbsp;
									<span class="text-muted">回答者：<a href="#">刘强</a></span>&nbsp;&nbsp;&nbsp;
									<span class="text-muted"><a href="#"><i class="icon icon-thumbs-o-up"></i>108</a></span>
								</div>
							</div>
						</div>
						<div class="items items-hover" id="qanda">
							<div class="item">
								<div class="item-heading">
									<div class="pull-right label label-success">数学</div>
									<h4><a href="###">问：排列组合的概念</a></h4>
								</div>
								<div class="item-content">
									<div class="text">所谓排列组合问题，就是从n个不同元素中选取m个元素按照一定的顺序排成一列，就叫做从n个不同元素中取出m个元素的一个排列；从n个不同元素中取出m(m≤n）个元素的所有排列的个数，叫做从n个不同元素中取出m个……</div>
								</div>
								<div class="item-footer">
									<span class="text-muted">2013-11-11 16:14:37</span>
									&nbsp;&nbsp;&nbsp;
									<span class="text-muted"><a href="#">24</a>个回答</span>
									&nbsp;&nbsp;&nbsp;
									<span class="text-muted">回答者：<a href="#">刘强</a></span>&nbsp;&nbsp;&nbsp;
									<span class="text-muted"><a href="#"><i class="icon icon-thumbs-o-up"></i>108</a></span>
								</div>
							</div>
						</div>
						
					</div>
					<!--优秀回答者-->
					<div class="panel" id="goodresponder">
						<div class="panel-body">
							<h3>优秀回答者</h3>
							<a href="#"><img src="<%=basePath%>/images/idphotocircle1.png" style="position: relative;margin-left: 10px;"></a>
							<a href="#" style="position: relative;margin-left: 36px;"><img src="<%=basePath%>/images/idphotocircle2.png"></a>
							<p></p>
							<a href="#"><img src="<%=basePath%>/images/idphotocircle3.png" style="position: relative;margin-left: 10px;"></a>
							<a href="#" style="position: relative;margin-left: 36px;"><img src="<%=basePath%>/images/idphotocircle1.png"></a>
							<p></p>
							<a href="#"><img src="<%=basePath%>/images/idphotocircle2.png" style="position: relative;margin-left: 10px;"></a>
							<a href="#" style="position: relative;margin-left: 36px;"><img src="<%=basePath%>/images/idphotocircle3.png"></a>
							<p></p>
							<a href="#"><img src="<%=basePath%>/images/idphotocircle3.png" style="position: relative;margin-left: 10px;"></a>
							<a href="#" style="position: relative;margin-left: 36px;"><img src="<%=basePath%>/images/idphotocircle1.png"></a>
						</div>
					</div>
					
					<!--分页-->
					<ul class="pager" id="pager5" data-ride="pager" data-page="1" data-rec-total="89" data-max-nav-count="4"
					 data-elements="prev_icon,page_of_total_text,next_icon" style="margin-left:500px;">
	
					</ul>
				</div>
				<!--社区作者-->
				<div id="community_author" style="display:none;">
					<div id="box2">
					
					</div>
					
					<!--分页-->
					<ul class="pager" id="pager3" style="margin-left:500px;">
		
					</ul>
				</div>
			</div>
			<!--学习社区end-->
		</div>
		</div>
		<script type="text/javascript" src="<%=basePath%>/js/index.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/checkLogin_regist.js"></script>
		<jsp:include page="footer.jsp" />
	</body>
</html>