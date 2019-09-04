<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <title>平台管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/layuiadmin/style/admin.css" media="all">
</head>
<body>
    <div class="layui-container">
        <div class="layui-card-body" style="padding: 15px;">
            <form class="layui-form" id="updateForm">
                <input type="hidden" name="userId" value="${userId}">
                <div class="layui-form-item">
                    <label class="layui-form-label">原密码</label>
                    <div class="layui-input-block">
                        <input type="password" autocomplete="off" class="layui-input password" placeholder="请输入原密码" name="oldPwd" id="oldPwd">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">新密码</label>
                    <div class="layui-input-block">
                        <input type="password" autocomplete="off" class="layui-input password" placeholder="请输入新密码" name="newPwdOne" id="newPwdOne">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">新密码</label>
                    <div class="layui-input-block">
                        <input type="password" autocomplete="off" class="layui-input password" placeholder="请再次输入新密码" name="newPwdTwo" id="newPwdTwo">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block" style="margin-left: 240px" onmouseover="showPassword()" onmouseout="hidePassword()">
                        <i class="layui-icon layui-icon-password" style="font-size: 20px;font-weight: bold"></i>
                    </div>
                </div>
            </form>
            <div class="layui-form-item layui-layout-admin">
                <div class="layui-input-block">
                    <div class="layui-footer" style="left: 0;">
                        <button class="layui-btn" onclick="savePassword()">保存</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="/layuiadmin/layui/layui.js"></script>
    <script type="text/javascript" src="/js/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery.form.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>
    <script type="text/javascript" src="/js/plugins/image/previewImg.js"></script>
    <script type="text/javascript">
        layui.config({
            // 静态资源所在路径
            base: '/layuiadmin/'
        }).extend({
            // 主入口模块
            index: 'lib/index'
        }).use(['index', 'form'], function(){
            var $ = layui.$,
                layer = layui.layer,
                element = layui.element;
        });

        function savePassword(){
            if($("#oldPwd").val()==="" || $("#newPwdOne").val()==="" || $("#newPwdTwo").val()===""){
                layer.msg("请输入原密码与新密码");
                return false;
            }
            $.ajax({
                url: "/user/updatePassword",
                data: $('#updateForm').serialize(),
                dataType: "json",
                type: "post",
                traditional: true,
                success: function (data) {
                    if (data.status) {
                        layer.msg(data.desc);
                        window.setTimeout(function () {
                            parent.location.reload();
                        }, 1000);
                    }
                }
            });
        }

        // 显示密码
        function showPassword(){
            $(".password").attr('type','text');
            $(".password").attr('readonly','readonly');
        }

        // 隐藏密码
        function hidePassword(){
            $(".password").attr('type','password');
            $(".password").removeAttr('readonly','readonly');
        }
    </script>
</body>
</html>
