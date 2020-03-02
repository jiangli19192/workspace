package com.zjl.study.spEL.mode;

/**
 * 订单类
 *
 */
public class Order {
	/**
	 * 订单名称
	 */
	private String orderName;
	/*
	 * 用户姓名
	 */
	private String userName;
	/**
	 * 用户对象
	 */
	private User customer;

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "订单名:" + this.getOrderName() + ", 姓名:" + this.getUserName()
				+ ", 编号:" + this.getCustomer().getId();
	}
}