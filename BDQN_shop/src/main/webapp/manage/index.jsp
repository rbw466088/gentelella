
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-1.8.3.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>

<c:remove var="message" scope="session"/>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="yangProduct">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="yangProduct">首页</a></li>
			<li><a href="manage/News?actions=manage">用户</a></li>
			<li><a href="manage/productList">商品</a></li>
			<li><a href="manage/HouTaiDinDan?actions=manage">订单</a></li>
			<li><a href="manage/LiuYan">留言</a></li>
			<li><a href="manage/infoNewsServlet">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		<c:out value="${account.id}"></c:out>您好，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="yangProduct">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd ><a href="manage/News?actions=manage">用户管理</a></dd>
			  <dt>商品信息</dt>
				<dd><em><a href="manage/productClass-add.jsp">新增</a></em><a href="manage/DaLeiServlet">分类管理</a></dd>
				<dd><em><a href="manage/FenLeiServlet">新增</a></em><a href="manage/productList">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="manage/HouTaiDinDan?actions=manage">订单管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="manage/LiuYan">留言管理</a></dd>
				<dt>新闻管理</dt>
				<dd><em><a href="manage/news-add.jsp">新增</a></em><a href="manage/infoNewsServlet">新闻管理</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>管理首页</h2>
		<div id="welcome" class="manage">
			<div class="shadow">
				<em class="corner lb"></em>
				<em class="corner rt"></em>
				<div class="box">
					<div class="msg">
						<p>欢迎回来</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
