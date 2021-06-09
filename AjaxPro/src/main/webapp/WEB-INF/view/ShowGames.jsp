<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>游戏列表</title>
<style type="text/css">
div {
	width: 500px;
	margin: 0px auto;
}

table {
	width: 100%;
}

td {
	height: 30px;
	line-height: 30px;
	text-align: center;
}

thead tr td {
	font-weight: bold;
}
#show{
	display: block;
}
.titles{
	color: red;
	font-weight: bold;
}
#addInfo{
	width: 500px;
	margin: 0px auto;
	margin-top: 100px;
	display: none;
}
</style>
</head>
<%
	request.setAttribute("path", request.getContextPath());
%>
<script type="text/javascript" src="${path}/statics/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path}/statics/js/select.js"></script>
<script type="text/javascript" src="${path}/statics/js/del.js"></script>
<script type="text/javascript" src="${path}/statics/js/add.js"></script>
<body>
	<div  id="addInfo">
		<form action="addGames" method="post" id="myForm">
			<table border="2" cellpadding="0" cellspacing="0">
				<thead>
					<tr>
						<td colspan="3" style="text-align: center; background-color: red">新增游戏</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="titles">游戏名称</td>
						<td><input type="text" name="gameNames" value="" id="gameNameAdd"></td>
						<td style="text-align: center;"><span style="color: red">*</span></td>
					</tr>
					<tr>
						<td class="titles">游戏类别</td>
						<td><input type="text" name="gameTypes" value="" id="gameTypeAdd"></td>
						<td><span></span></td>
					</tr>
					<tr>
						<td class="titles">发行公司</td>
						<td><input type="text" name="gameCompanys" value=""
							id="gameCompanyAdd"></td>
						<td><span></span></td>
					</tr>
					<tr>
						<td class="titles">发行年份</td>
						<td><input type="text" name="gameYears" value="" id="gameYearAdd"></td>
						<td><span style="color: red"> 四位数字</span></td>
					</tr>
					<tr>
						<td colspan="3" style="text-align: center;"><input
							type="button" onclick="addGames();" value="添加" /> <input
							type="button" onclick="ret();" value="返回" /></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<div id="show">
		<table border="2">
			<thead>
				<tr>
					<td colspan="5" style="text-align: right; padding-right: 10px">
					</td>
				</tr>
				<tr>
					<td colspan="5" style="text-align: center; background-color: gray">游戏列表</td>
				<tr>
					<td colspan="5">游戏名称: <input type="text" name="gameName"
						id="gameName" /> &nbsp;&nbsp;&nbsp;&nbsp; 游戏类别: <input
						type="text" name="gameType" id="gameType" />
					</td>
				<tr>
					<td colspan="5">发行公司: <input type="text" name="gameCompany"
						id="gameCompany" /> &nbsp;&nbsp;&nbsp;&nbsp; 发行年份: <input
						type="text" name="gameYear" value="" id="gameYear" />
					</td>
				</tr>
				<tr>
					<td class="titles">游戏名称</td>
					<td class="titles">游戏类别</td>
					<td class="titles">发行公司</td>
					<td class="titles">发行年份</td>
					<td>
						<input type="button" value="查询" style="font-weight: bold; color: red;" onclick="sel();" />
						<input type="button" value="新增" style="font-weight: bold; color: red;" onclick="add();" >
					</td>
				</tr>
			</thead>
			<tbody id="js-data">
				<%-- <c:forEach items="${list}" var="game">
					<tr>
						<td style="display: none">${game.gameId}</td>
						<td>${game.gameName}</td>
						<td>${game.gameType}</td>
						<td>${game.gameCompany}</td>
						<td>${game.gameYear}</td>
						<td><input type="button" onclick="del(${game.gameId});" value="删除"></td>
					</tr>
				</c:forEach> --%>
			</tbody>
		</table>

	</div>
</body>
</html>