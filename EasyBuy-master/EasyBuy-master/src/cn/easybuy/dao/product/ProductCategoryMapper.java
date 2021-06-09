package cn.easybuy.dao.product;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.easybuy.entity.ProductCategory;
import cn.easybuy.param.ProductCategoryParam;

public interface ProductCategoryMapper {
	
	/**
	 * 添加商品分类
	 * @param productCategory
	 * @return
	 * @throws Exception
	 */
	public int add(ProductCategory productCategory) throws Exception;
	
	/**
	 * 修改商品分类
	 * @param productCategory
	 * @return
	 * @throws Exception
	 */
	public int update(ProductCategory productCategory) throws Exception;
	
	/**
	 * 根据id删除商品分类
	 * @param parseLong
	 * @return
	 * @throws Exception
	 */
	public int deleteById(@Param("id")Integer parseLong) throws Exception;
	
	/**
	 *  根据id查询商品分类
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ProductCategory queryProductCategoryById(@Param("id")Integer id) throws Exception;
	
	/**
	 * 根据条件查询商品分类列表
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<ProductCategory> queryProductCategorylist(ProductCategoryParam productCategoryParam) throws Exception;
	
	/**
	 * 根据参数查询商品分类的数目
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Integer queryProductCategoryCount(ProductCategoryParam productCategoryParam) throws Exception;
	
}
