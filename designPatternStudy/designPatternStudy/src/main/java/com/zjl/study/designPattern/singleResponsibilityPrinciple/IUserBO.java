package com.zjl.study.designPattern.singleResponsibilityPrinciple;

/**
 * 业务对象接口 Bussiness Object, 简称BO
 * ClassName : IUserBO
 * @author 张江立
 * @date 2019年9月16日 上午9:36:50
 *
 */
public interface IUserBO {
	public void setUserID(String userID);
	public String getUserID();
	
	public void setPassword(String password);
	public String getPassword();
	
	public void setUserName(String userName);
	public void getUserName();
}
