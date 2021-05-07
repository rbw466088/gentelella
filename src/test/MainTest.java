package test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.easybuy.dao.news.NewsMapper;
import cn.easybuy.dao.order.OrderDetailMapper;
import cn.easybuy.entity.News;
import cn.easybuy.entity.OrderDetail;
import cn.easybuy.param.NewsParams;
import cn.easybuy.utils.MyBatisUtil;

public class MainTest {

	/**
	 * 根据id查询新闻
	 */
	@Test
	public void test01() {
		SqlSession sqlSession = null;
		News info = new News();
		try {
			sqlSession = MyBatisUtil.createSqlSession();
			info = sqlSession.getMapper(NewsMapper.class).getNewsById(531);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}

		System.out.println("实体对象：" + info);
	}

	/**
	 * 查询新闻列表
	 */
	@Test
	public void test02() {
		SqlSession sqlSession = null;
		List<News> info = new ArrayList<News>();
		try {
			sqlSession = MyBatisUtil.createSqlSession();

			// 分页对象
			NewsParams page = new NewsParams();

			// 分页为真
			page.setPage(true);
			// 忽略条数
			page.setStartIndex(4);
			// 显示条数
			page.setPageSize(3);
			// 排序条件
			page.setSort("id");

			info = sqlSession.getMapper(NewsMapper.class).queryNewsList(page);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}

		System.out.println("实体对象：" + info.size() + info);
	}

	/**
	 * 查询新闻的数目(可以按新闻标题模糊查询)
	 */
	@Test
	public void test03() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.createSqlSession();

			NewsParams page = new NewsParams();

			page.setPage(false);
			page.setStartIndex(4);
			page.setPageSize(3);
			page.setSort("id");

			page.setTitle("积分");

			int count = sqlSession.getMapper(NewsMapper.class).queryNewsCount(page);

			System.out.println("新闻的条数：" + count);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}

	}
	
	/**
	 * 增加订单明细（返回类型：int，参数：OrderDetail对象）。
	 *  insert into easybuy_order_detail (orderId,productId,quantity,cost) 
	 *				values (#{orderId},#{product.id},#{quantity},#{cost})
	 *				(明细表主键-自增)，订单主键，	商品主键，			数量，		消费	
	 *
	 *	public int add(OrderDetail orderDetail) throws Exception;
	 *
	 *	
	 */
	@Test
	public void test04() {
		//不测试了。
	}
	
	
	/**
	 * 根据订单id查询订单明细列表（返回类型：List<OrderDetail>，参数：订单id）。
	 */
	@Test
	public void test05() {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.createSqlSession();

			List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();

			orderDetailList = sqlSession.getMapper(OrderDetailMapper.class).getOrderDetailList(2);

			System.out.println("订单明细表信息：" + orderDetailList.size()+orderDetailList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MyBatisUtil.closeSqlSession(sqlSession);
		}

	}
	
	
}
