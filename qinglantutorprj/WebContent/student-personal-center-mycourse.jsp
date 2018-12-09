<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="dist/css/zui.css" />
		<link rel="stylesheet" type="text/css" href="css/personal-center.css">
		<link rel="stylesheet" type="text/css" href="css/student-mycourse.css">
		<link rel="stylesheet" type="text/css" href="css/header.css"/>
		<link rel="stylesheet" type="text/css" href="css/footer.css"/>
		<link rel="stylesheet" type="text/css" href="css/assignment_homework.css">
		<link rel="stylesheet" href="dist/lib/kindeditor/kindeditor.css" />
		<link rel="stylesheet" href="dist/lib/kindeditor/kindeditor.min.css" />
		<link href="dist/lib/datetimepicker/datetimepicker.min.css" rel="stylesheet">
		
		<!-- ZUI Javascript 依赖 jQuery -->
		<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
		<!-- ZUI 标准版压缩后的 JavaScript 文件 -->
		<script src="dist/js/zui.min.js"></script>
		<link href="dist/lib/datetimepicker/datetimepicker.min.css" rel="stylesheet">
		<script src="dist/lib/kindeditor/kindeditor.min.js"></script>
		<script src="dist/lib/kindeditor/kindeditor.js"></script>
		<script src="dist/lib/kindeditor/kindeditor/plugins.ok.js"></script>
		<script src="dist/lib/datetimepicker/datetimepicker.min.js"></script>
		
		<script type="text/javascript" charset="utf-8" src="textarea/ueditor.config.js"></script>
    	<script type="text/javascript" charset="utf-8" src="textarea/ueditor.all.min.js"> </script>
    	<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    	<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    	<script type="text/javascript" charset="utf-8" src="textarea/lang/zh-cn/zh-cn.js"></script>
		
		<style type="text/css">
		  #inputSearchExample3{
		    width: 228.67px;
		  }
		  .input-group-btn{
		    display: block;
		    width: 52px;
		    height: 32px;
		  }
		  #header-login > span:first-of-type{
		    margin-left: -10px;
		  }
		  #header-login > span:last-of-type{
		    margin-left: -10px;
		  }
		</style>
	<title>学生，我的课程</title>
</head>
<body>
<!-- 头部 -->
<div id="head">
    <div id="header-box">
    <div id="big-box">
      <!-- logo -->
      <div id="top-box">
        <div id="top-box-logo">
          <img src="images/headerlogo.png" alt="logo" id="logoPic">
          <div id="name-pic"><img src="images/nameTop.png" alt="namePic" style="width: 263.3px;height:66px;"></div>
        </div>
      </div>
    </div>
      <!-- 下拉菜单 -->
      <div id="bottom-box">
        <div id="topBox2">
          <ul id="navFont">
          <li class="navFont1"><a href="#">首页</a></li>
          <li><a href="#">家教</a>
            <ul>
              <li><a href="#">小学</a></li>
              <li><a href="#">初中</a></li>
              <li><a href="#">高中</a></li>
            </ul>
          </li>
          <li><a href="#">论坛社区</a>
            <ul>
              <li><a href="#">学霸说</a></li>
              <li><a href="#">资料库</a></li>
              <li><a href="#">家长岛</a></li>
            </ul>
          </li>
          <li><a href="#">我要提问</a>
            <ul>
              <li><a href="#">心理困惑</a></li>
              <li><a href="#">情感问题</a></li>
              <li><a href="#">学习障碍</a></li>
            </ul>
          </li>
          <li><a href="#">个人中心</a></li>
        </ul>
      <!-- 搜索框 -->
      <!-- <div id="searchPart">
          <form id="partForm">
            <input type="text" value="请输入您要搜索的科目" id="partInput" autofocus="autofocus" />
            <input type="submit" id="search_btn" name="heder-submit" value="搜索" />
          </form>
        </div> -->
        <div class="input-group">
            <div class="input-control search-box search-box-circle has-icon-left has-icon-right search-example" id="searchboxExample">
              <input id="inputSearchExample3" type="search" class="form-control search-input" placeholder="搜索">
              <label for="inputSearchExample3" class="input-control-icon-left search-icon"><i class="icon icon-search"></i></label>
            </div>
          <span class="input-group-btn">
            <button class="btn btn-primary" type="button">搜索</button>
          </span>
      </div>
        <!-- 登录注册 -->
        <div id="header-login">
          <span><a href="#">登录</a></span>
          <!-- <span>/</span> -->
          <span><a href="#">注册</a></span>
        </div>
      </div>
      </div>
  </div>
</div>
<script>
        var search = document.getElementById("partInput");
        search.onfocus = function(){
            search.value="";
        }
</script>

	<!--作业布置-->
	<div id="assign">
		<div class="container-fixed">
			<div id="closeframe">
				<button id="closebutton" onclick="closeframe()" class="btn"><i class="icon icon-times"></i></button>
			</div>
			<br />
			<div class="panel-body">
				<h2>作业布置</h2>
				<hr />
				<!--上半部分左边输入框-->
				<div id="leftbox">
					<!--作业完成日期-->
					<lable>作业完成日期</label>
						<label>
							<input type="text" class="form-control form-date" placeholder="选择或者输入一个日期：yyyy-MM-dd" style="width:400px;">
						</label>
						<br /><br />
						<!--作业预计耗时-->
						<lable>作业预计耗时</label>
							<label>
								<input type="text" class="form-control" placeholder="单位为小时,例如'3.5'">
							</label>
							<br /><br />
							<!--作业科目-->
							<lable>作业科目</label>
								<label>
									<input type="text" class="form-control" placeholder="例如'物理'">
								</label>
								<br />
				</div>
				<!--上半部分右边输入框-->
				<div id="rightbox">
					<!--作业题目-->
					<lable>作业题目</label>
						<label>
							<input type="text" class="form-control" placeholder="" style="width:400px;">
						</label>
						<br /><br />
						<!--作业备注-->
						<lable>作业备注</label>
							<label>
								<textarea class="form-control" rows="3" placeholder="可以输入多行文本" style="width:400px; height:100px; position: relative; margin-left:60px; margin-top:-20px;"></textarea>
							</label>
							<br />
				</div>
				<!--富文本编辑框-->
				<div id="container">
					<lable>作业内容</label>
						<div id="write-box-text"><textarea id="contentSimple" name="content" class="form-control kindeditorSimple"></textarea></div>
				</div>
				<br />
				<!--按钮-->
				<div id="choose_button">
					<button class="btn btn-primary " type="button">保存</button>
					<button class="btn " type="button">预览</button>
					<button class="btn btn-primary " type="button">提交</button>
				</div>
			</div>
		</div>
	</div>

<!-- 中部 -->
<div id="content">
    <div id="c1">
      <ul>
        <li id="c1-img">
          <div><img src="http://zui.sexy/docs/img/img2.jpg" width="120px" height="120px" class="img-circle" alt="圆形图片"></div>
          <p>积分：1024</p>
        </li>
        <li id="c1-about">
          <p>狗蛋</p>
          <span class="label label-badge">认证家教</span>
          <span class="label label-badge">大三</span>
        </li>
        <li id="c1-person">
          <p id="c1-person-p1">个人介绍</p>
          <p id="c1-person-p2">
            &nbsp;&nbsp;123123123123123fjhakjfhadjfhakjfhfjhlllllllllllllllllllaaaaa
          </p>
        </li>
        <li id="c1-star">
          <p id="c1-star-p1">学员评分</p>
          <div id=c1-star-div>
            <img src="images/fill-star.png" style="width: 25px;height: 25px;">
            <img src="images/fill-star.png" style="width: 25px;height: 25px;">
            <img src="images/fill-star.png" style="width: 25px;height: 25px;">
            <img src="images/fill-star.png" style="width: 25px;height: 25px;">
            <img src="images/empty-star.png" style="width: 25px;height: 25px;">
            <form>
              <input type="submit" name="查看详情" value="查看详情">
            </form>
          </div>
        </li>
      </ul>
    </div>
    <div id="c2">
      <div class="c2" id="c2-left">
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-envelope"></i>&nbsp;我的消息<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="i2con icon-book"></i>&nbsp;我的课程<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-flag"></i>&nbsp;学员评价<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-newspaper-o"></i>&nbsp;我的文章<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-question-sign"></i>&nbsp;我的问答<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-wrench"></i>&nbsp;个人资料<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-stack"></i>&nbsp;我的教案<i class="icon icon-chevron-right"></i></a></div>
         <div class="c2-left-item" id="c2-left-news"><a href="#"><i class="icon icon-file-text-o"></i>&nbsp;我的作业<i class="icon icon-chevron-right"></i></a></div>
      </div>
      <div class="c2 panel" id="c2-right">
        <div class="panel-heading">
          <h2>我的课程</h2>
        </div>
        <div class="panel-body">
          <div  class="c2-right-item"> 
              <ul>
                <li>
                  <span>科目</span>
                  <p>数学</p>
                </li>
                <li>
                  <span>学生</span>
                  <div>
                    <img src="images/b.jpg" width="115px" height="115px" class="img-circle" alt="圆形图片">
                  </div>
                  <p>李狗蛋</p>
                </li>
                <li>
                  <span>作业</span><br>
                  <span style="text-align: center; ">已完成：...</span><br><br>
                    <p>.....作业</p><p>.....作业</p><p>.....作业</p><p>.....作业</p><p>.....作业</p><p>.....作业</p><p>.....作业</p><p>.....作业</p>   
                </li>
                <li>
                  <span>课程时间</span><br><br>
                  <div id="">
                    <span class="course-time1">9-11</span>
                    <span>~~</span>
                    <span class="course-time1">10-10</span>
                  </div>
                  <button type="button">
                      <a href = "javascript:void(0)" onclick = "buttontime(1)">更改时间</a>
                  </button>
                </li>
                <li>
                  <form action="#" method="post">
                    <input type="button" name="detail" value="课程反馈" onclick="document.getElementById('review').style.display='block';document.getElementById('fade').style.display='block';">
                  </form>
                  <form action="#" method="post">
                    <input type="button" name="detail" value="布置作业" onclick="homework()">
                  </form>
                  <form action="#" method="post">
                    <input type="submit" name="detail" value="查看文案">
                  </form>
                </li>
              </ul>
          </div>
          <div  class="c2-right-item"> 
              <ul>
                <li>
                  <span>科目</span>
                  <p>数学</p>
                </li>
                <li>
                  <span>学生</span>
                  <div>
                    <img src="images/b.jpg" width="115px" height="115px" class="img-circle" alt="圆形图片">
                  </div>
                  <p>李狗蛋</p>
                </li>
                <li>
                  <span>作业</span><br>
                  <span style="text-align: center; ">已完成：...</span><br><br>
                    <p>.....作业</p><p>.....作业</p><p>.....作业</p><p>.....作业</p><p>.....作业</p><p>.....作业</p><p>.....作业</p><p>.....作业</p>   
                </li>
                <li>
                  <span>课程时间</span><br><br>
                  <div id="">
                    <span class="course-time2">9-11</span>
                    <span>~~</span>
                    <span class="course-time2">10-10</span>
                  </div>
                  <button type="button">
                      <a href = "javascript:void(0)" onclick = "buttontime(2)">更改时间</a>
                  </button>
                </li>
                <li>
                  <form action="#" method="post">
                    <input type="submit" name="detail" value="课程反馈">
                  </form>
                  <form action="#" method="post">
                    <input type="button" name="detail" value="布置作业" onclick="homework()">
                  </form>
                  <form action="#" method="post">
                    <input type="submit" name="detail" value="查看文案">
                  </form>
                </li>
              </ul>
          </div>
        </div>
       	<div id="light" class="white_content">
              <a href = "javascript:void(0)" onclick = "document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'"><i class="icon icon-times"></i></a><br><br>
              开始时间：
              <input id="c2-right-item-l4-inp1" type="text" class="form-control form-date" placeholder="选择或者输入一个日期：MM-dd">
              结束时间：
              <input id="c2-right-item-l4-inp2" type="text" class="form-control form-date" placeholder="选择或者输入一个日期：MM-dd">
              <button type="button">
                  <a href = "javascript:void(0)" onclick = "buttontime(0)">保存</a>
              </button>
        </div> 
        <div id="review" class="white_content" style="width: 1000px;">
        	<a href = "javascript:void(0)" onclick = "document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'"><i class="icon icon-times"></i></a><br><br>
		   	<script id="editor" type="text/plain" style="width:600px;height:300px;"></script>
        </div>
        <div id="fade" class="black_overlay"></div> 
        <script type="text/javascript">
            var a = 0;
            var b = 0;
            function buttontime(i){
              if(i==0){
                document.getElementsByClassName(b)[0].innerHTML=document.getElementById('c2-right-item-l4-inp1').value;
                document.getElementsByClassName(b)[1].innerHTML=document.getElementById('c2-right-item-l4-inp2').value;
                document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none';
                coursetime();
              }else{
                a=i;
                b ='course-time'+a;
                document.getElementById('c2-right-item-l4-inp1').value=document.getElementsByClassName(b)[0].innerHTML;
                document.getElementById('c2-right-item-l4-inp2').value=document.getElementsByClassName(b)[1].innerHTML;
                document.getElementById('light').style.display='block';document.getElementById('fade').style.display='block';
              }
            }
            function coursetime(){
            	var startTime = document.getElementById('c2-right-item-l4-inp1').value;
            	var endTime = document.getElementById('c2-right-item-l4-inp2').value;
            	var courseTime = startTime + "===" + endTime;
            	alert(courseTime);
            	$.ajax({
            		type:"POST",
            		//contentType : "application/json",
            		url:"test",
            		dataType:"json", 
            		data:{"courseTime":courseTime,"ab":"23"},
            		success:function(postdata){
            			alert(postdata);
            			//alert(postdata.coursetime);
            			alert("success");
            		},
            		error:function(){
            			alert("error");
            		}
            	});
            };
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
        </script> 
      </div>
    </div>
</div>
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
	
	<script>
		// 日期选择
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
			format: "yyyy-mm-dd"
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
				        'imagecenter', //居中
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
				  ]
			  ]
		});
	</script>
	
</body>
</html>