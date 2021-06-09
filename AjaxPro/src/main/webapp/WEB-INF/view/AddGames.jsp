<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加游戏信息</title>
</head>
<%
	request.setAttribute("path", request.getContextPath());
%>
<script type="text/javascript" src="${path}/statics/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function add() {
		var gameName = $("#gameName").val();
		var gameYear = $("#gameYear").val();
		if(!gameName){
			alert("游戏名称不能为空！");
			return false;
		}
		if(gameYear){ 
			var test = /^\d{4}$/; 
			if(!test.test(gameYear)){
				alert("发行年份应为四位数字，请重新输入！");
				return false;
			}
		}
		$("#myForm").submit();
	}
	
	function ret() {
		window.location.href="selectGames";
	}
</script>
	<c:if test="${!empty message}">
		<script type="text/javascript" >
			alert('${message}');
		</script>
	</c:if> 
	<c:remove var="message" scope="session"/>
<body>
	<div>
		<div class="table">
			<form action="addGames" method="post" id="myForm" >
				<table border="2" cellpadding="0" cellspacing="0">
					<thead>
						<tr>
							<td colspan="3" style="text-align: center;background-color: red">新增游戏</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="lefts">游戏名称</td>
							<td><input type="text" name="gameName" value=""
								id="gameName"></td>
							<td style="text-align: center;"><span style="color: red">*</span></td>
						</tr>
						<tr>
							<td class="lefts">游戏类别</td>
							<td><input type="text" name="gameType" value=""
								id="gameType"></td>
							<td><span></span></td>
						</tr>
						<tr>
							<td class="lefts">发行公司</td>
							<td><input type="text" name="gameCompany" value=""
								id="gameCompany"></td>
							<td><span></span></td>
						</tr>
						<tr>
							<td class="lefts">发行年份</td>
							<td><input type="text" name="gameYear" value="" id="gameYear"></td>
							<td><span style="color: red"> 四位数字</span></td>
						</tr>
						<tr>
							<td colspan="3" style="text-align: center;">
								<input type="button" onclick="add();" value="添加" />
								<input type="button" onclick="ret();" value="返回" />
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>