package dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import po.Stu_Info;
import po.UserInfo;


public interface IUserInfoDao {
	/**
	 * 获取总数
	 * @return int
	 */
	public int selectCount();
	
	/**
	 * 获取所有数据
	 * @return List<UserInfo>
	 */
	public List<UserInfo> showAll() ;
	
	/**
	 * 按ID查询数据
	 * @param id 
	 * @return UserInfo
	 */
	public UserInfo findById(int id);
	
	/**
	 * 添加数据
	 * @param info
	 * @return 受影响的行数
	 */
	public int save(UserInfo info);
	
	/**
	 * 修改数据
	 * @param info
	 * @return 受影响的行数
	 */
	public int userUpdate(UserInfo info);
	
	/**
	 * 删除数据
	 * @param info
	 * @return 受影响的行数
	 */
	public int userDelete(UserInfo info);
	
	/**
	 * 查询时间间距中的数据
	 * @param beginTime 开始时间
	 * @param endTime	结束时间
	 * @return
	 */
	public List<UserInfo> findByTime(@Param("beginTime")String beginTime,@Param("endTime")String endTime);
	
	/**
	 * association获取所有数据
	 * @return List<Stu_Info>
	 */
	public List<Stu_Info> stu_ShowAll();
	
	/**
	 * collection按条件获取数据
	 * @return List<Stu_Info>
	 */
	public List<Stu_Info> list_ShowAll(Stu_Info info);
	
	/**
	 * 数组入参查询
	 * @param name 数组
	 * @return
	 */
	public List<Stu_Info> arrayList(String[] name);
	
	
	
	
	
	
	
	
	
}
