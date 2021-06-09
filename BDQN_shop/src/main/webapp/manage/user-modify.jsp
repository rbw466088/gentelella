<%@page import="com.YANG.BDQN_shop.entity.you.LoginEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理 - 易买网</title>
<style type="text/css">
	span{color: red}
</style>

<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/jquery-1.8.3.js"></script>
<script type="text/javascript" src="../scripts/function.js"></script>
</head>
<script type="text/javascript">
	function myAdd(){
		var Names = $("#Names").val();
		var DivNames = $("#DivNames");
		if(Names==""){
			DivNames.html("名字不能为空!");
			return false;
		}
		else{
			DivNames.html("");
		}
		var passWord = $("#passWord").val();
		var Divpwd = $("#Divpwd");
		if(passWord==""){
			Divpwd.html("密码不能为空!");
			return false;
		}
		else{
			Divpwd.html("");
		}
		var passWords = $("#passWords").val();
		var Divpwds = $("#Divpwds");
		if(passWords==""){
			Divpwds.html("确认密码不能为空!");
			return false;
		}
		else{
			Divpwds.html("");
		}
		var RiQi=$("#RiQi").val();
		var Divbirthday=$("#Divbirthday");
		if(RiQi==""){
			Divbirthday.html("日期不能为空");
			return false;
		}
		else{
			Divbirthday.html("");
		}
		var mobile = $("#mobile").val();
		var Divmobile = $("#Divmobile");
		if(mobile==""){
			Divmobile.html("手机号不能为空！");
			return false;
		}
		else{
			Divmobile.html("");
		}
		var address=$("#address").val();
		var Divaddress=$("#Divaddress");
		if(address==""){
			Divaddress.html("地址不能为空！");
			return false;
		}
		else{
			Divaddress.html("");
		}
		var passWord = $("#passWord").val();
		var passWords = $("#passWords").val();
		var Divpwds = $("#Divpwds");
		if(passWord==passWords){
			Divpwds.html("");
		}
		else{
			Divpwds.html("两次密码不一样!");
			return false;
		}
        $("#myform").submit();
	}
        
           
</script>

<body>
<% String path=request.getContextPath();%>
<div id="header" class="wrap">

	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../yangProduct">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="../yangProduct">首页</a></li>
			<li class="current"><a href="News?actions=manage">用户</a></li>
			<li><a href="../manage/productList">商品</a></li>
			<li ><a href="HouTaiDinDan?actions=manage">订单</a></li>
			<li><a href="../manage/LiuYan">留言</a></li>
			<li><a href="../manage/infoNewsServlet">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		<c:out value="${account.id}"></c:out>您好，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="../yangProduct">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><a href="News?actions=manage">用户管理</a></dd>
			  <dt>商品信息</dt>
				<dd><em><a href="../manage/productClass-add.jsp">新增</a></em><a href="../manage/DaLeiServlet">分类管理</a></dd>
				<dd><em><a href="../manage/FenLeiServlet">新增</a></em><a href="../manage/productList">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="HouTaiDinDan?actions=manage">订单管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="../manage/LiuYan">留言管理</a></dd>
				<dt>新闻管理</dt>
				<dd><em><a href="../manage/news-add.jsp">新增</a></em><a href="../manage/infoNewsServlet">新闻管理</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>修改用户</h2>
		<div class="manage">
			<form id="myform" action="UpdateServlet" method="post" >
				<table class="form">
					<tr>
						<td class="field">用户名(*)：</td>
						<td><input type="text" class="text" name="userName" id="userName" value="${show.id }" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">真实姓名(*)：</td>
						<td><input type="text" class="text" name="Names" id="Names"  value="${show.name }" /><span class='warn' id='DivNames'></span></td>
					</tr>
					<tr>
						<td class="field">登录密码(*)：</td>
						<td><input type="password" class="text" name="passWord" id="passWord" value="${show.pwd }" /><span class='warn' id='Divpwd'></span></td>
					</tr>
                    <tr>
						<td class="field">确认密码(*)：</td>
						<td><input type="password" class="text" name="passWord" id="passWords" value="${show.pwd }" /><span class='warn' id='Divpwds'></span></td>
					</tr>
					<tr>
						<td class="field">性别(*)：</td>			
						<td>
							<c:choose>
								<c:when test="${show.sex=='F'}">
									<input type="radio" name="sex" value="F"  checked="checked"/>女
								</c:when>
								<c:otherwise>
									<input type="radio" name="sex" value="F" />女
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${show.sex=='T'}">
									<input type="radio" name="sex" value="T"  checked="checked"/>男 
								</c:when>
								<c:otherwise>
									<input type="radio" name="sex" value="T" />男 
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td class="field">出生日期：</td>
						<td><input type="text" name="RiQi" id="RiQi" value="${show.birthday }"><span class='warn' id='Divbirthday'></span></td>
					</tr>
					<tr>
						<td class="field">手机(*)：</td>
						<td><input type="text" class="text" name="mobile" id="mobile"  value="${show.mobile }" /><span class='warn' id='Divmobile'></span></td>
					</tr>
					<tr>
						<td class="field">地址(*)：</td>
						<td><input type="text" class="text" name="address" id="address" value="${show.address }" /><span class='warn' id='Divaddress'></span></td>
					</tr>					
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="button" value="更新" onclick="myAdd()"/></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>