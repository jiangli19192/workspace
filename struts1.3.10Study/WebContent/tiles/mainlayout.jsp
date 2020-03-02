<%@ page contentType="text/html; charset=UTF-8"%> 
<%@ taglib uri="/WEB-INF/tld/struts-tiles.tld" prefix="tiles"%>

<html> 
  <head> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/> 
    <title>tiles</title> 
  </head> 
  <body> 
    <tiles:insert attribute="header" /> 
    <tiles:insert attribute="body" /> 
    <tiles:insert attribute="footer" /> 
  </body> 
</html>