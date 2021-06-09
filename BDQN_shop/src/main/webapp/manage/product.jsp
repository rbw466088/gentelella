<%@page import="com.YANG.BDQN_shop.entity.you.EntitySpgl"%>
<%@page import="java.util.List"%>
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
<script type="text/javascript">
	function myAdd(){
		$("#myFrom").submit();
	}
</script>
 <%
  	  	List<EntitySpgl> list=(List<EntitySpgl>)session.getAttribute("proList");
    	if(session.getAttribute("proList")==null){
        	request.getRequestDispatcher("productList").forward(request, response);
        	return;
        }
        
        int a_hangshu=4; //每页显示行数
        int a_zongshu=list.size();//记录总行数
        int a_zongyeshu=a_zongshu%a_hangshu==0?a_zongshu/a_hangshu:a_zongshu/a_hangshu+1;//总页数
        int a_dangqian=1;//当前页数    
        String a_str=request.getParameter("dangqian");
        if(a_str!=null){
        	try{
        		a_dangqian=Integer.parseInt(a_str);
        	}
        	catch(Exception ex){
        		ex.printStackTrace();
        	}
        }
        if(a_dangqian<1){
        	a_dangqian=1;
        }
        if(a_dangqian>a_zongshu){
        	a_dangqian=a_zongshu;
        }
        //当前页的数据行
        int start=(a_dangqian-1)*a_hangshu;
        int end=a_dangqian*a_hangshu>a_zongshu?a_zongshu:a_dangqian*a_hangshu;
        List<EntitySpgl> li=list.subList(start, end);
        //out.print(li.size());
    %>
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
		<h2>商品管理</h2>
		<form action="productMh" method="post" id="myFrom">
		商品名称查询：<input type="text" id="name" name="name"/><input type="button" value="查询" onclick="myAdd()"/><span id="Divname"></span>
		</form>
		<div class="manage">
			<table class="list">
				<tr>
					<th>编号</th>
					<th>商品名称</th>
					<th>操作</th>
				</tr>
					<%
     				for(EntitySpgl en:li){
     			%>
				<tr>
					<td class="first w4 c"><%=en.getEpid()%></td>
					<td class="thumb"><img src="${path }/images/product/<%=en.getEpfilename()%>" width="100px" height="100px"/><%=en.getEpname()%></td>
					<td class="w1 c"><a href="productInfo?id=<%=en.getEpid()%>">修改</a> <a class="manageDel" href="productDel?id=<%=en.getEpid()%>">删除</a></td>
				</tr>
				<%} %>
				<tr>
     				<td colspan="3" id="fy">
     					<%if(a_dangqian==1){ %>
     			首页&nbsp;上一页
     		<%}else{ %>
     		<a href="product.jsp?dangqian=1">首页</a>
     		<a href="product.jsp?dangqian=<%=a_dangqian-1%>">上一页</a>
     		<%} %>
     		
     		<%if(a_dangqian==a_zongyeshu){ %>
     			下一页&nbsp;尾页
     		<%}else{ %>
     		<a href="${path}/manage/product.jsp?dangqian=<%=a_dangqian+1 %>">下一页</a>
     		<a href="${path}/manage/product.jsp?dangqian=<%=a_zongyeshu %>">尾页</a>
     		<%} %>
     				</td>
     			</tr>
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
