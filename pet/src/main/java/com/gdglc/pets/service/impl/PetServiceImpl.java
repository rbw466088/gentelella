package com.gdglc.pets.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.gdglc.pets.dao.PetMapper;
import com.gdglc.pets.entity.Pet;
import com.gdglc.pets.service.PetService;
import com.github.pagehelper.PageInfo;

public class PetServiceImpl implements PetService {
	
	//定义dao接口对象属性
	private PetMapper petMapper;
	
	public PetMapper getPetMapper() {
		return petMapper;
	}

	public void setPetMapper(PetMapper petMapper) {
		this.petMapper = petMapper;
	}

	@Override
	public List<Pet> selectPetListPage() {
		List<Pet> petList = new ArrayList<Pet>();
		try {
			petList = petMapper.selectPetListPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return petList;
	}

	@Override
	public int deleteByPrimaryKey(Integer petId) {
		int num = 0;
		try {
			if(null!=petId) {
				num = petMapper.deleteByPrimaryKey(petId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int insert(Pet record) {
		int num = 0;
		try {
			if(null!=record) {
				num = petMapper.insert(record);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public int insertSelective(Pet record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Pet> selectPetByBreedListPage(String petBreed) {
		List<Pet> petList = new ArrayList<Pet>();
		try {
			petList = petMapper.selectPetByBreedListPage(petBreed);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return petList;
	}

	@Override
	public int updateByPrimaryKeySelective(Pet record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Pet record) {
		int num = 0;
		try {
			if(null!=record) {
				num = petMapper.updateByPrimaryKey(record);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public List<Pet> selectArticleListPage(PageInfo page, int userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pet> selectPetByID(Integer petId) {
		List<Pet> petList = new ArrayList<Pet>();
		try {
			petList = petMapper.selectPetByID(petId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return petList;
	}



}
