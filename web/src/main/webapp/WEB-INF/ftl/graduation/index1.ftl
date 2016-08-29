<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Language" content="zh-CN" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>转让市场首页</title>
<link rel="shortcut icon"
	href="/SpringMvcStudy/resource/images/images2/No_Smoking.ico"
	type="image/x-icon">
	<link rel="stylesheet" type="text/css"
		href="/SpringMvcStudy/resource/css/index.css" />
	<link rel="stylesheet" type="text/css"
		href="/SpringMvcStudy/resource/css/headerfooter.css" />
	<link rel="stylesheet" type="text/css"
		href="/SpringMvcStudy/resource/css/table.css" />
	<link rel="stylesheet" type="text/css"
		href="/SpringMvcStudy/resource/css/banner.css" />
	<link rel="stylesheet" type="text/css"
		href="/SpringMvcStudy/resource/css/AlertDIV.css" />
	<link rel="stylesheet" type="text/css"
		href="/SpringMvcStudy/resource/css/lrtk.css" />
	<script type="text/javascript"
		src="/SpringMvcStudy/resource/js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript"
		src="/SpringMvcStudy/resource/js/script.headerfooter.js"></script>
	<script type="text/javascript"
		src="/SpringMvcStudy/resource/js/index.js"></script>
</head>
<body>
	<div class="header-top">
		<div class="h-inner">
			<div class="tel">
				毕业设计：<em>基于SpringMvc的理财产品转让系统设计</em>
			</div>
			<div class="links">
				<#if !reg??> <a id="login" href="./account_Login"
					style="display: black">登录/注册</a> </#if> <#if reg??> <a id="reg"
					href="./logout" class="${reg!''}" style="display: black">注销：【${reg!"测试" }】</a>
				</#if> <a href="./myOrder">我的订单</a>
			</div>
		</div>
	</div>
	<div class="header-con">
		<div class="h-inner">
			<a href="./otc" id="logo"><img
				src="/SpringMvcStudy/resource/images/images2/logo.jpg"></a>
			<div class="h-search">
				<input type="text" id="s-input" placeholder="名称/代码" /> <a 
					id="s-btn" title="搜索">搜索</a>
				<div id="s-result">
					<ul class="s-search" style="list-style:none;height: 165px;overflow: scroll;">
					</ul>
				</div>
			</div>
			<div class="nav">
				<a href="./otc" class="active">首页</a><a href="./myproduct">我要转让</a><a
					href="./myAsset">我的账户</a>
			</div>
			<p class="breadcrumb">
				<a href="">毕业设计</a><a href="">>OTC转让专区</a>
			</p>
		</div>
	</div>
	<div id="main">
		<div class="inner">
			<div class="banner">
				<div class="banner-center">
					<img class="banner-images"
						src="/SpringMvcStudy/resource/images/images/banner.jpg" />

				</div>
			</div>
			<div class="pro-table">
				<div class="title">
					<h4 class="title">转让专区</h4>
				</div>
				<table>
					<thead>
						<tr>
							<th style="width: 40px;"></th>
							<th class="name">产品名称</th>
							<th class="id">原预期年化<br>收益率</th>
							<th class="rate"><span>买入后参考</span><br><span>年化收益率</span><a
									style="position: absolute; margin: -9px -1px; height: 29px;"
									href="javascript:void(0)"><img class="filter"
										src="/SpringMvcStudy/resource/images/images2/filter_down_square.png"></img></a></th>
							<th class="period">剩余期限<a href="javascript:void(0)"><img
									class="filter"
									src="/SpringMvcStudy/resource/images/images2/filter_down_square.png"></img></a></th>
							<th class="period">转让份额<a href="javascript:void(0)"><img
									class="filter"
									src="/SpringMvcStudy/resource/images/images2/filter_down_square.png"></img></a></th>
							<th class="amount">转让金额/元<a href="javascript:void(0)"><img
									class="filter"
									src="/SpringMvcStudy/resource/images/images2/filter_down_square.png"></img></a></th>
							<th class="risk">风险<a href="javascript:void(0)"><img
									class="filter"
									src="/SpringMvcStudy/resource/images/images2/filter_down_square.png"></img></a></th>
							<th class="start">发布时间</th>
							<th class="status">购买状态</th>
							<th style="width: 40px;"></th>
						</tr>
					</thead>
					<tbody id="otc">
						<div>
							<a href="./buy"> <#if products??> <#list products as item>
								<tr id="${item.id!""}">
									<td></td>
									<td class="name"><img class="trans"
										src="/SpringMvcStudy/resource/images/images2/trans.png"></img>${item.product_name!""}<p>(代码：${item.product_code!"" })</p></td>
									<td class="id">${item.plan_income!"6.65" }%</td>
									<td class="rate">${item.reference_income!"" }<span
										class="per">%</span></td>
									<td class="period">${item.lastdate!"" }天</td>
									<td class="amount">${item.transfer_account!"13,799,000" }</td>
									<td class="amount">${item.transfer_capital!"13,799,000" }</td>
									<#if item.risk=="1">
									<td class="risk">低</td> </#if> <#if item.risk=="2">
									<td class="risk">高</td> </#if>
									<td class="start">${item.public_date!"2015/01/08"}</td>
									<#if item.state=="0">
									<td class="status"><a class="status cancel"
										id="${item.id!""}"><img
											src="/SpringMvcStudy/resource/images/images2/cancel_button.png"></img></a></td></#if>
									<#if item.state=="1">
									<td class="status"><a
										href="./buy?status=${item.state!''}&id=${item.id!''}"><img
											src="/SpringMvcStudy/resource/images/images2/buy_button.png"></img></a></td></#if>
									<#if item.state=="2">
									<td class="status"><a
										href="./buy?status=${item.state!''}&id=${item.id!''}"><img
											src="/SpringMvcStudy/resource/images/images2/sellout_button.png"></img></a></td></#if>
									<td></td>
								</tr> </#list> </#if>
							</a>
						</div>
					</tbody>
				</table>
			</div>
		</div>

		<!--弹出层  -->
		<!--弹出层时背景层DIV-->
		<div id="Myfade" class="black_overlay"></div>
		<div id="MyDiv" class="white_content" style="position: fixed">
			<div class="con">
				<div class="content1">
					<a class="content2">撤&nbsp;单</a>
				</div>
			</div>
			<hr />
			<ul style="list-style: none;">
				<li><a><h2>
							产品代码:<span class="xiangxi1 xiangxi">12315</span>
						</h2></a></li>
				<li><a><h2>
							产品名称:<span class="xiangxi2 xiangxi" style="font-size: 17px;">12315</span>
						</h2></a></li>
				<li><a><h2>
							剩余数量:<span class="xiangxi3 xiangxi">12315</span>
						</h2></a></li>
				<li><a><h2>
							发布时间:<span class="xiangxi4 xiangxi">12315</span>
						</h2></a></li>
			</ul>
			<hr />
			<button id="" class="confirm_buy" ><a style="color:#FF8000;" href="javascript:void(0)">确认</a></button>
			<button class="cancel_buy" onclick="CloseDiv1('MyDiv','Myfade')"><a style="color:#FF8000;" href="javascript:void(0)">取消</a></button>
		</div>
		<div class="white_content2">
			<div>
				<p class="jiazai1">正在撤单，请稍等...</p>
			</div>
			<div class="container123">
				<div class="warning123"></div>
			</div>
		</div>

		<!--弹出层  -->

		<div id="footer-nf">
		<div>
		<p class="footer-weiba">基于SpringMVC的理财产品转让系统设计</p>
		</div>
		</div>
		<script>
//  弹出隐藏层
  function ShowDiv(){
  	$('#MyDiv').show();
  	$('#Myfade').show();
  	$('#Myfade').height($(document).height());
  	var id=$(this).attr("id");
  };
//  关闭弹出层
$('.confirm_buy').click(function(){
	$('#MyDiv').hide();
  	//$('#Myfade').hide();
	$('.white_content2').show();
  	var id=$(this).attr("id");
  	 $.ajax({
		  url:"./cancelProduct",
		  datatype : "json",
			 async : false,         //设置为同步
			  data : {id : id },
			  type : "POST",
		   success : function(data) {
				if (data.result=="true") {
					setTimeout(function(){
						$('.white_content2').hide();
						$('#Myfade').hide();
						window.location.reload();
					},2000);
				}else if (data.result=="false") {
					setTimeout(function(){
						alert("撤单失败，请稍后再试 ");
						$('.white_content2').hide();
						$('#Myfade').hide();
						window.location.reload();
					},2000);
				}			
		   }		
	  });
});
  function CloseDiv1(show_div,bg_div)
  {
  	$('#MyDiv').hide();
  	$('#Myfade').hide();
  };
  $('.cancel').click(function(){
	  var id=$(this).attr("id");
	  var product;
	  $.ajax({
		  url:"./choseCancelPro",
		  datatype : "json",
			 async : false,         //设置为同步进行
			  data : {id : id },
			  type : "POST",
		   success : function(data) {
			   product=data.product;
			   $('.xiangxi1').text(product.product_code);
			   $('.xiangxi2').text(product.product_name);
			   $('.xiangxi3').text(product.rest_account);
			   $('.xiangxi4').text(product.public_date);
			   $('.confirm_buy').attr("id",product.id);
			   ShowDiv();
		   }		
	  });
  });
  </script>
</body>
</html>
