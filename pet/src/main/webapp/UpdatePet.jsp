<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改宠物</title>
</head>
<script type="text/javascript" src="jquery-1.8.3.js"></script>
<script type="text/javascript">
	function myUpdate() {
		var petName = $("#petName").val();
		var petBreed = $("#petBreed").val();
		var birthday = $("#birthday").val();
		if(!petName){
			alert("昵称不能为空!");
			return;
		}
		if(!petBreed){
			alert("请选择品种!");
			return;
		}
		if(!birthday){
			alert("出生日期不能为空!");
			return;
		}
		var date = /^\d{4}-\d{2}-\d{2}$/;
		
		if(!date.test(birthday)){
			alert("出生日期格式不正确!");
			return;
		}
		$("#updateForm").submit();
	}
</script>

<body>

	<div align="center">
		<h1>修改宠物信息</h1>
	</div>
	<form action="UpdatePetServlet?petId=${param.petId}"
		method="post" id="updateForm">
		<div>
			<table>
				<c:forEach var="pet" items="${petList}" varStatus="vs">
					<tr>
						<td>宠物ID：</td>
						<td>${pet.petId}</td>
					</tr>
					<tr>
						<td>昵称：</td>
						<td><input type="text" name="petName" id="petName"
							value="${pet.petName}" /></td>
					</tr>
					<tr>
						<td>品种：</td>
						<td><select name="petBreed" id="petBreed">
								<c:choose>
									<c:when test="${pet.petBreed=='狗'}">
										<option value="狗" selected="selected">狗</option>
									</c:when>
									<c:otherwise>
										<option value="狗">狗</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${pet.petBreed=='猫'}">
										<option value="猫" selected="selected">猫</option>
									</c:when>
									<c:otherwise>
										<option value="猫">猫</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${pet.petBreed=='鸟'}">
										<option value="鸟" selected="selected">鸟</option>
									</c:when>
									<c:otherwise>
										<option value="鸟">鸟</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${pet.petBreed=='老鼠'}">
										<option value="老鼠" selected="selected">老鼠</option>
									</c:when>
									<c:otherwise>
										<option value="老鼠">老鼠</option>
									</c:otherwise>
								</c:choose>
						</select></td>
					</tr>
					<tr>
						<td>性别：</td>
						<td><c:choose>
								<c:when test="${pet.petSex=='雄'}">
									<input type="radio" value="雄" name="petSex" checked="checked" />雄
							</c:when>
								<c:otherwise>
									<input type="radio" value="雄" name="petSex" />雄
							</c:otherwise>
							</c:choose> <c:choose>
								<c:when test="${pet.petSex=='雌'}">
									<input type="radio" value="雌" name="petSex" checked="checked" />雌
							</c:when>
								<c:otherwise>
									<input type="radio" value="雌" name="petSex" />雌
							</c:otherwise>
							</c:choose></td>
					</tr>
					<tr>
						<td>出生日期：</td>
						<td><input type="text" name="birthday" id="birthday"
							value="<fmt:formatDate value="${pet.birthday}" pattern="yyyy-MM-dd" />" />&#160<b>yyyy-mm-dd</b></td>
					</tr>
					<tr>
						<td>描述：</td>
						<td><input type="text" name="description"
							value="${pet.description}" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="button" value="提交" onclick="myUpdate();" /> <input
							type="reset" value="重置" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</form>
</body>
</html>