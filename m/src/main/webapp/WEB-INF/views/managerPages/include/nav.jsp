<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 17/10/12
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="nav">
    <div class="nav_center">
        <a href="javascript:void(0);" onclick="window.location.href='${path}/manager/index/logout'">退出</a>
        <img src="${path}/resources/images/1.png"/>
        <h1>欢迎您,<span id="accountSpan"></span></h1>
    </div>
</div>
<script>
    $(document).ready(function () {
        jQuery.ajax({
            type: "post",
            async: true,
            url: "${path}/manager/merchantAccount/getAccountFormCookie",
            success: function(result){
                $("#accountSpan").text(result.data.name);

                //$("#editPwdId").attr("itemUrl",contextPath+"/umplatform/user/toEditPsw?id="+result.data.userInfo.id);
            }
        });
    });
</script>