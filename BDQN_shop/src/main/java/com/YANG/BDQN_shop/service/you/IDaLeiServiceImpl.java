package com.YANG.BDQN_shop.service.you;

import java.util.List;

import com.YANG.BDQN_shop.dao.you.IDaLeiDao;
import com.YANG.BDQN_shop.entity.you.DaLeiEntity;

public class IDaLeiServiceImpl implements IDaLeiService {
	private IDaLeiDao  daLeiService;
	public IDaLeiDao getDaLeiService() {
		return daLeiService;
	}

	public void setDaLeiService(IDaLeiDao daLeiService) {
		this.daLeiService = daLeiService;
	}

	@Override
	public DaLeiEntity findById(int id) {
		DaLeiEntity da = new DaLeiEntity();;
		try{
			da= daLeiService.findById(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return da;
	}

	@Override
	public List<DaLeiEntity> findAlls() {
		
		List<DaLeiEntity> list=null;
		try {
			list=daLeiService.findAlls();	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int DaLeiUpdate(DaLeiEntity das) {
		int i=0;
		try {
			i=daLeiService.DaLeiUpdate(das);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		}
		return i;
	}

	@Override
	public int AddDaLei(DaLeiEntity info) {
		
		int i=0;
		try {
			i=daLeiService.AddDaLei(info);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {	
		}
		return i;
	}

	@Override
	public int DeletDaLei(int petId) {
		
		int i=0;
		try {
			i=daLeiService.DeletDaLei(petId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		}
		return i;
	}

}
