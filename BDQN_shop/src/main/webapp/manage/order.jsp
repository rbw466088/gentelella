<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/jquery-1.8.3.js"></script>
<script type="text/javascript" src="../scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../yangProduct">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="../yangProduct">首页</a></li>
			<li><a href="News?actions=manage">用户</a></li>
			<li><a href="../manage/productList">商品</a></li>
			<li class="current"><a href="HouTaiDinDan?actions=manage">订单</a></li>
			<li ><a href="../manage/LiuYan">留言</a></li>
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
		<h2>订单管理</h2>
		<div class="manage">
			<div class="search">				
			</div>
			<div class="spacer"></div>
            <form id="orderForm" method="post"  action="HouTaiDinDan?actions=manage">
                 订单号：<input type="text" class="text" name="entityId" id="entityId" />
                 订货人：<input type="text" class="text" name="userName" />
                 <label class="ui-blue"><input type="submit" name="submit" value="查询" /></label>
            </form>
			<table class="list">
			<c:forEach items="${list}" var="st" varStatus="vs">
				<thead>
				<tr>
					<th colspan="2">单号：${st.eoid }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 时间：${st.eocreatetime }</th>	
					<th >状态：
						<select name="status">
							<c:if test="${st.eostatus==1}">
								<option value="1" selected="selected">待审核</option>
								<option value="2">审核通过</option>
								<option value="3">配货</option>
								<option value="4">送货中</option>
								<option value="5">收货并确认</option>
							</c:if>
							<c:if test="${st.eostatus==2}">
								<option value="1">待审核</option>
								<option value="2" selected="selected">审核通过</option>
								<option value="3">配货</option>
								<option value="4">送货中</option>
								<option value="5">收货并确认</option>
							</c:if>
							<c:if test="${st.eostatus==3}">
								<option value="1">待审核</option>
								<option value="2">审核通过</option>
								<option value="3" selected="selected">配货</option>
								<option value="4">送货中</option>
								<option value="5">收货并确认</option>
							</c:if>
							<c:if test="${st.eostatus==4}">
								<option value="1">待审核</option>
								<option value="2">审核通过</option>
								<option value="3">配货</option>
								<option value="4" selected="selected">送货中</option>
								<option value="5">收货并确认</option>
							</c:if>
							<c:if test="${st.eostatus==5}">
								<option value="1">待审核</option>
								<option value="2">审核通过</option>
								<option value="3">配货</option>
								<option value="4">送货中</option>
								<option value="5" selected="selected">收货并确认</option>
							</c:if>
						</select>
						</th> 
						<th><input type="submit" name="submit" value="更新" /></th>
					
					
				</tr>
				</thead>
				<tr>
					<td class="first w4 c"><img src="../images/product/${st.epfilename}" width="100px" height="100px"/>${st.epname }</td>
					<td >${st.epprice }</td>
					<td>${st.eodquantity }</td>
					<td class="w1 c" rowspan="2">总计：${st.epprice*st.eodquantity}</td>					
				</tr>
			</c:forEach>
			</table>
			
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
