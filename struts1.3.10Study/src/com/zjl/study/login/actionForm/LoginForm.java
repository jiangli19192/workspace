package com.zjl.study.login.actionForm;

import org.apache.struts.action.ActionForm;

public class LoginForm extends ActionForm {
	private static final long serialVersionUID = -2837971793304870375L;

	private String username;

	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
