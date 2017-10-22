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
                    phone: {
                        required:true,
						isMobile:true
					},
                    password:"required",
                    imagecode:"required"
                },
                submitHandler: function(form) {
                    form.submit();
                }
            });


            // 自定义验证
            $.validator.addMethod("isMobile", function (value, element, params) {
                //var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
                var myreg = /^1[3|4|5|7|8][0-9]{9}$/;
                if (!myreg.test(value)) {
                    return false;
                }
                return true;
            }, "请正确填写手机号码");

            $("#submitBtn").click(function () {
                if($("#inputForm").valid()){
                    $.ajax({
                        url: "${path}/merchant/merchantAccount/saveMyAccountInfo",
                        global: false,
                        type: "POST",
                        dataType: "json",
                        data:{
                            phone:$("#phone").val(),
                            password:$("#password").val(),
                            imagecode:$("#imagecode").val()
                        },
                        async: false,
                        success: function (result) {
                            if (result.success) {
                                window.wxc.xcConfirm("操作成功。", window.wxc.xcConfirm.typeEnum.success);
                                window.setTimeout("window.location='${path}/merchant/merchantAccount/getMyAccountInfo'",2000);
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
		<!-- 账户信息 -->
		<div  class="right_wrap">
			<!-- 修改  -->
			<div class="account_alter1">
				<div class="account_top">
					<h2>账户信息 > 修改</h2>
				</div>
				<div class="account_bottom">
					<form id="inputForm" name="inputForm" action="/merchant/merchantAccount/saveMyAccountInfo" method="post">
					<ul class="account_bottom_nav">
						<li>新手机号:<input type="text" name="phone" id="phone" placeholder="请输入新手机号"></li>
						<li>登录密码:<input type="password" name="password" id="password" placeholder="请输入登录密码"></li>
						<li>验证码:<input type="text" name="imagecode" id="imagecode" placeholder="请输入验证码">
							<img src="${path}/merchant/merchantAccount/imageCode" style="height:39px;width: 100px;"
								 onclick="this.src='${path}/merchant/merchantAccount/imageCode?'+Math.random()" />
						</li>
					</ul>
					<div class="account_save" id="submitBtn">提交</div>
					<div class="account_abolish" onclick="history.go(-1);">取消</div>
					</form>
				</div>
			</div>
		</div>
	</div>


</body>
</html>