$(document).ready(function() { 
	var account_flag="false";
	var price_flag="false";
	var permission;
	//右边转让成功动态显示
	function right_tip_show(){    
		var account=$('#exchange_account').val();
		var price=$('#exchange_price').val();
		var plan_income=$('.reference_income').attr("id");
		if (account_flag=="true" && price_flag=="true") {
			$('.Account_income').text((account*price).toFixed(2));
			$('.reference_income').text(plan_income*1.5);
		}
	};
       //  弹出隐藏层
	  function ShowDiv(){
	  	$('#MyDiv').show();
	  	$('#Myfade').show();
	  	$('#Myfade').height($(document).height());
	  };
	  
	  //  关闭隐藏层
	  function HideDiv(){
	  	$('#MyDiv').hide();
	  	$('#Myfade').hide();
	  };
	  $('.cancel_buy').click(function(){
		  HideDiv();
	  });
	//委托数量的input动态动作
	$('#exchange_account').keyup(function(){
		var exchange=$(this).val();
		var amount=parseInt($('#amount').text().replace(/[^0-9]/g,''));  //获取拥有份额
		var rest=amount-exchange;
//		if (exchange=="") {
			$('.count_warn').hide();
			$('.count_warn1').hide();
			$('.count_warn2').hide();
//		}
		if (amount<1000) {
			$('.count_warn1').show();
			price_flag="false";
			return false;
		}
		if (exchange<1000) {
			$('.count_warn').show();
			price_flag="false";
			return false;
		}
		if (rest<1000 && rest!=0) {
			$('.count_warn2').show();
			price_flag="false";
			return false;
		}
		if (exchange>=1000 && amount>=1000 && rest>1000 || rest==0) {
			$('.count_warn').hide();
			account_flag="true";
		}
		right_tip_show();
	});
	//委托价格的动态输入
	$('#exchange_price').keyup(function(){
		var exchange=$(this).val();
		$(this).val(exchange.replace(/^(\-)*(\d+)\.(\d\d).*$/, '$1$2.$3')); //限制两位小数
		exchange=$(this).val();
		if (exchange<1.00) {
			$('.price_warn').show();
		}
		if (exchange>=1) {
			$('.price_warn').hide();
			price_flag="true";
		}
		right_tip_show();
	});
	//check box的控制
	$('.checkbox').click(function(){
		permission=$(this).attr("checked");
	});
	//转让功能
	$('.transfer_confirm').click(function(){
		if (account_flag=="false" || price_flag=="false" || permission==null) {
			return false;
		}else{
			var account=$('#exchange_account').val();
			var price=$('#exchange_price').val();
			$('.xiangxi3').text(account+"份");
			$('.xiangxi4').text((price*1.0).toFixed(2)+"元");
			ShowDiv();
		}
	});
	$('.confirm_buy').click(function(){
		var id=$('.transfer_confirm').attr("id");
		var account=$('#exchange_account').val();
		var price=$('#exchange_price').val();
		var Account_income=$('.Account_income').text();
		var reference_income=$('.reference_income').text();
		HideDiv();
		$('#Myfade').show();
		$('.white_content2').show();
		$.ajax({
			url:"./exchange",
			datatype:"json",
			async:"false",
			data:{id:id,account:account,price:price,Account_income:Account_income,reference_income:reference_income},
			type : "POST",
			success:function(data){
				if (data.result=="true") {
					setTimeout(function(){
						$('#Myfade').hide();
						$('.white_content2').hide();},2000);
//					$('.confirm_buy123').attr("target","_blank");
//					$('.confirm_buy123').attr("href","./transfer_confirm");
					location.href="./transfer_confirm"
				}
			}
		});
	});
}); 