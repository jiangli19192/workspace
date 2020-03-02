package com.zbwang.strutsone.actionForm;
import org.apache.struts.action.ActionForm;

public class HelloWorldForm extends ActionForm{
	
	private static final long serialVersionUID = 6341361706006926889L;
	
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}