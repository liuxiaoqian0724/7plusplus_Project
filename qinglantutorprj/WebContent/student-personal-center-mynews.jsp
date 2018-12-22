<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>我的消息</title>
	<!-- ZUI 标准版压缩后的 CSS 文件 -->
<link rel="stylesheet" href="css/zui.min.css">
<link rel="stylesheet" type="text/css" href="css/personal-center.css">
<link rel="stylesheet" type="text/css" href="css/student-mynews.css">
<link rel="stylesheet" type="text/css" href="css/header.css"/>
<link rel="stylesheet" type="text/css" href="css/footer.css"/>

<!-- ZUI Javascript 依赖 jQuery -->
<script src="lib/jquery/jquery.js"></script>
<!-- ZUI 标准版压缩后的 JavaScript 文件 -->
<script src="js/zui.min.js"></script>


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
<script>
        var search = document.getElementById("partInput");
        search.onfocus = function(){
            search.value="";
        }
</script>
<!-- 中部 -->
<div id="content">
    <!-- 通用personaltop部分 -->
<c:forEach items="${personal}" var="x">
    <div id="c1">
      <ul>
        <li id="c1-img">
          <div><img src="http://zui.sexy/docs/img/img2.jpg" width="120px" height="120px" class="img-circle" alt="圆形图片"></div>
          <p>积分：1024</p>
        </li>
        <li id="c1-about">
          <p>${x.userName}</p>
          <span class="label label-badge">${x.school}</span>
          <span class="label label-badge">${x.major}</span>
        </li>
        <li id="c1-person">
          <p id="c1-person-p1">个人介绍</p>
          <p id="c1-person-p2">
            &nbsp;&nbsp;${x.introduce}
          </p>
        </li>
        <li id="c1-star">
          <p id="c1-star-p1">学员评分 :${finalstarfull}</p>
          
          <div id=c1-star-div>
          	<c:forEach items="${personalstar}" var="a">
           	<img src="images/<c:out value="${a}"/>.png" style="width: 30px;height: 30px;">
            <!-- <img src="images/fill-star.png" style="width: 25px;height: 25px;"> -->
             </c:forEach> 
            <form>
              <input type="button" name="查看详情" value="查看详情" style="disable:ture; outline:none;">
            </form>
          </div>
        </li>
      </ul>
    </div>
    </c:forEach>
    
    
    <div id="c2">
      <div class="c2" id="c2-left">
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-envelope"></i>&nbsp;我的消息<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-book"></i>&nbsp;我的课程<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-flag"></i>&nbsp;我的评价<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-newspaper-o"></i>&nbsp;我的文章<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-question-sign"></i>&nbsp;我的问答<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-wrench"></i>&nbsp;个人资料<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-stack"></i>&nbsp;我的教案<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-file-text-o"></i>&nbsp;我的作业<i class="icon icon-chevron-right"></i></a></div>
      </div>
       <div class="c2 panel" id="c2-right">
        <div class="panel-heading">
          <h2>我的消息</h2>
        </div>
        <div class="panel-body">
        <c:forEach items="${news}" var="x"> 
          <div>
          
            <div class="c2-left-item1">
              <img src="images/${x.userimg}.jpg" class="img-circle" alt="圆形图片"><br>
              <span>${x.username}</span>
            </div>
            <div class="c2-left-item2">
              <h3>${x.cutContent}<span>${x.sendtime}</span></h3>
              <p id="somenews2">${x.content}</p>
            </div>
            <button type="button" class="c2-left-item3">
                 <a href = "javascript:void(0)" onclick = "buttontime(2)">查看详情</a>
            </button>
          </div>
          </c:forEach>
          <div>
          
            <div class="c2-left-item1">
              <img src="images/b.jpg" class="img-circle" alt="圆形图片"><br>
              <span>admin</span>
            </div>
            <div class="c2-left-item2">
              <h3>有关您的个人详情页的问题<span>new DateTime()</span></h3>
              <p id="somenews3">一般来说，这种需要保存当前状态的结构，比如导航，tab，幻灯片切换等等，你的页面要跳转到其他页面，你需要将index传递给其他页面，告诉另外一个页面第index个按钮需要高亮，态的结构，比，你的页面要跳转到其他页面，你需要将index传递给其他页面，告诉另外一个页面第index个按钮需要高亮</p>
            </div>
            <button type="button" class="c2-left-item3">
                      <a href = "javascript:void(0)" onclick = "buttontime(3)">查看详情</a>
            </button>
          </div>
        </div>
        <div id="light" class="white_content">
                <a href = "javascript:void(0)" onclick = "document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'"><i class="icon icon-times"></i></a><br><br>
                <p id="allnews"></p>
                <button type="button" id="refuse" onclick="buttontime(1)">拒绝</button>
                <button type="button" id="agree" onclick="buttontime(0)">同意</button>
                <p id="answer"></p>
        </div> 
        <div id="fade" class="black_overlay"></div> 
        <script type="text/javascript">
            function buttontime(i){
              var a = 0;
              if(i==1){
                document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none';
                document.getElementById('refuse').style.display='none';
                document.getElementById('agree').style.display='none';
                document.getElementById('answer').innerHTML='已拒绝';
              }else if(i==0){
                document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none';
                document.getElementById('refuse').style.display='none';
                document.getElementById('agree').style.display='none';
                document.getElementById('answer').innerHTML='已同意';
              }else{
                a="somenews"+i;
                document.getElementById('allnews').innerHTML = document.getElementById(a).innerHTML;
                document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block';
                document.getElementById('refuse').style.display='block';
                document.getElementById('agree').style.display='block';
                document.getElementById('answer').innerHTML='';
              }
            }
        </script>
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