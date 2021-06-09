<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加标准表信息</title>
<%
	request.setAttribute("path", request.getContextPath());
%>
<script type="text/javascript" src="${path}/statics/js/jquery-1.8.3.js"></script>
<style>
html {
	font-size: 1rem;
}

#container {
	width: 60%;
	border: 1px solid black;
	margin: 0px auto;
}

p {
	text-align: center;
	font-size: 1.6rem;
}

table {
	font-size: 1.2rem;
	width: 90%;
	margin: 1rem auto;
}

table tr td {
	padding: 1rem;
	width: 50%;
	border: 1px solid black;
}

.rights {
	text-align: right;
}

.inputs {
	height: 1.3rem;
}

button {
	font-size: 1.3rem;
}
span{
	color: red;
	font-size:12px;
	padding-left: 10px;
}
</style>
</head>
<script type="text/javascript">
	function sub(){
		//var stdNum = document.getElementByName("stdNum");
		var stdNum = $("#stdNum_verder").val();
		var zhname = $("#zhname_verder").val();
		var version = $("#version_verder").val();
		var keys = $("#keys_verder").val();
		var packagePath = $("#path_verder").val();
		
		/* if(!stdNum){
			alert("标准号不能为空！");
			return false;
		}
		if(!zhname){
			alert("中文名称不能为空！");
			return false;
		}
		if(!version){
			alert("版本不能为空！");
			return false;
		}
		if(!keys){
			alert("关键词/字不能为空！");
			return false;
		}
		var Path_photo=$("#Path_photo");
		if(!packagePath){
			alert("附件不能为空！");
			return false;
		} */
		
		var releaseDate = $("#releaseDate").val();
		var implDate =  $("#implDate").val();
		var test = /^\d{4}[-]\d{1,2}[-]\d{1,2}$/; 
		if(releaseDate){
			if(!test.test(releaseDate)){
				alert("发布日期格式错误！");
				return false;
			}
		}
		if(implDate){
			if(!test.test(implDate)){
				alert("实施日期格式错误！");
				return false;
			}
		}
		
		$('#addForm').submit();
	}
</script>
<script type="text/javascript" language="javascript">
	
	<c:if test="${!empty message}">
		alert('${message}');
	</c:if> 
	<c:remove var="message" scope="session"/>
</script>
<body>
	<div id="container">
		<p>增加标准信息</p>
		<div class="table">
			<form action="AddStandard" method="post" id="addForm"
				enctype="multipart/form-data">
				<table border="2" cellpadding="0" cellspacing="0">
					<tr>
						<td class="rights">*标准号:</td>
						<td><input type="text" name="stdNum" value=""
							id="stdNum_verder"><span>${stdNum}</span></td>
					</tr>
					<tr>
						<td class="rights">*中文名称:</td>
						<td><input type="text" name="zhname" value=""
							id="zhname_verder"><span>${zhname}</span></td>
					</tr>
					<tr>
						<td class="rights">*版本:</td>
						<td><input type="text" name="version" value=""
							id="version_verder"><span>${version}</span></td>
					</tr>
					<tr>
						<td class="rights">*关键词/字:</td>
						<td><input type="text" name="keys" value="" id="keys_verder"><span>${keys}</span></td>
					</tr>
					<tr>
						<td class="rights">发布日期(yyyy-mm-dd):</td>
						<td><input type="text" name="releaseDate" class="inputs"
							id="releaseDate"></td>
					</tr>
					<tr>
						<td class="rights">实施日期(yyyy-mm-dd):</td>
						<td><input type="text" name="implDate" id="implDate"></td>
					</tr>
					<tr>
						<td class="rights">*附件:</td>
						<td><input type="file" name="file" id="path_verder"><span>${file}</span></td>
					</tr>
					<tr>
						<td class="rights">*附件:</td>
						<td><input type="file" name="file2" id="pat"></td>
					</tr>
					<tr>
						<td class="rights" colspan="2" style="text-align: center"><button
								onclick="return sub();">保存</button>&nbsp;&nbsp;
							<button id="cancels">取消</button></td>
					</tr>
				</table>
			</form>

		</div>
	</div>

</body>
</html>