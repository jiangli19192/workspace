package com.zjl.study.hello;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class HelloForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 与hello.jsp页面的属性userName对应。
	 * */
	private String userName=null;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 将hello.jsp页面表单中的数据重置为默认值。
	 * */
	public void reset(ActionMapping mapping,HttpServletRequest request){
		this.userName = null;
	}
	/**
	 * 验证这个request中的属性。如果发生错误，返回ActionErrors对象；否则，返回empty对象。
	 * */
	public ActionErrors validate(ActionMapping mapping,HttpServletRequest request){
		ActionErrors errors = new ActionErrors();
		if((userName==null)|(userName.length()<1)){
			errors.add("username", new ActionMessage("hello.no.username.error"));
		}
		else{//do nothing
		}
		return errors;
	}
}
