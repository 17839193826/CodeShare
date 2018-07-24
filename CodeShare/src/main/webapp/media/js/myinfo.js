var $, layer, form, layedit, upload;
var editindex;
layui.use(['layer', 'form', 'upload', 'jquery', 'layedit'], function() {

	$ = layui.jquery;
	layer = layui.layer;
	form = layui.form;
	layedit = layui.layedit;
	upload = layui.upload;

	layedit.set({
		uploadImage: {
			url: apiUrl + 'api/Admin/UploadImg',
			success: function(src) {
				if(src.code == 0) {
					layer.msg("上传成功！");
				} else {
					layer.msg("上传失败！");
				}
			}
		}
	});
	editindex = layedit.build('Info'); //建立编辑器    
	query();
	//执行实例
	var uploadInst = upload.render({
		elem: '#imgpic' //绑定元素
			,
		url: apiUrl + 'api/Admin/UploadImg' //上传接口
			,
		done: function(src) {
			if(src.code == 0) {
				$("#imgurl").val(src.data.src);
				$("#imgpic").attr("src", src.data.src);
			} else {
				layer.msg("上传失败！");
			}

		},
		error: function() {
			//请求异常回调
		}
	});

	form.on('submit(btnsave)', function(data) {
		layer.load();
		var data1 = {
			Id: data.field.lblid,
			Name: data.field.Name,
			Address: data.field.Address,
			Oneword: data.field.Oneword,
			Imgurl: data.field.imgurl,
			Qq: data.field.Qq,
			Email: data.field.Email,
			Weibo: data.field.Weibo,
			Git: data.field.Git,
			Info: encodeURIComponent(layedit.getContent(editindex)),
			remark: ""
		}
		$.ajax({
			url: apiUrl + 'api/Admin/SaveMyInfo',
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
					layer.msg("保存成功");
				}
			},
			statusCode: {
				401: function() {
					layer.msg("登录信息验证失败，请重新登录");
				}
			},
			complete: function() {
				layer.closeAll('loading');
			}
		});
		return false;

	});

});

function query() {
var index = layer.load(0, {
		shade: false
	});
	$.ajax({
		url: apiUrl + 'api/Admin/GetMyInfo',
		type: 'get', //GET
		async: true, //或false,是否异步
		dataType: 'json', //返回的数据格式：json/xml/html/script/jsonp/text
		contentType: 'application/json',
		headers: {
			'Authorization': 'Bearer ' + sessionStorage.getItem("token")
		},
		success: function(jsondata) {
			if(jsondata.Type == 1) {
				if(jsondata.Data == null) {
					$("#lblid").val(-1);
					return;
				}
				var data = jsondata.Data;
				$("#lblid").val(data.Id);
				$("#Name").val(data.Name);
				$("#Address").val(data.Address);
				$("#Oneword").val(data.Oneword);
				$("#author").val(data.Author);
				$("#Qq").val(data.Qq);
				$("#Email").val(data.Email);
				$("#Weibo").val(data.Weibo);
				$("#Git").val(data.Git);
				$("#imgurl").val(data.Imgurl);
				$("#imgpic").attr("src", data.Imgurl);
				$("#Info").val(data.Info);
				form.render();
				editindex = layedit.build('Info');
			}
		},
		complete: function() {
			layer.close(index);
		},
		statusCode: {
			401: function() {
				layer.msg("登录信息验证失败，请重新登录");
			}
		}

	});
}