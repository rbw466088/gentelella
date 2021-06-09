<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学员信息列表</title>
<%
	request.setAttribute("path", request.getContextPath());
%>
<script type="text/javascript" src="${path}/statics/js/jquery-1.8.3.js"></script>
<style>
html {
	font-size: 1rem;
}

body {
	font-size: 1rem;
}

#mainBox {
	margin: 0px auto;
	width: 60%;
	display: flex;
	flex-direction: column;
	align-items: center;
}

.rights {
	text-align: right
}

p {
	text-align: center;
	margin-top: 0px;
	font-size: 24px;
	font-weight: bold;
}

table {
	width: 90%;
}

table tr td {
	width: 10%;
	text-align: center;
	padding: 0.5rem;
}

thead tr th, tfoot tr td {
	padding: 0.5rem;
	border: 0px;
}
</style>
<script type="text/javascript" language="javascript">
	$(function () {
		$("tr:odd").css("background-color","gray");
	});
</script>
</head>
<script type="text/javascript" >
	<c:if test="${!empty message}">
		alert('${message}');
	</c:if> 
	<c:remove var="message" scope="session"/>
</script>
<body>
	<div id="mainBox">
		<p>学员信息列表</p>
		<table border="2" cellpadding="0px" cellspacing="0">
			<thead>
				<tr class="rights">
					<th colspan="7" style="padding-right: 20px"><a href="add">添加学员</a></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>编号</td>
					<td>姓名</td>
					<td>性别</td>
					<td>年龄</td>
					<td>电话</td>
					<td>Email</td>
					<td>班级</td>
				</tr>
				<c:if test="${null!=stuList}">
					<c:forEach items="${stuList}" var="stu" varStatus="vsIndex">
						<tr>
							<td>${stu.id}</td>
							<td>${stu.name}</td>
							<td>${stu.gender}</td>
							<td>${stu.age}</td>
							<td>${stu.telephone}</td>
							<td>${stu.email}</td>
							<td>${stu.classname}</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</body>
</html>