package com.zjl.study.springcxf.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.zjl.study.springcxf.webservice.model.User;

@WebService(targetNamespace = "com:zjl:study:springcxf:webservice")
public interface HelloWorldService {
	
	@WebMethod(operationName = "sayHi")
	String sayHi(@WebParam(name="text")String text);
	
	@WebMethod(operationName = "sayHiToUser")
    String sayHiToUser(User user);
	
	@WebMethod(operationName = "sayHiToUserList")
    String[] sayHiToUserList(List<User> userList);
}
