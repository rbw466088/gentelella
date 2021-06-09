<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学员信息</title>
<%
	request.setAttribute("path", request.getContextPath());
%>
<script type="text/javascript" src="${path}/statics/js/jquery-1.8.3.js"></script>
<style>
html {
	font-size: 1rem;
}

#container {
	width: 22rem;
	margin: 0px auto;
}

p {
	text-align: center;
	font-size: 1.6rem;
}

table {
	font-size: 1.2rem;
	width: 100%;
	margin: 1rem auto;
}

table tr td {
	padding: 0.2rem 0.3rem;
	border: 1px solid black;
}

.lefts {
	background-color: gray;
	text-align: right;
	width: 20%;;
}

.rights {
	width: 80%;;
}

.inputs {
	height: 1.3rem;
}

button {
	font-size: 1.3rem;
}

span {
	color: red;
	font-size: 12px;
	padding-left: 10px;
}
</style>
</head>
<script type="text/javascript">
	function sub(){
 		var name = $("[name='name']").val();
		var gender = $("[name='gender']").val();
		var age = $("[name='age']").val();
		var telephone = $("[name='telephone']").val();
		var email = $("[name='email']").val();
		var classid = $("[name='classid']").val();
		if(!name){
			alert("姓名不能为空！");
			return false;
		}
		if(!gender){
			alert("性别不能为空！");
			return false;
		}
		if(!age){
			alert("年龄不能为空！");
			return false;
		}
		if(!telephone){
			alert("电话号码不能为空！");
			return false;
		}
		if(!email){
			alert("邮箱不能为空！");
			return false;
		}
		if(!classid){
			alert("请选择班级！");
			return false;
		}
		var test = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
		if(!test.test(email)){
			alert("填写的邮箱格式错误，请重写！");
			return false;
		}
		$('#addForm').submit();
	}
</script>
<script type="text/javascript" >
	<c:if test="${!empty message}">
		alert('${message}');
	</c:if> 
	<c:remove var="message" scope="session"/>
</script>
<body>
	<div id="container">
		<p>学员信息添加</p>
		<div class="table">
			<form action="AddStu" method="post" id="addForm">
				<table border="2" cellpadding="0" cellspacing="0">
					<tr>
						<td class="lefts">姓名:</td>
						<td class="rights"><input type="text" name="name" value="${param.name}">
						<span>${errorname}</span></td>
					</tr>
					<tr>
						<td class="lefts">性别:</td>
						<td class="rights"><input type="text" name="gender" value="${param.gender}">
						<span>${errorgender}</span></td>
					</tr>
					<tr>
						<td class="lefts">年龄:</td>
						<td class="rights"><input type="text" name="age" value="${param.age}">
						<span>${errorage}</span></td>
					</tr>
					<tr>
						<td class="lefts">电话:</td>
						<td class="rights"><input type="text" name="telephone" value="${param.telephone}">
						<span>${errortelephone}</span></td>
					</tr>
					<tr>
						<td class="lefts">email:</td>
						<td class="rights"><input type="text" name="email" value="${param.email}">
						<span>${erroremail}</span></td>
					</tr>
					<tr>
						<td class="lefts">班级:</td>
						<td class="rights"><select name="classid"
							style="width: 100px" >
								<option value="">请选择</option>
								<c:forEach items="${showClass}" var="classes"
									varStatus="vsIndex">
									<option value="${classes.id}">${classes.name}</option>
								</c:forEach>
						</select><span>${errorclassid}</span></td>
					</tr>
					<tr>
						<td class="bot" colspan="2" style="text-align: center"><button
								onclick="return sub();">保存</button>&nbsp;&nbsp;
							<button id="cancels">返回</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>