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
    <title>后台管理系统 - 首页</title>
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/style.css">
    <script type="text/javascript" src="${path}/resources/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="${path}/resources/js/module.js"></script>
    <script type="text/javascript">
        function reinitIframe(){
            var iframe = document.getElementById("UFrame");
            try{
                var bHeight = iframe.contentWindow.document.body.scrollHeight;
                var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
                var height = Math.max(bHeight, dHeight);
                iframe.height =  height;
            }catch (ex){

            }
        }
        window.setInterval("reinitIframe()", 200);
    </script>
</head>
<body>

<div id="header">
    <%@ include file="./include/nav.jsp" %>
    <%@ include file="./include/topMenu.jsp" %>
</div>

<!-- 内容 Start -->
<div class="content clearfix" id="content">
    <iframe src="${path}/manager/index/home" scrolling="no" id="UFrame"></iframe>
</div>
<!-- 内容 end -->

<%@ include file="./include/footer.jsp" %>

<script type="text/javascript">
    $(function (){
        loadMenu();
        $('.header_center li a').on('click',function (){
            var _thathtml   = $(this).text();
            var _thatnavstr = '<h1>'+ _thathtml +'</h1><ul class="nav_left">';
            var _thatindex  = $(this).parent().index();
            if( _thatindex == 0 ){
                $('.content').html('<iframe src="${path}/manager/index/home" scrolling="no" id="UFrame"></iframe>');
            }else{
                $('.content').html('<div class="nav_wrap"></div><div class="cont_wrap"></div>');
                for( var i = 0; i < route.length; i++ ){
                    if( _thathtml == route[i].title ){
                        var particulars = route[i].particulars;
                        for( var y = 0; y < particulars.length; y++ ){
                            _thatnavstr += '<li url="'+ particulars[y].sonurl +'">'+ particulars[y].sontile +'</li>';
                            $('.cont_wrap').html('<iframe src="${path}/'+ particulars[0].sonurl +'" scrolling="no" id="UFrame"></iframe>');
                        }
                    }
                }
                _thatnavstr += '</ul>';
                $('.nav_wrap').html( _thatnavstr );
                $('.nav_left li:first').addClass('first');
            }
            $(this).parent().addClass('active').siblings().removeClass('active');

            // reinitIframe();
        })
        $(document).on('click','.nav_left li',function (){
        	
            var thatUrl = $(this).attr('url');
            var path = "${path}";
            $('.cont_wrap').html('<iframe src="' + path + '/' + thatUrl +'" scrolling="no" id="UFrame"></iframe>');
            $(this).addClass('first').siblings().removeClass('first');
            console.log( thatUrl )
        })
    })
    function loadMenu() {
        $.ajax({
            url: "${path}/manager/channelInfo/loadMenu",
            global: false,
            type: "GET",
            dataType: "json",
            async: false,
            success: function (result) {
                route =result;
            }
        });
    }
</script>
</body>
</html>