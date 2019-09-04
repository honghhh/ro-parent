<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<body class="layui-layout-body">

<div id="LAY_app">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header">
            <!-- 头部区域 -->
            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item layadmin-flexible" lay-unselect>
                    <a href="javascript:;" layadmin-event="flexible" title="侧边伸缩">
                        <i class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
                    </a>
                </li>
                <li class="layui-nav-item" lay-unselect>
                    <a href="javascript:;" layadmin-event="refresh" title="刷新">
                        <i class="layui-icon layui-icon-refresh-3"></i>
                    </a>
                </li>
            </ul>
            <ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">
                <%--<li class="layui-nav-item layui-hide-xs" lay-unselect id="clear">
                    <a href="javascript:;" data-type="clear" class="clear">
                        <i class="layui-icon layui-icon-fonts-clear"></i>
                    </a>
                </li>--%>
                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="theme">
                        <i class="layui-icon layui-icon-theme"></i>
                    </a>
                </li>
                <li class="layui-nav-item" lay-unselect>
                    <a href="javascript:;">
                        <cite>${loginDto.login}</cite>
                    </a>
                    <dl class="layui-nav-child" id="right-layer">
                        <dd style="text-align: center;"><a lay-href="javaScript:;" data-type="password1" class="updatePassword">修改密码</a></dd>
                        <hr>
                        <dd style="text-align: center;"><a href="/logout">退出</a></dd>
                    </dl>
                </li>

                <li class="layui-nav-item layui-hide-xs" lay-unselect>
                    <a href="javascript:;" layadmin-event="fullscreen">
                        <i class="layui-icon layui-icon-screen-full"></i>
                    </a>
                </li>
            </ul>
        </div>

        <!-- 侧边菜单 -->
        <div class="layui-side layui-side-menu">
            <div class="layui-side-scroll">
                <div class="layui-logo" lay-href="home/console.html">
                    <span>${loginDto.nickname}</span>
                </div>
                <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu" lay-filter="layadmin-system-side-menu">
                    <li data-name="home" class="layui-nav-item layui-nav-itemed">
                        <a href="javascript:;" lay-tips="主页" class="layui-this">
                            <i class="layui-icon layui-icon-home"></i>
                            <cite>主页</cite>
                        </a>
                    </li>
                    <c:forEach items="${menus}" var="l">
                        <li data-name="component" class="layui-nav-item">
                            <c:if test="${l.parentid==0}">
                                <a href="javascript:;" lay-tips="${l.menuname}" lay-direction="2">
                                    <i class="layui-icon ${l.icon}"></i>
                                    <cite>${l.menuname}</cite>
                                </a>
                            </c:if>
                            <dl class="layui-nav-child">
                                <c:forEach items="${menus}" var="ll">
                                    <c:if test="${ll.parentid==l.id && ll.type==1}">
                                        <dd data-name="button">
                                            <a lay-href="${ll.url}"><i class="layui-icon ${ll.icon}"></i>${ll.menuname}</a>
                                        </dd>
                                    </c:if>
                                </c:forEach>
                            </dl>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <!-- 页面标签 -->
        <div class="layadmin-pagetabs" id="LAY_app_tabs">
            <div class="layui-icon layadmin-tabs-control layui-icon-prev" layadmin-event="leftPage"></div>
            <div class="layui-icon layadmin-tabs-control layui-icon-next" layadmin-event="rightPage"></div>
            <div class="layui-icon layadmin-tabs-control layui-icon-down">
                <ul class="layui-nav layadmin-tabs-select" lay-filter="layadmin-pagetabs-nav">
                    <li class="layui-nav-item" lay-unselect>
                        <a href="javascript:;"></a>
                        <dl class="layui-nav-child layui-anim-fadein">
                            <dd layadmin-event="closeThisTabs"><a href="javascript:;">关闭当前标签页</a></dd>
                            <dd layadmin-event="closeOtherTabs"><a href="javascript:;">关闭其它标签页</a></dd>
                            <dd layadmin-event="closeAllTabs"><a href="javascript:;">关闭全部标签页</a></dd>
                        </dl>
                    </li>
                </ul>
            </div>
            <div class="layui-tab" lay-unauto lay-allowClose="true" lay-filter="layadmin-layout-tabs">
                <ul class="layui-tab-title" id="LAY_app_tabsheader">
                    <li lay-id="home/console.html" lay-attr="home/console.html" class="layui-this"><i class="layui-icon layui-icon-home"></i></li>
                </ul>
            </div>
        </div>

        <!-- 主体内容 -->
        <div class="layui-body" id="LAY_app_body">
            <div class="layadmin-tabsbody-item layui-show">
                <iframe src="/plat/welcome" frameborder="0" class="layadmin-iframe"></iframe>
            </div>
        </div>

        <!-- 辅助元素，一般用于移动设备下遮罩 -->
        <div class="layadmin-body-shade" layadmin-event="shade"></div>
    </div>
</div>

<script src="/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: '/layuiadmin/' // 静态资源所在路径
    }).extend({
        index: 'lib/index' // 主入口模块
    }).use(['index'],function () {
        var $ = layui.$,// 引入jquery
            admin = layui.admin,
            element = layui.element,//element模块的实例 返回的element变量为该实例的对象，携带一些用于元素操作的基础方法 比如监听事件
            layer = layui.layer;// 弹层组件

        element.render();// 更新渲染

        var active = {
            password1: function () {
                layer.open({
                    title:'修改密码',
                    type: 2,// layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
                    shadeClose: true,
                    area: ['520px', '350px'],
                    content: '/user/showUpdatePassword'
                });
            }/*,
            clear:function(){
                layer.confirm('清除缓存？', function(){
                    $.ajax({
                        url: "/clear",
                        data: {},
                        dataType: "json",
                        type: "post",
                        success: function (data) {
                            if(data.status){
                                layer.msg('操作成功',{icon:1});
                            }
                        }
                    });
                });
            },
            tip1:function(){
                layer.tips('对分类及协议变更后请清除缓存', this, {
                    tips: 1
                });
            }*/
        };

        $('#right-layer .updatePassword').on('click', function(){
            var type = $(this).data('type');// data-type="password1" 获取到password1的参数
            active[type] && active[type].call(this);// 执行参数为password1的方法
        });
        $("#clear .clear").on('click',function () {
            var type = $(this).data('type');
            active[type] && active[type].call(this);
        });
        $(".clear").on('mouseover',function () {
            active['tip1'] && active['tip1'].call(this);
        })
    });
</script>
</body>
</html>



