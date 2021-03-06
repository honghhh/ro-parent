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
    <style>
        thead tr th{text-align: center!important;}
        tr td{text-align: center!important;}
    </style>
</head>
<body>
    <div class="layui-fluid">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md12">
                <div class="layui-card">
                    <div class="layui-card-body">
                        <div class="test-table-reload-btn" style="margin-left: -10px;margin-bottom: 10px;">
                            <button class="layui-btn addThis" type="button" style="margin-left: 10px" data-id="">新增角色</button>
                        </div>
                        <table class="layui-table">
                            <thead>
                            <tr>
                                <th width="10%">ID</th>
                                <th width="15%">角色名称</th>
                                <th width="10%">状态</th>
                                <th width="20%">创建时间</th>
                                <th width="40%">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${list}" var="l">
                                <tr>
                                    <td>${l.id}</td>
                                    <td>${l.name}</td>
                                    <td>${l.status==1?'正常':'禁用'}</td>
                                    <td><fmt:formatDate value="${l.createtime}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate></td>
                                    <td class="td-manage">
                                        <button data-id="${l.id}" data-type="editThis" class="layui-btn layui-btn-sm layui-btn-primary editThis">编辑</button>
                                        <c:if test="${l.status==1}">
                                            <button data-id="${l.id}" data-status="0" data-type="updateThis" class="layui-btn layui-btn-sm layui-btn-warm updateThis">禁用</button>
                                        </c:if>
                                        <c:if test="${l.status==0}">
                                            <button data-id="${l.id}" data-status="1" data-type="updateThis" class="layui-btn layui-btn-sm layui-btn-normal updateThis">启用</button>
                                        </c:if>
                                        <button data-id="${l.id}" data-type="delThis" class="layui-btn layui-btn-sm layui-btn-danger delThis">删除</button>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
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
        }).use(['index', 'laydate'], function () {
            var $ = layui.$,
                admin = layui.admin,
                element = layui.element,
                layer = layui.layer;
            element.render();

            var active = {
                editThis: function (id) {
                    layer.open({
                        title:'新增/编辑角色',
                        type: 2,
                        area: ['850px', '500px'],
                        content: '/role/showRoleEdit?id='+id
                    });
                },
                delThis:function (id,url) {
                    layer.confirm('确定删除吗？', function(){
                        delThis(id,url);
                    });
                },
                updateThis:function (id,status,url) {
                    layer.confirm('确定操作吗？', function(){
                        updateThis(id,status,url);
                    });
                }
            };
            var type = 'editThis';
            $('.editThis').on('click', function(){
                var id = $(this).data('id');
                active[type] && active[type].call(this,id);
            });
            $('.addThis').on('click', function(){
                var id = $(this).data('id');
                active[type] && active[type].call(this,id);
            });
            $('.delThis').on('click',function () {
                var delType = $(this).data('type');
                var id = $(this).data('id');
                var url = "/role/deleteRole";
                active[delType] && active[delType].call(this,id,url);
            });
            $('.updateThis').on('click',function () {
                var updateType = $(this).data('type');
                var id = $(this).data('id');
                var status = $(this).data('status');
                var url = "/role/updateRoleStatus";
                active[updateType] && active[updateType].call(this,id,status,url);
            })
        });
    </script>
</body>
</html>
