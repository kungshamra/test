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

	<div id="container">

		<div id="logo">
			<s:include value="header.jsp" />
		</div>

		<div id="menu">

			<div id="left-menu">
				<%-- 	<s:include value="welcome.jsp" /> --%>
				<div id="user-info">
					<ul>
						<li><s:text name="%{getText('10504')}" /></li>
						<li>[<s:text name="10004" />] | [<a href="login.jsp"><s:text name="10015" /></a>]
						</li>
					</ul>
				</div>
			</div>

			<div id="right-menu">
				<s:include value="menu.jsp" />
			</div>
		</div>

		<div id="pagebody">
			<div id="sidebar">
				<s:include value="sidebar.jsp" />
			</div>
			<div id="content">
				<iframe id="iframe" name="content" scrolling="auto" height="700"></iframe>
				<%-- <s:include value="table.jsp" /> --%>
			</div>

		</div>

		<div id="foot"></div>

	</div>

</body>
</html>