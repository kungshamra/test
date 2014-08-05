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
<link href="<%=styleCatalog%>/bootstrap-cerulean.css" type="text/css"
	rel="stylesheet">
<link href="<%=styleCatalog%>/page.css" type="text/css" rel="stylesheet">
<script src="<%=scriptCatalog%>/jquery-1.9.1.js"></script>
<script src="<%=scriptCatalog%>/jquery.myPagination.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title></title>
</head>
<body>
<center>
	<br>
	<h3><s:property value="contractName"/>合同信息详情</h3>
	<br>
	<div style="width: 50%">
		<table class="table table-bordered table-striped table-condensed">
		<tr>
			<td>合同ID</td>
			<td><s:property value="id"/></td>
		</tr>
		<tr>
			<td>合同名称</td>
			<td><s:property value="contractName"/></td>
		</tr>
		<tr>
			<td>合同类型</td>
			<td><s:property value="contractType"/></td>
		</tr>
		<tr>
			<td>合同金额</td>
			<td><s:property value="contractAmount"/></td>
		</tr>
		<tr>
			<td>签订时间</td>
			<%-- <td align="center"><s:property value="contractTime"/></td> --%>
			<td><s:date name="contractTime" format="yyyy-MM-dd" /></td>
		</tr>
		<tr>
			<td>合同备注</td>
			<td><s:property value="remarks"/></td>
		</tr>
	</table>
	</div>
	<input class="btn btn-inverse" type="button" onclick="history.go(-1);" value="返回">
</center>
</body>
</html>