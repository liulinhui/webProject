$(function() {
// //用户注销
// $(".header-top #reg").click(function(){
//	    
// $.ajax({
// url: "./count",
// async: false,
// data:{},
// type: 'POST',
// success: function (data) {
// if (data < 0) {
// hint("<spam style='font-weight:bold'>买家预期年化收益率小于零!</spam><br>&emsp;");
// $("input[name='price']").val(priceMinValue);
// }
// var rate1 = (parseFloat(data) * 100).toFixed(2);
// $("#rate").text(rate1);
// countnum();
// setTotal();
// }
// });
//        
//		
//		
// })

	$("#float-bar .back-top").click(function() {
		$('html,body').animate({
			'scrollTop' : '0'
		})
	})

	$("#float-bar").mouseenter(function() {
		if ($(this).hasClass('opened')) {
			$(this).removeClass('opened');
			$('#float-bar').animate({
				'right' : '-77px'
			});
		} else {
			$(this).addClass('opened');
			$('#float-bar').animate({
				'right' : '0'
			});
		}
	})

	$("#float-bar").mouseleave(function() {
		if ($(this).hasClass('opened')) {
			$(this).removeClass('opened');
			$('#float-bar').stop(true, false).animate({
				'right' : '-77px'
			});
		} else {
			$(this).addClass('opened');
			$('#float-bar').animate({
				'right' : '0'
			});
		}
	})

	$("a.qr-btn").hover(function() {
		var rel = $(this).attr('rel');
		$('#' + rel).stop(true, false).fadeIn();
	}, function() {
		var rel = $(this).attr('rel');
		$('#' + rel).stop(true, false).fadeOut();
	})

	$('#footer-nf .f-select').click(function(e) {
		if ($(this).hasClass('opened')) {
			$(this).find('.links-box').slideUp();
			$(this).removeClass('opened')
		} else {
			$(this).find('.links-box').slideDown();
			$(this).addClass('opened')
		}
		e.stopPropagation();
	});
	$('#footer-nf').click(function() {
		var fSelect = $(this).find('.f-select');
		if (fSelect.hasClass('opened')) {
			fSelect.find('.links-box').slideUp();
			fSelect.removeClass('opened')
		}
	});

	$('.h-search #s-input').keyup(function() {
		var info=$('.h-search #s-input').val();
		$.ajax({
			url:"./fuzzyMatch",
		  datatype : "json",
			   data: {info:info},
			 async : false,         // 设置为同步进行
			  type : "POST",
		   success : function(data) {
			   var childhtml="<li><a style="+"'display:none'"+">----</a></li>";
			    $.each(data.matchs, function(i, item) {
			      childhtml += '<li><a href='+'"./buy?status='+item.state+'&id='+item.id+'">'+item.product_name+'</li>';
			   });
			    $('.s-search').html(childhtml);
		   }		
		});
		$('.h-search #s-result').addClass('opened').fadeIn();
	})
	$('.h-search').mouseleave(function() {
		if ($('.h-search #s-result').hasClass('opened')) {
			$('.h-search #s-result').removeClass('opened').fadeOut();
		}
		;
	})
})