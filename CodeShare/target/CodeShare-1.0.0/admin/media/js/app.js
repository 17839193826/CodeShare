var apiUrl = "http://twodogs.top:8020/";
//var apiUrl = "http://localhost:56713/";

function getarticletype(id) {
	switch(id) {
		case 0:
			return "默认分类";
			break;
		case 10:
			return "Android";
			break;
		case 11:
			return "IOS";
			break;
		case 12:
			return "Java";
			break;
		case 13:
			return "C#";
			break;
		case 14:
			return "Web前端";
			break;
		case 15:
			return "html5";
			break;
		case 16:
			return "数据库";
			break;
		case 99:
			return "闲情随笔";
			break;
		default:
			return "默认分类";
			break;

	}
}

function getrestype(id) {
	switch(id) {
		case 0:
			return "默认分类";
			break;
		case 1:
			return "源码";
			break;
		case 2:
			return "文档";
			break;
		default:
			return "默认分类";
			break;

	}
}

function errorImg(img) {
	img.src = "images/helloworld.png";
	img.onerror = null;
}

function errorLinkImg(img) {
	img.src = "images/friendlink.png";
	img.onerror = null;
}
