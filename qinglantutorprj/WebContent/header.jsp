<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

 <div id="header-box">
    		<div id="big-box">
    			<!-- logo -->
    			<div id="top-box">
    				<div id="top-box-logo">
    					<img src="<%=basePath%>/images/headerlogo.png" alt="logo" id="logoPic">
    					<img src="<%=basePath%>/images/nameTop.png" alt="namePic" style="width:12%;">
    				</div>
    			</div>
    		</div>
    			<!-- 下拉菜单 -->
    			<div id="bottom-box">
    				<div id="topBox2">
    					<ul id="navFont">
    					<li class="navFont1"><a href="<%=basePath%>/index.jsp">首页</a></li>
    					<li><a href="search/家教">家教</a>
    						<ul>
    							<li><a href="search/小学">小学</a></li>
    							<li><a href="search/初中">初中</a></li>
    							<li><a href="search/高中">高中</a></li>
    						</ul>
    					</li>
    					<li><a href="#">论坛社区</a>
    						<ul>
    							<li><a href="#">学霸说</a></li>
    							<li><a href="#">资料库</a></li>
    							<li><a href="#">家长岛</a></li>
    						</ul>
    					</li>
    					<li><a href="#">我要提问</a>
    						<ul>
    							<li><a href="#">心理困惑</a></li>
    							<li><a href="#">情感问题</a></li>
    							<li><a href="#">学习障碍</a></li>
    						</ul>
    					</li>
    					<li><a href="#">个人中心</a></li>
    				</ul>
    				<!-- 登录注册 -->
    				<div id="header-login">
    					<a href="javascipt:void(0)" onclick="loginDis()">登录</a>
    					<a href="javascript:void(0)" onclick="registDis()">/注册</a>
    				</div>
    			</div>
    		</div>
    		<!-- 搜索框 -->
   			<div class="input-group" id="searchboxExample">
 				<div class="input-control search-box search-box-circle has-icon-left has-icon-right search-example">
   					<input id="inputSearchExample3" type="search" class="form-control search-input" placeholder="请输入搜索科目">
   					<label for="inputSearchExample3" class="input-control-icon-left search-icon"><i class="icon icon-search"></i></label>
 				</div>
  				<span class="input-group-btn">
    				<button class="btn btn-info" type="submit">搜索</button>
  				</span>
			</div>
    	</div>



      	<!--登录-->
      	<div id="login" style="display: none;" class="popup">
      		<div id="login_title">
      			<h1>登录</h1>
      		</div>
      		<div id="closeframe">
      			<button id="closebutton" onclick="closeframe()"><i class="icon icon-times"></i></button>
      		</div>
      		<form id="login_form">
      			<!--邮箱-->
      			<div class="input-control has-icon-left" style="width:361px">
      				<input id="login_useremail" type="text" class="form-control" placeholder="邮箱" name="email">
      				<label for="inputAccountExample1" class="input-control-icon-left"><i class="icon icon-user "></i></label>
      			</div>
      			<h5></h5>
      			<!--密码-->
      			<div class="input-control has-icon-left" style="width:361px">
      				<input id="login_password" type="password" class="form-control" placeholder="密码" name="password">
      				<label for="inputPasswordExample1" class="input-control-icon-left"><i class="icon icon-key"></i></label>
      			</div>
      			<h5></h5>
      			<!--按钮-->
      			<button class="btn btn-info" type="button">忘记密码</button>
      			<button class="btn btn-info" type="button" style="margin-left:200px">免费注册</button>
      			<h5></h5>
      			<button class="btn btn-info" type="button" style="width:361px" id="loginnow" onclick='logInNow()'>立即登录</button>
      			<br/><span id="show" style="color:red; font-size='15px';"></span>
      		</form>
      		<!--二维码-->
      		<div id="login_qrcode">
      			<button class="btn btn-info " type="button" style="width:180px;">免费注册</button>
      			<img src="<%=basePath%>/images/qrcode.jpg">
      			<p>扫描二维码获得更多动态信息</p>
      		</div>
      	</div>
      	<div class="panel" id="register"style="display:none;">
      		<div id="register_title">
      			<h1>会员注册</h1>
      			<h3></h3>
      		</div>
      		<div id="closeframe">
      			<button id="closebutton" onclick="closeframe()"><i class="icon icon-times"></i></button>
      		</div>
        		<div class="panel-body">
        			<form class="form-horizontal" onsubmit="return checkRegist()" id="info">
        				<!--用户名-->
        				<div class="form-group">
          				<label for="exampleInputAccount4" class="col-sm-2">用户名</label>
          				<div class="col-md-6 col-sm-10">
            					<input type="text" class="form-control" id="username" placeholder="请输入1-6位的汉字、英文、数字、下划线" onblur="checkName()">
            					<span id="nameError" style="color: red;font-size: 17px;">
            					</span>
          				</div>
        				</div>
      				<!--性别-->
      				<div id="sex">
      					<label for="exampleInputAccount4" class="col-sm-2">性别</label>
      					<label class="radio-inline">
      						<input type="radio" name="sex" value="男"> 男
      					</label>
      					<label class="radio-inline" style="margin-left: 100px;">
      						<input type="radio" name="sex" checked="checked" value="女"> 女
      					</label>
      				</div>
        				<!--密码-->
        				<div class="form-group">
          				<label for="exampleInputPassword4" class="col-sm-2">密码</label>
          				<div class="col-md-6 col-sm-10">
            					<input type="password" class="form-control" id="password" placeholder="密码的格式为6-16位，只能是字母、数字和下划线" onblur="checkPwd()">
            					<span id="pwdError" style="color: red;font-size: 17px;">
            					</span>
          				</div>
        				</div>
        				<!--确认密码-->
        				<div class="form-group">
          				<label for="exampleInputPassword4" class="col-sm-2">确认密码</label>
          				<div class="col-md-6 col-sm-10">
            					<input type="password" class="form-control" id="repassword" placeholder="确认密码" onblur="checkRePwd()">
            					<span id="rePwdError" style="color: red;font-size: 17px;">
            					</span>
          				</div>
        				</div>
        				<!--邮箱-->
        				<div class="form-group">
          				<label for="exampleInputAccount4" class="col-sm-2">邮箱</label>
          				<div class="col-md-6 col-sm-10">
            					<input type="text" class="form-control" id="email" placeholder="邮箱名" style="width:320px;"onblur="checkEmail()">
            					<span id="emailError" style="color: red;font-size: 17px;">
            					</span>
            					<button class="btn btn-info" type="button" style="float:right; margin-top:-32px;width:20%;" id="send" onclick="sendEmail()" disabled="true">发送验证码</button>
          				</div>
        				</div>
        				<!--图形验证-->
        				<div class="form-group">
          				<label for="exampleInputAccount4" class="col-sm-2">图形验证</label>
          				<div id="mpanel1" style="margin-left: 157px;">
      					</div>
      					<span id="identifyError" style="color: red;font-size: 17px;">
            					</span>
        				</div>
        				<!--邮箱验证码-->
        				<div class="form-group">
          				<label for="exampleInputAccount4" class="col-sm-2">邮箱验证码</label>
          				<div class="col-md-6 col-sm-10">
            					<input type="text" class="form-control" id="EIdentify" placeholder="请注意查收邮件" onblur="checkEIdentify()">
            					<span id="EIdentifyError" style="color: red;font-size: 17px;">
            					</span>
          				</div>
        				</div>
        				<!--角色-->
        				<div id="role">
        					<label for="exampleInputAccount4" class="col-sm-2">角色</label>
      	  				<label class="radio-inline">
      	  					<input type="radio" name="roles" value="家长"> 家长
      					</label>
      					<label class="radio-inline" style="margin-left: 100px;">
      	  					<input type="radio" name="roles" checked="checked" value="老师"> 老师
      					</label>
        				</div>
        				<!--协议-->
        				<div class="form-group">
          				<div class="col-sm-offset-2 col-sm-10">
            					<div class="checkbox" style="margin-left: 100px;">
                					<input type="checkbox" id="principle">我已阅读并同意家教用户网站协议
            					</div>
          				</div>
        				</div>
        				<span id="allError" style="color: red;margin-left: 220px;font-size: 18px;"></span>
        				<!--注册按钮-->
        				<div class="form-group">
          				<div class="col-sm-offset-2 col-sm-10">
            					<input onclick="submitData()" type="button" value="提交" class="btn btn-info" style="width: 58%;">
          				</div>
        				</div>
      			</form>
        		</div>
        		<!--二维码-->
        		<div id="register_qrcode">
      			<button class="btn btn-info " type="button" style="width:180px;">免费注册</button>
      			<img src="<%=basePath%>/images/qrcode.jpg">
      			<p>扫描二维码获得更多动态信息</p>
      		</div>
      	</div>
