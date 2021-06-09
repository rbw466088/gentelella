<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="${path }/css/style.css" />
<script type="text/javascript" src="${path }/scripts/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path }/scripts/function.js"></script>
</head>

<script type="text/javascript">
	function myAdd(){
		var Name = $("#userId").val();
		var anothername = $("#password").val();
		var yanZhengMa = $("#yanZhengMa").val();
		
		if(!Name){
			alert("请填写用户名！");
			return;
		}
		if(!anothername){
			alert("请填写密码！");
			return;
		}
		if(!yanZhengMa){
			alert("请输入验证码！");
			return;
		}
		$('#addForm').submit();
	}

</script>
<script type="text/javascript">
	<c:if test="${!empty message}">
		alert('${message}');
	</c:if>
	<c:remove var="message" scope="session"/>
</script>

	
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
<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
			<h1>欢迎回到易买网</h1>
			<form id="addForm" method="post" action="${path }/login?action=${action}">
				<table>
					<tr>
						<td class="field">用户名：</td>
						<td>
                            <input class="text" type="text" id="userId" name="userId" />
							<span class='warn' id='Divpwd_1'></span>
						</td>
					</tr>
					<tr>
						<td class="field">登录密码：</td>
						<td>
                            <input class="text" type="password" id="password" name="password" />
							<span class='warn' id='Divpwd_2'></span>
						</td>
					</tr>
					<tr>
						<td class="field">输入验证码：</td>
						<td><input class="text" type="text" id="yanZhengMa" name="yanZhengMa" /></td>
						<td>
                            <img src="${path }/codeUtil" id="img"/> 
  			<a href="javascript:;" onclick="document. 
   getElementById('img').src='${path }/codeUtil?'+new Date().getTime();">看不清，换一个</a> 

							<span class='warn' id='Divpwd_3'></span>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-green"><input type="button"  value="立即登录" onclick="myAdd()"/></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>