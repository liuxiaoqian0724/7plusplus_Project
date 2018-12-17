//设置登录、注册按钮的点击效果
var identify = false;
var isPwd = false;
var isRePwd = false;
var isName = false;
var isEmail = false;
var isEIdentify = false;

function loginDis() {
	var abc = $(document.body).html();//JQ方式
	var login = document.getElementById("login");
	var register = document.getElementById("register");
	if (login.style.display == "block") {
		login.style.display = "none";
		document.getElementById('fade').style.display = 'none';
	} else {
		login.style.display = "block";
		document.getElementById('fade').style.display = 'block';
		abc.css = {
			"overflow-x" : "hidden",
			"overflow-y" : "hidden"
		}

	}
	register.style.display = "none";
	//禁止滚动条
	$(document.body).css({
		"overflow-x" : "hidden",
		"overflow-y" : "hidden"
	});

}
function registDis() {
	var abc = $(document.body).html();
	var login = document.getElementById("login");
	var register = document.getElementById("register");
	if (register.style.display == "block") {
		register.style.display = "none";
		document.getElementById('fade').style.display = 'none';
	} else {
		register.style.display = "block";
		document.getElementById('fade').style.display = 'block';
		abc.css = {
			"overflow-x" : "hidden",
			"overflow-y" : "hidden"
		}
	}
	login.style.display = "none";
	//禁止滚动条
	$(document.body).css({
		"overflow-x" : "hidden",
		"overflow-y" : "hidden"
	});
}
//注册验证
//这里的初始化是滑动&拼图的标志slideVerify
$('#mpanel1').slideVerify(
		{
			type : 2,
			mode : 'pop',
			vOffset : 5,
			vSpace : 5,
			explain : '向右滑动完成验证',
			imgUrl : '<%=basePath%>/images/',
			imgName : [ '1.jpg','2.jpg','3.jpg','4.jpg','5.jpg','6.jpg',
					'7.jpg','8.jpg','9.jpg','10.jpg','11.jpg','12.jpg',
					'13.jpg'],
			imgSize : {
				width : '422px',
				height : '200px',
			},
			blockSize : {
				width : '40px',
				height : '40px',
			},
			barSize : {
				width : '422px',
				height : '40px',
			},
			ready : function() {
			},
			success : function() {
				identify = true;
			},
			error : function() {
				identify = false;
			}

		});
//表单验证
function checkName(){
		var username = $('#username').val();
		var nameError =$('#nameError');
		if(username == ""){
			nameError.html('用户名不能为空！<label class="input-control-icon-right"><img alt="" src="images/icon/error.png" style="width:20px; height:20px; position:relative; margin-left:-15px;"></label>');
			isName = false;
		}else{
			nameError.html('<label class="input-control-icon-right"><img alt="" src="images/icon/ok.png" style="width:20px; height:20px; position:relative; margin-left:-15px;"></label>');
			isName = true;
		}
	}
function checkPwd(){
		var pwd = $('#password').val();
		var pwdError =$('#pwdError');
		var reg = /^[A-Za-z0-9]{6,16}$/;
		if(pwd == ""){
			isPwd = false;
			pwdError.html('密码不能为空！<label class="input-control-icon-right"><img alt="" src="images/icon/error.png" style="width:20px; height:20px; position:relative; margin-left:-15px;"></label>');
		}else if(!pwd.match(reg)){
			isPwd = false;
			pwdError.html('您的密码不符合格式要求！<label class="input-control-icon-right"><img alt="" src="images/icon/error.png" style="width:20px; height:20px; position:relative; margin-left:-15px;"></label>');
		}else{
			pwdError.html('<label class="input-control-icon-right"><img alt="" src="images/icon/ok.png" style="width:20px; height:20px; position:relative; margin-left:-15px;"></label>');
			isPwd = true;
		}
	}
function checkRePwd(){
		var rePwd = $('#repassword').val();
		var pwd = $('#password').val();
		var rePwdError =$('#rePwdError');
		if(rePwd==""){
			isRePwd = false;
			rePwdError.html('密码不能为空！<label class="input-control-icon-right"><img alt="" src="images/icon/error.png" style="width:20px; height:20px; position:relative; margin-left:-15px;"></label>');
		}else if(rePwd!=pwd){
			isRePwd = false;
			rePwdError.html('两次密码不一致！<label class="input-control-icon-right"><img alt="" src="images/icon/error.png" style="width:20px; height:20px; position:relative; margin-left:-15px;"></label>');
		}else{
			isRePwd = true;
			rePwdError.html('<label class="input-control-icon-right"><img alt="" src="images/icon/ok.png" style="width:20px; height:20px; position:relative; margin-left:-15px;"></label>');
		}
	}
function switchMSG(times, ele, txt) {
	ele.attr('disabled', true)
	var idT = setInterval(function() {
		if (times < 1) {
			ele.html(txt)
			ele.attr('disabled', false)
			clearInterval(idT)
		} else {
			ele.html('  ' + times + ' s')
			times--
		}
	}, 1000)
}
function sendEmail() {
	var btn = $('#send');
	var EmailError = $('#emailError');
	var info = {
		"email" : $("#email").val()
	}
	$.ajax({
		type : "post",
		url : "emailreg/send",
		data : JSON.stringify(info),
		datatype : "json",
		contentType : "application/json;charset=UTF-8",
		success : function(data) {
			if (data == "ok") {
				switchMSG(59, btn, "重新发送")
				EmailError.html("邮件发送成功！");
			} else {
				$("#send").attr("disabled", false);
				EmailError.html('邮件发送失败，点击重新发送！');
			}
		}

	});

}
function checkEmail() {
	var email = $('#email').val();
	var EmailError = $('#emailError');
	var mailReg = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
	if (email == "") {
		isEmail = false;
		$("#send").attr("disabled",true);
		EmailError.html('邮箱不能为空！<label class="input-control-icon-right"><img alt="" src="images/icon/error.png" style="width:20px; height:20px; position:relative; margin-left:-230px;"></label>');
	} else if (!email.match(mailReg)) {
		isEmail = false;
		$("#send").attr("disabled", true);
		EmailError.html('邮箱格式不正确！<label class="input-control-icon-right"><img alt="" src="images/icon/error.png" style="width:20px; height:20px; position:relative; margin-left:-230px;"></label>');
	} else {
		var info = {
			"email" : $("#email").val()
		}
		$.ajax({
			type : "post",
			url : "emailreg/check",
			data : JSON.stringify(info),
			datatype : "json",
			contentType : "application/json;charset=UTF-8",
			success : function(data) {
				if (data == "ok") {
					isEmail = true;
					$("#send").attr("disabled", false);
					EmailError.html('<label class="input-control-icon-right"><img alt="" src="images/icon/ok.png" style="width:20px; height:20px; position:relative; margin-left:-230px;"></label>');
				} else {
					isEmail = false;
					$("#send").attr("disabled", true);
					EmailError.html('该邮箱已经被注册！<label class="input-control-icon-right"><img alt="" src="images/icon/error.png" style="width:20px; height:20px; position:relative; margin-left:-230px;"></label>');
				}
			}

		});
	}
}

function submitData() {
	if (checkRegist()) {
		var info = {
			"username" : $("#username").val(),
			"sex" : $("input[name='sex']:checked").val(),
			"password" : $("#password").val(),
			"email" : $("#email").val(),
			"roles" : $("input[name='roles']:checked").val()
		}
		$.ajax({
			type : "post",
			url : "user/regist",
			data : JSON.stringify(info),
			datatype : "json",
			contentType : "application/json;charset=UTF-8",
			success : function(data) {
				if (data == "ok") {
					if ($("input[name='roles']:checked").val() == "家长") {
						window.location.href = "student-personal-center-evaluation.jsp"
					} else {
						window.location.href = "teacher-personal-center-evaluation.jsp"
					}
				}
			}

		});
	}
}
function checkEIdentify() {
	var EIdentify = $('#EIdentify').val();
	var EIdentifyError = $('#EIdentifyError');
	if (EIdentify == "") {
		isEIdentify = false;
		EIdentifyError.html('验证码不能为空！');
	} else {
		var info = {
			"email" : $("#email").val(),
			"authCode" : $('#EIdentify').val(),
			"type" : "reg"
		}
		$.ajax({
			type : "post",
			url : "authcode/verify",
			data : JSON.stringify(info),
			datatype : "json",
			contentType : "application/json;charset=UTF-8",
			success : function(data) {
				if (data == "succeed") {
					EIdentifyError.html('验证码正确<label class="input-control-icon-right"><img alt="" src="images/icon/ok.png" style="width:20px; height:20px; position:relative; margin-left:-15px;"></label>');
					isEIdentify = true;
				} else {
					EIdentifyError.html('验证码错误<label class="input-control-icon-right"><img alt="" src="images/icon/error.png" style="width:20px; height:20px; position:relative; margin-left:-15px;"></label>');
					isEIdentify = false;
				}
			}

		});

	}
}
function checkRegist() {
	var allError = $('#allError');
	var principle = $('#principle');
	if (isName && isPwd && isRePwd && isEmail && isEIdentify && identify) {
		if (principle.prop('checked')) {
			allError.html('');
			return true;
		} else {
			allError.html('注册需要您接受本网站协议！<label class="input-control-icon-right"><img alt="" src="images/icon/error.png" style="width:20px; height:20px; position:relative; margin-left:-15px;"></label>');
			return false;
		}

	} else {
		allError.html('请确保您的信息完整，请认真填写！<label class="input-control-icon-right"><img alt="" src="images/icon/error.png" style="width:20px; height:20px; position:relative; margin-left:-15px;"></label>');
		return false;
	}
}
//关闭弹框
function closeframe() {
	var abc = $(document.body).html();
	var register = document.getElementById("register");
	var login = document.getElementById("login");
	register.style.display = "none";
	login.style.display = "none";
	document.getElementById('fade').style.display = 'none';
	//启用滚动条
	$(document.body).css({
		"overflow-x" : "auto",
		"overflow-y" : "auto"
	});
}

//登录验证
function logincheck() {
	var useremail = $("#login_email").val();
	var password = $("#login_password").val();
	var show = $("#show");
	if (useremail == "" || password == "") {
		show.html("邮箱或密码为空！");
		return false;
	} else {
		show.html("");
		return true;
	}
}



 