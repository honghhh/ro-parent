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
            <input placeholder='用户名' type='text' id="userName">
            <div class='validation'>
                <img src='img/tick.png'>
            </div>
            </input>
        </div>
        <div class='login_fields__password'>
            <div class='icon'>
                <img src='/static/login/img/lock_icon_copy.png'>
            </div>
            <input placeholder='密码' type='password' id="passWord">
            <div class='validation'>
                <img src='/static/login/img/tick.png'>
            </div>
        </div>
        <div class='login_fields__submit d1' id="login_buttom">
            <input type='button' id="login_button_submit" value='登录' class="box shake">
            <div class='forgot'>
                <a href='javascript:void(0)' onclick="siginA()">注册</a>&nbsp;&nbsp;
                <a href='#'>忘记密码?</a>
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
            <input placeholder='用户名' type='text' id="userName_sgin">
            <div class='validation'>
                <img src='/static/login/img/tick.png'>
            </div>
            </input>
        </div>
        <div class='login_fields__password'>
            <div class='icon'>
                <img src='/static/login/img/lock_icon_copy.png'>
            </div>
            <input placeholder='密码' type='password' id="passWord_sgin">
            <div class='validation'>
                <img src='/static/login/img/tick.png'>
            </div>
        </div>
        <div class='login_fields__password'>
            <div class='icon'>
                <img src='/static/login/img/key.png'>
            </div>
            <input placeholder='验证码' type='text' id="code">
            <img class="validation2" onclick="javascript:document.getElementById('codeimage').src='/verifyImg?t=' + Math.random();"
                 src="/verifyImg" name="codeimage" id="codeimage"/>
            <!-- <div class='validation'>
                <img src='/static/login/img/tick.png'>
            </div> -->
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
<%--<script src="/static/login/js/login.js"></script>--%>
<script>
    $('#login_button_submit').click(function() {
        var userName = $("#userName").val().trim();
        var passWord = $("#passWord").val().trim();
        if(userName == "") {
            setContent("账号不能为空")
            return;
        } else if(passWord == "") {
            $("#span").html("密码不能为空")
            setContent("密码不能为空")
            return;
        }
        $('.login').addClass('test');
        setTimeout(function() {
            $('.login').addClass('testtwo');
        }, 300);
        setTimeout(function() {
            $('.authent').show().animate({
                right: -320
            }, {
                easing: 'easeOutQuint',
                duration: 600,
                queue: false
            });
            $('.authent').animate({
                opacity: 1
            }, {
                duration: 200,
                queue: false
            }).addClass('visible');
        }, 500);

        $.ajax({
            url: "/login",
            type: "post",
            dataType: 'json',
            data: {
                userName: userName,
                passWord: passWord
            },
            success: function(res) {
                //登录中
                setTimeout(function() {
                    $('.authent').show().animate({
                        right: 90
                    }, {
                        easing: 'easeOutQuint',
                        duration: 600,
                        queue: false
                    });
                    $('.authent').animate({
                        opacity: 0
                    }, {
                        duration: 200,
                        queue: false
                    }).addClass('visible');
                    $('.login').removeClass('testtwo');
                }, 2500);
                console.log(res)
                if(res.state == "200") {
                    	window.location = "/plat/index";
                    //				登录成功
                    setTimeout(function() {
                        $('.login').removeClass('test');
                        $('.login div').fadeOut(123);
                    }, 2800);
                    setTimeout(function() {
                        $('.success').fadeIn();
                        setTimeout(function() {
                            window.location = "/plat/index";
                            //									$('.success').fadeOut(123);

                        }, 2000);
                        setTimeout(function() {
                            $('.login div').fadeIn(123);
                        }, 2200);
                    }, 3200);
                } else {
                    setTimeout(function() {
                        $('.login').removeClass('test');
                        // $('.authent').removeClass('authent');
                        $('.authent').removeAttr("style");
                        $('.visible').removeClass('visible');
                    }, 2800);
                    $("#span").html(res.desc)
                }
            }
        })
    });
    $('input[type="text"],input[type="password"]').focus(function() {
        $(this).prev().animate({
            'opacity': '1'
        }, 200);
    });
    $('input[type="text"],input[type="password"]').blur(function() {
        $(this).prev().animate({
            'opacity': '.5'
        }, 200);
    });
    $('input[type="text"],input[type="password"]').keyup(function() {
        if(!$(this).val() == '') {
            $(this).next().animate({
                'opacity': '1',
                'right': '30'
            }, 200);
        } else {
            $(this).next().animate({
                'opacity': '0',
                'right': '20'
            }, 200);
        }
    });
    var open = 0;
    $('.tab').click(function() {
        $(this).fadeOut(200, function() {
            $(this).parent().animate({
                'left': '0'
            });
        });
    });

    function siginA() {
        $("#login").hide()
        $("#sigin").show()
    }

    function callBack() {
        $("#sigin").hide()
        $("#login").show()
    }

    function sigin() {
        var userName = $("#userName_sgin").val().trim();
        var passWord = $("#passWord_sgin").val().trim();
        var code = $("#code").val().trim();
        if(userName == "") {
            setContent("账号不能为空")
            return;
        } else if(passWord == "") {
            setContent("密码不能为空")
            return;
        } else if(code == ""){
            $("#span_sigin").html("验证码不能为空")
            return;
        }

        $.ajax({
            url: "/register",
            type: "post",
            dataType: 'json',
            data: {
                userName: userName,
                passWord: passWord,
                code: code
            },
            success: function(res) {
                console.log(res)
                if(res.state == "200") {
                    $("#span_sigin").html("注册成功")
                    window.location = "/login";
                } else {
                    $("#span_sigin").html(res.msg)
                }
            }
        })
    }

    //设置内容
    function setContent(content){
        $("#span_sigin").html(content)
        $('input[type="button"]').addClass("addStyle")
        $("body .login_fields__submit input").css("border", "2px solid red")
        $("body .login_fields__submit input").css("background", "red")
        setTimeout(function() {
            $('input[type="button"]').removeClass("addStyle")
            $("body .login_fields__submit input").css("border", "2px solid #67baff")
            $("body .login_fields__submit input").css("background", "none")
        }, 1500);
    }
</script>
</body>
</html>
