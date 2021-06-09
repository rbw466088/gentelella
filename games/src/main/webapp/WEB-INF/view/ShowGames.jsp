<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>游戏列表</title>
</head>
	<c:if test="${!empty message}">
		<script type="text/javascript" >
			alert('${message}');
		</script>
	</c:if> 
	<c:remove var="message" scope="session"/>
<body>
	<p>${messJoin}</p>
	<div>
		<table border="2" cellpadding="0" cellspacing="0">
			<thead>
				<tr>
					<td colspan="4" style="text-align: right;"><a href="selectGames">返回</a></td>
				</tr>
				<tr>
					<td colspan="4" style="text-align: center;background-color: blue">游戏列表</td>
				</tr>
				<tr>
					<td>游戏名称</td>
					<td>游戏类别</td>
					<td>发行公司</td>
					<td>发行年份</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="game">
					<tr>
						<td>${game.gameName}</td>
						<td>${game.gameType}</td>
						<td>${game.gameCompany}</td>
						<td>${game.gameYear}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>