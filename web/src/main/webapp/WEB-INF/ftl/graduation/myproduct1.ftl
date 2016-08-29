<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="Content-Language" content="zh-CN" />
  <meta http-equiv="Content-Script-Type" content="text/javascript" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>我拥有的的产品</title>
    <link rel="shortcut icon" href="/SpringMvcStudy/resource/images/images2/No_Smoking7.ico" type="image/x-icon">
  <link rel="stylesheet" type="text/css" href="/SpringMvcStudy/resource/css/otc_sell.css"/>
  <link rel="stylesheet" type="text/css" href="/SpringMvcStudy/resource/css/headerfooter.css"/>
  <link rel="stylesheet" type="text/css" href="/SpringMvcStudy/resource/css/table.css"/>
  <script type="text/javascript" src="/SpringMvcStudy/resource/js/jquery-1.8.2.min.js"></script>
  <script type="text/javascript" src="/SpringMvcStudy/resource/js/script.headerfooter.js"></script>
  <script type="text/javascript" src="/SpringMvcStudy/resource/js/index.js"></script>
 
</head>

<body>
    <div class="header-top">
    <div class="h-inner">
     <div class="tel">毕业设计：<em>基于SpringMvc的理财产品转让系统设计</em></div>
      <div class="links">
        <#if !reg??>      
        <a id="login" href="./account_Login" style="display:black">登录/注册</a> 
        </#if>  
        <#if reg??>         
        <a id="reg" href="./logout" class="${reg!''}" style="display:black">注销：【${reg!"测试" }】</a>
        </#if>              
        <a href="./myOrder">我的订单</a>
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
				<div class="header" style="height:50px">
					<h3>请选择您需要转让的产品</h3>
				</div>
				<#if assets??> 
				<#list assets as item>
				<div class="header">
					<a href="./sell?id=${item.id!''}"><h3>您当前持有<span id="amount">${item.account!''}</span>份 &nbsp; <span id="product">${item.product_name!''}<span>(${item.product_code!''})</span></span></h3></a>
				</div>
				</#list>
				</#if>			
			</div>		
			</div>
			<div class="blank"></div>
    </div> 
   <div id="footer-nf">
		<div>
		<p class="footer-weiba">基于SpringMVC的理财产品转让系统设计</p>
		</div>
		</div>
</body>
</html>
