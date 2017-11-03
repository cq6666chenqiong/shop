<!doctype html>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
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
	<script type="text/javascript" src="${path}/resources/javascript/common.js"></script>
	<script type="text/javascript" src="${path}/resources/javascript/finance.js"></script>
	<script type="text/javascript" src="${path}/resources/js/jquery.validate.js"></script>
	<script type="text/javascript" src="${path}/resources/js/xcConfirm/js/xcConfirm.js"></script>
	<link rel="stylesheet" href="${path}/resources/js/xcConfirm/css/xcConfirm.css">
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/reset.css">
	<script type="text/javascript" src="${path}/resources/js/common.js"></script>
</head>
<body>
	
	<ol>
	<form id="pageForm" action="${path}/manager/finance/list" method="post">
					<input type="hidden" name="pageNo" id="pageNo">
				</form>
	
		<li class="inquier">
			<h3>交易查询</h3>
			<div class="time">
				<p>时间：</p>
				<span class="hover">今天</span>
				<span>昨天</span>
				<span>最近7天</span>
				<span>最近30天</span>
				<div style="width:432px;height:42px;float:left;">
				  <input id="txtBeginDate" style="width:170px;padding:7px 10px;border:1px solid #E7E7EB;margin-right:18px;float:left;font-size:12px;margin-top:12px;" placeholder="开始日期"/>
				  <span style="float:left;line-height:55px;">至</span>
				  <input id="txtEndDate" style="width:170px;padding:7px 10px;border:1px solid #E7E7EB;float:left;font-size:12px;margin-left:18px;margin-top:12px;" placeholder="结束日期"/>
				</div>
			</div>
			<div class="name">
				<p>门店名称：</p>
				<div class="all">
					<p>全部门店</p>
					<img src="${path}/resources/images/finance/triangle.png" alt="">
					<div class="none">
						<p>内圈科技</p>
						<p>万能鸟</p>
					</div>
				</div>
				<p>支付状态：</p>
				<div class="pay">
					<p>已支付</p>
					<img src="${path}/resources/images/finance/triangle.png" alt="">
					<div class="none1">
						<p>已支付</p>
						<p>未支付</p>
					</div>
				</div>
				<p>交易类型</p>
				<div class="state">
					<p>微信支付</p>
					<img src="${path}/resources/images/finance/triangle.png" alt="">
					<div class="none2">
						<p>支付宝支付</p>
						<p>微信支付</p>
					</div>
				</div>
			</div>
			<div class="name_two">
				<p>终端来源：</p>
				<div class="inp_1">
					<p>门店收款码</p>
					<img src="${path}/resources/images/finance/triangle.png" alt="">
					<div class="none3">
						<p>门店收款码</p>
						<p>在线收款码</p>
					</div>
				</div>
				<p>交易单号：</p>
				<div class="inp_2">
					<input type="text" value="请输入交易单号">
				</div>
				<p>收银员：</p>
				<div class="inp_3">
					<p>张三</p>
					<img src="${path}/resources/images/finance/triangle.png" alt="">
					<div class="none4">
						<p>李四</p>
						<p>张三</p>
					</div>
				</div>
			</div>
			<div class="name_three">
				<p>优惠类型：</p>
				<div class="inp_4">
					<p>平台优惠</p>
					<img src="${path}/resources/images/finance/triangle.png" alt="">
					<div class="none5">
						<p>平台优惠</p>
						<p>优惠平台</p>
					</div>
				</div>
			</div>
			<div class="word">
				<div class="inquire">
					<p>查询</p>
				</div>
				<div class="wordd">
					<p>高级搜索</p>
					<img src="${path}/resources/images/finance/pull.png" alt="">
				</div>
				<div class="derive">
					<p>导出</p>
				</div>
			</div>
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
					<tr>
						<td>2017/09/09</br>10:00:09</td>
						<td>8900239849<br/>8938589</td>
						<td>支付宝</br>POS机</td>
						<td>朝阳区第二</br>分店</td>
						<td>张三</td>
						<td>100.00</td>
						<td>100.00</td>
						<td>0</td>
						<td>支付成功</td>
						<td>0.38</td>
						<td>99.62</td>
						<td class="msg">退款</br>详情</td>
					</tr>
					<tr>
						<td>2017/09/09</br>10:00:09</td>
						<td>8900239849<br/>8938589</td>
						<td>微信退款</br>POS机</td>
						<td>朝阳区第二</br>分店</td>
						<td>里斯</td>
						<td>0</td>
						<td>0</td>
						<td>100.00</td>
						<td>退款成功</td>
						<td>0.38</td>
						<td>99.62</td>
						<td class="msg">退款</br>详情</td>
					</tr>
					<tr>
						<td>2017/09/09</br>10:00:09</td>
						<td>8900239849<br/>8938589</td>
						<td>储值消费</br>POS机</td>
						<td>朝阳区第二</br>分店</td>
						<td>里斯</td>
						<td>100.00</td>
						<td>100.00</td>
						<td>0</td>
						<td>支付成功</td>
						<td>0.38</td>
						<td>99.62</td>
						<td class="msg">退款</br>详情</td>
					</tr>
				</tbody>
			</table>
			<%@ include file="../include/page.jsp" %>
			<%--
			<ul class="page">
				<li class="on"><上一页</li>
				<li class="cur">1</li>
				<li>2</li>
				<li>3</li>
				<li>下一页></li>
			</ul>
			<p class="end">到第<input type="text" value="3">&nbsp&nbsp页</p>
			<p class="sum">共<span>&nbsp&nbsp16条</span>&nbsp记录</p>
			--%>
		</li>
	</ol>	

	<script>
		$(function () {
	        $("#txtBeginDate").calendar({
	            controlId: "divDate",                                 // 弹出的日期控件ID，默认: $(this).attr("id") + "Calendar"
	            speed: 200,                                           // 三种预定速度之一的字符串("slow", "normal", or "fast")或表示动画时长的毫秒数值(如：1000),默认：200
	            complement: true,                                     // 是否显示日期或年空白处的前后月的补充,默认：true
	            readonly: true,                                       // 目标对象是否设为只读，默认：true
	            upperLimit: new Date(),                               // 日期上限，默认：NaN(不限制)
	            lowerLimit: new Date("2011/01/01"),                   // 日期下限，默认：NaN(不限制)
	            /*callback: function () {                               // 点击选择日期后的回调函数
	                alert("您选择的日期是：" + $("#txtBeginDate").val());
	            }*/
	        });
	        $("#txtEndDate").calendar();
	    });
	</script>
	<script src="${path}/resources/plugins/jquery/lyz.calendar.min.js" type="text/javascript"></script>
</body>
</html>