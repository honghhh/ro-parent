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
    <style>
        .show_icon{
            font-size: 20px;
            color: #499ef8;
            font-weight: bold;
        }
        .layui-input-block .layui-unselect>span{
            height: 18px;
        }
    </style>
</head>
<body>
    <div class="layui-container">
        <div class="layui-card">
            <div class="layui-card-body" style="padding: 15px;">
                <form class="layui-form" id="roleAddForm" lay-filter="role">
                    <input type="hidden" name="id" value="${role.id}">
                    <div class="layui-form-item">
                        <label class="layui-form-label">角色名称<span style="color: red">*</span></label>
                        <div class="layui-input-block">
                            <input type="text" class="layui-input" value="${role.name}" placeholder="角色名称" name="name" style="width: 400px">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">菜单<span style="color: red">*</span></label>
                        <div class="layui-input-block">
                            <div class="layui-col-lg10">
                                <c:forEach items="${list}" var="l">
                                    <c:if test="${l.parentid==0}">
                                        <div class="layui-col-md12">
                                            <c:if test="${l.type==0}">
                                                <div class="layui-col-sm12 main_show">
                                                    <div class="layui-col-sm10">
                                                        <div class="main" data-id="${l.id}">
                                                            <input class="main${l.id}" data-id="${l.id}" type="checkbox" ${l.check} lay-skin="primary"
                                                                   id="checkbox-${l.id}" data-type="1">
                                                            <label for="checkbox-${l.id}" class="layui-btn layui-btn-xs layui-btn-danger">${l.menuname}</label>
                                                        </div>
                                                    </div>
                                                    <div class="layui-col-sm2 expand" id="row${l.id}">
                                                        <i class="layui-icon layui-icon-triangle-d show_icon one"></i>
                                                    </div>
                                                </div>
                                            </c:if>
                                            <c:forEach items="${list}" var="p">
                                                <c:if test="${p.parentid==l.id}">
                                                    <div class="layui-col-xs12 child child-row${l.id}" style="margin-left: -80px">
                                                        <c:if test="${p.type==1}">
                                                            <div class="layui-input-block child child-row${l.id}">
                                                                <input data-parentId="${l.id}" data-id="${p.id}" name="child" lay-skin="primary"
                                                                       class="child${l.id}" type="checkbox" ${p.check}
                                                                       id="checkbox-${p.id}" title="${p.menuname}" data-type="2">
                                                                <c:if test="${p.type==1}">
                                                                    <span class="layui-badge layui-bg-orange">主页面</span>
                                                                </c:if>
                                                                <c:forEach items="${list}" var="t">
                                                                    <c:if test="${t.parentid==p.id}">
                                                                        <div class="layui-col-xs10" style="margin-left: -60px">
                                                                            <div class="layui-input-block child child-row${l.id}">
                                                                                <input data-parentId="${p.id}" data-id="${t.id}" name="child"
                                                                                       class="child${l.id} third${p.id}" type="checkbox" ${t.check}
                                                                                       id="checkbox-${t.id}" lay-skin="primary" title="${t.menuname}">
                                                                                <label for="checkbox-${t.id}">
                                                                                    <c:if test="${t.type==2}">
                                                                                        <span class="layui-badge layui-bg-blue">按钮</span>
                                                                                    </c:if>
                                                                                    <c:if test="${t.type==3}">
                                                                                        <span class="layui-badge-rim">子页面</span>
                                                                                    </c:if>
                                                                                </label>
                                                                            </div>
                                                                        </div>
                                                                    </c:if>
                                                                </c:forEach>
                                                            </div>
                                                        </c:if>
                                                    </div>
                                                </c:if>
                                            </c:forEach>
                                        </div>
                                    </c:if>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" name="menuids" id="menuids">
                </form>
                <div class="layui-form-item layui-layout-admin">
                    <div class="layui-input-block">
                        <div class="layui-footer" style="left: 0;">
                            <button class="layui-btn" onclick="saveRole()">保存</button>
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
    <script type="text/javascript">
        layui.config({
            // 静态资源所在路径
            base: '/layuiadmin/'
        }).extend({
            // 主入口模块
            index: 'lib/index'
        }).use(['index', 'form'], function () {
            var $ = layui.$,
                layer = layui.layer,
                element = layui.element,
                form = layui.form;
            form.on('checkbox',function (data) {
                // 得到checkbox原始DOM对象
                var dom = data.elem;
                // 得到点击的类型,请看input上的data-type
                var type = $(dom).data('type');
                // 获取被点击input的id,input上的data-id
                var id = $(dom).data('id');
                if(type===1){
                    // data.elem.checked判断是否选中，true/false
                    if(data.elem.checked){
                        $('.child'+id).prop('checked',true);
                    }else{
                        $('.child'+id).prop('checked',false);
                    }
                }else if(type===2){
                    if(data.elem.checked){
                        $('.third'+id).prop('checked',true);
                    }else{
                        $('.third'+id).prop('checked',false);
                    }
                }
                // 复选框操作后重新渲染form，否则元素无法正确显示
                form.render('checkbox');
            })
        });

        $(function () {
            // 在每个主菜单加上图标，点击进行展开/收起
            $('div.expand').css({"cursor":"pointer"}).click(function () {
                $(this).parent('.main_show').siblings('.child-'+this.id).toggle();
                if($(this).children('.show_icon').attr('class') === 'layui-icon layui-icon-triangle-r show_icon one'){
                    $(this).empty();
                    $(this).append('<i class="layui-icon layui-icon-triangle-d show_icon two"></i>');
                }else{
                    $(this).empty();
                    $(this).append('<i class="layui-icon layui-icon-triangle-r show_icon one"></i>');
                }
            });
        });

        function saveRole() {
            var checkBoxArr = [];
            $('input[name="child"]:checked').each(function () {
                var id = $(this).attr("data-id");
                var parentId = $(this).attr("data-parentId");
                checkBoxArr.push(id);
                checkBoxArr.push(parentId);
            });
            $("#menuids").val(checkBoxArr);
            $.ajax({
                url: "/role/editRole",
                data: $('#roleAddForm').serialize(),
                dataType: "json",
                type: "post",
                traditional: true,
                success: function (data) {
                    if (data.status) {
                        layer.msg(data.desc,{icon:1});
                        window.setTimeout(function () {
                            window.parent.location.reload();
                        }, 1000);
                    }else{
                        layer.msg(data.desc,{icon:2});
                    }
                }
            });
        }
    </script>
</body>
</html>
