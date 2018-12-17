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
	<title>家教信息列表</title>
	<meta charset="utf-8">
	<!--  <base href="<%=basePath%>"></base>-->
	<link rel="stylesheet" type="text/css" media="screen" href="https://cdn.staticfile.org/ionicons/2.0.1/css/ionicons.min.css">
	<!--引入css-->
   <link rel="stylesheet" href="<%=basePath%>/dist/css/zui.min.css">
   <link rel="stylesheet" href="<%=basePath%>/dist/css/zui.css" />
   <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/header.css"/>
   <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/footer.css"/>
   <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/tutorlisted.css">
	
	<!--引入js-->
   <script src="<%=basePath%>/js/jquery-3.2.1.js"></script>
   <script type="text/javascript" src="<%=basePath%>/dist/lib/jquery/jquery.js"></script>
   <script type="text/javascript" src="<%=basePath%>/dist/js/zui.min.js"></script>
   <script type="text/javascript" src="<%=basePath%>/dist/js/zui.js"></script>
   <script type="text/javascript" src="<%=basePath%>/js/tutorlisted.js"></script>

</head>
<body>
<!-- header -->
<jsp:include page="header.jsp"/>
<!-- //header -->
<div class="content">
	<!--条件筛选-->
	<div class="content-top">
		<div class="title">
			<div class="title-title"><h3>全部老师&nbsp;&nbsp;&nbsp;></h3></div>
			<ul class="title-ul">
 				<!-- <li class="title-condition">数学 &nbsp;
 					<i class="icon1 ion-close"></i></li> -->
 				<c:forEach items="${conditions}" var="condition" varStatus="status">
  				 	<c:if test="${condition!='0'}" >
 						<c:if test="${status.index==1}">
	 						<li class="title-condition">${condition} &nbsp;
	 						<a href="/qinglantutorprj/change/deleteconditions/0/1/1/1/1"><i class="icon1 ion-close"></i></a></li>
 						</c:if>
 						<c:if test="${status.index==2}">
	 						<li class="title-condition">${condition} &nbsp;
	 						<a href="/qinglantutorprj/change/deleteconditions/1/0/1/1/1"><i class="icon1 ion-close"></i></a></li>
 						</c:if>
 						<c:if test="${status.index==3}">
	 						<li class="title-condition">${condition} &nbsp;
	 						<a href="/qinglantutorprj/change/deleteconditions/1/1/0/1/1"><i class="icon1 ion-close"></i></a></li>
 						</c:if>
 						<c:if test="${status.index==4}">
	 						<li class="title-condition">${condition} &nbsp;
	 						<a href="/qinglantutorprj/change/deleteconditions/1/1/1/0/1"><i class="icon1 ion-close"></i></a></li>
 						</c:if>
 						<c:if test="${status.index==5}">
	 						<li class="title-condition">${condition} &nbsp;
	 						<a href="/qinglantutorprj/change/deleteconditions/1/1/1/1/0"><i class="icon1 ion-close"></i></a></li>
 						</c:if>
 					</c:if>
 				</c:forEach>
				<a href="/qinglantutorprj/change/deleteconditions/0/0/0/0/0"><li id="spe3">清空筛选项</li></a>
			</ul>

		</div>		<br>
		<div class="content-conditions">
			<ul class="conditions">
				<li class="con-content">
					<!-- <div class="ul"> -->
					<ul class="con-ul">
						<li class="spe">
							授课年级
						</li>
						<c:forEach items="${grades}" var="grade">
							<a href="/qinglantutorprj/change/addconditions/${grade[1]}/0/0/0/0">
							<li class="con-li">
								${grade[1]}
							</li></a>
						</c:forEach>
						<a href="#"><li id="more">
							更多<i class="icon11 icon-angle-down"></i>
						</li></a>
						
					</ul>
					<!-- </div> -->					
				</li>

				<li class="hide-con-content">
					<ul class="con-ul">
						<a href="#"><li class="con-li">
							高一
						</li></a>
						<a href="#"><li class="con-li">
							高二
						</li></a>
						<a href="#"><li class="con-li">
							高三
						</li></a>
					</ul>
				</li>
				<div class="dashed"></div>
				<li class="con-content">
					<ul class="con-ul">
						<li class="spe">
							教学科目
						</li>
						<!--后台循环-->
						<c:forEach items="${courses}" var="course">
							<a href="/qinglantutorprj/change/addconditions/0/${course[1]}/0/0/0">
							<li class="con-li">
							${course[1]}
							</li></a>
						</c:forEach> 
						<a href="#"><li id="more1">
							更多<i class="icon11 icon-angle-down"></i>
						</li></a>
					</ul>
				</li>
				<li class="hide-con-content1">
					<ul class="con-ul">
						<a href="#"><li class="con-li">
							音乐
						</li></a>
						<a href="#"><li class="con-li">
							美术
						</li></a>
					</ul>
				</li>
				<div class="dashed"></div>
				<li class="con-content">
					<ul class="con-ul">
						<li class="spe">
							上门区域
						</li>
						<!--后台循环-->
						<a href="/qinglantutorprj/change/addconditions/0/0/长安区/0/0"><li class="con-li">
							长安区
						</li></a>
						<a href="/qinglantutorprj/change/addconditions/0/0/裕华区/0/0"><li class="con-li">
							裕华区
						</li></a>
						<a href="/qinglantutorprj/change/addconditions/0/0/新华区/0/0"><li class="con-li">
							新华区
						</li></a>
						<a href="/qinglantutorprj/change/addconditions/0/0/桥西区/0/0"><li class="con-li">
							桥西区
						</li></a>
						<a href="/qinglantutorprj/change/addconditions/0/0/鹿泉区/0/0"><li class="con-li">
							鹿泉区
						</li></a>
						<a href="/qinglantutorprj/change/addconditions/0/0/井陉矿区/0/0"><li class="con-li">
							井陉矿区
						</li></a>

					</ul>
				</li>
				<div class="dashed"></div>
				<li class="con-content">
					<ul class="con-ul">
						<li class="spe">
							老师性别
						</li>
						<!--后台循环-->
						<a href="/qinglantutorprj/change/addconditions/0/0/0/男老师/0"><li class="con-li">
							男老师
						</li></a>
						<a href="/qinglantutorprj/change/addconditions/0/0/0/女老师/0"><li class="con-li">
							女老师
						</li></a>
					</ul>
				</li>
				<div class="dashed"></div>
				<li class="con-content">
					<ul class="con-ul">
						<li class="spe">
							老师专业
						</li>
						<!--后台循环-->
						<a href="/qinglantutorprj/change/addconditions/0/0/0/0/文科"><li class="con-li">
							文科
						</li></a>
						<a href="/qinglantutorprj/change/addconditions/0/0/0/0/理科"><li class="con-li">
							理科
						</li></a>
					</ul>
				</li>
				<div class="dashed"></div>
			</ul>
		</div>
	</div>
	<!--内容中间部分-->
	<div class="content-middle">
		<!--内容左半部分——家教展示列表-->
		<div class="middle-left">
			<div class="left-top">
				<ul class="top-ul">
					<li id="spe1">符合条件老师</li>
					<a href="#"><li class="top-li">智能排序 </li></a>
					<a href="#"><li class="top-li">好评数 </li></a>
					<a href="#"><li class="top-li">价格最高 </li></a>
					<a href="#"><li class="top-li">星级最高 </li></a>
					<a href="#"><li class="top-li">教过的学生最多 </li></a>
				</ul>
			</div>
			<!--家教列表展示-->
			<div class="tutorshow">
				<!--一个家教展示-->
				<!--foreach循环每个家教的信息-->
				<c:forEach items="${tutors}" var="tutor">
					<a href="tutordetailed.html">
					<div class="tutorone">
						<div class="tutorinformation">
						<!--家教头像-->
						<div class="tutor-photo">
							<img src="<%=basePath%>/images/${tutor[2]}" width="110px" height="110px" class="img-rounded" alt="圆角图片">
						</div>
						<!--家教基本信息-->
						<div class="tutor-information">
							<div class="username">
								${tutor[1]}
							</div>
							<div class="introduce">
								<p>${tutor[3]}</p>
							</div>
							<div class="information">
								<div class="firline">
									<div class="star">
										<img src="<%=basePath%>/images/fill-star.png" style="width: 20px;height: 20px;">
										<img src="<%=basePath%>/images/fill-star.png" style="width: 20px;height: 20px;">
										<img src="<%=basePath%>/images/fill-star.png" style="width: 20px;height: 20px;">
										<img src="<%=basePath%>/images/fill-star.png" style="width: 20px;height: 20px;">
										<img src="<%=basePath%>/images/empty-star.png" style="width: 20px;height: 20px;">
									</div>
									<div class="teachages">教龄${tutor[5]}年</div>	
									<!-- <div class="teachhours">授课134小时</div> -->
								</div>
							</div>
						</div>
						<!--家长评论-->
						<div class="tutor-comment">&nbsp;<i class="icon2 icon-comment-alt"></i>&nbsp;<span>家长评论&nbsp;${tutor[7]}条</span>
							<p>${tutor[8]}</p>
						</div>
						<div class="separator"></div>
						<div class="tutor-check">
							<div class="price"><i class="icon22 icon-yen"></i>${tutor[4]}<span class="spe2">起</span></div>
							<div class="check">
								<a href="tutordetailed.html"><button class="btn1" type="button">立即查看</button></a>
							</div>
						</div>
						</div>
					</div>
					</a>
				</c:forEach>	
				
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
		<!--内容右半部分 空闲区域-->
		<div class="middle-right">
			<div class="right-title">
				推荐家教
			</div>
			<!--foreach循环-->
			<!--一个家教-->
			<div class="recommended">
				<div class="recommend-left">
				<!--照片-->
					<div class="re-photo">
						<img src="http://zui.sexy/docs/img/img2.jpg" width="80px" height="80px" class="img-circle" alt="圆形图片">
					</div>
					<!--名字-->
					<div class="re-name">
						李老师
					</div>
				</div>
				<!-- <div class="re-tag">
					优秀教师
				</div> -->
				<div class="recommend-right">
					<!--介绍-->
					<div class="re-introduce">
						家教介绍	:教学经验丰富，课堂生动幽默，综合点拨提高。
					</div>
					<div class="re-grade">
						学员评分:95
					</div>
					<!--家教时长-->
					<!-- <div class="re-hour">
						家教时长：100小时
					</div> -->
					<!--地区-->
					<!--地区通过数据库查-->
					<div class="re-region">
						<i class="icon ion-ios-location"></i>&nbsp;&nbsp;裕华区
					</div>
					<div class="re-detail"><a href="tutordetailed.html">详情</a></div>
				</div>
			</div>
			<div class="recommended">
				<div class="recommend-left">
				<!--照片-->
					<div class="re-photo">
						<img src="http://zui.sexy/docs/img/img2.jpg" width="80px" height="80px" class="img-circle" alt="圆形图片">
					</div>
					<!--名字-->
					<div class="re-name">
						李老师
					</div>
				</div>
				<!-- <div class="re-tag">
					优秀教师
				</div> -->
				<div class="recommend-right">
					<!--介绍-->
					<div class="re-introduce">
						家教介绍	:教学经验丰富，课堂生动幽默，综合点拨提高。
					</div>
					<div class="re-grade">
						学员评分:95
					</div>
					<!--家教时长-->
					<!-- <div class="re-hour">
						家教时长：100小时
					</div> -->
					<!--地区-->
					<!--地区通过数据库查-->
					<div class="re-region">
						<i class="icon ion-ios-location"></i>&nbsp;&nbsp;裕华区
					</div>
					<div class="re-detail"><a href="tutordetailed.html">详情</a></div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- header -->
<jsp:include page="footer.jsp"/>
<!-- //header -->
</body>
</html>