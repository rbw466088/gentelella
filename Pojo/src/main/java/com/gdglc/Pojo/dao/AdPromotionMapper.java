package com.gdglc.Pojo.dao;

import com.gdglc.Pojo.entity.AdPromotion;

public interface AdPromotionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AdPromotion record);

    int insertSelective(AdPromotion record);

    AdPromotion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdPromotion record);

    int updateByPrimaryKey(AdPromotion record);
}