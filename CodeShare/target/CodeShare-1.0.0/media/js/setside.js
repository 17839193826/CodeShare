function set(num,id) {

    console.log(num,id)
    $("#side").append(" <li class=\"layui-nav-item\" id='l1'>\n" +
        "            <a href=\"Selfhome.html?id="+id+"\">\n" +
        "                <i class=\"layui-icon\">&#xe609;</i>\n" +
        "                我的主页\n" +
        "            </a>\n" +
        "        </li>\n" +
        "        <li class=\"layui-nav-item\" id='l2'>\n" +
        "            <a href=\"set.html\">\n" +
        "                <i class=\"layui-icon\">&#xe620;</i>\n" +
        "                基本设置\n" +
        "            </a>\n" +
        "        </li>\n" +
        "        <li class=\"layui-nav-item\" id='l3'>\n" +
        "            <a href=\"message.html\">\n" +
        "                <i class=\"layui-icon layui-icon-notice\"></i>\n" +
        "                我的消息\n" +
        "            </a>\n" +
        "        </li>\n" +
        "        <li class=\"layui-nav-item\" id='l4'>\n" +
        "            <a href=\"MyTie.html\">\n" +
        "                <i class=\"layui-icon layui-icon-dialogue\"></i>\n" +
        "                我的帖子\n" +
        "            </a>\n" +
        "        </li>\n" +
        "        <li class=\"layui-nav-item\" id='l5'>\n" +
        "            <a href=\"MyCollect.html\">\n" +
        "                <i class=\"layui-icon layui-icon-component\"></i>\n" +
        "                其他\n" +
        "            </a>\n" +
        "        </li>")
    $("#l" + num).addClass("layui-this")
}