<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 17/10/13
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header">
    <div class="header_center">
        <img src="${path}/resources/images/logo.png" class="logo"/>
        <ul id="menuUl">
            <li class="active"><a url="${path}/manager/index/home">首页</a></li>
<%--            <li><a url="views/account.html">账户管理</a></li>
            <li><a url="views/finance.html">财务管理</a></li>
            <li><a url="views/apply.html">应用市场</a></li>
            <li><a url="views/myapply.html">我的应用</a></li>
            <li><a url="views/shop.html">门店信息管理</a></li>
            <li><a url="views/system.html">系统管理</a></li>--%>
        </ul>
    </div>
</div>
<script>
    $(function () {
        loadParentMenu();
    });
    /**
     * 加载父级菜单
     */
    function loadParentMenu() {
        $.ajax({
            url: "${path}/manager/channelInfo/getParentChannelList",
            global: false,
            type: "GET",
            dataType: "json",
            async: false,
            success: function (result) {
                $.each(result, function (index, value) {
                    var $option = $("<li><a url='views/account.html'>"+value.channelName+"</a></li>");
                    $("#menuUl").append($option);
                });
            }
        });
    }
</script>
