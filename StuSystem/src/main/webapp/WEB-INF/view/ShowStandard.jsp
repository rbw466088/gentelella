<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>标准信息列表</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<style>
html {
	font-size: 1rem;
}

body {
	font-size: 1rem;
}

#mainBox {
	margin: 0px auto;
	border: 1px solid black;
	width: 60%;
	display: flex;
	flex-direction: column;
	align-items: center;
}

.rights {
	text-align: right
}

p {
	text-align: center;
	margin-top: 0px;
}

table {
	width: 90%;
}

table tr td {
	width: 10%;
	text-align: center;
	padding: 0.5rem;
}

thead tr th, tfoot tr td {
	padding: 0.5rem;
	border: 0px;
}
</style>


</head>
<script type="text/javascript">
	//默认保留查询条件
	$(function() {
		//$("#inp").val("${zhname}");
		$("tr:odd").css("background-color","gray");
	});
	
	//按条件查询提交
	function zhname() {
		$("#myForm").submit();
	}
	
	//全选~~全不选
	function setChecked() {
	    var boxs = document.getElementsByName("tests");
	    var chkbox = document.getElementById("chkall");
	    if(chkbox.checked == true){
	        for(var i=0 ; i<boxs.length ; i++) {
	            boxs[i].checked = true;
	        }
	    }else{
	        for(var i=0 ; i<boxs.length ; i++) {
	            boxs[i].checked = false;
	        }
	    }
	}
	
	//批量删除
 	function dele() {
 		var str="";
		var sel=document.getElementsByName("tests");
		
		for(var i=0;i<sel.length;i++){
			if(sel[i].checked==true){
				str+=sel[i].value+",";
			}	
		} 
		if(str==""){
			alert("请选择删除项！");
			return false;
		} 
		if(window.confirm("确定删除吗？")){
			window.location.href = "DeleteStandard?delParam="+str;
		}
		return false;
 	}
	
	//新增
	function add() {
		window.location.href = "add";
		return false;
	}
</script>
<script type="text/javascript" language="javascript">
	<c:if test="${!empty message}">
		alert('${message}');
	</c:if> 
	/* <c:remove var="message" scope="session"/> */
</script>
<body>
	<div id="mainBox">
		<p>标准信息列表</p>
		<table border="2" cellpadding="0px" cellspacing="0">
			<thead>
				<tr class="rights">
					<th colspan="7">
						<form action="ShowStandard " method="post" id="myForm">
							<input type="text" name="zhname" id="inp" value="${zhname}" />&nbsp;&nbsp;
							<button onclick="zhname();">提交检索</button>
							&nbsp;&nbsp;
							<button onclick="return add();">新增标准</button>
							&nbsp;&nbsp;
							<button onclick="return dele();">删除标准</button>
						</form>
					</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="checkbox" id="chkall" onclick="setChecked();" /></td>
					<td>标准号</td>
					<td>中文名</td>
					<td>版本</td>
					<td>发布日期</td>
					<td>实施日期</td>
					<td>操作</td>
				</tr>
				<c:if test="${null!=standardList}">
					<c:forEach items="${standardList}" var="standard"
						varStatus="vsIndex">
						<tr>
							<td><input type="checkbox" name="tests"
								value="${standard.id}" /></td>
							<td>${standard.stdNum}</td>
							<td>${standard.zhname}</td>
							<td>${standard.version}</td>
							<td><fmt:formatDate value="${standard.releaseDate}"
									pattern="yyyy-MM-dd" /></td>
							<td><fmt:formatDate value="${standard.implDate}"
									pattern="yyyy-MM-dd" /></td>
							<td><a href="down/${standard.id}">下载</a>&nbsp;&nbsp;<a
								href="StandardById?id=${standard.id}">修改</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="7" class="rights"><c:choose>
							<c:when test="${info.pageNum==1}">
						首页
				    	上一页 
					</c:when>
							<c:otherwise>
								<a href="ShowStandard?pageNum=1&zhname=${zhname}">首页</a>
								<a
									href="ShowStandard?pageNum=${info.pageNum-1}&zhname=${zhname}">上一页
								</a>
							</c:otherwise>
						</c:choose> <c:choose>
							<c:when test="${info.pageNum==info.pages}">
						下一页
						末页
					</c:when>
							<c:otherwise>
								<a
									href="ShowStandard?pageNum=${info.pageNum+1}&zhname=${zhname}">下一页
								</a>
								<a href="ShowStandard?pageNum=${info.pages}&zhname=${zhname}">末页</a>
							</c:otherwise>
						</c:choose> 当前页【${info.pageNum}/${info.pages}】</td>
				</tr>
			</tfoot>
		</table>
		<p>${message}</p>
		<c:remove var="message" scope="session" />
	</div>

</body>
</html>