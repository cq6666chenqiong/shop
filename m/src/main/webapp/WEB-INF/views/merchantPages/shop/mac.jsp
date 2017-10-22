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
    <script type="text/javascript">
        function macAdd(){
            location.href = "${path}/merchant/merchantActivityCodeManage/macAdd";
        }
    </script>
</head>
<body>

<div id="right">
    <ul>
        <li>
            <div id="activitycode">
                <h2>活动码管理</h2>
                <div class="shopdetail">
                    <div class="shopmsg activeshopname">
                        <p>门店名称：</p>
                        <input type="text" placeholder="请输入门店名称">
                    </div>
                    <div class="shopmsg activefacility" style="margin-left:15px">
                        <p>关联设备：</p>
                        <input type="text" placeholder="请输入关联设备">
                    </div>
                </div>
                <div class="shopoperate">
                    <input type="button" value="查询" class="shopcheck">
                    <input type="button" value="添加活动码" class="shopadd addactivitycode" style="cursor:pointer" onclick="macAdd();">
                </div>
                <table border="0" cellspacing="0" cellpadding="0">
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
                    <tr>
                        <td>1</td>
                        <td>朝阳区第二分店朝阳区第二分店</td>
                        <td>一楼1号桌</td>
                        <td>4783948574</td>
                        <td>POS机</td>
                        <td>2018/09/09 09:00:00</td>
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
                    </tbody>
                </table>
                <div class="shopbottom">
                    <p class="pagenumber">共<span>16条</span>记录</p>
                    <ul>
                        <li class="prevpage"><span><</span>上一页</li>
                        <li class="cur">1</li>
                        <li>2</li>
                        <li>3</li>
                        <li class="pagejump">到第<span>3</span>页</li>
                        <li class="nextpage">下一页<span>></span></li>
                    </ul>
                </div>
            </div>
        </li>
    </ul>
</div>
</body>
</html>
