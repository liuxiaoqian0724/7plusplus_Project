$(document).ready(function(){
	var username=getCookie("USERNAME");
	if(username==0){
		$("#header-login").html("");
		var buttons='<a href="javascipt:void(0)" onclick="loginDis()">登录</a>'
	                  +'<a href="javascript:void(0)" onclick="registDis()">/注册</a>'
		$("#header-login").append(buttons);
	}
	else{
		$("#header-login").html("");
		$("#header-login").append('<span style="text-decoration:none; font-size:14px; color:#ddf4df;white-space:nowrap;"><i>Hello</i>,'+'<strong style="font-size:16px;">'+username+'</strong>！</span><button class="btn btn-info" id="login_button" style="text-decoration:none; width:50px; font-size:12px; position:relative; left:5%; top:-5%;" onclick="logout()">退出</button>');
	}
	var role=getCookie("ROLE");
	if(role=="老师"){
		$("#choose_button").append('<button class="btn btn-info" type="button" id="i_wonder_release" onclick="window.location.href=\'<%=basePath%>/sendmessageed.jsp\'"><i class="icon icon-pencil"></i>我要发布</button>');
	}
	// 调用
	datashow(currentpage);
	topage(currentpage);
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
					var buttons = '<a href="javascipt:void(0)" onclick="loginDis()">登录</a>'
		                  +'<a href="javascript:void(0)" onclick="registDis()">/注册</a>';
					$("#header-login").append(buttons);
					window.location.reload();
				} else {
					login.style.display = "block";
					show.html('邮箱或密码错误');
				}
			}
		});
	}
