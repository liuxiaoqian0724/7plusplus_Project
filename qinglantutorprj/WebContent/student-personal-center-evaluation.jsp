<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html>
<head>
	<title>我的评价</title>
	<!-- ZUI 标准版压缩后的 CSS 文件 -->
<link rel="stylesheet" href="<%=basePath%>/css/zui.min.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/personal-center.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/student-myevaluation.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/header.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/footer.css"/>

<!-- ZUI Javascript 依赖 jQuery -->
<script src="<%=basePath%>/lib/jquery/jquery.js"></script>
<!-- ZUI 标准版压缩后的 JavaScript 文件 -->
<script src="<%=basePath%>/js/zui.min.js"></script>

<meta charset="utf-8">
</head>
<body>
<!-- 头部 -->
<jsp:include page="header.jsp"/>
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
            <img src="<%=basePath%>/images/fill-star.png" style="width: 25px;height: 25px;">
            <img src="<%=basePath%>/images/fill-star.png" style="width: 25px;height: 25px;">
            <img src="<%=basePath%>/images/fill-star.png" style="width: 25px;height: 25px;">
            <img src="<%=basePath%>/images/fill-star.png" style="width: 25px;height: 25px;">
            <img src="<%=basePath%>/images/empty-star.png" style="width: 25px;height: 25px;">
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
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-flag"></i>&nbsp;我的评价<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-newspaper-o"></i>&nbsp;我的文章<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-question-sign"></i>&nbsp;我的问答<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-wrench"></i>&nbsp;个人资料<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-stack"></i>&nbsp;我的教案<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-file-text-o"></i>&nbsp;我的作业<i class="icon icon-chevron-right"></i></a></div>
      </div>
      <div class="c2 panel" id="c2-right">
        <div>
            <div class="panel-heading">
                <h2>收到的评价</h2>
            </div>
            <div class="panel-body"> 
              <div class="c2-right-item">
                    <div>
                        <span>匿名用户</span>
                        <div>
                            <img src="<%=basePath%>/images/fill-star.png" style="width: 30px;height: 30px;">
                            <img src="<%=basePath%>/images/fill-star.png" style="width: 30px;height: 30px;">
                            <img src="<%=basePath%>/images/fill-star.png" style="width: 30px;height: 30px;">
                            <img src="<%=basePath%>/images/fill-star.png" style="width: 30px;height: 30px;">
                            <img src="<%=basePath%>/images/empty-star.png" style="width: 30px;height: 30px;">
                        </div>
                    </div>
                    <div>
                        <p>Subject：即“当前操作用户”。但是，在Shiro中，Subject这一概念并不仅仅指人，也可以是第三方进程、后台帐户（Daemon Account）或其他类似事物。它仅仅意味着“当前跟软件交互的东西”。但考虑到大多数目的和用途，你可以把它认为是Shiro的“用户”概念概念并不仅仅指人，也可以是第三方进程、后台帐户（Daemon Account）或其他类似事物。它仅仅意味着“当前跟软件交互的东西”。但考虑概念并不仅仅指人，也可以是第三方进程、后台帐户（Daemon Account）或其他类似事物。它仅仅意味着“当前跟软件交互的东西”。但考虑概念并不仅仅指人，也可以是第三方进程、后台帐户（Daemon Account）或其他类似事物。它仅仅意味着“当前跟软件交互的东西”。但考虑</p>
                    </div>
                    <div>
                        <span>2018-08-16</span>
                    </div>
                </div>
                <div class="c2-right-item">
                    <div>
                        <span>匿名用户</span>
                        <div>
                            <img src="<%=basePath%>/images/fill-star.png" style="width: 30px;height: 30px;">
                            <img src="<%=basePath%>/images/fill-star.png" style="width: 30px;height: 30px;">
                            <img src="<%=basePath%>/images/fill-star.png" style="width: 30px;height: 30px;">
                            <img src="<%=basePath%>/images/fill-star.png" style="width: 30px;height: 30px;">
                            <img src="<%=basePath%>/images/empty-star.png" style="width: 30px;height: 30px;">
                        </div>
                    </div>
                    <div>
                        <p>Subject：即“当前操作用户”。但是，在Shiro中，Subject这一概念并不仅仅指人，也可以是第三方进程、后台帐户（Daemon Account）或其他类似事物。它仅仅意味着“当前跟软件交互的东西”。但考虑到大多数目的和用途，你可以把它认为是Shiro的“用户”概念概念并不仅仅指人，也可以是第三方进程、后台帐户（Daemon Account）或其他类似事物。它仅仅意味着“当前跟软件交互的东西”。但考虑概念并不仅仅指人，也可以是第三方进程、后台帐户（Daemon Account）或其他类似事物。它仅仅意味着“当前跟软件交互的东西”。但考虑概念并不仅仅指人，也可以是第三方进程、后台帐户（Daemon Account）或其他类似事物。它仅仅意味着“当前跟软件交互的东西”。但考虑</p>
                    </div>
                    <div>
                        <span>2018-08-16</span>
                    </div>
                </div> 
                <div class="c2-right-item">
                    <div>
                        <span>匿名用户</span>
                        <div>
                            <img src="<%=basePath%>/images/fill-star.png" style="width: 30px;height: 30px;">
                            <img src="<%=basePath%>/images/fill-star.png" style="width: 30px;height: 30px;">
                            <img src="<%=basePath%>/images/fill-star.png" style="width: 30px;height: 30px;">
                            <img src="<%=basePath%>/images/fill-star.png" style="width: 30px;height: 30px;">
                            <img src="<%=basePath%>/images/empty-star.png" style="width: 30px;height: 30px;">
                        </div>
                    </div>
                    <div>
                        <p>Subject：即“当前操作用户”。但是，在Shiro中，Subject这一概念并不仅仅指人，也可以是第三方进程、后台帐户（Daemon Account）或其他类似事物。它仅仅意味着“当前跟软件交互的东西”。但考虑到大多数目的和用途，你可以把它认为是Shiro的“用户”概念概念并不仅仅指人，也可以是第三方进程、后台帐户（Daemon Account）或其他类似事物。它仅仅意味着“当前跟软件交互的东西”。但考虑概念并不仅仅指人，也可以是第三方进程、后台帐户（Daemon Account）或其他类似事物。它仅仅意味着“当前跟软件交互的东西”。但考虑概念并不仅仅指人，也可以是第三方进程、后台帐户（Daemon Account）或其他类似事物。它仅仅意味着“当前跟软件交互的东西”。但考虑</p>
                    </div>
                    <div>
                        <span>2018-08-16</span>
                    </div>
                </div> 
            </div>
        </div>
        <div>
            <div class="panel-heading">
              <h2>给出的评价</h2>
            </div>
            <div class="panel-body"> 
                <div class="c2-right-item">
                    <div>
                        <span>匿名用户</span>
                        <div>
                            <img src="<%=basePath%>/images/fill-star.png" style="width: 30px;height: 30px;">
                            <img src="<%=basePath%>/images/fill-star.png" style="width: 30px;height: 30px;">
                            <img src="<%=basePath%>/images/fill-star.png" style="width: 30px;height: 30px;">
                            <img src="<%=basePath%>/images/fill-star.png" style="width: 30px;height: 30px;">
                            <img src="<%=basePath%>/images/empty-star.png" style="width: 30px;height: 30px;">
                        </div>
                    </div>
                    <div>
                        <p>Subject：即“当前操作用户”。但是，在Shiro中，Subject这一概念并不仅仅指人，也可以是第三方进程、后台帐户（Daemon Account）或其他类似事物。它仅仅意味着“当前跟软件交互的东西”。但考虑到大多数目的和用途，你可以把它认为是Shiro的“用户”概念概念并不仅仅指人，也可以是第三方进程、后台帐户（Daemon Account）或其他类似事物。它仅仅意味着“当前跟软件交互的东西”。但考虑概念并不仅仅指人，也可以是第三方进程、后台帐户（Daemon Account）或其他类似事物。它仅仅意味着“当前跟软件交互的东西”。但考虑概念并不仅仅指人，也可以是第三方进程、后台帐户（Daemon Account）或其他类似事物。它仅仅意味着“当前跟软件交互的东西”。但考虑</p>
                    </div>
                    <div>
                        <span>2018-08-16</span>
                    </div>
                </div> 
                <div class="c2-right-item">
                    <div>
                        <span>匿名用户</span>
                        <div>
                            <img src="<%=basePath%>/images/fill-star.png" style="width: 30px;height: 30px;">
                            <img src="<%=basePath%>/images/fill-star.png" style="width: 30px;height: 30px;">
                            <img src="<%=basePath%>/images/fill-star.png" style="width: 30px;height: 30px;">
                            <img src="<%=basePath%>/images/fill-star.png" style="width: 30px;height: 30px;">
                            <img src="<%=basePath%>/images/empty-star.png" style="width: 30px;height: 30px;">
                        </div>
                    </div>
                    <div>
                        <p>Subject：即“当前操作用户”。但是，在Shiro中，Subject这一概念并不仅仅指人，也可以是第三方进程、后台帐户（Daemon Account）或其他类似事物。它仅仅意味着“当前跟软件交互的东西”。但考虑到大多数目的和用途，你可以把它认为是Shiro的“用户”概念概念并不仅仅指人，也可以是第三方进程、后台帐户（Daemon Account）或其他类似事物。它仅仅意味着“当前跟软件交互的东西”。但考虑概念并不仅仅指人，也可以是第三方进程、后台帐户（Daemon Account）或其他类似事物。它仅仅意味着“当前跟软件交互的东西”。但考虑概念并不仅仅指人，也可以是第三方进程、后台帐户（Daemon Account）或其他类似事物。它仅仅意味着“当前跟软件交互的东西”。但考虑</p>
                    </div>
                    <div>
                        <span>2018-08-16</span>
                    </div>
                </div> 
            </div>
        </div>
        
      </div>
    </div>
</div>
 <jsp:include page="footer.jsp"/>
</body>
</html>