<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="utf-8">
<title>注册页面</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- CSS -->
<link rel="shortcut icon"
	href="/SpringMvcStudy/resource/images/images2/No_Smoking2.ico"
	type="image/x-icon">

<link rel="stylesheet"
	href="/SpringMvcStudy/resource/assets/css/reset.css">
<link rel="stylesheet"
	href="/SpringMvcStudy/resource/assets/css/style.css">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
</head>
<body>
	<div class="page-container">
		<h1>注册新用户</h1>
		<form action="account_Reg" method="post">
			<input type="text" name="user_name" class="username"
				placeholder="用户名"> <input type="text" name="user_code"
				class="usercode" placeholder="账号"> <input type="password"
				class="password" placeholder="密码"> <input type="password"
				name="user_password" class="password_1" placeholder="密码"
				style="display: none">

			<div class="error">
				<span>+</span>
			</div>
		</form>
		<button class="submit_1">注册</button>
	</div>
	<script type="text/javascript"
		src="/SpringMvcStudy/resource/assets/js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript"
		src="/SpringMvcStudy/resource/assets/js/supersized.3.2.7.min.js"></script>
	<script type="text/javascript"
		src="/SpringMvcStudy/resource/assets/js/supersized-init.js"></script>
	<script type="text/javascript"
		src="/SpringMvcStudy/resource/assets/js/scripts.js"></script>
	<script type="text/javascript"
		src="/SpringMvcStudy/resource/js/RSA/Barrett.js"></script>
	<script type="text/javascript"
		src="/SpringMvcStudy/resource/js/RSA/BigInt.js"></script>
	<script type="text/javascript"
		src="/SpringMvcStudy/resource/js/RSA/RSA.js"></script>
	<script type="text/javascript"
		src="/SpringMvcStudy/resource/js/jquery.md5.js"></script>
	<script>
		var status;
		var pubilcKey; //公钥 
		$('.submit_1')
				.click(
						function() {
							$.ajax({
								url : "./codeConfirm", //查看账号是否已经被人注册了 
								data : {
									usercode : $('.usercode').attr("value")
								},
								async : false, //设置为同步进行
								datatype : "json",
								type : "POST",
								success : function(data) {
									status = data.status;
								}
							});
							if (status == "exist") {
								alert("用户" + $('.usercode').attr("value")
										+ "已经被别人注册了 ");
							} else if (status == "noexist") {
								$.ajax({ //后台请求公钥参数
									url : "./getPublicKey",
									async : false, //设置为同步进行
									datatype : "json",
									type : "POST",
									success : function(data) {
										pubilcKey = data.pubilcKey; //获取公钥参数
									}
								})

								setMaxDigits(130);
								pubilcKey = new RSAKeyPair("10001", "",
										pubilcKey); //获取公钥 
								var user_password = $('.password_1');
								var password = $('.password').val();
								for (var i = 0; i < 50; i++) { //对原密码MD5加密50次，存入数据库 
									password = $.md5(password);
								}
								password = encryptedString(pubilcKey,
										encodeURIComponent(password)); //rsa公钥加密，第一个参数是加密因子，第二个参数是解密因子
								$('.password_1').val(password); //因为浏览器端不需要解密，所以第二个参数传入空字符串
								$('form').submit();
							}
						});
	</script>
</body>
</html>


