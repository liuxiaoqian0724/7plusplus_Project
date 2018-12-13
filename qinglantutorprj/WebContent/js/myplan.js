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


var which = 0;

function getContent() {
	document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none';
    var arr = [];
    arr.push(UE.getEditor('editor').getContent());
    var content=arr.join("\r\n");
    alert(content);

    document.getElementById(which).innerHTML=content;

    // alert(content);
    
}
function setContent(i){
	which=i;
	document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block';
	var a = document.getElementById(i).innerHTML;
	//清空内容插入
	UE.getEditor('editor').setContent(a,false);
}

	
