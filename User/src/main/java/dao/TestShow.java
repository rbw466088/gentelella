package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import po.Class_Info;
import po.Stu_Info;
import po.UserInfo;

public class TestShow {
	public static final Logger Log = Logger.getLogger(TestShow.class);
	public static void main(String[] args) {
		
		String resource = "myBatis-config.xml";
		InputStream inputStream;
		SqlSession session = null;
		int num = 0;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println(sqlSessionFactory);
			session = sqlSessionFactory.openSession();
			System.out.println(session);
			int count = 0;
			//count = session.selectOne("com.gzgl.selectCount");
			//System.out.println("获取的记录总数是："+count);
			 
			IUserInfoDao userInfoDao = session.getMapper(IUserInfoDao.class);  
			
			count = userInfoDao.selectCount();
			System.out.println("获取的记录总数是："+count);
			
			List<UserInfo> userInfoList = userInfoDao.showAll();
			System.out.println("获取所有数据");
			for (UserInfo userInfo : userInfoList) {
				System.out.println(userInfo.getId()+"---"+userInfo.getName()+"---"+userInfo.getAge()+"---"+userInfo.getCreatedate());
			}
			
			UserInfo user = userInfoDao.findById(1);
			System.out.println("按ID获取对应数据");
			System.out.println(user.getId()+"---"+user.getName()+"---"+user.getAge()+"---"+user.getCreatedate());
			
			System.out.println("添加数据");
			UserInfo info = new UserInfo();
			info.setName("王八");
			info.setAge(25);
			num = userInfoDao.save(info);
			session.commit();
			System.out.println("受影响的行数"+num);
			System.out.println("刚添加的数据的ID(标识列、主键):"+info.getId());
			
			System.out.println("修改数据");
			UserInfo in = new UserInfo();
			in.setAge(18);
			in.setId(1);
			num = userInfoDao.userUpdate(in);
			session.commit();
			System.out.println("受影响的行数"+num);
			
			System.out.println("删除数据");
			UserInfo inf = new UserInfo();
			inf.setId(info.getId());
			num = userInfoDao.userDelete(inf);
			session.commit();
			System.out.println("受影响的行数"+num);
			
			List<UserInfo> findByTime = userInfoDao.findByTime("2017-11-21 00:00:00", "2017-11-21 23:59:59");
			System.out.println("查询时间间距中的数据");
			for (UserInfo userInfo : findByTime) {
				//System.out.println("时间间距中的数据："+userInfo.getId()+"---"+userInfo.getName()+"---"+userInfo.getAge()+"---"+userInfo.getCreatedate());
				System.out.println("时间间距中的数据："+userInfo.getId()+"---"+userInfo.getName()+"---"+userInfo.getAge()+"---"+userInfo.getCreateStr());
			}
			
			/**
			 * 班级学生表
			 */
			List<Stu_Info> stuInfo = userInfoDao.stu_ShowAll();
			System.out.println("实体类对象型用association（实体类中包含）");
			for (Stu_Info stu : stuInfo) {
				System.out.println("学号"+stu.getId()+"  姓名"+stu.getName()+"   年龄"+stu.getAge()+
					"  出生日期"+stu.getBrithdayStr()+"  班级ID"+stu.getClassId()+"  班级名称"+stu.getClassName().getName());
			} 
			
			
			Stu_Info stu_info = new Stu_Info(); 
			stu_info.setName("三");
			List<Stu_Info> stuList = userInfoDao.list_ShowAll(stu_info);
			System.out.println("集合类型用collection（实体类中包含）");
			for (Stu_Info stu : stuList) {
				System.out.print("学号"+stu.getId()+"  姓名"+stu.getName()+"   年龄"+stu.getAge()+
					"  出生日期"+stu.getBrithdayStr()+"  班级ID"+stu.getClassId());
				for (Class_Info list : stu.getClassList()) {
					System.out.println("  班级名称"+list.getName());
				}
			} 
		} catch (IOException e) {
			e.printStackTrace();
			num = 0;
		}finally {
			session.close();
		}
		
	}
}
