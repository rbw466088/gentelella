package cn.easybuy.service.product;

import cn.easybuy.dao.product.ProductCategoryDao;
import cn.easybuy.dao.product.ProductCategoryDaoImpl;
import cn.easybuy.dao.product.ProductCategoryMapper;
import cn.easybuy.dao.product.ProductMapper;
import cn.easybuy.entity.Product;
import cn.easybuy.entity.ProductCategory;
import cn.easybuy.param.ProductCategoryParam;
import cn.easybuy.utils.DataSourceUtil;
import cn.easybuy.utils.EmptyUtils;
import cn.easybuy.utils.MyBatisUtil;
import cn.easybuy.utils.Params;
import cn.easybuy.utils.ProductCategoryVo;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

/**
 * Created by bdqn on 2016/5/8.
 */
public class ProductCategoryServiceImpl implements ProductCategoryService {
	
	private Logger logger = Logger.getLogger(ProductCategoryServiceImpl.class);
    /**
     *
     * @param id
     * @return
     */
    @Override
    public ProductCategory getById(Integer id) {
        SqlSession sqlSession = null;
        ProductCategory productCategory = new ProductCategory();
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			productCategory = sqlSession.getMapper(ProductCategoryMapper.class).queryProductCategoryById(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			productCategory = null;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return productCategory;
    }

    @Override
    public List<ProductCategory> queryProductCategoryList(ProductCategoryParam params) {
        SqlSession sqlSession = null;
		List<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			productCategoryList = sqlSession.getMapper(ProductCategoryMapper.class).queryProductCategorylist(params);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			productCategoryList = null;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		logger.debug("productCategoryList size: " + productCategoryList.size());
		return productCategoryList;
    }

    @Override
    public int queryProductCategoryCount(ProductCategoryParam params) {
        SqlSession sqlSession = null;
		int count = 0;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			count = sqlSession.getMapper(ProductCategoryMapper.class).queryProductCategoryCount(params);
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
    public boolean modifyProductCategory(ProductCategory productCategory) {
        SqlSession sqlSession = null;
		boolean flag = false;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			if(sqlSession.getMapper(ProductCategoryMapper.class).update(productCategory) > 0)
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
    /**
     * 新增商品分类
     */
    @Override
    public boolean addProductCategory(ProductCategory productCategory) {
    	SqlSession sqlSession = null;
		boolean flag = false;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			if(sqlSession.getMapper(ProductCategoryMapper.class).add(productCategory) > 0)
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
    /**
     * 根据Id删除商品
     * @param id
     */
    @Override
    public boolean deleteById(Integer id) {
    	SqlSession sqlSession = null;
		boolean flag = false;
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			if(sqlSession.getMapper(ProductCategoryMapper.class).deleteById(id) > 0)
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
    /**
     * 查询全部的商品分类
     * @return
     */
    @Override
    public List<ProductCategoryVo> queryAllProductCategoryList() {
        //查询一级分类的列表
        List<ProductCategoryVo> productCategory1VoList = new ArrayList<ProductCategoryVo>();
        //查询一级分类
        List<ProductCategory> productCategory1List = getProductCategories(null);
        //查询二级分类
        for (ProductCategory product1Category : productCategory1List) {
            //封装一级分类
            ProductCategoryVo productCategoryVo = new ProductCategoryVo();
            productCategoryVo.setProductCategory(product1Category);
            List<ProductCategoryVo> productCategoryVo1ChildList = new ArrayList<ProductCategoryVo>();
            //根据一级分类查询二级分类
            List<ProductCategory> productCategory2List = getProductCategories(product1Category.getId());
            for (ProductCategory productCategory2 : productCategory2List) {
                ProductCategoryVo productCategoryVo2 = new ProductCategoryVo();
                productCategoryVo1ChildList.add(productCategoryVo2);
                productCategoryVo2.setProductCategory(productCategory2);
                List<ProductCategoryVo> productCategoryVo2ChildList = new ArrayList<ProductCategoryVo>();
                productCategoryVo2.setProductCategoryVoList(productCategoryVo2ChildList);
                //根据二级分类查询三级分类的列表
                List<ProductCategory> productCategory3List = getProductCategories(productCategory2.getId());
                for (ProductCategory productCategory3 : productCategory3List) {
                    ProductCategoryVo productCategoryVo3 = new ProductCategoryVo();
                    productCategoryVo3.setProductCategory(productCategory3);
                    productCategoryVo2ChildList.add(productCategoryVo3);
                }
            }
            productCategoryVo.setProductCategoryVoList(productCategoryVo1ChildList);
            productCategory1VoList.add(productCategoryVo);
        }
        return productCategory1VoList;
    }
    /**
     * 查询子分类
     * @param parentId
     * @return
     */
    private List<ProductCategory> getProductCategories(Integer parentId) {//根据父ID查询所有子商品分类
    	SqlSession sqlSession = null;
    	List<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();
        try {
        	sqlSession = MyBatisUtil.createSqlSession();
            ProductCategoryParam params = new ProductCategoryParam();
            if (EmptyUtils.isNotEmpty(parentId)) {
            	params.setParentId(parentId);
            } else {
            	params.setParentId(0);
            }
            productCategoryList = sqlSession.getMapper(ProductCategoryMapper.class).queryProductCategorylist(params);
        } catch (Exception e) {
            e.printStackTrace();
            productCategoryList = null;
        } finally {
        	MyBatisUtil.closeSqlSession(sqlSession);
        }
        logger.debug("productCategoryList size: " + productCategoryList.size());
		return productCategoryList;
    }
}
