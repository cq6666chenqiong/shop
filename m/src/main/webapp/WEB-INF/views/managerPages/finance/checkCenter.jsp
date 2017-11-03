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
	<title>智慧商街商户端 - 财务管理</title>
	 <meta http-equiv="pragma" content="no-cache">
	  <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">  
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/reset.css">
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/style.css">
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/finance.css">
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/lyz.calendar.css">
	<script type="text/javascript" src="${path}/resources/plugins/jquery/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${path}/resources/javascript/common.js"></script>
	<script type="text/javascript" src="${path}/resources/javascript/finance.js"></script>
	<script type="text/javascript">
	$(document).ready(function () {
	    $("#click").click(function () {
	       alert('aaa');
		   $("#benyue").html("改变span的值（给span赋值)");
		       });
	});
	</script>
</head>
<body>		
	<ol>
		<li class="rec">
			<h3>对账中心</h3>
			<div class="time">
				<p>时间：</p>
				<span class="hover" onclick=thisMonth() >本月</span>
				<span onclick=lastMonth()>上月</span>
				<span onclick=lastSevenDay()>最近7天</span>
				<div style="width:432px;height:42px;float:left;">
				  <input id="txtBeginDate" style="width:170px;padding:7px 10px;border:1px solid #E7E7EB;margin-right:18px;float:left;font-size:12px;margin-top:12px;" placeholder="开始日期"/>
				  <span style="float:left;line-height:55px;">至</span>
				  <input id="txtEndDate" style="width:170px;padding:7px 10px;border:1px solid #E7E7EB;float:left;font-size:12px;margin-left:18px;margin-top:12px;" placeholder="结束日期"/>
				</div>
			</div>
			<div class="word">
				<div class="inquire">
					<p>查询</p>
				</div>
				<div class="derive">
					<p>导出</p>
				</div>
			</div>
			<div class="always">
				<div>
					<p>交易总笔数&nbsp&nbsp(<span>笔</span>)</p>
					<h3>0</h3>
				</div>
				<div>
					<p>交易总金额&nbsp&nbsp(<span>笔</span>)</p>
					<h3>0</h3>
				</div>
				<div>
					<p>退款总笔数&nbsp&nbsp(<span>笔</span>)</p>
					<h3>0</h3>
				</div>
				<div>
					<p>退款总金额&nbsp&nbsp(<span>笔</span>)</p>
					<h3>0</h3>
				</div>
				<div>
					<p>交易总净额&nbsp&nbsp(<span>笔</span>)</p>
					<h3>0</h3>
				</div>
				<div class="op">
					<p>结算总金额&nbsp&nbsp(<span>笔</span>)</br>预计</p>
					<h3>0</h3>
				</div>
			</div>
			<table border="0" cellspacing="0" cellpadding="0" class="tab_rec">
				<thead>
					<tr>
						<td>排名</td>
						<td>门店名称</td>
						<td>交易总金额/元</td>
						<td>交易总笔数/笔</td>
						<td>退款总金额/元</td>
						<td>优惠总金额/元</td>
						<td>实收总金额/元</td>
						<td>划账总金额/元</td>
						<td>操作</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><img src="${path}/resources/images/finance/trophy.png" alt=""></td>
						<td>朝阳区第二分店</td>
						<td>100</td>
						<td>100</td>
						<td>20</td>
						<td>20</td>
						<td>60</td>
						<td>59</td>
						<td class="msg_imp">查看明细</td>
					</tr>
				</tbody>
			</table>
			<ul class="page">
				<li class="on"><上一页</li>
				<li class="cur">1</li>
				<li>2</li>
				<li>3</li>
				<li>下一页></li>
			</ul>
			<p class="end">到第<input type="text" value="3">&nbsp&nbsp页</p>
			<p class="sum">共<span>&nbsp&nbsp16条</span>&nbsp记录</p>
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
	</div>
</body>
</html>