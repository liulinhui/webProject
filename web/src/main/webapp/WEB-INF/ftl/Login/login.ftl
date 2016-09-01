<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<#assign staticPath="/resources">
    <meta charset="utf-8">
    <title>用户登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- CSS -->
    <link rel="stylesheet"
          href="${staticPath}/css/graduation/login/reset.css">
    <link rel="stylesheet"
          href="${staticPath}/css/graduation/login/style.css">
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>
<div class="page-container">
    <h1>登录</h1>

    <form action="loginCon" method="post">
        <input type="text" name="user_code" class="usercode" placeholder="账号">
        <input type="password" class="password" name="user_password" placeholder="密码">
        <#--<div style="display:none"><input type="password" name="user_password" class="password1" placeholder="密码"></div>-->
        <div class="warning">
            <button class="submit1">登录</button>
        </div>
        <div class="error">
            <span>+</span>
        </div>
    </form>
</div>
<script src="${staticPath}/js/graduation/common/jquery-1.8.2.min.js"></script>
<script src="${staticPath}/js/graduation/login/supersized.3.2.7.min.js"></script>
<script src="${staticPath}/js/graduation/login/supersized-init.js"></script>
<script type="text/javascript">
    //加密过程
    $('.submit1').click(function () {
        $('form').submit();
    })
</script>
</body>
</html>


