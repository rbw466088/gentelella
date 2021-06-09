package po;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Stu_Info implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3357544614262286519L;
	
	private int id;					//学号
	private String name;			//姓名
	private int classId;			//班级ID
	private int age;				//年龄
	private Date brithday;			//出生日期util-Dat类型
	private String brithdayStr = ""; 	//出生日期String类型
	private Class_Info className;		//班级名称
	private List<Class_Info> classList; //班级信息集合
	
	
	public List<Class_Info> getClassList() {
		return classList;
	}
	public void setClassList(List<Class_Info> classList) {
		this.classList = classList;
	}
	public Class_Info getClassName() {
		return className;
	}
	public void setClassName(Class_Info className) {
		this.className = className;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getAge() {
		Date date = new Date();
		if(null!=brithday) {
			Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		    Date currYear = calendar.getTime();
		    int nowDate = Integer.valueOf(dateFormat.format(currYear));
		    int brithdayDate = Integer.parseInt(getBrithdayStr().substring(0,4));
		    age = nowDate-brithdayDate;
		    return age;
		}
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBrithday() {
		return brithday;
	}
	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}
	public String getBrithdayStr() {
		if(null!=brithday) {
			SimpleDateFormat date = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); 
			return date.format(brithday);
		}
		return brithdayStr;
	}
	public void setBrithdayStr(String brithdayStr) {
		this.brithdayStr = brithdayStr;
	}
	
	
}
