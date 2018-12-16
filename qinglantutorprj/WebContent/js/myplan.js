//实例化编辑器
//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
var ue = UE.getEditor('editor',{
    toolbars:[
        [
        	'bold', //加粗
			  'indent', //首行缩进
	        'italic', //斜体
	        'underline', //下划线
	        'strikethrough', //删除线
	        'justifyleft', //居左对齐
	        'justifyright', //居右对齐
	        'justifycenter', //居中对齐
	        'justifyjustify', //两端对齐
	        'forecolor', //字体颜色
	        'backcolor', //背景色
	        'subscript', //下标
	        'fontborder', //字符边框
	        'superscript', //上标
	        'fontfamily', //字体
	        'fontsize', //字号
	        'pasteplain', //纯文本粘贴模式
	        'selectall', //全选
	         'horizontal', //分隔线
	        'removeformat', //清除格式
	        'link', //超链接
	        'emotion', //表情
	        'spechars', //特殊字符
	        'simpleupload', //单图上传
        ]
    ]
});
var ue2 = UE.getEditor('editor-2',{
    toolbars:[
        [
        	'bold', //加粗
			  'indent', //首行缩进
	        'italic', //斜体
	        'underline', //下划线
	        'strikethrough', //删除线
	        'justifyleft', //居左对齐
	        'justifyright', //居右对齐
	        'justifycenter', //居中对齐
	        'justifyjustify', //两端对齐
	        'forecolor', //字体颜色
	        'backcolor', //背景色
	        'subscript', //下标
	        'fontborder', //字符边框
	        'superscript', //上标
	        'fontfamily', //字体
	        'fontsize', //字号
	        'pasteplain', //纯文本粘贴模式
	        'selectall', //全选
	         'horizontal', //分隔线
	        'removeformat', //清除格式
	        'link', //超链接
	        'emotion', //表情
	        'spechars', //特殊字符
	        'simpleupload', //单图上传
        ]
    ]
});

//仅选择日期
$(".form-date").datetimepicker(
{
    language:  "zh-CN",
    weekStart: 1,
    todayBtn:  1,
    autoclose: 1,
    todayHighlight: 1,
    startView: 2,
    minView: 2,
    forceParse: 0,
    format: "mm-dd"
});



//打开教案编辑键
var which = 0;
var planid = 0;
function contentOpen(i){
	which="content-"+i;
	planid = i;
	$("#light").css("display","block");
	$("#fade").css("display","block");
	var content = document.getElementById(which).innerHTML;
	var time = document.getElementById("time-"+i).innerHTML;
	//清空内容插入
	UE.getEditor('editor').setContent(content,false);
	$("#light > div > input").val(time);
	$("#light >span").css("display","none");
}

//点击确定键
function getContent() {
    var arr = [];
    arr.push(UE.getEditor('editor').getContent());
    var content=arr.join("\r\n");
    var time = $("#light > div > input").val();
    if(content.length==0){
    	$("#light >span").css("display","block");
    }else{
    	var json = {
    		"id":planid,"content":content,"time":time
    	};
    	$.ajax({
    		type:"post",
    		dataType:"json",
    		url:"teachPlanEdit",
    		data:json,
    		success:function(data){
    			alert(data);
    			document.getElementById(which).innerHTML=content;
    	    	document.getElementById("time-"+planid).innerHTML=time;
    		},
    		error:function(){
    			alert("error");
    		}
    	});
    	$("#light").css("display","none");
    	$("#fade").css("display","none");
    }
        
}

//删除某个教案
function deletePlan(pid){
	var id = "plan-" + pid;
	$("div").remove(".c2-right-item #" + id);
	$.ajax({
		type:"post",
		dataType:"json",
		data:{"id":pid},
		url:"teachPlanDelete",
		success:function(data){
			alert(data);
		},
		error:function(){
			alert("error");
		}
	});
}

//点击新增教案键
var trid = 0;
function addTeachPlan(param){
	trid = param;
	$("#addPlan").css("display","block");
	$("#fade").css("display","block");
	$("#addPlan >span").css("display","none");
}

//新增按钮的 确定
function addTeachPlanInfor(){
	 var arr = [];
    arr.push(UE.getEditor('editor-2').getContent());
    var content=arr.join("\r\n");
    var time = $("#addPlan > div > input").val();
    var total = 0;
    if(content.length==0||time.length==0){
    	$("#addPlan >span").css("display","block");
    }else{
    	$.ajax({
        	type:"post",
        	dataType:"json",
        	url:"teachPlanAdd",
        	data:{"trid":trid,"content":content,"time":time},
        	success:function(data){
    			alert("反馈成功");
    			total = parseInt(data);
    			$("#addPlan").css("display","none");
    			$("#fade").css("display","none");
    			var id = "addPlan-" + trid;
    			$("#"+id).append("<div id=\"plan-"+total+"\">" +
    		    		"<a href=\"javascript:void(0)\"  onclick=\"deletePlan("+total+" })\"><span class=\"icon icon-times\"></span></a>" 
    		    		+"<div id=\"content-"+total+"\">"+content+"</div>" 
    		    		+"<span id=\"time-"+total+"\">"+time+"</span>" 
    		    		+"</div>");
    		},
    		error:function(){
    			alert("error");
    		}
        });
    	
    }
    
}
	
