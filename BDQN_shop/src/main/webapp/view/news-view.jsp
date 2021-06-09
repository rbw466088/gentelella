<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-1.8.3.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="view/shopping.jsp" class="shopping">购物车X件</a><a href="login">登录</a><a href="ce">注册</a><a href="commentServlet">留言</a><a href="manage">后台管理</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="yangProduct">首页</a></li>
			<li><a href="#">图书</a></li>
			<li><a href="#">百货</a></li>
			<li><a href="#">品牌</a></li>
			<li><a href="#">促销</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			<li class="first"><a href="#">音乐</a></li>
			<li><a href="#">影视</a></li>
			<li><a href="#">少儿</a></li>
			<li><a href="#">动漫</a></li>
			<li><a href="#">小说</a></li>
			<li><a href="#">外语</a></li>
			<li><a href="#">数码相机</a></li>
			<li><a href="#">笔记本</a></li>
			<li><a href="#">羽绒服</a></li>
			<li><a href="#">秋冬靴</a></li>
			<li><a href="#">运动鞋</a></li>
			<li><a href="#">美容护肤</a></li>
			<li><a href="#">家纺用品</a></li>
			<li><a href="#">婴幼奶粉</a></li>
			<li><a href="#">饰品</a></li>
			<li class="last"><a href="#">Investor Relations</a></li>
		</ul>
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="yangProduct">易买网</a> &gt; 阅读新闻
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
				<c:forEach items="${typeList}" var="type">
				<dt><c:out value="${type.emName}"></c:out></dt>
				<c:forEach items="${categoryList }" var="epc">
					<c:if test="${type.emParentId == epc.epcParentId }">
						<dd><a href="product?id=${epc.epcId}"><c:out value="${epc.epcName}"></c:out></a></dd>
					</c:if>
				</c:forEach>
			</c:forEach>
			</dl>
		</div>
		<div class="spacer"></div>
		<div class="last-view">
			<h2>最近浏览</h2>
			<dl class="clearfix">
				<c:forEach items="${sessionScope.productsInfo}" var="productInfo">
					<dt><a href="fengProductView?epid=${productInfo.epId }"><img src="images/product/${productInfo.epFileName }" style="height: 30px;width: 30px;"/></a></dt>
					<dd><a href="fengProductView?epid=${productInfo.epId }" target="_self">${productInfo.epName }</a></dd>
				</c:forEach>
		  </dl>
		  
	  </div>
	</div>
	</div>
	<div id="news" class="right-main" >
		<h1>${byIdList.get(0).getEnTitle()}</h1>
		<div class="content">
			<ul>
				<li>${byIdList.get(0).enContent}</li>
			</ul>
		</div>
	</div>
	<div class="clear"></div>

<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>