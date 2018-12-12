<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="dist/css/zui.css" />
		<link rel="stylesheet" type="text/css" href="css/personal-center.css">
		<link rel="stylesheet" type="text/css" href="css/student-mycourse.css">
		<link rel="stylesheet" type="text/css" href="css/header.css"/>
		<link rel="stylesheet" type="text/css" href="css/footer.css"/>
		
		<!-- ZUI Javascript 依赖 jQuery -->
		<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
		<!-- ZUI 标准版压缩后的 JavaScript 文件 -->
		<script type="text/javascript" src="dist/js/zui.min.js"></script>
		
		<script type="text/javascript" charset="utf-8" src="textarea/ueditor.config.js"></script>
    	<script type="text/javascript" charset="utf-8" src="textarea/ueditor.all.min.js"> </script>
    	<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    	<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    	<script type="text/javascript" charset="utf-8" src="textarea/lang/zh-cn/zh-cn.js"></script>
		
		<style type="text/css">
		  #inputSearchExample3{
		    width: 228.67px;
		  }
		  .input-group-btn{
		    display: block;
		    width: 52px;
		    height: 32px;
		  }
		  #header-login > span:first-of-type{
		    margin-left: -10px;
		  }
		  #header-login > span:last-of-type{
		    margin-left: -10px;
		  }
		</style>
	<title>学生，我的课程</title>
</head>
<body>
<!-- 头部 -->
<div id="head">
    <div id="header-box">
    <div id="big-box">
      <!-- logo -->
      <div id="top-box">
        <div id="top-box-logo">
          <img src="images/headerlogo.png" alt="logo" id="logoPic">
          <div id="name-pic"><img src="images/nameTop.png" alt="namePic" style="width: 263.3px;height:66px;"></div>
        </div>
      </div>
    </div>
      <!-- 下拉菜单 -->
      <div id="bottom-box">
        <div id="topBox2">
          <ul id="navFont">
          <li class="navFont1"><a href="#">首页</a></li>
          <li><a href="#">家教</a>
            <ul>
              <li><a href="#">小学</a></li>
              <li><a href="#">初中</a></li>
              <li><a href="#">高中</a></li>
            </ul>
          </li>
          <li><a href="#">论坛社区</a>
            <ul>
              <li><a href="#">学霸说</a></li>
              <li><a href="#">资料库</a></li>
              <li><a href="#">家长岛</a></li>
            </ul>
          </li>
          <li><a href="#">我要提问</a>
            <ul>
              <li><a href="#">心理困惑</a></li>
              <li><a href="#">情感问题</a></li>
              <li><a href="#">学习障碍</a></li>
            </ul>
          </li>
          <li><a href="#">个人中心</a></li>
        </ul>
      <!-- 搜索框 -->
      <!-- <div id="searchPart">
          <form id="partForm">
            <input type="text" value="请输入您要搜索的科目" id="partInput" autofocus="autofocus" />
            <input type="submit" id="search_btn" name="heder-submit" value="搜索" />
          </form>
        </div> -->
        <div class="input-group">
            <div class="input-control search-box search-box-circle has-icon-left has-icon-right search-example" id="searchboxExample">
              <input id="inputSearchExample3" type="search" class="form-control search-input" placeholder="搜索">
              <label for="inputSearchExample3" class="input-control-icon-left search-icon"><i class="icon icon-search"></i></label>
            </div>
          <span class="input-group-btn">
            <button class="btn btn-primary" type="button">搜索</button>
          </span>
      </div>
        <!-- 登录注册 -->
        <div id="header-login">
          <span><a href="#">登录</a></span>
          <!-- <span>/</span> -->
          <span><a href="#">注册</a></span>
        </div>
      </div>
      </div>
  </div>
</div>

<!-- 中部 -->
<div id="content">
    <div id="c1">
      <ul>
        <li id="c1-img">
          <div><img src="http://zui.sexy/docs/img/img2.jpg" width="120px" height="120px" class="img-circle" alt="圆形图片"></div>
          <p>积分：1024</p>
        </li>
        <li id="c1-about">
          <p>狗蛋</p>
          <span class="label label-badge">认证家教</span>
          <span class="label label-badge">大三</span>
        </li>
        <li id="c1-person">
          <p id="c1-person-p1">个人介绍</p>
          <p id="c1-person-p2">
            &nbsp;&nbsp;123123123123123fjhakjfhadjfhakjfhfjhlllllllllllllllllllaaaaa
          </p>
        </li>
        <li id="c1-star">
          <p id="c1-star-p1">学员评分</p>
          <div id=c1-star-div>
            <img src="images/fill-star.png" style="width: 25px;height: 25px;">
            <img src="images/fill-star.png" style="width: 25px;height: 25px;">
            <img src="images/fill-star.png" style="width: 25px;height: 25px;">
            <img src="images/fill-star.png" style="width: 25px;height: 25px;">
            <img src="images/empty-star.png" style="width: 25px;height: 25px;">
            <form>
              <input type="submit" name="查看详情" value="查看详情">
            </form>
          </div>
        </li>
      </ul>
    </div>
    <div id="c2">
      <div class="c2" id="c2-left">
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-envelope"></i>&nbsp;我的消息<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="i2con icon-book"></i>&nbsp;我的课程<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-flag"></i>&nbsp;学员评价<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-newspaper-o"></i>&nbsp;我的文章<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-question-sign"></i>&nbsp;我的问答<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-wrench"></i>&nbsp;个人资料<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-stack"></i>&nbsp;我的教案<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-file-text-o"></i>&nbsp;我的作业<i class="icon icon-chevron-right"></i></a></div>
      </div>
      <div class="c2 panel" id="c2-right">
        <div class="panel-heading">
          <h2>我的课程</h2>
        </div>
        <div class="panel-body">
        	<c:forEach items="${courseDetailList }" var="courseInformation">		          
        		<div  class="c2-right-item"> 
		              <ul>
		                <li>
		                  <span>科目</span>
		                  <p>${courseInformation.subject }</p>
		                </li>
		                <li>
		                  <span>老师</span>
		                  <div>
		                    <img src="${courseInformation.img }" width="115px" height="115px" class="img-circle" alt="圆形图片">
		                  </div>
		                  <p>${courseInformation.name }</p>
		                </li>
		                <li>
		                  <span>未完成作业</span><br>
		                  <span style="text-align: center; ">老师发布时间</span><br><br>
		                  	<c:forEach items="${courseInformation.homework }" var="homeworkTime">
		                  		<p>${homeworkTime }</p>
		                  	</c:forEach> 
		                </li>
		                <li>
		                  <span>课程时间</span><br><br>
		                  <div>
		                    <span class="course-time1">${courseInformation.startTime }</span>
		                    <span>~~</span>
		                    <span class="course-time1">${courseInformation.endTime }</span>
		                  </div>
		                </li>
		                <li>
		  <script type="text/javascript" src="js/stumycourse.js"></script> 
		                  <form action="#" method="post">
		                    <input type="button" name="detail" value="课程反馈" onclick="reviewClick(${courseInformation.crid})" />
		                 </form>
		                  <form action="HomeWorkShow" method="post">
		                    <input type="button" name="detail" value="查看作业">
		                  </form>
		                  <form action="#" method="post">
		                    <input type="submit" name="detail" value="查看文案">
		                  </form>
		                </li>
		              </ul>
		          </div>
        	</c:forEach>
          
        </div>
        <div id="review" class="white_content">
        	<a href = "javascript:void(0)" onclick = "reviewClose()"><i class="icon icon-times"></i></a><br><br>
		   	<div>
		   		<span>评价星级： </span>
		   		<a href="javascript:click(1)"><img src="images/empty-star.png" id="star1" onMouseOver="over(1)" onMouseOut="out(1)"/></a>
				<a href="javascript:click(2)"><img src="images/empty-star.png" id="star2" onMouseOver="over(2)" onMouseOut="out(2)" /></a>
				<a href="javascript:click(3)"><img src="images/empty-star.png" id="star3" onMouseOver="over(3)" onMouseOut="out(3)" /></a>
				<a href="javascript:click(4)"><img src="images/empty-star.png" id="star4" onMouseOver="over(4)" onMouseOut="out(4)"/></a>
				<a href="javascript:click(5)"><img src="images/empty-star.png" id="star5" onMouseOver="over(5)" onMouseOut="out(5)"/></a>
		   	</div>
		   	<textarea rows="7" cols="70"></textarea>
			<span>请评价星级</span>
			<button type="button" onclick="reviewSubmit()">发出评价</button>
        </div>
        <div id="fade" class="black_overlay"></div>
      </div>
    </div>
</div>
 <div class="footer">
    <!-- 关于网页 -->
    <div class="footer-font">
      <div id="footer-font-about">
        <div id="about-title"><h3 class="font-h3">关于青蓝</h3></div>
        <div id="about-font"><p class="footer-words">
          青蓝家教旨在为大学生和家长提供真实可靠的家教信息发布、家教过程约束和学情分析平台。大学生家教在平台上注册并发布家教信息，家教在线上记录孩子的每次学习情况用于记录分析，并且可以给孩子提供线上辅导功能，家长可即时查看情况，更加了解孩子的学情。同时平台还为家长和家教提供论坛交流区，用于资料交流和分享。
        </p></div>
      </div>
      <div id="footer-font-a">
        <div id="a-title"><h3 class="font-h3">链接</h3></div>
        <div id="a-font">
          <a href="#" class="footer-words">加入我们</a>
          <a href="#" class="footer-words">网站须知</a>
          <a href="#" class="footer-words">意见反馈</a>
          <a href="#" class="footer-words">免责声明</a>
        </div>
      </div>
      <div id="footer-font-friend">
        <div id="friend-title"><h3 class="font-h3">鸣谢伙伴</h3></div>
        <div id="friend-logo">
          <div id="friend-logo-div1">
            <i class="icon icon-github icon-3x" ></i>
            <i class="icon icon-qq icon-3x"></i>
            <i class="icon icon-wechat icon-3x"></i>
          </div>
        </div>
      </div>
      <div id="footer-font-img">
        <div id="footer-font-img-font"><h3>扫码关注我们了解更多</h3></div>
        <img src="images/code.png" id="QRcode">
    </div>
  </div>

  <!-- 权利归属 -->
    <div id="footer-right">
      <div id="footer-right-font">
        <p>
          <br>
          <a href="#" id="footer-right-font-a1">Copyright 2018-2020&nbsp;&nbsp;&nbsp;青蓝家教</a>
          <a href="#" id="footer-right-font-a1">Copyright 2018-2020&nbsp;&nbsp;&nbsp;青蓝家教</a>
            <a href="#" id="footer-right-font-a2">冀ICP备05067795号  冀公网安备110402440008号 </a>
          </p>
      </div>
    </div>
  </div>	
	
</body>
</html>