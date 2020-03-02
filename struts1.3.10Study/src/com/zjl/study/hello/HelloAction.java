package com.zjl.study.hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class HelloAction extends Action {
	/**
	 * 处理指定的HTTP request，创建对应的返回HTTP response。
	 * 
	 * */
	public ActionForward execute(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)throws Exception{
		String userName = null;
		/*获得request中的 参数*/
		userName = ((HelloForm)form).getUserName();
		/*如果userName是Monster,显示错误信息。--验证业务逻辑*/
		if("Monster".equalsIgnoreCase(userName)){
			/*未通过验证，将错误信息存入request。*/
			ActionErrors errors = new ActionErrors();
			errors.add("username",new ActionMessage("hello.dont.talk.to.monster"));
			saveErrors(request, errors);
			return mapping.findForward("SayHello");
		}
		else{/*通过验证*/
		}
		/*将userName持久化。--业务逻辑处理。*/
		PersonBean pb= new PersonBean();
		pb.setName(userName);
		pb.savePermanence();
		//将人员信息存入request返回给用户。
		request.setAttribute("personbean", pb);
		request.removeAttribute(mapping.getAttribute());
		/*跳转到hello.jsp。*/
		return mapping.findForward("SayHello");
	}
}
