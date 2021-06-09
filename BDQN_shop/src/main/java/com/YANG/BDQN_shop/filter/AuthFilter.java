package com.YANG.BDQN_shop.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.YANG.BDQN_shop.entity.you.LoginEntity;


public class AuthFilter implements Filter  {
	
	protected void Auth(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hrequest = (HttpServletRequest)request;
		HttpServletResponse hresponse=(HttpServletResponse)response;
		
		String path = hrequest.getContextPath();
		//获取登录用户信息
		LoginEntity user = (LoginEntity)hrequest.getSession().getAttribute("account");
		//如果不存在用户信息，跳转到登录页面
		if(null == user){
			hresponse.sendRedirect(path+"/login");
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
}
