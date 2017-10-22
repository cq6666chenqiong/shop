$(function(){
	$(".nav10>li").click(function(){
		$(this).addClass("post").siblings().removeClass("post");
		$(this).find(".bai").show();
		$(this).find(".lan").hide();
		$(this).siblings().find(".bai").hide();
		$(this).siblings().find(".lan").show();
	})
	option = {
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    color:['#FDB08B', '#95C9FA','#84D9DA','#FADC89'],
	    legend: {
	        bottom: 10,
	        left: 'center',
	        data: ['会员', '轻度','中度','重度']
	    },
	    series : [
	        {
	            type: 'pie',
	            radius : '65%',
	            center: ['50%', '50%'],
	            selectedMode: 'single',
	            data:[
	                {value:535, name: '重度'},
	                {value:510, name: '中度'},
	                {value:634, name: '轻度'},
	                {value:735, name: '会员'}
	            ],
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            },
	            label:{
					normal:{
						show:false 
					}
				}
	        }
	    ]
	};

    //初始化echarts实例
    var myChart = echarts.init(document.getElementById('chartmain'));
    var myChart1 = echarts.init(document.getElementById('chartmain1'));
    var myChart2 = echarts.init(document.getElementById('chartmain2'));

    //使用制定的配置项和数据显示图表
    myChart.setOption(option);
    myChart1.setOption(option);
    myChart2.setOption(option);

})