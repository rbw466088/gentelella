<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<style type="text/css">
*{
	margin: 0;
	padding: 0;
}
#body{
	width:500px;
	margin: 0px auto;
}
.table {
	width: 100%;
}
table {
	width: 100%;
}
td{
	height:30px;
	line-height: 30px;
}
</style>
</head>
<%
	request.setAttribute("path", request.getContextPath());
%>
<script type="text/javascript" src="${path}/statics/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path}/statics/js/ajax.js"></script>
<body>
	<div id="body">
		<div class="table">
			<form action="ajaxAddUser" method="post" id="myForm" >
				<table border="0" cellpadding="0" cellspacing="0">
					<thead>
						<tr>
							<td colspan="3" style="text-align: center;background-color: red">用户注册</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="lefts">用户名称：</td>
							<td><input type="text" name="username" value=""
								id="userName" title="用户名称"></td>
							<td style="width: 200px"><p id="userNameJoin"></p></td>
						</tr>
						<tr>
							<td class="lefts">用户密码：</td>
							<td><input type="text" name="pwd" value=""
								id="userPwd" title="用户密码"></td>
							<td style="width: 200px;"><p id="userPwdJoin"></p></td>
						</tr>
						<tr>
							<td class="lefts">确认密码：</td>
							<td><input type="text" name="password" value=""
								id="password" title="确认密码"></td>
							<td style="width: 200px;text-align: left;"><p id="passwordJoin"></p></td>
						</tr>
						<tr>
							<td colspan="3" style="text-align: center;">
							<input type="button" value="注册" onclick="check();" style="width: 50px;height: 30px;"/></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>