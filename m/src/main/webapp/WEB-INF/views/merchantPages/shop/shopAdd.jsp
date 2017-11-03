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
<html>
<head>
    <title>智慧商街商户端 - 门店信息管理</title>
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/shop.css">
    <script type="text/javascript" src="${path}/resources/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="${path}/resources/js/jquery.validate.js"></script>
    <script type="text/javascript" src="${path}/resources/javascript/common.js"></script>
    <script type="text/javascript" src="${path}/resources/javascript/shop.js"></script>
    <script type="text/javascript" src="${path}/resources/js/card.js"></script>
    <script>

        jQuery.extend(jQuery.validator.messages, {
            remote: "请修正该字段",
             email: "请输入正确格式的电子邮件",
             url: "请输入合法的网址",
             date: "请输入合法的日期",
             dateISO: "请输入合法的日期 (ISO).",
             number: "请输入合法的数字",
             digits: "只能输入整数",
             creditcard: "请输入合法的信用卡号",
            equalTo: "请再次输入相同的值",
            accept: "请输入拥有合法后缀名的字符串",
            maxlength: jQuery.validator.format("请输入一个长度最多是 {0} 的字符串"),
            minlength: jQuery.validator.format("请输入一个长度最少是 {0} 的字符串"),
            rangelength: jQuery.validator.format("请输入一个长度介于 {0} 和 {1} 之间的字符串"),
            range: jQuery.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
            max: jQuery.validator.format("请输入一个最大为 {0} 的值"),
            min: jQuery.validator.format("请输入一个最小为 {0} 的值")
        });


        $(function(){
            $("select[name='region']").change(function() {
                //被选中的option
                var selected_value = $(this).val();
                $("select[name='county']").empty();
                $("select[name='district']").empty();

                if(selected_value != ''){
                    $.ajax({
                        type : "POST",
                        url: "/merchant/areaInfo/getAreaList",
                        data:{parentId:selected_value},
                        success: function(data){
                            var defautOption = "<option value=''>请选择</option>"
                            $("select[name='county']").append(defautOption);
                            for(var i=0;i<data.length;i++){
                                var option = $("<option>").val(data[i].id).text(data[i].name);
                                $("select[name='county']").append(option);

                            }
                        }});
                }
            });

            $("select[name='county']").change(function() {
                //被选中的option
                var selected_value = $(this).val();
                $("select[name='district']").empty();
                if(selected_value != ''){
                    $.ajax({
                        type : "POST",
                        url: "/merchant/areaInfo/getAreaList",
                        data:{parentId:selected_value},
                        success: function(data){
                            var defautOption = "<option value=''>请选择</option>"
                            $("select[name='district']").append(defautOption);
                            for(var i=0;i<data.length;i++){
                                var option = $("<option>").val(data[i].id).text(data[i].name);
                                $("select[name='district']").append(option);

                            }
                        }});
                }
            });
            $("#inputForm").validate({
                rules: {
                    name: "required",
                    shortName:"required",
                    region:"required",
                    contactPhone:{required:true,isTel:true},
                    contactsPersonName:"required",
                    contactsPersonPhone:{required:true,isMobile:true},
                    address:"required",
                    lon:"digits",
                    lat:"digits",
                    accountName:"required",
                },
                submitHandler: function(form) {
                    form.submit();
                }
            });

            jQuery.validator.addMethod("isTel", function(value, element) {
                var tel = /^\d{3,4}-?\d{7,9}$/; //电话号码格式010-12345678
                return this.optional(element) || (tel.test(value));
            }, "请正确填写电话号码");

            jQuery.validator.addMethod("isMobile", function(value, element) {
                var length = value.length;
                var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;
                return this.optional(element) ||(length == 11 && mobile.test(value));
            }, "请正确填写手机号码");

            //表单验证end
            $.validator.addMethod("isPositive",function(value,element){
                var score = /^[0-9]*$/;
                return this.optional(element) || (score.test(value));
            },"请输入正确的编号");

            jQuery.validator.addMethod("isIdCardNo", function(value, element) {
                return this.optional(element) || idCardNoUtil.checkIdCardNo(value);
            }, "请正确输入正确的身份证号码");
            jQuery.validator.addMethod("isIdCardNo", function(value, element) {
                return this.optional(element) || idCardNoUtil.checkIdCardNo(value);
            }, "请正确输入正确的身份证号码");
            jQuery.validator.addMethod("isDate", function(value, element){
               var ereg = /^(\d{1,4})(-|\/)(\d{1,2})(-|\/)(\d{1,2})$/;
               var r = value.match(ereg);
                    if (r == null) {
                            return false;
                        }
                    var d = new Date(r[1], r[3] - 1, r[5]);
                    var result = (d.getFullYear() == r[1] && (d.getMonth() + 1) == r[3] && d.getDate() == r[5]);

                    return this.optional(element) || (result);
                }, "请输入正确的日期");


        });

    </script>
    <script>
        function checkissame(){
            var issamevalue = $('input[name="issame"]:checked').val();
            if(issamevalue == 0){
                 $("#submitbutton").hide();
                 $("#nextbutton").show();
                 $("#legadiv").show();
                 //增加校验规则
                $("#legalPersonName").rules("add",{required:true});
                $("#legalPersonTel").rules("add",{required:true,isMobile:true});
                $("#bossIdNo").rules("add",{required:true,isIdCardNo:true});
                $("#bossEdate").rules("add",{required:true,isDate:true});
                $("#blMerchantName").rules("add",{required:true});
                $("#blEdate").rules("add",{required:true,isDate:true});
                $("#blNo").rules("add",{required:true,isPositive:true});
            }else{
                $("#submitbutton").show();
                $("#nextbutton").hide();
                $("#legadiv").hide();

                //去除校验规则
                $("#legalPersonName").rules("remove");
                $("#legalPersonTel").rules("remove");
                $("#bossIdNo").rules("remove");
                $("#bossEdate").rules("remove");
                $("#blMerchantName").rules("remove");
                $("#blEdate").rules("remove");
                $("#blNo").rules("remove");
            }
        }

        function checkispublic(){
            var accountTypeValue = $('input[name="accountType"]:checked').val();
            if(accountTypeValue == 0){
                $("#legalpersondiv").show();
                $("#idnodiv").show();
                $("#bosspositivedl").show();
                $("#bossbackdl").show();
                $("#accountpic1dl").show();
                $("#accountpic2dl").show();
                $("#licencedl").hide();
                $("#idNo").rules("add",{required:true,isIdCardNo:true});

            }else{
                $("input[name='accountIdentityType']").get(0).checked = true;
                $("#legalpersondiv").hide();
                $("#idnodiv").hide();
                $("#bosspositivedl").hide();
                $("#bossbackdl").hide();
                $("#accountpic1dl").hide();
                $("#accountpic2dl").hide();
                $("#licencedl").show();
                $("#idNo").rules("remove");
            }
        }

        function checkisboss(){
            var accountIdentityTypeValue = $('input[name="accountIdentityType"]:checked').val();
            if(accountIdentityTypeValue == 0){
                $("#bosspositivedl").hide();
                $("#bossbackdl").hide();
            }else{
                $("#bosspositivedl").show();
                $("#bossbackdl").show();
            }
        }

        $(document).ready(function() {
            $("#nextbut").click(function () {
                if($("#inputForm").valid()){

                    $("#accountName").rules("add",{required:true});
                    $("#bankName").rules("add",{required:true});
                    $("#bankBranch").rules("add",{required:true});
                    $("#bankNo").rules("add",{required:true,isPositive:true});
                    $("#accountNo").rules("add",{required:true,isPositive:true});
                    $("#weixinSettleRate").rules("add",{required:true});
                    $("#zhifubaoSettleRate").rules("add",{required:true});
                    $("#qqqianbaoSettleRate").rules("add",{required:true});
                    $("#jdqianbaoSettleRate").rules("add",{required:true});
                    $("#yinlianSettleRate").rules("add",{required:true});




                    $("#addshop").hide();
                    $("#shopaccountno").show();
                    $("#submitbutton").show();
                    $("#nextbutton").hide();
                }
            });
        });

    </script>
</head>
<body>

<div id="header"></div>
<form id="inputForm" name="inputForm" action="/merchant/shopManage/shopAddSave" method="post">
    <div id="right">
        <ul>
            <li class="shopmanage">
                <div id="addshop">
                    <h2>门店管理 > 添加门店</h2>
                    <p>基本信息</p>
                    <div class="shopbasemsg">
                        <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:20px">
                            <p><span class="requiredField">*</span>门店全称：</p>
                            <input type="text" name="name" id="name" placeholder="请输入门店全称" style="width:298px;background-position:268px 16px">
                        </div>
                        <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:100px">
                            <p><span class="requiredField">*</span>门店简称：</p>
                            <input type="text" name="shortName" id="shortName" placeholder="请输入门店简称" style="width:298px;background-position:268px 16px">
                        </div>
                        <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:20px">
                            <p><span class="requiredField">*</span>门店电话：</p>
                            <input type="text" name="contactPhone" id="contactPhone" placeholder="请输入门店电话" style="width:298px;background-position:268px 16px">
                        </div>
                        <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:100px">
                            <p><span class="requiredField">*</span>营业时间：</p>
                            <div style="width:118px;background-position:268px 16px">
                                <p><select name="businessStarttimeHour">
                                    <option value="0">00</option>
                                    <option value="1">01</option>
                                    <option value="2">02</option>
                                    <option value="3">03</option>
                                    <option value="4">04</option>
                                    <option value="5">05</option>
                                    <option value="6">06</option>
                                    <option value="7">07</option>
                                    <option value="8">08</option>
                                    <option value="9">09</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                    <option value="13">13</option>
                                    <option value="14">14</option>
                                    <option value="15">15</option>
                                    <option value="16">16</option>
                                    <option value="17">17</option>
                                    <option value="18">18</option>
                                    <option value="19">19</option>
                                    <option value="20">20</option>
                                    <option value="21">21</option>
                                    <option value="22">22</option>
                                    <option value="23">23</option>
                                </select>:<select name="businessStarttimeMin">
                                    <option value="0">00</option>
                                    <option value="1">01</option>
                                    <option value="2">02</option>
                                    <option value="3">03</option>
                                    <option value="4">04</option>
                                    <option value="5">05</option>
                                    <option value="6">06</option>
                                    <option value="7">07</option>
                                    <option value="8">08</option>
                                    <option value="9">09</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                    <option value="13">13</option>
                                    <option value="14">14</option>
                                    <option value="15">15</option>
                                    <option value="16">16</option>
                                    <option value="17">17</option>
                                    <option value="18">18</option>
                                    <option value="19">19</option>
                                    <option value="20">20</option>
                                    <option value="21">21</option>
                                    <option value="22">22</option>
                                    <option value="23">23</option>
                                    <option value="24">24</option>
                                    <option value="25">25</option>
                                    <option value="26">26</option>
                                    <option value="27">27</option>
                                    <option value="28">28</option>
                                    <option value="29">29</option>
                                    <option value="30">30</option>
                                    <option value="31">31</option>
                                    <option value="32">32</option>
                                    <option value="33">33</option>
                                    <option value="34">34</option>
                                    <option value="35">35</option>
                                    <option value="36">36</option>
                                    <option value="37">37</option>
                                    <option value="38">38</option>
                                    <option value="39">39</option>
                                    <option value="40">40</option>
                                    <option value="41">41</option>
                                    <option value="42">42</option>
                                    <option value="43">43</option>
                                    <option value="44">44</option>
                                    <option value="45">45</option>
                                    <option value="46">46</option>
                                    <option value="47">47</option>
                                    <option value="48">48</option>
                                    <option value="49">49</option>
                                    <option value="50">50</option>
                                    <option value="51">51</option>
                                    <option value="52">52</option>
                                    <option value="53">53</option>
                                    <option value="54">54</option>
                                    <option value="55">55</option>
                                    <option value="56">56</option>
                                    <option value="57">57</option>
                                    <option value="58">58</option>
                                    <option value="59">59</option>
                                </select></p>
                                <div class="upper"></div>
                                <div class="lower"></div>
                            </div>
                            <span>至</span>
                            <div style="width:118px;background-position:268px 16px">
                                <p><select name="businessEndtimeHour">
                                    <option value="0">00</option>
                                    <option value="1">01</option>
                                    <option value="2">02</option>
                                    <option value="3">03</option>
                                    <option value="4">04</option>
                                    <option value="5">05</option>
                                    <option value="6">06</option>
                                    <option value="7">07</option>
                                    <option value="8">08</option>
                                    <option value="9">09</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                    <option value="13">13</option>
                                    <option value="14">14</option>
                                    <option value="15">15</option>
                                    <option value="16">16</option>
                                    <option value="17">17</option>
                                    <option value="18">18</option>
                                    <option value="19">19</option>
                                    <option value="20">20</option>
                                    <option value="21">21</option>
                                    <option value="22">22</option>
                                    <option value="23">23</option>
                                    <option value="24">24</option>
                                </select>:<select name="businessEndtimeMin">
                                    <option value="0">00</option>
                                    <option value="1">01</option>
                                    <option value="2">02</option>
                                    <option value="3">03</option>
                                    <option value="4">04</option>
                                    <option value="5">05</option>
                                    <option value="6">06</option>
                                    <option value="7">07</option>
                                    <option value="8">08</option>
                                    <option value="9">09</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                    <option value="13">13</option>
                                    <option value="14">14</option>
                                    <option value="15">15</option>
                                    <option value="16">16</option>
                                    <option value="17">17</option>
                                    <option value="18">18</option>
                                    <option value="19">19</option>
                                    <option value="20">20</option>
                                    <option value="21">21</option>
                                    <option value="22">22</option>
                                    <option value="23">23</option>
                                    <option value="24">24</option>
                                    <option value="25">25</option>
                                    <option value="26">26</option>
                                    <option value="27">27</option>
                                    <option value="28">28</option>
                                    <option value="29">29</option>
                                    <option value="30">30</option>
                                    <option value="31">31</option>
                                    <option value="32">32</option>
                                    <option value="33">33</option>
                                    <option value="34">34</option>
                                    <option value="35">35</option>
                                    <option value="36">36</option>
                                    <option value="37">37</option>
                                    <option value="38">38</option>
                                    <option value="39">39</option>
                                    <option value="40">40</option>
                                    <option value="41">41</option>
                                    <option value="42">42</option>
                                    <option value="43">43</option>
                                    <option value="44">44</option>
                                    <option value="45">45</option>
                                    <option value="46">46</option>
                                    <option value="47">47</option>
                                    <option value="48">48</option>
                                    <option value="49">49</option>
                                    <option value="50">50</option>
                                    <option value="51">51</option>
                                    <option value="52">52</option>
                                    <option value="53">53</option>
                                    <option value="54">54</option>
                                    <option value="55">55</option>
                                    <option value="56">56</option>
                                    <option value="57">57</option>
                                    <option value="58">58</option>
                                    <option value="59">59</option>
                                </select></p>
                                <div class="upper"></div>
                                <div class="lower"></div>
                            </div>
                        </div>
                        <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:20px">
                            <p><span class="requiredField">*</span>联系人：</p>
                            <input type="text"  name="contactsPersonName" id="contactsPersonName" placeholder="请输入联系人姓名" style="width:298px;background-position:268px 16px">
                        </div>
                        <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:100px">
                            <p><span class="requiredField">*</span>联系电话：</p>
                            <input type="text"  name="contactsPersonPhone" id="contactsPersonPhone"  placeholder="请输入联系电话" style="width:298px;background-position:268px 16px">
                        </div>
                        <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:20px">
                            <p><span class="requiredField">*</span>所属地区：</p>
                            <div style="width:298px;background-position:268px 16px">
                                <p><select name="region">
                                    <option value="">请选择</option>
                                    <c:forEach items="${areaInfos}" var="temp">
                                        <option value="${temp.id}" >${temp.name}</option>
                                    </c:forEach>
                                </select>
                                    <select name="county"></select>
                                    <select name="district"></select>
                                </p>
                                <ul style="width:298px">
                                    <li></li>
                                    <li></li>
                                </ul>
                            </div>
                        </div>
                        <div class="shopmsg shopselect" style="width:890px;margin-top:20px;margin-left:20px">
                            <p><span class="requiredField">*</span>详细地址：</p>
                            <input type="text"  name="address" id="address"  placeholder="请输入详细地址" style="width:788px;background-position:268px 16px">
                        </div>
                        <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:20px">
                            <p><span class="requiredField">*</span>经度：</p>
                            <div style="width:298px;background:none;color:#000000;font-size:14px;text-indent:20px">
                                <p style="line-hight:40px;"><input type="text" name="lon" id="lon"  value="36" style="width:298px;background-position:268px 16px"></p>
                            </div>
                        </div>
                        <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:100px">
                            <p><span class="requiredField">*</span>纬度：</p>
                            <div style="width:298px;background:none;color:#000000;font-size:14px;text-indent:20px">
                                <p style="line-hight:40px;"><input type="text" name="lat" id="lat" value="12"  style="width:298px;background-position:268px 16px"></p>
                            </div>
                        </div>
                    </div>
                    <div class="shopmap"></div>
                    <div class="shopmsg shopaccount" style="clear:both">
                        <p style="width:165px"><span class="requiredField">*</span>门店结算信息是否一致：</p>
                        <p style="width:165px">
                            <input type="radio" name="issame" value="1" checked="checked" onclick="checkissame();">
                            是
                            <input type="radio" name="issame" value="0" onclick="checkissame();">
                            否
                        </p>
                    </div>
                    <div id="legadiv" class="shopbasemsg tops" style="display: none">
                        <p class="p_second">法人信息</p>
                        <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:20px">
                            <p>法人姓名：</p>
                            <input type="text" name="legalPersonName" id="legalPersonName" placeholder="请输入法人姓名" style="width:298px;background-position:268px 16px">
                        </div>
                        <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:100px">
                            <p class="people">法人联系电话：</p>
                            <input type="text" name="legalPersonTel" id="legalPersonTel"  placeholder="请输入法人联系电话" style="width:270px;background-position:268px 16px">
                        </div>
                        <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:20px">
                            <p class="people">法人身份证号：</p>
                            <input type="text" name="bossIdNo" id="bossIdNo" placeholder="请输入法人身份证号" style="width:280px;background-position:268px 16px">
                        </div>
                        <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:100px">
                            <p class="people">身份证有效期：</p>
                                <input type="text" name="bossEdate" id="bossEdate" placeholder="请输入法人身份证有效期" style="width:270px;background-position:268px 16px">
                        </div>
                        <p class="p_first">营业执照信息</p>
                        <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:20px">
                            <p style="width:128px">营业执照商户名称：</p>
                            <input type="text"  name="blMerchantName" id="blMerchantName"  placeholder="请输入营业执照商户名称" style="width:260px;background-position:268px 16px">
                        </div>
                        <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:20px">
                            <p style="width:128px">营业执照有效期：</p>
                                <input type="text" name="blEdate" id="blEdate" placeholder="请输入营业执照有效期" style="width:200px;background-position:268px 16px">
                        </div>
                        <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:20px">
                            <p class="people">营业执照号：</p>
                                <input type="text" name="blNo" id="blNo" placeholder="请输入营业执照号" style="width:280px;background-position:268px 16px">
                        </div>
                    </div>
                    <div class="shopmsg shopdataupload">
                        <p style="margin-left:20px;">上传资料：</p>
                        <dl>
                            <dt></dt>
                            <dd><span>*</span>门头照</dd>
                        </dl>
                        <dl>
                            <dt></dt>
                            <dd><span>*</span>收银台照片</dd>
                        </dl>
                        <dl style="margin-right:0">
                            <dt></dt>
                            <dd><span>*</span>店内环境照片</dd>
                        </dl>
                    </div>
                    <div class="shopmsg shopdataupload">
                        <dl style="margin-left: 105px;">
                            <dt></dt>
                            <dd><span>*</span>添加营业执照</dd>
                        </dl>
                        <dl>
                            <dt></dt>
                            <dd><span>*</span>法人身份证正面</dd>
                        </dl>
                        <dl style="margin-right:0">
                            <dt></dt>
                            <dd><span>*</span>法人身份证反面</dd>
                        </dl>
                    </div>
                    <div class="shopmsg shopdataupload">
                        <dl style="margin-left: 105px;">
                            <dt></dt>
                            <dd>补充材料一</dd>
                        </dl>
                        <dl>
                            <dt></dt>
                            <dd>补充材料二</dd>
                        </dl>
                    </div>

                </div>
                <div id="shopaccountno" style="display:none">
                    <h2>门店管理 > 添加门店</h2>
                    <p>结算信息</p>
                    <div class="shopmsgwrap">
                        <div class="shopmsg shopaccount" style="margin-left:20px;width:390px">
                            <p style="width:200px">结算账户类型：
                           <input type="radio" name="accountType" value="1" checked="checked" onclick="checkispublic();">
                            对公
                            <input type="radio" name="accountType" value="0" onclick="checkispublic();">
                            对私
                            </p>
                        </div>
                        <div id="legalpersondiv" class="shopmsg shopaccount accountuserid" style="margin-left:90px;width:390px;display:none">
                            <p style="width:240px">结算账户人身份：
                                <input type="radio" name="accountIdentityType" value="1" checked="checked" onclick="checkisboss();">
                                法人
                                <input type="radio" name="accountIdentityType" value="0" onclick="checkisboss();">
                                非法人
                            </p>
                        </div>
                    </div>
                    <ul class="bankmsgnav">
                       <%-- <li class="bankmsg">
                            <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:20px">
                                <p>开户名称：</p>
                                <input type="text" placeholder="请输入开户名称" style="width:298px;background-position:268px 16px">
                            </div>
                            <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:100px">
                                <p>开户银行：</p>
                                <input type="text" placeholder="请输入开户银行" style="width:298px;background-position:268px 16px">
                            </div>
                            <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:20px">
                                <p>开户支行：</p>
                                <input type="text" placeholder="请输入开户支行" style="width:298px;background-position:268px 16px">
                            </div>
                            <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:100px">
                                <p>银行联行号：</p>
                                <input type="text" placeholder="请输入银行联行号" style="width:298px;background-position:268px 16px">
                            </div>
                            <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:20px">
                                <p>银行账号：</p>
                                <input type="text" placeholder="请输入银行账号" style="width:298px;background-position:268px 16px">
                            </div>
                        </li>--%>
                        <li class="bankmsg">
                            <div id="idnodiv" class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:20px;display:none">
                                <p>身份证号：</p>
                                <input type="text" name="idNo" id="idNo" placeholder="请输入身份证号" style="width:298px;background-position:268px 16px">
                            </div>
                            <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:100px">
                                <p>开户名称：</p>
                                <input type="text" name="accountName" id="accountName" placeholder="请输入开户名称" style="width:298px;background-position:268px 16px">
                            </div>
                            <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:20px">
                                <p>开户银行：</p>
                                <input type="text" name="bankName" id="bankName" placeholder="请输入开户银行" style="width:298px;background-position:268px 16px">
                            </div>
                            <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:100px">
                                <p>开户支行：</p>
                                <input type="text"  name="bankBranch" id="bankBranch" placeholder="请输入开户支行" style="width:298px;background-position:268px 16px">
                            </div>
                            <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:20px">
                                <p>银行联行号：</p>
                                <input type="text" name="bankNo" id="bankNo" placeholder="请输入银行联行号" style="width:298px;background-position:268px 16px">
                            </div>
                            <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:100px">
                                <p>银行账号：</p>
                                <input type="text" name="accountNo" id="accountNo" placeholder="请输入银行账号" style="width:298px;background-position:268px 16px">
                            </div>
                        </li>
                        <%--<li class="bankmsg" style="display:none">
                            <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:20px">
                                <p>身份证号：</p>
                                <input type="text" placeholder="请输入身份证号" style="width:298px;background-position:268px 16px">
                            </div>
                            <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:100px">
                                <p>开户名称：</p>
                                <input type="text" placeholder="请输入开户名称" style="width:298px;background-position:268px 16px">
                            </div>
                            <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:20px">
                                <p>开户银行：</p>
                                <input type="text" placeholder="请输入开户银行" style="width:298px;background-position:268px 16px">
                            </div>
                            <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:100px">
                                <p>开户支行：</p>
                                <input type="text" placeholder="请输入开户支行" style="width:298px;background-position:268px 16px">
                            </div>
                            <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:20px">
                                <p>银行联行号：</p>
                                <input type="text" placeholder="请输入银行联行号" style="width:298px;background-position:268px 16px">
                            </div>
                            <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:100px">
                                <p>银行账号：</p>
                                <input type="text" placeholder="请输入银行账号" style="width:298px;background-position:268px 16px">
                            </div>
                        </li>--%>
                    </ul>
                    <ul class="userdataupload">
                        <li class="shopmsg shopdataupload" style="height:330px;">
                            <p style="margin-left:20px;">上传资料：</p>
                            <dl id="bosspositivedl" style="display: none;">
                                <dt></dt>
                                <dd>法人身份证正面</dd>
                            </dl>
                            <dl id="bossbackdl" style="display: none;">
                                <dt></dt>
                                <dd>法人身份证反面</dd>
                            </dl>
                            <dl id="accountpic1dl" style="margin-right:0;display: none;">
                                <dt></dt>
                                <dd>银行卡正面</dd>
                            </dl>
                            <dl id="accountpic2dl" style="margin-left:105px;display: none;">
                                <dt></dt>
                                <dd>银行卡反面</dd>
                            </dl>
                            <dl id="licencedl">
                                <dt></dt>
                                <dd>开户许可证</dd>
                            </dl>
                            <dl id="blpicdl">
                                <dt></dt>
                                <dd>营业执照</dd>
                            </dl>
                        </li>
                        <li class="shopmsg shopdataupload" style="height:330px;display:none">
                            <p style="margin-left:20px;">上传资料：</p>
                            <dl>
                                <dt></dt>
                                <dd>法人身份证正面</dd>
                            </dl>
                            <dl>
                                <dt></dt>
                                <dd>法人身份证反面</dd>
                            </dl>
                            <dl style="margin-right:0">
                                <dt></dt>
                                <dd>银行卡正面</dd>
                            </dl>
                            <dl style="margin-left:105px;">
                                <dt></dt>
                                <dd>银行卡反面</dd>
                            </dl>
                            <dl>
                                <dt></dt>
                                <dd>营业执照</dd>
                            </dl>
                        </li>
                        <li class="shopmsg shopdataupload" style="display:none">
                            <p style="margin-left:20px;">上传资料：</p>
                            <dl>
                                <dt></dt>
                                <dd>银行卡正面</dd>
                            </dl>
                            <dl>
                                <dt></dt>
                                <dd>银行卡反面</dd>
                            </dl>
                            <dl style="margin-right:0">
                                <dt></dt>
                                <dd>营业执照</dd>
                            </dl>
                        </li>
                    </ul>
                    <p>结算信息</p>
                    <div class="bankmsg">
                        <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:20px">
                            <p>微信：</p>
                            <input type="text" name="weixinSettleRate" id="weixinSettleRate" placeholder="" style="width:290px;background-position:268px 16px">%
                        </div>
                        <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:100px">
                            <p>支付宝：</p>
                            <input type="text" name="zhifubaoSettleRate" id="zhifubaoSettleRate" placeholder="" style="width:290px;background-position:268px 16px">%
                        </div>
                        <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:20px">
                            <p>QQ钱包：</p>
                            <input type="text" name="qqqianbaoSettleRate" id="qqqianbaoSettleRate" placeholder="" style="width:290px;background-position:268px 16px">%
                        </div>
                        <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:100px">
                            <p>京东钱包：</p>
                            <input type="text" name="jdqianbaoSettleRate" id="jdqianbaoSettleRate" placeholder="" style="width:290px;background-position:268px 16px">%
                        </div>
                        <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:20px">
                            <p>银联：</p>
                                <input type="text" name="yinlianSettleRate" id="yinlianSettleRate" placeholder="" style="width:290px;background-position:268px 16px">%
                        </div>
                        <div class="shopmsg shopselect" style="width:390px;margin-top:20px;margin-left:100px">
                            <p>结算时间：</p>
                            <div style="width:98px;background-position:68px 16px">
                                <p>T+<select name="settleDay">
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                    <option value="13">13</option>
                                    <option value="14">14</option>
                                </select></p>
                                <ul style="width:98px">
                                    <li></li>
                                    <li></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="shopmsg shopaccount" style="clear:both;margin-top:20px;">
                        <p style="width:200px">结算类型：
                         <input type="radio" name="settleType" value="1" checked="checked">
                         自动
                         <input type="radio" name="settleType" value="0">
                         手动
                         </p>
                    </div>

                </div>
            </li>
            <div id="submitbutton" class="save" style="clear:both;padding-top:20px">
                <input type="submit" value="保存" class="savebtn" style="cursor:pointer">
                <input type="button" value="取消" class="canclebtn">
            </div>
            <div id="nextbutton" class="save" style="clear:both;padding-top:20px;display: none">
                <input id="nextbut" type="button" value="下一步" class="savebtn" style="cursor:pointer">
                <input type="button" value="取消" class="canclebtn">
            </div>
        </ul>
    </div>
</form>
</body>
</html>