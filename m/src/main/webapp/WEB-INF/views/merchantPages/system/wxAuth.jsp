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
	<!-- 微信授权 -->
	<div>
		<div class="accredit_wrap top">
			<div class="accredit_top">
				<h2>微信授权</h2>
			</div>
			<div class="accredit_buttom">
				<div class="head_img" style="width: 300px;">
					<span>公众号头像:<span style="margin-left: 12px;">&nbsp&nbsp${wechatInfo.name}</span></span>
				</div>
				<div class="head_img" style="width: 300px;">
					<span>APPID:<span style="margin-left: 48px;">${wechatInfo.appId}</span></span>
				</div>
				<div class="head_img" style="width: 300px;">
					<span>AppSecret:<span style="margin-left: 20px;">${wechatInfo.appSecret}</span></span>
				</div>
				<a href="${path}/merchant/wechatInfo/toWxAuth2" target="_self">
				<div class="anew">
					<c:if test="${wechatInfo==null}">
						授权
					</c:if>
					<c:if test="${wechatInfo.status==0}">
						授权
					</c:if>
					<c:if test="${wechatInfo.status==1}">
						重新授权
					</c:if>
				</div>
				</a>
			</div>
		</div>
	</div>
</div>
</body>
</html>