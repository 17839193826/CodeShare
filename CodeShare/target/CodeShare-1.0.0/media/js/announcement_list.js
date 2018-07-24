var form, $, table, layer;
layui.use(['element', 'layer', 'form', 'table'], function() {
	form = layui.form;
	$ = layui.jquery;
	layer = layui.layer;
	table = layui.table;

	//执行渲染
	table.render({
		elem: '#tbmain', //指定原始表格元素选择器（推荐id选择器）
		height: 'full-80',
		limits: [30, 60, 100, 150, 300],
		limit: 10,
		even: true,
		page: false,
		loading: true,
		cols: [
			[{
					field: 'operation',
					title: '操作',
					width: "15%",
					sort: false,
					align: 'center',
					toolbar: '#barTool'

				},

				{
					field: 'Createtime',
					title: '时间',
					width: "15%",
					sort: true
				},
				{
					field: 'Contentstr',
					title: '内容',
					width: "55%",
					sort: true
				}, {
					field: 'Anlevel',
					title: '级别',
					width: "15%",
					templet: function(d) {
						if(d.Anlevel == 1) {
							return "一般";
						} else if(d.Anlevel == 2) {
							return "重要";
						} else if(d.Anlevel == 3) {
							return "非常重要";
						}else{
							return d.Anlevel;
						}

					},
					sort: true
				}

			]
		],
		url: apiUrl + 'api/Admin/GetAnnouncementList',
		method: "get",
		headers: {
			Authorization: 'Bearer ' + sessionStorage.getItem("token"),
			contentType: 'application/json'
		},
		contentType: 'application/json',
		dataType: 'json',
		response: {
			statusName: 'Type' //数据状态的字段名称，默认：code
				,
			statusCode: 1 //成功的状态码，默认：0
				,
			msgName: 'Message' //状态信息的字段名称，默认：msg
				,
			countName: 'Count' //数据总数的字段名称，默认：count
				,
			dataName: 'Data' //数据列表的字段名称，默认：data

		}

	});

	//监听工具条
	table.on('tool(tbmain)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
		var data = obj.data; //获得当前行数据
		var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
		var tr = obj.tr; //获得当前行 tr 的DOM对象

		if(layEvent === 'del') { //删除
			layer.confirm('确定删除此公告吗？', function(index) { //删除对应行（tr）的DOM结构，并更新缓存

				del(obj);
				//向服务端发送删除指令
			});
		} else if(layEvent === 'edit') { //
			var index = layer.open({
				type: 2,
				title: '公告编辑',
				shadeClose: true,
				shade: 0.8,
				area: ['100%', '100%'],
				content: 'announcement_edit.html?id=' + data.Id, //iframe的url
				success: function(layero, index) {
					var body = layer.getChildFrame('body', index);
					body.find("#lblid").val(-1);
				},
				end: function() {

				}
			});
		}
	});
	//添加数据
	$('#btnAdd').click(function() {
		var index = layer.open({
			type: 2,
			title: '公告编辑',
			shadeClose: true,
			shade: 0.8,
			area: ['100%', '100%'],
			content: 'announcement_edit.html?id=-1', //iframe的url
			success: function(layero, index) {
				var body = layer.getChildFrame('body', index);
				body.find("#lblid").val(-1);
			},
			end: function() {

			}
		});
	});
	//添加数据
	$('#btnSearch').click(function() {
		search();
	});
	//查询
	function search() {
		table.reload('tbmain', {
			url: apiUrl + 'api/Admin/GetAnnouncementList',
			method: "get",
			headers: {
				Authorization: 'Bearer ' + sessionStorage.getItem("token"),
				contentType: 'application/json'
			},
			contentType: 'application/json',
			dataType: 'json',
			response: {
				statusName: 'Type' //数据状态的字段名称，默认：code
					,
				statusCode: 1 //成功的状态码，默认：0
					,
				msgName: 'Message' //状态信息的字段名称，默认：msg
					,
				countName: 'Count' //数据总数的字段名称，默认：count
					,
				dataName: 'Data' //数据列表的字段名称，默认：data

			}
		});

	};
	//删除
	function del(obj) {
		var index = layer.load(0);

		$.ajax({
			url: apiUrl + 'api/Admin/DelAnnouncement/' + obj.data.Id,
			type: 'post',
			async: true,
			contentType: 'application/json',
			dataType: 'json',
			headers: {
				Authorization: 'Bearer ' + sessionStorage.getItem("token")
			},
			success: function(jsondata) {
				if(jsondata.Type == 1) {
					obj.del();
					layer.msg("删除成功");
				} else {
					layer.msg("删除失败");
				}
			},
			complete: function(data, xhr) {
				layer.close(index);
			}

		});
	}
});