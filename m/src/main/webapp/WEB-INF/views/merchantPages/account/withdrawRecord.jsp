<!doctype html>
<%@ page language="java" pageEncoding="UTF-8" %>
<html lang="en">
<head>
	<%@ include file="../include/header.jsp" %>
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/style.css">
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/account.css">
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/lyz.calendar.css">
	<script type="text/javascript" src="${path}/resources/js/account.js"></script>
	<script type="text/javascript" src="${path}/resources/time/js/laydate.js"></script>

</head>
<body>
	
	<div class="main_wrap" >
		<div class="title">提现记录</div>
		<ul class="recordd">
			<li class="recordd_color">全部提现</li>
<%--			<li>营销账户余额</li>
			<li>累计消耗金额</li>--%>
		</ul>
		<input type="hidden"  id="today" value="${today}">
		<input type="hidden"  id="yesterday" value="${yesterday}">
		<input type="hidden"  id="sevenDayStart" value="${sevenDayStart}">
		<input type="hidden"  id="sevenDayEnd" value="${sevenDayEnd}">
		<input type="hidden"  id="monthStart" value="${monthStart}">
		<input type="hidden"  id="monthDayEnd" value="${monthDayEnd}">
		<form id="pageForm" action="${path}/merchant/fundAccount/withdrawRecord" method="post">
			<input type="hidden" name="pageNo" id="pageNo">
			<input type="hidden" name="timeType" id="timeType" value="${searchCondition.timeType}">
		<div class="deal_time">
			<div>
				<em>时间：</em>
				<span class="<c:if test='${searchCondition.timeType==1}'>ti</c:if> ts" timeType="1">今天</span>
				<span class="<c:if test='${searchCondition.timeType==2}'>ti</c:if> ts" timeType="2">昨天</span>
				<span class="<c:if test='${searchCondition.timeType==3}'>ti</c:if> ts" timeType="3">最近7天</span>
				<span class="<c:if test='${searchCondition.timeType==4}'>ti</c:if> ts" timeType="4">最近30天</span>
				<div class="plug_in">
					<p class="start_time m_rq">
						<%--<input id="txtBeginDate" class="m_riqi" placeholder="选择日期"/>--%>
						<input id="startTime" name="startTime" class="laydate-icon m_riqi" placeholder="开始日期" value="<fmt:formatDate value="${searchCondition.startTime}" pattern="yyyy-MM-dd" />" />
					</p>
					<i class="jg">至</i>
					<p class="end_time m_rq">
						<%--<input id="txtEndDate" class="m_riqi" placeholder="结束日期"/>--%>
						<input id="endTime" name="endTime" class="laydate-icon m_riqi"  placeholder="结束日期" value="<fmt:formatDate value="${searchCondition.endTime}" pattern="yyyy-MM-dd" />" />
					</p>
				</div>
			</div>
		</div>

		<div class="mold">
			<div class="mold_left">提现类型:</div>
			<select name="withdrawType" id="withdrawType" style="width:150px;">
				<option value="">--请选择--</option>
				<option value="1" <c:if test="${searchCondition.withdrawType==1}">selected</c:if> >余额提现</option>
				<option value="2" <c:if test="${searchCondition.withdrawType==2}">selected</c:if>>实时提现</option>
			</select>
		</div>
		<div class="demand">
			<input type="button" value="查询" onclick="$('#pageForm').submit();">
		</div>
		</form>
		<div class="particulars">提现明细 <span>提现记录${sumAmount}元， 提现记录${pageBean.totalCount}次</span> </div>
		<table cellpadding="0" cellspacing="0" class="table">
            <thead>
                <tr>
                    <td>创建时间</td>
                    <td>交易时间</td>
                    <td>流水号</td>
                    <td>提现金额/元</td>
                    <td>提现账户</td>
                    <td>提现手续费/元</td>
                    <td>提现类型</td>
                    <td>操作人</td>
                    <td>状态</td>
                </tr>
            </thead>
            <tbody>
			<c:forEach items="${pageBean.list}" var="withdrawRecord">
            	<tr>
	            	<td style="width: 100px;"><fmt:formatDate value="${withdrawRecord.createTime}" pattern="yyyy/MM/dd HH:mm:ss" /></td>
					<td style="width: 100px;"><fmt:formatDate value="${withdrawRecord.tradeTime}" pattern="yyyy/MM/dd HH:mm:ss" /></td>
					<td>${withdrawRecord.businessNo}</td>
					<td>${withdrawRecord.amount}</td>
					<td>
						<c:if test="${withdrawRecord.withdrawAccount==1}">银行卡</c:if>
						<c:if test="${withdrawRecord.withdrawAccount==2}">营销账户</c:if>
					</td>
					<td>${withdrawRecord.fee}</td>
					<td>
						<c:if test="${withdrawRecord.withdrawType==1}">余额提现</c:if>
						<c:if test="${withdrawRecord.withdrawType==2}">实时提现</c:if>
					</td>
					<td>${withdrawRecord.operatorName}</td>
					<td>
						<c:if test="${withdrawRecord.status==0}">处理中</c:if>
						<c:if test="${withdrawRecord.status==1}">提现成功</c:if>
						<c:if test="${withdrawRecord.status==2}">提现失败</c:if>
					</td>
				</tr>
			</c:forEach>
            </tbody>
        </table>
		<%@ include file="../include/page.jsp" %>
<%--        <div class="page_wrap">
        	<ul class="page1">
        		<li class="prev"> < 上一页</li>
        		<li class="page_color">1</li>
        		<li class="page_color">2</li>
        		<li class="page_color">3</li>
        		<li class="next">下一页 > </li>
        	</ul>
        	<p class="page2"><em>到第</em> <span>3</span> <i>页</i></p>
        	<p class="page3">共 <span>	16条</span> 记录</p>
        </div>--%>
	</div>
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