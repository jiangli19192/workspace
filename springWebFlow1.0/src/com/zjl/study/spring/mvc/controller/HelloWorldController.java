package com.zjl.study.spring.mvc.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloWorldController implements Controller {
	private String hellowrold;
	private String viewpage;

	public String getHellowrold() {
		return hellowrold;
	}

	public void setHellowrold(String hellowrold) {
		this.hellowrold = hellowrold;
	}

	public String getViewpage() {
		return viewpage;
	}

	public void setViewpage(String viewpage) {
		this.viewpage = viewpage;
	}

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<String, String> model = new HashMap<String, String>();
		model.put("hellowrold", this.getHellowrold());
		return new ModelAndView(this.getViewpage(), model);
	}
}