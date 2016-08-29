<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>理财产品转让平台</title>
  <link rel="shortcut icon" href="/SpringMvcStudy/resource/images/images2/favicon.ico" type="image/x-icon">
<link href="/SpringMvcStudy/resource/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form class="form" commandName="product" action="index" method="post">
<div class="login">
    <div class="box png">
		<div class="logo png"></div>
		<div class="input">
			<div class="log">
				<div class="name">
					<label for="name">用户名</label><input type="text" class="text" id="value_1" placeholder="用户名" name="name" tabindex="1" path="name">
				</div>
				<div class="pwd">
					<label for="password">密　码</label><input type="password" class="text" id="value_2" placeholder="密码"  tabindex="2" path="password">
					<input style="display:none" type="password" class="text" id="value_3" placeholder="密码" name="password" tabindex="2" path="password"></div>
					<input  class="submit" tabindex="3" value="登录">
					<div class="check"></div>
				</div>
				<div class="tip"></div>
			</div>
		</div>
	</div>
    <div class="air-balloon ab-1 png"></div>
	<div class="air-balloon ab-2 png"></div>
    <div class="footer"></div>
</div>
</form>
<script type="text/javascript" src="/SpringMvcStudy/resource/js/jQuery.js"></script>
<script type="text/javascript" src="/SpringMvcStudy/resource/js/fun.base.js"></script>
<script type="text/javascript" src="/SpringMvcStudy/resource/js/script.js"></script>
<script type="text/javascript" src="/SpringMvcStudy/resource/js/des.js"></script>

<script >
$(function(){
	$(".submit").click(function(){
		var str=$("#value_2").val();
		var enResult=strEnc(str,"ddfdvdda","sdgfdhgkifgth","gryftgndfrh");
		$("#value_3").val(enResult);
		//alert($("#value_3").val());
		$('form').submit();
	})
})
</script>
</body>
</html>