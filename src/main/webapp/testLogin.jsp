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
	<center>
	<br><br>
	<h2>用户登录</h2><hr width="50%"><br>
	登录测试：输入工号登录(000001为系统管理员，<br>000002为项目管理员，000003为一般用户，<br>000004具有所有权限)<br><br>
		<s:form action="Welcome">
			<s:textfield name="username" label="用户名"></s:textfield>
			<s:submit value="提交" />
		</s:form>
	</center>
</body>
</html>