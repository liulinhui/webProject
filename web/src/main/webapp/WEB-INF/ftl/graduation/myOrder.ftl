<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Language" content="zh-CN" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>我的订单</title>
<link rel="shortcut icon"
	href="/SpringMvcStudy/resource/images/images2/war.ico"
	type="image/x-icon">
	<link rel="stylesheet" type="text/css"
		href="/SpringMvcStudy/resource/css/otc_sell.css" />
	<link rel="stylesheet" type="text/css"
		href="/SpringMvcStudy/resource/css/css-table.css" />
	<link rel="stylesheet" type="text/css"
		href="/SpringMvcStudy/resource/css/headerfooter.css" />
	<link rel="stylesheet" type="text/css"
		href="/SpringMvcStudy/resource/css/table.css" />
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
				</#if> <a href="./myOrder"
					style="color: #1f567c; font-weight: bold;">我的订单</a>
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
				<a href="./otc">首页</a><a href="./myproduct">我要转让</a><a
					href="./myAsset">我的账户</a>
			</div>
			<p class="breadcrumb">
				<a href="">毕业设计</a><a href="">>OTC转让专区</a>
			</p>
		</div>
	</div>
	<div id="main">
		<div class="inner">
			<div class="blank"></div>
			<div class="bill" style="-moz-user-select: -moz-none;"
				onselectstart="return false;">
				<div class="header" style="text-align: center; margin: 0 auto;">
					<h3 style="font-size: 40px;">您的订单详情</h3>
				</div>
				<table id="travel">
					<thead>
						<tr
							style="font-size: 30px; font-family: Verdana; color: #6C6C6C; font-weight: bold">
							<th scope="col" rowspan="2">产品名称</th>
							<th scope="col" colspan="10">详细信息</th>
						</tr>

						<tr>
							<th scope="col">产品代码</th>
							<th scope="col">预计年化收益率</th>
							<th scope="col">到期时间</th>
							<th scope="col">买入份额</th>
							<th scope="col">买入价格</th>
							<th scope="col">金额</th>
							<th scope="col">买入时间</th>
							<th scope="col">风险</th>
							<th scope="col">状态</th>
							<th scope="col">操作</th>
						</tr>
					</thead>
					<tbody>
						<#if order??> <#list order as item>
						<tr>
							<th scope="row"
								style="font-size: 15px; font-weight: bold; font-family: kaiti;">${item.product_name!''}</th>
							<td>${item.product_code!''}</td>
							<td>${item.reference_income!''}&nbsp%</td>
							<td>${item.limit_time!''}</td>
							<td>${item.buy_amount!''}</td>
							<td>￥${item.price!''}</td>
							<td>￥${item.total_money!''}</td>
							<td>${item.buy_time!''}</td> <#if item.risk=='1'>
							<td>低</td> </#if> <#if item.risk=='2'>
							<td>高</td> </#if> <#if item.status=='2'>
							<td><a id=${item.id!''} class="underline"
								style="font-size: 16px; font-weight: bold; font-family: kaiti;">已付</a></td>
							<td><a id=${item.id!''} class="underline delete"
								href="javascript:void(0)"
								style="font-size: 16px; font-weight: bold; font-family: kaiti;">删除记录</a></td>
							</#if> <#if item.status=='1'>
							<td><a id=${item.id!''} class="underline payNow"
								href="javascript:void(0)"
								style="color: #FF0000; font-family: kaiti; font-size: 16px; font-weight: bold;">立即支付</a></td>
							<td><a id=${item.id!''} class="underline delete"
								href="javascript:void(0)"
								style="font-size: 16px; font-weight: bold; font-family: kaiti;">取消订单</a></td>
							</#if> <#if item.status=='3'>
							<td><a id=${item.id!''} class="underline"
								style="color: #FF0000; font-family: kaiti; font-size: 16px; font-weight: bold;">交易停止</a></td>
							<td><a id=${item.id!''} class="underline"
								style="font-size: 16px; font-weight: bold; font-family: kaiti;">删除记录</a></td>
							</#if>
						</tr>
						</#list> </#if> <#if order?size==0>
						<div style="margin: 276px; position: absolute;">
							<div style="color: #666666;">
								您暂时还没有任何产品,逛逛<a href="./otc" class="order"><img
									src="/SpringMvcStudy/resource/images/images2/exchange_market_button.png"
									style="margin: -10px 12px;"></img></a>吧
							</div>
						</div>
						</#if>
					</tbody>
				</table>
			</div>
		</div>
		<div class="blank"></div>
	</div>
	<!--弹出层  -->
	<!--弹出层时背景层DIV-->
	<div id="Myfade" class="black_overlay"></div>
	<div id="MyDiv" class="white_content">
		<div class="con">
			<div class="content1">
				<a class="content2">支&nbsp;付</a>
			</div>
		</div>
		<hr />
		<ul style="list-style: none;">
			<li><a><h2>
						产品代码:<span class="xiangxi1 xiangxi"></span>
					</h2></a></li>
			<li><a><h2>
						产品名称:<span class="xiangxi2 xiangxi" style="font-size: 17px;"></span>
					</h2></a></li>
			<li><a><h2>
						购买数量:<span class="xiangxi3 xiangxi"></span>
					</h2></a></li>
			<li><a><h2>
						支付金额:<span class="xiangxi4 xiangxi"></span>
					</h2></a></li>
		</ul>
		<hr />
		<button id="" class="confirm_pay">
			<a style="color: #FF8000;" href="javascript:void(0)">确认</a>
		</button>
		<button class="cancel_pay">
			<a style="color: #FF8000;" href="javascript:void(0)">取消</a>
		</button>
	</div>
	<div class="white_content2">
		<div>
			<p class="jiazai1">正在支付，请稍等...</p>
		</div>
		<div class="container123">
			<div class="warning123"></div>
		</div>
	</div>
	<div class="white_content3">
		<div class="content1">
			<a class="content2">提&nbsp;醒</a>
		</div>
		<div class="lowemoney">
		     <a>您的资金不足，请赶紧充钱吧！</a>
		</div>
		<button class="cancel_pay1">
			<a style="color: #FF8000;" href="javascript:void(0)">确定</a>
		</button>
	</div>

	<!--弹出层  -->
	<script>
		$(document).ready(function() {
			//  弹出隐藏层
			function ShowDiv() {
				$('#MyDiv').show();
				$('#Myfade').show();
				$('#Myfade').height($(document).height());
			}
			;

			$('tbody tr').hover(function() {
				$(this).addClass('odd');
			}, function() {
				$(this).removeClass('odd');
			});
			$('.delete').click(function() { //取消订单
				var id = $(this).attr("id");
				$('#Myfade').show();
				setTimeout(function(){
					$.ajax({
						url : "./deleteOrder",
						datatype : "json",
						async : false, //设置为同步进行
						data : {
							id : id
						},
						type : "POST",
						success : function(data) {
							$('#Myfade').hide();
							window.location.reload();
						}
					});
				},1000);
			});
			//获取支付产品信息
			$('.payNow').click(function() {
				var id = $(this).attr("id");
				var product;
				$.ajax({
					url : "./pay",
					datatype : "json",
					async : false,
					data : {
						id : id
					},
					type : "POST",
					success : function(data) {
						product = data.order;
						$('.xiangxi1').text(product.product_code);
						$('.xiangxi2').text(product.product_name);
						$('.xiangxi3').text(product.buy_amount+"份");
						$('.xiangxi4').text(product.total_money + "元");
						$('.confirm_pay').attr("id", product.id);
						ShowDiv();
					}
				})
			});
			//取消购买，关闭弹窗
			$('.cancel_pay').click(function() {
				$('#MyDiv').hide();
				$('#Myfade').hide();
			});
			$('.cancel_pay1').click(function() {
				$('.white_content3').hide();
				$('#Myfade').hide();
			});
			//确认购买
			$('.confirm_pay').click(function() {
				$('#MyDiv').hide();
				$('.white_content2').show();
				var id = $(this).attr("id");
				var state;
				$.ajax({
					url : "./confirmPay",
					datatype : "json",
					async : false,
					data : {
						id : id
					},
					type : "POST",
					success : function(data) {
						state = data.result;
						if (state == "false") {
							setTimeout(function() {
								$('.white_content2').hide();
								$('.white_content3').show();
							}, 1500);
						} else {
							setTimeout(function() {
								$('.white_content2').hide();
								$('#Myfade').hide();
								window.location.reload();
							}, 2000);
						}
					}
				})
			});
		});
	</script>
	<div id="footer-nf">
		<div>
		<p class="footer-weiba">基于SpringMVC的理财产品转让系统设计</p>
		</div>
		</div>
</body>
</html>
