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
          <div><img src="${map.user.userImg }" width="120px" height="120px" class="img-circle" alt="圆形图片"></div>
        </li>
        <li id="c1-about">
          <p>${map.user.userName }</p>
          <c:if test="${map.user.role eq '老师' }">
          		<span class="label label-badge">${map.user.school }</span>
          		<span class="label label-badge">${map.user.grade }</span>
          </c:if>
        </li>
        <li id="c1-person">
          <p id="c1-person-p1">个人介绍</p>
          <p id="c1-person-p2">
            &nbsp;&nbsp;${map.user.introduce }
          </p>
        </li>
        <li id="c1-star">
          <p id="c1-star-p1">评分${map.grade }</p>
          <div id=c1-star-div>
            <img src="images/${map.star1 }.png" style="width: 25px;height: 25px;">
            <img src="images/${map.star2 }.png" style="width: 25px;height: 25px;">
            <img src="images/${map.star3 }.png" style="width: 25px;height: 25px;">
            <img src="images/${map.star4 }.png" style="width: 25px;height: 25px;">
            <img src="images/${map.star5 }.png" style="width: 25px;height: 25px;">
            <form action="jumptoReview" method="post">
              <input type="submit" name="查看详情" value="查看详情">
            </form>
          </div>
        </li>
      </ul>
    </div>
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
      <div class="c2 panel" id="c2-right" style=" OVERFLOW-X:hidden; OVERFLOW-Y:hidden;">
        <div class="panel-heading">
          <h2>我的作业</h2>
        </div>
	      
        <div class="panel-body"  style="position:relative;">
        	<c:forEach  items="${homework }" var="h">
          	 <div >
           	 <c:forEach items="${teachers }" var="t">
          
           		
           		<c:if test="${h.getTeachRelation().getUser().getId()==t.id }">
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
                  <button type="button"><a href="WorkComplete?hid=${h.hid}">查看详情</a></button>
                   <button type="button"><c:if test="${h.sstatus == '未完成'}"><a href="WorkComplete?hid=${h.hid}">未完成</a></c:if><c:if test="${h.sstatus == '已完成'}">已完成</c:if></button>
              </div>
              
           </div>
          
           </c:forEach >
        <ul class="pager" style="position:absolute;bottom:0;left:300px;margin-bottom:10px;" >
       			<c:choose>
       				<c:when test="${page == 1 }">
       					<li class="previous disabled"><a href="jump">«</a></li>
       				</c:when>
       				<c:otherwise>
       					<li class="previous"><a href="HomeWorkShow?page=${page-1 }">«</a></li>
       				</c:otherwise>
       			</c:choose>
			  	<li><div style="width:105px;height:30px;text-align:center;padding-top:2px;font-size:18px;">第${page }/${pagenum }页</div></li>
			  	<c:choose>
       				<c:when test="${page ==pagenum}"> 
       					<li class="previous disabled"><a href="jump">»</a></li>
       				</c:when>
       				<c:otherwise>
       					<li class="next"><a href="HomeWorkShow?page=${page+1 }">»</a></li>
       				</c:otherwise>
       			</c:choose>
			  
			</ul>
           
       
        </div>
        
      </div>
    </div>
</div>
 <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>