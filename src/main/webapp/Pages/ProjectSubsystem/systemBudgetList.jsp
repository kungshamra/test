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
<script>
	$(function() {
		var curpage = "";
		curpage = $("#curpage").val();
		var pageCount = "";
		pageCount = $("#pageCount").val();
		$("#page").myPagination({
			currPage : curpage,
			pageCount : pageCount,
			pageSize : 6
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目子系统列表管理</title>
</head>
<body>
	<h2 style="text-align: center">
		<s:property value="projectName" />
		项目子系统
	</h2>
	<br>
	<input class="btn btn-inverse" type="button" value="返回"
		onclick="window.location='multiEntityQuery'">
	<%-- <input class="btn btn-small btn-primary" type="button" value="新增"
		onclick="window.location='beforeAddProjectSystem?projectId=<s:property value="#request.projectId"/>'">
	<input class="btn btn-small btn-danger" type="button" value="删除"
		onclick="window.location=''"> --%>

	<table class="table table-striped">
		<tr>
			<th>全选</th>
			<!-- <th>序号</th> -->
			<th>子系统名称</th>
			<!-- <th>子系统预算</th> -->
			<th>类别</th>
			<th>平台</th>
			<th>性质</th>
			<th>子系统总投资额</th>
			<th>子系统结转</th>
			<th>子系统新增投资额</th>
			<th>操作</th>
		</tr>
		<s:iterator value="list" status="list">
			<tr class="odd">
				<td><input type="checkbox" name="item"
					value="<s:property value="id"/>"></td>
				<%-- <td><s:property value="#list.count" /></td> --%>
				<td><s:property value="systemName" /></td>
				<%-- <td><s:property value="systemBudget" /></td> --%>
				<td><s:if test="systemType==1">
						<s:property value="'数据中心'" />
					</s:if> <s:elseif test="systemType==2">
						<s:property value="'基础设施'" />
					</s:elseif> <s:elseif test="systemType==3">
						<s:property value="'五大平台'" />
					</s:elseif> <s:else>
						<s:property value="systemType" />
					</s:else></td>
				<td><s:if test="systemPlatform==1">
						<s:property value="'营销平台'" />
					</s:if> <s:elseif test="systemPlatform==2">
						<s:property value="'运行平台'" />
					</s:elseif> <s:elseif test="systemPlatform==3">
						<s:property value="'M&E平台'" />
					</s:elseif> <s:elseif test="systemPlatform==4">
						<s:property value="'服务平台'" />
					</s:elseif> <s:elseif test="systemPlatform==5">
						<s:property value="'综合平台'" />
					</s:elseif> <s:else>
						<s:property value="systemPlatform" />
					</s:else></td>
				<td><s:if test="systemDevelopType==1">外包</s:if> <s:else>自主</s:else></td>
				<td><s:property value="%{formatDouble(systemTotalInvest)}" /></td>
				<td><s:property value="%{formatDouble(systemCarryOver)}" /></td>
				<td><s:property value="%{formatDouble(systemNewlyInvest)}" /></td>
				<td><a class="btn btn-info"
					href="beforeEditSystemBudget?id=<s:property value="id"/>&budgetId=<s:property value="#request.budgetId"/>">编辑</a></td>
			</tr>
		</s:iterator>
	</table>
	<input type="hidden" id="curpage" name="curpage"
		value="<s:property value="#request.page"/>" />
	<input type="hidden" id="pageCount" name="pageCount"
		value="<s:property value="totalPage"/>" />
	<div id="page" class="menu"></div>
</body>
</html>