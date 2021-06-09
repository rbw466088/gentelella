package com.YANG.BDQN_shop.service.you;

import java.util.List;

import com.YANG.BDQN_shop.dao.you.ILoginDao;
import com.YANG.BDQN_shop.entity.you.LoginEntity;

public class ILoginServletImpl implements ILoginServlet {
	private ILoginDao loginServlet;
	public ILoginDao getLoginServlet() {
		return loginServlet;
	}

	public void setLoginServlet(ILoginDao loginServlet) {
		this.loginServlet = loginServlet;
	}

	@Override
	public LoginEntity findAll(LoginEntity info) {
		LoginEntity da=null;
		try{
			da= loginServlet.findAll(info);
			}catch(Exception e){
			e.printStackTrace();
		}
		return da;
	}

	@Override
	public int status(String id, String pwd) {
		int i=0;
		try{
			i= loginServlet.status(id,pwd);
			}catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public LoginEntity loginById(String id) {
		LoginEntity da=null;
		try{
			da= loginServlet.loginById(id);
			}catch(Exception e){
			e.printStackTrace();
		}
		return da;
	}

	@Override
	public int update(LoginEntity login) {	
		int i=0;
		try {
			i=loginServlet.update(login);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		}
		return i;
	}

	@Override
	public List<LoginEntity> findAlls(String id) {
		List<LoginEntity> da=null;
		try{
			da= loginServlet.findAlls(id);
			}catch(Exception e){
			e.printStackTrace();
		}
		return da;
	}

}
