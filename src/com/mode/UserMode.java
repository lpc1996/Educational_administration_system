/**
 * 
 */
package com.mode;

/**
 * @author 12892
 * @version 0.1
 */
public class UserMode {

	/**
	 * 用户信息模板类
	 */
	
	private String id;
	private String name;
	private int limit;
	

	public UserMode() {
		// TODO Auto-generated constructor stub
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		if(limit > 0 && limit <= 9) {
			this.limit = limit;
		}else {
			this.limit=-1;
		}
	}
}
