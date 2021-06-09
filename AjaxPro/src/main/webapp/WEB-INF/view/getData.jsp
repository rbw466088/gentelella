<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach items="${list}" var="game">
	<tr>
		<td style="display: none">${game.gameId}</td>
		<td>${game.gameName}</td>
		<td>${game.gameType}</td>
		<td>${game.gameCompany}</td>
		<td>${game.gameYear}</td>
		<td><input type="button" onclick="del(${game.gameId});" value="删除"></td>
	</tr>
</c:forEach>