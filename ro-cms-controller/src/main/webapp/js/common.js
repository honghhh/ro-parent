// 通过id删除对象
function deleteById(id,url){
    layer.confirm('确认要删除吗？',function(index) {
        $.ajax({
            url: url,
            data: {'id': id},
            dataType: "json",
            type: "post",
            success: function (status) {
                if (status) {
                    layer.close(index);
                    layer.msg('删除成功', {icon: 1});
                    setTimeout(function () {
                        window.location.reload();
                    }, 1000)
                } else {
                    layer.close(index);
                    layer.msg('删除失败', {icon: 2})
                }
            }
        })
    })
}

function updateThis(id,status,url){
    $.ajax({
        url: url,
        data: {'id': id, "status": status},
        dataType: "json",
        type: "post",
        success: function (data) {
            if (data.status) {
                layer.msg(data.desc, {icon: 1});
                setTimeout(function () {
                    window.location.reload();
                }, 1000)
            } else {
                layer.msg(data.desc, {icon: 2});
            }
        }
    })
}

function delThis(id,url){
    $.ajax({
        url: url,
        data: {'id': id},
        dataType: "json",
        type: "post",
        success: function (status) {
            if (status) {
                layer.msg('删除成功', {icon: 1});
                setTimeout(function () {
                    window.location.reload();
                }, 1000)
            } else {
                layer.msg('删除失败', {icon: 2})
            }
        }
    })
}

// 表单ajax提交,刷新父页面
function FormSubmit(formId,url){
    $(".layui-btn").attr("disabled",true);
    $(formId).ajaxSubmit({
        type: 'post',
        url: url,
        data: $(formId).serialize(),
        dataType: 'json',
        success: function (data) {
            if (data.status) {
                layer.msg(data.desc, {icon: 1});
                setTimeout(function () {
                    window.parent.location.reload();
                }, 1000)
            } else {
                layer.msg(data.desc, {icon: 2});
                $(".layui-btn").attr("disabled",false);
            }
        },
        error: function () {
            layer.msg("请检查页面信息是否正确", {icon: 2});
        }
    });
}
// 表单ajax提交,刷新当前页面
function FormSubmitCurrent(formId,url){
    $(formId).ajaxSubmit({
        type: 'post',
        url: url,
        data: $(formId).serialize(),
        dataType: 'json',
        success: function (data) {
            if (data.status) {
                layer.msg(data.desc, {icon: 1});
                setTimeout(function () {
                    window.location.reload();
                }, 1000)
            } else {
                layer.msg(data.desc, {icon: 2});
            }
        },
        error: function () {
            layer.msg("请检查页面信息是否正确", {icon: 2});
        }
    });
}

function createTime(v){
	var date = new Date(v);
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    m = m<10?'0'+m:m;
    var d = date.getDate();
    d = d<10?("0"+d):d;
    var h = date.getHours();
    h = h<10?("0"+h):h;
    var M = date.getMinutes();
    M = M<10?("0"+M):M;
    var str = y+"-"+m+"-"+d+" "+h+":"+M;
    return str;
}