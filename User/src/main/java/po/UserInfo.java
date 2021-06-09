package po;

import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


public class UserInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3747570805250347583L;
	
	
	private Integer id;
	private String name;
	private Integer age;
	private Date createdate;
	private String createStr;
	
	public String getCreateStr() {
		SimpleDateFormat date = new SimpleDateFormat("YYYY/mm/dd HH:mm:ss");
		if(null!=createdate) {
			return date.format(createdate);
		}
		return "";
	}
	public void setCreateStr(String createStr) {
		this.createStr = createStr;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
}
