<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: wuyongtao
  Date: 2017/10/18
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <script type="text/javascript" src=${path}/resources/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="${path}/resources/javascript/common.js"></script>
    <script type="text/javascript" src="${path}/resources/javascript/shop.js"></script>
</head>
<body>

<div id="right">
    <ul>
        <li>
            <div id="addactivity" style="">
                <h2 style="margin-bottom:15px">活动码管理 > 添加活动码</h2>
                <div class="shopmsg shopselect" style="width:890px;margin-left:20px">
                    <p style="width:100px">选择门店：</p>
                    <div style="width:298px;background-position:268px 16px">
                        <p>请选择门店</p>
                        <ul style="width:298px">
                            <li>内圈科技</li>
                            <li>万能鸟</li>
                        </ul>
                    </div>
                </div>
                <div class="shopmsg staffselect" style="width:890px;margin-top:20px;margin-left:20px">
                    <p style="width:100px">活动码名称：</p>
                    <input type="text" placeholder="请输入活动码名称" style="width:298px">
                </div>
                <div class="shopmsg staffselect" style="width:890px;margin-top:20px;margin-left:20px">
                    <p style="width:100px">关联终端设备：</p>
                    <div style="width:298px;background-position:268px 16px">
                        <p>POS机</p>
                        <ul style="width:298px">
                            <li>POS机</li>
                            <li>云打印机</li>
                            <li>微收银</li>
                            <li>商亿</li>
                        </ul>
                    </div>
                </div>
                <div class="shopmsg staffselect" style="width:890px;margin-top:20px;margin-left:20px">
                    <p style="width:100px">所属位置：</p>
                    <input type="text" placeholder="请输入所属位置" style="width:298px">
                </div>
                <div class="save" style="float:left">
                    <input type="button" value="保存" class="savebtn">
                    <input type="button" value="取消" class="canclebtn">
                </div>
            </div>
        </li>
    </ul>
</div>
</body>
</html>
