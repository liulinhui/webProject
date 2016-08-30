<#compress>
<!DOCTYPE html>
<html>
    <#assign contextPath=CONTEXT />
<head>
    <meta charset="UTF-8">
    <title>test</title>
</head>
<body>
<p>freemarker test========<@test/></p><br>
<p>freemarker test========<@xml_escape/></p><br>
<p>zhujie test========${webTest!"cainima"}</p><br>
<p>${contextPath}</p>
</body>
</html>
</#compress>