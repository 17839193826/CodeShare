$(function () {
    var id
    var uid = getData();
    $.get("queryOneUser.do", "id=" + uid, function (data) {
        var obj = data[0]
        if (obj.level == 2) {
            $("#level").html("版主")
        } else if (obj.level > 2) {
            $("#level").html("管理员")
        }else {
            $("#level").html("成员")
        }
        if (obj.flag > 1) {
            $("#flag").html("（该号已被封）")
        }
        $(".nickname").text(obj.nickname)
        id = obj.id
        $("#sign").text("(" + obj.sign + ")")
        $("#createtime").text(obj.createtime + "加入")
        if (obj.sex == 1) {
            $("#sex").append("<i class=\"iconfont icon-nan\"></i>")
        } else if (obj.sex == 0) {
            $("#sex").append("<i class=\"iconfont icon-nv\"></i>")
        }

        $.get("queryFollow.do", "beuid=" + id, function (data) {
            if (data == '1') {
                console.log("是否有关注：" + data)
                $("#heart2").attr("checked", "checked");
            } else {
                console.log("是否有关注：" + data)
            }
        })
    })

    function demo() {
        demointerval = setInterval(function () {
            var chkbox = document.querySelector('input[type="checkbox"]:not([checked])');
            if (chkbox) {
                chkbox.click();
                chkbox.setAttribute('checked', 'checked');
            } else {
                clearInterval(demointerval);
            }
        }, 600);
    }

    if (document.location.pathname.indexOf('fullcpgrid') > -1) {
        demo();
    }
    $("#heart2").click(function () {
        $.post("addFollow.do", "beuid=" + id, function (obj) {
            if (obj == '1') {
                layer.msg('关注成功！', {icon: 1});
            } else if (obj == '0') {
                layer.msg('取消关注成功！', {icon: 1});
            } else if (obj == "nologin") {
                window.location = 'login.html'
            }
        })

    })
})

function getData() {
    var url = window.location.search;
    index = url.indexOf("?");
    if (index > -1) {
        var str = url.substr(index + 1);
        if (str.indexOf('=')) {
            return str.split('=')[1];
        }
    }
    return null;
}