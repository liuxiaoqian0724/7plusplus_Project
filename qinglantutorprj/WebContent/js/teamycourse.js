var a = 0;
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
    		"crid":a
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
    a=param;
    b ='course-time'+a;
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

//富文本编辑框
KindEditor.create('textarea.kindeditorSimple', {
	basePath: '/dist/lib/kindeditor/',
	bodyClass : 'article-content',
	resizeType : 1,
	allowPreviewEmoticons : false,
	allowImageUpload : false,
	items : [
		'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
		'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
		'insertunorderedlist', '|', 'emoticons', 'image', 'link'
	]
});

//布置作业按钮点击效果
var assign=document.getElementById("assign");
assign.style.display="none";
function homework(){
	var fade=document.getElementById("fade");
	if(assign.style.display=="none"){
		assign.style.display="block";
		fade.style.display="block";
	}
	else{
		assign.style.display="none";
		fade.style.display="none";
	}
}

//关闭布置作业弹框
function closeframe(){
	var fade=document.getElementById("fade");
	assign.style.display="none";
	fade.style.display="none";
}



