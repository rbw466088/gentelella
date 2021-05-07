package cn.easybuy.dao.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.easybuy.entity.Product;
import cn.easybuy.entity.User;


/**
 * ProductMapper接口方法：
 *（1）增加商品（返回类型：int，参数：Product对象）。
 *（2）根据商品id修改商品信息（返回类型：int，参数：Product对象）。
 *（3）根据商品id删除商品信息（返回类型：int，参数：商品id）。
 *（4）根据商品id查看商品详情（返回类型：Product，参数：商品id）。
 *（5）根据查询条件，分页显示商品信息列表（返回类型：List<Product>，参数：当前页码、页码容量、商品名称、分类级别、类别）。
 *（6）根据条件查询商品信息表总记录数（返回类型：int，参数：商品名称、分类级别、类别）。
 *（7）更新指定商品库存量（返回类型：int，参数：商品id、库存）。
 */
public interface ProductMapper {
	
	/**
	 * 增加商品（返回类型：int，参数：Product对象）。
	 */
	public int add(Product product) throws Exception;
	
	/**
	 * 根据商品id修改商品信息（返回类型：int，参数：Product对象）。
	 */
	public int update(Product product) throws Exception;
	
	/**
	 * 根据商品id删除商品信息（返回类型：int，参数：商品id）。
	 */
	public int deleteProductById(@Param("id")Integer productId) throws Exception;
	
	/**
	 * 根据商品id查看商品详情（返回类型：Product，参数：商品id）.
	 */
	public Product getProductById(@Param("id")Integer productId) throws Exception;
	
	/**
	 * 根据查询条件，分页显示商品信息列表（返回类型：List<Product>，参数：当前页码、页码容量、商品名称、分类级别、类别）。
	 */
	public List<Product> getProductList(@Param("from")Integer currentPageNo,
										@Param("pageSize")Integer pageSize,
										@Param("proName")String proName,
										@Param("categoryId")Integer categoryId,
										@Param("level")Integer level) throws Exception;
	
	/**
	 * 根据条件查询商品信息表总记录数（返回类型：int，参数：商品名称、分类级别、类别）。
	 */
	public int count(@Param("proName")String proName,
					 @Param("categoryId")Integer categoryId,
					 @Param("level")Integer level) throws Exception;
	
	/**
	 * 更新指定商品库存量（返回类型：int，参数：商品id、库存）。
	 */
	public int updateStock(@Param("id")Integer productId,@Param("stock")Integer stock) throws Exception;
	

}
