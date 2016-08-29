<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Language" content="zh-CN" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>我的资产</title>
<link rel="shortcut icon"
	href="/SpringMvcStudy/resource/images/images2/No_Smoking6.ico"
	type="image/x-icon">
	<link rel="stylesheet" type="text/css"
		href="/SpringMvcStudy/resource/css/otc_sell.css" />
	<link rel="stylesheet" type="text/css"
		href="/SpringMvcStudy/resource/css/myAsset-css-table.css" />
	<link rel="stylesheet" type="text/css"
		href="/SpringMvcStudy/resource/css/headerfooter.css" />
	<link rel="stylesheet" type="text/css" media="screen"
		href="/SpringMvcStudy/resource/css/myAsset.css" />
	<link rel="stylesheet" type="text/css"
		href="/SpringMvcStudy/resource/css/table.css" />
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
					<ul class="s-search"
						style="list-style: none; height: 165px; overflow: scroll;">
					</ul>
				</div>
			</div>
			<div class="nav">
				<a href="./otc">首页</a><a href="./myproduct">我要转让</a><a
					class="active" href="./myAsset">我的账户</a>
			</div>
			<p class="breadcrumb">
				<a href="">毕业设计</a><a href="">>OTC转让专区</a>
			</p>
		</div>
	</div>
	<div id="main">
		<div class="inner">
			<div class="blank"></div>
			<div class="bill">
				<div class="header user-info" style="height: 45px">
					<a><h3>当前账户信息:</h3></a>
				</div>
				<div id="table" style="-moz-user-select: -moz-none;"
					onselectstart="return false;">
					<table id="travel">
						<thead>
							<tr>
								<th scope="col">用户名</th>
								<th scope="col">用户账号</th>
								<th scope="col">可用资金</th>
								<th scope="col">注册日期</th>
								<th scope="col">充值</th>
							</tr>
						</thead>
						<tbody>
							<#if user??>
							<tr>
								<td>${user.user_name!'---'}</td>
								<td>${user.user_code!'---'}</td>
								<td>${user.user_asset!'---'}￥</td>
								<td>${user.reg_time!'---'}</td>
								<td><a href="./AccountRecharge"><img
										src="/SpringMvcStudy/resource/images/images2/recharge.png" /></a></td>
							</tr>
							</#if>
						</tbody>
					</table>
				</div>
				<div class="header xianshi" style="height: 50px">
					<a href="javascript:void(0);"><h3>
							您当前拥有的产品:<span style="margin: 0 24px;"><span
								style="color: #DF7928; margin-right: 5px;">${account!''}</span>件</span>
						</h3></a>
				</div>
				<div class="display"
					style="display: black; -moz-user-select: -moz-none; overflow: hidden"
					onselectstart="return false;">
					<ul class="pricing_table">
						<#if assets??> <#list assets as item>
						<li class="price_block" style="float: left">
							<h3 style="color: #DB7224">${item.product_code!''}</h3>
							<div class="price">
								<div class="price_figure">
									<span class="price_number" style="font-size: 21px;">${item.product_name!''}</span>
								</div>
							</div>
							<ul class="features">
								<li style="font-weight: bold; font-size: 16px;">${item.account!''}份</li>
								<li style="font-weight: bold; font-size: 15px;">买入时间:${item.limit_time!''}</li>
								<li style="font-weight: bold; font-size: 15px;">年化收益率:${item.plan_income!''}</li>
								<#if item.risk=='1'>
								<li style="font-weight: bold; font-size: 16px;">低风险</li> </#if>
								<#if item.risk=='2'>
								<li style="font-weight: bold; font-size: 16px;">高风险</li> </#if>
							</ul> <#if item.status=="1">
							<div class="footer">
								<a href="./sell?id=${item.id!''}" class="action_button">立即转让</a>
							</div> </#if> <#if item.status=="2">
							<div class="footer">
								<a class="action_button ">正在转让</a>
							</div> </#if>
						</li> </#list> </#if>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$('.xianshi').toggle(function() {
				$('.display').hide();
			}, function() {
				$('.display').show();
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
