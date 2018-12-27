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
	<title>我的消息--学生</title>
	<!-- ZUI 标准版压缩后的 CSS 文件 -->
	<link rel="stylesheet" type="text/css" href="css/personal-center.css">
	<link rel="stylesheet" type="text/css" href="css/student-mynews.css">
	<link rel="stylesheet" type="text/css" href="css/header.css"/>
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
<c:set var="totalpage" value="${totalpage}"/>
<c:set var="pagenow" value="${pagenow}"/>
<div id="content">
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
          <p id="c1-person-p1">个人介绍</p>
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
        <div class="panel-heading">   
        <h2>我的消息</h2>
        </div>
        <div class="panel-body"style="position:relative;" >
        
        
        <c:forEach items="${news}" var="x"> 
          <div>
            <div class="c2-left-item1">
              <img src="${x.userimg}" class="img-circle" alt="圆形图片"><br>
              <span>${x.username}</span>
            </div>
            <div  style="width:76.5%;height:198px;">
            	 <div class="c2-left-item2">
	             <h3 style="margin-top:10px;width:500px;">${x.cutContent}<span style="float:right;">${fn:substring(x.sendtime, 0, 10)}</span></h3>
	              		<c:if test="${x.status==1}"><h4>已拒绝</h4></c:if>
	              		<c:if test="${x.status==2}"><h4>已同意</h4></c:if>
	              		<c:if test="${x.status==0}"><h4>未读</h4></c:if>
	              <p id="somenews${x.mid}">${x.content}</p>
	            </div>
	            <button type="button" class="c2-left-item3">
	                 <a href = "javascript:void(0)" onclick = "buttontime(${x.mid},${x.status})">查看详情</a>
	            </button>
            </div>
          </div>        
          
          
          </c:forEach>
		  <ul class="pager" style="position:absolute;bottom:0;left:300px;margin-bottom:10px;" >
       			<c:choose>
       				<c:when test="${pagenow == 1 }">
       					<li class="previous disabled"><a href="#">«</a></li>
       				</c:when>
       				<c:otherwise>
       					<li class="previous"><a href="jumptoNews?pagenow=${pagenow-1}">«</a></li>
       				</c:otherwise>
       			</c:choose>
			  	<li><div style="width:105px;height:30px;text-align:center;padding-top:2px;font-size:18px;">第${pagenow}/${totalpage}页</div></li>
			  	<c:choose>
       				<c:when test="${pagenow==totalpage}">
       					<li class="previous disabled"><a href="#">»</a></li>
       				</c:when>
       				<c:otherwise>
       					<li class="next"><a href="jumptoNews?pagenow=${pagenow+1}">»</a></li>
       				</c:otherwise>
       			</c:choose>
			  
			</ul>
      	</div>
    </div>
    </div>
     <div id="light" class="white_content">
                <a href = "javascript:void(0)" onclick = "document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'"><i class="icon icon-times"></i></a><br><br>
                <h3>消息内容:&nbsp;&nbsp;</h3><h5>Tips:如遇到垃圾消息请拒绝并反馈</h5>
                <h3 id="allnews"></h3>
                
                <div id="answerAX"> 
                <a href="#" id="no"><button type="button" id="refuse">拒绝</button></a>
                <a href="#" id="yes"><button type="button" id="agree" >同意</button></a>
                </div>
        </div> 
        <div id="fade" class="black_overlay"></div> 
        <script type="text/javascript">
            function buttontime(i,p){
              var a = "somenews"+i;
              var b = "answerAX"+i;
              var linkyes ="InsertTRCR?mid="+i;
              var linkno ="changeStatus?status=1&mid="+i;
             
              if(p==1){
            	  document.getElementById('allnews').innerHTML = document.getElementById(a).innerHTML;
                  document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block';
                  document.getElementById('refuse').style.display='none';
                  document.getElementById('agree').style.display='none';
              }else if(p==0){
            	  document.getElementById('allnews').innerHTML = document.getElementById(a).innerHTML;
                  document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block';
                  document.getElementById('refuse').style.display='block';
                  document.getElementById('agree').style.display='block'; 
                  document.getElementById("no").href=linkno;
                  document.getElementById("yes").href=linkyes;
                  
              }else if(p==2){
            	document.getElementById('allnews').innerHTML = document.getElementById(a).innerHTML;
                document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block';
                document.getElementById('refuse').style.display='none';
                document.getElementById('agree').style.display='none';
              }
            }
        </script>
</div>
  <jsp:include page="footer.jsp"></jsp:include>
  <script type="text/javascript" src="js/checkLogin_regist.js"></script>
</body>
</html>