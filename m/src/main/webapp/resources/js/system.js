$(function(){
	// 账户信息
	$(".account_icon").click(function(){
		$(".account_wrap").hide()
		$(".account_alter").show()
	})
	$(".account_abolish").click(function(){
		$(".account_wrap").show()
		$(".account_alter").hide()
	})
	//微信授权
	$(".anew").click(function(){
		$(".accredit_wrap").toggle()
		$(".redelegation_wrap").toggle()
	})
	//角色管理
	$(".role_top>h2>span").click(function(){
		$(".role_wrap").hide()
		$(".role_append").show()	
	})
	$(".role_set_nav li img").click(function(){
		$(this).next().next().toggle()
	})
	$(".merchantAccountSelectShop li a").click(function(){
		var shopIds="";
		var selectedCount=0;
		$(".admin_bottom_option_right p").remove();
		$(this).toggleClass("pic2")
        $(".role_set_nav li a").each(
            function(){
                if ($(this).attr('class')=="pic2") {
                    selectedCount=selectedCount+1;
                    var $pObj = $("<p>"+$(this).text()+"</p>");
                    $(".admin_bottom_option_right").append($pObj);
                    if (shopIds != "") {
                        shopIds = shopIds + "," + $(this).attr("shopId");
                    } else {
                        shopIds = $(this).attr("shopId");
                    }
                }
            }
        );
		$("#shopIds").val(shopIds);
        $("#selectedCount").text(selectedCount);
	});
    $(".shopAccountSelectShop li a").click(function(){
        var shopIds="";
        //var selectedCount=0;
        $(this).toggleClass("pic2");
        $(this).parent().siblings().find("a").removeClass("pic2");

        $(".role_set_nav li a").each(
            function(){
                if ($(this).attr('class')=="pic2") {
                    //selectedCount=selectedCount+1;
                    if (shopIds != "") {
                        shopIds = shopIds + "," + $(this).attr("shopId");
                    } else {
                        shopIds = $(this).attr("shopId");
                    }
                }
            }
        );
        $("#shopIds").val(shopIds);
        //$("#selectedCount").text(selectedCount);
    });
	$(".role_set_main div span").click(function(){
		$(this).toggleClass("window_i")
	})
	$(".admin_bottom_option_bottom>p>a").click(function(){
		$(this).toggleClass("pic2")
	})
	$(".checkbox").click(function(){
		$(this).toggleClass("checkbox_one").siblings().removeClass("checkbox_one")
	})
	//账号管理
	$(".admin_bottom_nav>li>input:last").click(function(){
		$(this).next(".admin_bottom_select").toggle()
	})
	$(".admin_bottom_nav1>li>input:last").click(function(){
		$(this).next(".admin_bottom_select").toggle()
	})
	$(".admin_bottom_box>div.new_admin").on("click",function(){
		$(".admin_top").hide()
		$(".admin_wrap").show()
		$(".admin_new_admin").show()
		// $(".rgba").show()
	})
	$(".admin_bottom_box>div.new_shop").on("click",function(){
		$(".admin_top").hide()
		$(".admin_new_admin").hide()
		$(".admin_wrap").show()
		$(".admin_new_admin1").show()
		// $(".rgba").show()
	})
	$(".abolish").click(function(){
		$(".admin_wrap").hide()
		$(".admin_new_admin1").hide()
		$(".admin_top").show()
		// $(".rgba").hide()

	})
	$(".admin_bottom_option_bottom>p>a").click(function(){
		$(this).toggleClass("pic2").siblings().removeClass("pic2")
	})
	$(".content_m>p>a").click(function(){
		$(this).toggleClass("pic2").siblings().removeClass("pic2")
	})
	//支付配置
	$(".left_nav>li").click(function(){
		$(this).addClass("first").siblings().removeClass("first")
		$(".right>div").eq($(this).index()).show().addClass("right_wrap").siblings().hide().removeClass("right_wrap")
		$(".top").show().next().hide()
	})
	$(".right_nav>li").click(function(){
		$(this).addClass("one").siblings().removeClass("one")
		$(".border-bottom_wrap>div").eq($(this).index()).addClass("right_bottom").siblings().removeClass("right_bottom")
	})
	$(".alipay").click(function(){
		$(".alipay_box").toggle()
	})
	$(".alipay_box>p").on("click",function(){
		var text=$(this).text();
		$(".alipay").val(text);
		$(".alipay_box").hide()
		$(".right_bottom>ul").eq($(this).index()).addClass("right_bottom_nav").siblings().removeClass("right_bottom_nav")
	})
	$(".last>a").click(function(){
		if($(".alipay").val()==""){
			$(".last_wrap").hide()
		}else{
			$(".last_wrap").show()
		}
	})
	$(".select_one>p").click(function(){
		$(this).addClass("word_one").siblings().removeClass("word_one")
		$(".select_word").html("")
		var text=$(".word_one").text();
		$(".select_word").show().text(text)
	})
	
	$(".last_select_one>p").click(function(){
		$(this).addClass("last_word_one").siblings().removeClass("last_word_one")
		$(".last_select_word").html("")
		var text=$(".last_word_one").text();
		$(".last_select_word").show().text(text)
		
	})
	$(".abolish").click(function(){
		$(".last_wrap").hide()	
	})
	$(".delete").click(function(){
		$(".last_wrap").hide()	
	})
	$(".save").click(function(){
		$(".last_wrap").hide()
	})
})
