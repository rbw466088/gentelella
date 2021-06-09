<%@page import="com.YANG.BDQN_shop.entity.you.XiaoLeiEntity"%>
<%@page import="com.YANG.BDQN_shop.entity.you.DaLeiEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/jquery-1.8.3.js"></script>
<script type="text/javascript" src="../scripts/function.js"></script>
</head>
 <%
  	  	List<DaLeiEntity> da=(List<DaLeiEntity>)session.getAttribute("daLei");
		 List<XiaoLeiEntity> xiao=(List<XiaoLeiEntity>)session.getAttribute("xiao");
    	if(request.getAttribute("daLei")==null){
        	request.getRequestDispatcher("DaLeiServlet").forward(request, response);
        	return;
        }
        
        int a_hangshu=2; //每页显示行数
        int a_zongshu=da.size();//记录总行数
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
        List<DaLeiEntity> li=da.subList(start, end);
        //out.print(li.size());
    %>
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
		<h2>分类管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>编号</th>
					<th>分类名称</th>
					<th>操作</th>
				</tr>
				<%
     				for(DaLeiEntity dalei:li){
     			%>
				<tr>
					<td class="first w4 c"><%=dalei.getId() %> </td>
					<td><%=dalei.getName() %></td>
					<td class="w1 c"><a href="DaLeiInfoServlet?id=<%=dalei.getId() %>">修改</a> <a class="manageDel" href="FenLeiDeleteServlet?id=<%=dalei.getPapent()%>">删除</a></td>
				</tr>
				<%
     				for(XiaoLeiEntity xiaolei:xiao){
     					if(dalei.getPapent()==xiaolei.getPapent()){
     			%>
				<tr>
					<td class="first w4 c"><%=xiaolei.getId() %></td>
					<td class="childClass"><%=xiaolei.getName() %></td>
					<td class="w1 c"><a href="XiaoInfoServlet?id=<%=xiaolei.getId() %>">修改</a> <a class="manageDel" href="XiaoDeleteServlet?id=<%=xiaolei.getId() %>">删除</a></td>
				</tr>
				<%}
				} %>
				<%} %>
				<tr>
     				<td colspan="3" id="fy">
     					<%if(a_dangqian==1){ %>
     			首页&nbsp;上一页
     		<%}else{ %>
     		<a href="productClass.jsp?dangqian=1">首页</a>
     		<a href="productClass.jsp?dangqian=<%=a_dangqian-1%>">上一页</a>
     		<%} %>
     		
     		<%if(a_dangqian==a_zongyeshu){ %>
     			下一页&nbsp;尾页
     		<%}else{ %>
     		<a href="${path}/manage/productClass.jsp?dangqian=<%=a_dangqian+1 %>">下一页</a>
     		<a href="${path}/manage/productClass.jsp?dangqian=<%=a_zongyeshu %>">尾页</a>
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