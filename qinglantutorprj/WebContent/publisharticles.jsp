<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<title>文章发布</title>
		<!--本地css-->
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/publisharticles.css">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/header.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/footer.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/register_login.css" />
		<!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
		<script src="<%=basePath%>/js/jquery-3.2.1.js"></script>
		<!-- zui -->
		<link rel="stylesheet" href="<%=basePath%>/dist/css/zui.css" />
		<script type="text/javascript" src="<%=basePath%>/dist/js/zui.js"></script>
		<!-- 富文本编辑框组件 -->
		<link rel="stylesheet" href="<%=basePath%>/dist/lib/kindeditor/kindeditor.css" />
		<link rel="stylesheet" href="<%=basePath%>/dist/lib/kindeditor/kindeditor.min.css" />
		<script src="<%=basePath%>/dist/lib/kindeditor/kindeditor.min.js"></script>
		<script src="<%=basePath%>/dist/lib/kindeditor/kindeditor.js"></script>
		<script src="<%=basePath%>/dist/lib/kindeditor/kindeditor/plugins.ok.js"></script>
		<!--标签编辑-->
		<script src="<%=basePath%>/xoxco/src/jquery.tagsinput.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/xoxco/src/jquery.tagsinput.css" />
		<!-- js功能代码 -->
		<script src="<%=basePath%>/js/header.js"></script>
		<script src="<%=basePath%>/js/nav.js"></script>
	</head>
	<body bgcolor="#ffffff">
		<jsp:include page="header.jsp" />
			<div class="panel-body" id="out">
				<form action="${pageContext.request.contextPath}/pubarticles",method="post">
					<!--标题-->
					<h1>文章发布</h1>
					<hr />
					<br />
					<!--输入框-->
					<lable style="font-size:16px;"><strong>标题&nbsp;&nbsp;&nbsp;</strong></label>
						<label>
							<input type="text" class="form-control" style="width: 443%;" name="title">
						</label>
						<br /><br />
						<!--富文本编辑框-->
						<div id="write-box-text" style="width:100%; height:auto;">
							<textarea id="contentSimple" name="content" class="form-control kindeditorSimple" style="height:300px;"></textarea>
						</div>
						<!--小提示-->
						<div id="tips">tips:发布的文章审核通过之后才能被大家看到哦</div>
						<br />
						<!--标签-->
						<div><strong>编辑标签</strong>(单击回车后添加)：</div>
						<form>
							<input id="tags_1" type="text" class="tags" value="默认标签">
						</form>
						<br />
						<!--提交按钮-->
						<button class="btn" type="button" style="position: relative; left:80%">保存文章</button>
						<button class="btn btn-primary" type="submit" style="position: relative; left:81%" data-options="attributes:{'url':'index'}">确认发布</button>
				</form>
			</div>
		<script>
			//富文本编辑框
			KindEditor.create('textarea.kindeditorSimple', {
				basePath: '/dist/lib/kindeditor/',
				bodyClass: 'article-content',
				resizeType: 1,
				allowPreviewEmoticons: false,
				allowImageUpload: false,
				items: [
					'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
					'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
					'insertunorderedlist', '|', 'emoticons', 'image', 'link'
				]
			});
			//标签编辑
			function onAddTag(tag) {
				alert("Added a tag: " + tag);
			}

			function onRemoveTag(tag) {
				alert("Removed a tag: " + tag);
			}

			function onChangeTag(input, tag) {
				alert("Changed a tag: " + tag);
			}
			$(function() {
				$('#tags_1').tagsInput({
					width: 'auto'
				});
			});
		</script>
		<script type="text/javascript" src="<%=basePath%>/js/index.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/checkLogin_regist.js"></script>
		<jsp:include page="footer.jsp" />
	</body>
</html>
