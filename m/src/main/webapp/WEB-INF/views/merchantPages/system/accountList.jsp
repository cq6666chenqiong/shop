<!doctype html>
<%@ page language="java" pageEncoding="UTF-8" %>
<html lang="en">
<head>
	<%@ include file="../include/header.jsp" %>
	<link rel="stylesheet" href="${path}/resources/css/system.css">
	<script src="${path}/resources/js/system.js"></script>
	<script>
		function setMerchantAccountStatus(merchantAccountId,status,tips){
            window.wxc.xcConfirm('确定要'+ tips +'吗?', window.wxc.xcConfirm.typeEnum.confirm, {
                title: '提示'
                , onOk: function () {
                    $.ajax({
                        url: "${path}/merchant/merchantAccount/setMerchantAccountStatus",
                        global: false,
                        type: "POST",
                        dataType: "json",
                        data:{
                            merchantAccountId:merchantAccountId,
                            status:status
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
                },
            });

		}

        function deleteMerchantAccount(merchantAccountId){
            window.wxc.xcConfirm('确定要刪除吗?', window.wxc.xcConfirm.typeEnum.confirm, {
                title: '提示'
                , onOk: function () {
                    $.ajax({
                        url: "${path}/merchant/merchantAccount/delete",
                        global: false,
                        type: "POST",
                        dataType: "json",
                        data:{
                            id:merchantAccountId
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
                },
            });

        }

        function toAddAccout(type) {
            window.location.href="${path}/merchant/merchantAccount/toAddAccount?type="+type;
        }
        function toEditAccount(id,accountType) {
            window.location.href="${path}/merchant/merchantAccount/toEditAccount?id="+id+"&type="+accountType;
        }
        function search(){
            $("#pageForm").submit();
		}
	</script>
</head>
<body>
	

	<div class="right">	
		<!-- 账号管理 -->
		<div style="height: 830px;">
			<div class="admin_top top">
				<div class="admin_top">
					<h2>账号管理</h2>
				</div>
				<div class="admin_bottom">
					<form id="pageForm" action="${path}/merchant/merchantAccount/accountList" method="post">
						<input type="hidden" name="pageNo" id="pageNo">
					<ul  class="admin_bottom_nav">
						<li>门店名称:<input type="text" name="shopName" id="shopName" placeholder="请输入门店名称" value="${searchCondition.shopName}"></li>
						<li>手机号码:<input type="text" name="phone" id="phone" placeholder="请输入手机号称" value="${searchCondition.phone}"></li>
						<li>姓名:<input type="text" name="name" id="name" placeholder="请输入姓名" value="${searchCondition.name}"></li>
						<li>账号类型:&nbsp;&nbsp;
							<select name="accountType" id="accountType" style="height:40px;width:150px;border:1px solid #E7E7EB;">
								<option value="">--请选择--</option>
								<option value="1" <c:if test="${searchCondition.accountType==1}">selected</c:if> >商户</option>
							   <option value="2" <c:if test="${searchCondition.accountType==2}">selected</c:if>>门店</option>
						    </select>
							<div class="admin_bottom_select">

							</div>
						</li>
					</ul>
					<div class="admin_bottom_box">
						<div class="demand" onclick="search();">查询</div>
						<div class="new_shop" onclick="toAddAccout(2);">新增门店账号</div>
						<div class="new_admin" onclick="toAddAccout(1);">新增商户账号</div>
					</div>
					</form>
					<table border="0" cellspacing="0" cellpadding="0" class="table">
						<tr>
							<th>真实姓名</th>
							<th>登陆账号</th>
							<th>账号类型</th>
							<th>所属角色</th>
							<th>管理门店数/个</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${pageBean.list}" var="merchantAccount">
						<tr>
							<td>${merchantAccount.name}</td>
							<td>${merchantAccount.account}</td>
							<td>
								<c:if test="${merchantAccount.accountType==1}">商戶</c:if>
								<c:if test="${merchantAccount.accountType==2}">门店</c:if>
							</td>
							<td>${merchantAccount.roleNames}</td>
							<td>shopNum</td>
							<td>
								<c:if test="${merchantAccount.status==0}">禁用</c:if>
								<c:if test="${merchantAccount.status==1}">启用</c:if>
							</td>
							<td>
								<c:if test="${merchantAccount.status==1}"><span onclick="setMerchantAccountStatus(${merchantAccount.id},0,'停用');">停用</span> </c:if>
								<c:if test="${merchantAccount.status==0}"><span onclick="setMerchantAccountStatus(${merchantAccount.id},1,'启用');">启用</span> </c:if>
								<span onclick="toEditAccount(${merchantAccount.id},${merchantAccount.accountType});">修改</span>
								<span onclick="deleteMerchantAccount(${merchantAccount.id});">删除</span></td>
						</tr>
						</c:forEach>
					</table>
					<%@ include file="../include/page.jsp" %>
				</div>
			</div>

		</div>
	</div>


</body>
</html>