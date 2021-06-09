package cn.easybuy.service.user;

import cn.easybuy.dao.order.UserAddressMapper;
import cn.easybuy.entity.UserAddress;
import cn.easybuy.param.UserAddressParam;
import cn.easybuy.utils.MyBatisUtil;
import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by bdqn on 2016/5/12.
 */
public class UserAddressServiceImpl implements UserAddressService {
    /**
     * 查询用户地址列表
     *
     * @param id
     * @return
     * @throws Exception
     */
    public List<UserAddress> queryUserAdressList(Integer id) throws Exception{
    	SqlSession sqlSession = null;
        List<UserAddress> userAddressList = null;
        try {
        	sqlSession = MyBatisUtil.createSqlSession();
            UserAddressParam params = new UserAddressParam();
            params.setUserId(id);
            userAddressList = sqlSession.getMapper(UserAddressMapper.class).queryUserAddressList(params);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            userAddressList = null;
        }finally{
        	MyBatisUtil.closeSqlSession(sqlSession);
        }
        return userAddressList;
    }
    /**
     * 添加用户地址
     *
     * @param id
     * @param address
     * @return
     */
    @Override
    public Integer addUserAddress(Integer id, String address,String remark) {
    	SqlSession sqlSession = null;
    	Integer userAddressId = null;
        try {
			sqlSession = MyBatisUtil.createSqlSession();
			UserAddress userAddress=new UserAddress();
	        userAddress.setUserId(id);
	        userAddress.setAddress(address);
	        userAddress.setRemark(remark);
			userAddressId = sqlSession.getMapper(UserAddressMapper.class).add(userAddress);
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			sqlSession.rollback();
			userAddressId = null;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return userAddressId;
    }

    @Override
    public UserAddress getUserAddressById(Integer id) {
    	SqlSession sqlSession = null;
    	UserAddress userAddress=new UserAddress();
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			userAddress = sqlSession.getMapper(UserAddressMapper.class).getUserAddressById(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			userAddress = null;
		}finally{
			MyBatisUtil.closeSqlSession(sqlSession);
		}
		return userAddress;
    }
}
