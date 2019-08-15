<%@page import="com.gas.service.Configue"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="/lib/html5shiv.js"></script>
<script type="text/javascript" src="/lib/respond.min.js"></script>
<![endif]-->
<link href="/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="/static/h-ui.admin/css/H-ui.login.css?v=1" rel="stylesheet" type="text/css" />
<link href="/static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title><%=Configue.sysInfos.getTitle() %>-后台登录</title>
<meta name="keywords" content="">
<meta name="description" content="">
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class=""></div>
<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form class="form form-horizontal" id="enterForm" method="post">
    
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-xs-8">
          <input id="login" name="login" type="text" placeholder="请输入账号" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-xs-8">
          <input id="" name="password" type="password" placeholder="密码" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <!-- <input name="validCode" class="input-text size-L" type="text" placeholder="验证码" style="width:150px;">
          <img onclick="javascript:document.getElementById('codeimage').src='/verifyImg?t=' + Math.random();"
			src="/verifyImg" name="codeimage" id="codeimage" width="100"> -->
			<input name="" type="button" onclick="enter()" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
		</div>
      </div>
      <div class="pd-10">&nbsp;</div>
    </form>
  </div>
</div>
<div class="footer">Copyright <%=Configue.sysInfos.getTitle() %></div>
<script type="text/javascript" src="/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript">

$(function() {
	document.onkeydown = function(e) {
		var ev = document.all ? window.event : e;
		if (ev.keyCode == 13) {
			enter();
		}
	}
	if (window.top !== window.self) {
		window.top.location = window.location;
	}
});
function enter() {
	$.ajax({
		url : "/enter",
		dataType : "json",
		data : $('#enterForm').serialize(),
		type : "post",
		success : function(data) {
			if (data.status) {
				location.href = "/plat/index";
			} else {
				$.Huimodalalert(data.desc, 1000);
				$('#codeimage').click();
			}
		}
	});
}
</script>
</body>
</html>