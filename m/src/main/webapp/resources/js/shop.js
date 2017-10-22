$(function(){
	$('#left>ul>li').click(function(){
		$(this).addClass('cur').siblings().removeClass('cur');
		$('#right>ul>li').eq($(this).index()).show().siblings().hide();
	})
	$('#left>ul>li:nth-child(4)').click(function(){
		$('#storevalue').show().siblings().hide();
		$('#right>ul>li').eq($(this).index()).siblings().hide();
	})
	$('#left>ul>li:nth-child(3)').click(function(){
		$('#activitycode').show().siblings().hide();
		$('#right>ul>li').eq($(this).index()).siblings().hide();
	})
	$('#left>ul>li:nth-child(2)').click(function(){
		$('#facilitymanage').show().siblings().hide();
		$('#right>ul>li').eq($(this).index()).siblings().hide();
	})
	$('#left>ul>li:nth-child(1)').click(function(){
		$('#shopmanage').show().siblings().hide();
		$('#right>ul>li').eq($(this).index()).siblings().hide();
	})
	$('#right .postermsg>div>p').click(function(){
		$(this).siblings().toggle().parent().parent().siblings('div').find('div>ul').hide();
	})
	$('#right .postermsg>div>ul>li').click(function(){
		$(this).parent().hide().siblings().html($(this).html());
	})
	$('#right .shopmsg>div>p').click(function(){
		$(this).siblings('ul').toggle().parent().parent().siblings('div').find('div>ul').hide();
	})
	$('#right .shopmsg>div>ul>li').click(function(){
		$(this).parent().hide().siblings().html($(this).html());
	})
	$('#addfacility .staffselect>div>ul>li').click(function(){
		$('#addfacility .staffselectnav>li').eq($(this).index()).show().siblings().hide();
	})
	$('#right .addstorevaluebg').click(function(){
		$('#storevalue').hide();
		$('#storevaluebg').show();
	})
	$('#right .addstorevalue').click(function(){
		$('#storevalue').hide();
		$('#addstorevalue').show();
	})
	$('#right .addactivitycode').click(function(){
		$('#activitycode').hide();
		$('#addactivity').show();
	})
	$('#shopmanage .shopadd').click(function(){
		$('#shopmanage').hide();
		$('#addshop').show();
	})
	$('#facilitymanage .addfacility').click(function(){
		$('#facilitymanage').hide();
		$('#addfacility').show();
	})
	$('#addshop .shopaccount>dl>dt').click(function(){
		$(this).parent().addClass('select').siblings('dl').removeClass('select');
	})
	$('#addshop .shopaccountyes>dt').click(function(){
		$('#addshop .savebtn').val("保存")
	})
	$('#addshop .shopaccountno>dt').click(function(){
		$('#addshop .savebtn').val("下一步")
	})
	$('#addshop .savebtn').click(function(){
		if($(this).val()=="下一步"){
			$('#shopaccountno').show().siblings().hide();
		}
	})
	$('#addshop .canclebtn').click(function(){
		$('#shopmanage').show().siblings().hide();
	})
	$('#shopaccountno .canclebtn').click(function(){
		$('#addshop').show().siblings().hide();
	})
	$('#addfacility .canclebtn').click(function(){
		$('#facilitymanage').show().siblings().hide();
	})
	$('#addactivity .canclebtn').click(function(){
		$('#activitycode').show().siblings().hide();
	})
	$('#addstorevalue .canclebtn').click(function(){
		$('#storevalue').show().siblings().hide();
	})
	$('#shopaccountno .shopaccount>dl>dt').click(function(){
		$(this).parent().addClass('select').siblings('dl').removeClass('select');
	})
	$('#shopaccountno .shopaccountpublic>dt').click(function(){
		$('#shopaccountno .accountuserid').hide();
		$('#shopaccountno .bankmsgnav>li:nth-child(1)').show().siblings().hide();
		$('#shopaccountno .userdataupload>li:nth-child(1)').show().siblings().hide();
	})
	$('#shopaccountno .shopaccountprivate>dt').click(function(){
		$('#shopaccountno .accountuserid').show();
		$('#shopaccountno .bankmsgnav>li:nth-child(2)').show().siblings().hide();
		$('#shopaccountno .userdataupload>li:nth-child(2)').show().siblings().hide();
	})
	$('#shopaccountno .legalperson>dt').click(function(){
		$('#shopaccountno .bankmsgnav>li:nth-child(2)').show().siblings().hide();
		$('#shopaccountno .userdataupload>li:nth-child(2)').show().siblings().hide();
	})
	$('#shopaccountno .unincorporate>dt').click(function(){
		$('#shopaccountno .bankmsgnav>li:nth-child(3)').show().siblings().hide();
		$('#shopaccountno .userdataupload>li:nth-child(3)').show().siblings().hide();
	})
	$('#right .editswitch').click(function(){
		if($(this).attr("id")==0){
			$(this).find('.editslide').stop().animate({"left":"24px"},200);
			$(this).find('.editon').stop().animate({"width":"42px"},200);
			$(this).attr({"id":1});
		}else{
			$(this).find('.editslide').stop().animate({"left":0},200);
			$(this).find('.editon').stop().animate({"width":0},200);
			$(this).attr({"id":0});
		}
	})
})