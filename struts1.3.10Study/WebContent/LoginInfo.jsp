<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h2>Hello Visitor!</h2>

username:${user.username} <br/>
password:${user.password} <br/>

username:<bean:write name="user" property="username"/> <br/>
password:<bean:write name="user" property="password"/> <br/>

<bean:write name="loginForm" property="username"/>

<a href="login.jsp">back</a>
</body>
</html>
