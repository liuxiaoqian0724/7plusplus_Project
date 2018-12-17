<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<title>我的作业</title>
	<base href="<%=basePath%>">
	<!-- ZUI 标准版压缩后的 CSS 文件 -->
<link rel="stylesheet" href="dist/css/zui.min.css">
<link rel="stylesheet" type="text/css" href="css/personal-center.css">
<link rel="stylesheet" type="text/css" href="css/student-homework.css">
<link rel="stylesheet" type="text/css" href="css/header.css"/>
<link rel="stylesheet" type="text/css" href="css/footer.css"/>

<!-- ZUI Javascript 依赖 jQuery -->
<script src="dist/lib/jquery/jquery.js"></script>
<!-- ZUI 标准版压缩后的 JavaScript 文件 -->
<script src="dist/js/zui.min.js"></script>


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

<meta charset="utf-8">
</head>
<body>
<!-- 头部 -->
<jsp:include page="header.jsp"></jsp:include>
<script>
        var search = document.getElementById("partInput");
        search.onfocus = function(){
            search.value="";
        }
</script>
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
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-book"></i>&nbsp;我的课程<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-flag"></i>&nbsp;学员评价<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-newspaper-o"></i>&nbsp;我的文章<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-question-sign"></i>&nbsp;我的问答<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-wrench"></i>&nbsp;个人资料<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-stack"></i>&nbsp;我的教案<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-file-text-o"></i>&nbsp;我的作业<i class="icon icon-chevron-right"></i></a></div>
      </div>
      <div class="c2 panel" id="c2-right">
        <div class="panel-heading">
          <h2>我的作业</h2>
        </div>
	      
        <div class="panel-body">
      
       
        	<c:forEach  items="${homework }" var="h">
           <div>	
           	 <c:forEach items="${teachers }" var="t">
           		<c:if test="${t.id==1}">
           		
	              <div class="c2-right-left">
	                  <img src="${t.userImg}" width="115px" height="115px" class="img-circle" alt="圆形图片">
	                  <p>${t.userName}</p>
	                  <button>${h.sstatus}</button>
	                
	              </div>
             	 </c:if>
              </c:forEach>
           
              <div class="c2-right-right">
                  <div>
                      <h3>任务一 力学</h3>
                      <p>${h.tcontent}</p>
                      <span>${h.tstartTime}</span>
                  </div>
                  <button type="button"><a href="#">查看详情</a></button>
                   <button type="submit"><c:if test="${h.sstatus == '未完成'}"><a href="WorkComplete">完成作业</a></c:if></button>
              </div>
              
           </div>
          
           </c:forEach >
          
           
       
        </div>
        
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