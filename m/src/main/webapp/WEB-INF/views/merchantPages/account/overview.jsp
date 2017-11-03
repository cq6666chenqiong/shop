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
		function toWithdraw(type){
            window.location.href="${path}/merchant/fundAccount/toWithdraw?type="+type;
		}
	</script>
</head>
<body>
	
	<div class="main_wrap">
		<div class="title">账户概览</div>
		<div class="account_balance">
			<div class="balance">营销账户余额</div>
			<p class="word1">余额</p>
			<p class="word2"> <span>0.09</span> 元</p>
			<div class="button">
				<input type="button" class="recharge charge" value="充值">
				<input type="button" class="examine charge" value="查看账户流水">
			</div>
		</div>
		<div class="account_balance">
			<div class="statistics">
				<p class="word3">余额统计</p>
				<p class="word4">实时提现</p>
			</div>
			<div class="list">
				<div class="list_left">
					<div class="list1">
						<p class="word1">可提现余额</p>
						<p class="word2"> <span>${merchantFundAccount.withdrawAmount}</span> 元</p>
						<input type="button" class="deposit" value="提现" onclick="toWithdraw(1);">
					</div>
					<div class="list2">
						<p class="word1">余额</p>
						<p class="word2"> <span>${realTimeAmount}</span> 元</p>
						<input type="button" class="deposit" value="提现" onclick="toWithdraw(2);">
					</div>
				</div>
				<div class="list_right">
					<div class="list3">
						<p class="word1">会员充值净收入</p>
						<p class="word2"> <span style="color:#ff0000">0.09</span> 元</p>
						<input type="button" class="deposit" value="提现">
					</div>
					<div class="list4">
						<p class="word1">非会员消费净收入</p>
						<p class="word2"> <span style="color:#00bfff">0.09</span> 元</p>
						<input type="button" class="deposit" value="提现">
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>