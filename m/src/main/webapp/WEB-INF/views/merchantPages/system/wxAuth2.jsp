<!doctype html>
<%@ page language="java" pageEncoding="UTF-8" %>
<html lang="en">
<head>
	<%@ include file="../include/header.jsp" %>
	<link rel="stylesheet" href="${path}/resources/css/system.css">
	<script>
        $(document).ready(function() {
            $("#inputForm").validate({
                rules: {
                    name: {
                        required:true
					},
                    appId: {
                        required:true
                    },
                    appSecret: {
                        required:true
                    }
                },
                submitHandler: function(form) {
                    //form.submit();
                }
            });


            $("#submitBtn").click(function () {
                if($("#inputForm").valid()){
                    $.ajax({
                        url: "${path}/merchant/wechatInfo/saveWechatInfo",
                        global: false,
                        type: "POST",
                        dataType: "json",
                        data:{
                            name:$("#name").val(),
                            appId:$("#appId").val(),
                            appSecret:$("#appSecret").val()
                        },
                        async: false,
                        success: function (result) {
                            if (result.success) {
                                window.wxc.xcConfirm("操作成功。", window.wxc.xcConfirm.typeEnum.success);
                                window.open("http://open.zhihuishangjie.cn/open","");
                                window.setTimeout("window.location='${path}/merchant/wechatInfo/toWxAuth'",2000);
                            } else {
                                window.wxc.xcConfirm(result.message, window.wxc.xcConfirm.typeEnum.error);
                                //$("#finishChat").show();
                            }
                        }
                    });
                }
            });
        });
	</script>
</head>
<body>




	<div class="right">
		<div>
		<div class="redelegation_wrap" style="display: block;">
			<div class="accredit_top">
				<h2>微信授权</h2>
			</div>
			<form id="inputForm" name="inputForm" action="/merchant/wechatInfo/doWxAuth" method="post">
			<div class="redelegation">
				<div class="appid app" style="margin-top: 0px;"><span class="requiredField">*</span>公众号名称:<input type="type" name="name" id="name" placeholder="请输入公众号名称"></div>
				<div class="appid app"><span class="requiredField">*</span>APPID:<input  style="margin-left: 58px;" type="type" name="appId" id="appId" placeholder="请输入APPID"></div>
				<div class="appid app"><span class="requiredField">*</span>AppSecret:<input style="margin-left: 30px;" type="type" name="appSecret" id="appSecret" style="margin-left: 17px;" placeholder="请输入APPSercret"></div>
				<div class="anew" id="submitBtn">添加授权</div>
			</div>
			</form>
		</div>
	</div>
	</div>

</body>
</html>