<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.gdglc.stuSystem.entity.Standard"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>修改标准表信息</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
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
<script type="text/javascript">
	$(function () {
		$("#stdNum_verder").val("${stan.stdNum}");

	});
	function sub(){
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
		
		$('#updateForm').submit();
	}
</script>
</head>
<body>

	<div id="container">
		<p>修改标准信息</p>
		<div class="table">
			<form action="UpdateStandard" method="post" id="updateForm"
				enctype="multipart/form-data">
				<table border="2" cellpadding="0" cellspacing="0">
					<tr style="display: none">
						<td class="rights">ID:</td>
						<td><input type="text" name="id" value="${stan.id}"
							id="id_verder"></td>
					</tr>
					<tr>
						<td class="rights">*标准号:</td>
						<td><input type="text" name="stdNum" value="${stan.stdNum}"
							id="stdNum_verder"><span>${stdNum}</span></td>
					</tr>
					<tr>
						<td class="rights">*中文名称:</td>
						<td><input type="text" name="zhname" value="${stan.zhname}"
							id="zhname_verder"><span>${zhname}</span></td>
					</tr>
					<tr>
						<td class="rights">*版本:</td>
						<td><input type="text" name="version" value="${stan.version}"
							id="version_verder"><span>${version}</span></td>
					</tr>
					<tr>
						<td class="rights">*关键词/字:</td>
						<td><input type="text" name="keys" value="${stan.keys}"
							id="keys_verder"><span>${keys}</span></td>
					</tr>
					<tr>
						<td class="rights">发布日期(yyyy-mm-dd):</td>
						<td><input type="text" name="releaseDate" class="inputs"
							id="releaseDate"
							value="<fmt:formatDate value='${stan.releaseDate}' pattern='yyyy-MM-dd' />" /></td>
					</tr>
					<tr>
						<td class="rights">实施日期(yyyy-mm-dd):</td>
						<td><input type="text" name="implDate" id="implDate"
							value="<fmt:formatDate value='${stan.implDate}' pattern='yyyy-MM-dd' />" /></td>
					</tr>
					<tr>
						<td class="rights">附件:</td>
						<td><input type="file" name="file" id="path_verder"><span>${file}</span></td>
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