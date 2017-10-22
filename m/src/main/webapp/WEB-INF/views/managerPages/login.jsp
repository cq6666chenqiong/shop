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
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>智慧商街商户后台</title>
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/reset.css">
	<script type="text/javascript" src="${path}/resources/js/jquery-1.8.3.min.js"></script>
	<style type="text/css">
	html, body {
		width: 100%;
		height: 100%;
		margin: 0;
	  }
	  body {
		background-image: url(${path}/resources/images/merchantLogin/bg.png);
		background-size: cover;
		background-position: 50% 0%;
	  }
	  .head{
	  	width: 100%;
	  	min-width: 1200px;
        height: 129px;
        background: #FAFAFA;
        position: absolute;
        top: 0px;
	  }
	  .head .logo{
        width: 239px;
        height: 57px;
        background: url(${path}/resources/images/merchantLogin/logo_sh.png) no-repeat;
        margin-left:20%;
        margin-top: 36px;
        float: left; 
	  }
	  .head .name{
        margin-top: 53px;
        float: left;
        color: #999999;
        margin-left: 45px;
        font-size: 36px;
        font-family: "微软雅黑"; 
	  }
	  .my{
	  	width: 100%;
	  	min-width: 1200px;
	  	height: 442px;
	    top: 200px;
	  	position: relative;
	  }
	  .my-container {
	  	background: #fff;
		width: 569px;
		height: 470px;
		border-radius:8px;
		position: absolute;
		right: 5%;
	  }
	  .my-container .login{
		height: 66px;
		border-bottom: 1px solid #ccc;
		line-height: 66px;
		color: #333;
		text-align: center;
		font-size: 20px;
	  }
	  .my-container .login1{
	  	width: 472px;
		height: 50px;
		line-height: 50px;
		color: #333;
		margin: 0 auto;
		font-size: 20px;
		margin-top: 23px;
	  }
	  .my-container .login2{
	  	width: 472px;
		height: 50px;
		margin: 0 auto;
		border-bottom: 1px solid #ccc;
	  }
	  .login2 .login2_1{
	  	width: 21px;
	  	height: 21px;
	  	background: url(${path}/resources/images/merchantLogin/zh_sh.png) no-repeat;
	  	margin-top: 14px;
	  	float: left;
	  	margin-left: 20px;
	  }
	  .login2 .login2_2{
	  	width: 15px;
	  	height: 20px;
	  	background: url(${path}/resources/images/merchantLogin/mm_ssh.png) no-repeat;
	  	margin-top: 15px;
	  	float: left;
	  	margin-left: 22px;
	  }
	  .login2 .login2_3{
	  	width: 18px;
	  	height: 20px;
	  	background: url(${path}/resources/images/merchantLogin/yz_sh.png) no-repeat;
	  	margin-top: 15px;
	  	float: left;
	  	margin-left: 21px;
	  }
	  .login2 input{
	  	width: 336px;
	  	height: 46px;
	  	float: left;
	  	border: none;
	  	margin-left: 10px;
	  	font-size: 18px;
	  	font-family: "微软雅黑";
	  }
	  .login2 .login2_4{
	  	width: 87px;
	  	height: 37px;
	  	float: left;
	  	display: block;
	  	margin-top: 8px;
	  }
	  .login3{
	  	width: 472px;
		height: 20px;
		margin: 0px auto;
		margin-top: 20px;
		line-height: 20px;
		font-size: 14px;
		color: #333;
	  }
	  .login3 input{
	  	width: 16px;
		height: 15px;
		margin-left: 2px;
		margin-right: 10px;
	  }
	  .login3 .login3_1{
	  	line-height: 20px;
		float: right;
		cursor: pointer;
	  }
	  .login4{
	  	width: 122px;
	  	height: 36px;
	  	line-height: 36px;
		background: #08C1FF;
		color: #fff;
		font-size: 14px;
		text-align: center;
		border-radius: 5px;
		margin-left: 50px;
		margin-top: 44px;
		cursor: pointer;
	  }
	.wrong{
		width: 468px;
		height: 20px;
		margin: 0px auto;
		line-height: 20px;
		font-size: 14px;
		margin-top: 20px;
		color: #ee394b;
		display: none;
	}
      </style>
</head>
<body>
        <div class="head">
        	<div class="logo"></div>
        	<h1 class="name">商户后台123</h1>
        </div>
        <div class="my">
        	<div class="my-container">
			  <div class="login">账号密码登录</div>
			  <div class="login1">登录</div>
			  <div class="login2">
			  	  <div class="login2_1"></div>
			  	  <input type="text" name="account" id="account" value="">
			  </div>
			  <div class="login2">
			  	  <div class="login2_2"></div>
			  	  <input type="password" name="password" id="password" value="">
			  </div>
			  <div class="login2">
			  	  <div class="login2_3"></div>
			  	  <input type="text" value="" name="imagecode" id="imagecode" onkeydown="if(event.keyCode=='13'){$('#submit1').click();}">
				  <img src="${path}/manager/index/imageCode" width="110px" height="40px" border="0"
					   onclick="this.src='${path}/manager/index/imageCode?'+Math.random()" class="login2_4" id="codeImg"/>
			  </div>
				<div class="wrong"></div>
			  <div class="login3">
			  	<input type="checkbox" name="isRememberAccount" id="isRememberAccount"  value="true"/>记住账号
			  	<div class="login3_1">忘记密码</div>
			  </div>
              <div class="login4" id="submit1" onclick="checkForSubmit();">立即登录 </div>
		    </div>
        </div>
		
		<script type="text/javascript" src="${path}/resources/js/adapttext.js"></script>
		<script type="text/javascript">
/*
			document.addEventListener('DOMContentLoaded', function() {
				new AdaptText(document.getElementById('my-container'), {
				  callback: function(newFontSize) {
					console.log('new font-size is ', newFontSize);
				  }
				});
			  });
*/
(function ($) {
    if (getCookie("account") != null) {
        $("#isRememberAccount").prop("checked", true);
        $("#account").val(getCookie("account"));
        //$("[name='type']").val(getCookie("memberUsertype"));
        $("#password").focus();
    } else {
        $("#isRememberAccount").prop("checked", false);
        $("#account").focus();
    }
})(jQuery);

            //校验验证码
            function checkForSubmit(){
                var account=$("#account").val();
                var password=$("#password").val();
                var imagecode=$("#imagecode").val();
                if(account==""){
                    $(".wrong").show();
                    $(".wrong").text("请输入账户名！");
                    return false;
                }
                if(password==""){
                    $(".wrong").show();
                    $(".wrong").text("请输入密码！");
                    return false;
                }
                if(imagecode==""){
                    $(".wrong").show();
                    $(".wrong").text("请输入验证码！");
                    return false;
                }
                $("#submit1").removeAttr("onclick");
                //md5前台加密

                jQuery.ajax({type: "post",
                    url:  "${path}/manager/index/authenticate",
                    data: {
                        "account":account,
                        "password":password,
                        "imagecode":imagecode
                    },
                    success: function(result){
                        if (result.success) {
                            if ($("#isRememberAccount").prop("checked")) {
                                addCookie("account", $("#account").val(), {expires: 7 * 24 * 60 * 60});
                            } else {
                                removeCookie("account");
                            }
                            window.location.href="${path}/manager/index";
                        } else {
                            $("#submit1").attr("onclick","checkForSubmit();");
                            $(".wrong").show();
                            $(".wrong").text(result.message);
                        }
                    }
                });
            }


// 添加Cookie
function addCookie(name, value, options) {
    if (arguments.length > 1 && name != null) {
        if (options == null) {
            options = {};
        }
        if (value == null) {
            options.expires = -1;
        }
        if (typeof options.expires == "number") {
            var time = options.expires;
            var expires = options.expires = new Date();
            expires.setTime(expires.getTime() + time * 1000);
        }
        document.cookie = encodeURIComponent(String(name)) + "=" + encodeURIComponent(String(value)) + (options.expires ? "; expires=" + options.expires.toUTCString() : "") + (options.path ? "; path=" + options.path : "") + (options.domain ? "; domain=" + options.domain : ""), (options.secure ? "; secure" : "");
    }
}

// 获取Cookie
function getCookie(name) {
    if (name != null) {
        var value = new RegExp("(?:^|; )" + encodeURIComponent(String(name)) + "=([^;]*)").exec(document.cookie);
        return value ? decodeURIComponent(value[1]) : null;
    }
}

// 移除Cookie
function removeCookie(name, options) {
    addCookie(name, null, options);
}
		</script>
</body>
</html>