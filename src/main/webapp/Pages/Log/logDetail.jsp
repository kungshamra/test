<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<% String scriptCatalog="/Scal.PIMS/Scripts"; %>
<% String styleCatalog="/Scal.PIMS/Style"; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<%=styleCatalog%>/bootstrap-cerulean.css" type="text/css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<center>
		<br> <br>
		<h3>操作日志详细信息查看</h3>
		<br>
		<div style="width: 50%">
			<table class="table table-bordered table-striped table-condensed">
				<s:iterator value="list">
					<tr>
						<td style="width: 20%">登录名：</td>
						<td><s:property value="loginName" /></td>
					</tr>
					<tr>
						<td style="width: 20%">操作人：</td>
						<td><s:property value="trueName" /></td>
					</tr>
					<tr>
						<td style="width: 20%">操作模块：</td>
						<td><s:property value="moduleName" /></td>
					</tr>
					<tr>
						<td style="width: 20%">关键字：</td>
						<td><s:property value="keyWord" /></td>
					</tr>
					<tr>
						<td style="width: 20%">操作类型：</td>
						<td><s:if test="operateType == 1">新增</s:if> <s:elseif test="operateType == 2">删除</s:elseif><s:else>修改</s:else></td>
					</tr>
					<tr>
						<td style="width: 20%">操作信息：</td>
						<td><s:property value="operateInfo" /></td>
					</tr>
					<tr>
						<td style="width: 20%">操作时间：</td>
						<td><s:date name="operateTime" format="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>
					<tr>
						<td style="width: 20%">操作IP地址：</td>
						<td><s:property value="ipAddress" /></td>
					</tr>
					
				</s:iterator>
			</table>
		</div>
		<input class="btn btn-inverse" type="button" value="返回"
			onclick="history.go(-1)">
	</center>
</body>
</html>