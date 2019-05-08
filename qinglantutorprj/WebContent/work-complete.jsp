<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<base href="<%=basePath%>">
	
	<link rel="stylesheet" type="text/css" href="css/work-complete.css">
	<link rel="stylesheet" type="text/css" href="css/header.css"/>
	<link rel="stylesheet" type="text/css" href="css/footer.css"/>
	<link rel="stylesheet" type="text/css" href="css/register_login.css"/>
	
	
	<script type="text/javascript" charset="utf-8" src="textarea/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="textarea/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="textarea/lang/zh-cn/zh-cn.js"></script>
    
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
	
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<!-- 作业完成页面 -->
	<div id="d1">
		<div id="c1"><h2>作业完成</h2></div>
		<c:forEach items="${homework}" var="h">
			<div id="c2">任务   <br>
				<p style="font-size: 16px;margin-top:10px;font-weight: normal;width: 500px;color: #999">${h.getTeachRelation().getUser().getUserName()}老师 发布于${fn:substring(h.tstartTime, 0, 10)}</p>
			</div>
		</c:forEach>
		<div id="c3"><c:forEach items="${sstatus}" var="s"> ${s} </c:forEach></div>
		<div id="c4"><c:forEach items="${homework}" var="h">${h.tcontent}</c:forEach></div>
		<div class="c5">作业内容：</div>
		<div style="float: left;margin-left: -10px;margin-top: -3px;"><p style="font-size: 13px;margin-top:30px;font-weight: normal;width: 500px;">Tips:请标明作业的题目序号方便老师判卷</p>
		</div>
		<!-- 富文本编辑框与提交代码 -->
		<div id="c6">
		<c:if test="${not empty hid}">
			<form action="Update" method="post">
			<c:if test="${not empty ts}">
				<script id="editor" type="text/plain" style="width:800px;height:150px;" name="content"></script>
				<input name="hid" type="hidden" value="${hid}">
				
				<p id="question" >作业疑问</p>
				<textarea style="resize: none;width: 230px;height: 75px;margin-top: 30px;" name="question"  disabled="disabled"></textarea>
				<input type="submit" value="提交"  class="btn-submit"  disabled="disabled"/>
			</c:if>
			<c:if test="${empty ts}">
				<script id="editor" type="text/plain" style="width:800px;height:150px;" name="content"></script>
				<input name="hid" type="hidden" value="${hid}">
				
				<p id="question" >作业疑问</p>
				<textarea style="resize: none;width: 230px;height: 75px;margin-top: 30px;" name="question"></textarea>
				<input type="submit" value="提交"  class="btn-submit"  />
			</c:if>
			</form>
		</c:if>	
		</div>
	</div>
	<!-- 引用footer -->
	<jsp:include page="footer.jsp"/>
<script>
	// 富文本编辑框js代码
	//富文本编辑框
var ue = UE.getEditor('editor',{
	toolbars:[
		[
			 'bold', //加粗
			  'indent', //首行缩进
	        'italic', //斜体
	        'underline', //下划线
	        'strikethrough', //删除线
	        'justifyleft', //居左对齐
	        'justifyright', //居右对齐
	        'justifycenter', //居中对齐
	        'justifyjustify', //两端对齐
	        'forecolor', //字体颜色
	        'backcolor', //背景色
	        'subscript', //下标
	        'fontborder', //字符边框
	        'superscript', //上标
	        'fontfamily', //字体
	        'fontsize', //字号
	        'pasteplain', //纯文本粘贴模式
	        'selectall', //全选
	         'horizontal', //分隔线
	        'removeformat', //清除格式
	        'time', //时间
	        'date', //日期
	        'link', //超链接
	        'emotion', //表情
	        'spechars', //特殊字符
	        'simpleupload', //单图上传
		]
	]
});
	</script>	
	  <script type="text/javascript" src="js/checkLogin_regist.js"></script>
</body>

</html>