package com.zjl.study.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zjl.study.login.actionForm.LoginForm;



public class LoginAction extends Action
{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
	        HttpServletRequest request, HttpServletResponse response)
	        throws Exception 
	{
		LoginForm loginForm = (LoginForm) form;
		request.setAttribute("user", loginForm);
		return "zjl".equals(loginForm.getUsername()) ? mapping.findForward("success") : mapping
				.findForward("error") ;
	}
}
