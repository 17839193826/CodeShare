var $, layer, form, layedit, upload;
var editindex;
layui.use(['layer', 'form', 'upload', 'jquery', 'layedit'], function() {

	$ = layui.jquery;
	layer = layui.layer;
	form = layui.form;		
	form.on('submit(btnsave)', function(data) {
		if	(data.field.newpwd!=data.field.newpwd2){
			layer.msg("两次输入的密码不一致");
			return false;
		}
		layer.load();
		var data1 = {
			id: sessionStorage.getItem("id"),	
			oldpwd: data.field.oldpwd,			
			newpwd: data.field.newpwd
		}
		$.ajax({
			url: apiUrl + 'api/Admin/UpdatePwd',
			type: 'post', //GET
			async: true, //或false,是否异步
			dataType: 'json', //返回的数据格式：json/xml/html/script/jsonp/text
			contentType: 'application/json',
			data: JSON.stringify(data1),
			headers: {
				'Authorization': 'Bearer ' + sessionStorage.getItem("token")
			},
			dataType: 'json', //返回的数据格式：json/xml/html/script/jsonp/text
			success: function(jsondata) {
				if(jsondata.Type == 1) {
					layer.msg('密码修改成功，请重新登录');		
					var index = parent.layer.getFrameIndex(window.name);
					parent.layer.close(index);
					parent.location.href='login.html';
				}else{
					layer.msg(jsondata.Message);
				}
			},
			statusCode: {
				401: function() {
					layer.msg("登录信息验证失败，请重新登录");
					location.href = 'login.html';
				}
			},
			complete: function() {
				layer.closeAll('loading');
			}
		});
		return false;

	});

});