<!doctype html>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fnss" prefix="fnss" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta content="width=device-width, initial-scale=1" name="viewport"/>
	<title>智慧商街商户端 - 财务管理</title>
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/reset.css">
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/style.css">
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/finance.css">
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/lyz.calendar.css">
	<script type="text/javascript" src="${path}/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${path}/resources/js/common.js"></script>
	<script type="text/javascript" src="${path}/resources/js/finance.js"></script>
	<script type="text/javascript" src="${path}/resources/js/jquery.validate.js"></script>
	<script type="text/javascript" src="${path}/resources/js/xcConfirm/js/xcConfirm.js"></script>
	<link rel="stylesheet" href="${path}/resources/js/xcConfirm/css/xcConfirm.css">
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/reset.css">
	<script type="text/javascript" src="${path}/resources/js/common.js"></script>
	<script type="text/javascript" src="${path}/resources/time/js/laydate.js"></script>
	
		<script type="text/javascript" >
		   function formatDate (val) {
			   // 格式化时间
			   let start = new Date(val)
			   let y = start.getFullYear()
			   let m = (start.getMonth() + 1) > 10 ? (start.getMonth() + 1) : (start.getMonth() + 1)
			   let d = start.getDate() > 10 ? start.getDate() : start.getDate()
			   return y + '-' + m + '-' + d
			 }
			 
			 function mistiming (sDate1, sDate2) {
			   // 计算开始和结束的时间差
			   let aDate, oDate1, oDate2, iDays
			   aDate = sDate1.split('-')
			   oDate1 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0])
			   aDate = sDate2.split('-')
			   oDate2 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0])
			   iDays = parseInt(Math.abs(oDate1 - oDate2) / 1000 / 60 / 60 / 24)
			   return iDays + 1
			 }
			 
			 function countDate (start, end) {
			   // 判断开始和结束之间的时间差是否在90天内
			   let days = mistiming(start, end)
			   let stateT = days > 90 ? Boolean(0) : Boolean(1)
			   return {
			     state: stateT,
			     day: days
			   }
			 }
			 
			 function timeForMat (count) {
			   // 拼接时间
			   let time1 = new Date()
			   time1.setTime(time1.getTime() - (24 * 60 * 60 * 1000))
			   let Y1 = time1.getFullYear()
			   let M1 = ((time1.getMonth() + 1) > 10 ? (time1.getMonth() + 1) : (time1.getMonth() + 1))
			   let D1 = (time1.getDate() > 10 ? time1.getDate() : time1.getDate())
			   let timer1 = Y1 + '-' + M1 + '-' + D1 // 当前时间
			   let time2 = new Date()
			   time2.setTime(time2.getTime() - (24 * 60 * 60 * 1000 * count))
			   let Y2 = time2.getFullYear()
			   let M2 = ((time2.getMonth() + 1) > 10 ? (time2.getMonth() + 1) : (time2.getMonth() + 1))
			   let D2 = (time2.getDate() > 10 ? time2.getDate() : time2.getDate())
			   let timer2 = Y2 + '-' + M2 + '-' + D2 // 之前的7天或者30天
			   return {
			     t1: timer1,
			     t2: timer2
			   }
			 }
			 
			 function today () {
				   // 校验是不是选择的昨天
				   let timer = timeForMat(0);
				   return timer;
			 }
			 
			 function yesterday () {
			   // 校验是不是选择的昨天
			   let timer = timeForMat(1);
			   return timer;
			 }
			 
			 function sevenDays () {
			   // 获取最近7天
			   let timer = timeForMat(7);
			   return timer;
			 }
			 
			 function thirtyDays () {
			   // 获取最近30天
			   let timer = timeForMat(30);
			   return timer;
			 }
			 
			 function ontoday(){
				 var t = today();
				 $("#startTime").val(t.t2);
				 $("#endTime").val(t.t2);
			 }
			 
			 function onyesterday(){
				 var t = yesterday();
				 $("#startTime").val(t.t1);
				 $("#endTime").val(t.t1);
			 }
			 
			 function onlatestsevendays(){
				 var t = sevenDays();
				 $("#startTime").val(t.t2);
				 $("#endTime").val(today().t2);
			 }
			 
			 function onlatestthirtydays(){
				 var t = thirtyDays();
				 $("#startTime").val(t.t2);
				 $("#endTime").val(today().t2);
			 }
			 
			 
			function refunds(orderId,planChargeAmount,actualChargeAmount){
				alert(planChargeAmount);
				window.wxc.xcConfirm('输入退款金额?<input type="text" id="ssss">', window.wxc.xcConfirm.typeEnum.confirm, {
	                title: '提示'
	                , onOk: function () {
	                	
	                	alert($(ssss).val());
	                	$.ajax({
	                        url: "${path}/merchant/finance/orderCenter",
	                        global: false,
	                        type: "POST",
	                        dataType: "json",
	                        data:{
	                            
	                        },
	                        async: false,
	                        success: function (result) {
	                            if (result.success) {
	                                window.wxc.xcConfirm("操作成功。", window.wxc.xcConfirm.typeEnum.success);
	                                window.setTimeout("window.location.reload()",2000);
	
	                            } else {
	                                window.wxc.xcConfirm(result.message, window.wxc.xcConfirm.typeEnum.error);
	                            }
	                        }
	                       
	                    });
	                	 if (Number($(ssss).val())<88) {
	                         window.wxc.xcConfirm("操作成功。", window.wxc.xcConfirm.typeEnum.success);
	                       
	
	                     } else {
	                         window.wxc.xcConfirm("操作失败。", window.wxc.xcConfirm.typeEnum.error);
	                     }
	                	/*
	                    $.ajax({
	                        url: "${path}/merchant/merchantAccount/deleteMerchantAccount",
	                        global: false,
	                        type: "POST",
	                        dataType: "json",
	                        data:{
	                            merchantAccountId:merchantAccountId
	                        },
	                        async: false,
	                        success: function (result) {
	                            if (result.success) {
	                                window.wxc.xcConfirm("操作成功。", window.wxc.xcConfirm.typeEnum.success);
	                                window.setTimeout("window.location.reload()",2000);
	
	                            } else {
	                                window.wxc.xcConfirm(result.message, window.wxc.xcConfirm.typeEnum.error);
	                            }
	                        }
	                       
	                    });
	                	 */
	                },
	            });
			}
			
			function formSubmit(){
				$("#pageForm").submit();
			}
			
			function createExcel(){
				var url = $("#pageForm").attr("action");
				$("#pageForm").attr("action","${path}/merchant/finance/createExcelForOrder");
				$("#pageForm").submit();
				$("#pageForm").attr("action",url);
			}
		</script>
</head>
<body>
	
	<ol>
		<li class="inquier">
				
				<h3>交易查询</h3>
				<form id="pageForm" action="${path}/merchant/finance/orderCenter" method="post"> 
				      <input type="hidden" name="pageNo" id="pageNo">
				<div class="time">
					<p>时间：</p>
					<span class="hover" onclick="ontoday()">今天</span>
					<span onclick="onyesterday()">昨天</span>
					<span onclick="onlatestsevendays()">最近7天</span>
					<span onclick="onlatestthirtydays()">最近30天</span>
					<div style="width:432px;height:42px;float:left;">
					  <input id="startTime" name="startTimeStr" class="inline laydate-icon" value="${startTime }" placeholder="开始日期"/>
					  <span style="line-height:55px;">至</span>
					  <input id="endTime" name="endTimeStr" class="inline laydate-icon" value="${endTime }" placeholder="结束日期"/>
					</div>
				</div>
				<div class="name">
				<p>门店名称：</p>
				<div class="all">
					<select id="store" name="storeCode" value="${orderInfo.storeCode }">
					   <option <c:if test="${orderInfo.storeCode==''}">selected</c:if> value="">请选择</option>
					   <option <c:if test="${orderInfo.storeCode=='1'}">selected</c:if> value="1">全部门店1</option>
					</select>
				</div>
				<p>支付状态：</p>
				<div class="pay">
				    <select id="status" name="status" value="${orderInfo.status}">
				       <option <c:if test="${orderInfo.status==''}">selected</c:if> value="">请选择</option>
				       <option <c:if test="${orderInfo.status=='1'}">selected</c:if> value="0">未确认</option>
					   <option <c:if test="${orderInfo.status=='1'}">selected</c:if> value="1">成功</option>
					   <option <c:if test="${orderInfo.status=='2'}">selected</c:if> value="2">失败</option>
					</select>
				</div>
				<p>支付方式：</p>
			    <div class="state">
					<select id="payMethod" name="payMethod" value="${orderInfo.payMethod }" >
					   <option <c:if test="${orderInfo.payMethod ==''}">selected</c:if> value="">请选择</option>
					   <option <c:if test="${orderInfo.payMethod =='2'}">selected</c:if> value=2>支付宝支付</option>
					   <option <c:if test="${orderInfo.payMethod =='1'}">selected</c:if> value=1>微信支付</option>
					</select>
				</div>
				
			</div>
			<div class="name_two">
			    <p>交易类型：</p>
			    <div class="state">
					<select id="orderType" name="orderType" value="${orderInfo.orderType }" >
					   <option <c:if test="${orderInfo.payMethod ==''}">selected</c:if> value="">请选择</option>
					   <option <c:if test="${orderInfo.payMethod =='2'}">selected</c:if> value="1">微信</option>
					   <option <c:if test="${orderInfo.payMethod =='1'}">selected</c:if> value="2">支付宝</option>
					   <option <c:if test="${orderInfo.payMethod =='1'}">selected</c:if> value="3">银联卡</option>
					   <option <c:if test="${orderInfo.payMethod =='1'}">selected</c:if> value="4">京东</option>
					</select>
				</div>
				<p>终端来源：</p>
				<div class="inp_1">
					<select id="deviceType" name="deviceType" value="${orderInfo.deviceType }">
					   <option value="">请选择</option>
					   <option value="1">微收银 </option>
					   <option value="2">商亿</option>
					   <option value="3">云打印机</option>
					   <option value="4">POS机</option>
					</select>
				</div>
				<p>交易单号：</p>
				<div class="inp_2">
					<input type="text" id="orderId" name="orderId" value="${orderInfo.orderId }">
				</div>
				
			</div>
			<div class="name_three">
				<p>优惠类型：</p>
				<div class="inp_4">
					<select id="discountType" name="discountType" value="${orderInfo.discountType }">
					       <option value="">请选择</option>
						   <option value="1">平台优惠</option>
						   <option value="2">优惠平台（商家优惠）</option>
					</select>
				</div>
				<p>收银员：</p>
				<div class="inp_3">
					<select id="accountId" name="accountId" >
					   <option value="">请选择</option>
					   <option>支付宝支付</option>
					   <option>微信支付</option>
					</select>
				</div>
			</div>
			<div class="word">
				<div class="inquire">
					<p onclick="formSubmit();">查询</p>
				</div>
				<div class="wordd">
					<p>高级搜索</p>
					<img src="${path}/resources/images/finance/pull.png" alt="">
				</div>
				<div class="derive">
					<p onclick="createExcel()">导出</p>
				</div>
			</div>
			</form>
			<div class="deal">
				<div class="deal_left">
					<p>交易笔数&nbsp&nbsp(<span>笔</span>)</p>
					<h3>0</h3>
				</div>
				<div class="deal_left">
					<p>商家收入&nbsp&nbsp(<span>元</span>)</p>
					<h3>0</h3>
					<span class="on">充值收入:0</span>
					<span class="two">交易收入:0</span>
				</div>
				<div class="deal_right">
					<p>商家净收入&nbsp&nbsp(<span>元</span>)</p>
					<h3>0</h3>
				</div>
			</div>
			<div class="data">
				<div>
					<p>订购金额&nbsp&nbsp(<span>元</span>)</p>
					<h3>0</h3>
				</div>
				<div>
					<p>商家优惠&nbsp&nbsp(<span>元</span>)</p>
					<h3>0</h3>
				</div>
				<div>
					<p>手续费&nbsp&nbsp(<span>元</span>)</p>
					<h3>0</h3>
				</div>
				<div>
					<p>净退款&nbsp&nbsp(<span>元</span>)</p>
					<h3>0</h3>
					<span class="first">实退金额:0</span>
					<span class="sec">手续费:0</span>
				</div>
				<div class="empty">
					<p>退款笔数&nbsp&nbsp(<span>笔</span>)</p>
					<h3>0</h3>
				</div>
			</div>
			<div class="word_right">
				<img class="pull" src="${path}/resources/images/finance/pull_1.png" alt="">
				<p class="more">查看更多数据</p>
			</div>
		
		
			
	
			
			
			<table border="0" cellspacing="0" cellpadding="0" class="tab">
				<thead>
					<tr>
						<td>交易时间</td>
						<td>交易订单号</td>
						<td>交易类型</br>终端来源</td>
						<td>门店</td>
						<td>收银员</td>
						<td>交易金额/元</td>
						<td>实收金额/元</td>
						<td>退款金额/元</td>
						<td>交易状态</td>
						<td>费率/%</td>
						<td>划账金额/元</td>
						<td>操作</td>
					</tr>
				</thead>
				<tbody>
				   <c:forEach items="${pageBean.list }" var="order">
						<tr>
							<td>${order.tradeTime }</td>
							<td>${order.orderId}</td>
							<td>${order.orderPayMethedName}</br>POS机</td>
							<td>${order.shortName }</td>
							<td>张三</td>
							<!-- <fmt:formatNumber type="number" value="${order.planChargeAmount }" pattern="0.00" maxFractionDigits="2"/> -->
							<td>${fnss:formateNumber(order.planChargeAmount)} </td>
							<td>${fnss:formateNumber(order.actualChargeAmount)}</td>
							<td>${fnss:formateNumber(order.refundMoney)}</td>
							<td>${order.orderTypeName}</td>
							<td>${fnss:formateNumber(order.rate)}%</td>
							<td>${fnss:formateNumber(order.netIncome)}</td>
							<td class="msg"><a onclick="refunds(${order.orderId},${order.planChargeAmount},${order.actualChargeAmount})">退款</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<%@ include file="../include/page.jsp" %>
			
		</li>
	</ol>	

	
<script src="${path}/resources/plugins/jquery/lyz.calendar.min.js" type="text/javascript"></script>
<script type="text/javascript">
!function(){
	laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
	laydate({elem: '#startTime'});//绑定元素
}();

!function(){
	laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
	laydate({elem: '#endTime'});//绑定元素
}();
</script>
</body>
</html>