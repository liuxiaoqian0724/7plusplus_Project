<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
   <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
	<title>我的评价--老师</title>
	<!-- ZUI 标准版压缩后的 CSS 文件 -->
<link rel="stylesheet" href="dist/css/zui.min.css">
<link rel="stylesheet" type="text/css" href="css/personal-center.css">
<link rel="stylesheet" type="text/css" href="css/student-myevaluation.css">
<link rel="stylesheet" type="text/css" href="css/header.css"/>
<link rel="stylesheet" type="text/css" href="css/footer.css"/>
 <link rel="stylesheet" type="text/css" href="css/header.css"/>
    <link rel="stylesheet" type="text/css" href="css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="css/register_login.css"/>
    <!-- zui -->
    <link rel="stylesheet" href="dist/css/zui.css" />
    <link rel="stylesheet" href="css/verify.css" />
    <!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
    <script src="js/jquery-3.2.1.js"></script>
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
<!-- 头部 -->
<div id="head">
<jsp:include page="header.jsp"></jsp:include>
</div>

<!-- 中部 -->
<div id="content">
<c:set var="totalpage" value="${totalpage}"/>
<c:set var="pagenow" value="${pagenow}"/>


<!-- 通用personaltop部分 -->
<c:forEach items="${personal}" var="x">
    <div id="c1">
      <ul>
        <li id="c1-img">
          <div><img src="${x.userImg }" width="120px" height="120px" class="img-circle" alt="圆形图片"></div>
          
        </li>
        <li id="c1-about">
          <p>${x.userName}</p>
          <span class="label label-badge">${x.school}</span>
          <span class="label label-badge">${x.major}</span>
        </li>
        <li id="c1-person">
          <p id="c1-person-p1">个人简介</p>
          <p id="c1-person-p2">
            &nbsp;&nbsp;${x.introduce}
          </p>
        </li>
        <li id="c1-star">
          <p id="c1-star-p1">评分 :${finalstarfull}</p>
          
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
         <div class="c2-left-item" id="c2-left-news"><a href="jumptoNews"><i class="icon icon-envelope"></i>&nbsp;我的消息<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="courseInformation"><i class="icon icon-book"></i>&nbsp;我的课程<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="jumptoReview"><i class="icon icon-flag"></i>&nbsp;我的评价<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-newspaper-o"></i>&nbsp;我的文章<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-question-sign"></i>&nbsp;我的问答<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="inforedit"><i class="icon icon-wrench"></i>&nbsp;个人资料<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="teachPlanInformation"><i class="icon icon-stack"></i>&nbsp;我的教案<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="HomeWorkShow"><i class="icon icon-file-text-o"></i>&nbsp;我的作业<i class="icon icon-chevron-right"></i></a></div>
      </div>
      <div class="c2 panel" id="c2-right">
        <div>
            <div class="panel-heading">
                <h2>收到的学生评价</h2>
            </div>
            <div class="panel-body" style="height:690px;position:relative;width:800px;" > 
            <c:forEach items="${listpage}" var="z">
             <c:forEach items="${z.review}" var="x">
             <script type="text/javascript">
                
             </script>
                
              <div class="c2-right-item">
                    <div  style="border:0px;border-bottom:1px solid #c0c0c0;">
                        <span>${z.givername}</span>
                        <div id="reviewstar">
                        <c:forEach items="${z.star}" var="star1">
                            <img src="images/<c:out value="${star1}"/>.png" style="width: 30px;height: 30px;">
                           </c:forEach>
                           <%--  <p>分数：${x.reviewStar}</p> --%>
                        </div>
                    </div>
                    <div style="border:0px;border-bottom:1px solid #c0c0c0;">
                        <p>${x.reviewContent}</p>
                    </div>
                    <div style="border:0px;">
                        <span>${fn:substring(x.reviewTime, 0, 10)}</span>
                    </div>
                </div>
                 </c:forEach>
                </c:forEach>
                <ul class="pager" style="position:absolute;bottom:0;left:300px;" >
       			<c:choose>
       				<c:when test="${pagenow == 1 }">
       					<li class="previous disabled"><a href="#">«</a></li>
       				</c:when>
       				<c:otherwise>
       					<li class="previous"><a href="jumptoReview?pagenow=${pagenow-1}">«</a></li>
       				</c:otherwise>
       			</c:choose>
			  	<li><div style="width:105px;height:30px;text-align:center;padding-top:2px;font-size:18px;">第${pagenow}/${totalpage}页</div></li>
			  	<c:choose>
       				<c:when test="${pagenow==totalpage}">
       					<li class="previous disabled"><a href="#">»</a></li>
       				</c:when>
       				<c:otherwise>
       					<li class="next"><a href="jumptoReview?pagenow=${pagenow+1}">»</a></li>
       				</c:otherwise>
       			</c:choose>
			  
			</ul>
                
            </div>
        </div>
        
        
      </div>
    </div>
</div>
  <jsp:include page="footer.jsp"></jsp:include>
  <script type="text/javascript" src="js/checkLogin_regist.js"></script>
</body>
</html>