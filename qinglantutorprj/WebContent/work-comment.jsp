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
	<meta charset="utf-8">
	<base href="<%=basePath%>">
	
	<link rel="stylesheet" type="text/css" href="css/footer.css"/>
	<link rel="stylesheet" href="dist/css/zui.min.css">
	<script type="text/javascript" src="distb/jquery/jquery.js"></script>
	<script type="text/javascript" src="dist/js/zui.min.js"></script>
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
		

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<!-- 作业完成页面 -->
	<div id="d1" style="height: 1100px;">
		<div id="c1"><h2>作业评价</h2></div>
		<div id="c2">任务一 力学   <br>
			<p style="font-size: 16px;margin-top:10px;font-weight: normal;width: 500px;color: #999;">李狗蛋老师 发布于2018年8月6日</p>
		</div>
		<div id="c3">待完成</div>
		<div id="c4"></div>
		<div class="c5">作业内容：</div>
		<p style="font-size: 13px;margin-top:60px;margin-left:-110px;font-weight: normal;width: 500px;float: left;">张三完成于2018年8月6日</p>
		

		<!-- 作业内容 -->
		<div  style="	width: 800px;height: 200px;float: left;overflow-y:auto;overflow-x: hidden;
				border:1px solid #c0c0c0;margin-left: 47px;"></div>
		<!-- 作业疑问 -->
		<div  class="c5" style="margin-left: 27px;">作业疑问：</div>
		<div  style="width: 800px;height: 110px;float: left;overflow-y:auto;overflow-x: hidden;
					border:1px solid #c0c0c0;margin-top: -15px;margin-left: 47px;"></div>		
		
			<!-- 作业耗时与完成情况 -->
			<div id="time1" > 
				<div  class="c7" style="height: 20px;width: 75px;">分数</div>
				<div  class="t2" ><input type="text" style="width:40px;" >  </div>
				<div style="float: left;margin-left: 190px;margin-top:-20px;width: 50px;"><p>分</p></div>
				<div  class="c7" style="height: 20px;width: 75px;margin-top: 20px;">完成情况</div>
				<div  class="t2" >优秀</div>		
			</div>
			
		<!-- 	作业评语表单提交 -->
			<form action="" method="post"  >
				<div  class="c7" style="margin-left: 170px;">作业评语</div>
				<textarea style="resize: none;width: 430px;height: 125px;margin-left:-80px ;margin-top: 40px;float: left;border:1px dashed #c0c0c0;"></textarea>
				<input type="submit" value="提交"  class="btn-submit" style="float: right;margin-right: 47px;margin-top: -28px;" />
			</form>
		
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
<!-- <script>
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
	</script>	 -->
</body>

</html>