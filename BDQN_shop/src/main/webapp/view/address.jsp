<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>易买网</title>
</head>
<link type="text/css" rel="stylesheet" href="${path }/css/style.css" />
<script type="text/javascript" src="${path }/scripts/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path }/scripts/function.js"></script>


<body>
<div id="header" class="wrap">
	<div id="logo"><img src="${path }/images/logo.gif" /></div>
	<div class="help"><a href="${path }/view/shopping.jsp" class="shopping">购物车X件</a><a href="login">登录</a><a href="ce">注册</a><a href="commentServlet">留言</a><a href="manage">后台管理</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="${path }/yangProduct">首页</a></li>
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
<div id="position0" class="wrap">
	您现在的位置：<a href="../view/index.jsp">易买网</a> &gt; 结账
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
				<c:forEach items="${typeList}" var="type">
				<dt><c:out value="${type.emName}"></c:out></dt>
				<c:forEach items="${categoryList}" var="epc">
					<c:if test="${type.emParentId == epc.epcParentId}">
						<dd><a href="product?id=${epc.epcId}"><c:out value="${epc.epcName}"></c:out></a></dd>
					</c:if>
				</c:forEach>
			</c:forEach>
			</dl>
		</div>
	</div>
</div>
<div id="news" class="right-main">
		<h1>&nbsp;</h1>
		<div class="content">
            <form action="${path }/addOrder" method="post">
                收货地址:<input name="addr" id="addr" type="button"  value="添加新地址" />
                <span id="span"></span> <br />
                <c:forEach var="add" items = "${listInfo}">
                	<input name="address" type="radio" id="address" checked="checked" value="${add.address}"/><span>${add.address}</span><br />
                </c:forEach>
                <input type="hidden" name="moneys" value="${productInfo.epPrice }" />
                <div class="button">  <input type="submit" value="结账" />    </div>
            </form>
		</div>
</div>
<div class="clear"></div>
<div id="position1" class="wrap"></div>
<div class="wrap">
	<div id="shopping"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>