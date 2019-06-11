$(document).ready(function(){
	//调用
	topage4(currentpage4);
	listshow(currentpage4);
})
//页码定义
var currentpage4 = 1;
var totalpage4 = 1;
//timestamp类型在js中的转化
function timestampToTime(timestamp) {
	var date = new Date(timestamp);
	Y = date.getFullYear() + '-';
	M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
	D = date.getDate() + ' ';
	h = date.getHours() + ':';
	m = date.getMinutes() + ':';
	s = date.getSeconds();
	return Y+M+D;
}
//家教信息页码
function topage4(currentpage4) {
	// 点击previous时
	$("#pager4").on("click", "#previous4", function() {
		currentpage4 = currentpage4 - 1;
		listshow(currentpage4);
	});
	// 点击next时
	$("#pager4").on("click", "#next4", function() {
		currentpage4 = currentpage4 + 1;
		listshow(currentpage4);
	});
}
function listshow(currentpage4) {
	$.ajax({
		type : 'post',
		url : 'articles',
		contentType : 'charset=UTF-8',
		dataType : 'Json',
		async : false,
		success : function(data) {
			totalpage4 = Math.ceil(data.length / 5);
			$("#articlel").html("");
			$("#articlelist").html("");
			$.each(data,function(index, res) {
				// 当前页为第一页时
				if (currentpage4 == 1) {
					$("#pager4").html("");
					devicepage4 = '<li class="previous disabled"><a id="previous4">«</a></li>'
							+ '<li><span style="border:0px;">第&nbsp;&nbsp;&nbsp;'
							+ currentpage4
							+ '/'
							+ totalpage4
							+ '&nbsp;&nbsp;&nbsp;页</span></li>'
							+ '<li class="next"><a id="next4">»</a></li>';
					$("#pager4").append(devicepage4);
				}
				// 当前页为最后一页时
				if (currentpage4 == totalpage4) {
					$("#pager4").html("");
					devicepage4 = '<li class="previous"><a id="previous4">«</a></li>'
							+ '<li><span style="border:0px;">第&nbsp;&nbsp;&nbsp;'
							+ currentpage4
							+ '/'
							+ totalpage4
							+ '&nbsp;&nbsp;&nbsp;页</span></li>'
							+ '<li class="next disabled"><a id="next4">»</a></li>';
					$("#pager4").append(devicepage4);
				}
				// 当前页为中间页时
				if (currentpage4 > 1 && currentpage4 < totalpage4) {
					$("#pager4").html("");
					devicepage4 = '<li class="previous"><a id="previous4">«</a></li>'
							+ '<li><span style="border:0px;">第&nbsp;&nbsp;&nbsp;'
							+ currentpage4
							+ '/'
							+ totalpage4
							+ '&nbsp;&nbsp;&nbsp;页</span></li>'
							+ '<li class="next"><a id="next4">»</a></li>';
					$("#pager4").append(devicepage4);
				}
				if(index<4){
					articlelist1='<div class="col-md-4 col-sm-6 col-lg-3">'+
					'<a class="card" href="teacherdetail?artid='+res.aId+'" style="position:relative; width:93%; margin-left:1%;">'+
					'<img src="images/img2.jpg" alt="">'+
					'<div class="card-heading"><strong>'+res.title+'</strong></div>'+
					'<div class="pull-right" style="position:relative;margin-right:3%;"><i class="icon-thumbs-o-up"></i>'+res.likeCount+'</div>'+
					'</a>'+
					'</div>';
					$("#articlel").append(articlelist1);
				}
				if (index >= (currentpage4 - 1) * 5
						&& index <= currentpage4 * 5 - 1) {
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
					articlelist2='<div class="articlecard">'+
						'<a href="teacherdetail?artid='+res.aId+'"><img src="images/course'+(index+1)+'.jpg" class="img-rounded" alt="圆角图片" style="position:relative; margin:1%; width:15%;"></a>'+
						'<div class="card-heading" style="position: relative; margin-top:-11%; left:20%; width:80%;"><a href="teacherdetail?artid='+res.aId+'"><strong>'+res.title+'</strong></a></div>'+
						'<div class="card-content text-muted" style="position: relative; left:20%; width:75%;">'+content+
						'</div>'+
						'<div class="author">'+
						'<img src="images/idphotocircle'+(index+1)+'.png" style="position: relative; width: 4%; left:20%; margin:1%;" />'+
						'<div style="position: relative; left: 26%; margin-top:-4%; margin-bottom: 1%; width:30%;">Alexander</div>'+
						'<div style="position:relative; left: 35%; margin-top:-3%; margin-bottom: 1%; width:30%;" type="datatime-local">'+timestampToTime(res.sendTime)+'</div>'+
						'<div class="pull-right" style="position:relative; margin-top:-3%; right:2%;"><i class="icon-comment-alt"></i>19</div>'+
						'<div class="pull-right" style="position:relative; margin-top:-3%; right:6%;"><i class="icon-thumbs-o-up"></i>'+res.likeCount+'</div>'+
						'<div class="pull-right" style="position:relative; margin-top:-3%; right:10%;"><i class="icon-star-empty"></i>19</div>'+
						'</div>'+
						'</div>';
					$("#articlelist").append(articlelist2);
				}
			});
		}
	});
}