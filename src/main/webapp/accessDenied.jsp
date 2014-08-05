<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<% String scriptCatalog="/Scal.PIMS/Scripts"; %>
<% String styleCatalog="/Scal.PIMS/Style"; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<%=styleCatalog %>/index.css" type="text/css" rel="stylesheet">
<link href="<%=styleCatalog %>/jquery-ui-1.10.3.custom.css" type="text/css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="10602" /></title>
</head>
<body>
<% 
	response.setHeader("refresh", "3;URL=testLogin.jsp") ;
%>
<center>
	<h1>访问被拒绝，您没有相应的权限！！！</h1>
	3秒后自动跳转到登录界面...若没有跳转请点<a href="testLogin.jsp">这里</a>！
</center>
	
</body>
</html>