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
<link href="<%=styleCatalog%>/jquery-ui-1.10.3.custom.min.css"
	type="text/css" rel="stylesheet">
<link href="<%=styleCatalog%>/page.css" type="text/css" rel="stylesheet">
<link href="<%=styleCatalog%>/simple-canleder.css" type="text/css"
	rel="stylesheet">
<script src="<%=scriptCatalog%>/jquery-1.9.1.js"></script>
<script src="<%=scriptCatalog%>/jquery-ui-1.10.3.custom.min.js"></script>
<script src="<%=scriptCatalog%>/simple-canleder.js"></script>
<script src="<%=scriptCatalog%>/jquery.myPagination.js"></script>
<script>
	$(function() {
		$("#from").simpleCanleder();
		$("#to").simpleCanleder();
	});
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
<title></title>
</head>
<body>
	<h3>项目信息管理列表</h3>
	<input class="btn btn-small btn-primary" type="button" value="新增"
		onclick="window.location='Pages/ProjectInfo/infoAdd.jsp'">&nbsp;&nbsp;
	<!-- 批量删除功能暂时不做 -->
	<!-- 	<input class="btn btn-small btn-danger" type="button" value="删除"
		onclick="return confirm('你确定要删除该记录吗？');"> -->
	<br>
	<br>
	<center>
		<h2>搜索条件</h2>
		<div>
			<s:form action="searchProInfo?page=1" cssStyle="float:left"
				theme="simple">
				<input type="hidden" name="flag" value="1" />
				项目名称：<s:textfield cssStyle="width:8%" name="projectName"
					label="项目名称"></s:textfield>
				 年份：<s:textfield cssStyle="width:8%" name="startTime" label="年份"
					id="from">
					<s:param name="year1">
						<s:date name="startTime" format="yyyy-MM-dd" />
					</s:param>
				</s:textfield>
				至<s:textfield cssStyle="width:8%" name="endTime" id="to">
					<s:param name="year2">
						<s:date name="endTime" format="yyyy-MM-dd" />
					</s:param>
				</s:textfield>
				类别：<s:select cssStyle="width:8%" name="projectType"
					list="#{0:'---',1:'数据中心',2:'基础设施',3:'五大平台'}" label="类别" value=""></s:select>
				开发类别：<s:select cssStyle="width:8%" name="developType"
					list="#{0:'---',1:'自主',2:'外包'}" label="%{getText('10105')}" /> 
				
				平台：<s:select cssStyle="width:8%" name="projectPlatform"
					list="#{0:'---',1:'营销平台',2:'运行平台',3:'M&E平台',4:'服务平台',5:'综合平台'}"
					label="平台"></s:select>
					项目状态：<s:select cssStyle="width:8%" name="projectStatus"
					list="#{0:'---',1:'高',2:'中',3:'低'}" label="项目状态"></s:select>
				<%-- 项目进度：<s:select cssStyle="width:8%" name="progressType"
					list="#{0:'---',1:'高',2:'中',3:'低'}" label="项目进度"></s:select> --%>
					优先级：<s:select cssStyle="width:8%" name="priority"
					list="#{0:'---',1:'高',2:'中',3:'低'}" label="优先级"></s:select>
					是否计划外：<s:select cssStyle="width:8%" name="scheduledPlan"
					list="#{0:'---',1:'否',2:'是'}" label="是否计划外"></s:select> 

				预算金额：
					<s:textfield cssStyle="width:8%" name="totalInvestment2a" value=""
					label="预算金额"></s:textfield>				
				---
					<s:textfield cssStyle="width:8%" name="totalInvestment2b" value=""
					label="预算金额"></s:textfield>


				<s:submit value="查询" />
				<s:reset value="重置" />
			</s:form>
		</div>
	</center>
	<table class="table table-striped">
		<tr>
			<th>项目id</th>
			<th>全选</th>
			<th>项目名称</th>
			<th>项目子系统</th>
			<th>类别</th>
			<th>平台</th>
			<th>项目状态</th>
			<th>项目进度</th>
			<th>在建年份</th>
			<th>预算申报时间</th>
			<th>预算批准时间</th>
			<th>优先级</th>
			<th>是否计划外项目</th>
			<th>预算金额</th>
			<!-- 		<th>项目预算</th> -->
			<th>合同信息</th>
			<th>开发类别</th>
			<th>申报部门</th>
			<th>分管领导</th>
			<th>责任科室</th>
			<th>备注</th>
			<th colspan="2" align="center">操作</th>
		</tr>
		<s:iterator value="showlist">
			<tr>
				<td><s:property value="proInfo.id" /></td>
				<td><input type="checkbox"></td>
				<td><s:property value="proInfo.projectName" /></td>
				<td name="projectSystem"><a
					href="findAllProjectSystem?projectId=<s:property value="proInfo.id"/>&projectType=<s:property value="proInfo.projectType"/>&projectPlatform=<s:property value="proInfo.projectPlatform"/>&developType=<s:property value="proInfo.developType"/>&projectName=<s:property value="proInfo.projectName" />&page=1&flag=1">查看</a></td>
				<%-- <td><s:property value="proInfo.projectType" /></td> --%>
				<s:set name="projectType" value="proInfo.projectType" />
				<td><s:if test="#projectType==1">
						<s:property value="'数据中心'" />
					</s:if> <s:elseif test="#projectType==2">
						<s:property value="'基础设施'" />
					</s:elseif> <s:elseif test="#projectType==3">
						<s:property value="'五大平台'" />
					</s:elseif> <s:else>
						<s:property value="" />
					</s:else></td>
				<%-- <td><s:property value="proInfo.projectPlatform" /></td> --%>
				<s:set name="projectPlatform" value="proInfo.projectPlatform" />
				<td><s:if test="#projectPlatform==1">
						<s:property value="'营销平台'" />
					</s:if> <s:elseif test="#projectType==2">
						<s:property value="'运行平台'" />
					</s:elseif> <s:elseif test="#projectType==3">
						<s:property value="'M&E平台'" />
					</s:elseif> <s:elseif test="#projectType==4">
						<s:property value="'服务平台'" />
					</s:elseif> <s:elseif test="#projectType==5">
						<s:property value="'综合平台'" />
					</s:elseif> <s:else>
						<s:property value="" />
					</s:else></td>
				<%-- <td><s:property value="proInfo.projectStatus" /></td> --%>
				<s:set name="projectStatus" value="proInfo.projectStatus" />
				<td><s:if test="#projectStatus==1">
						<s:property value="'启动'" />
					</s:if> <s:elseif test="#projectStatus==2">
						<s:property value="'未启动'" />
					</s:elseif> <s:elseif test="#projectStatus==3">
						<s:property value="'暂停'" />
					</s:elseif> <s:elseif test="#projectStatus==4">
						<s:property value="'取消'" />
					</s:elseif> <s:elseif test="#projectStatus==5">
						<s:property value="'待批准'" />
					</s:elseif> <s:elseif test="#projectStatus==6">
						<s:property value="'被否决'" />
					</s:elseif> <s:else>
						<s:property value="" />
					</s:else></td>
				<%-- <s:set name="dynamicProgress" value="proProgress.progressType" /> --%>
				<%-- <td><s:property value="" /><a
					href="findAllProgressInfo?projectId=<s:property value="proInfo.id"/>"><s:property value="proProgress.progressType" /></a></td> --%>
				<td><s:property value="" /><a
					href="findAllProgressInfo?projectId=<s:property value="proInfo.id"/>&projectName=<s:property value="proInfo.projectName"/>&page=1&flag=1">查看</a></td>
				<td><s:set name="constructYear" value="proProgress.endTime" />
					<s:set name="nowTime" value="new java.util.Date()" /> <s:if
						test="#constructYear==null">
						<s:date name="nowTime" format="yyyy-MM" />
					</s:if> <s:else>
						<s:date name="proProgress.endTime" format="yyyy-MM" />
					</s:else></td>
				<%-- 				<td><s:property value="proInfo.year" /></td> --%>
				<td><s:date name="proInfo.budgetApplyTime" format="yyyy-MM" /></td>
				<%-- 				<td><s:property value="proInfo.budgetApplyTime" /></td> --%>
				<td><s:date name="proInfo.budgetApprovalTime" format="yyyy-MM" /></td>
				<%-- 				<td><s:property value="proInfo.budgetApprovalTime" /></td> --%>
				<%-- <td><s:property value="proInfo.priority" /></td> --%>
				<s:set name="priority" value="proInfo.priority" />
				<td><s:if test="#priority==1">
						<s:property value="'高'" />
					</s:if> <s:elseif test="#priority==2">
						<s:property value="'中'" />
					</s:elseif> <s:elseif test="#priority==3">
						<s:property value="'低'" />
					</s:elseif> <s:else>
						<s:property value="" />
					</s:else></td>
				<%-- <td><s:property value="proInfo.scheduledPlan" /></td> --%>
				<s:set name="scheduledPlan" value="proInfo.scheduledPlan" />
				<td><s:if test="#scheduledPlan==1">
						<s:property value="'否'" />
					</s:if> <s:elseif test="#scheduledPlan==2">
						<s:property value="'是'" />
					</s:elseif> <s:else>
						<s:property value="" />
					</s:else></td>
				<td><s:property value="proBudget.totalInvestment2" /></td>
				<!-- 根据和张华讨论，由于其他地方可以查看子系统和预算的信息了，这里不需要查看功能 -->
				<!-- <td name="projectBudget"><a href="multiEntityQuery">查看</a></td> -->

				<td name="projectContract"><a
					href="findContract?projectId=<s:property value="proInfo.id"/>&page=1&flag=1&projectName=<s:property value="proInfo.projectName"/>">查看</a></td>
				<%-- <td><s:property value="proInfo.developType" /></td> --%>
				<s:set name="developType" value="proInfo.developType" />
				<td><s:if test="#developType==1">
						<s:property value="'外包'" />
					</s:if> <s:elseif test="#developType==2">
						<s:property value="'自主'" />
					</s:elseif> <s:else>
						<s:property value="" />
					</s:else></td>
				<td><s:property value="proInfo.applyDepartment" /></td>
				<td><s:property value="proInfo.responsibilityDep" /></td>
				<td><s:property value="proInfo.responsibilityLeader" /></td>
				<td><s:property value="proInfo.remark" /></td>
				<td><a
					href="beforeEditProjectInfo?id=<s:property value="proInfo.id"/>">编辑</a></td>
				<td><a
					href="deleteProjectInfo?id=<s:property value="proInfo.id"/>"
					onclick="return confirm('你确定要删除该记录吗？');">删除</a></td>
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