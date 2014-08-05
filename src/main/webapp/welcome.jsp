<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<% String scriptCatalog="/Scal.PIMS/Scripts"; %>
<% String styleCatalog="/Scal.PIMS/Style"; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<%=styleCatalog %>/welcome.css" type="text/css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<div id="user-info">
		<div id="left">
			<img alt="logo" src="Images/hi.gif">
		</div>
		<div id="right">

			<p>
				<s:text name="%{getText('10504')}" />
			</p>

			<s:text name="10004" />|
			<s:text name="10015" />

		</div>
	</div>
</body>
</html>