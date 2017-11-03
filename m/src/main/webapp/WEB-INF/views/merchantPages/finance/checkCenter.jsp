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
	<title>智慧商街商户端 - 财务管理</title>
	 <meta http-equiv="pragma" content="no-cache">
	  <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">  
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
	<script type="text/javascript">
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
		 
	
		function formSubmit(){
			$("#pageForm").submit();
		}
		
		function createExcel(){
			var url = $("#pageForm").attr("action");
			$("#pageForm").attr("action","${path}/merchant/finance/createExcelForCheckOrder");
			$("#pageForm").submit();
			$("#pageForm").attr("action",url);
		}
		
		function lookDetail(){
			window.location.href = '${path}/merchant/finance/checkDetail?storeCode='+$('#storeCode').val()+'&startTimeStr='+$('#startTime').val()+'&endTimeStr='+$('#endTime').val();
		}
	</script>
</head>
<body>		
	<ol>
		<li class="rec">
			<h3>对账中心</h3>
			<form id="pageForm" action="${path}/merchant/finance/checkCenter" method="post"> 
				<input type="hidden" name="pageNo" id="pageNo">
				<div class="time">
					<p>时间：</p>
					<span class="hover" onclick="ontoday()">今天</span>
					<span onclick="onyesterday()">昨天</span>
					<span onclick="onlatestsevendays()">最近7天</span>
					<div style="width:432px;height:42px;float:left;">
					   <input id="startTime" name="startTimeStr" class="inline laydate-icon" value="${startTime}" placeholder="开始日期"/>
					   <span style="line-height:55px;">至</span>
					   <input id="endTime" name="endTimeStr" class="inline laydate-icon" value="${endTime }" placeholder="结束日期"/>
					</div>
				</div>
				<div class="word">
					<div class="inquire">
						<p onclick="formSubmit();">查询</p>
					</div>
					<div class="derive">
						<p onclick="createExcel()">导出</p>
					</div>
				</div>
			</form>
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
			<input type="hidden" id="storeCode" name="storeCode" value="1"/>
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
						<td class="msg_imp"><a href='#' onclick="lookDetail()">查看明细</a></td>
					</tr>
				</tbody>
			</table>
			<%@ include file="../include/page.jsp" %>
		</li>
	</ol>	

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
	<script src="${path}/resources/plugins/jquery/lyz.calendar.min.js" type="text/javascript"></script>
	
	</div>
</body>
</html>