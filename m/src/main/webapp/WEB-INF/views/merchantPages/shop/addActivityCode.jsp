<!doctype html>
<%@ page language="java" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <%@ include file="../include/header.jsp" %>
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/shop.css">
    <script type="text/javascript" src="${path}/resources/javascript/shop.js"></script>

<script>
    function getDeviceList(){
        $("#deviceId option").remove();
        var $option1 = $("<option value=''>--请选择--</option>");
        $("#deviceId").append($option1);
        if($("#macCode").val()!=""){
            jQuery.ajax({type: "post",
                url:  "${path}/merchant/terminalDevice/getDeviceListByMacCode",
                async:false,
                data: {
                    "macCode":$("#macCode").val()
                },
                dataType:"json",
                success: function(message){
                    if(message.success){
                        var data=message.data;
                        if(data!=null && data.length>0){
                            for(var i=0;i<data.length;i++){
                                var id = data[i].id;
                                var name = data[i].name;
                                //添加到单位名称的下拉菜单中
                                var $option = $("<option></option>");
                                $option.attr("value",id);
                                $option.text(name);
                                $("#deviceId").append($option);
                            }
                        }
                    }else{
                        window.wxc.xcConfirm("操作失败", window.wxc.xcConfirm.typeEnum.error);
                    }
                }
            });
        }
    }
</script>
</head>
<body>

<div id="right">
    <ul>
        <li>
            <div id="addactivity" style="">
                <h2 style="margin-bottom:15px">活动码管理 > 添加活动码</h2>
                <div class="shopmsg shopselect" style="width:890px;margin-left:20px">
                    <p style="width:100px">选择门店：</p>
                    <select id="macCode" name="macCode" style="	height:40px;width:298px;border:1px solid #E7E7EB;padding-left:10px;box-sizing: border-box;" onchange="getDeviceList();">
                        <option value="">--请选择--</option>
                        <c:forEach items="${shopList}" var="shop">
                        <option value="${shop.mchCode}">${shop.shortName}</option>
                            </c:forEach>
                    </select>
                </div>
                <div class="shopmsg staffselect" style="width:890px;margin-top:20px;margin-left:20px">
                    <p style="width:100px">活动码名称：</p>
                    <input type="text" name="activityName" id="activityName" placeholder="请输入活动码名称" style="width:298px">
                </div>
                <div class="shopmsg staffselect" style="width:890px;margin-top:20px;margin-left:20px">
                    <p style="width:100px">关联终端设备：</p>
                    <select id="deviceId" name="deviceId" style="	height:40px;width:298px;border:1px solid #E7E7EB;padding-left:10px;box-sizing: border-box;">
                        <option value="">--请选择--</option>

                    </select>
                </div>
                <div class="shopmsg staffselect" style="width:890px;margin-top:20px;margin-left:20px">
                    <p style="width:100px">所属位置：</p>
                    <input type="text" name="position" id="position" placeholder="请输入所属位置" style="width:298px">
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
