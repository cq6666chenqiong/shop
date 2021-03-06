<!doctype html>
<%@ page language="java" pageEncoding="UTF-8" %>
<html lang="en">
<head>
	<%@ include file="../include/header.jsp" %>
	<link rel="stylesheet" href="${path}/resources/css/system.css">
	<script src="${path}/resources/js/system.js"></script>
</head>
<body>

	<div class="right">
		<!-- 角色管理 -->
		<div>
			<div class="role_wrap top">
				<div class="role_top">
					<h2>角色管理<span><a href="${path}/merchant/roleInfo/addRole" target="_self">添加角色</a></span></h2>
				</div>
				<form id="pageForm" action="${path}/merchant/roleInfo/list" method="post">
					<input type="hidden" name="pageNo" id="pageNo">
				</form>
				<div class="role_bottom">
					<table border="0" cellspacing="0" cellpadding="0" class="table">
						<tr>
							<th>角色名称</th>
							<th>类型</th>
							<th>角色描述</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${pageBean.list}" var="role">
							<tr>
								<td>${role.roleName}</td>
								<td>
									<c:if test="${role.roleType==1}">商戶</c:if>
									<c:if test="${role.roleType==2}">门店</c:if>
								</td>
								<td>${role.roleDesc}</td>
								<td><a href="${path}/merchant/roleInfo/editRole?id=${role.id}" target="_self">查看授权</a></td>
							</tr>
						</c:forEach>

					</table>
				</div>
				<%@ include file="../include/page.jsp" %>
<%--				<div class="foot">
					<span class="prev">&lt;上一页</span>
					<span>1</span>
					<span>2</span>
					<span>3</span>
					<span class="prev">下一页&gt;</span>
					<div><p>到第</p><span>3</span><p>页</p></div>
					<div><p>共<em>16</em>条记录</p></div>
				</div>--%>
			</div>
		</div>
	</div>

</body>
</html>