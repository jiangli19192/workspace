package com.zjl.study.spEL.mode;

/**
 * 用户对象 ClassName : User
 * 
 * @author 张江立
 * @date 2019年4月13日 下午5:42:22
 *
 */
public class User {
	/**
	 * 编号
	 */
	private Integer id;
	/**
	 * 用户名
	 */
	private String name;

	public User(Integer id, String name) {
		this.id = id;
		this.name = name;
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
}
