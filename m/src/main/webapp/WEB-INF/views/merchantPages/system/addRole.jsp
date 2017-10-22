<!doctype html>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
	<%@ include file="../include/header.jsp" %>
	<link rel="stylesheet" href="${path}/resources/css/system.css">
	<link rel="stylesheet" href="${path}/resources/js/treeTable/stylesheets/bootstrap.min.css">
	<link rel="stylesheet" href="${path}/resources/js/treeTable/stylesheets/jquery.treetable.css"/>
	<link rel="stylesheet" href="${path}/resources/js/treeTable/stylesheets/jquery.treetable.theme.default.css"/>

	<script type="text/javascript" src="${path}/resources/js/system.js"></script>

	<script type="text/javascript" src="${path}/resources/js/treeTable/javascripts/src/jquery.treetable.js"></script>
	<script type="text/javascript" src="${path}/resources/js/TableTree.js"></script>
	<script type="text/javascript" src="${path}/resources/js/Map.js"></script>
    <script type="text/javascript">

        $(function(){
            $("#resourceTreeTable").loadTreeTable({
                url:'/merchant/channelInfo/getChannelTree',
                checkBox:true,
                expandable: true
                ,parmaName:'resourceIds'
            });
            // 表单验证
            $("#inputForm").validate({
                rules: {
                    roleName: "required"
                },
                submitHandler: function(form) {
                    $.ajax({
                        url: "${path}/merchant/roleInfo/save",
                        global: false,
                        type: "POST",
                        dataType: "json",
                        data:{
                            roleName:$("#roleName").val(),
                            roleDesc:$("#roleDesc").val(),
                            resourceIds:$("#resourceIds").val()
                        },
                        async: false,
                        success: function (result) {
                            if (result.success) {
                                window.wxc.xcConfirm("操作成功。", window.wxc.xcConfirm.typeEnum.success);
                                window.setTimeout("window.location='${path}/merchant/roleInfo/list'",2000);
                                //window.location.href="${path}/roleInfo/list";
                            } else {
                                window.wxc.xcConfirm(result.message, window.wxc.xcConfirm.typeEnum.error);
                            }
                        }
                    });
                }
            });
            //表单验证end
            $.validator.addMethod("isPositive",function(value,element){
                var score = /^[0-9]*$/;
                return this.optional(element) || (score.test(value));
            },"请输入大于0的整数");

        });
        var contextPath = "<%=request.getContextPath()%>";
    </script>

</head>
<body>

	<div class="right">
		<!-- 角色管理 -->
		<div>
			<div class="role_append" style="display: block;">
                <form id="inputForm" action="${path}/merchant/roleInfo/save" method="post">
				<div class="role_top1">
					<h2>角色管理 > 添加角色</h2>
					<p>基础设置</p>
				</div>
				<ul class="role_nav">
					<li><span class="requiredField">*</span>角色名称: <input type="text" name="roleName" id="roleName" placeholder="请输入角色名称"> </li>
					<li><span class="requiredField">&nbsp;</span>角色描述: <input type="text" name="roleDesc" id="roleDesc" placeholder="请输入角色描述"> </li>
				</ul>
				<%--<div class="role_set">权限设置</div>--%>
				<input type="hidden" name="resourceIds" id="resourceIds">
				<div class="role_set_nav_wrap col-md-12" style="box-sizing: border-box;">
					<table id="resourceTreeTable" class="treetable treeTable_style" style="font-size:14px;background: white;">
						<thead style="font-size:14px">
						<tr>
							<th column="text"><label>资源名称</label></th>
							<th column="type"><label>资源类型</label></th>
							<th column="remark"><label>描述</label></th>
						</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
                    <input type="submit" value="保存" class="savebtn">
                    <input type="button" value="取消"  onclick="window.location.href='${path}/merchant/roleInfo/list'" class="canclebtn">
                </form>
			</div>

		</div>
	</div>

</body>
</html>