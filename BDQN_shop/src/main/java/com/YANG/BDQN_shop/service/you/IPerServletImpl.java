package com.YANG.BDQN_shop.service.you;

import java.util.List;

import com.YANG.BDQN_shop.dao.you.IDaoimpl;
import com.YANG.BDQN_shop.entity.you.EntitySpgl;

public class IPerServletImpl implements IPerServlet {
	private IDaoimpl perServlet;
	public IDaoimpl getPerServlet() {
		return perServlet;
	}

	public void setPerServlet(IDaoimpl perServlet) {
		this.perServlet = perServlet;
	}

	@Override
	public int getCr(EntitySpgl en) {
		
		int i=0;
		try {
			i=perServlet.getCr(en);
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		}
		return i;
	}

	@Override
	public int getSc(EntitySpgl en) {		
		int i=0;
		try {
			i=perServlet.getSc(en);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		}
		return i;
	}

	@Override
	public EntitySpgl getIdcx(int id) {	
		EntitySpgl da=null;
		try{
			da= perServlet.getIdcx(id);
			}catch(Exception e){
			e.printStackTrace();
		}
		return da;
	}

	@Override
	public List<EntitySpgl> getCx() {	
		List<EntitySpgl> da=null;
		try{
			da= perServlet.getCx();
			}catch(Exception e){
			e.printStackTrace();
		}
		return da;
	}

	@Override
	public List<EntitySpgl> getMh(String name) {	
		List<EntitySpgl> da=null;
		try{
			da= perServlet.getMh(name);
			}catch(Exception e){
			e.printStackTrace();
		}
		return da; 
		
	}

	@Override
	public boolean getXg(EntitySpgl en) {
		boolean i=true;
		try {	
			i=perServlet.getXg(en);		
		} catch (Exception e) {
			e.printStackTrace();
		}finally { 
			
		}
		return i;
	}

}
