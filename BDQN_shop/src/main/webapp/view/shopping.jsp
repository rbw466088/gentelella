<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="${path }/css/style.css" />
<script type="text/javascript" src="${path }/scripts/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path }/scripts/function.js"></script>
<script type="text/javascript">
//删除商品
function myDel(id){
    if(confirm("确定要删除吗？")) {
    	window.location.href="${path }/shoppingCart?action=remove&epId="+id;    	
    }else{
        return false;
    }
};
function myRem(id){
	 var num = $("#number_id_0").val();//存值
	 if(num<=1){
		 if(confirm("确定要删除吗？")) {
		    	window.location.href="${path }/shoppingCart?action=remove&id=add&epId="+id;    	
		    }else{
		        return false;
		    }
	 }
	 window.location.href="${path }/shoppingCart?action=delete&id=add&epId="+id;
};
</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="${path }/images/logo.gif" /></div>
	<div class="help"><a href="${path }/view/shopping.jsp" class="shopping">购物车X件</a><a href="../view/login.jsp">登录</a><a href="../view/register.jsp">注册</a><a href="../view/guestbook.jsp">留言</a><a href="../manage/index.jsp">后台管理</a></div>
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
<div id="position" class="wrap">
	您现在的位置：<a href="${path }/yangProduct">易买网</a> &gt; 购物车
</div>
<div class="wrap">
	<div id="shopping">
		<form action="${path }/showAddress?user=${inst.getId()}" method="post">
			<table>
				<tr>
					<th>商品名称</th>
					<th>商品价格</th>
					<th>购买数量</th>
					<th>操作</th>
				</tr>
				<c:forEach var="item" items="${cart.items }" varStatus="statu">
				<tr id="product_id_0">
					<td class="thumb"><a href="${path }/fengProductView?epid=${item.value.product.epId }"><img src="${path }/images/product/${item.value.product.epFileName }" /></a><a href="${path }/fengProductView?epid=${item.value.product.epId }">${item.value.product.epName }</a></td>
					<td class="price" id="price_id_0">
						<span>￥${item.value.cost }</span>
						<input type="hidden" value="99" />
					</td>
					<td class="number">
                        <span name="del"><a href="javascript:void(0)" onclick="myRem('${item.value.product.epId }');">-</a></span>
                       <input name="number" type="text" id="number_id_0" value="${item.value.count }"  />
                        <span name="add"><a href="shoppingCart?action=add&id=add&epId=${item.value.product.epId }">+</a></span>
					</td>
					<td class="delete"><a href="javascript:void(0)" onclick="myDel('${item.value.product.epId }');">删除</a></td>
				</tr>
				</c:forEach>
			</table>
			
            <div class="total"><span id="total">总计：￥${cart.totalCost }</span></div>
            <input type="hidden" name="money" value="${cart.totalCost }" />
			<div class="button"><input type="submit" value="" /></div>
		</form>
	</div>
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
