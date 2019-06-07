<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String appContext = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ appContext + "/";
%>
<!DOCTYPE html>
<html>
<head>
<title>家教详情</title>
<meta charset="utf-8">
<base href="<%=basePath%>">

<link rel="stylesheet" type="text/css" href="css/tutordetailed.css">
<link rel="stylesheet" type="text/css" href="css/header.css" />
<link rel="stylesheet" type="text/css" href="css/footer.css" />
<link rel="stylesheet" type="text/css" href="css/register_login.css" />
<link rel="stylesheet" href="css/verify.css" />

<!--zui css-->
<link rel="stylesheet" href="dist/css/zui.min.css">
<link rel="stylesheet" href="dist/css/zui.css">
<link rel="stylesheet" href="dist/css/zui.lite.css">
<link rel="stylesheet" href="css/verify.css" />
<!-- <link rel="stylesheet" type="text/css" media="screen" href="https://cdn.staticfile.org/ionicons/2.0.1/css/ionicons.min.css"> -->

<!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
<script src="js/jquery-3.2.1.js"></script>
<!-- ZUI Javascript组件 -->
<script type="text/javascript" src="dist/js/zui.js"></script>
<script src="js/verify.js"></script>
<script src="js/verify.min.js"></script>
<!-- <script src="js/header.js"></script> -->
<!-- <script type="text/javascript" src="dist/lib/jquery/jquery.js"></script> -->
<script type="text/javascript" src="dist/js/zui.min.js"></script>
<script type="text/javascript" src="dist/js/zui.lite.js"></script>
<script src="js/header.js"></script>
<script src="js/nav.js"></script>


</head>
<body>
	<!--header-->
	<jsp:include page="header.jsp"></jsp:include>
	<!--//header结束  -->


	<!--content-->
	<div class="content">
		<!--内容的上半部分-->
		<div class="content-top">
			<!--面包屑-->
			<ol class="breadcrumb">
				<li><a href="indexed.html"><i class="icon icon-home"></i>&nbsp;Home</a></li>
				<li><a href="tutorlisted.html">石家庄家教老师</a></li>
				<li class="active">${user.realName}</li>
			</ol>
			<!--个人信息-->
			<div class="information">
				<!--左半部分 photo-->
				<div class="in-photo">
					<div class="bigimg">
						<div class="img">
							<img src="${user.img1}" width="320px" height="320px"
								class="img-rounded" alt="圆角图片">
						</div>
					</div>
					<div class="imgs">
						<ul>
							<!--数据库循环-->
							<li>
								<!-- <img data-toggle="lightbox" src="images/img4.jpg" data-image="images/big-img4.jpg" data-caption="小图看大图" class="img-thumbnail" id="img-spc" alt="" width="60"> -->
								<img src="${user.img1}" class="img-thumbnail" id="img-spc"
								width="60" data-image="${user.img1}">
							</li>
							<li>
								<!-- <img data-toggle="lightbox" src="images/img3.jpg" data-image="images/big-img3.jpg" data-caption="小图看大图" class="img-thumbnail" alt="" width="60px" height="60px"> -->
								<img src="${user.img2}" class="img-thumbnail" id="img-spc"
								width="60" data-image="${user.img2}">
							</li>
							<li>
								<!-- <img data-toggle="lightbox" src="images/img5.jpg" data-image="images/big-img5.jpg" data-caption="小图看大图" class="img-thumbnail" alt="" width="60"> -->
								<img src="${user.img3}" class="img-thumbnail" id="img-spc"
								width="60" data-image="${user.img3}">
							</li>
							<li>
								<!-- <img data-toggle="lightbox" src="images/img3.jpg" data-image="images/big-img3.jpg" data-caption="小图看大图" class="img-thumbnail" alt="" width="60"> -->
								<img src="${user.img4}" class="img-thumbnail" id="img-spc"
								width="60" data-image="${user.img4}">
							</li>
						</ul>
					</div>
				</div>
				<!--详细信息-->
				<div class="in-detail">
					<!--家教名-->
					<div class="de-name">
						<b>${user.realName}</b>
					</div>
					<!--数据库搜索家教的教龄、评价条数、是否认证信息  -->
					<div class="de-lineone">
						教龄：${user.myJobs[0].teacherAge}年&nbsp;&nbsp;|&nbsp;评价数：${reviewCount}条|&nbsp;&nbsp;<i
							class="icon1 ion-android-checkmark-circle"></i>&nbsp;已实名
					</div>
					<div class="de-linetwo">
						<div class="one">
							<!--数据库查询-->
							<span class="title">课时费：</span> <span class="price"><i
								class="icon icon-yen"></i>&nbsp;${user.myJobs[0].price}</span> <span
								class="hour">/小时</span>
							<!--根据数据库评价星级展示星星  -->
							<span class="star"> 
							<c:forEach begin="1" end="${user.teachRelations[0].classRelation[0].reviews[0].reviewStar}">
									<img src="images/fill-star.png"
										style="width: 20px; height: 20px;">
								</c:forEach> 
								<c:forEach begin="${user.teachRelations[0].classRelation[0].reviews[0].reviewStar}" end="4">
									<img src="images/empty-star.png"
										style="width: 20px; height: 20px;">
								</c:forEach>
							</span>
							<div class="separator1"></div>
							<span class="comment">
								<ul>
									<li>${reviewCount}</li>
									<li>用户评价</li>
								</ul>
							</span>
						</div>
						<!-- <div class="two">
   						<span class="title">认证服务</span>
                     <span class="aa"><i class="icon1 ion-android-checkmark-circle"></i>&nbsp;实名
                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     <i class="icon1 ion-android-checkmark-circle"></i>&nbsp;学历</span>
   					</div> -->
					</div>
					<div class="de-linefour">
						<span class="title1">授课时间</span>
						<table class="time_table png_img table table-bordered"
							style="width: 500px;">
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
							<!--循环输出家教可上课的时间，？？？问题待解决  -->
							<tbody>
								<tr>
									<th>上午</th>
									<c:forEach var="count" begin="1" step="3" end="19">
										<c:set var="flag" value="0"></c:set>
										<c:forEach items="${user.myJobs[0].times}" var="mytime">
											<c:choose>
												<c:when test="${flag==0}">
													<td data-id="${count}"><c:if
															test="${count==mytime.tid}">
															<img src="images/icon/ok.png" alt=" ">
															<c:set var="flag" value="1"></c:set>
														</c:if> <c:if test="${count!=mytime.tid}">
															<img src="images/icon/error.png" alt=" ">
															<c:set var="flag" value="1"></c:set>
														</c:if></td>
												</c:when>
											</c:choose>
										</c:forEach>
										<c:set var="flag" value="1"></c:set>
									</c:forEach>
								</tr>
								<tr>
									<th>下午</th>
									<c:forEach var="count" begin="2" step="3" end="21">
										<c:set var="flag" value="0"></c:set>
										<c:forEach items="${user.myJobs[0].times}" var="mytime">
											<c:choose>
												<c:when test="${flag==0}">
													<td data-id="${count}"><c:if
															test="${count==mytime.tid}">
															<img src="images/icon/ok.png" alt=" ">
															<c:set var="flag" value="1"></c:set>
														</c:if> <c:if test="${count!=mytime.tid}">
															<img src="images/icon/error.png" alt=" ">
															<c:set var="flag" value="1"></c:set>
														</c:if></td>
												</c:when>
											</c:choose>
										</c:forEach>
										<c:set var="flag" value="1"></c:set>
									</c:forEach>
								</tr>
								<tr>
									<th>上午</th>
									<c:forEach var="count" begin="3" step="3" end="22">
										<c:set var="flag" value="0"></c:set>
										<c:forEach items="${user.myJobs[0].times}" var="mytime">
											<c:choose>
												<c:when test="${flag==0}">
													<td data-id="${count}"><c:if
															test="${count==mytime.tid}">
															<img src="images/icon/ok.png" alt=" ">
															<c:set var="flag" value="1"></c:set>
														</c:if> <c:if test="${count!=mytime.tid}">
															<img src="images/icon/error.png" alt=" ">
															<c:set var="flag" value="1"></c:set>
														</c:if></td>
												</c:when>
											</c:choose>
										</c:forEach>
										<c:set var="flag" value="1"></c:set>
									</c:forEach>
								</tr>
							</tbody>
						</table>
					</div>
					<!--根据数据库查询老师可以教授的年级  -->
					<form method="post" id="inquire-teacher">
						<div class="de-linethree">
							<span class="title">授课年级</span>
							<div class="grade">
								<ul>
									<c:forEach items="${user.myJobs[0].grades}" var="grade">
										<li class="gradeli" value="${grade.gname}">${grade.gname}</li>
									</c:forEach>
								</ul>
								<!--隐藏域获取用户信息 -->
								<input type="hidden" value="${user.id}" id="hidden-UserId">
							</div>
						</div>
						<!--按钮-->
						<div class="de-linefive">
							<button class="btn1 btn-lg" type="button" id="inquire">联系ta</button>
					</form>
					<!--ajax向数据库增添用户消息 -->
					<script type="text/javascript">
                 $(document).ready(function(){
                	 $('.gradeli').on("click",function(){
                		 this.setAttribute("id", "chosenLi");
                		  });
                     $("#inquire").click(function(){
                         //序列化表单元素，返回json数据
                        var gradeChosen=$("#chosenLi").html();
                        var userId=$("#hidden-UserId").val();
                        var params={"userId":userId,"gradeChosen":gradeChosen};
                         $.ajax({
                             type:"POST",
                             contentType : 'application/json;charset=utf-8',
                             url:"tutorDetail/inquire",
                             data:JSON.stringify(params),
                             dataType : 'json',
                             success:function(date){
                            	 confirm("您好！已经向家教发送咨询信息，家教同意后会将家教联系方式反馈到个人中心-我的消息中。");
                             },
                             error:function(e) {
                                 alert("出错："+e);
                             }
                         })
                     });
                 });
                 </script>
					<!--//结束  ajax向数据库增添用户消息 -->

					<!-- <form action="tutorDetail/showtutorDetail" method="post"> -->
					<button class="btn1 btn-lg" type="button">预约</button>
					<!--  </form> -->
				</div>
			</div>
		</div>
	</div>
	<!--内容的中间部分-->
	<div class="content-middle">
		<!--中间的左半部分-->
		<div class="middle-left">
			<!--标签页-->
			<ul class="nav nav-tabs">
				<li class="active"><a data-tab href="#tabContent1">学生评价</a></li>
				<li><a data-tab href="#tabContent2">老师详情</a></li>
				<!-- <li><a data-tab href="#tabContent3">标签3</a></li> -->
			</ul>
			<div class="tab-content">
				<div class="tab-pane active" id="tabContent1">
					<div class="tabone-top">
						<div class="top-left">
							<p>满意率</p>
							<span>96.47%</span>
						</div>
						<div class="separator"></div>
						<div class="top-right">
							<p>大家都在说：</p>
							<div class="right-tab">
								<ul id="reviewTrend">
									<!--数据库查询-->
									<li id="reviewTrendcount">全部${reviewCount}</li>
<!-- 									<li class="reviewTrendli"></li> -->
								</ul>
							</div>
						</div>
					</div>
					<hr>
					<!--评价条件-->
					<div class="comment-conditions">
						<ul>
							<li id="rank">排序:</li>
							<a href="#"><li class="comment-condition">好评</li></a>
							<a href="#"><li class="comment-condition">中评</li></a>
							<a href="#"><li class="comment-condition">差评</li></a>
						</ul>
					</div>
					<hr>
					<!--ajax分页显示该家教名下的评论-->
					<div class="comments">
					</div>
					<div class="page">
							<ul class="pager" id="pager" style="width:300px; position:relative; left:41%;">
							<li>1</li>
						</ul>
						</div>
				</div>
				<div class="tab-pane" id="tabContent2">
					<!--教学经历-->
					<div class="successcase">
						<p class="successtitle">
							<!-- &nbsp;&nbsp; -->
							<i class="icon2 icon-file-text-o"></i>&nbsp;&nbsp;&nbsp;教学经历
						</p>
						<div class="cases">
							<!--数据库循环展示家教教学案例-->
							<div class="case">
								<p class="ca-title">奥数从不入门到获奖</p>
								<div class="ca-content">${user.myJobs[0].experience }</div>
							</div>
							<div class="dashed"></div>
							<div class="hidecase">
								<div class="dashed"></div>
								<div class="case">
									<p class="ca-title">奥数从不入门到获奖</p>
									<div class="ca-content">${user.myJobs[0].experience }</div>
								</div>
								<div class="dashed"></div>
								<div class="case">
									<p class="ca-title">奥数从不入门到获奖</p>
									<div class="ca-content">${user.myJobs[0].experience }</div>
								</div>
							</div>
						</div>
						<!--更多-->
						<div class="box">
							<span class="line"></span> <span class="text">查看更多<i
								class="icon icon-angle-down" id="ii"></i></span> <span class="line"></span>
						</div>
					</div>
					<!--h成功案例-->
					<div class="teaex">
						<p class="teaextitle">
							<i class="icon2 icon-file-text-o"></i>&nbsp;&nbsp;&nbsp;成功案例
						</p>
						<div class="teacase">
							<!--时间-->
							<p class="teaextime">2011/02—至今</p>
							<p class="teaextag">知名学校数学老师</p>
							<p class="teaexwork">${user.myJobs[0].success}</p>
						</div>
						<div class="dashed"></div>
						<div class="teacase">
							<!--时间-->
							<p class="teaextime">2011/02—至今</p>
							<p class="teaextag">知名学校数学老师</p>
							<p class="teaexwork">${user.myJobs[0].success}</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--中间的右半部分-->
		<div class="middle-right">
			<!--常用地址-->
			<div class="address">
				<p>
					<i class="icon4 icon-map-marker"></i>&nbsp;&nbsp;常用地址
				</p>
				<div class="add">
					<img src="images/address.png" width="250px" height="200px"
						class="img-rounded1" alt="圆角图片">
				</div>
			</div>
			<!--教学特色-->
			<div class="feature">
				<p>
					<i class="icon icon-pencil"></i>&nbsp;&nbsp;教学特色
				</p>
				<div class="text1">
					17年一线教育经验，有独特的教学思路引导学生悟理。课堂中，提问，建模，反思，互动，成长。善于从互动中发现学生薄弱知识点，从而针对学习的因材施教，对症下药，起到事半功倍的效果。课堂上喜欢和学生互动，营造轻松活泼风趣的课堂氛围。幽默风趣的课堂，专业的知识体系架构，超强的责任心，让学生学有所思，学有所得！
				</div>
			</div>
			<!--教过的学生名单-->
			<div class="studentlist">
				<p>
					<i class="icon icon-user"></i>&nbsp;&nbsp;教过的学生学校名单
				</p>
				<div class="text1">
					<ul>
						<li>南门小学</li>
						<li>育才中学</li>
						<li>41中</li>
						<li>文昌</li>
						<li>南门小学</li>
						<li>育才中学</li>
						<li>41中</li>
						<li>文昌</li>
					</ul>

				</div>
			</div>
		</div>
	</div>
	<!--内容的底部-->
	<div class="content-bottom">
		<!--相似老师-->
		<p class="similartitle">
			<i class="icon2 icon-file-text-o"></i>&nbsp;&nbsp;&nbsp;相似老师
		</p>
		<div class="similarteachers">
			<a href="tutordetailed.html">
				<div class="teacher">
					<!--头像-->
					<div class="teaphoto">
						<img src="http://zui.sexy/docs/img/img1.jpg" width="105px"
							height="105px" class="img-rounded2" alt="圆角图片">
					</div>
					<div class="teainfo">
						<p class="teaname">小初数学李老师</p>
						<div class="introduce">
							一线教师，物理年级组长，年级主任，心理咨询师。让学生在短期内提高成绩，爱上物理。</div>
						<p class="info">
							<span class="star1"> <img src="images/fill-star.png"
								style="width: 20px; height: 20px;"> <img
								src="images/fill-star.png" style="width: 20px; height: 20px;">
								<img src="images/fill-star.png"
								style="width: 20px; height: 20px;"> <img
								src="images/fill-star.png" style="width: 20px; height: 20px;">
								<img src="images/empty-star.png"
								style="width: 20px; height: 20px;">
							</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span class="info-span">教龄5年&nbsp;&nbsp;</span>
						</p>
						<!-- <div class="teatag">
                     <ul>
                        <li>小升初</li>
                        <li>小升初</li>
                        <li>小升初</li>
                        <li>小升初</li>
                     </ul>
                  </div> -->
					</div>
					<div class="separator"></div>
					<div class="teaprice">
						<p>
							<i class="icon3 icon-yen"></i>&nbsp;<span class="price1">163</span><span
								class="qi">起</span>
						</p>
						<a href="#"><button class="btn2" type="button">立即查看</button></a>
					</div>
				</div>
			</a>
			<hr>
			<a href="tutordetailed.html">
				<div class="teacher">
					<!--头像-->
					<div class="teaphoto">
						<img src="http://zui.sexy/docs/img/img1.jpg" width="105px"
							height="105px" class="img-rounded2" alt="圆角图片">
					</div>
					<div class="teainfo">
						<p class="teaname">小初数学李老师</p>
						<div class="introduce">
							一线教师，物理年级组长，年级主任，心理咨询师。让学生在短期内提高成绩，爱上物理。</div>
						<p class="info">
							<span class="star1"> <img src="images/fill-star.png"
								style="width: 20px; height: 20px;"> <img
								src="images/fill-star.png" style="width: 20px; height: 20px;">
								<img src="images/fill-star.png"
								style="width: 20px; height: 20px;"> <img
								src="images/fill-star.png" style="width: 20px; height: 20px;">
								<img src="images/empty-star.png"
								style="width: 20px; height: 20px;">
							</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span class="info-span">教龄5年&nbsp;&nbsp;</span>
						</p>
						<!-- <div class="teatag">
                     <ul>
                        <li>小升初</li>
                        <li>小升初</li>
                        <li>小升初</li>
                        <li>小升初</li>
                     </ul>
                  </div> -->
					</div>
					<div class="separator"></div>
					<div class="teaprice">
						<p>
							<i class="icon3 icon-yen"></i>&nbsp;<span class="price1">163</span><span
								class="qi">起</span>
						</p>
						<a href="#"><button class="btn2" type="button">立即查看</button></a>
					</div>
				</div>
			</a>
		</div>
	</div>
	</div>
	<script type="text/javascript" src="js/checkLogin_regist.js"></script>
	<script type="text/javascript">
           $(document).ready(function(){
        	   var currentpage = 1;
       			var totalpage = 1;
       			var pagetemp = new Array();
        		showdata(currentpage);
        		topage(currentpage);
               })
				//页码
				function topage(currentpage) {
					// 点击previous时
					$("#pager").on("click", "#previous", function() {
					currentpage = currentpage - 1;
					showdata(currentpage);
					console.log(currentpage);
				});
				// 点击next时
				$("#pager").on("click", "#next", function() {
					currentpage = currentpage + 1;
					showdata(currentpage);
					console.log(currentpage);
				});
			}

        // 展示数据
           function showdata(currentpage) {
           	$.ajax({
           		type : 'post',
           		url : 'tutorDetail/tutorReviewPager?tid='+${user.id},
           		contentType : 'application/json;charset=UTF-8',
           		dataType : 'json',
           		async : false,
           		success : function(data) {
           			alert("skdfjlks")
           			totalpage = Math.ceil(data.length / 3);
           			$(".comments").html("");
           			$.each(data,function(index, res) {
           				/* $("#reviewTrend").html(""); */
       					lis = '<li class="trendLis">'
       					+res.adj
       					+'('
       					+Math.ceil(Math.random()*4);
       					+')'
       					+'</li>'
       					$("#reviewTrend").append(lis); 
           				// 当前页为第一页时
           				if (currentpage == 1) {
           					$("#pager").html("");
           					devicepage = '<li class="previous disabled"><a id="previous">«</a></li>'
           							+ '<li><span style="border:0px;">第&nbsp;&nbsp;&nbsp;'
           							+ currentpage
           							+ '/'
           							+ totalpage
           							+ '&nbsp;&nbsp;&nbsp;页</span></li>'
           							+ '<li class="next"><a id="next">»</a></li>';
           					$("#pager").append(devicepage);
           				}
           				// 当前页为最后一页时
           				if (currentpage == totalpage) {
           					$("#pager").html("");
           					devicepage = '<li class="previous"><a id="previous">«</a></li>'
           							+ '<li><span style="border:0px;">第&nbsp;&nbsp;&nbsp;'
           							+ currentpage
           							+ '/'
           							+ totalpage
           							+ '&nbsp;&nbsp;&nbsp;页</span></li>'
           							+ '<li class="next disabled"><a id="next">»</a></li>';
           					$("#pager").append(devicepage);
           				}
           				// 当前页为中间页时
           				if (currentpage > 1 && currentpage < totalpage) {
           					$("#pager").html("");
           					devicepage = '<li class="previous"><a id="previous">«</a></li>'
           							+ '<li><span style="border:0px;">第&nbsp;&nbsp;&nbsp;'
           							+ currentpage
           							+ '/'
           							+ totalpage
           							+ '&nbsp;&nbsp;&nbsp;页</span></li>'
           							+ '<li class="next"><a id="next">»</a></li>';
           					$("#pager").append(devicepage);
           				}
           				if (index >= (currentpage - 1) * 3
           						&& index <= currentpage * 3 - 1) {
           					var timestamp= new Date(res.reviewDateTime);
           					teacherinf = '<div class="user-comment">'
           							    +'<div class="user-photo">'
           								+'<img src="'
           								+res.reivewUserImg
           								+'" width="55px" height="55px" class="img-circle" alt="圆形图片">'
           								+'</div>'
           								+'<div class="user-info">'
           								+'<p class="username">'
           								+res.reviewUserName
           								+'</p>'
           								+'<p class="usercomment">'
           								+res.reivewContent
           								+'</p>'
           								+'<p class="usertime">'
           								+timestamp.toLocaleDateString().replace(/\//g, "-") + " " + timestamp.toTimeString().substr(0,0) 
           								+'</p>'
           								+'</div>'
           								+'</div>'
           								+'<div class="dashed"></div>'
           					$(".comments")
           							.append(teacherinf);
           				}
           			})
           		}
           	});
           }
          
           </script>
	<script src="js/tutordetailed.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/checkLogin_regist.js"></script>
	<!--footer-->
	<jsp:include page="footer.jsp"></jsp:include>
	<!--//footer结束  -->
</body>

</html>

