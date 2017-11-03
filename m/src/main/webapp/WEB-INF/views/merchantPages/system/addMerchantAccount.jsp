<!doctype html>
<%@ page language="java" pageEncoding="UTF-8" %>
<html lang="en">
<head>
	<%@ include file="../include/header.jsp" %>
	<link rel="stylesheet" href="${path}/resources/css/system.css">
	<script src="${path}/resources/js/system.js"></script>
	<script>
        $(document).ready(function() {
            $("#inputForm").validate({
                rules: {
                    account: {
                        required:true,
                        checkAccountIsExists:true
					},
                    password:"required",
					name:"required",
                    phone: {
                        required:true,
                        isMobile:true
                    }
                },
                submitHandler: function(form) {

                }
            });

            $.validator.addMethod("checkAccountIsExists", function (value, element, params) {
                var flag=0;
                jQuery.ajax({
                    type: "post",
                    async: false,
                    url: "${path}/merchant/merchantAccount/checkAccountIsExists",
                    data: {
                        account:$("#account").val()
                    },
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
            }, "已存在");
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
                    var roleIds="";
                    $('input[name=roleId]').each(
                        function(){
                            if ($(this).attr('checked')) {
                                if (roleIds != "") {
                                    roleIds = roleIds + "," + $(this).val();
                                } else {
                                    roleIds = $(this).val();
                                }
                            }
                        }
                    );
                    if (roleIds == "") {
                        $("#roleHint").show();
                        return false;
					}
                    if($.trim($("#shopIds").val())==""){
                        $(".admin_bottom_option>h2>span").show();
                        return false;
                    }
                    $.ajax({
                        url: "${path}/merchant/merchantAccount/saveAccount",
                        global: false,
                        type: "POST",
                        dataType: "json",
                        data:{
                            roleIds:roleIds,
                            accountType:$("#accountType").val(),
                            account:$("#account").val(),
                            password:$("#password").val(),
                            name:$("#name").val(),
                            phone:$("#phone").val(),
                            shopIds:$("#shopIds").val()
                        },
                        async: false,
                        success: function (result) {
                            if (result.success) {
                                window.wxc.xcConfirm("操作成功。", window.wxc.xcConfirm.typeEnum.success);
                                window.setTimeout("window.location='${path}/merchant/merchantAccount/accountList'",2000);
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
       <div class="admin_wrap">
		<div class="admin_new_admin" style="display: block;">
			<div class="admin_main">
				<div class="admin_main_top">
					<h2>账号管理 > 创建账号</h2>
				</div>
				<form id="inputForm" name="inputForm" action="/merchant/merchantAccount/saveAccount" method="post">
					<input type="hidden" name="accountType" id="accountType" value="1">
					<input type="hidden" name="shopIds" id="shopIds" value="">
				<div class="admin_bottom">
					<ul  class="admin_bottom_nav1">
						<li class="admin_bottom_nav_one"><span class="requiredField">*</span>账户类型:
							<span>
								商户账号
							</span>
						</li>
						<li><span class="requiredField">*</span>登录账号:<input type="text" name="account" id="account" placeholder="请输入您的账号"></li>
						<li><span class="requiredField">*</span>登录密码:<input type="password" name="password" id="password" placeholder="请输入您的密码"></li>
						<li><span class="requiredField">*</span>真实姓名:<input type="text" name="name" id="name" placeholder="请输入您的姓名"></li>
						<li class="admin_bottom_nav_two"><span class="requiredField">*</span>手机号:<input type="text" name="phone" id="phone" placeholder="请输入您的手机号"></li>

					</ul>
					<div class="content_m">
						<p><span class="requiredField">*</span>角色管理：
							<c:forEach items="${roleList}" var="roleInfo" varStatus="status">
								<input type="checkbox" name="roleId" value="${roleInfo.id}" <c:if test="${status.index==0}">style="margin-left:26px;"</c:if>> ${roleInfo.roleName}
							</c:forEach>
							<label id="roleHint" class="error" style="display: none"> 请选择角色</label>
						</p>

						<p style="color: #00bfff;margin-left:92px;">
							<a href="${path}/merchant/roleInfo/addRole" target="_self">
							+新增角色
							</a>
						</p>
					</div>
<%--					<div class="content_m">
						<div>
							<a style="display:block;float: left; border:none;"><img src="${path}/resources/images/system/img7.png" alt="">角色管理:</a>
							<c:forEach items="${roleList}" var="roleInfo">
							<span class="checkbox" ><input type="checkbox"  name="roleId" value="${roleInfo.id}"></span>
							<a style="display:block;float: left; border:none;">${roleInfo.roleName}</a>
							</c:forEach>
						</div>
						<p style="color: #00bfff;margin-left:98px;"><a href="${path}/merchant/roleInfo/addRole" target="_self">+新增角色</a></p>
					</div>--%>

					<div class="admin_bottom_option">
						<h2>选择门店<span>请选择门店</span></h2>
						<div class="admin_bottom_option_box">
							<div class="admin_bottom_option_top">
								<input type="text">
								<span>已选列表</span>
								<span>已选中门(<a id="selectedCount">0</a>)家</span>
							</div>
							<div class="admin_bottom_option_bottom" >
								<ul class="role_set_nav role_set_nav4 admin_bottom_option_nav1 as merchantAccountSelectShop">
									<c:forEach items="${shopList}" var="shop">
									<li><a href="####" shopId="${shop.id}">${shop.shortName }</a></li>
									</c:forEach>
								</ul>
								</ul>
							</div>
							<div class="admin_bottom_option_right">
								<%--<p>北京内圈科技有限公司<a class="pic2"></a></p>--%>

							</div>
						</div>
				</div>
				<span class="save" id="submitBtn">保存</span>
				<span class="abolish" onclick="history.go(-1);" >取消</span>
				</form>
			</div>
		</div>

	</div>
	</div>
	</div>


</body>
</html>