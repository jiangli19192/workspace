<%@ page language="java" contentType="text/html; charset=windows-31j"
    pageEncoding="windows-31j"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><bean:message key="hello.jsp.title"/></title>
<html:base/>
<style>
#imgTree{
width:1024px;
height:200px;
}

</style>
</head>
<body bgcolor="white"><p></p>
<h2><bean:message key="hello.jsp.page.heading"/></h2>
<html:errors/>
<logic:present name="personbean" scope="request">
	<h2>
		<bean:message key="hello.jsp.page.hello"/>
		<bean:write name="personbean" property="name"/>
	</h2>
</logic:present>
<html:form action="/Hello.do" focus="userName">
	<bean:message key="hello.jsp.prompt.person"/>
	<html:text property="userName" size="16" maxlength="16"/><br></br>
	<html:submit property="submit" value="Submit"/>
	<html:reset/>
</html:form><br>
<div id=imgTree>
<html:img page="/hello/img/tree.jpg" alt="Powered by struts"/>
</div>
</body>
</html>