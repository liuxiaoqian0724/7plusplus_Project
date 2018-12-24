//实例化编辑器
//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
var ue = UE.getEditor('editor',{
    toolbars:[
        [
             'bold', //加粗
              'indent', //首行缩进
            'snapscreen', //截图
            'italic', //斜体
            'underline', //下划线
            'strikethrough', //删除线
            'subscript', //下标
            'fontborder', //字符边框
            'superscript', //上标
            'formatmatch', //格式刷
            'blockquote', //引用
            'pasteplain', //纯文本粘贴模式
            'selectall', //全选
             'horizontal', //分隔线
            'removeformat', //清除格式
            'time', //时间
            'date', //日期
            'insertrow', //前插入行
            'insertcol', //前插入列
            'mergeright', //右合并单元格
            'mergedown', //下合并单元格
            'deleterow', //删除行
            'deletecol', //删除列
             'splittocells', //完全拆分单元格
            'deletecaption', //删除表格标题
            'inserttitle', //插入标题
            'mergecells', //合并多个单元格
            'deletetable', //删除表格
            'cleardoc', //清空文档
            'insertparagraphbeforetable', //"表格前插入行"
            'fontfamily', //字体
            'fontsize', //字号
            'paragraph', //段落格式
            'simpleupload', //单图上传
             'edittable', //表格属性
            'edittd', //单元格属性
            'link', //超链接
            'emotion', //表情
            'spechars', //特殊字符
            'searchreplace', //查询替换
            'justifyleft', //居左对齐
            'justifyright', //居右对齐
            'justifycenter', //居中对齐
            'justifyjustify', //两端对齐
            'forecolor', //字体颜色
            'backcolor', //背景色
            'insertorderedlist', //有序列表
            'insertunorderedlist', //无序列表
            'fullscreen', //全屏
            'rowspacingtop', //段前距
            'rowspacingbottom', //段后距
            'pagebreak', //分页
            'imagenone', //默认
            'imageleft', //左浮动
            'imageright', //右浮动
            'attachment', //附件
             'lineheight', //行间距
              'imagecenter', //居中
              'touppercase', //字母大写
            'tolowercase', //字母小写
            'background', //背景
             'inserttable', //插入表格
              'charts', // 图表
        ]
    ]
});


var which = 0;

function getContent() {
	document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none';
    var arr = [];
    arr.push(UE.getEditor('editor').getContent());
    var content=arr.join("\r\n");

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

	
