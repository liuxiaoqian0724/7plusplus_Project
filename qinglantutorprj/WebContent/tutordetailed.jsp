<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>家教详情</title>
	<meta charset="utf-8">
   <!--引入css-->
   <link rel="stylesheet" href="dist/css/zui.min.css">
   <link rel="stylesheet" href="dist/css/zui.css">
   <link rel="stylesheet" href="dist/css/zui.lite.css">

   <link rel="stylesheet" type="text/css" media="screen" href="https://cdn.staticfile.org/ionicons/2.0.1/css/ionicons.min.css">
   <link rel="stylesheet" type="text/css" href="css/tutordetailed.css">
   <link rel="stylesheet" type="text/css" href="css/header.css"/>
   <link rel="stylesheet" type="text/css" href="css/footer.css"/>
   <!--引入js-->
   <script type="text/javascript" src="dist/lib/jquery/jquery.js"></script>
   <script type="text/javascript" src="dist/js/zui.min.js"></script>
   <script type="text/javascript" src="dist/js/zui.js"></script>
   <script type="text/javascript" src="dist/js/zui.lite.js"></script>
	
	<script src="js/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="js/tutordetailed.js"></script>
</head>
<body>
<!--header-->
	<%@ include file="header.jsp"%>
<!--//header结束  -->


<!--content-->
<div class="content">
	<!--内容的上半部分-->
	<div class="content-top">
		<!--面包屑-->
         <ol class="breadcrumb">
           <li><a href="indexed.html"><i class="icon icon-home"></i>&nbsp;Home</a></li>
           <li><a href="tutorlisted.html">石家庄家教老师</a></li>
           <li class="active">张娴</li>
         </ol>
   		<!--个人信息-->
   		<div class="information">
   			<!--左半部分 photo-->
   			<div class="in-photo">
   				<div class="bigimg">
                  <div class="img">
                     <img src="images/big-img4.jpg" width="320px" height="320px" class="img-rounded" alt="圆角图片">
                  </div>
   					
   				</div>
   				<div class="imgs">
   					<ul>
   						<!--数据库循环-->
   						<li><!-- <img data-toggle="lightbox" src="images/img4.jpg" data-image="images/big-img4.jpg" data-caption="小图看大图" class="img-thumbnail" id="img-spc" alt="" width="60"> -->
                     <img src="images/img4.jpg" class="img-thumbnail" id="img-spc" width="60" data-image="images/big-img4.jpg">            
                     </li>
                     <li><!-- <img data-toggle="lightbox" src="images/img3.jpg" data-image="images/big-img3.jpg" data-caption="小图看大图" class="img-thumbnail" alt="" width="60px" height="60px"> -->
                     <img src="images/img3.jpg" class="img-thumbnail" id="img-spc" width="60" data-image="images/big-img3.jpg">
                     </li>
   						<li><!-- <img data-toggle="lightbox" src="images/img5.jpg" data-image="images/big-img5.jpg" data-caption="小图看大图" class="img-thumbnail" alt="" width="60"> -->
                     <img src="images/img5.jpg" class="img-thumbnail" id="img-spc" width="60" data-image="images/big-img5.jpg">            
                     </li>
                     <li><!-- <img data-toggle="lightbox" src="images/img3.jpg" data-image="images/big-img3.jpg" data-caption="小图看大图" class="img-thumbnail" alt="" width="60"> -->
                     <img src="images/img3.jpg" class="img-thumbnail" id="img-spc" width="60" data-image="images/big-img3.jpg">
                     </li>
   					</ul>
   				</div>
   			</div>
   			<!--详细信息-->
   			<div class="in-detail">
               <!--家教名-->
   				<div class="de-name">
   					<b>张娴</b>
   				</div>
   				<div class="de-lineone">
   					教龄：11年&nbsp;&nbsp;|&nbsp;&nbsp;  好评数48条 
   				</div>
   				<div class="de-linetwo">
   					<div class="one">
   						<!--数据库查询-->
   						<span class="title">课酬</span>
                     <span class="price"><i class="icon icon-yen"></i>&nbsp;221</span>
                     <span class="hour">/小时</span>
   						<span class="star">
                        <img src="images/fill-star.png" style="width: 20px;height: 20px;">
                        <img src="images/fill-star.png" style="width: 20px;height: 20px;">
                        <img src="images/fill-star.png" style="width: 20px;height: 20px;">
                        <img src="images/fill-star.png" style="width: 20px;height: 20px;">
                        <img src="images/empty-star.png" style="width: 20px;height: 20px;">            
                     </span>
                     <div class="separator1"></div> 
                     <span class="comment">
                        <ul>
                           <li>1523</li>
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
                  <table class="time_table png_img table table-bordered" style="width:500px;">
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
                                 <td data-id="1">
                                    <img src="images/icon/ok.png" alt=" ">
                                 </td>
                                 <td data-id="4 ">
                                    <img src="images/icon/error.png" alt=" ">
                                 </td>
                                 <td data-id="7 ">
                                    <img src="images/icon/ok.png" alt=" ">
                                 </td>
                                 <td data-id="10 ">
                                    <img src="images/icon/ok.png" alt=" ">
                                 </td>
                                 <td data-id="13 ">
                                    <img src="images/icon/error.png" alt=" ">
                                 </td>
                                 <td data-id="16 ">
                                    <img src="images/icon/error.png" alt=" ">
                                 </td>
                                 <td data-id="19 ">
                                    <img src="images/icon/ok.png" alt=" ">
                                 </td>
                              </tr>
                              <tr>
                                 <th>下午</th>
                                 <td data-id="2 ">
                                    <img src="images/icon/error.png" alt=" ">
                                 </td>
                                 <td data-id="5 ">
                                    <img src="images/icon/error.png" alt=" ">
                                 </td>
                                 <td data-id="8 ">
                                    <img src="images/icon/ok.png" alt=" ">
                                 </td>
                                 <td data-id="11 ">
                                    <img src="images/icon/error.png" alt=" ">
                                 </td>
                                 <td data-id="14 ">
                                    <img src="images/icon/ok.png" alt=" ">
                                 </td> 
                                 <td data-id="17 ">
                                    <img src="images/icon/error.png" alt=" ">
                                 </td>
                                 <td data-id="20 ">
                                    <img src="images/icon/ok.png" alt=" ">
                                 </td>
                              </tr>
                              <tr>
                                 <th>晚上</th>
                                 <td data-id="3 ">
                                    <img src="images/icon/ok.png" alt=" ">
                                 </td>
                                 <td data-id="6 ">
                                    <img src="images/icon/error.png" alt=" ">
                                 </td>
                                 <td data-id="9 ">
                                    <img src="images/icon/ok.png " alt=" ">
                                 </td>
                                 <td data-id="12 ">
                                    <img src="images/icon/ok.png" alt=" ">
                                 </td> 
                                 <td data-id="15 ">
                                    <img src="images/icon/error.png" alt=" ">
                                 </td>
                                 <td data-id="18 ">
                                    <img src="images/icon/error.png" alt=" ">
                                 </td>
                                 <td data-id="21 ">
                                    <img src="images/icon/error.png" alt=" ">
                                 </td>
                              </tr>
                           </tbody>
                        </table>
               </div>
   				<div class="de-linethree">
   					<span class="title">授课年级</span>
   					<div class="grade">
   						<ul>
   							<li class="gradeli">一年级</li>
   							<li class="gradeli">一年级</li>
   							<li class="gradeli">一年级</li>
   							<li class="gradeli">一年级</li>
   							<li class="gradeli">一年级</li>
   							<li class="gradeli">一年级</li>
   							<li class="gradeli">一年级</li>
   							<li class="gradeli">一年级</li>
   						</ul>
   					</div>
   				</div>
   				<!-- <div class="de-linefour">
   					<span class="title">授课方式</span>
   					<div class="pattern">
   						<ul>
   							<li class="patternli">老师上门</li>
   							<li class="patternli">学生上门</li>
   						</ul>
   					</div>
   				</div> -->
               
               <!--按钮-->
   				<div class="de-linefive">
                  <button class="btn1 btn-lg" type="button">预约</button>
                  <button class="btn1 btn-lg" type="button">咨询</button>
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
                     <!-- <span class="star">⭐⭐⭐⭐⭐</span> -->
                  </div>
                  <div class="separator"></div> 
                  <div class="top-right">
                     <p>大家都在说：</p>
                     <div class="right-tab">
                        <ul>
                           <!--数据库查询-->
                           <li>全部31</li>
                           <li>认真负责31</li>
                           <li>思路清晰31</li>
                           <li>认真负责31</li>
                           <li>思路清晰31</li>
                           <li>认真负责31</li>
                           <li>思路清晰31</li>
                        </ul>
                     </div>
                  </div>
               </div>
               <hr>
               <!--评价条件-->
               <div class="comment-conditions">
                  <ul>
                     <li id="rank">排序:</li>
                     <!--数据库中查询-->
                     <a href="#"><li class="comment-condition">好评(52)</li></a>
                     <a href="#"><li class="comment-condition">中评(2)</li></a>
                     <a href="#"><li class="comment-condition">差评(1)</li></a>
                  </ul>
               </div>
               <hr>
               <div class="comments">
                  <!--数据库循环-->
                  <div class="user-comment">
                     <!--照片框-->
                     <div class="user-photo">
                        <img src="http://zui.sexy/docs/img/img2.jpg" width="55px" height="55px" class="img-circle" alt="圆形图片">
                     </div>
                     <div class="user-info">
                        <p class="username">用户名</p>
                        <p class="usercomment">用户的评价</p>
                        <p class="usertime">2018年11月20日 18:55</p>
                     </div>
                  </div>
                  <div class="dashed"></div>
                  <div class="user-comment">
                     <!--照片框-->
                     <div class="user-photo">
                        <img src="http://zui.sexy/docs/img/img2.jpg" width="55px" height="55px" class="img-circle" alt="圆形图片">
                     </div>
                     <div class="user-info">
                        <p class="username">用户名</p>
                        <p class="usercomment">用户的评价</p>
                        <p class="usertime">2018年11月20日 18:55</p>
                     </div>
                  </div>
                  <div class="dashed"></div>
                  <div class="user-comment">
                     <!--照片框-->
                     <div class="user-photo">
                        <img src="http://zui.sexy/docs/img/img2.jpg" width="55px" height="55px" class="img-circle" alt="圆形图片">
                     </div>
                     <div class="user-info">
                        <p class="username">用户名</p>
                        <p class="usercomment">用户的评价</p>
                        <p class="usertime">2018年11月20日 18:55</p>
                     </div>
                  </div>
                  <div class="dashed"></div>
                  <div class="user-comment">
                     <!--照片框-->
                     <div class="user-photo">
                        <img src="http://zui.sexy/docs/img/img2.jpg" width="55px" height="55px" class="img-circle" alt="圆形图片">
                     </div>
                     <div class="user-info">
                        <p class="username">用户名</p>
                        <p class="usercomment">用户的评价</p>
                        <p class="usertime">2018年11月20日 18:55</p>
                     </div>
                  </div>
                  <div class="page">
                     <ul class="pager" data-ride="pager" data-page="2" data-rec-total="89" data-max-nav-count="4" data-elements="prev_icon,nav,next_icon"></ul>
                  </div>
               </div>
               
            </div>
            <div class="tab-pane" id="tabContent2">
               <!--成功案例-->
               <div class="successcase">
                  <p class="successtitle"><!-- &nbsp;&nbsp; --><i class="icon2 icon-file-text-o"></i>&nbsp;&nbsp;&nbsp;成功案例</p>
                  <div class="cases">
                     <!--数据库循环-->
                     <div class="case">
                        <p class="ca-title">奥数从不入门到获奖</p>
                        <div class="ca-content">
                           刘同学，从三年级开始奥数，学习一年后效果不佳，对奥数也有了一些抵触，我从四年级开始带他，注重教学方法，课堂效率，激发他的学习兴趣，**生活实际，在快乐中学习，帮助刘同学迅速建立了信心，使其在奥数学习中如鱼得水。在五年级的一次数学邀请赛中取得了二等奖的好成绩。
                        </div>
                     </div>
                     <div class="dashed"></div>
                     <div class="case">
                        <p class="ca-title">奥数从不入门到获奖</p>
                        <div class="ca-content">
                           刘同学，从三年级开始奥数，学习一年后效果不佳，对奥数也有了一些抵触，我从四年级开始带他，注重教学方法，课堂效率，激发他的学习兴趣，**生活实际，在快乐中学习，帮助刘同学迅速建立了信心，使其在奥数学习中如鱼得水。在五年级的一次数学邀请赛中取得了二等奖的好成绩。
                        </div>
                     </div>
                     
                     <div class="hidecase">
                        <div class="dashed"></div>
                        <div class="case">
                           <p class="ca-title">奥数从不入门到获奖</p>
                           <div class="ca-content">
                              刘同学，从三年级开始奥数，学习一年后效果不佳，对奥数也有了一些抵触，我从四年级开始带他，注重教学方法，课堂效率，激发他的学习兴趣，**生活实际，在快乐中学习，帮助刘同学迅速建立了信心，使其在奥数学习中如鱼得水。在五年级的一次数学邀请赛中取得了二等奖的好成绩。
                           </div>
                        </div>
                        <div class="dashed"></div>
                        <div class="case">
                           <p class="ca-title">奥数从不入门到获奖</p>
                           <div class="ca-content">
                              刘同学，从三年级开始奥数，学习一年后效果不佳，对奥数也有了一些抵触，我从四年级开始带他，注重教学方法，课堂效率，激发他的学习兴趣，**生活实际，在快乐中学习，帮助刘同学迅速建立了信心，使其在奥数学习中如鱼得水。在五年级的一次数学邀请赛中取得了二等奖的好成绩。
                           </div>
                        </div>
                     </div>
                  </div>
                  <!--更多-->
                  <div class="box">
                       <span class="line"></span>
                       <span class="text">查看更多<i class="icon icon-angle-down" id="ii"></i></span>
                       <span class="line"></span>
                  </div>
               </div> 
               <!--h教学经历-->   
               <div class="teaex">
                  <p class="teaextitle"><i class="icon2 icon-file-text-o"></i>&nbsp;&nbsp;&nbsp;教学经历</p>
                  <div class="teacase">
                      <!--时间-->
                     <p class="teaextime">2011/02—至今 </p>
                     <p class="teaextag">知名学校数学老师</p>
                     <p class="teaexwork">   
                        兼职在教育机构从事培训工作，尤其擅长一对一个性化辅导，根据学生特点因材施教。经验丰富，教学突出，深受学生喜爱！
                     </p>
                  </div>
                  <div class="dashed"></div>
                  <div class="teacase">
                      <!--时间-->
                     <p class="teaextime">2011/02—至今 </p>
                     <p class="teaextag">知名学校数学老师</p>
                     <p class="teaexwork">   
                        兼职在教育机构从事培训工作，尤其擅长一对一个性化辅导，根据学生特点因材施教。经验丰富，教学突出，深受学生喜爱！
                     </p>
                  </div>
               </div> 
            </div>
         </div>
      </div>
		<!--中间的右半部分-->
		<div class="middle-right">
         <!--常用地址-->
         <div class="address">
            <p><i class="icon4 icon-map-marker"></i>&nbsp;&nbsp;常用地址</p>
            <div class="add"><img src="images/address.png" width="250px" height="200px" class="img-rounded1" alt="圆角图片"></div>
         </div>
         <!--教学特色-->
         <div class="feature">
            <p><i class="icon icon-pencil"></i>&nbsp;&nbsp;教学特色</p>
            <div class="text1">
               17年一线教育经验，有独特的教学思路引导学生悟理。课堂中，提问，建模，反思，互动，成长。善于从互动中发现学生薄弱知识点，从而针对学习的因材施教，对症下药，起到事半功倍的效果。课堂上喜欢和学生互动，营造轻松活泼风趣的课堂氛围。幽默风趣的课堂，专业的知识体系架构，超强的责任心，让学生学有所思，学有所得！
            </div>
         </div>
         <!--教过的学生名单-->
         <div class="studentlist">
            <p><i class="icon icon-user"></i>&nbsp;&nbsp;教过的学生学校名单</p>
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
      <p class="similartitle"><i class="icon2 icon-file-text-o"></i>&nbsp;&nbsp;&nbsp;相似老师</p>
      <div class="similarteachers">
         <a href="tutordetailed.html">
            <div class="teacher">
               <!--头像-->
               <div class="teaphoto">
                  <img src="http://zui.sexy/docs/img/img1.jpg" width="105px" height="105px" class="img-rounded2" alt="圆角图片">
               </div>
               <div class="teainfo">
                  <p class="teaname">小初数学李老师</p>
                  <div class="introduce">
                     一线教师，物理年级组长，年级主任，心理咨询师。让学生在短期内提高成绩，爱上物理。
                  </div>
                  <p class="info">
                     <span class="star1">
                        <img src="images/fill-star.png" style="width: 20px;height: 20px;">
                        <img src="images/fill-star.png" style="width: 20px;height: 20px;">
                        <img src="images/fill-star.png" style="width: 20px;height: 20px;">
                        <img src="images/fill-star.png" style="width: 20px;height: 20px;">
                        <img src="images/empty-star.png" style="width: 20px;height: 20px;">
                     </span>
                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     <span class="info-span">教龄5年&nbsp;&nbsp;</span>
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
                  <p><i class="icon3 icon-yen"></i>&nbsp;<span class="price1">163</span><span class="qi">起</span></p>
                  <a href="#"><button class="btn2" type="button">立即查看</button></a>
               </div>
            </div>
         </a>
         <hr>
         <a href="tutordetailed.html">
            <div class="teacher">
               <!--头像-->
               <div class="teaphoto">
                  <img src="http://zui.sexy/docs/img/img1.jpg" width="105px" height="105px" class="img-rounded2" alt="圆角图片">
               </div>
               <div class="teainfo">
                  <p class="teaname">小初数学李老师</p>
                  <div class="introduce">
                     一线教师，物理年级组长，年级主任，心理咨询师。让学生在短期内提高成绩，爱上物理。
                  </div>
                  <p class="info">
                     <span class="star1">
                        <img src="images/fill-star.png" style="width: 20px;height: 20px;">
                        <img src="images/fill-star.png" style="width: 20px;height: 20px;">
                        <img src="images/fill-star.png" style="width: 20px;height: 20px;">
                        <img src="images/fill-star.png" style="width: 20px;height: 20px;">
                        <img src="images/empty-star.png" style="width: 20px;height: 20px;">
                     </span>
                     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     <span class="info-span">教龄5年&nbsp;&nbsp;</span>
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
                  <p><i class="icon3 icon-yen"></i>&nbsp;<span class="price1">163</span><span class="qi">起</span></p>
                  <a href="#"><button class="btn2" type="button">立即查看</button></a>
               </div>
            </div>
         </a>
      </div>
	</div>
</div>
<!--footer-->
	<%@ include file="footer.jsp"%>
<!--//footer结束  -->
</body>
</html>

