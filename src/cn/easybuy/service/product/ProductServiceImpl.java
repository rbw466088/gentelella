package cn.easybuy.service.product;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import cn.easybuy.dao.product.ProductMapper;
import cn.easybuy.entity.Product;
import cn.easybuy.utils.MyBatisUtil;

/**
 * 商品的业务类
 */
public class ProductServiceImpl implements ProductService {
	
	private Logger logger = Logger.getLogger(ProductServiceImpl.class);
	
	@Override
	public boolean add(Product product) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		boolean flag = false;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			if(sqlSession.getMapper(ProductMapper.class).add(product) > 0)
               flag = true;
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			sqlSession.rollback();
			flag = false;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return flag;
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		boolean flag = false;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			if(sqlSession.getMapper(ProductMapper.class).update(product) > 0)
               flag = true;
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			sqlSession.rollback();
			flag = false;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return flag;
	}

	@Override
	public boolean deleteProductById(Integer productId) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		boolean flag = false;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			if(sqlSession.getMapper(ProductMapper.class).deleteProductById(productId) > 0)
               flag = true;
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			sqlSession.rollback();
			flag = false;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return flag;
	}

	@Override
	public Product getProductById(Integer productId) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		Product product = new Product();
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			product = sqlSession.getMapper(ProductMapper.class).getProductById(productId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			product = null;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return product;
	}

	@Override
	public List<Product> getProductList(Integer currentPageNo,Integer pageSize, 
										String proName, Integer categoryId, Integer level) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		List<Product> productList = new ArrayList<Product>();
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			currentPageNo = (currentPageNo-1)*pageSize;
			productList = sqlSession.getMapper(ProductMapper.class).getProductList(currentPageNo, pageSize, proName, categoryId, level);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			productList = null;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		logger.debug("productList size: " + productList.size());
		return productList;
	}

	@Override
	public int count(String proName,Integer categoryId, Integer level) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		int count = 0;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			count = sqlSession.getMapper(ProductMapper.class).count(proName, categoryId, level);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			count = 0;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return count;
	}

	@Override
	public boolean updateStock(Integer productId, Integer stock) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		boolean flag = false;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			if(sqlSession.getMapper(ProductMapper.class).updateStock(productId, stock) > 0)
               flag = true;
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			sqlSession.rollback();
			flag = false;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return flag;
	}
   
}
