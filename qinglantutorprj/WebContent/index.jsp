<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String basePath = request.getContextPath();%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Index</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <link rel="stylesheet" type="text/css" href="css/header.css"/>
    <link rel="stylesheet" type="text/css" href="css/footer.css"/>
    <link rel="stylesheet" type="text/css" href="css/register_login.css"/>
    <!-- zui -->
    <link rel="stylesheet" href="dist/css/zui.css" />
    <link rel="stylesheet" href="css/verify.css" />
    <!-- jQuery (ZUI中的Javascript组件依赖于jQuery) -->
    <script src="js/jquery-3.2.1.js"></script>
    <!-- ZUI Javascript组件 -->
    <script type="text/javascript" src="dist/js/zui.js"></script>
    <script src="js/verify.js"></script>
    <script src="js/verify.min.js"></script>
   <!--  js功能代码 -->
   
   </head>  
	
  <body>
   <jsp:include page="header.jsp"/>
	<div class="container-fixed">
			<!--轮播图myNiceCarousel-->
			<div id="myNiceCarousel" class="carousel slide" data-ride="carousel" style="position: relative; margin-top: 15px;">
				<!-- 圆点指示器 -->
				<ol class="carousel-indicators">
					<li data-target="#myNiceCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myNiceCarousel" data-slide-to="1"></li>
					<li data-target="#myNiceCarousel" data-slide-to="2"></li>
				</ol>
				<!-- 轮播项目 -->
				<div class="carousel-inner">
					<div class="item active">
						<img alt="First slide" src="images/banner1.png">
						<div class="carousel-caption"></div>
					</div>
					<div class="item">
						<img alt="Second slide" src="images/banner2.png">
						<div class="carousel-caption"></div>
					</div>
					<div class="item">
						<img alt="Third slide" src="images/banner3.png">
						<div class="carousel-caption"></div>
					</div>
				</div>
				<!-- 项目切换按钮 -->
				<a class="left carousel-control" href="#myNiceCarousel" data-slide="prev">
					<span class="icon icon-chevron-left"></span>
				</a>
				<a class="right carousel-control" href="#myNiceCarousel" data-slide="next">
					<span class="icon icon-chevron-right"></span>
				</a>
			</div>
			<!--轮播图end-->
	
			<!--家教信息图片tutor_information_pic-->
			<div class="tutor_information_pic">
				<img src="images/hr.png" style="position:relative; width:408px; margin-left:0px; margin-top:50px; display:inline;"/>
				<img src="images/tutorinf.png" style="position:relative; margin-top:25px; margin-left:50px;"/>
				<img src="images/hr.png" style="position:relative; width:408px; margin-left:730px; margin-top:-70px;"/>
			</div>
			<!--家教信息tutor_information-->
			<div class="tutor_information">
				<!--按钮choose_button-->
				<div class="btn-group" id="choose_button">
					<button type="button" class="btn btn-info">兼职家教</button>
					<button type="button" class="btn btn-info">专职家教</button>
					<button type="button" class="btn btn-info">推荐家教</button>
					<button class="btn btn-info" type="button" id="i_wonder_release" onclick="window.location.href='sendmessage.jsp'"><i class="icon icon-pencil"></i>我要发布</button>
				</div>
				<!--个人信息personal_information-->
				<div class="cards cards-borderless" id="personal_information" style="width:100%">
				<!-- 教师简介 -->
					<div id="personal_name_introduce_school" style="width:1305px;">
						
					</div>
					<!-- 分页器 -->
					<ul class="pager" id="pager" style="float:right; position:relative; margin-right:45%;">
						
					</ul>
				</div>
				<script>
				var currentpage=1;
				var totalpage=1;
				var pagetemp=new Array();
				console.log(totalpage);
					$(document).ready(function(data){
						datashow(currentpage);
						topage(currentpage);
					});
					//页码
					function topage(currentpage){
						//点击previous时
						$("#pager").on("click","#previous",function(){
							currentpage=currentpage-1;
							datashow(currentpage);
							console.log(currentpage);
						});
						//点击next时
						$("#pager").on("click","#next",function(){
							currentpage=currentpage+1;
							datashow(currentpage);
							console.log(currentpage);
						});
					}
					//展示数据
					function datashow(currentpage){
						$.ajax({
							type:'post',
							url:'indexfile',
							contentType:'application/json;charset=UTF-8',
							dataType:'json',
							async:false,
							success:function(data){
								totalpage=Math.ceil(data.length/5);
								$("#personal_name_introduce_school").html("");
								$.each(data,function(index,res){
									if(index>=(currentpage-1)*5&&index<=currentpage*5-1){
										teacherinf='<div class="col-md-4 col-sm-6 col-lg-3" id="personal_inf">'
											+'<a class="card" href="#" style="position: relative;">'
											+'<img src="'+res.userImg+'" alt="">'
											+'<div class="caption">中小学优秀英语教师</div>'
											+'<div class="card-content text-muted"  id="personal_name">'
											+'<p></p>'
											+'<p>&nbsp;&nbsp;&nbsp;姓名：'+res.realName+'</p>'
											+'<p>&nbsp;&nbsp;&nbsp;学校：'+res.school+'</p>'
											+'<p>&nbsp;&nbsp;&nbsp;简介：'+res.introduce+'</p>'
											+'</div>'
											+'</a>'
											+'</div>'
										$("#personal_name_introduce_school").append(teacherinf);	
										console.log(currentpage+"ajax")
									}
								})
								//当前页为第一页时
								if(currentpage==1){
									$("#pager").html("");
									devicepage='<li class="previous disabled"><a id="previous">«</a></li>'
										+'<li><span style="border:0px;">第&nbsp;&nbsp;&nbsp;'+currentpage+'/'+totalpage+'&nbsp;&nbsp;&nbsp;页</span></li>'
										+'<li class="next"><a id="next">»</a></li>';
									$("#pager").append(devicepage);
								}
								//当前页为最后一页时
								if(currentpage==totalpage){
									$("#pager").html("");
									devicepage='<li class="previous"><a id="previous">«</a></li>'
										+'<li><span style="border:0px;">第&nbsp;&nbsp;&nbsp;'+currentpage+'/'+totalpage+'&nbsp;&nbsp;&nbsp;页</span></li>'
										+'<li class="next disabled"><a id="next">»</a></li>';
									$("#pager").append(devicepage);
								}
								//当前页为中间页时
								if(currentpage>1&&currentpage<totalpage){
									$("#pager").html("");
									devicepage='<li class="previous"><a id="previous">«</a></li>'
										+'<li><span style="border:0px;">第&nbsp;&nbsp;&nbsp;'+currentpage+'/'+totalpage+'&nbsp;&nbsp;&nbsp;页</span></li>'
										+'<li class="next"><a id="next">»</a></li>';
									$("#pager").append(devicepage);
								}
							}
						});
					}
				</script>		
			</div>
			<!--家教信息end-->
	
			<!--学习社区图片-->
			<div class="studycommunity">
				<img src="images/hr.png" style="position:relative; width:408px; margin-left:0px; margin-top:50px; display:inline;"/>
				<img src="images/studycommunity.png" style="position:relative; margin-top:25px; margin-left:50px;"/>
				<img src="images/hr.png" style="position:relative; width:408px; margin-left:730px; margin-top:-70px;"/>
			</div>
			<!--学习社区learning_community-->
			<div id="learning_community" class="panel">
				<!--按钮choose_button-->
				<div class="btn-group" id="choose_button">
					<button type="button" class="btn btn-info" id="opt1" onclick="learning_experienceDis()">学习经验</button>
					<button type="button" class="btn btn-info" id="opt2" onclick="course_questionDis()">课程问答</button>
					<button type="button" class="btn btn-info" id="opt3" onclick="community_authorDis()">社区作者</button>
					<button class="btn btn-info" type="button" id="i_wonder_release" onclick="window.location.href='sendmessage.jsp'"><i class="icon icon-pencil"></i>我要发布</button>
				</div>
				<!--学习经验-->
				<div id="learning_experience" class="panel" style="display:block;">
					<div class="items items-hover" id="card">
						<div class="item">
							<!--关键词-->
							<div class="card_keyword">
								<div class="btn-group btn-group-vertical" style="width:150px; position:relative; margin-left:15px;">
									<button type="button" class="btn">#物理</button>
									<button type="button" class="btn">#中考冲刺</button>
									<button type="button" class="btn">#好文</button>
								</div>
								<h3></h3>
								<div class="btn-group">
									<button type="button" class="btn" id="collection" onclick="changstars()"><i class="icon icon-star-empty"></i><span id="collectioncount">108</span></button>
									<button type="button" class="btn" id="good" onclick="changegood()"><i class="icon icon-thumbs-o-up"></i><span id="goodcount">108</span></button>
									<button type="button" class="btn"><i class="icon icon-chat-line"></i>108</button>
								</div>
							</div>
							<!--文章及图片-->
							<div class="cards_article">
								<div class="item-heading">
									<div class="pull-right label label-success"></div>
									<h4><a href="###">巧解物理难题——中考冲刺经验分享</a></h4>
								</div>
								<div class="item-content">
									<div class="media pull-right"><img src="images/physics.jpg" alt="" style="height:75%; width:75%;margin-top:-20px; margin-left:15px;"></div>
									<div class="text">作为考生，首先要知道中考物理的命题方向，各省、市中考题都要遵循既利于选拔，又利于初中物理教学，突出自主学习的主旋律的原则，所以在命题中有80%都是基础题和中等难度题，只有20%的题较有难度。只要同学们调整好心态，认真复习，中考一定会考出好成绩。首先要重视……</div>
								</div>
								<div class="item-footer">
									<a href="#" class="text-muted"><span class="text-muted">2013-11-11 16:14:37</span>
								</div>
							</div>
						</div>
					</div>
					<!--帖子-->
					<div class="items items-hover" id="card">
						<div class="item">
							<!--关键词-->
							<div class="card_keyword">
								<div class="btn-group btn-group-vertical" style="width:150px; position:relative; margin-left:15px;">
									<button type="button" class="btn">#数学</button>
									<button type="button" class="btn">#高考冲刺</button>
									<button type="button" class="btn">#好文</button>
								</div>
								<h3></h3>
								<div class="btn-group">
									<button type="button" class="btn"><i class="icon icon-star-empty"></i>108</button>
									<button type="button" class="btn"><i class="icon icon-thumbs-o-up"></i>108</button>
									<button type="button" class="btn"><i class="icon icon-chat-line"></i>108</button>
								</div>
							</div>
							<!--文章及图片-->
							<div class="cards_article">
								<div class="item-heading">
									<div class="pull-right label label-success"></div>
									<h4><a href="###">学霸传授——高考数学偷分技巧</a></h4>
								</div>
								<div class="item-content">
									<div class="media pull-right"><img src="images/maths.jpg" alt="" style="height:75%; width:75%;margin-top:-20px; margin-left:15px;"></div>
									<div class="text">数学作为三大主课之一，所占的分量相当的重，很多学生也明白如果数学学不好的话想要考上理想的大学是天方夜谭，但是苦于无学习之法，那么高中数学都有哪些学习方法呢?今天我们就给大家整理出来一些高考数学“偷分技巧”……</div>
								</div>
								<div class="item-footer">
									<a href="#" class="text-muted"><span class="text-muted">2013-11-11 16:14:37</span>
								</div>
							</div>
						</div>
					</div>
					<div class="items items-hover" id="card">
						<div class="item">
						<!--关键词-->
							<div class="card_keyword">
								<div class="btn-group btn-group-vertical" style="width:150px; position:relative; margin-left:15px;">
									<button type="button" class="btn">#英语</button>
									<button type="button" class="btn">#中考冲刺</button>
									<button type="button" class="btn">#好文</button>
								</div>
								<h3></h3>
								<div class="btn-group">
									<button type="button" class="btn"><i class="icon icon-star-empty"></i>108</button>
									<button type="button" class="btn"><i class="icon icon-thumbs-o-up"></i>108</button>
									<button type="button" class="btn"><i class="icon icon-chat-line"></i>108</button>
								</div>
							</div>
							<!--文章及图片-->
							<div class="cards_article">
								<div class="item-heading">
									<div class="pull-right label label-success"></div>
									<h4><a href="###">中考英语完形填空三大技巧分享</a></h4>
								</div>
								<div class="item-content">
									<div class="media pull-right"><img src="images/english.jpg" alt="" style="height:75%; width:75%;margin-top:-20px; margin-left:15px;"></div>
									<div class="text">完形填空题以其内容广泛和知识、能力有机结合而备受命题者的青睐，它也是各类英语测试和竞赛中的重点题。且多数同学认为完形填空题是较难的题型 之一。金华龙文教育个性化辅导教师认为，完形填空题难主要有两个原因：一是它所测试的内容几乎是无所不包：单词……</div>
								</div>
								<div class="item-footer">
									<a href="#" class="text-muted"><span class="text-muted">2013-11-11 16:14:37</span>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--课程问答-->
				<div id="course_question" style="display:none;">
					<!--问题与回答-->
					<div id="question_answer">
						<div class="items items-hover" id="qanda">
							<div class="item">
								<div class="item-heading">
									<div class="pull-right label label-success">物理</div>
									<h4><a href="###">问：请问初三物理有哪些重点</a></h4>
								</div>
								<div class="item-content">
									<div class="text" style="position: relative; padding: 5px;">电学和力学毋庸置疑是中考物理的两大重点，其中电学包括基础的电压、电流、电阻、电路知识，欧姆定律，电功率相关问题以及电学试验，大题和试验电学部分是必考考点；力学部分重点在压力压强以……</div>
								</div>
								<div class="item-footer">
									<span class="text-muted">2013-11-11 16:14:37</span>
									&nbsp;&nbsp;&nbsp;
									<span class="text-muted"><a href="#">24</a>个回答</span>
									&nbsp;&nbsp;&nbsp;
									<span class="text-muted">回答者：<a href="#">刘强</a></span>&nbsp;&nbsp;&nbsp;
									<span class="text-muted"><a href="#"><i class="icon icon-thumbs-o-up"></i>108</a></span>
								</div>
							</div>
						</div>
						<div class="items items-hover" id="qanda">
							<div class="item">
								<div class="item-heading">
								<div class="pull-right label label-success">化学</div>
								<h4><a href="###">问：请问化学方程式配平有什么好的方法</a></h4>
								</div>
								<div class="item-content">
									<div class="text">观察法适用于简单的氧化-还原方程式配平。配平关键是观察反应前后原子个数变化，找出关键是观察反应前后原子个数相等。有的氧化-还原方程看似复杂，也可根据原子数和守恒的思想利用观察法配平。经观察，由出现次数……</div>
								</div>
								<div class="item-footer">
									<span class="text-muted">2013-11-11 16:14:37</span>
									&nbsp;&nbsp;&nbsp;
									<span class="text-muted"><a href="#">24</a>个回答</span>
									&nbsp;&nbsp;&nbsp;
									<span class="text-muted">回答者：<a href="#">刘强</a></span>&nbsp;&nbsp;&nbsp;
									<span class="text-muted"><a href="#"><i class="icon icon-thumbs-o-up"></i>108</a></span>
								</div>
							</div>
						</div>
						<div class="items items-hover" id="qanda">
							<div class="item">
								<div class="item-heading">
									<div class="pull-right label label-success">生物</div>
									<h4><a href="###">问：请问蛋白质的形成</a></h4>
								</div>
								<div class="item-content">
									<div class="text">蛋白质合成不仅要有合成的场所，而且还必须有mRNA、tRNA、20种氨基酸原料和一些蛋白质因子及酶。Mg、K+离子等参与，并由ATP、GTP提供能量，合成中mRNA是编码2合成蛋白质的模板，tRNA是识别密码子，转……</div>
								</div>
								<div class="item-footer">
									<span class="text-muted">2013-11-11 16:14:37</span>
									&nbsp;&nbsp;&nbsp;
									<span class="text-muted"><a href="#">24</a>个回答</span>
									&nbsp;&nbsp;&nbsp;
									<span class="text-muted">回答者：<a href="#">刘强</a></span>&nbsp;&nbsp;&nbsp;
									<span class="text-muted"><a href="#"><i class="icon icon-thumbs-o-up"></i>108</a></span>
								</div>
							</div>
						</div>
						<div class="items items-hover" id="qanda">
							<div class="item">
								<div class="item-heading">
									<div class="pull-right label label-success">数学</div>
									<h4><a href="###">问：排列组合的概念</a></h4>
								</div>
								<div class="item-content">
									<div class="text">所谓排列组合问题，就是从n个不同元素中选取m个元素按照一定的顺序排成一列，就叫做从n个不同元素中取出m个元素的一个排列；从n个不同元素中取出m(m≤n）个元素的所有排列的个数，叫做从n个不同元素中取出m个……</div>
								</div>
								<div class="item-footer">
									<span class="text-muted">2013-11-11 16:14:37</span>
									&nbsp;&nbsp;&nbsp;
									<span class="text-muted"><a href="#">24</a>个回答</span>
									&nbsp;&nbsp;&nbsp;
									<span class="text-muted">回答者：<a href="#">刘强</a></span>&nbsp;&nbsp;&nbsp;
									<span class="text-muted"><a href="#"><i class="icon icon-thumbs-o-up"></i>108</a></span>
								</div>
							</div>
						</div>
					</div>
					<!--优秀回答者-->
					<div class="panel" id="goodresponder">
						<div class="panel-body">
							<h3>优秀回答者</h3>
							<a href="#"><img src="images/idphotocircle1.png" style="position: relative;margin-left: 10px;"></a>
							<a href="#" style="position: relative;margin-left: 36px;"><img src="images/idphotocircle2.png"></a>
							<p></p>
							<a href="#"><img src="images/idphotocircle3.png" style="position: relative;margin-left: 10px;"></a>
							<a href="#" style="position: relative;margin-left: 36px;"><img src="images/idphotocircle1.png"></a>
							<p></p>
							<a href="#"><img src="images/idphotocircle2.png" style="position: relative;margin-left: 10px;"></a>
							<a href="#" style="position: relative;margin-left: 36px;"><img src="images/idphotocircle3.png"></a>
							<p></p>
							<a href="#"><img src="images/idphotocircle3.png" style="position: relative;margin-left: 10px;"></a>
							<a href="#" style="position: relative;margin-left: 36px;"><img src="images/idphotocircle1.png"></a>
						</div>
					</div>
				</div>
				<!--社区作者-->
				<div id="community_author" style="display:none;">
					<div class="items items-hover" id="author">
						<div class="item">
							<a href="#"><img src="images/idphotocircle1.png" style="width:12%; margin-left:15px;"></a>
							<div class="btn-group btn-group-vertical" style="position: relative; margin-left: 25px; width:80px; margin-top: 10px">
								<button type="button" class="btn">认证家教</button>
								<p></p>
								<button type="button" class="btn">社区作家</button>
								<p></p>
								<button type="button" class="btn">高采纳率</button>
							</div>
							<div class="personal_introduction">
								<br/>
								<b>个人介绍：</b>主要是初中英语，数学，小学全科的教程奥语及课内外作业，针对性补差，提高简单题的做题速度和难题的解题思路方法，培养良好的习惯和自学能力。在一教育机构任职，课后进行私人辅导，喜欢小孩有责任心，耐心。希望在这过程中共同成长进步。
							</div>
							<div class="personal_article">
								<h3><b>他的文章</b><br/></h3>
								<a href="#"><h4>巧解物理难题——中考冲刺经验分享</h4></a>
								<a href="#"><h4>巧解物理难题——中考冲刺经验分享</h4></a>
								<a href="#"><h4>巧解物理难题——中考冲刺经验分享</h4></a>
								<button class="btn" type="button" style="position: relative; margin-left: 240px; margin-top:-30px;">查看更多</button>
							</div>
							<button class="btn btn-mini " type="button" style="position: relative;margin-left:1010px; margin-top:-260px;"><i class="icon icon-plus"></i>关注</button>
						</div>
					</div>
					<div class="items items-hover" id="author">
						<div class="item">
							<a href="#"><img src="images/idphotocircle2.png" style="width:12%; margin-left:15px;"></a>
							<div class="btn-group btn-group-vertical" style="position: relative; margin-left: 25px; width:80px; margin-top: 10px">
								<button type="button" class="btn">认证家教</button>
								<p></p>
								<button type="button" class="btn">社区作家</button>
								<p></p>
								<button type="button" class="btn">高采纳率</button>
							</div>
							<div class="personal_introduction">
								<br/>
								<b>个人介绍：</b>主要是初中英语，数学，小学全科的教程奥语及课内外作业，针对性补差，提高简单题的做题速度和难题的解题思路方法，培养良好的习惯和自学能力。在一教育机构任职，课后进行私人辅导，喜欢小孩有责任心，耐心。希望在这过程中共同成长进步。
							</div>
							<div class="personal_article">
								<h3><b>他的文章</b><br/></h3>
								<a href="#"><h4>巧解物理难题——中考冲刺经验分享</h4></a>
								<a href="#"><h4>巧解物理难题——中考冲刺经验分享</h4></a>
								<a href="#"><h4>巧解物理难题——中考冲刺经验分享</h4></a>
								<button class="btn" type="button" style="position: relative; margin-left: 240px; margin-top:-30px;">查看更多</button>
							</div>
							<button class="btn btn-mini " type="button" style="position: relative;margin-left:1010px; margin-top:-260px;"><i class="icon icon-plus"></i>关注</button>
						</div>
					</div>
					<div class="items items-hover" id="author">
						<div class="item">
							<a href="#"><img src="images/idphotocircle3.png" style="width:12%; margin-left:15px;"></a>
							<div class="btn-group btn-group-vertical" style="position: relative; margin-left: 25px; width:80px; margin-top: 10px">
								<button type="button" class="btn">认证家教</button>
								<p></p>
								<button type="button" class="btn">社区作家</button>
								<p></p>
								<button type="button" class="btn">高采纳率</button>
							</div>
							<div class="personal_introduction">
								<br/>
								<b>个人介绍：</b>主要是初中英语，数学，小学全科的教程奥语及课内外作业，针对性补差，提高简单题的做题速度和难题的解题思路方法，培养良好的习惯和自学能力。在一教育机构任职，课后进行私人辅导，喜欢小孩有责任心，耐心。希望在这过程中共同成长进步。
							</div>
							<div class="personal_article">
								<h3><b>他的文章</b><br/></h3>
								<a href="#"><h4>巧解物理难题——中考冲刺经验分享</h4></a>
								<a href="#"><h4>巧解物理难题——中考冲刺经验分享</h4></a>
								<a href="#"><h4>巧解物理难题——中考冲刺经验分享</h4></a>
								<button class="btn" type="button" style="position: relative; margin-left: 240px; margin-top:-30px;">查看更多</button>
							</div>
							<button class="btn btn-mini " type="button" style="position: relative;margin-left:1010px; margin-top:-260px;"><i class="icon icon-plus"></i>关注</button>
						</div>
					</div>
				</div>
				<!--分页-->
				<ul class="pager" id="pager" data-ride="pager" data-page="2" data-rec-total="89" data-max-nav-count="4" data-elements="prev_icon,page_of_total_text,next_icon" style="margin-left:500px;">
					
				</ul>	
			</div>
			<!--学习社区end-->
		</div>
	</div>
		<script type="text/javascript">
			//学习社区点击按钮切换界面
			var learning_experience=document.getElementById('learning_experience');
			var course_question=document.getElementById('course_question');
			var community_author=document.getElementById('community_author');
			function learning_experienceDis(){
					learning_experience.style.display="block";
					course_question.style.display="none";
					community_author.style.display="none";
				}
			function course_questionDis(){
			  learning_experience.style.display="none";
			  course_question.style.display="block";
			  community_author.style.display="none";
			}
			function community_authorDis(){
			  learning_experience.style.display="none";
			  course_question.style.display="none";
			  community_author.style.display="block";
			}
			
			//收藏按钮点击效果
			function changstars(){
				var collection=document.getElementById("collection");
				var collectioncount=document.getElementById("collectioncount").innerText;
				if(collectioncount==108){
					console.log(collectioncount);
					collectioncount=parseInt(collectioncount)+1;
					collection.innerHTML="<i class='icon icon-star'></i><span id='collectioncount'>"+collectioncount+"</span>";
				}
				else{
					console.log(collectioncount);
					collectioncount=parseInt(collectioncount)-1;
					collection.innerHTML="<i class='icon icon-star-empty'></i><span id='collectioncount'>"+collectioncount+"</span>";
				}
			}
			
			//点赞按钮点击效果
			function changegood(){
				var changegood=document.getElementById("good");
				var goodcount=document.getElementById("goodcount").innerText;
				if(goodcount==108){
					goodcount=parseInt(goodcount)+1;
					good.innerHTML="<i class='icon icon-thumbs-up'></i><span id='goodcount'>"+goodcount+"</span>";
				}
				else{
					goodcount=parseInt(goodcount)-1;
					good.innerHTML="<i class='icon icon-thumbs-o-up'></i><span id='goodcount'>"+goodcount+"</span>";
				}
			}
			
			//图片的划入划出事件
			var arr = new Array();
			$(".card").each(function(){
				arr.push($(this));
			});
			for(var i=0;i<5;i++){
				arr[i].mouseover(function(){
					$(this).animate({top:'-10px'},"fast");
				});
				arr[i].mouseout(function(){
					$(this).animate({top:'0px'},"fast");
				});
			}
		</script>
			
			
		<div class="footer">
				<!-- 关于网页 -->
				<div class="footer-font">
					<div id="footer-font-about">
						<div id="about-title"><h3 class="font-h3">关于青蓝</h3></div>
						<div id="about-font"><p class="footer-words">
							青蓝家教旨在为大学生和家长提供真实可靠的家教信息发布、家教过程约束和学情分析平台。大学生家教在平台上注册并发布家教信息，家教在线上记录孩子的每次学习情况用于记录分析，并且可以给孩子提供线上辅导功能，家长可即时查看情况，更加了解孩子的学情。同时平台还为家长和家教提供论坛交流区，用于资料交流和分享。
						</p></div>
					</div>
					<div id="footer-font-a">
						<div id="a-title"><h3 class="font-h3">链接</h3></div>
						<div id="a-font">
							<a href="#" class="footer-words">加入我们</a>
							<a href="#" class="footer-words">网站须知</a>
							<a href="#" class="footer-words">意见反馈</a>
							<a href="#" class="footer-words">免责声明</a>
						</div>
					</div>
					<div id="footer-font-friend">
						<div id="friend-title"><h3 class="font-h3">鸣谢伙伴</h3></div>
						<div id="friend-logo">
							<div id="friend-logo-div1">
								<i class="icon icon-github icon-3x" ></i>
								<i class="icon icon-qq icon-3x"></i>
								<i class="icon icon-wechat icon-3x"></i>
							</div>
						</div>
					</div>
					<div id="footer-font-img">
						<div id="footer-font-img-font"><h3>扫码关注我们了解更多</h3></div>
						<img src="images/code.png" id="QRcode">
				</div>
			</div>
		
			<!-- 权利归属 -->
				<div id="footer-right">
					<div id="footer-right-font">
						<p>
							<br>
							<a href="#" id="footer-right-font-a1">Copyright 2018-2020&nbsp;&nbsp;&nbsp;青蓝家教</a>
							<a href="#" id="footer-right-font-a1">Copyright 2018-2020&nbsp;&nbsp;&nbsp;青蓝家教</a>
			    			<a href="#" id="footer-right-font-a2">冀ICP备05067795号  冀公网安备110402440008号 </a>
			    		</p>
					</div>
				</div>
			</div>
	<script type="text/javascript" src="js/checkLogin_regist.js"></script>
</body>
</html>