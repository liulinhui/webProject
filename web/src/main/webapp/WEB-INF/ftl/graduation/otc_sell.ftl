<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Language" content="zh-CN" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>转让页面</title>
<link rel="shortcut icon"
	href="/SpringMvcStudy/resource/images/images2/No_Smoking10.ico"
	type="image/x-icon">
	<link rel="stylesheet" type="text/css"
		href="/SpringMvcStudy/resource/css/otc_sell.css" />
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
		src="/SpringMvcStudy/resource/js/otc_cell.js"></script>
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
				<a href="./otc">首页</a><a href="./myproduct" class="active">我要转让</a><a
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
			<div class="bill">
				<div class="header">
					<h3>
						您当前持有<span id="amount">${asset.account!''}</span>份 &nbsp; <span
							id="product">${asset.product_name!''}（${asset.product_code!''}）</span>
					</h3>
				</div>
				<div class="rules">
					<div class="content">
						<h5>交易规则：</h5>
						<p>
							1.<span
								style="font-family: kaiti; color: #F99325; font-size: 17px; font-weight: bold;">${asset.product_name!''}</span>
							最小持有份额为1000份
						</p>
						<p>2.转让后剩余的份额必须大于1000份或者为0</p>
					</div>
				</div>
				<div class="exchange">
					<div class="content">
						<ul class="input">
							<li><span>委托数量</span> <input type="text"
								id="exchange_account" class="exchange" /> <span>份</span>&nbsp;&nbsp;
								<a class="count_warn"><img
									src="/SpringMvcStudy/resource/images/images2/Sellerror.png" />转让数量请大于1000</a>
								<a class="count_warn1"><img
									src="/SpringMvcStudy/resource/images/images2/Sellerror.png" />最小持有1000才可以转让</a>
								<a class="count_warn2"><img
									src="/SpringMvcStudy/resource/images/images2/Sellerror.png" />转让后份额剩余0或者大于1000份</a>
								<p>
									转让份数至少为<span class="red">1000</span>份
								</p></li>
							<li><span>委托价格</span> <input name="price"
								id="exchange_price" class="exchange" type="text"></input> <span>元/份</span>&nbsp;&nbsp;
								<a class="price_warn"><img
									src="/SpringMvcStudy/resource/images/images2/Sellerror.png" />最小报价1.00元</a>
								<p>
									最小报价为<span class="red">1.00</span>元/份
								</p></li>
							<li style="margin-top: 76px;"><input type="checkbox"
								class="hidden-input checkbox" />
								<p class="read">
									我已阅读<a href="./protocol" target="_blank">相关协议</a>并同意开通OTC交易权限
								</p></li>
							<div id=${asset.id!''} style="cursor: pointer;"
								class="button transfer_confirm"></div>
						</ul>
						<div class="info" style="display: block;">
							<h5>若本次转让成功</h5>
							<ul>
								<li><img
									src="/SpringMvcStudy/resource/images/images2/buy_icon.png"></img>
								<p>
										<span class="Account_income">------</span>元
									</p>
									<p>我将获得现金</p></li>
								<li><img
									src="/SpringMvcStudy/resource/images/images2/sell_icon.png"></img>
								<p>
										<span id=${asset.plan_income!''} class="reference_income">---</span>%
									</p>
									<p>预计买家持有到期将获得年化收益率</p></li>
							</ul>
						</div>
						<div class="read"></div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--弹出层  -->
	<!--弹出层时背景层DIV-->
	<div id="Myfade" class="black_overlay"></div>
	<div id="MyDiv" class="white_content" style="position: fixed">
		<div class="con">
			<div class="content1">
				<a class="content2">转&nbsp;让</a>
			</div>
		</div>
		<hr />
		<ul style="list-style: none;">
			<li><a><h2>
						产品代码:<span class="xiangxi1 xiangxi">${asset.product_code!''}</span>
					</h2></a></li>
			<li><a><h2>
						产品名称:<span class="xiangxi2 xiangxi" style="font-size: 17px;">${asset.product_name!''}</span>
					</h2></a></li>
			<li><a><h2>
						转让数量:<span class="xiangxi3 xiangxi"></span>
					</h2></a></li>
			<li><a><h2>
						转让价格:<span class="xiangxi4 xiangxi"></span>
					</h2></a></li>
		</ul>
		<hr />
		<button id="" class="confirm_buy">
			<a style="color: #FF8000;" class="confirm_buy123" href="javascript:void(0)">确认</a>
		</button>
		<button class="cancel_buy" >
			<a style="color: #FF8000;" href="javascript:void(0)">取消</a>
		</button>
	</div>
	<div class="white_content2">
		<div>
			<p class="jiazai1">正在转让，请稍等...</p>
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
</body>
</html>
