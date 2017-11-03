<!doctype html>
<%@ page language="java" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <%@ include file="../include/header.jsp" %>
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/shop.css">
    <script type="text/javascript" src="${path}/resources/javascript/shop.js"></script>

    <script type="text/javascript">
        function toAddActivityCode(){
            location.href = "${path}/merchant/activityCode/toAddActivityCode";
        }
    </script>
</head>
<body>

<div id="right">
    <ul>
        <li>
            <!-- 活动码管理 -->
            <div id="activitycode">
                <h2>活动码管理</h2>
                <form id="pageForm" action="${path}/merchant/activityCode/getActivityCodeList" method="post">
                    <input type="hidden" name="pageNo" id="pageNo">
                <div class="shopdetail">
                    <div class="shopmsg activeshopname">
                        <p>门店名称：</p>
                        <input type="text" name="shopName" value="${searchCondition.shopName}" placeholder="请输入门店名称">
                    </div>
                    <div class="shopmsg activefacility" style="margin-left:15px">
                        <p>关联设备：</p>
                        <input type="text" name="deviceName" value="${searchCondition.deviceName}" placeholder="请输入关联设备">
                    </div>
                </div>
                <div class="shopoperate">
                    <input type="button" value="查询" class="shopcheck"  onclick="$('#pageForm').submit();">
                    <input type="button" value="添加活动码" class="shopadd addactivitycode" style="cursor:pointer" onclick="toAddActivityCode();">
                </div>
                </form>
                <table border="0" cellspacing="0" cellpadding="0" class="table_one">
                    <thead>
                    <td style="width:31px">序号</td>
                    <td style="width:177px">门店名称</td>
                    <td style="width:89px">活动码名称</td>
                    <td style="width:85px">活动码编号</td>
                    <td style="width:64px">关联设备</td>
                    <td style="width:91px">创建时间</td>
                    <td style="width:163px">操作</td>
                    </thead>
                    <tbody>
<c:forEach items="${pageBean.list}" var="activityCode" varStatus="status">
                    <tr>
                        <td>${status.index+1}</td>
                        <td>${activityCode.shopName}</td>
                        <td>${activityCode.activityName}</td>
                        <td>${activityCode.activityCode}</td>
                        <td>${activityCode.deviceName}</td>
                        <td>${activityCode.cTime}</td>
                        <td>
                            <p style="width:180px;text-indent:20px">修改<span>下载活动码</span></p>
                            <div>
                                <p style="text-align:center;display:inline-block">启动/禁用</p>
                                <div class="editswitch" id="0">
                                    <div class="editoff"></div>
                                    <div class="editon"></div>
                                    <div class="editslide"></div>
                                </div>
                            </div>
                        </td>
                    </tr>
</c:forEach>
                    </tbody>
                </table>
                <%@ include file="../include/page.jsp" %>
<%--                <div class="shopbottom">
                    <p class="pagenumber">共<span>16条</span>记录</p>
                    <ul>
                        <li class="prevpage"><span><</span>上一页</li>
                        <li class="cur">1</li>
                        <li>2</li>
                        <li>3</li>
                        <li class="pagejump">到第<span>3</span>页</li>
                        <li class="nextpage">下一页<span>></span></li>
                    </ul>
                </div>--%>
            </div>
        </li>
    </ul>
</div>

</body>
</html>
