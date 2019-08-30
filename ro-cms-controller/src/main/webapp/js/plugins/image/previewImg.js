//图片在线预览
function showImg(v) {

    for (var i = 0; i < v.files.length; i++) {
        var files = v.files[i];
        var point = files.name.lastIndexOf(".");
        var ext = files.name.substr(point+1).toLowerCase();
        if ("png" != ext && "jpg" != ext && "jpeg" != ext && "gif" != ext) {
            alert("文件类型不相符,只允许上传PNG,JPG,GIF,JPEG文件类型");
            return;
        }
        var objUrl1 = getObjectURL(v.files[i]);
        if (objUrl1) {
            // 在这里修改图片的地址属性
            $(v).next().attr('src', objUrl1)
            $(v).next().removeClass("none");
            $(v).next().attr('style', '');
        }
    }
};

function showVideo (v) {
	for (var i = 0; i < v.files.length; i++) {
        var files = v.files[i];
        var point = files.name.lastIndexOf(".");
        var ext = files.name.substr(point+1).toLowerCase();
        var objUrl1 = getObjectURL(v.files[i]);
        if (objUrl1) {
            // 在这里修改图片的地址属性
            $(v).next().attr('src', objUrl1);
            $(v).next().attr('style', '');
        }
    }
}

//建立一個可存取到該file的url
function getObjectURL(file) {
    var url = null;
    // 下面函数执行的效果是一样的，只是需要针对不同的浏览器执行不同的 js 函数而已
    if (window.createObjectURL != undefined) { // basic
        url = window.createObjectURL(file);
    } else if (window.URL != undefined) { // mozilla(firefox)
        url = window.URL.createObjectURL(file);
    } else if (window.webkitURL != undefined) { // webkit or chrome
        url = window.webkitURL.createObjectURL(file);
    }
    return url;
}
