$(function () {
    $("#codeimage").animate({
        'opacity': '1',
        'right': '30'
    }, 200);
});
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
            if(res.status) {
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
                        // sessionStorage.setItem("token", res.data);
                        // sessionStorage.getItem("token", res.data);
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
$('.action').keyup(function() {
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
            if(res.status) {
                $("#span_sigin").html("注册成功")
                window.location = "/loginPage";
            } else {
                $("#span_sigin").html(res.desc)
                $('#codeimage').click();
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