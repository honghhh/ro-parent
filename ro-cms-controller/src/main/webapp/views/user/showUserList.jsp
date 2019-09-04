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
        thead tr th{text-align: center!important;font-weight: bold!important;}
        tr td{text-align: center!important;}
    </style>
</head>
<body>
    <div class="layui-fluid">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md12">
                <div class="layui-card">
                    <form action="/user/showUserList" id="seachFrom" class="layui-form">
                        <div class="layui-card-body">
                            <div class="test-table-reload-btn" style="margin-left: -10px;margin-bottom: 10px;">
                                <button class="layui-btn addThis" type="button" style="margin-left: 10px" data-id="0">新增管理员</button>
                            </div>
                            <table class="layui-table">
                                <thead>
                                <tr>
                                    <th width="5%">ID</th>
                                    <th width="15%">登录名</th>
                                    <th width="15%">用户名称</th>
                                    <th width="10%">角色名称</th>
                                    <th width="10%">状态</th>
                                    <th width="15%">创建时间</th>
                                    <th width="100">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${pageInfo.list}" var="l">
                                    <tr>
                                        <td>${l.id}</td>
                                        <td>${l.login}</td>
                                        <td>${l.nickname}</td>
                                        <td>${l.roleid}</td>
                                        <td>${l.status==1?'正常':'禁用'}</td>
                                        <td><fmt:formatDate value="${l.createtime}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate></td>
                                        <td>
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
                            <div class="test-table-reload-btn" style="margin-top: 10px;">
                                <%@include file="../paging.jsp" %>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script src="/layuiadmin/layui/layui.js"></script>
    <script type="text/javascript" src="/js/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>
    <script>
        layui.config({
            base: '/layuiadmin/' //静态资源所在路径
        }).extend({
            index: 'lib/index' //主入口模块
        }).use(['index', 'laydate'], function(){
            var $ = layui.$,
                admin = layui.admin,
                element = layui.element,
                layer = layui.layer;
            element.render();

            var active = {
                editThis: function (id) {
                    layer.open({
                        title:'新增/编辑管理员',
                        type: 2,
                        area: ['550px', '520px'],
                        content: '/user/editUser?id='+id
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
                active[type] && active[type].call(this,$(this).data('id'));
            });
            $('.addThis').on('click', function(){
                active[type] && active[type].call(this,$(this).data('id'));
            });
            $('.delThis').on('click',function () {
                var delType = $(this).data('type');
                var id = $(this).data('id');
                var url = "/user/deleteUser";
                active[delType] && active[delType].call(this,id,url);
            });
            $('.updateThis').on('click',function () {
                var updateType = $(this).data('type');
                var id = $(this).data('id');
                var status = $(this).data('status');
                var url = "/user/updateUserStatus";
                active[updateType] && active[updateType].call(this,id,status,url);
            })
        });
    </script>
</body>
</html>
