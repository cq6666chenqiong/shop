$( function () {
	$('.header_center li a').on('click',function (){
		var _thathtml   = $(this).text();
		var _thatnavstr = '<h1>'+ _thathtml +'</h1><ul class="nav_left">';
		var _thatindex  = $(this).parent().index();
		if( _thatindex == 0 ){
			$('.content').html('<iframe src="views/home.html" scrolling="no" id="UFrame"></iframe>');
		}else{
			$('.content').html('<div class="nav_wrap"></div><div class="cont_wrap"></div>');
			for( var i = 0; i < route.length; i++ ){
				if( _thathtml == route[i].title ){
					var particulars = route[i].particulars;
					for( var y = 0; y < particulars.length; y++ ){
						_thatnavstr += '<li url="'+ particulars[y].sonurl +'">'+ particulars[y].sontile +'</li>';
						$('.cont_wrap').html('<iframe src="'+ particulars[0].sonurl +'" scrolling="no" id="UFrame"></iframe>');
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
		$('.cont_wrap').html('<iframe src="'+ thatUrl +'" scrolling="no" id="UFrame"></iframe>');
		$(this).addClass('first').siblings().removeClass('first');
		console.log( thatUrl )
	})
})