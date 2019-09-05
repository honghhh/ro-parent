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
        thead tr th{text-align: center!important;font-weight: bold!important;}
        tr td{text-align: center!important;}
    </style>
</head>
<body>
    <div class="layui-fluid">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md12">
                <div class="layui-card">
                    <form action="/log/showLogList" id="seachFrom" class="layui-form">
                        <div class="layui-card-body">
                            <%-- 查询条件设置 --%>
                            <div class="layui-container" style="padding-bottom: 50px">
                                <div class="layui-col-md12">
                                    <div class="layui-col-md3">
                                        <div class="layui-col-sm3" style="line-height: 38px">时间范围：</div>
                                        <div class="layui-col-sm8">
                                            <input class="layui-input" name="queryTime" id="laydate-cn" autocomplete="off" value="${log.queryTime}">
                                        </div>
                                    </div>
                                    <div class="layui-col-sm3">
                                        <button class="layui-btn layui-btn" type="submit">查询</button>
                                    </div>
                                    <div class="layui-col-md12"><hr></div>
                                </div>
                            </div>
                            <table class="layui-table">
                                <thead>
                                <tr>
                                    <th width="5%">ID</th>
                                    <th width="10%">管理员</th>
                                    <th width="10%">ip</th>
                                    <th width="10%">请求链接</th>
                                    <th width="10%">执行模块</th>
                                    <th width="10%">执行方法</th>
                                    <th width="10%">时长</th>
                                    <th width="10%">描述</th>
                                    <th width="10%">操作时间</th>
                                    <th width="10%">操作状态</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${pageInfo.list}" var="l">
                                    <tr>
                                        <td>${l.id}</td>
                                        <td>${l.loginaccount}</td>
                                        <td>${l.loginip}</td>
                                        <td>${l.actionurl}</td>
                                        <td>${l.module}</td>
                                        <td>${l.method}</td>
                                        <td>${l.actiontime}</td>
                                        <td>${l.description}</td>
                                        <td><fmt:formatDate value="${l.gmtcreate}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate></td>
                                        <td>${l.state==1?'成功':'失败'}</td>
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
                layer = layui.layer,
                laydate = layui.laydate;
            element.render();

            var today = new Date();
            var last = today.getFullYear() + "-" + today.getMonth() + "-" +today.getDate();
            today = today.getFullYear() + "-" + (today.getMonth()+1) + "-" +today.getDate();
            laydate.render({
                elem: '#laydate-cn',
                range:'~',
                max:today
            });
        });
    </script>
</body>
</html>
