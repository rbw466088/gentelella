package com.YANG.BDQN_shop.service.you;

import java.util.List;

import com.YANG.BDQN_shop.dao.you.IXiaoLeiDao;
import com.YANG.BDQN_shop.entity.you.XiaoLeiEntity;

public class IXiaoLeiServceImpl implements IXiaoLeiServce {
	private IXiaoLeiDao xiaoLeiServce;
	public IXiaoLeiDao getXiaoLeiServce() {
		return xiaoLeiServce;
	}

	public void setXiaoLeiServce(IXiaoLeiDao xiaoLeiServce) {
		this.xiaoLeiServce = xiaoLeiServce;
	}

	@Override
	public List<XiaoLeiEntity> findAlls() {
		
		List<XiaoLeiEntity> list=null;
		try {
			list=xiaoLeiServce.findAlls();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int AddXiaoLei(XiaoLeiEntity info) {
		int i=0;
		try {
			i=xiaoLeiServce.AddXiaoLei(info);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return i;
	}

	@Override
	public int DeletXiaoLei(int papent) {
		
		int i=0;
		try {
			
			i=xiaoLeiServce.DeletXiaoLei(papent);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return i;
	}

	@Override
	public int DeletXiaos(int petId) {
		int i=0;
		try {
			
			i=xiaoLeiServce.DeletXiaos(petId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return i;
	}

	@Override
	public XiaoLeiEntity xiaoById(int id) {
		
		XiaoLeiEntity list=null;
		try {
			
			list=xiaoLeiServce.xiaoById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int XiaoLeiUpdate(XiaoLeiEntity das) {
		
		int i=0;
		try {
			i=xiaoLeiServce.XiaoLeiUpdate(das);	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		}
		return i;
	}

}
