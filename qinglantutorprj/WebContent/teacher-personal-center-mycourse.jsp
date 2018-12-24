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
	<title>老师，我的课程</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="<%=basePath%>">
	<link rel="stylesheet" type="text/css" href="css/personal-center.css">
	<link rel="stylesheet" type="text/css" href="css/teacher-mycourse.css">
	<link rel="stylesheet" type="text/css" href="css/header.css"/>
	<link rel="stylesheet" type="text/css" href="css/footer.css"/>
	
	<script type="text/javascript" charset="utf-8" src="textarea/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="textarea/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="textarea/lang/zh-cn/zh-cn.js"></script>

<!-- zui -->
	<link rel="stylesheet" href="dist/css/zui.css" />
	<link href="dist/lib/datetimepicker/datetimepicker.min.css" rel="stylesheet">
	<!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
	<script src="dist/lib/jquery/jquery.js"></script>
	<!-- ZUI Javascript组件 -->
	<script type="text/javascript" src="dist/js/zui.js"></script>
	<script src="dist/lib/datetimepicker/datetimepicker.min.js"></script>
	<style type="text/css">
		*{
			margin:0px;
			padding:0px;
		}
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
		.black_overlay {
			display: none;
			position: fixed;
			top: -50px;
			left: -40px;
			width: 100%;
			height: 1880px;
			background-color: black;
			z-index: 1001;
			-moz-opacity: 0.8;
			opacity: 0.8;
			filter: alpha(opacity=88);
		}
	</style>

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
          <h2>我的课程</h2>
        </div>
        <div class="panel-body" style="position:relative;"> 
        	<div style="height:93%;width:100%;">
        <script type="text/javascript" src="js/stumycourse.js"></script> 
       		<c:forEach items="${courseDetailList }" var="courseInformation">
       			<div  class="c2-right-item"> 
		              <ul>
		                <li>
		                  <span>科目</span>
		                  <p>${courseInformation.subject }</p>
		                </li>
		                <li>
		                  <span>学生</span>
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
		                  <div id="">
		                     <span class="course-time${courseInformation.crid }">${courseInformation.startTime }</span>
		                    <span>~~</span>
		                    <span class="course-time${courseInformation.crid }">${courseInformation.endTime }</span>
		                  </div>
		                  <button type="button">
		                      <a href = "javascript:void(0)" onclick = "buttonTimeOpen(${courseInformation.crid})">更改时间</a>
		                  </button>
		                </li>
		                <li>
		       
		                  <form action="#" method="post">
		                    <input type="button" name="detail" value="课程反馈" onclick="reviewClick(${courseInformation.crid})" />
		                 </form>
		                  <form action="#" method="post">
		                    <input type="button" name="detail" value="布置作业" onclick="homeworkOpen(${courseInformation.crid})">
		                  </form>
		                  <form action="#" method="post">
		                    <input type="submit" name="detail" value="编辑文案">
		                  </form>
		                </li>
		             </ul>
          		</div>
          		
          		
          		
          		
       		</c:forEach>
       		</div>
       		
       		<ul class="pager" style="position:absolute;bottom:0;left:300px;margin-bottom:10px;" >
       			<c:choose>
       				<c:when test="${page == 1 }">
       					<li class="previous disabled"><a href="jump">«</a></li>
       				</c:when>
       				<c:otherwise>
       					<li class="previous"><a href="courseJump?page=${page-1 }">«</a></li>
       				</c:otherwise>
       			</c:choose>
			  	<li><div style="width:105px;height:30px;text-align:center;padding-top:2px;font-size:18px;">第${page }/${pageTotal }页</div></li>
			  	<c:choose>
       				<c:when test="${page == pageTotal}">
       					<li class="previous disabled"><a href="jump">»</a></li>
       				</c:when>
       				<c:otherwise>
       					<li class="next"><a href="courseJump?page=${page+1 }">»</a></li>
       				</c:otherwise>
       			</c:choose>
			  
			</ul>
		</div>
        <div id="light" class="white_content">
              <a href = "javascript:void(0)" onclick = "document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'"><i class="icon icon-times"></i></a><br><br>
              开始时间：
              <input id="c2-right-item-l4-inp1" type="text" class="form-control form-date" placeholder="选择或者输入一个日期：MM-dd">
              结束时间：
              <input id="c2-right-item-l4-inp2" type="text" class="form-control form-date" placeholder="选择或者输入一个日期：MM-dd">
              <button type="button">
                  <a href = "javascript:void(0)" onclick = "buttonTimeSubmit()">保存</a>
              </button>
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
		   	<textarea rows="7" cols="70" onclick="reviewTextarea()"></textarea>
			<span>请评价星级</span>
			<button type="button" onclick="reviewSubmit()">发出评价</button>
        </div>
        
        <div id="course" class="white_content">
        	<a href = "javascript:void(0)" onclick = "homeworkClose()"><i class="icon icon-times"></i></a><br><br>
        	<div>
	        	<span>请选择作业截止时间：</span>
			   	<input id="coursedeadtime" type="text" class="form-control form-date" placeholder="选择或者输入一个日期：MM-dd">
        	</div>        
		   	<p>作业内容：</p>
		   	<script id="editor" type="text/plain" style="width:760px;height:200px;"></script>
			<span>请将时间或内容填上</span>
			<button type="button" onclick="homeworkSubmit()">上传内容</button>
        </div>
        <div id="fade" class="black_overlay"></div> 
        <script type="text/javascript" src="js/teamycourse.js"></script>
      </div>
    </div>
</div>
<!-- 底部 -->
<jsp:include page="footer.jsp"></jsp:include>



</body>
</html>