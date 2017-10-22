<!doctype html>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
	<%@ include file="../include/header.jsp" %>
	<link rel="stylesheet" href="${path}/resources/css/system.css">
</head>
<body>
	
	<div class="right">
		<!-- 账户信息 -->
		<div  class="right_wrap">
			<!-- 账户信息  -->
			<div class="account_wrap top">
				<div class="account_top ">
					<h2>账户信息</h2>
				</div>
				<div class="account_bottom">
					<ul class="account_bottom_nav">
						<li>商户名称:<span>${merchantInfo.name}</span></li>
						<li>商户编号:<span>${merchantInfo.mchCode}</span></li>
						<li>管理门店:<span>全部门店</span></li>
						<li>登录账号:<span>${merchantAccount.account}</span></li>
						<li>真实姓名:<span>${merchantAccount.name}</span></li>
						<li>我的角色:<span>${roleNames}</span></li>
						<li>路机器授权:<span>武川县老袁笨鸡莜面饭店一分店</span></li>
						<li>手机号码:<span>${merchantAccount.phone}</span></li>
					</ul>
					<a href="${path}/merchant/merchantAccount/toEditMyAccountInfo" target="_self"><div class="account_icon">修改</div></a>
				</div>
			</div>

	</div>
	</div>
</body>
</html>