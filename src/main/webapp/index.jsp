<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String scriptCatalog = "/Scal.PIMS/Scripts";
%>
<%
    String styleCatalog = "/Scal.PIMS/Style";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<%=styleCatalog%>/index.css" type="text/css"
	rel="stylesheet">
<link href="<%=styleCatalog%>/jquery-ui-1.10.3.custom.min.css"
	type="text/css" rel="stylesheet">
<script src="<%=scriptCatalog%>/jquery-1.9.1.js"></script>
<script>
	$(document).ready(function() {
		$(".switch").click(function() {
			$(".left").toggleClass("hide");
			$(".switch").toggleClass("reduce");
			$(".right").toggleClass("add");
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="10602" /></title>
</head>
<body>

	<div id="container">

		<div id="head">
			<div id="logo">
				<s:include value="header.jsp" />
			</div>
			<div id="user">
				<%-- 	<s:include value="welcome.jsp" /> --%>
				<div id="user-info">
					<ul>
						<li><s:text name="%{getText('10504')}" /></li>
						<li>[<a href="testLoginOut.jsp">注销</a>]
						</li>
					</ul>
				</div>
			</div>
		</div>

		<div class="left">


			<div id="sidebar">
				<s:include value="sidebar.jsp" />
			</div>


		</div>
		<div class="switch">
			<img src="Images/switch_left.gif">
		</div>
		<div class="right">
			<%-- <div id="tag">
				<s:include value="menu.jsp" />
			</div> --%>
			<div id="content">
				<iframe id="iframe" name="content" scrolling="auto" height="680"
					src="findAllProjectInfo?page=1"></iframe>
				<%-- <s:include value="table.jsp" /> --%>
			</div>

		</div>

	</div>

</body>
</html>