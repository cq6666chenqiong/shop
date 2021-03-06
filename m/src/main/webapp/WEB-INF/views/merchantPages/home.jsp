<!doctype html>
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
	<title>智慧商街商户端 - 首页</title>
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/reset.css">
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/home.css">
	<link href="${path}/resources/css/lyz.calendar.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${path}/resources/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${path}/resources/js/common.js"></script>
	<script type="text/javascript" src="${path}/resources/js/home.js"></script>
	<script type="text/javascript" src="${path}/resources/js/echarts.min.js"></script>
	<script src="${path}/resources/js/lyz.calendar.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="${path}/resources/time/js/laydate.js"></script>
</head>
<body>
	<div id="header"></div>
	<div class="content">
		<div class="main">
			<div class="main1">
				<img style="float: left;margin-right: 20px;margin-top: 1px;" src="${path}/resources/images/notice.png" alt="">
				<div class="car">
					<p class="word">热烈庆祝智慧商街成功上市,热烈庆祝智慧商街成功上市,热烈庆祝智慧商街成功上</p>
				</div>
				<p class="word1">更多</p>
				<img src="${path}/resources/images/2.png" alt="" style="float: right;margin-right: 18px;">
				<p class="word2">2017-08-17</p>
			</div>
			
			<div class="main2">
				<a href="#" class="ab">今日经营概览</a>
			</div>
			<div class="main3">
				<div>
					<p class="word3">今日会员数</p>
					<p class="word4">0</p>
				</div>
				<div>
					<p class="word3">今日交易金额</p>
					<p class="word4">0</p>
				</div>
				<div>
					<p class="word3">今日交易笔数</p>
					<p class="word4">0</p>
				</div>
				<div>
					<p class="word3">今日平均客单价</p>
					<p class="word4">0</p>
				</div>
			</div>
			<div class="main2">
				<a href="#" class="ab">近期交易情况</a>
			</div>
			<div class="main4">
				<div style="margin-left: 1%;">
					<div class="tbl">
						<p class="word5"><img style="margin-right: 5px;margin-top: -4px;" src="${path}/resources/images/3.png" alt="">昨日</p>
					</div>
					<div class="tbl1">
						<div class="l">
							<p>交易总金额</p>
							<p>优惠总金额</p>
							<p>实际交易金额</p>
							<p>交易总笔数</p>
							<p>交易客单价</p>
						</div>
						<div class="r">
							<p>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥0.04</p>
							<p>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥0.04</p>
							<p>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥0.04</p>
							<p>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥0.04</p>
							<p>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥0.04</p>
						</div>
					</div>
				</div>
				<div style="margin-left: 11%;">
					<div class="tbl">
						<p class="word5">最近7天</p>
					</div>
					<div class="tbl1">
						<div class="l">
							<p>交易总金额</p>
							<p>优惠总金额</p>
							<p>实际交易金额</p>
							<p>交易总笔数</p>
							<p>交易客单价</p>
						</div>
						<div class="r">
							<p>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥0.04</p>
							<p>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥0.04</p>
							<p>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥0.04</p>
							<p>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥0.04</p>
							<p>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥0.04</p>
						</div>
					</div>
				</div>
				<div style="margin-left: 11%;">
					<div class="tbl">
						<p class="word5">最近30天</p>
					</div>
					<div class="tbl1">
						<div class="l">
							<p>交易总金额</p>
							<p>优惠总金额</p>
							<p>实际交易金额</p>
							<p>交易总笔数</p>
							<p>交易客单价</p>
						</div>
						<div class="r">
							<p>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥0.04</p>
							<p>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥0.04</p>
							<p>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥0.04</p>
							<p>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥0.04</p>
							<p>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥0.04</p>
						</div>
					</div>
				</div>
			</div>
			<div class="main2">
				<a href="#" class="ab">时段分析</a>
			</div>
			<div class="main6">
			     
				<div class="plug">
					<div style="width:500px;height:42px;float:left;">
					  <span style="float:left;line-height:55px;margin-right: 15px;">时间:</span>
					     <input id="timeDate" style="width:170px;padding:7px 10px;border:1px solid #E7E7EB;margin-right:18px;float:left;font-size:12px;margin-top:12px;" placeholder="开始日期"/>
					</div>
					<input type="button" id="query" value="查询">
				</div>
				<div class="hour">
					<ul class="nav10">
						<li class="post"><a href="javascipt:;">
							<p class="word7">近24小时销售金额(元)<img style="margin-left: 5px;" src="${path}/resources/images/doubt.png" alt=""></p>
							<p class="word8">1,593,847.41</p>
							<p class="word9">对比昨天&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<img class="bai" style="margin-top: -3px;margin-right: 5px;" src="${path}/resources/images/rise_white.png" alt=""><img class="lan" style="margin-top: -3px;margin-right: 5px;display: none;" src="${path}/resources/images/rise_blue.png" alt=""><span>3.50%</span></p>
							<p class="word9">对比上周一&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<img class="bai" style="margin-top: -3px;margin-right: 5px;margin-left: -9.5px;" src="${path}/resources/images/decline_white.png" alt=""><img class="lan" style="margin-top: -3px;margin-right: 5px;margin-left: -9.5px;display: none;" src="${path}/resources/images/decline_gules.png" alt=""><span>4.80%</span></p>
						</a></li>
						<li><a href="javascipt:;">
							<p class="word7">近24小时销售笔数(笔)<img style="margin-left: 5px;" src="${path}/resources/images/doubt.png" alt=""></p>
							<p class="word8">4556</p>
							<p class="word9">对比昨天&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img class="lan" style="margin-top: -3px;margin-right: 5px;" src="${path}/resources/images/rise_blue.png" alt=""><img class="bai" style="margin-top: -3px;margin-right: 5px;display: none;" src="${path}/resources/images/rise_white.png" alt=""><span>3.50%</span></p>
							<p class="word9">对比上周一&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img style="margin-top: -3px;margin-right: 5px;margin-left: -9.5px;" src="${path}/resources/images/decline_gules.png" alt="" class="lan"><img class="bai" style="margin-top: -3px;margin-right: 5px;margin-left: -9.5px;display: none;" src="${path}/resources/images/decline_white.png" alt=""><span>4.80%</span></p>
						</a></li>
						<li><a href="javascipt:;">
							<p class="word7">近24小时人均金额(元)<img style="margin-left: 5px;" src="${path}/resources/images/doubt.png" alt=""></p>
							<p class="word8">1234.88</p>
							<p class="word9">对比昨天&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img style="margin-top: -3px;margin-right: 5px;" src="${path}/resources/images/7.png" alt="" class="lan"><img class="bai" style="margin-top: -3px;margin-right: 5px;display: none;" src="${path}/resources/images/rise_white.png" alt=""><span>3.50%</span></p>
							<p class="word9">对比上周一&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img style="margin-top: -3px;margin-right: 5px;margin-left: -9.5px;" src="${path}/resources/images/8.png" alt="" class="lan"><img class="bai" style="margin-top: -3px;margin-right: 5px;margin-left: -9.5px;display: none;" src="${path}/resources/images/decline_white.png" alt=""><span>4.80%</span></p>
						</a></li>
					</ul>
				</div>
				<div class="line">
					
					<div id="main" style="margin:auto;height:500px;min-width:1200px"></div>
				</div>
				<div class="graph">
					<p>
						<a class="wrp" href="#">
							<img src="${path}/resources/images/blue.png" alt="">
						</a>
						<span>近24小时销售额</span>
					</p>
					<p>
						<a style="background: #979797" class="wrp" href="#">
							<img src="${path}/resources/images/gray.png" alt="">
						</a>
						<span>昨天销售金额</span>
					</p>
					<p>
						<a style="background: #ff7e00" class="wrp" href="#">
							<img src="${path}/resources/images/yellow.png" alt="">
						</a>
						<span>上周一销售金额</span>
					</p>
				</div>
			</div>
		</div>
	</div>

	
	<script>
		$(function () {
			var option = {
				    title : {
				        text: '',
				        subtext: ''
				    },
				    tooltip : {
				        trigger: 'axis'
				    },
				    calculable : true,
				    xAxis : [
				    	
				        {
				        	
			        	 	
				        	splitLine:{ show:true },
				        	type : 'category',
				            boundaryGap : false,
				            data : ['周一','周二','周三','周四','周五','周六','周日']
				        }
				    ],
				    yAxis : [
				    	
				        {   
				        	axisTick:{
				                show:false
				            },
				        	splitLine:{ show:true },
				        	type : 'value'
				        }
				    ],
				    series : [
				        {
				            name:'近24小时销售额',
				            type:'line',
				            smooth:true,
				            itemStyle: {normal: {color:'#00BFFF',lineStyle:{color:'#00BFFF'},areaStyle: {type: 'default'}}},
				            data:[10, 12, 21, 54, 260, 830, 710]  // ${machineCabinetlist}
				        },
				        {
				            name:'昨天销售金额',
				            type:'line',
				            smooth:true,
				            itemStyle: {normal: {color:'#8B8989',lineStyle:{color:'#8B8989'},areaStyle: {type: 'default'}}},
				            data:[30, 182, 434, 791, 390, 30, 10]   // ${machineCabinetlist}
				        },
				        {
				            name:'上周一销售金额',
				            type:'line',
				            smooth:true,
				            itemStyle: {normal: {color:'#FF7F00',lineStyle:{color:'#FF7F00'},areaStyle: {type: 'default'}}},
				            data:[1320, 1132, 601, 234, 120, 90, 20]   // ${machineCabinetlist}
				        }
				    ]
				};
				
				var myChart = echarts.init(document.getElementById('main'));
				myChart.setOption(option);
	    });
		
		!function(){
			laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
			laydate({elem: '#timeDate'});//绑定元素
		}();
	</script>
</body>
</html>