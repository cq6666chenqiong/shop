<!doctype html>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../include/header.jsp" %>
<html lang="en">
<head>
	<%@ include file="../include/header.jsp" %>
	<link rel="stylesheet" href="${path}/resources/css/system.css">
</head>
<body>

	<div class="right">
		<!-- 角色管理 -->
		<div>
			<div class="role_wrap top">
				<div class="role_top">
					<h2>角色管理<span><a href="${path}/merchant/roleInfo/addRole" target="_self">添加角色</a></span></h2>
				</div>
				<div class="role_bottom">
					<table border="0" cellspacing="0" cellpadding="0" class="table">
						<tr>
							<th>角色名称</th>
							<th>角色描述</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${roleList}" var="role">
						<tr>
							<td>${role.roleName}</td>
							<td>${role.roleDesc}</td>
							<td><a href="${path}/merchant/roleInfo/editRole?id=${role.id}" target="_self">查看授权</a></td>
						</tr>
						</c:forEach>
					</table>
				</div>

			</div>
		</div>
	</div>

</body>
</html>