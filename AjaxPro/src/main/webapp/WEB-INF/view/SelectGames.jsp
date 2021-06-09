<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>游戏管理查询页面</title>
</head>
<%
	request.setAttribute("path", request.getContextPath());
%>
<script type="text/javascript" src="${path}/statics/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path}/statics/js/ajax.js"></script>
<script type="text/javascript">
	function sub() {
		var gameYear = $("#gameYear").val();
		if(gameYear){
			var test = /^\d{4}$/;
			if(!test.test(gameYear)){
				alert("发行年份应为四位数字，请重新输入！");
				return false;
			}
		}
		$("#myForm").submit();
	}
	
	function add() {
		window.location.href="add";
	}
</script>
<body>	
	<div>
		<div class="table">
			<form action="showGames" method="post" id="myForm" >
				<table border="2" cellpadding="0" cellspacing="0">
					<thead>
						<tr>
							<td colspan="3" style="text-align: center;background-color: gray">游戏查询</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="lefts">游戏名称:</td>
							<td><input type="text" name="gameName" value=""
								id="gameName"></td>
							<td><span></span></td>
						</tr>
						<tr>
							<td class="lefts">游戏类别:</td>
							<td><input type="text" name="gameType" value=""
								id="gameType"></td>
							<td><span></span></td>
						</tr>
						<tr>
							<td class="lefts">发行公司:</td>
							<td><input type="text" name="gameCompany" value=""
								id="gameCompany"></td>
							<td><span></span></td>
						</tr>
						<tr>
							<td class="lefts">发行年份:</td>
							<td><input type="text" name="gameYear" value="" id="gameYear"></td>
							<td><span style="color: red"> 四位数字</span></td>
						</tr>
						<tr>
							<td colspan="3" style="text-align: center;">
								<input type="button" onclick="sub();" value="查询" />
								<input type="button" onclick="add();" value="新增" />
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>