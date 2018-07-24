$(function () {
    $.get("/queryLogin.do", function (data) {
        var obj = data[0]
        console.log(obj)

        if (obj == undefined) {
            $.get("loginout.do")
            $("#ul").append("  <!-- 未登入的状态 -->" +
                "            <li class=\"layui-nav-item\">" +
                "                <a class=\"iconfont icon-touxiang layui-hide-xs\" href=\"/login.html\"></a>" +
                "            </li>" +
                "            <li class=\"layui-nav-item\">" +
                "                <a href=\"/login.html\">登入</a>" +
                "            </li>" +
                "            <li class=\"layui-nav-item\">" +
                "                <a href=\"/reg.html\">注册</a>" +
                "            </li>" +
                "            <li class=\"layui-nav-item layui-hide-xs\">" +
                "                <a href=\"/app/qq/\" onclick=\"layer.msg('正在通过QQ登入', {icon:16, shade: 0.1, time:0})\" title=\"QQ登入\"" +
                "                   class=\"iconfont icon-qq\"></a>" +
                "            </li>" +
                "            <li class=\"layui-nav-item layui-hide-xs\">" +
                "                <a href=\"/app/weibo/\" onclick=\"layer.msg('正在通过微博登入', {icon:16, shade: 0.1, time:0})\" title=\"微博登入\"" +
                "                   class=\"iconfont icon-weibo\"></a>" +
                "            </li>")
        } else {
            $("#ul").append("<!-- 登入后的状态 -->" +
                " <li class='layui-nav-item'>" +
                "  <a href='javascript:;'>" +
                "<img src='/media/layui/images/face/1.gif' class='layui-nav-img' id='my-avatar'>" +
                "    <span id='user'></span>" +
                " </a> <dl class='layui-nav-child' id='dl'><dd><a href='/Selfhome.html?id="+obj.id+"' ><i class='fa fa-home'></i>用户主页 </a></dd>" +
                "<dd><a href='/set.html' ><i class=\"layui-icon layui-icon-username\"></i>用户中心</a></dd>"+
                "  <dd><a href='/updatePassword.html'><i class=\"layui-icon layui-icon-password\"></i>修改密码</a></dd>" +
                " </dl></li>" +
                "<li class=\"layui-nav-item\">" +
                "<form name=\"out\" action=\"/loginout.do\" method=\"post\"><input type=\"hidden\" name=\"_csrf\" value=\"65d3081f-b7a5-48a3-abf6-f22dda780588\"/>" +
                " <a href=\"javascript:document.out.submit();\"><i class=\"fa  fa-sign-out\" aria-hidden=\"true\"></i>&nbsp;退出</a></form></li>"
            )
            if(obj.level>1){
                $("#dl").append(" <dd><a href='/admin/index.html'><i class=\"layui-icon layui-icon-home\"></i>管理后台</a></dd>")
            }
            $("#user").html(obj.nickname)
        }
    })


    $("#work").click(function () {
        $.get("workadd.do", "type=1", function (obj) {
            console.log("签到返回值：" + obj)
            if (obj == 1) {
                layer.msg(
                    "签到成功",
                    {icon: 6, time: 2000, offset: 't'}
                )
            } else if (obj == 0) {
                layer.msg("签到失败", {
                    icon: 5, time: 2000, offset: 't'
                })
            }
        })
    })
})