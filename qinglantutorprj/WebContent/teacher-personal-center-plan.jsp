<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>老师，我的教案</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="<%=basePath%>">
	<link rel="stylesheet" href="dist/css/zui.min.css">
	<link rel="stylesheet" type="text/css" href="css/personal-center.css">
	<link rel="stylesheet" type="text/css" href="css/teacher-myplan.css">
	<link rel="stylesheet" type="text/css" href="css/header.css"/>
	<link rel="stylesheet" type="text/css" href="css/footer.css"/>	
	<link rel="stylesheet" type="text/css" href="css/register_login.css"/>
	<link rel="stylesheet" href="dist/css/zui.css" />

	<script type="text/javascript" charset="utf-8" src="textarea/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="textarea/ueditor.all.min.js"> </script>
	<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
	<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
	<script type="text/javascript" charset="utf-8" src="textarea/lang/zh-cn/zh-cn.js"></script>
	
	<!-- zui -->
	<script src="js/jquery-3.2.1.js"></script>
	<link rel="stylesheet" href="dist/css/zui.css" />
	<link href="dist/lib/datetimepicker/datetimepicker.min.css" rel="stylesheet">
	<!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
	<!-- <script src="dist/lib/jquery/jquery.js"></script> -->
	<!-- ZUI Javascript组件 -->
	<script type="text/javascript" src="dist/js/zui.js"></script>
	<script src="dist/lib/datetimepicker/datetimepicker.min.js"></script>
	
	<link rel="stylesheet" href="css/verify.css" />
	<script type="text/javascript" src="js/verify.js"></script>
    <script type="text/javascript" src="js/verify.min.js"></script>
    <script type="text/javascript" src="js/header.js"></script>
 	<script type="text/javascript" src="js/nav.js"></script>
 	
 	<!-- semantic -->
	<link rel="stylesheet" type="text/css" href="Semantic/components/message.css"/>
</head>
<body>
<!-- 头部 -->
<jsp:include page="header.jsp"></jsp:include>
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
          <p id="c1-person-p1">个人简介</p>
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
      <div class="c2 panel" id="c2-right">
        <div class="panel-heading">
          <h2>我的教案</h2>
        </div>
        <div class="panel-body" style="position:relative;">
        	<div>
        	<c:forEach items="${teachPlanInformationList }" var="teachPlanInformation">
	              <div class="c2-right-img">
	                <img src="${teachPlanInformation.img }" width="100px" height="100px" class="img-circle" alt="圆形图片">
	                <p>${teachPlanInformation.name }</p>
	              </div>
	              <div class="c2-right-items">
	                  <div>
                 			<div class="c2-right-item" id="addPlan-${teachPlanInformation.trid}">
                 				<c:forEach items="${teachPlanInformation.planDetailMap }" var="planDetail">
		                        <div id="plan-${planDetail.planId }">
		                            <a href="javascript:void(0)"  onclick="deletePlan(${planDetail.planId })"><span class="icon icon-times"></span></a>
		                            <a href="javascript:void(0)" onclick = "contentOpen(${planDetail.planId})"><span class="icon icon-edit"></span></a>
		                            <div id="content-${planDetail.planId }">${planDetail.content }</div>
		                            <span id="time-${planDetail.planId }">${planDetail.time }</span>
		                        </div>
	                  		</c:forEach>
	                     	</div>
	                     	<div class="c2-right-edit">
		                        <a href="javascript:void(0)" onclick="addTeachPlan(${teachPlanInformation.trid})">
		                        	<span class="icon icon-plus icon-2x"></span>
		                        </a>
		                    </div>
	                  </div>
	              </div>
	              
	              
	              
	              
        	</c:forEach>
          </div>
          
          <ul class="pager" style="position:absolute;bottom:0px;left:300px;margin-bottom:10px;">
       			<c:choose>
       				<c:when test="${page == 1 }">
       					<li class="previous disabled"><a href="jump">«</a></li>
       				</c:when>
       				<c:otherwise>
       					<li class="previous"><a href="teachPlanJump?page=${page-1 }">«</a></li>
       				</c:otherwise>
       			</c:choose>
			  	<li><div style="width:105px;height:30px;text-align:center;padding-top:2px;font-size:18px;">第${page }/${pageTotal }页</div></li>
			  	<c:choose>
       				<c:when test="${page == pageTotal}">
       					<li class="previous disabled"><a href="jump">»</a></li>
       				</c:when>
       				<c:otherwise>
       					<li class="next"><a href="teachPlanJump?page=${page+1 }">»</a></li>
       				</c:otherwise>
       			</c:choose>
			  
			</ul>
        </div>

        <!-- 富文本编辑框 -->
        <div id="light" class="white_content"> 
           <a href = "javascript:void(0)" onclick = "document.getElementById('light').style.display='none';document.getElementById('fade').style.display ='none'"><span class="icon icon-times"></span></a><br>
           <div>
           	 <span>教案备用时间:</span>
          	 <input type="text" class="form-control form-date" placeholder="选择或者输入一个日期：MM-dd">
           </div>
           <script id="editor" type="text/plain" style="width:750px;height:200px;"></script>
           <span>请输入教案内容</span>
           <button type="button" value="保存" onclick="getContent()">确定</button>
        </div>
        <div id="addPlan" class="white_content"> 
           <a href = "javascript:void(0)" onclick = "document.getElementById('addPlan').style.display='none';document.getElementById('fade').style.display ='none'"><span class="icon icon-times"></span></a><br>
           <div>
           	 <span>教案备用时间:</span>
          	 <input type="text" class="form-control form-date" placeholder="选择或者输入一个日期：MM-dd">
           </div>
           <script id="editor-2" type="text/plain" style="width:750px;height:200px;"></script>
           <span>请输入教案内容</span>
           <button type="button" value="保存" onclick="addTeachPlanInfor()">确定</button>
        </div>
      	<div id="fade" class="black_overlay"></div>
        <script type="text/javascript" src="js/myplan.js"></script>
      </div>
    </div>
	</div>
</div>
<!-- 底部 -->
<jsp:include page="footer.jsp"></jsp:include>
 
 <script type="text/javascript" src="js/checkLogin_regist.js"></script>
</body>


</html>