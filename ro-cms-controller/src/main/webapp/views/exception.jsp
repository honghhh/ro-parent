<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="java.io.StringWriter"%>
<%@page import="java.io.PrintWriter"%>
<%
	String errorMsg = null;
	Throwable ex = null;
	if (request.getAttribute("javax.servlet.error.exception") != null) {
		ex = (Throwable) request.getAttribute("javax.servlet.error.exception");
	} else {
		//ex = exception;
	}
	//记录日志
	if (ex != null) {
		StringWriter stringWriter = new StringWriter();
		ex.printStackTrace(new PrintWriter(stringWriter));
		errorMsg = stringWriter.toString();
	}
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
<script src="/js/jquery.js"></script>
<title>出现问题</title>
<style>
/*==============通用错误页面==============*/
.error-warp{padding-left:10px; padding-right:10px; background:#f6f7fb; text-align:center;height:100vh; font-size:16px;}
.error-warp p:first-child{width:100%; height:240px;display:block; background:url(/images/bg_img.png) no-repeat center center; background-size:240px;}
.error-warp p:nth-child(2){ color:#b7b6b7; line-height:32px;}
.error-warp p:nth-child(3){width:95%; margin-left:auto; margin-right:auto; margin-top:10px; margin-bottom:24px;}
.error-warp p:nth-child(3) a{ display:block; background:#3383fc; line-height:43px;color:#fff; border-radius:3px; font-size:18px;}
.error-warp p:nth-child(4){margin-left:10px;}
.error-warp p:nth-child(4) a{ line-height:30px; color:#666;}
/*点击效果*/
.error-warp p:nth-child(3) a:hover{background:#65a2ff;}
.error-warp p:nth-child(3) a:active{background:#65a2ff;}
.error-warp p:nth-child(4) a:hover{color:#4480da;}
.error-warp p:nth-child(4) a:active{color:#4480da;}
</style>
</head>

<body>
<div class="error-warp">
	<p></p>
    <span id="error"><%= ex.getMessage() %></span>
    <p><a href="javascript:history.go(-1);">返回上一页>></a></p>
</div>
</body>
</html>
