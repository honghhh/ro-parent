<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户登录</title>
    <link href="http://cdn.bootcss.com/jqueryui/1.11.0/jquery-ui.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/static/login/css/default.css">
    <link rel="stylesheet" type="text/css" href="/static/login/css/styles.css">
    <link rel="stylesheet" type="text/css" href="/static/login/css/login.css"/>
</head>
<body>
<div class='login' id="login">
    <div class='login_title'>
        <span id="span">用户登录</span>
    </div>
    <div class='login_fields'>
        <div class='login_fields__user'>
            <div class='icon'>
                <img src='/static/login/img/user_icon_copy.png'>
            </div>
            <input placeholder='用户名' type='text' id="userName" class="action">
            <div class='validation'>
                <img src='/static/login/img/tick.png'>
            </div>
            </input>
        </div>
        <div class='login_fields__password'>
            <div class='icon'>
                <img src='/static/login/img/lock_icon_copy.png'>
            </div>
            <input placeholder='密码' type='password' id="passWord" class="action">
            <div class='validation'>
                <img src='/static/login/img/tick.png'>
            </div>
        </div>
        <div class='login_fields__submit d1' id="login_buttom">
            <input type='button' id="login_button_submit" value='登录' class="box shake">
            <%--<div class='forgot'>
                <a href='javascript:void(0)' onclick="siginA()">注册</a>&nbsp;&nbsp;
                <a href='#'>忘记密码?</a>
            </div>--%>
        </div>
    </div>
    <div class='success'>
        <h2>登录成功</h2>
        <p>欢迎回来</p>
    </div>
    <div class='disclaimer'>
        <p>这个世界上只有10种人：懂得二进制的和不懂得二进制的。</p>
    </div>
</div>
<!--注册-->
<div class='login' id="sigin" style="display: none;">
    <div class='login_title'>
        <span id="span_sigin">用户注册</span>
    </div>
    <div class='login_fields'>
        <div class='login_fields__user'>
            <div class='icon'>
                <img src='/static/login/img/user_icon_copy.png'>
            </div>
            <input placeholder='用户名' type='text' id="userName_sgin" class="action">
            <div class='validation'>
                <img src='/static/login/img/tick.png'>
            </div>
            </input>
        </div>
        <div class='login_fields__password'>
            <div class='icon'>
                <img src='/static/login/img/lock_icon_copy.png'>
            </div>
            <input placeholder='密码' type='password' id="passWord_sgin" class="action">
            <div class='validation'>
                <img src='/static/login/img/tick.png'>
            </div>
        </div>
        <div class='login_fields__password'>
            <div class='icon'>
                <img src='/static/login/img/lock_icon_copy.png'>
            </div>
            <input placeholder='验证码' type='text' id="code">
            <img class="validation2" onclick="javascript:document.getElementById('codeimage').src='/verifyImg?t=' + Math.random();"
                 src="/verifyImg" name="codeimage" id="codeimage"/>
        </div>
        <div class='login_fields__submit d1' id="login_buttom">
            <input type='button' value='注册' onclick="sigin()" id="sigin_button_submit" class="box shake">
            <div class='forgot'>
                <a href='javascript:void(0)' onclick="callBack()">返回登陆</a>
            </div>
        </div>
    </div>
    <div class='success'>
        <h2>登录成功</h2>
        <p>欢迎回来</p>
    </div>
    <div class='disclaimer'>
        <p>这个世界上只有10种人：懂得二进制的和不懂得二进制的。</p>
    </div>
</div>
<div class='authent'>
    <img src='/static/login/img/puff.svg'>
    <p>登录中...</p>
</div>
<script src='/static/login/js/stopExecutionOnTimeout.js?t=1'></script>
<script src="/static/login/js/jquery-2.1.1.min.js"></script>
<script src="http://cdn.bootcss.com/jqueryui/1.11.0/jquery-ui.min.js"></script>
<script src="/js/login.js"></script>
</body>
</html>
