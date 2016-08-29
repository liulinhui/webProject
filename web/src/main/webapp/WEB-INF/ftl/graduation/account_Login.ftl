<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="utf-8">
<title>用户登录</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- CSS -->
<link rel="shortcut icon"
	href="/SpringMvcStudy/resource/images/images2/No_Smoking1.ico"
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
		<h1>登录</h1>
		<form action="account_Login" method="post">
			<input type="text" name="user_code" class="usercode" placeholder="账号">
			<input type="password" class="password" placeholder="密码">
			<div style="display:none"><input type="password" name="user_password" class="password1"  placeholder="密码"></div>
			<div class="warning">
				<button class="submit1">登录</button>
			</div>
			<div class="error">
				<span>+</span>
			</div>
		</form>
		<a href="./account_Reg"><button>立即注册</button></a>
	</div>
	<script src="/SpringMvcStudy/resource/assets/js/jquery-1.8.2.min.js"></script>
	<script
		src="/SpringMvcStudy/resource/assets/js/supersized.3.2.7.min.js"></script>
	<script src="/SpringMvcStudy/resource/assets/js/supersized-init.js"></script>
	<script src="/SpringMvcStudy/resource/assets/js/scripts.js"></script>
	<script type="text/javascript" src="/SpringMvcStudy/resource/js/des.js"></script>
	<script type="text/javascript" src="/SpringMvcStudy/resource/js/jquery.md5.js"></script>
	<script type="text/javascript">
	var key1,key2,key3;
	
	//ajax向后台请求keys
	var getKey=$(function(){
		
		var pasw=$('.password').val();
		$.ajax({
			url: "./ajaxAccount_login",
			datatype:"json",
			type:"GET",
			success:function(date){
			key1=date.key1;
			key2=date.key2;
			key3=date.key3;
			},
			error:function(){
				alert("密钥发放故障:请联系老子  ");
			}
		});		
	});
	        //加密过程 
	    $('.submit1').click(function(){
	    	var str=$('.password').val();    	       
	    	for(var i=0;i<50;i++){         //对原始密码进行MD5加密 50次                   
	    		str=$.md5(str);
			}
	    	console.log("原密码进行50次MD5迭代加密 "+str);
	    	var enResult=strEnc(str,key1,key2,key3)            //des加密 
	    	for(var i=0;i<100;i++){                           //对密码加密后的值进行MD5加密  防止别人解密获得原始密码
				enResult=$.md5(enResult);
			}
	    	$('.password1').val(enResult);
	    	console.log("des加密后的密文 "+$('.password1').val());
	    	$('form').submit();
	    })
	</script>
</body>
</html>


