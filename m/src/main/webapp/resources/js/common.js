function CommonHeader( element,pageindex )
{	
	$(element).load('../views/common/header.html',function (){
		$('.header_center li').eq( pageindex ).addClass('active').siblings().removeClass('active');
	})
}
