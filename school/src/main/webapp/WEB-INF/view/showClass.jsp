<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班级列表</title>
<script  type="text/javascript" src="../../js/jquery-1.8.3.js"></script>
</head>
<body>
<div><a href="showInfo">添加新班级</a></div>
	<div>
		<table>
			<thead>
				<tr>
					<td>班级ID</td><td>班级名称</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cla" items="${list}">
					<tr>
						<td>${cla.id}</td><td>${cla.name}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>