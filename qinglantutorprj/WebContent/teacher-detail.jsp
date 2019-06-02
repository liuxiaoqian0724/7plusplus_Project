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
					<p>标题:炸豆腐丸子，教你小技巧，加入这两种调料拌馅，外酥里嫩，吃着香</p>
				</div>
				<div id="top" style="height:150px; width:780.5; background-color: #fff;">
					<div id="left">
						<!-- 上部头像 -->
						<img id="img-circle1" src="images/idphotocircle1.png" width="80px" height="80px" alt="圆形图片">
						<!-- 对该教师加关注 -->
						<div id="follow">
							<ul style="list-style-type:none;  background-color: #fff;">
								<li style="margin-bottom: 6px; background-color: #fff; font-size: 18px;"><span id="teachername">${teachername }</span><span style="background-color: #fff;"><button class="btn" type="button" id="button-follow" style="margin-right: 20px;"><i class="icon icon-plus"></i>关注</button></span></li>
								<li style="margin-bottom: 6px; background-color: #fff; font-size: 18px;">2019.5.7 15:40&nbsp;&nbsp;&nbsp;阅读:109&nbsp;&nbsp;&nbsp;点赞:10</li>
							</ul>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</div>
					</div>
					<div id="right">
						<ul style="list-style-type:none; background-color: #fff;">
							<li style=" background-color: #fff; font-size: 20px;">标签:</li>
							<li style="margin-bottom: 3px; background-color: #fff;"><button class="btn" type="button">生物</button><button class="btn" type="button" style="margin-left: 6px;">认证作者</button></li>
							<li style="margin-bottom: 3px; background-color: #fff;"><button class="btn" type="button" style="margin-top: 4px;">提分秘籍</button></li>
							<li style="margin-bottom: 3px; background-color: #fff;"><button class="btn" type="button" style="margin-top: 4px;">高一</button></li>
						</ul>
					</div>
				</div>
				<div id="blank"></div>
				<!-- 正文部分 -->
				<div id="Middletop">
					<p id="word">驻村大队积极的向我们展示他们近年来的成果，首先就是解决了居民的饮水问题，每家每户通自来水管，保证了居民的日常饮用水的便捷度和安全性，其次道路的硬化，每个村落的主街道都变成了柏油大道，不论是通车还是过往的行人，都便捷了许多，然后是夜晚的亮化，在村落的主干道加太阳能路灯，为村民的晚上出行提供了安全保障，除此之外，还有的村庄，填补多年来的大坑，借土填坑，修桥通路，整个村庄面貌焕然一新。
不过驻村小组表示，扶贫工作开展到目前为止，仍旧有未曾攻克的难题，比如说，建档立卡的标准无法严格考量，村民的经济难以以产业化的形式带动起来，农村的青壮年劳动力缺失，附近村庄的儿童上学难问题依旧存在，农村教育资源相对较差等等……
					</p>
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
					<div id="introduce">
						<img src="images/idphotocircle1.png" width="90px" height="90px" id="img-circle2" alt="圆形图片">
						<p id="name">NAME</p>
						<p style="background-color: #fff;" id="introducep"> 炸丸子的肉馅里最好不要加葱花，葱花容易炸糊,吃起来影响口感和颜色。炸丸子时，油烧热后用小火，下入丸子，待全部下入后，在用中火炸，这样丸子成熟度一样，不会有的熟了有的没熟，炸制期间用勺子不停地搅动，使丸子炸的颜色一致，用大火容易炸的丸子外焦里不熟。喜欢这个菜肴的做法，你学会了吗?学会了别忘了点赞、收藏、转发，也欢迎在评论区发表您的看法，或者分享您的做法，欢迎关注-勺美食，每天都会发布家常美食做法。</p>
						<button class="btn" type="button" id="reply">回复</button>
						<p id="replytimess"> 2019.5.6 15:59</p>
					</div>
					<div id="introduce">
						<img src="images/idphotocircle1.png" width="90px" height="90px" id="img-circle2" alt="圆形图片">
						<p id="name">NAME</p>
						<p style="background-color: #fff;" id="introducep"> 炸丸子的肉馅里最好不要加葱花，葱花容易炸糊,吃起来影响口感和颜色。炸丸子时，油烧热后用小火，下入丸子，待全部下入后，在用中火炸，这样丸子成熟度一样，不会有的熟了有的没熟，炸制期间用勺子不停地搅动，使丸子炸的颜色一致，用大火容易炸的丸子外焦里不熟。喜欢这个菜肴的做法，你学会了吗?学会了别忘了点赞、收藏、转发，也欢迎在评论区发表您的看法，或者分享您的做法，欢迎关注-勺美食，每天都会发布家常美食做法。</p>
						<button class="btn" type="button" id="reply">回复</button>
						<p id="replytimess"> 2019.5.6 15:59</p>
					</div>
					<div id="introduce">
						<img src="images/idphotocircle1.png" width="90px" height="90px" id="img-circle2" alt="圆形图片">
						<p id="name">NAME</p>
						<p style="background-color: #fff;" id="introducep"> 炸丸子的肉馅里最好不要加葱花，葱花容易炸糊,吃起来影响口感和颜色。炸丸子时，油烧热后用小火，下入丸子，待全部下入后，在用中火炸，这样丸子成熟度一样，不会有的熟了有的没熟，炸制期间用勺子不停地搅动，使丸子炸的颜色一致，用大火容易炸的丸子外焦里不熟。喜欢这个菜肴的做法，你学会了吗?学会了别忘了点赞、收藏、转发，也欢迎在评论区发表您的看法，或者分享您的做法，欢迎关注-勺美食，每天都会发布家常美食做法。</p>
						<button class="btn" type="button" id="reply">回复</button>
						<p id="replytimess"> 2019.5.6 15:59</p>
					</div>
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
					<textarea id="bottomtextarea" rows="2" placeholder="撰写评论...">炸丸子的肉馅里最好不要加葱花，葱花容易炸糊,吃起来影响口感和颜色。炸丸子时，油烧热后用小火，下入丸子，待全部下入后，在用中火炸，这样丸子成熟度一样，不会有的熟了有的没熟，炸制期间用勺子不停地搅动，使丸子炸的颜色一致，用大火容易炸的丸子外焦里不熟。喜欢这个菜肴的做法，你学会了吗?学会了别忘了点赞、收藏、转发，也欢迎在评论区发表您的看法，或者分享您的做法，欢迎关注-勺美食，每天都会发布家常美食做法。</textarea>
					<div id="row">
						<button class="btn" type="button" id="replyok">发表回复</button>
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