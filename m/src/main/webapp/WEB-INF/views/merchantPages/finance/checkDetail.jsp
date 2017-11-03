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
	
		function formSubmit(){
			$("#pageForm").submit();
		}
		
	</script>
</head>
<body>		
	<ol>
		<li class="rec">
			<h3>对账中心>>查看明细</h3>
			<form id="pageForm" action="${path}/merchant/finance/checkDetail" method="post"> 
				<input type="hidden" name="pageNo" id="pageNo">
				<div class="name">
					<p>支付状态：</p>
					<div class="pay">
					   <div class="pay">
						    <select id="status" name="status" value="${orderInfo.status}">
						       <option <c:if test="${orderInfo.status==''}">selected</c:if> value="">请选择</option>
						       <option <c:if test="${orderInfo.status=='1'}">selected</c:if> value="0">未确认</option>
							   <option <c:if test="${orderInfo.status=='1'}">selected</c:if> value="1">成功</option>
							   <option <c:if test="${orderInfo.status=='2'}">selected</c:if> value="2">失败</option>
							</select>
						</div>
					</div>
				</div>
				<div class="word">
					<div class="inquire">
						<p onclick="formSubmit();">查询</p>
					</div>
					
				</div>
			</form>
			<table border="0" cellspacing="0" cellpadding="0" class="tab_rec">
				<thead>
					<tr>
						<td>序号</td>
						<td>交易总净笔数/笔</td>
						<td>交易总净金额/元</td>
						<td>支付类型</td>
						<td>商户费率/%</td>
						<td>预计划账金额/元</td>
						
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>100</td>
						<td>100</td>
						<td>20</td>
						<td>20</td>
						<td>60</td>
						<td>59</td>
					</tr>
				</tbody>
			</table>
			<%@ include file="../include/page.jsp" %>
		</li>
	</ol>	

	
	<script src="${path}/resources/plugins/jquery/lyz.calendar.min.js" type="text/javascript"></script>
	
	</div>
</body>
</html>