<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增宠物信息</title>
<style type="text/css">
	#Btable{
		width:500px;
		margin: 0px auto;
	}
	#Btable table{
		width:100%;
	}
	.head{
		text-align: right;
		padding-right: 20px;
	}
</style>
<script type="text/javascript" src="jquery-1.8.3.js"></script>
<script type="text/javascript">
	function myAdd() {
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
		$("#addForm").submit();
	}
</script>
</head>
<body>
	<div align="center">
		<h1>宠物的基本信息</h1>
	</div>
	<form action="AddPetServlet" method="post" id="addForm">
		<div id="Btable">
			<table>
				<tr>
					<td class="head">昵称：</td>
					<td><input type="text" name="petName" id="petName"/></td>
				</tr>
				<tr>
					<td class="head">品种：</td>
					<td>
						<select name="petBreed" id="petBreed">
							<option value="">--请选择--</option>
							<option value="狗">狗</option>
							<option value="猫">猫</option>
							<option value="鸟">鸟</option>
							<option value="老鼠">老鼠</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="head">性别：</td>
					<td>
						<input type="radio" value="雄" name="petSex" checked="checked" />雄 
						<input type="radio" value="雌" name="petSex" />雌
					</td>
				</tr>
				<tr>
					<td class="head">出生日期：</td>
					<td><input type="text" name="birthday" id="birthday"/>&#160<b>yyyy-mm-dd</b></td>
				</tr>
				<tr>
					<td class="head">描述：</td>
					<td><input type="text" name="description" /></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="button" value="提交" onclick="myAdd();"/> 
						<input type="reset" value="重置" />
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>