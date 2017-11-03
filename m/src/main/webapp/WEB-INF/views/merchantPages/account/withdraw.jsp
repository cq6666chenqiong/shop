<!doctype html>
<%@ page language="java" pageEncoding="UTF-8" %>
<html lang="en">
<head>
	<%@ include file="../include/header.jsp" %>
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/style.css">
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/account.css">
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/lyz.calendar.css">
	<script type="text/javascript" src="${path}/resources/js/account.js"></script>
	<script>
        $(document).ready(function() {
            $("#inputForm").validate({
                rules: {
                    amount: {
                        required:true,
                        isdecimalstwo:true,
                        smallUseableAmount:true
                    },
                    password:"required",
                    fee:"required"
                },
                submitHandler: function(form) {
                    //form.submit();
                }
            });

            // 自定义验证
            //两位小数正数验证切大于等于0.1小于等于9999999.99
            $.validator.addMethod("isdecimalstwo",function(value,element){
                return this.optional(element) || (/^\d{0,7}(\.\d{1,2})?$/.test(value)&&value>=0.1);
            },"请输入数字(最小0.1,最大9999999.99),可保留不多于两位小数");

            $.validator.addMethod("smallUseableAmount", function (value, element, params) {
                if (value>$("#canWithdrawAmount").val()) {
                    return false;
                }
                return true;
            }, "提现金额不能大于可体现金额");

            $("#submitBtn").click(function () {
                if($("#inputForm").valid()){
                    $.ajax({
                        url: "${path}/merchant/fundAccount/saveWithdrawRecord",
                        global: false,
                        type: "POST",
                        dataType: "json",
                        data:{
                            merchantId:$("#merchantId").val(),
                            withdrawType:$("#withdrawType").val(),
                            withdrawAccount:$("#withdrawAccount").val(),
                            amount:$("#amount").val(),
                            fee:$("#fee").val(),
                            password:$("#password").val(),
                            mchCode:$("#mchCode").val()
                        },
                        async: false,
                        success: function (result) {
                            if (result.success) {
                                window.wxc.xcConfirm("操作成功。", window.wxc.xcConfirm.typeEnum.success);
                                window.setTimeout("window.location='${path}/merchant/fundAccount/overview'",2000);
                            } else {
                                window.wxc.xcConfirm(result.message, window.wxc.xcConfirm.typeEnum.error);
                                //$("#finishChat").show();
                            }
                        }
                    });
                }
            });
        });


		function withdrawAll() {
			if($("#withdrawType").val()==1){
                $("#amount").val($("#canWithdrawAmount").val())
                $("#fee").val("0.00");
			}else{
                $("#amount").val($("#canWithdrawAmount").val())
                $("#fee").val("0.00");
			}
        }
	</script>
</head>
<body>
	
	<div class="main_wrap">
		<div class="title">提现</div>
		<div class="settlement_account">
			<p class="settlement_word">结算账户</p>
		</div>
		<div class="account_information">
			<div class="account_data">
				<div class="account_data_left">开户名称</div>
				<div class="account_data_right">${mechantExtendInfo.accountName}</div>
			</div>
			<div class="account_data">
				<div class="account_data_left">开户银行</div>
				<div class="account_data_right">${mechantExtendInfo.bankName}</div>
			</div>
<%--			<div class="account_data">
				<div class="account_data_left">开户银行省市</div>
				<div class="account_data_right">北京市海淀区北清路68号院24号楼A座4层0428</div>
			</div>--%>
			<div class="account_data">
				<div class="account_data_left">银行账户</div>
				<div class="account_data_right">${mechantExtendInfo.accountNo}</div>
			</div>
		</div>
		<div class="settlement_account">
			<p class="settlement_word">提现信息</p>
		</div>
		<form id="inputForm" name="inputForm" action="/merchant/merchantAccount/saveAccount" method="post">
			<input type="hidden" name="merchantId" id="merchantId" value="${merchantInfo.id}">
			<input type="hidden" name="mchCode" id="mchCode" value="${mechantExtendInfo.mchCode}">
			<input type="hidden" id="withdrawType" name="withdrawType" value="${type}">
			<input type="hidden" id="withdrawAccount" name="withdrawAccount" value="1">

			<input type="hidden" id="canWithdrawAmount" value="${canWithdrawAmount}">
		<div class="account_information maxheight">
			<div class="information1">
				<p class="information1_left"> <span style="color:#ff0000">*</span>提现金额 </p>
				<input type="text" class="input1" name="amount" id="amount">
				<p class="unit">元</p>
				<p class="cash">可提现余额${canWithdrawAmount},
					<span onclick="withdrawAll();">
						全部提现
				   </span>
				</p>
				<p class="attention1"> <span style="color:#ff0000;margin-right:8px">*</span>最少提现金额2000元,一天仅能提现一次</p>
			</div>
			<div class="information2">
				<p class="information1_left">提现手续费</p>
				<input type="text" class="input4" placeholder="0.00"  name="fee" id="fee" readonly>
				<p class="unit">元</p>
				<p class="attention2"> <span style="color:#ff0000;margin-right:8px">*</span>提现手续费率0.05%</p>
			</div>
			<div class="information3">
				<p class="information1_left"> <span style="color:#ff0000">*</span>收款账户</p>
				<div class="input2 input_color">银行卡</div>
				<div class="input3 input_color">营销账户</div>
			</div>
			<div class="information1">
				<p class="information1_left"> <span style="color:#ff0000">*</span>提现密码</p>
				<input type="password" class="input5"  name="password" id="password">
			</div>
			<div class="refer">
				<input type="button" value="提交" id="submitBtn">
			</div>
		</div>
		</form>

	</div>

</body>
</html>