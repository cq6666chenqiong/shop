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
                    password: {
                        required:true,
                        isRight:true
					},
                    newPassword: {
                        required:true,
                        newPassword:true
                    },
                    reNewPassword: {
                        required:true,
                        reNewPassword:true
                    }
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

            //验证原始密码是否正确
            $.validator.addMethod("isRight", function (value, element, params) {
                var flag=0;
                jQuery.ajax({
                    type: "post",
                    async: false,
                    url: "${path}/merchant/merchantAccount/checkPassword",
                    data: {password:$("#password").val()},
                    success: function(result){
                        if (result.success) {
                            flag=1;
                        } else {
                            flag=0;
                        }
                    }
                });
                if(flag==0){
                    return false;
                }else{
                    return true;
                }
            }, "原始密码不正确");

            // 验证新密码是否和原始密码相同
            $.validator.addMethod("newPassword", function (value, element, params) {
                if(value==$("#password").val()){
                    return false;
                }
                return true;
            }, "新密码不能和原始密码相同");
            //验证两次新密码是否一致
            $.validator.addMethod("reNewPassword", function (value, element, params) {
                if(value!=$("#newPassword").val()){
                    return false;
                }
                return true;
            }, "两次密码输入不一致");

            $("#submitBtn").click(function () {
                if($("#inputForm").valid()){
                    $.ajax({
                        url: "${path}/merchant/merchantAccount/updateMyPassword",
                        global: false,
                        type: "POST",
                        dataType: "json",
                        data:{
                            password:$("#newPassword").val()
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
					<h2>账户信息 > 修改密码</h2>
				</div>
				<div class="account_bottom">
					<form id="inputForm" name="inputForm" action="/merchant/merchantAccount/updateMyPassword" method="post">
					<ul class="account_bottom_nav">
						<li><span class="requiredField">*</span>原密码:<input type="password" name="password" id="password" placeholder="请输入原密码"></li>
						<li><span class="requiredField">*</span>新密码:<input type="password" name="newPassword" id="newPassword" placeholder="请输入新的密码"></li>
						<li><span class="requiredField">*</span>重复密码:<input style="margin-left: 26px;"  type="password" name="reNewPassword" id="reNewPassword" style="margin-left: 17px;" placeholder="请重复输入新的密码"></li>
					</ul>
					<div class="account_save" style="margin-left: 32px;" id="submitBtn">提交</div>
					<div class="account_abolish" onclick="history.go(-1);">取消</div>
					</form>
				</div>
			</div>
		</div>
	</div>


</body>
</html>