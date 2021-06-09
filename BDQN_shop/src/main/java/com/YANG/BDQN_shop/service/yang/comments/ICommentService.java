package com.YANG.BDQN_shop.service.yang.comments;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.YANG.BDQN_shop.entity.yang.Comment;

public interface ICommentService {

		/**
		 * 获取所有用户留言
		 * @param dangQianYe
		 * @param showCounts
		 * @return
		 */
		public List<Comment> getAll(@Param("dangQianYe")int dangQianYe,@Param("showCounts")int showCounts);
		
		/**
		 * 获取所有留言数量
		 * @return
		 */
		public int getCount();
		
		/**
		 * 添加留言
		 * @param ecContent
		 * @param ecCreateTime
		 * @param ecNickName
		 * @return
		 */
		public int addCom(@Param("ecContent")String ecContent,@Param("ecCreateTime")Date ecCreateTime,@Param("ecNickName")String ecNickName);
		
}
