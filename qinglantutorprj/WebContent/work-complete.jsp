<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<!-- zui -->
	<link rel="stylesheet" href="dist/css/zui.css" />
	<link rel="stylesheet" href="dist/lib/kindeditor/kindeditor.css" />
	<link rel="stylesheet" href="dist/lib/kindeditor/kindeditor.min.css" />
	<link href="dist/lib/datetimepicker/datetimepicker.min.css" rel="stylesheet">
	<!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
	<script src="dist/lib/jquery/jquery.js"></script>
	<!-- ZUI Javascript组件 -->
	<script type="text/javascript" src="dist/js/zui.js"></script>
	<script src="dist/lib/kindeditor/kindeditor.min.js"></script>
	<script src="dist/lib/kindeditor/kindeditor.js"></script>
	<script src="dist/lib/kindeditor/kindeditor/plugins.ok.js"></script>
	<script src="dist/lib/datetimepicker/datetimepicker.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/header.css">
	<style type="text/css">
	  
	</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<!-- 作业完成页面 -->
	<div id="d1">
		<div id="c1"><h2>作业完成</h2></div>
		<div id="c2">任务一 力学   <br>
			<p style="font-size: 16px;margin-top:10px;font-weight: normal;width: 500px;color: #999">李狗蛋老师 发布于2018年8月6日</p>
		</div>
		<div id="c3"><c:forEach items="${sstatus}" var="s"> ${s} </c:forEach></div>
		<div id="c4"><c:forEach items="${homework}" var="h">${h.tcontent}</c:forEach></div>
		<div class="c5">作业内容：</div>
		<div style="float: left;margin-left: -10px;margin-top: -3px;"><p style="font-size: 13px;margin-top:30px;font-weight: normal;width: 500px;">Tips:请标明作业的题目序号方便老师判卷</p>
		</div>
		<!-- 富文本编辑框与提交代码 -->
		<div id="c6">
			<form action="Update" method="post">
				<textarea id="contentSimple" name="content" class="form-control kindeditorSimple" style="overflow-y:auto;
					overflow-x: hidden;height:200px;resize: none;" >
				</textarea>
				
				
				<p id="question" >作业疑问</p>
				<textarea style="resize: none;width: 230px;height: 75px;margin-left: 120px;margin-top: 30px;" name="question"></textarea>
				<input type="submit" value="提交"  class="btn-submit" />

			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
<script>
	// 富文本编辑框js代码
	KindEditor.create('textarea.kindeditorSimple', {
    basePath: '/dist/lib/kindeditor/',
    bodyClass : 'article-content',
    resizeType : 1,
    allowPreviewEmoticons : false,
    allowImageUpload : false,
    items : [
        'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
        'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
        'insertunorderedlist', '|', 'emoticons', 'image', 'link'
    ]
});
	</script>	
</body>

</html>