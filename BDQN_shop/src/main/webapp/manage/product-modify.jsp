<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理 - 易买网</title>
<style type="text/css">
span{
color: red;
}
</style>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/jquery-1.8.3.js"></script>
<script type="text/javascript" src="../scripts/function.js"></script>
<script type="text/javascript">
	function myAdd(){
		var productName = $("#productName").val();
		var DivproductName = $("#DivproductName");
		if(productName==""){
			DivproductName.html("名字不能为空!");
			return false;
		}
		else{
			DivproductName.html("");
		}
		var productms = $("#productms").val();
		var Divproductms = $("#Divproductms");
		if(productms==""){
			Divproductms.html("描述不能为空!");
			return false;
		}
		else{
			Divproductms.html("");
		}
		var parentId = $("#parentId").val();
		var DivparentId = $("#DivparentId");
		if(parentId==""){
			DivparentId.html("分类不能为空!");
			return false;
		}
		else{
			DivparentId.html("");
		}
		var productPrice=$("#productPrice").val();
		var DivproductPrice=$("#DivproductPrice");
		if(productPrice==""){
			DivproductPrice.html("价格不能为空");
			return false;
		}
		else{
			DivproductPrice.html("");
		}
		var products = $("#products").val();
		var Divproducts = $("#Divproducts");
		if(products==""){
			Divproducts.html("库存不能为空！");
			return false;
		}
		else{
			Divproducts.html("");
		}
		var photo=$("#photo").val();
		var Divphoto=$("#Divphoto");
		if(photo==""){
			Divphoto.html("图片不能为空！");
			return false;
		}
		else{
			Divphoto.html("");
		}
        $("#myform").submit();
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
			<li><a href="HouTaiDinDan?actions=manage">订单</a></li>
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
		<h2>修改商品</h2>
		<div class="manage">
			<form action="${path}/manage/productUp" id="myform" enctype="multipart/form-data" method="post">
				<table class="form">
					<tr><td><input type="hidden" name="id"  value="${spinfo.epid}"></td></tr>
					<tr>
					
						<td class="field">商品名称(*)：</td>
						<td><input type="text" class="text" name="productName" id="productName" value="${spinfo.epname }" /><span id="DivproductName"></span></td>
					</tr>
                    <tr>
						<td class="field">描述：</td>
						<td><input type="text" class="text" name="productms" id="productms" value="${spinfo.epdescription }"/><span id="Divproductms"></span></td>
					</tr>
					<tr>
						<td class="field">所属分类：</td>
						<td>
							<select name="parentId" id="parentId">
							<option value="">请选择</option>
							<c:forEach items="${daLei}" var="da">
								
								<c:forEach items="${xiao}" var="xiao">
								<c:if test="${da.papent==xiao.papent}">
								<option value="${xiao.id}">&nbsp;&nbsp;${xiao.name}</option>
								</c:if>
									</c:forEach>
							</c:forEach>	
							</select>
						<span id="DivparentId"></span></td>
					</tr>					
					<tr>
						<td class="field">商品价格(*)：</td>
						<td><input type="text" class="text tiny" name="productPrice" id="productPrice"  value=${spinfo.epprice }> （元）<span id="DivproductPrice"></span></td>
					</tr>
					
					<tr>
						<td class="field">库存(*)：</td>
						<td><input type="text" class="text tiny" name="products" id="products"  value=${spinfo.epstock }><span id="Divproducts"></span></td>
					</tr>
					<tr>
						<td class="field">商品图片：</td>
						<td><input type="file" class="text" name="photo" id="photo"/><span id="Divphoto"></span></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="button"  value="确定" onclick="myAdd()"/></label></td>
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