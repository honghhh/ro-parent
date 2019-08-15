<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/css/plugins/toastr/toastr.min.css" type="text/css" rel="stylesheet">
<script src="/js/plugins/toastr/toastr.min.js" type="text/javascript"></script>
<script type="text/javascript">
	toastr.options = {
		closeButton : false,//是否显示关闭按钮
		progressBar : true,//是否显示进度条
		positionClass : 'toast-top-center',
		onclick : null, //点击消息框自定义事件 
		showDuration : "300", //显示动作时间 
		hideDuration : "1000", //隐藏动作时间 
		timeOut : "2000", //自动关闭超时时间 
		extendedTimeOut : "1000",
		showEasing : "swing",
		hideEasing : "linear",
		showMethod : "fadeIn", // 显示的方式，和jquery相同 
		hideMethod : "fadeOut" //隐藏的方式，和jquery相同 	
	}
	function sAlert(msg) {
		toastr.success(msg, '提示');
	}
	function eAlert(msg) {
		toastr.error(msg, '错误')
	}
	function iAlert(msg) {
		toastr.info(msg, '提示')
	}
/* 	//询问框
	layer.confirm('上架/下架分类,相关产品将会同步上架/下架状态？', {
	  	btn: ['确认','取消'] //按钮
	}, function(){
	  layer.msg('的确很重要', {icon: 1});
	}, function(){
	  layer.msg('也可以这样', {
	    time: 20000, //20s后自动关闭
	    btn: ['明白了', '知道了']
	  });
	}); */
</script>