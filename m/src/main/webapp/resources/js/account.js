$(function(){
	$(".nav li").click(function(){
		$(this).addClass("first").siblings().removeClass("first");
		$(".main_wrap").eq($(this).index()).show().siblings(".main_wrap").hide();
	})

	$(".charge").click(function(){
		$(this).css({"background":"#08c1ff","color":"#ecfaff","border":"1px solid #08c1ff"}).siblings()
				.css({"background":"#fff","color":"#4c4c4c","border":"1px solid #ccc"})
	})
	$(".input1").keyup(function(){
		//$(".attention1").fadeIn(800)
	})
	$(".input4").keyup(function(){
		$(".attention2").fadeIn(800)
	})
	$(".input_color").click(function(){
		$(this).css({"border":"1px solid #00bfff",
			"color":"#12c4ff",
			"background":"url(../images/account/img.png) no-repeat 96px 12px"
		}).siblings(".input_color").css({"border":"1px solid #ccc",
			"color":"#434343",
			"background":"none"
		})
	})
	$(".refer input").click(function(){
		$(".succeed").fadeIn(800).fadeOut(800)
		//$(".input1").val("")
		//$(".input4").val("")
		//$(".input5").val("")
	})

	$(".input6").click(function(){
		$(".w_pay").show()
		$(".content").hide()

	})
	$(".input7").click(function(){
		$(".sweep_pay").show()
		$(".content").hide()
	})

	 $(".textarea").keyup(function(){
        var len=$(".textarea").val().length;
        if(len>100){
            $(".textarea").val($(".textarea").val().substring(0,100));
        }else{
            $(".num2").text(100-$(".textarea").val().length);
            $(".num1").text($(".textarea").val().length);
        }
    })

 	$(".record li").click(function(){
 		$(this).addClass("record_color").siblings().removeClass("record_color")
 	})
 	$(".recordd li").click(function(){
 		$(this).addClass("recordd_color").siblings().removeClass("recordd_color")
 	})

 	/**/
 	$(".ts").click(function(){
        var timeType=$(this).attr("timeType");
		$(this).addClass("ti").siblings().removeClass("ti");
        $("#timeType").val(timeType);

        if(timeType==1){
        	$("#startTime").val($("#today").val());
            $("#endTime").val($("#today").val());
		}else if (timeType==2) {
            $("#startTime").val($("#yesterday").val());
            $("#endTime").val($("#yesterday").val());
        }else if (timeType==3) {
            $("#startTime").val($("#sevenDayStart").val());
            $("#endTime").val($("#sevenDayEnd").val());
        }else if (timeType==4) {
            $("#startTime").val($("#monthStart").val());
            $("#endTime").val($("#monthDayEnd").val());
        }
        //$("#pageForm").submit();
	})
 	/**/

 	$(".page_color").click(function(){
 		$(this).css({"color":"#ffa508"}).siblings().css({"color":"#666"})
 	})
})
