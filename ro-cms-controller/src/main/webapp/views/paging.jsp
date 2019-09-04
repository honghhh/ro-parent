<%@ page contentType="text/html; charset=utf-8"%>
<div class="layui-fluid" >
	<div class="layui-row layui-col-space15">
		<div class="layui-col-sm12 layui-input-inline" style="padding-top: 10px;">
			<!-- 是否是搜索请求, 1是0否(搜索请求需要将页码改为1) -->
			<input type="hidden" id="issearch" value="1" />
			<input type="hidden" id="endnum" name="endnum" value="${pageInfo.pages}" />
			<input type="hidden" id="page" name="page" value="${pageInfo.pageNum}" />
			<input type="button" onclick="funPage(1)" class="layui-btn layui-btn-sm layui-btn-normal" value="首页"/>
			<input type="button" onclick="funPage(2)" class="layui-btn layui-btn-sm layui-btn-normal" value="上一页"/>
			<input type="button" onclick="funPage(3)" class="layui-btn layui-btn-sm layui-btn-normal" value="下一页"/>
			<input type="button" onclick="funPage(4)" class="layui-btn layui-btn-sm layui-btn-normal" value="末页"/>
			<span>当前第<span id="nowpage">${pageInfo.pageNum}</span>页
			[共<span id="total">${pageInfo.total}</span>条,
	   		<span id="totalpages">${pageInfo.pages}</span>页];</span>
			<span style="font-size: 16px">第</span>&nbsp;&nbsp;
			<input type="text" id="topage"  class="layui-input layui-input-inline" style="width:60px;margin-bottom: 5px; text-align: center;height:30px"
				   onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
			<input type="button" onclick="funPage(5)" class="layui-btn layui-btn-sm layui-btn-normal" value="跳转"/>
		</div>
	</div>

</div>
<script type="text/javascript" src="/js/jquery/jquery.min.js"></script>
<script>
	// 表单的onsubmit事件, 在表单提交前触发, 判断是否为搜索请求, 是则改页码为1
	$(function() {
		$("#seachFrom").submit(function() {
			if ($("#issearch").val() != 0) {
				$("#page").val(1);
			}
		});
	});
	// 处理分页
	function funPage(flag) {
		var page = parseInt($("#page").val());
		var endnum = parseInt($("#endnum").val());
		// 如果是首页
		if (flag == 1) {
			page = 1;
		}
		// 如果是上一页
		if (flag == 2) {
			if (page <= 1) {
				layer.msg("已经是第一页");
				return;
			}
			page = page - 1;
		}
		// 如果是下一页
		if (flag == 3) {
			if ((page + 1) > endnum) {
				layer.msg("已经是最后一页");
				return;
			}
			page = page + 1;
		}
		// 如果是末页
		if (flag == 4) {
			page = endnum;
		}
		// 如果是跳转
		if (flag == 5) {
			var pageVal = $("#topage").val();
			if(pageVal.length < 1 || isNaN(pageVal)){
				layer.msg("请输入正确页面",{icon:3});
				return;
			}
			var toPage = parseInt(pageVal);
			if (toPage<1 || toPage>endnum) {
				layer.msg("请输入正确页面",{icon:3});
				return;
			}
			page = topage;
		}
		$("#page").val(page);
		$("#issearch").val(0);
		$("#seachFrom").submit();
		// $("#issearch").val(1);
	}
</script>
