<!DOCTYPE html>
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
    <title>智慧商街商户端 - 门店信息管理</title>
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/shop.css">
    <script type="text/javascript" src="${path}/resources/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="${path}/resources/javascript/common.js"></script>
    <script type="text/javascript" src="${path}/resources/javascript/shop.js"></script>
    <script type="text/javascript">
        function shopAdd(){
            location.href = "${path}/merchant/shopManage/shopAdd";
        }

    </script>
</head>
<body>

<div id="header"></div>
<div class="content clearfix">
    <div id="right">
        <ul>
            <li class="shopmanage">
                <div id="shopmanage">
                    <h2>门店管理</h2>
                    <form id="pageForm" action="${path}/merchant/shopManage/getShopList">
                        <input type="hidden" name="pageNo" id="pageNo">
                    <div class="shopdetail">
                        <div class="shopmsg shopnumber" style="margin-left:15px">
                            <p>门店名称：</p>
                            <input name="name" type="text" placeholder="请输入门店名称">
                        </div>
                        <div class="shopmsg shopnumber" style="margin-left:15px">
                            <p>门店编号：</p>
                            <input name="mchCode" type="text" placeholder="请输入门店单号">
                        </div>
                        <div class="shopmsg shopstate" style="margin-left:15px">
                            <p>门店状态：</p>
                                <p><select name="status">
                                    <option value="">请选择</option>
                                    <option value="0">初始</option>
                                    <option value="1">审核中</option>
                                    <option value="2">审核通过</option>
                                </select></p>
                        </div>
                    </div>
                    <div class="shopoperate">
                        <input type="submit" value="查询" class="shopcheck">
                        <input type="button" value="添加门店" class="shopadd" style="cursor:pointer" onclick="shopAdd();">
                    </div>
                    </form>
                    <table border="0" cellspacing="0" cellpadding="0">
                        <thead>
                        <td>门店编号</td>
                        <td>门店名称</td>
                        <td>门店地址</td>
                        <td>行业</td>
                        <td>状态</td>
                        <td>操作</td>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageBean.list }" var="merchant">
                        <tr>
                            <td>${merchant.mchCode}</td>
                            <td>${merchant.name}</td>
                            <td>${merchant.region}${merchant.county}${merchant.district}${merchant.address}</td>
                            <td>${merchant.businessType}</td>
                            <td>${merchant.status}</td>
                            <td>
                                <div>
                                    <p style="text-align:center;display:inline-block">编辑</p>
                                    <div class="editswitch" id="0">
                                        <div class="editoff"></div>
                                        <div class="editon"></div>
                                        <div class="editslide"></div>
                                    </div>
                                </div>
                                <p style="">终端设备管理<span>账号管理</span></p>
                                <p style="">门店收款码下载<span>查看</span></p>
                            </td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <%@ include file="../include/page.jsp" %>
                </div>
            </li>
        </ul>
    </div>
</div>
</body>
</html>