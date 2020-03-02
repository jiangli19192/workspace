package com.zjl.study.springcxf.webservice.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.zjl.study.springcxf.webservice.HelloWorldService;
import com.zjl.study.springcxf.webservice.model.User;

@WebService(endpointInterface = "com.zjl.study.springcxf.webservice.HelloWorldService", targetNamespace = "com:zjl:study:springcxf:webservice")
public class HelloWorldServiceImpl implements HelloWorldService {
	Map<Integer, User> users = new LinkedHashMap<Integer, User>();

	@Override
	public String sayHi(String text) {
		return "Hello " + text;
	}

	@Override
	public String sayHiToUser(User user) {
		users.put(users.size() + 1, user);
		return "Hello " + user.getName();
	}

	@Override
	public String[] sayHiToUserList(List<User> userList) {
		String[] result = new String[userList.size()];
		int i = 0;
		for (User u : userList) {
			result[i] = "Hello " + u.getName();
			i++;
		}
		return result;
	}

}
