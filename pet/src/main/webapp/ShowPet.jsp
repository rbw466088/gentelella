<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>宠物列表</title>

<style type="text/css">
	#pet{
		width:100%;
		text-align: center;
	}
	#title{
		margin:20px 0px;
	}
	#Btable{
		width:500px;
		margin: 0px auto;
		text-align: center;
	}
	#Btable table{
		width:100%;
	}
</style>
<script type="text/javascript" src="${path}/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function(){
		$("#petBreed").val('${param.petBreed}');
		$("tbody tr:odd").css("background-color","gray");
	});
</script>
</head>
<body>
	<div id="pet">
		<form action="PetServlet" method="post">
		<div id="title">
			品种
			<select name="petBreed" id="petBreed">
				<option value="">--请选择--</option>
				<option value="狗">狗</option>
				<option value="猫">猫</option>
				<option value="鸟">鸟</option>
				<option value="老鼠">老鼠</option>
			</select>
			<input type="submit" value="查询" />
			<a href="AddPet.jsp">新增宠物</a>
		</div>
		</form>
		<div id="Btable">
			<table cellspacing="0" cellpadding="0" border="1">
				<thead>
					<tr style="background-color: red">
						<td>宠物昵称</td>
						<td>出生日期</td>
						<td>性别</td>
						<td>编辑</td>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${petList}" var="pet" >
					<tr>
						<td>${pet.petName}</td>
						<td><fmt:formatDate value="${pet.birthday}" pattern="yyyy-MM-dd" /></td>
						<td>${pet.petSex}</td>
						<td><a href="PetByIDServlet?petId=${pet.petId}">编辑</a>  <a href="DeletePetServlet?petId=${pet.petId}">删除</a></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<div id="page">
				<c:choose>
					<c:when test="${info.pageNum==1}">
						首页
				    	上一页 
					</c:when>
					<c:otherwise>
						<a href="PetServlet?pageNum=1&petBreed=${param.petBreed}">首页</a> 
						<a href="PetServlet?pageNum=${info.pageNum-1}&petBreed=${param.petBreed}">上一页 </a>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${info.pageNum==info.pages}">
						下一页
						末页
					</c:when>
					<c:otherwise>
						<a href="PetServlet?pageNum=${info.pageNum+1}&petBreed=${param.petBreed}">下一页 </a>
						<a href="PetServlet?pageNum=${info.pages}&petBreed=${param.petBreed}">末页</a>
					</c:otherwise>
				</c:choose>
				当前页【${info.pageNum}/${info.pages}】
			</div>
		</div>
	</div>
</body>
</html>