$(document).ready(function(){
	var username=getCookie("USERNAME");
	if(username==0){
		$("#header-login").html("");
		var buttons='<div class="btn-group">'
	                  +'<button class="btn" id="login_button" onclick="loginDis()">登录</button>'
	                  +'<button class="btn" id="register_button" onclick="registDis()">注册</button>'
	                  +'</div>';
		$("#header-login").append(buttons);
	}
	else{
		$("#header-login").html("");
		$("#header-login").append('<span style="text-decoration:none; font-size:18px; color:#ddf4df;white-space:nowrap;"><i>Honey</i>,'+'<strong style="font-size:20px;">'+username+'</strong>！</span><button class="btn btn-info" id="login_button" style="text-decoration:none; font-size:12px;border:none;position:relative;top:-34px;left:250px;" onclick="logout()">退出</button>');
	}
});
		// 页码
		// 登录保持
	// 获取指定名称的cookie的值
	function getCookie(name) {
		var strCookie = document.cookie;
		var arrCookie = strCookie.split("; ");
		for (var i = 0; i < arrCookie.length; i++) {
			var arr = arrCookie[i].split("=");
			if (arr[0] == name)
				return arr[1];
		}
		return "";
	} 
	function logout(){
		$.ajax({
			type : "post",
			url : "user/logout",
			datatype : "json",
			contentType : "application/json;charset=UTF-8",
			success : function(data) {
				if (data=="ok") {
					$("#header-login").html("");
					var buttons = '<div class="btn-group">'
							+ '<button class="btn" id="login_button" onclick="loginDis()">登录</button>'
							+ '<button class="btn" id="register_button" onclick="registDis()">注册</button>'
							+ '</div>';
					$("#header-login").append(buttons);
					window.location.reload();
				} else {
					login.style.display = "block";
					show.html('邮箱或密码错误');
				}
			}
		});
}