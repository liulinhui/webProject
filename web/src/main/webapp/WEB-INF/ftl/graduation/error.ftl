
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录界面</title>
  <link rel="shortcut icon" href="/SpringMvcStudy/resource/images/images2/No_Smoking5.ico" type="image/x-icon">
<link href="/SpringMvcStudy/resource/css/login.css" rel="stylesheet"
	type="text/css" />

</head>
<body>


	<div class="login">
		<div class="box png">
			<div class="logo png"></div>
			<div class="input">
				<div class="log">
					<div class="name">
						<h2 style="color: red">${errorMes!'特别提醒：您的操作不正确或是系统崩溃了，赶紧联系我！！！！！'}</h2>
						</br>
						<h5 style="color: blue">联系方式：120</h5>
						<input type="submit" id="return" class="return"
							onclick="javascript:history.go(-1);" value="返回上一页">
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


	<script type="text/javascript"
		src="/SpringMvcStudy/resource/js/jQuery.js"></script>
	<script type="text/javascript"
		src="/SpringMvcStudy/resource/js/fun.base.js"></script>
	<script type="text/javascript"
		src="/SpringMvcStudy/resource/js/script.js"></script>



</body>
</html>