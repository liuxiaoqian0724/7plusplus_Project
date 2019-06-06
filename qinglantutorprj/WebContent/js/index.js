$(document).ready(function(){
	var role=getCookie("ROLE");
	if(role=="老师"){
		$("#choose_button").append('<button class="btn btn-info" type="button" id="i_wonder_release" onclick="window.location.href=\'sendmessageed.jsp\'"><i class="icon icon-pencil"></i>我要发布</button>');
		$("#choose_buttons").append('<button class="btn btn-info" type="button" id="i_wonder_release" onclick="window.location.href=\'publisharticles.jsp\'"><i class="icon icon-pencil"></i>我要发布</button>');
	}
	else{
		$("#choose_button").append('');
		$("#choose_buttons").append('');
	}
	if(checkRegist()==true){
		if(role=="老师"){
			$("#choose_button").append('<button class="btn btn-info" type="button" id="i_wonder_release" onclick="window.location.href=\'sendmessageed.jsp\'"><i class="icon icon-pencil"></i>我要发布</button>');
			$("#choose_buttons").append('<button class="btn btn-info" type="button" id="i_wonder_release" onclick="window.location.href=\'sendmessage.jsp\'"><iclass="icon icon-pencil"></i>我要发布</button>');
		}
		else{
			$("#choose_button").append('');
			$("#choose_buttons").append('');
		}
	}
	// 调用
	topage1(currentpage1);
	topage2(currentpage2);
	topage3(currentpage3);
	datashow(currentpage1);
	learnshow(currentpage2);
	authorshow(currentpage3);
})
//页码定义
var currentpage1 = 1;
var totalpage1 = 1;
var currentpage2 = 1;
var totalpage2 = 1;
var currentpage3 = 1;
var totalpage3 = 1;
var pagetemp = new Array();
//家教信息页码
function topage1(currentpage1) {
	// 点击previous时
	$("#pager1").on("click", "#previous1", function() {
		currentpage1 = currentpage1 - 1;
		datashow(currentpage1);
	});
	// 点击next时
	$("#pager1").on("click", "#next1", function() {
		currentpage1 = currentpage1 + 1;
		datashow(currentpage1);
	});
}
//学习经验页码
function topage2(currentpage2) {
	// 点击previous时
	$("#pager2").on("click", "#previous2", function() {
		currentpage2 = currentpage2 - 1;
		learnshow(currentpage2);
	});
	// 点击next时
	$("#pager2").on("click", "#next2", function() {
		currentpage2 = currentpage2 + 1;
		learnshow(currentpage2);
	});
}
//社区作者页码
function topage3(currentpage3) {
	// 点击previous时
	$("#pager3").on("click", "#previous3", function() {
		currentpage3 = currentpage3 - 1;
		authorshow(currentpage3);
	});
	// 点击next时
	$("#pager3").on("click", "#next3", function() {
		currentpage3 = currentpage3 + 1;
		authorshow(currentpage3);
	});
}
// 展示家教信息数据
function datashow(currentpage1) {
	$.ajax({
		type : 'post',
		url : 'indexfile',
		contentType : 'application/json;charset=UTF-8',
		dataType : 'json',
		async : false,
		success : function(data) {
			totalpage1 = Math.ceil(data.length / 8);
			$("#personal_name_introduce_school").html("");
			$.each(data,function(index, res) {
				// 当前页为第一页时
				if (currentpage1 == 1) {
					$("#pager1").html("");
					devicepage1 = '<li class="previous disabled"><a id="previous1">«</a></li>'
							+ '<li><span style="border:0px;">第&nbsp;&nbsp;&nbsp;'
							+ currentpage1
							+ '/'
							+ totalpage1
							+ '&nbsp;&nbsp;&nbsp;页</span></li>'
							+ '<li class="next"><a id="next1">»</a></li>';
					$("#pager1").append(devicepage1);
				}
				// 当前页为最后一页时
				if (currentpage1 == totalpage1) {
					$("#pager1").html("");
					devicepage1 = '<li class="previous"><a id="previous1">«</a></li>'
							+ '<li><span style="border:0px;">第&nbsp;&nbsp;&nbsp;'
							+ currentpage1
							+ '/'
							+ totalpage1
							+ '&nbsp;&nbsp;&nbsp;页</span></li>'
							+ '<li class="next disabled"><a id="next1">»</a></li>';
					$("#pager1").append(devicepage1);
					console.log(currentpage1);
				}
				// 当前页为中间页时
				if (currentpage1 > 1 && currentpage1 < totalpage1) {
					$("#pager1").html("");
					devicepage1 = '<li class="previous"><a id="previous1">«</a></li>'
							+ '<li><span style="border:0px;">第&nbsp;&nbsp;&nbsp;'
							+ currentpage1
							+ '/'
							+ totalpage1
							+ '&nbsp;&nbsp;&nbsp;页</span></li>'
							+ '<li class="next"><a id="next1">»</a></li>';
					$("#pager1").append(devicepage1);
					console.log(currentpage1);
				}
				if (index >= (currentpage1 - 1) * 8
						&& index <= currentpage1 * 8 - 1) {
					var len;
					if(res.introduce==null){
						introduce='还没有详细介绍呦';
					}
					else{
						len=res.introduce.length;
					}
		            if(len>27){
		            	introduce=res.introduce.substr(0,27)+'……';
		            }
		            else{
		            	introduce=res.introduce;
		            }
					teacherinf = '<a href="tutorDetail/showtutorDetail/'+res.id+'" onclick="loginstatus(this)">'
								+'<div class="card"  style="position: relative; width:262px; height:300px;">'
							    +'<div class="image">'
								+'<img src="'+res.userImg+'" style="width:263px; height:148px;">'
								+'</div>'
								+'<div class="content">'
								+'<div class="header">'+res.realName+'</div>'
								+'<div class="meta">'
								+'<a>'+res.school+'</a>'
								+'</div>'
								+'<div class="description">'+introduce+'</div>'
								+'</div>'
								+'<div class="extra content">'
								+'<span class="right floated">'+res.teachAge+'年教龄 </span>'
								+'<span><i class="icon-heart-empty" style="color:red;"></i> 520 人喜欢</span>'
								+'</div>'
								+'</div>'
								+'</a>'
					$("#personal_name_introduce_school")
							.append(teacherinf);
				}
			})
		}
	});
}
//学习社区学习经验展示
function learnshow(currentpage2) {
	$.ajax({
		type : 'post',
		url : 'articleinf',
		contentType : 'charset=UTF-8',
		dataType : 'Json',
		async : false,
		success : function(data) {
			totalpage2 = Math.ceil(data.length / 3);
			$("#box1").html("");
			$.each(data,function(index, res) {
				// 当前页为第一页时
				if (currentpage2 == 1) {
					$("#pager2").html("");
					devicepage2 = '<li class="previous disabled"><a id="previous2">«</a></li>'
							+ '<li><span style="border:0px;">第&nbsp;&nbsp;&nbsp;'
							+ currentpage2
							+ '/'
							+ totalpage2
							+ '&nbsp;&nbsp;&nbsp;页</span></li>'
							+ '<li class="next"><a id="next2">»</a></li>';
					$("#pager2").append(devicepage2);
				}
				// 当前页为最后一页时
				if (currentpage2 == totalpage2) {
					$("#pager2").html("");
					devicepage2 = '<li class="previous"><a id="previous2">«</a></li>'
							+ '<li><span style="border:0px;">第&nbsp;&nbsp;&nbsp;'
							+ currentpage2
							+ '/'
							+ totalpage2
							+ '&nbsp;&nbsp;&nbsp;页</span></li>'
							+ '<li class="next disabled"><a id="next2">»</a></li>';
					$("#pager2").append(devicepage2);
				}
				// 当前页为中间页时
				if (currentpage2 > 1 && currentpage2 < totalpage2) {
					$("#pager2").html("");
					devicepage2 = '<li class="previous"><a id="previous2">«</a></li>'
							+ '<li><span style="border:0px;">第&nbsp;&nbsp;&nbsp;'
							+ currentpage2
							+ '/'
							+ totalpage2
							+ '&nbsp;&nbsp;&nbsp;页</span></li>'
							+ '<li class="next"><a id="next2">»</a></li>';
					$("#pager2").append(devicepage2);
				}
				if (index >= (currentpage2 - 1) * 3
						&& index <= currentpage2 * 3 - 1) {
					function repalceHtml(str){
						var dd=str.replace(/<\/?.+?>/g,"");
						var dds=dd.replace(/ /g,"");//dds为得到后的内容
						return dds;
					}
					var content=repalceHtml(res.content);
					var leng=res.content.length;
		            if(leng>70){
		            	content=content.substr(0,70)+'……';
		            }
		            else{
		            	content=content;
		            }
					articlelist3='<div class="items items-hover" id="card">'+
					'<div class="item">'+
					'<div class="card_keyword">'+
					'<div class="btn-group btn-group-vertical" style="width:150px; position:relative; margin-left:15px;">'+
					'<button type="button" class="btn">#物理</button>'+
					'<button type="button" class="btn">#中考冲刺</button>'+
					'<button type="button" class="btn">#好文</button>'+
					'</div>'+
					'<h3></h3>'+
					'<div class="btn-group">'+
					'<button type="button" class="btn" id="collection" onclick="changstars()"><i class="icon icon-star-empty"></i><span'+
					'id="collectioncount">108</span></button>'+
					'<button type="button" class="btn" id="good" onclick="changegood()"><i class="icon icon-thumbs-o-up"></i><span'+
					'id="goodcount">'+res.likeCount+'</span></button>'+
					'<button type="button" class="btn"><i class="icon icon-chat-line"></i>108</button>'+
					'</div>'+
					'</div>'+
					'<div class="cards_article">'+
					'<div class="item-heading">'+
					'<div class="pull-right label label-success"></div>'+
					'<h4><a href="teacherdetail?artid='+res.aId+'" onclick="loginstatus(this)">'+res.title+'</a></h4>'+
					'</div>'+
					'<div class="item-content">'+
					'<div class="media pull-right"><img src="images/courses'+(index+1)+'.jpg" alt="" style="width:75%;margin-top:-20px; margin-left:15px;"></div>'+
					'<div class="text">'+content+'</div>'+
					'</div>'+
					'<div class="item-footer">'+
					'<a href="#" class="text-muted"><span class="text-muted">'+timestampToTime(res.sendTime)+'</span>'+
					'</div>'+
					'</div>'+
					'</div>'+
					'</div>';
					$("#box1").append(articlelist3);
				}
			});
		}
	});
}

//学习社区社区作者展示
function authorshow(currentpage3) {
	$.ajax({
		type : 'post',
		url : 'indexfile',
		contentType : 'application/json;charset=UTF-8',
		dataType : 'json',
		async : false,
		success : function(data) {
			totalpage3 = Math.ceil(data.length / 3);
			$("#box2").html("");
			$.each(data,function(index, res) {
				// 当前页为第一页时
				if (currentpage3 == 1) {
					$("#pager3").html("");
					devicepage3 = '<li class="previous disabled"><a id="previous3">«</a></li>'
							+ '<li><span style="border:0px;">第&nbsp;&nbsp;&nbsp;'
							+ currentpage3
							+ '/'
							+ totalpage3
							+ '&nbsp;&nbsp;&nbsp;页</span></li>'
							+ '<li class="next"><a id="next3">»</a></li>';
					$("#pager3").append(devicepage3);
				}
				// 当前页为最后一页时
				if (currentpage3 == totalpage3) {
					$("#pager3").html("");
					devicepage3 = '<li class="previous"><a id="previous3">«</a></li>'
							+ '<li><span style="border:0px;">第&nbsp;&nbsp;&nbsp;'
							+ currentpage3
							+ '/'
							+ totalpage3
							+ '&nbsp;&nbsp;&nbsp;页</span></li>'
							+ '<li class="next disabled"><a id="next3">»</a></li>';
					$("#pager3").append(devicepage3);
				}
				// 当前页为中间页时
				if (currentpage3 > 1 && currentpage3 < totalpage3) {
					$("#pager3").html("");
					devicepage2 = '<li class="previous"><a id="previous3">«</a></li>'
							+ '<li><span style="border:0px;">第&nbsp;&nbsp;&nbsp;'
							+ currentpage3
							+ '/'
							+ totalpage3
							+ '&nbsp;&nbsp;&nbsp;页</span></li>'
							+ '<li class="next"><a id="next3">»</a></li>';
					$("#pager3").append(devicepage3);
				}
				if (index >= (currentpage3 - 1) * 3
						&& index <= currentpage3 * 3 - 1) {
					articlelist4='<div class="items items-hover" id="author">'+
					'<div class="item">'+
					'<a href="#" onclick="loginstatus(this)"><img src="'+res.userImg+'" style="width:12%; margin-left:15px;"></a>'+
					'<div class="btn-group btn-group-vertical" style="position: relative; margin-left: 25px; width:80px; margin-top: 10px">'+
					'<button type="button" class="btn">认证家教</button>'+
					'<p></p>'+
					'<button type="button" class="btn">社区作家</button>'+
					'<p></p>'+
					'<button type="button" class="btn">高采纳率</button>'+
					'</div>'+
					'<div class="personal_introduction">'+
					'<br />'+
					'<b>个人介绍：</b>'+res.introduce+
					'</div>'+
					'<div class="personal_article">'+
					'<h3><b>他的文章</b><br /></h3>'+
					'<a href="#">'+
					'<h4>巧解物理难题——中考冲刺经验分享</h4>'+
					'</a>'+
					'<a href="#">'+
					'<h4>巧解物理难题——中考冲刺经验分享</h4>'+
					'</a>'+
					'<a href="#">'+
					'<h4>巧解物理难题——中考冲刺经验分享</h4>'+
					'</a>'+
					'<button class="btn" type="button" style="position: relative; margin-left: 240px; margin-top:-30px;">查看更多</button>'+
					'</div>'+
					'<button class="btn btn-mini " type="button" style="position: relative;margin-left:1010px; margin-top:-260px;"><i'+
					'class="icon icon-plus"></i>关注</button>'+
					'</div>'+
					'</div>';
					$("#box2").append(articlelist4);
				}
			});
		}
	});
}

//timestamp在js中的转化
function timestampToTime(timestamp) {
	   var date = new Date(timestamp);
	   Y = date.getFullYear() + '-';
	   M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
	   D = date.getDate() + ' ';
	   h = date.getHours() + ':';
	   m = date.getMinutes() + ':';
	   s = date.getSeconds();
	   return Y+M+D+h+m+s;
}

// 学习社区点击按钮切换界面
var learning_experience = document.getElementById('learning_experience');
var course_question = document.getElementById('course_question');
var community_author = document.getElementById('community_author');
function learning_experienceDis() {
	learning_experience.style.display = "block";
	course_question.style.display = "none";
	community_author.style.display = "none";
}
function course_questionDis() {
	learning_experience.style.display = "none";
	course_question.style.display = "block";
	community_author.style.display = "none";
}
function community_authorDis() {
	learning_experience.style.display = "none";
	course_question.style.display = "none";
	community_author.style.display = "block";
}

// 收藏按钮点击效果
function changstars() {
	var collection = document.getElementById("collection");
	var collectioncount = document.getElementById("collectioncount").innerText;
	if (collectioncount == 108) {
		console.log(collectioncount);
		collectioncount = parseInt(collectioncount) + 1;
		collection.innerHTML = "<i class='icon icon-star'></i><span id='collectioncount'>"
				+ collectioncount + "</span>";
	} else {
		console.log(collectioncount);
		collectioncount = parseInt(collectioncount) - 1;
		collection.innerHTML = "<i class='icon icon-star-empty'></i><span id='collectioncount'>"
				+ collectioncount + "</span>";
	}
}

// 点赞按钮点击效果
function changegood() {
	var changegood = document.getElementById("good");
	var goodcount = document.getElementById("goodcount").innerText;
	if (goodcount == 108) {
		goodcount = parseInt(goodcount) + 1;
		good.innerHTML = "<i class='icon icon-thumbs-up'></i><span id='goodcount'>"
				+ goodcount + "</span>";
	} else {
		goodcount = parseInt(goodcount) - 1;
		good.innerHTML = "<i class='icon icon-thumbs-o-up'></i><span id='goodcount'>"
				+ goodcount + "</span>";
	}
}

//如果未登录则出现弹框
var email=getCookie("EMAIL");
function loginstatus(obj){
	if(email==""){
		alert("请先登录！");
		$(obj).attr("href","#");
	}
}
var aNodes = document.getElementsByTagName("a");
if(email==""){
	for(var i=0;i<aNodes.length;i++){
		aNodes[i].onclick=function(){
			alert("请先登录！");
		};
	}
}