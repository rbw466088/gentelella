<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<script type="text/javascript">
	function myAdd(){
		var id = $("#id").val();
		var ziid = $("#ziid").val();
		var dalei=$("#dalei").val();
		var className=$("#className").val();
		var Divpwds = $("#Divpwd");
		var Divpwds_1 = $("#Divpwd_1");
		var Divpwds_2 = $("#Divpwd_2");
		var Divpwds_3 = $("#Divpwd_3");
		if(dalei==""){
			
			Divpwds.html("父类名不能为空!");
			return false;
			
		}
		else{
			Divpwds.html("");
		}
		if(id==""){
			
			Divpwds_1.html("父类编号不能为空!");
			return false;
			
		}else{
			Divpwds_1.html("");
		}
		
		if(className==""){
			
			Divpwds_2.html("子类名不能为空!");
			return false;
			
		}else{
			Divpwds_2.html("");
		}
		
		if(ziid==""){
			
			Divpwds_3.html("子类编号不能为空!");
			return false;
			
		}else{
			Divpwds_3.html("");
		}
		
		if(id!=ziid){
			
			Divpwds_3.html("父类编号一定要和子类编号相同");
			return false;
		
		}else{
			Divpwds_3.html("");
		}
		$("#admian").submit();
	}

</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../yangProduct">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="../yangProduct">首页</a></li>
			<li><a href="News?actions=manage">用户</a></li>
			<li class="current"><a href="../manage/productList">商品</a></li>
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
		<h2>添加分类</h2>
		<div class="manage">
			<form action="FenLeiAddServlet" method="post" id="admian" >
				<table class="form">
					<tr>
						<td class="field">父分类名称：</td>
						<td>
							<input type="text" name="dalei" id="dalei" > <span class='warn' id='Divpwd'></span>
						</td>
					</tr>
					<tr>
						<td class="field">父分类编号：</td>
						<td>
							<input type="text" name="id" id="id" > <span class='warn' id='Divpwd_1'></span>
						</td>
					</tr>
					<tr>
						<td class="field">子分类名称：</td>
						<td><input type="text" class="className" name="className" id="className" /><span class='warn' id='Divpwd_2'></span></td>
					</tr>
					<tr>
						<td class="field">子分类编号：</td>
						<td><input type="text" class="ziid" name="ziid"  id="ziid" /><span class='warn' id='Divpwd_3'></span></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="button"  value="更新"  onclick=" myAdd()" /></label></td>
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