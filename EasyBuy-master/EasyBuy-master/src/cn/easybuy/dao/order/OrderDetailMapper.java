package cn.easybuy.dao.order;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.easybuy.entity.OrderDetail;

/**
 * OrderDetailMapper接口方法：
 *（1）增加订单明细（返回类型：int，参数：OrderDetail对象）。
 *（2）根据订单id查询订单明细列表（返回类型：List<OrderDetail>，参数：订单id）。
 */
public interface OrderDetailMapper {
	
	/**
	 * 增加订单明细（返回类型：int，参数：OrderDetail对象）。
	 */
	public int add(OrderDetail orderDetail) throws Exception;
	
	/**
	 * 根据订单id查询订单明细列表（返回类型：List<OrderDetail>，参数：订单id）。
	 */
	public List<OrderDetail> getOrderDetailList(@Param("orderId")Integer orderId) throws Exception;

}
