
var check = 0;//该变量是记录当前选择的评分

//点击课程反馈按钮，可以得到上课关系表的ID，就可以得到classRelation对象以方便插入
var classRelationId = 0;
function reviewClick(a){
	classRelationId = a;
	$("#review").css("display","block");
	$("#fade").css("display","block");
};

function reviewClose(){
	$("#review").css("display","none");
	$("#fade").css("display","none");
	$("#star1").attr("src","images/empty-star.png");
	$("#star2").attr("src","images/empty-star.png");
	$("#star3").attr("src","images/empty-star.png");
	$("#star4").attr("src","images/empty-star.png");
	$("#star5").attr("src","images/empty-star.png");
	$("#review > textarea").val("");
}

function reviewSubmit(){
	if(check==0){
		$("#review > button").attr("disabled",true);
		$("#review > button").attr("id","noStarButton");
		$("#review > span").css("display","block");
	}else{
		var content =$("#review > textarea").val();
		$.ajax({
			type:"post",
			//contentType:"application/json",
			url:"courseReview",
			dataType:"json",
			data:{"classRelationId":classRelationId,"reviewContent":content,"reviewStar":check},
			success:function(data){
				alert(data);
			},
			error:function(){
				alert("error");
			}
		});
		reviewClose();
	}
};


/*click()点击事件处理，记录打分*/
function click(param){
	check = param;//记录当前打分
	out();//设置星星数
	$("#review > button").attr("disabled",false);
	$("#review > button").removeAttr("id");
	$("#review > span").css("display","none");
}

/*over()是鼠标移过事件的处理方法*/
function over(param){
	if(param == 1){
		$("#star1").attr("src","images/fill-star.png");//第一颗星星亮起来，下面以此类推
	}else if(param == 2){
		$("#star1").attr("src","images/fill-star.png");
		$("#star2").attr("src","images/fill-star.png");
	}else if(param == 3){
		$("#star1").attr("src","images/fill-star.png");
		$("#star2").attr("src","images/fill-star.png");
		$("#star3").attr("src","images/fill-star.png");
	}else if(param == 4){
		$("#star1").attr("src","images/fill-star.png");
		$("#star2").attr("src","images/fill-star.png");
		$("#star3").attr("src","images/fill-star.png");
		$("#star4").attr("src","images/fill-star.png");
	}else if(param == 5){
		$("#star1").attr("src","images/fill-star.png");
		$("#star2").attr("src","images/fill-star.png");
		$("#star3").attr("src","images/fill-star.png");
		$("#star4").attr("src","images/fill-star.png");
		$("#star5").attr("src","images/fill-star.png");
	}
}

/*out 方法是鼠标移除事件的处理方法，当鼠标移出时，恢复到我的打分情况*/
function out(){
	if(check == 1){//打分是1，设置第一颗星星亮，其他星星暗，其他情况以此类推
		$("#star1").attr("src","images/fill-star.png");
		$("#star2").attr("src","images/empty-star.png");
		$("#star3").attr("src","images/empty-star.png");
		$("#star4").attr("src","images/empty-star.png");
		$("#star5").attr("src","images/empty-star.png");
	}else if(check == 2){
		$("#star1").attr("src","images/fill-star.png");
		$("#star2").attr("src","images/fill-star.png");
		$("#star3").attr("src","images/empty-star.png");
		$("#star4").attr("src","images/empty-star.png");
		$("#star5").attr("src","images/empty-star.png");
	}else if(check == 3){
		$("#star1").attr("src","images/fill-star.png");
		$("#star2").attr("src","images/fill-star.png");
		$("#star3").attr("src","images/fill-star.png");
		$("#star4").attr("src","images/empty-star.png");
		$("#star5").attr("src","images/empty-star.png");
	}else if(check == 4){
		$("#star1").attr("src","images/fill-star.png");
		$("#star2").attr("src","images/fill-star.png");
		$("#star3").attr("src","images/fill-star.png");
		$("#star4").attr("src","images/fill-star.png");
		$("#star5").attr("src","images/empty-star.png");
	}else if(check == 5){
		$("#star1").attr("src","images/fill-star.png");
		$("#star2").attr("src","images/fill-star.png");
		$("#star3").attr("src","images/fill-star.png");
		$("#star4").attr("src","images/fill-star.png");
		$("#star5").attr("src","images/fill-star.png");
	}else if(check == 0){
		$("#star1").attr("src","images/empty-star.png");
		$("#star2").attr("src","images/empty-star.png");
		$("#star3").attr("src","images/empty-star.png");
		$("#star4").attr("src","images/empty-star.png");
		$("#star5").attr("src","images/empty-star.png");
	}
}


