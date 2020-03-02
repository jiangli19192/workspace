package com.zjl.study.velocity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class VelocityAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		VelocityForm velocityForm = (VelocityForm) form;
		velocityForm.setName("张江立");
		velocityForm.setAge(11);
		List<String> phones = new ArrayList<String>();
		phones.add("13683654614");
		velocityForm.setPhones(phones);
		List<String> telphones = new ArrayList<String>();
		velocityForm.setTelphones(telphones);
		velocityForm.setNullPoint(null);
		velocityForm.setAddresses(null);
		velocityForm.setEmail("");
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("menuType", null);
		map.put("map", "");
		map.put("map2", "map2");
		velocityForm.setMap(map);
		
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("map0", "map0");
		map2.put("map1", "map1");
		map2.put("map2", "map2");
		velocityForm.setMap2(map2);
		
		request.setAttribute("velocityForm", velocityForm);
		
		request.setAttribute("addresses", null);
		request.setAttribute("phones", phones);
		request.setAttribute("telphones", telphones);
		request.setAttribute("map", map);
		request.setAttribute("map2", map2);
		
		return mapping.findForward("velocity");
	}
}
