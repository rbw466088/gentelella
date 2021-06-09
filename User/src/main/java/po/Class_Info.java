package po;

import java.io.Serializable;

public class Class_Info implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8744712146819906851L;
	
	private int id;
	private String name;
	
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
	
}
