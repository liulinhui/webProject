<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Language" content="zh-CN" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>交易页面</title>
<link rel="shortcut icon"
	href="/SpringMvcStudy/resource/images/images2/No_Smoking9.ico"
	type="image/x-icon">
	<link rel="stylesheet" type="text/css"
		href="/SpringMvcStudy/resource/css/otc_buy.css" />
	<link rel="stylesheet" type="text/css"
		href="/SpringMvcStudy/resource/css/headerfooter.css" />
	<link rel="stylesheet" type="text/css"
		href="/SpringMvcStudy/resource/css/table.css" />
	<link rel="stylesheet" type="text/css"
		href="/SpringMvcStudy/resource/css/buy_AlertDIV.css" />
	<script type="text/javascript"
		src="/SpringMvcStudy/resource/js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript"
		src="/SpringMvcStudy/resource/js/script.headerfooter.js"></script>
	<script type="text/javascript"
		src="/SpringMvcStudy/resource/js/index.js"></script>
	<!--[if IE 6]>
  <script src="./js/DD_belatedPNG_0.0.8a.js" type="text/javascript"></script>
  <script type="text/javascript">
    DD_belatedPNG.fix('#wx-qr img,#sj-qr img,#footer-nf .img-box img,#float-bar .handle,#float-bar .btn-set li.ol-im a,#float-bar .btn-set li.buy a,#float-bar .back-top a,#s-btn,#header-nf .header-top .sns a,background');
  </script>
  <![endif]-->
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
				<a href="./otc" class="active">首页</a><a href="./myproduct" >我要转让</a><a
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
			<#if product??>
			<div class="bill">
				<div class="header">
					<img src="/SpringMvcStudy/resource/images/images2/trans.png"></img>
					<h3>
						${product.product_name!"君得金28天期优先级" }<span>代码：${product.product_code!"S32424" }</span>
						<span style="float: right; margin: 0 91px;"><span
							style="color: #646cb8; font-size: 17px;">剩余分额：</span>${product.rest_account!"" }</span>
					</h3>
					<input class="identy" style="display: none" value=${product.id!'' } />
				</div>
				<div class="info">
					<div class="rate">
						<h2>
							${product.reference_income!"11.43" }<span>%</span>
						</h2>
						<h6>参考年化收益率</h6>
						<p>
							<span>单位面值</span> 1.00元/份
						</p>
						<div class="line"></div>
					</div>
					<div class="rate">
						<h2>
							${product.lastdate!"102" }<span>天</span>
						</h2>
						<h6>剩余期限</h6>
						<p>
							<span>转让价格</span> ${product.transfer_price!"" }元/份 <input id="s3"
								style="display: none;" value=${product.transfer_price!"" } />
						</p>
						<div class="line"></div>
					</div>
					<div class="rate">
						<h2>
							<input type="text" maxlength="8" class="fenge" id="s1" /> <span
								class="fengZi" style="margin-left: 92px;">份</span>
						</h2>
						<h6 style="margin-top: 47px;">转让份额</h6>
						<p>
							<span>转让日期</span>${product.public_date!"" }
						</p>
					</div>
					<div class="tip">
						<img src="/SpringMvcStudy/resource/images/images2/tip.png"></img>
						<h5>买家预期年化收益率=(持有期收入之和/转让价格-1)*(365/持有时间)*100%</h5>

					</div>
				</div>
				<div class="confirm">
					<div class="amount">
						<h2>
							<a style="color: #f99325;"><input class="allAccount"
								type="text" id="s2" disabled="disabled" placeholder="0" /></a><span>元</span>
						</h2>
						<h5>投资金额</h5>
					</div>
					<div class="warn">
						<h5 style="margin-left: 10px;">
							当前可用资金：<span id="amount">${RestMoney!"" }</span>元
						</h5>
						<a href="./AccountRecharge"><span id="recharge"></span></a>
					</div>
					<a href="./confirm" onclick="buy();return false;"><div
							class="button" id="conbuy"></div></a>
				</div>
			</div>
			</#if>
		</div>
	</div>

	<!--弹出层  -->
	<!--弹出层时背景层DIV-->
	<div id="Myfade" class="black_overlay"></div>
	<div id="MyDiv" class="white_content" style="position: fixed">
		<div class="con">
			<div class="content1">
				<a class="content2">友情提示</a>
			</div>
		</div>
		<div style="height: 197px;">
			<div style="padding: 59px 69px;">
				<a style="font-family: kaiti;font-weight: bold;font-size: 20px;">当前可购买分额:<span style="color:#FF8000">${product.rest_account!"" }</span>份
				</a>
				<p>请重新选择购买数量</p>
			</div>
		</div>
		<button class="confirm_buy" onclick="CloseDiv()">确认</button>
	</div>
	<div id="MyDiv1" class="white_content" style="position: fixed">
		<div class="con">
			<div class="content1">
				<a class="content2">友情提示</a>
			</div>
		</div>
		<div style="height: 197px;">
			<div style="padding: 59px 69px;">
				<a style="font-family: kaiti;font-weight: bold;font-size: 20px;">你的订单里已经存在:<span style="color:#FF8000">${product.product_name!}(${product.product_code!})</span>
				</a>
				<p>请选择其他理财产品</p>
			</div>
		</div>
		<button class="confirm_buy" onclick="CloseDiv1()">确认</button>
	</div>
	<!--弹出层  -->


	<div id="footer-nf">
		<div>
		<p class="footer-weiba">基于SpringMVC的理财产品转让系统设计</p>
		</div>
		</div>
	<script>
		var o_1 = document.getElementById("s1");
		var o_2 = document.getElementById("s2");
		var o_3 = document.getElementById("s3");
		o_1.onkeyup = function() {
			o_2.value = (((o_1.value) * (o_3.value)) * 1).toFixed(2);
		}
	</script>
	<script>
		function buy() {
			var allAccount = $("#s1").val(); //购买数量 
			var identy = $(".identy").val();
			var total_money=$('.allAccount').val();
			if (allAccount == 0) {
				return false;
			}
			var status;
			//判断购买数量是否超出范围
			$.ajax({
				url : "./confirmAccount",
				datatype : "json",
				async : false, //设置为同步进行
				data : {
					allAccount : allAccount,
					id : identy,
					total_money:total_money
				},
				type : "POST",
				success : function(data) {
					status = data.result;
				}
			});
			if (status == "false") {
				$('#Myfade').show();
				$('#MyDiv').show();
				return false;
			} else if (status == "true") {
				window.location.href = './confirm';
			}else if(status=="had"){
				$('#Myfade').show();
				$('#MyDiv1').show();
				return false;
			}
		};
		function CloseDiv(){
			$('#MyDiv').hide();
			$('#Myfade').hide();
		}
		function CloseDiv1(){
			$('#MyDiv1').hide();
			$('#Myfade').hide();
		}
	</script>
</body>
</html>
