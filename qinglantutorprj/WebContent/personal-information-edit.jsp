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
	<title>个人信息修改页</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<meta name="format-detectison" content="telephone=no">
	<base href="<%=basePath%>">
	<!-- ZUI 标准版压缩后的 CSS 文件 -->
	<link rel="stylesheet" type="text/css" href="css/personal-teacher-information-edit.css">
	<link rel="stylesheet" type="text/css" href="css/header.css" />
	<link rel="stylesheet" type="text/css" href="css/footer.css" />
	<link rel="stylesheet" type="text/css" href="css/register_login.css"/>
	<link rel="stylesheet" href="css/cropper.min.css">
	<link rel="stylesheet" href="css/ImgCropping.css">
	<link rel="stylesheet" type="text/css" href="css/normalize.css">
	<link rel="stylesheet" type="text/css" href="css/jquery-school-seletor.css">	
	
	
	<!-- ZUI 标准版压缩后的 JavaScript 文件 -->
	<script src="js/jquery-3.2.1.js"></script>
	
	<script src="js/cropper.min.js"></script>
	<script src="js/jquery-school-seletor.min.js"></script>
	
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
			<div>
				<a href="jumptoNews"><i class="icon icon-arrow-left icon-1x"></i>返回个人中心</a>
			</div><br>
			<span class="c1-item">个人信息</span>
		</div>
		<form action="" target="nm_iframe" method="post" class="form-horizontal" onsubmit="return checkAll('${user.role }')">
			<div id="c2">
				<div id="c2-left">
					<span>个人信息验证</span>
					<div id="c2-left-left" class="c2-left-item">
						<div class="form-group">
							<label for="exampleInputPassword4" class="col-sm-2" >真实姓名</label>
							<div class="col-md-6 col-sm-10">
								<input type="text" class="form-control" id="personName" placeholder="姓名需与学生证一致" onblur="checkName()" value="${user.realName }">
								<span id="personNameError" style="color: red;"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="exampleInputAccount4" class="col-sm-2" >身份证号</label>
							<div class="col-md-6 col-sm-10">
								<input type="text" class="form-control" id="personId" placeholder="18位身份证号" onblur="checkPersonId()" value="${user.idNumber }">
								<span id="personIdError" style="color: red;"></span>
							</div>
					</div>

						<div style="margin-left: 15px;">
							<label for="exampleInputAccount4" class="col-sm-2">身份证</label>
							<div style="width: 200px;height: 200px;border:1px solid #c0c0c0;padding: 5px;margin-top: 10px;margin-left: 70px;">
								<img id="finalImg"  width="100%" height="100%" style="margin-top:-18px;" src="${user.stuImg }">
							</div>
							<!--<button id="replaceImg" class="l-btn">上传身份证</button>-->
							<input type="button" name="上传头像" value="上传身份证" id="replaceImg" class="my-btn" onblur="checkStudentId()" style="outline:none;">
							<span id="studentIdError" style="color: red;"></span>
						</div>
						<div id="myphoto">
							<div style="width:80px;height:200px;">
								<label for="exampleInputAccount4" class="col-sm-2" >我的照片</label>
							</div>
							<div id="photos">
								<div id="img1">
									<button type="button" onclick="photoremove('img1')"><i class="icon icon-times icon-2x"></i></button>
									<img alt="" src="${user.img1 }" width="100%" height="100%">
									<input type="file" name="file"  class="img1" onchange="photosupload('img1')">
									<input type="button" name="上传头像" value="">
								</div>
								<div id="img2">
									<button type="button" onclick="photoremove('img2')"><i class="icon icon-times icon-2x"></i></button>
									<img alt="" src="${user.img2 }" width="100%" height="100%">
									<input type="file" name="file"  class="img2" onchange="photosupload('img2')">
									<input type="button" name="上传头像" value="">
								</div>
								<div id="img3">
									<button type="button" onclick="photoremove('img3')"><i class="icon icon-times icon-2x"></i></button>
									<img alt="" src="${user.img3 }" width="100%" height="100%">
									<input type="file" name="file"  class="img3" onchange="photosupload('img3')">
									<input type="button" name="上传头像" value="">
								</div>
								<div id="img4">
									<button type="button" onclick="photoremove('img4')"><i class="icon icon-times icon-2x"></i></button>
									<img alt="" src="${user.img4 }" width="100%" height="100%">
									<input type="file" name="file"  class="img4" onchange="photosupload('img4')">
									<input type="button" name="上传头像" value="">
								</div>
							</div>
						</div>
					</div>
					<div id="c2-left-right" class="c2-left-item">
						<img src="${user.userImg }" width="150px" height="150px" class="img-circle" alt="圆形图片" id="photo"><br>
						<span>我的头像</span>
						<input type="file" id="choosePhoto" name="file" accept="image/*">
						<input type="button" name="上传头像" value="上传头像">
					</div>
				</div>
				<div id="c2-right">
					<img src="images/code.png">
					<p>扫描二维码获取更多信息</p>
				</div>
			</div>
			<div id="c3" style="position:relative;">
				<span>完善个人信息</span>
				<c:choose>
					<c:when test="${user.role == '学生' }">
						<div class="form-group">
							<label for="exampleInputPassword4" class="col-sm-2">手机号</label>
							<div class="col-md-6 col-sm-10">
								<input type="text" class="form-control" id="phoneNum" value="${user.phoneNumber }" placeholder="11位手机号" onblur="checkPhoneNum()">
								<span id="phoneNumError" style="color: red;"></span>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div class="form-group">
							<label class="col-sm-2">我的学校</label>
							<div class="col-md-6 col-sm-10">
								<input type="text" id="schoolName" value="${user.school }" class="form-control" placeholder="点击选择学校" onblur="checkSchoolName()"/>
								<span id="schoolError" style="color: red;"></span>
							</div>
						</div>
						<div class="form-group" id="grade">
							<label for="exampleInputPassword4" class="col-sm-2">选择年级</label>
							<select class="form-control" style="margin-left: 103px;">
								<option value="大一">大一</option>
								<option value="大二">大二</option>
								<option value="大三">大三</option>
								<option value="大四">大四</option>
								<option value="研一">研一</option>
								<option value="研二">研二</option>
								<option value="研三">研三</option>
							</select>
						<script type="text/javascript">
							$(function() {  
								if(${empty user.grade }){
									$("#grade > select").get(0).value = '大一';	
								}else{
									$("#grade > select").get(0).value = '${user.grade }';	
								}
							})
						</script>		
						</div>
						<div class="form-group">
							<label for="exampleInputPassword4" class="col-sm-2">手机号</label>
							<div class="col-md-6 col-sm-10">
								<input type="text" class="form-control" id="phoneNum" value="${user.phoneNumber }" placeholder="11位手机号" onblur="checkPhoneNum()">
								<span id="phoneNumError" style="color: red;"></span>
							</div>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword4" class="col-sm-2">我的地址</label>
							<div class="col-md-6 col-sm-10">
								<input type="text" class="form-control" id="address" value="${user.address }" placeholder="请输入地址" onblur="checkAddress()">
								<span id="addressError" style="color: red;"></span>
							</div>
						</div>
						<div class="form-group" > 
							<label for="exampleInputPassword4" class="col-sm-2">我的专业</label>
							<div class="col-md-6 col-sm-10" id="major">
								<c:choose>
									<c:when test="${user.major == '理科' }">
										<select name="selectMajor"  placeholder="我的专业" style="height: 30px;width: 80px;">
											<option value="理科" selected="selected">理科</option>
											<option value="文科">文科</option>
										</select>
									</c:when>
									<c:otherwise>
										<select name="selectMajor"  placeholder="我的专业" style="height: 30px;width: 80px;">
											<option value="理科">理科</option>   
											<option value="文科" selected="selected">文科</option>
										</select>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword4" class="col-sm-2">个人简介</label>
							<div class="col-md-6 col-sm-10">
								<textarea id="intro" class="form-control" 
								style="resize:none;height: 75px;" placeholder="请输入个人简介(非必须)">${user.introduce }</textarea>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-6 col-sm-10">
								<span id="error" style="color: red;"></span>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
				
				<input type="submit" name="保存信息" value="保存信息" style="position:absolute;bottom:60px;">
			</div>
		</form>
		
		<iframe id="id_iframe" name="nm_iframe" style="display:none;"></iframe>

		<!--图片裁剪框 start-->
		<div style="display: none" class="tailoring-container">
			<div class="black-cloth" onclick="closeTailor(this)"></div>
			<div class="tailoring-content">
				<div class="tailoring-content-one">
					<label title="上传图片" for="chooseImg" class="l-btn choose-btn">
                   <input type="file" accept="image/jpg,image/jpeg,image/png" name="file" id="chooseImg" class="hidden" onchange="selectImg(this)">
                   选择图片
               </label>
					<div class="close-tailoring" onclick="closeTailor(this)">×</div>
				</div>
				<div class="tailoring-content-two">
					<div class="tailoring-box-parcel">
						<img id="tailoringImg">
					</div>
					<div class="preview-box-parcel">
						<p>图片预览：</p>
						<div class="square previewImg"></div>
						<div class="circular previewImg"></div>
					</div>
				</div>
				<div class="tailoring-content-three">
					<button class="l-btn cropper-reset-btn">复位</button>
					<button class="l-btn cropper-rotate-btn">旋转</button>
					<button class="l-btn cropper-scaleX-btn">换向</button>
					<button class="l-btn sureCut" id="sureCut">确定</button>
				</div>
			</div>
		</div>
		<!--图片裁剪框 end-->
	</div>
	
	<!-- 底部 -->
	<jsp:include page="footer.jsp"></jsp:include>
	
	<script type="text/javascript" src="js/checkLogin_regist.js"></script>
	<script src="js/personal-information-check.js"></script>
</body>
</html>