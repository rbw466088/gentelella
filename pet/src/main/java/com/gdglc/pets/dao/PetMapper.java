package com.gdglc.pets.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gdglc.pets.entity.Pet;
import com.github.pagehelper.PageInfo;

public interface PetMapper {
	
	/**
	 * 获取所有宠物信息
	 * @return
	 */
	List<Pet> selectPetListPage();
	
	/**
	 * 按ID删除宠物信息
	 * @param petId
	 * @return
	 */
    int deleteByPrimaryKey(Integer petId);

    /**
     * 新增宠物信息
     * @param record
     * @return
     */
    int insert(Pet record);

    int insertSelective(Pet record);
    
    /**
     * 按品种获取相应宠物信息
     * @param petBreed
     * @return
     */
    List<Pet> selectPetByBreedListPage(String petBreed);
    
    /**
     * 按ID获取宠物信息
     * @return
     */
    List<Pet> selectPetByID(Integer petId);

    int updateByPrimaryKeySelective(Pet record);
    
    /**
     * 更新宠物信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(Pet record);
    
    /**
     * 分页
     * @param page
     * @param userid
     * @return
     */
    public List<Pet> selectArticleListPage(@Param("page") PageInfo page,@Param("userid") int userid);
}