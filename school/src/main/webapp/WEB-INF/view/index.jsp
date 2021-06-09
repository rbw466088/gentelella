<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>标准信息列表</title>
<%
	request.setAttribute("path",request.getContextPath());
%>
<script type="text/javascript" src="${path}/statics/js/jquery-1.8.3.js"></script>

<script type="text/javascript">
	alert("-------------");
	$(function () {
		alert("++++++++++");
	});
</script>
</head>
<body>
<h2>Hello World!${keys} ${key}</h2>
<div>
	<form action="showInfo" method="post">
		请输入useCode:<input type="text" name="name" />
		<input type="submit" />
		${name}
	</form>
	
</div>
</body>
</html>
