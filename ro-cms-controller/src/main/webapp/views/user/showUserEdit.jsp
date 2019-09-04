<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
    <meta charset="utf-8">
    <title>平台管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/layuiadmin/style/admin.css" media="all">
    <style type="text/css">
        .red,.red a{
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="layui-container">
        <div class="layui-card">
            <div class="layui-card-body" style="padding: 15px;">
                <form class="layui-form" id="userAddForm" enctype="multipart/form-data">
                    <input type="hidden" name="id" value="${userObj.id}">
                    <div class="layui-form-item">
                        <label class="layui-form-label"><span class="red">*&nbsp;</span>登录名</label>
                        <div class="layui-input-block">
                            <input type="text" name="login" autocomplete="off" class="layui-input"
                                   placeholder="请输入登录名，不可重复" value="${userObj.login}" ${userObj.login!=null?'readonly':''}>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label"><span class="red">*&nbsp;</span>管理员昵称</label>
                        <div class="layui-input-block">
                            <input type="text" name="nickname" autocomplete="off" class="layui-input" value="${userObj.nickname}" placeholder="请输入管理员昵称">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">管理员头像</label>
                        <div class="layui-input-block">
                            <label for="imgUrl" class="layui-btn layui-btn-sm layui-btn-primary">上传图片</label>
                            <input accept=".jpg,.png,.gif,.jpeg" type="file" style="display:none;" name="imgUrl" id="imgUrl"
                                   onchange="showImg(this)"/>
                            <img id="imgf" src="${userObj.headurl==null?' ':userObj.headurl}" style="width: 100px;height: 100px;" />
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label"><span class="red">*&nbsp;</span>所属角色</label>
                        <div class="layui-input-block">
                            <select name="roleid">
                                <option value="">请选择</option>
                                <c:forEach items="${roles}" var="r">
                                    <option <c:if test="${r.id==userObj.roleid}">selected</c:if> value="${r.id}">${r.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </form>
                <div class="layui-form-item layui-layout-admin">
                    <div class="layui-input-block">
                        <div class="layui-footer" style="left: 0;">
                            <button class="layui-btn" onclick="FormSubmit('#userAddForm','/user/editUser')">保存</button>
                        </div>
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
    <script>
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
    </script>
</body>
</html>
