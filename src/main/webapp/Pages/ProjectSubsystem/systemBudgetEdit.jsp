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
<script src="<%=scriptCatalog%>/jquery-1.9.1.js"></script>
<script src="<%=scriptCatalog%>/jquery-ui-1.10.3.custom.min.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker({
			changeYear : true,
			changeMonth : true,
			showOtherMonths : true,
			selectOtherMonths : true,
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<center>
		<br> <br>
		<h3>项目子系统预算修改</h3>
		<div>
			<input class="btn btn-inverse" type="button" value="返回"
				onclick="history.go(-1)" style="margin-left: 300px;">
		</div>
		<s:form action="editSystemBudget">
			<s:hidden name="id" label="子系统ID"></s:hidden>
			<s:hidden name="budgetId" label="预算ID"></s:hidden>
			<s:textfield name="systemName" label="子系统名称" readonly="true"></s:textfield>
			<%-- <s:textfield name="systemType" label="类别"></s:textfield>
			<s:textfield name="systemPlatform" label="平台"></s:textfield>
			<s:radio list="%{#{'1':'自主','0':'外包'}}" name="systemDevelopType"
				label="性质" value="1" cssStyle="float:left;width:50px;"></s:radio> --%>
			<s:textfield name="systemTotalInvest" label="子系统总投资额"
				value="%{formatDouble(systemTotalInvest)}"></s:textfield>
			<s:textfield name="systemCarryOver" label="子系统结转"
				value="%{formatDouble(systemCarryOver)}"></s:textfield>
			<s:textfield name="systemNewlyInvest" label="子系统新增投资额"
				value="%{formatDouble(systemNewlyInvest)}"></s:textfield>
			<%-- <s:textfield name="teamMember" label="项目组人员"></s:textfield>
			<s:textfield name="handoverTime" label="运维交接时间" id="datepicker">
			<s:param name="value"><s:date name="handoverTime" format="yyyy-MM-dd"/></s:param> 
			</s:textfield>
			<s:textfield name="acceptors" label="验收评委"></s:textfield>
			<s:textfield name="userDepartment" label="使用部门"></s:textfield> --%>
			<s:textfield name="description" label="功能描述" readonly="true"></s:textfield>
			<s:textarea name="remark" label="备注" readonly="true"></s:textarea>
			<%-- 	<s:radio list="%{#{'1':'自主','0':'外包'}}" name="systemDevelopType"
				label="子系统开发类型  " value="1"></s:radio>
			<s:textfield name="applyDepartment" label="验收部门" value=""></s:textfield> --%>
			<s:submit value="提交" />
		</s:form>
	</center>
</body>
</html>