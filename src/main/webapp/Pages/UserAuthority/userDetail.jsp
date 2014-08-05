<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<% String scriptCatalog="/Scal.PIMS/Scripts"; %>
<% String styleCatalog="/Scal.PIMS/Style"; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<%=styleCatalog %>/bootstrap-cerulean.css" type="text/css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<body>
<center>
<br><br>
<h2>用户详细信息</h2>
<br>
<!-- <table cellpadding="8px" width="50%" border="1" style="color: #1c5d79; "> -->
<div style="width: 50%">
	<table class="table table-bordered table-striped table-condensed">
	<tr class="odd">
		<td>登录名：</td>
		<td><s:property value="loginName"/></td>
	</tr>
	<tr>
		<td>真实姓名：</td>
		<td><s:property value="trueName"/></td>
	</tr>
	<tr>
		<td>部门：</td>
		<td><s:property value="department"/></td>
	</tr>
	<tr>
		<td>手机：</td>
		<td><s:property value="mobile"/></td>
	</tr>
	<tr>
		<td>办公电话：</td>
		<td><s:property value="officeNumber"/></td>	
	</tr>
	<tr>
		<td>电子邮件：</td>
		<td><s:property value="email"/></td>
	</tr>	
<%-- 	<tr>
		<td>角色：</td>
		<td>
			<s:iterator value="role">
				<table align="center">
					<tr>
						<td>
							<s:property value="roleName"/>
						</td>
					</tr>
				</table>
			</s:iterator>
		</td>
	</tr> --%>
	<tr>
		<td>角色：</td>
		<td><s:iterator value="role"><s:property value="roleName" /></br></s:iterator></td>
	</tr>
<%-- 	<tr>
		<td>授权的功能：</td>
		<td>
			<s:iterator value="authority">
				<table align="center">
					<tr>
						<td>
							<s:property value="authorityName"/>
						</td>
					</tr>
				</table>
			</s:iterator>
		</td>
	</tr> --%>
	<tr>
		<td>状态：</td>
		<td><s:property value="dataMark==1?'启用':'停用'"/></td>
	</tr>
	<tr>
		<td>最后登录时间：</td>
		<td><s:date name="lastLogin" format="yyyy-MM-dd hh-mm-ss" /></td>
		<%-- <td><s:property value="lastLogin"/></td> --%>
	</tr>
	<tr>
		<td>备注：</td>
		<td><s:property value="remarks"/></td>
	</tr>
</table>
</div>
<input class="btn btn-inverse" type="button" onclick="history.go(-1);" value="返回">
</center>
</body>
</html>