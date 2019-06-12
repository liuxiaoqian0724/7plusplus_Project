<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isErrorPage="true"%>
<%response.setStatus(HttpServletResponse.SC_OK);%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>	

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/treemenu.css">
    <script src="js/treemenu.js"></script>
    <title>404</title>
</head>

<body>
<div id="wrapper">
  
	<img src="<%=basePath%>/images/404Top.png" style="position: absolute;float: left;width: 100%">
	<img src="<%=basePath%>/images/404Left.jpg" style="position: absolute; float: left;margin-top: 4%;width: 15%"  id="leftpic">
	<a  href="<%=basePath%>/javascript:onclick=jump() "><img src="images/backtoindex2.png" style="width:30%;position: absolute; float: left;margin-top: 25%;margin-left: 45%;z-index:3;"> </a>
	<img src="<%=basePath%>/images/404Bottom.jpg" style="width:85%;z-index:-2;position: absolute; float: left;margin-top: 37%;margin-left: 15%;overflow: hidden;"> 
   <img src="<%=basePath%>/images/404.jpg" style="position: absolute; float: left; margin-left: 25%; margin-top:10%;z-index:2;width: 30%">
  <img src="<%=basePath%>/images/404no2.png" style="position: absolute;float: left;margin-top:12%;margin-left:64%; width:23%; z-index: 3;">
  <img src="<%=basePath%>/images/404Logo.png" style="width:8%;position: absolute; float: left;margin-top: 11%;margin-left: 90%;z-index: 3;">
  <img src="<%=basePath%>/images/404beta.jpg" style="position: absolute; float: left;
  width:40%;margin-top:4%;margin-left: 60%;z-index:2;">
 
  <!-- treemenu -->
  <div id="Catalog">

    <ul id="prj">
      <a href="javascript:onclick=show('open') ">
      <img src="<%=basePath%>/images/right.png" id="p1" style="display: none;float: left">
      <img src="<%=basePath%>/images/show.png" id="p2" style="display:block;float: left">
      <img src="<%=basePath%>/images/prj.gif">青蓝家教网</a></ul>
    <ul id="open" class="no_circle">
      <li><img src="<%=basePath%>/images/right.png"><img src="<%=basePath%>/images/src.png"></a>src</li>
          <li> <img src="<%=basePath%>/images/right.png"><img src="<%=basePath%>/images/Apache.png">Apache Tomcat v9.0</li>
          <li><img src="<%=basePath%>/images/right.png"><img src="<%=basePath%>/images/Apache.png">JRE System Library</li> 
          <li id="bulid"><img src="<%=basePath%>/images/file.png">bulid</li>
          <li><img src="<%=basePath%>/images/right.png"><img src="<%=basePath%>/images/file.png">WebContent</li> 
          <li><a href="<%=basePath%>/javascript:onclick=show('staff')">
            <img src="<%=basePath%>/images/right.png">
            <img src="<%=basePath%>/images/file.png">制作人员名单</a></li>
          <ul id="staff">
            <li>刘晓倩</li>
            <li>崔珊</li>
            <li>王昭</li>
            <li>任家华</li>
            <li>胡宇</li>
            <li>刘杼滨</li>
            <li>董世轩</li>
          </ul>
      </ul>
      

  </div>
   <div id="tip" style="float:left;z-index: 9999;margin-left: 55%; margin-top: 12%; position: relative;font-size: 25px; font-weight: bold;">
     <p><span id="totalSecond" style="color: red; font-size: 25px; ">5</span>s内跳转到主页</p>
    </div>
</div>

  <!-- 页面跳转 -->
   
<script language="javascript" type="text/javascript"> 
var second = totalSecond.innerText;
  setInterval("redirect()", 1000);
  function redirect() {
    totalSecond.innerText = --second;
    if(second <= 0) location.href = '/qinglantutorprj/index.jsp';
  }
</script> 
</body></html>