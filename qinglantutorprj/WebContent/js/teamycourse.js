
//修改课程时间
var cridTime = 0;
var b = 0;
function buttonTimeSubmit(){
    document.getElementsByClassName(b)[0].innerHTML=document.getElementById('c2-right-item-l4-inp1').value;
    document.getElementsByClassName(b)[1].innerHTML=document.getElementById('c2-right-item-l4-inp2').value;
    document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none';
    var startTime = document.getElementById('c2-right-item-l4-inp1').value;
    var endTime = document.getElementById('c2-right-item-l4-inp2').value;
    var json = {
    		"startTime":startTime,
    		"endTime":endTime,
    		"crid":cridTime
    }
    $.ajax({
    	type:"post",
    	contentType:"application/json",
    	url:"courseTime",
    	dataType:"json",
    	data:JSON.stringify(json),
    	success:function(data){
			alert(data);
		},
		error:function(){
			alert("error");
		}
    	
    });
}    
function buttonTimeOpen(param){
	cridTime=param;
    b ='course-time'+cridTime;
    document.getElementById('c2-right-item-l4-inp1').value=document.getElementsByClassName(b)[0].innerHTML;
    document.getElementById('c2-right-item-l4-inp2').value=document.getElementsByClassName(b)[1].innerHTML;
    document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block';
}



//日期选择
$(".form-date1").datetimepicker(
{
	language:  "zh-CN",
	weekStart: 1,
	todayBtn:  1,
	autoclose: 1,
	todayHighlight: 1,
	startView: 2,
	minView: 2,
	forceParse: 0,
	format: "yyyy-mm-dd"
});
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


//布置作业按钮点击效果

var cridHomework = 0;
function homeworkOpen(param){
	cridHomework = param;
	$("#fade").css("display","block");
	$("#course").css("display","block");
	$("#course > span").css("display","none");
	$("#course > button").attr("disabled",false);
	$("#course > button").mouseover(function () {
        $(this).css("background", "#33a6b8");
    }).mouseout(function () {
        $(this).css("background", "white");
    });
};

//关闭布置作业弹框
function homeworkClose(){
	$("#fade").css("display","none");
	$("#course").css("display","none");
}
//作业提交页面
function homeworkSubmit(){
	var arr = [];
    arr.push(UE.getEditor("editor").getContent());
    var content = arr.join("\n");
    var deadlinetime = $("#coursedeadtime").val();
    if(content.length==0 || deadlinetime.length == 0){
    	$("#course > span").css("display","block");
    	$("#course > button").attr("disabled",true);
    	$("#course > button").css("background","white");
    }else{
    	$.ajax({
        	type:"post",
        	url:"courseHomework",
        	dataType:"json",
        	data:{"cridHomework":cridHomework,"content":content,"deadlinetime":deadlinetime},
        	success:function(data){
        		alert(data);
        	},
        	error:function(){
        		alert("error");
        	}
        });
    	UE.getEditor("editor").setContent("");
    	$("#coursedeadtime").val("");
    	homeworkClose();
    }
}


//富文本编辑框
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
	        'time', //时间
	        'date', //日期
	        'link', //超链接
	        'emotion', //表情
	        'spechars', //特殊字符
	        'simpleupload', //单图上传
		]
	]
});

