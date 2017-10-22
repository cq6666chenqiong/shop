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
		<!-- 账号管理 -->
		<div>
			<div class="admin_top top">
				<div class="admin_top">
					<h2>账号管理</h2>
				</div>
				<div class="admin_bottom">
					<ul  class="admin_bottom_nav">
						<li>门店名称:<input type="text" placeholder="请输入门店名称"></li>
						<li>手机号码:<input type="text" placeholder="请输入手机号称"></li>
						<li>姓名:<input type="text" placeholder="请输入姓名"></li>
						<li>账号类型:<input type="text" placeholder="商户">
							<div class="admin_bottom_select">
								
							</div>
						</li>
					</ul>
					<div class="admin_bottom_box">
						<div class="demand">查询</div>
						<div class="new_shop ">新增门店账号</div>
						<div class="new_admin">新增商户账号</div>
					</div>
					<table border="0" cellspacing="0" cellpadding="0" class="table">
						<tr>
							<th>手机号码</th>
							<th>姓名</th>
							<th>对应商户</th>
							<th>支付接入</th>
							<th>账号类型</th>
							<th>管理门店数/1</th>
							<th>操作</th>
						</tr>
						<tr>
							<td>6543298453</td>
							<td>旧城</td>
							<td>辣子鸡炒鸡店</td>
							<td>微信支付</td>
							<td>商户账号</td>
							<td>10</td>
							<td> <span>查看</span> <span>停用</span> <span>修改</span> <span>禁用</span></td>
						</tr>
					</table>
				</div>
			</div>
			<div class="rgba"></div>
			<div class="admin_wrap">
				<div class="admin_new_admin">
					<div class="admin_main">
						<div class="admin_main_top">
							<h2>账号管理 > 商户账号</h2>
						</div>
						<div class="admin_bottom">
							<ul  class="admin_bottom_nav1">
								<li class="admin_bottom_nav_one"><img src="../../images/system/img7.png" alt="">账户类型: <span>商户账号</span></li>
								<li>手机号:<input type="text" placeholder="请输入您的手机号称"></li>
								<li class="admin_bottom_nav_two">密码:<input type="text" placeholder="请输入您的密码"></li>
								<li>姓名:<input type="text" placeholder="请输入您的姓名"></li>
								<li>角色管理:<input type="text" placeholder="超级管理员">
									<div class="admin_bottom_select dmin_bottom_select1">
									
									</div>
								</li>
							</ul>
							<div class="admin_bottom_option">
								<h2>选择门店</h2>
								<div class="admin_bottom_option_box">
									<div class="admin_bottom_option_top">
										<div><img src="../../images/system/img8.png" alt=""></div>
										<span>已选列表</span>
										<span>已选中门(<a>1</a>)家</span>
									</div>
									<div class="admin_bottom_option_bottom">
										<p><a>全选</a>北京内圈科技有限公司<a></a></p>
									</div>
									<ul class="role_set_nav admin_bottom_option_nav">
										<li>
											<img src="../../images/system/img6.png" alt="">
											<a href="####">北京内圈科技有限公司</a>
											<ul class="role_set_nav role_set_nav4 admin_bottom_option_nav1">
												<li><a href="####">北京内圈科技有限公司</a></li>
												<li><a href="####">北京内圈科技有限公司</a></li>
											</ul>
										</li>
									</ul>
								</div>
							</div>
						</div>
						<span class="save">保存</span>
						<span class="abolish">取消</span>
					</div>
				</div>
				<div class="admin_new_admin1">
					<div class="admin_main">
						<div class="admin_main_top">
							<h2>账号管理 > 门户账号</h2>
						</div>
						<div class="admin_bottom">
							<ul  class="admin_bottom_nav1">
								<li class="admin_bottom_nav_one"><img src="../../images/system/img7.png" alt="">账户类型: <span>门户账号</span></li>
								<li>手机号:<input type="text" placeholder="请输入您的手机号称"></li>
								<li class="admin_bottom_nav_two">密码:<input type="text" placeholder="请输入您的密码"></li>
								<li>姓名:<input type="text" placeholder="请输入您的姓名"></li>
								<li>角色管理:<input type="text" placeholder="超级管理员">
									<div class="admin_bottom_select dmin_bottom_select1">
									
									</div>
								</li>
							</ul>
							<div class="admin_bottom_option">
								<h2>选择门店</h2>
								<div class="admin_bottom_option_box">
									<div class="admin_bottom_option_top">
										<div><img src="../../images/system/img8.png" alt=""></div>
										<span>已选列表</span>
										<span>已选中门(<a>1</a>)家</span>
									</div>
									<div class="admin_bottom_option_bottom">
										<p><a>全选</a>北京内圈科技有限公司<a class="pic2"></a></p>
									</div>
									<ul class="role_set_nav admin_bottom_option_nav">
										<li>
											<img src="../../images/system/img6.png" alt="">
											<a href="####">北京内圈科技有限公司</a>
											<ul class="role_set_nav role_set_nav4 admin_bottom_option_nav1">
												<li><a href="####">北京内圈科技有限公司</a></li>
												<li><a href="####">北京内圈科技有限公司</a></li>
											</ul>
										</li>
									</ul>
								</div>
							</div>
						</div>
						<span class="save">保存</span>
						<span class="abolish">取消</span>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>