<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<!--css引入-->
<link rel="stylesheet" href="<%=basePath%>/dist/css/zui.css" />
<link rel="stylesheet" href="<%=basePath%>/css/cityLayout.css" />
<link rel="stylesheet" href="<%=basePath%>/css/header.css" />
<link rel="stylesheet" href="<%=basePath%>/css/footer.css" />
<link rel="stylesheet" href="<%=basePath%>/css/sendmessageed.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/css/register_login.css" />
<link rel="stylesheet" href="<%=basePath%>/css/verify.css" />
<!--js引入-->
<script type="text/javascript" src="<%=basePath%>/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="<%=basePath%>/dist/js/zui.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/cityselect.js"></script>
<script src="<%=basePath%>/js/verify.js"></script>
<script src="<%=basePath%>/js/verify.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/js/checkLogin_regist.js"></script>

<title>求职信息发布</title>
</head>

<body>
	<!--导航栏开始-->
	<jsp:include page="header.jsp"></jsp:include>
	<!--导航栏结束-->

	<!--面板开始-->
	<div class="container-fixed">
		<div class="panel panel-success">
			<div class="panel-heading">
				<h2>求职信息发布</h2>
			</div>
			<form>
				<div class="panel-body">
					<ul class="list-group">
						<!--科目选择-->
						<li class="list-group-item"><label>科目（点击加号即可添加）*</label><br />
							<label>
								<button class="btn color-success" onclick="addSub(this)">语文<span class="label label-badge"
										style="background-color: #CCCCCC">+</span>
								</button>
								<button class="btn color-success" onclick="addSub(this)">数学<span class="label label-badge"
										style="background-color: #CCCCCC">+</span>
								</button>
								<button class="btn color-success" onclick="addSub(this)">英语<span class="label label-badge"
										style="background-color: #CCCCCC">+</span>
								</button>
								<button class="btn color-success" onclick="addSub(this)">历史<span class="label label-badge"
										style="background-color: #CCCCCC">+</span>
								</button>
								<button class="btn color-success" onclick="addSub(this)">地理<span class="label label-badge"
										style="background-color: #CCCCCC">+</span>
								</button>
								<button class="btn color-success" onclick="addSub(this)">化学<span class="label label-badge"
										style="background-color: #CCCCCC">+</span>
								</button>
								<button class="btn color-success" onclick="addSub(this)">生物<span class="label label-badge"
										style="background-color: #CCCCCC">+</span>
								</button>
								<button class="btn color-success" onclick="addSub(this)">音乐<span class="label label-badge"
										style="background-color: #CCCCCC">+</span>
								</button>
						</label> <input type="text" name="subject" class="form-control"
							id="subject" placeholder="例如数学，多个科目用;隔开" disabled="true">
						</li>
						<!--授课年级-->
						<li class="list-group-item"><label>授课年级（点击加号即可添加）*</label><br />
							<label> <span>小学：</span>
								<button class="btn color-success" onclick="addGra(this)">一年级<span class="label label-badge"
										style="background-color: #CCCCCC">+</span>
								</button>
								<button class="btn color-success" onclick="addGra(this)">二年级<span class="label label-badge"
										style="background-color: #CCCCCC">+</span>
								</button>
								<button class="btn color-success" onclick="addGra(this)">三年级<span class="label label-badge"
										style="background-color: #CCCCCC">+</span>
								</button>
								<button class="btn color-success" onclick="addGra(this)">四年级<span class="label label-badge"
										style="background-color: #CCCCCC">+</span>
								</button>
								<button class="btn color-success" onclick="addGra(this)">五年级<span class="label label-badge"
										style="background-color: #CCCCCC">+</span>
								</button>
								<button class="btn color-success" onclick="addGra(this)">六年级<span class="label label-badge"
										style="background-color: #CCCCCC">+</span>
								</button>
						</label> <br /> <label> <span>初中：</span>
								<button class="btn color-success" onclick="addGra(this)">初一 <span class="label label-badge"
										style="background-color: #CCCCCC">+</span>
								</button>
								<button class="btn color-success" onclick="addGra(this)">初二 <span class="label label-badge"
										style="background-color: #CCCCCC">+</span>
								</button>
								<button class="btn color-success" onclick="addGra(this)">初三 <span class="label label-badge"
										style="background-color: #CCCCCC">+</span>
								</button>
						</label> <br /> <label> <span>高中：</span>
								<button class="btn color-success" onclick="addGra(this)">高一 <span class="label label-badge"
										style="background-color: #CCCCCC">+</span>
								</button>
								<button class="btn color-success" onclick="addGra(this)">高二 <span class="label label-badge"
										style="background-color: #CCCCCC">+</span>
								</button>
								<button class="btn color-success" onclick="addGra(this)">高三 <span class="label label-badge"
										style="background-color: #CCCCCC">+</span>
								</button>
						</label> <input type="text" class="form-control" id="grade"
							placeholder="例如初三，多个年级用;隔开" disabled="true"></li>
						<!--授课时间表格-->
						<li class="list-group-item"><label>授课时间（点击表格选择）*</label>
							<table class="time_table png_img table table-bordered"
								style="width: 675px;">
								<thead>
									<tr>
										<th></th>
										<th>周一</th>
										<th>周二</th>
										<th>周三</th>
										<th>周四</th>
										<th>周五</th>
										<th>周六</th>
										<th>周日</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th>上午</th>
										<td data-id="1"><a href="javascript:void(0)"> <img
												src="<%=basePath%>/images/icon/error.png" alt=" "></a></td>
										<td data-id="4"><a href="javascript:void(0)"><img
												src="<%=basePath%>/images/icon/error.png" alt=" "></a></td>
										<td data-id="7"><a href="javascript:void(0)"><img
												src="<%=basePath%>/images/icon/error.png" alt=" "></a></td>
										<td data-id="10"><a href="javascript:void(0)"><img
												src="<%=basePath%>/images/icon/error.png" alt=" "></a></td>
										<td data-id="13"><a href="javascript:void(0)"><img
												src="<%=basePath%>/images/icon/error.png" alt=" "></a></td>
										<td data-id="16"><a href="javascript:void(0)"><img
												src="<%=basePath%>/images/icon/error.png" alt=" "></a></td>
										<td data-id="19"><a href="javascript:void(0)"><img
												src="<%=basePath%>/images/icon/error.png" alt=" "></a></td>
									</tr>
									<tr>
										<th>下午</th>
										<td data-id="2"><a href="javascript:void(0)"><img
												src="<%=basePath%>/images/icon/error.png" alt=" "></a></td>
										<td data-id="5"><a href="javascript:void(0)"><img
												src="<%=basePath%>/images/icon/error.png" alt=" "></a></td>
										<td data-id="8"><a href="javascript:void(0)"><img
												src="<%=basePath%>/images/icon/error.png" alt=" "></a></td>
										<td data-id="11"><a href="javascript:void(0)"><img
												src="<%=basePath%>/images/icon/error.png" alt=" "></a></td>
										<td data-id="14"><a href="javascript:void(0)"><img
												src="<%=basePath%>/images/icon/error.png" alt=" "></a></td>
										<td data-id="17"><a href="javascript:void(0)"><img
												src="<%=basePath%>/images/icon/error.png" alt=" "></a></td>
										<td data-id="20"><a href="javascript:void(0)"><img
												src="<%=basePath%>/images/icon/error.png" alt=" "></a></td>
									</tr>
									<tr>
										<th>晚上</th>
										<td data-id="3"><a href="javascript:void(0)"><img
												src="<%=basePath%>/images/icon/error.png" alt=" "></a></td>
										<td data-id="6"><a href="javascript:void(0)"><img
												src="<%=basePath%>/images/icon/error.png" alt=" "></a></td>
										<td data-id="9"><img
											src="<%=basePath%>/images/icon/error.png " alt=" "></td>
										<td data-id="12"><a href="javascript:void(0)"><img
												src="<%=basePath%>/images/icon/error.png" alt=" "></a></td>
										<td data-id="15"><a href="javascript:void(0)"><img
												src="<%=basePath%>/images/icon/error.png" alt=" "></a></td>
										<td data-id="18"><a href="javascript:void(0)"><img
												src="<%=basePath%>/images/icon/error.png" alt=" "></a></td>
										<td data-id="21"><a href="javascript:void(0)"><img
												src="<%=basePath%>/images/icon/error.png" alt=" "></a></td>
									</tr>
								</tbody>
							</table></li>
						<!--工作经历-->
						<li class="list-group-item "><label>工作经历*</label> <textarea
								class="form-control" id="experience" rows="3"
								placeholder="请输入您的工作经历"></textarea></li>
						<!--成功案例-->
						<li class="list-group-item "><label>成功案例*</label> <textarea
								class="form-control" id="success" rows="3"
								placeholder="请输入您的成功案例"></textarea></li>
						<!--教龄-->
						<li class="list-group-item "><label>教龄*</label> <select
							class="form-control" id="teachAge" placeholder="请选择教龄区间">
								<option value="0-2">0-2年</option>
								<option value="2-5">2-5年</option>
								<option value="5-10">5-10年</option>
								<option value="10-">10年以上</option>
						</select></li>
						<!--课时价格选择-->
						<li class="list-group-item "><label>课时价格*</label>
							<div class="row">
								<div class="col-xs-2">
									<input type="text" id="min" class="form-control"
										placeholder="最低价格">
								</div>
								<div class="col-xs-3">每课时（具体价格可以商量）</div>
							</div></li>
						<!--地点选择框-->
						<li class="list-group-item "><label>地点*</label> <input
							name=" " id="citySelect" type="text" class="city_input"
							readonly="readonly"></li>
						<!--同意框-->
						<li class="list-group-item ">
							<div class="checkbox">
								<label> <input type="checkbox" id="rules">
									我同意求职信息发布准则
								</label>
							</div>
							<div class="checkbox">
								<label> <input type="checkbox" id="principles">
									我同意网站相关规定
								</label>
							</div>
						</li>
						<!--提示框-->
						<li class="list-group-item" id="error-msg"
							style="color: red; font-size: 18px;">带*标的为必填项，请您认真如实填写。</li>
					</ul>
				</div>
				<div class="panel-footer ">
					<input type="button" value="保存发布信息"
						class="btn btn-block btn-primary" onclick="submitMessage()" />
				</div>
			</form>
		</div>
	</div>

	<!-- footer开始 -->

	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript" src="<%=basePath%>/js/sendmessage.js"></script>
	<!-- footer结束 -->
</body>

</html>
