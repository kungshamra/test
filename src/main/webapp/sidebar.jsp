<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<% String scriptCatalog="/Scal.PIMS/Scripts"; %>
<% String styleCatalog="/Scal.PIMS/Style"; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<%=styleCatalog %>/sidebar.css" type="text/css" rel="stylesheet">
<link href="<%=styleCatalog %>/jquery-ui-1.10.3.custom.min.css" type="text/css"
	rel="stylesheet">
<script src="<%=scriptCatalog %>/jquery-1.9.1.js"></script>
<script src="<%=scriptCatalog %>/jquery-ui-1.10.3.custom.min.js"></script>
<script>
	$(function() {
		$("#accordion").accordion();
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<div id="accordion">

		<h2>
			<s:text name="10602" />
		</h2>
		<div>
			<ul class="sidebar-ul">
				<li class="sidebar-li"><a href="findAllProjectInfo?page=1"
					target="content"><s:text name="10602" /></a></li>
				<li class="sidebar-li"><a href="multiEntityQuery?page=1"
					target="content"><s:text name="10701" /></a></li>
				<li class="sidebar-li"><a
					href="Pages/ProjectSummary/projectSummary.jsp" target="content"><s:text
							name="10651" /></a></li>
				<li class="sidebar-li"><a
					href="projectProgressHistory?page=1" target="content"><s:text
							name="10652" /></a></li>
			</ul>
		</div>

		<h2>
			<s:text name="10301" />
		</h2>
		<div>

			<ul class="sidebar-ul">
				<li class="sidebar-li"><a href="findUser?page=1"
					target="content"><s:text name="10303" /></a></li>
				<li class="sidebar-li"><a href="findRole"
					target="content"> <s:text name="10304" /></a></li>
				<li class="sidebar-li"><a
					href="findAuthority" target="content"> <s:text
							name="10305" /></a></li>
			</ul>

			<ul class="sidebar-ul">
				<li class="sidebar-li"><a href="showLog?page=1"
					target="content"><s:text name="10402" /></a></li>
			</ul>

		</div>
	</div>
</body>
</html>