<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试 Ajax</title>
<%
	request.setAttribute("path", request.getContextPath());
%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/statics/js/jquery-1.8.3.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/statics/js/ajax.js"></script>
<script type="text/javascript">
		
</script>
</head>
<body>
	<table border="0">
		<tr>
			<td>注册邮箱：</td>
			<td><input type="text" name="email" id="email" /></td>
			<td id="emailJoin"></td>
		</tr>
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="name" id="name" /></td>
			<td id="nameJoin"></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="text" name="pwd" id="pwd" /></td>
			<td id="pwdJoin"></td>
		</tr>
		<tr>
			<td>确认密码：</td>
			<td><input type="text" name="password" id="password" /></td>
			<td id="passwordJoin"></td>
		</tr>
		<tr>
			<td colspan="3" style="text-align: center;"><input type="button"
				value="注册" onclick="ajax();" /></td>
		</tr>
	</table>
</body>
</html>