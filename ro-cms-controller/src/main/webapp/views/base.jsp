<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
$.ajaxSetup({
	contentType:"application/x-www-form-urlencoded;charset=utf-8",
	complete: function (xhr, status) { 
		var sessionstatus=xhr.getResponseHeader("sessionstatus"); //通过XMLHttpRequest取得响应头，sessionstatus， 
		if(sessionstatus=="timeout"){ 
		   //如果超时就处理 ，指定要跳转的页面  
		   parent.location.reload();
		}  
	}
});
</script>