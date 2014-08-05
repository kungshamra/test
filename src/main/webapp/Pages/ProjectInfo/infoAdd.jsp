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
<%-- <link href="<%=styleCatalog%>/page.css" type="text/css" rel="stylesheet"> --%>
<link href="<%=styleCatalog%>/simple-canleder.css" type="text/css"
	rel="stylesheet">
<script src="<%=scriptCatalog%>/jquery-1.9.1.js"></script>
<script src="<%=scriptCatalog%>/jquery-ui-1.10.3.custom.min.js"></script>
<script src="<%=scriptCatalog%>/simple-canleder.js"></script>
<%-- <script src="<%=scriptCatalog%>/jquery-cutPage.js"></script> --%>
<script>
$(function() {
	$("#applyTime").simpleCanleder();
	$("#approveTime").simpleCanleder();
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<caption>
		<h3 align="center">项目信息新增</h3>
	</caption>
	<center>
		<s:form action="addProjectInfo">
			<s:textfield name="projectName" label="项目名称：" />
			<%-- <s:textfield name="projectType" label="类别：" /> --%>
			<s:select name="projectType"
				list="#{0:'---',1:'数据中心',2:'基础设施',3:'五大平台'}" label="类别" value=""></s:select>
			<%-- <s:textfield name="projectPlatform" label="平台：" /> --%>
			<s:select name="projectPlatform"
				list="#{0:'---',1:'营销平台',2:'运行平台',3:'ME平台',4:'综合平台',5:'综合平台'}" label="平台"></s:select>
			<%-- <s:textfield name="projectStatus" label="项目状态：" /> --%>
			<s:select name="projectStatus"
				list="#{ 0:'---',1:'启动',2:'未启动',3:'暂停',4:'取消',5:'待批准',6:'被否决'}"
				label="项目状态："></s:select>
			<s:textfield name="budgetApplyTime" label="预算申报时间：" id="applyTime" />
			<s:textfield name="budgetApprovalTime" label="预算批准时间：" id="approveTime"/>
			<%-- <s:textfield name="priority" label="优先级：" /> --%>
			<s:select name="priority" list="#{1:'高',2:'中',3:'低'}" label="优先级"></s:select>
			<%-- <s:textfield name="scheduledPlan" label="是否计划外项目：" /> --%>
			<s:radio cssStyle="float:left;width:50px" name="scheduledPlan"
				list="#{1:'否',2:'是'}" label="是否计划外项目" value="1"></s:radio>
			<%-- <s:textfield name="developType" label="开发类别：" /> --%>
			<s:radio name="developType" cssStyle="float:left;width:50px"
				list="#{1:'外包',2:'自主'}" label="开发类别" value="1"></s:radio>
			<s:textfield name="applyDepartment" label="申报部门：" />
			<s:textfield name="responsibilityLeader" label="分管领导：" />
			<s:textfield name="responsibilityDep" label="责任科室：" />
			<s:textfield name="remark" label="备注：" />
			<s:submit value="提交" cssStyle="float:left;"/><s:submit type="button" value="返回" onclick="history.go(-1);"/>			
		</s:form>
		<input type="button" onclick="history.go(-1);" value="input返回">
	</center>
</body>
</html>