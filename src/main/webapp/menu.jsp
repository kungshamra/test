<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<% String scriptCatalog="/Scal.PIMS/Scripts"; %>
<% String styleCatalog="/Scal.PIMS/Style"; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<%=styleCatalog %>/jquery-ui-1.10.3.custom.min.css" type="text/css"
	rel="stylesheet">
<script src="<%=scriptCatalog %>/jquery-1.9.1.js"></script>
<script src="<%=scriptCatalog %>/jquery-ui-1.10.3.custom.min.js"></script>
<script>
	$(function() {
		$("#tabs").tabs();
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<div id="tabs">
		<ul>
			<li><a href="#tabs-1"><s:text name="10602" /></a></li>
			<li><a href="#tabs-2"><s:text name="10301" /></a></li>
		</ul>
		<div id="tabs-1">
			<img alt="logo" src="Images/hi.gif">业务管理
		</div>
		<div id="tabs-2">
			<img alt="logo" src="Images/hi.gif">业务管理
		</div>
	</div>
</body>
</html>