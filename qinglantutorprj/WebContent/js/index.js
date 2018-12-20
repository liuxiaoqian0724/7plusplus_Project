var currentpage = 1;
var totalpage = 1;
var pagetemp = new Array();
console.log(totalpage);
//页码
function topage(currentpage) {
	// 点击previous时
	$("#pager").on("click", "#previous", function() {
		currentpage = currentpage - 1;
		datashow(currentpage);
		console.log(currentpage);
	});
	// 点击next时
	$("#pager").on("click", "#next", function() {
		currentpage = currentpage + 1;
		datashow(currentpage);
		console.log(currentpage);
	});
}
// 展示数据
function datashow(currentpage) {
	$.ajax({
		type : 'post',
		url : 'indexfile',
		contentType : 'application/json;charset=UTF-8',
		dataType : 'json',
		async : false,
		success : function(data) {
			totalpage = Math.ceil(data.length / 8);
			$("#personal_name_introduce_school").html("");
			$.each(data,function(index, res) {
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
				if (index >= (currentpage - 1) * 8
						&& index <= currentpage * 8 - 1) {
					var str=res.introduce;
		            if(str.length>27){
		            	introduce=str.substr(0,30)+'……';
		            }
		            else{
		            	introduce=str;
		            }
					teacherinf = '<div class="card"  style="position: relative; width:262px; height:300px;">'
							    +'<div class="image">'
								+'<img src="'+res.userImg+'">'
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
								+'<span><i class="icon-heart-empty"></i> 520 人喜欢</span>'
								+'</div>'
								+'</div>'
					$("#personal_name_introduce_school")
							.append(teacherinf);
				}
			})
		}
	});
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