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
</head>
<body>

<div id="right">
    <ul>
        <li>
            <div id="facilitymanage">
                <h2>终端设备管理</h2>
                <div class="shopdetail">
                    <div class="shopmsg shopname">
                        <p>门店名称：</p>
                        <input type="text" placeholder="请输入门店名称" style="width:228px">
                    </div>
                    <div class="shopmsg shopnumber" style="margin-left:15px">
                        <p>门店编号：</p>
                        <input type="text" placeholder="请输入门店单号" style="width:228px">
                    </div>
                </div>
                <div class="shopoperate">
                    <input type="button" value="查询" class="shopcheck">
                    <input type="button" value="添加设备" class="shopadd addfacility" style="cursor:pointer">
                </div>
                <table border="0" cellspacing="0" cellpadding="0">
                    <thead>
                    <td style="width:31px">序号</td>
                    <td style="width:93px">门店名称</td>
                    <td style="width:81px">设备名称</td>
                    <td style="width:30px">款台编号</td>
                    <td style="width:47px">款台秘钥</td>
                    <td style="width:57px">放置位置</td>
                    <td style="width:88px">关联活动码/个</td>
                    <td style="width:58px">激活时间</td>
                    <td style="width:131px">操作</td>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>朝阳区第二分店朝阳区第二分店</td>
                        <td>POS机1</td>
                        <td>1122233</td>
                        <td>1234</td>
                        <td>吧台</td>
                        <td>1</td>
                        <td>2019/09/09</td>
                        <td>
                            <p style="text-align:center">修改</p>
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
            <div id="addfacility" style="display:none">
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
                    <p style="width:100px">设备类型：</p>
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
                <ul class="staffselectnav">
                    <li>
                        <div class="shopmsg staffselect" style="width:890px;margin-top:20px;margin-left:20px">
                            <p style="width:100px">POS机名称：</p>
                            <input type="text" placeholder="请输入POS机名称" style="width:298px">
                        </div>
                        <div class="shopmsg staffselect" style="width:890px;margin-top:20px;margin-left:20px">
                            <p style="width:100px">设备编号：</p>
                            <input type="text" placeholder="请输入设备" style="width:298px">
                        </div>
                        <div class="shopmsg staffselect" style="width:890px;margin-top:20px;margin-left:20px">
                            <p style="width:100px">放置位置：</p>
                            <input type="text" placeholder="请输入放置位置" style="width:298px">
                        </div>
                    </li>
                    <li>
                        <div class="shopmsg staffselect" style="width:890px;margin-top:20px;margin-left:20px">
                            <p style="width:100px">设备ID：</p>
                            <input type="text" placeholder="请输入设备ID" style="width:298px">
                        </div>
                        <div class="shopmsg staffselect" style="width:890px;margin-top:20px;margin-left:20px">
                            <p style="width:100px">设备秘钥：</p>
                            <input type="text" placeholder="请输入设备秘钥" style="width:298px">
                        </div>
                        <div class="shopmsg staffselect" style="width:890px;margin-top:20px;margin-left:20px">
                            <p style="width:100px">放置位置：</p>
                            <input type="text" placeholder="请输入放置位置" style="width:298px">
                        </div>
                    </li>
                    <li>
                        <div class="shopmsg staffselect" style="width:890px;margin-top:20px;margin-left:20px">
                            <p style="width:100px">款台秘钥：</p>
                            <input type="text" placeholder="请输入款台秘钥" style="width:298px">
                        </div>
                    </li>
                    <li>
                        <div class="shopmsg staffselect" style="width:890px;margin-top:20px;margin-left:20px">
                            <p style="width:100px">款台秘钥：</p>
                            <input type="text" placeholder="请输入款台秘钥" style="width:298px">
                        </div>
                    </li>
                </ul>
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
