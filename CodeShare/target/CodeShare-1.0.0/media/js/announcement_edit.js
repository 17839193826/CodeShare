//获取url中的参数
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg); //匹配目标参数
	if(r != null) return unescape(r[2]);
	return null; //返回参数值
}
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
	$("#lblid").val(getUrlParam('id'));
	query(getUrlParam('id'));
	
	editindex = layedit.build('articlecontent',{tool: ['strong', 'italic', 'underline','del', '|', 'face','link','unlink']}); //建立编辑器    


	form.on('submit(btnsave)', function(data) {
	
		layer.load();
		var data1 = {
			Id: data.field.lblid,		
			Anlevel: data.field.articletype,
			Contentstr: encodeURIComponent(layedit.getContent(editindex)),
			
		}
		$.ajax({
			url: apiUrl + 'api/Admin/SaveAnnouncement',
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
					var index = parent.layer.getFrameIndex(window.name);
					parent.layer.close(index);
					parent.$('#btnSearch').trigger("click");
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

function query(id) {
	if(id == -1) {
		return;
	}
	var index = layer.load(0, {
		shade: false
	});
	$.ajax({
		url: apiUrl + 'api/Admin/GetAnnouncement/' + id,
		type: 'get', //GET
		async: true, //或false,是否异步
		dataType: 'json', //返回的数据格式：json/xml/html/script/jsonp/text
		contentType: 'application/json',
		headers: {
			'Authorization': 'Bearer ' + sessionStorage.getItem("token")
		},
		success: function(jsondata) {
			if(jsondata.Type == 1) {
				var data = jsondata.Data;					
				$("#articletype").val(data.Anlevel);
				$("#articlecontent").val(data.Contentstr);			
				 editindex = layedit.build('articlecontent',{tool: ['strong', 'italic', 'underline','del', '|', 'face','link','unlink']}); //建立编辑器    

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