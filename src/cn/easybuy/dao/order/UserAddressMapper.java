package cn.easybuy.dao.order;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.easybuy.entity.UserAddress;
import cn.easybuy.param.UserAddressParam;

public interface UserAddressMapper {
	
	/**
	 * 查询用户地址信息（参数是地址类分页对象）
	 */
	public List<UserAddress> queryUserAddressList(UserAddressParam userAddressParam)throws Exception;
	
	/**
	 * 增加用户地址
	 */
	public Integer add(UserAddress userAddress)throws Exception;
	
	/**
	 * 查询用户地址，按主键查询
	 */
	public UserAddress getUserAddressById(@Param("id")Integer addressId)throws Exception;
}
