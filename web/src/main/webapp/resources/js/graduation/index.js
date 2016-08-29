$(document).ready(function(){

	//Toggle chat table
	$(".chat-table tbody").hide();
  $("span#showhide").click(function(){
		$(".chat-table tbody").toggle();
  });

	//Filter by ascending or descending order
  $("img.filter").click(function(){
		$('img.filter').each(function(){
			if ($(this).attr('src')=='/SpringMvcStudy/resource/images/images2/filter_down_active.png') {
				$(this).attr('src','/SpringMvcStudy/resource/images/images2/filter_down_square.png');
			}	else if($(this).attr('src')=='/SpringMvcStudy/resource/images/images2/filter_up_active.png') {
				$(this).attr('src','/SpringMvcStudy/resource/images/images2/filter_up_square.png');
			}
		});
		$(this).attr('src',$(this).attr('src')=='/SpringMvcStudy/resource/images/images2/filter_down_square.png'||$(this).attr('src')=='/SpringMvcStudy/resource/images/images2/filter_down_active.png'?'/SpringMvcStudy/resource/images/images2/filter_up_active.png':'/SpringMvcStudy/resource/images/images2/filter_down_active.png');
	});

	$('div#selup').click(function(){
		var price = parseInt($('input[name=price]').val()) || 0;
		$('input[name=price]').attr('value', price +1);
	});

	$('div#seldown').click(function(){
		var price = parseInt($('input[name=price]').val()) || 0;
		$('input[name=price]').attr('value', price -1);
	});
	//hover table
	$('table tbody#otc tr').mouseover(function(){
		$(this).addClass('bg');
	});
	$('table tbody#otc tr').mouseout(function(){
		$(this).removeClass('bg');
	});
});
