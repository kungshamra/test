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
	/* 	$("#planStartTime").simpleCanleder();
		$("#planEndTime").simpleCanleder();
		$("#startTime").simpleCanleder();
		$("#endTime").simpleCanleder(); */
		$("#planStartTime").datepicker({
			changeYear : true,
			changeMonth : true,
			showOtherMonths : true,
			selectOtherMonths : true,
		});
		$("#planEndTime").datepicker({
			changeYear : true,
			changeMonth : true,
			showOtherMonths : true,
			selectOtherMonths : true,
		});
		$("#startTime").datepicker({
			changeYear : true,
			changeMonth : true,
			showOtherMonths : true,
			selectOtherMonths : true,
		});
		$("#endTime").datepicker({
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
	<h3><s:property value="projectName"/>项目进度信息编辑</h3>

	<table name="projectProgressEdit" border="0">

		<center>
			<s:form action="editProgressInfo">
				<s:textfield name="id" label="项目进度id：" />
				<s:textfield name="projectId" label="项目id：" />
				<%--<s:textfield name="progressType" label="项目进度："/>--%>
				<s:select name="progressType"
					list="#{ 1:'项目启动',2:'调研及需求',3:'项目评审',4:'项目报批',5:'项目招投标',6:'合同签署',7:'项目实施',8:'项目试运行',9:'项目验收'}"
					label="项目进度："></s:select>
				<%-- <s:textfield name="status" label="状态：" /> --%>
				<s:textfield name="planStartTime" label="计划启动时间：" id="planStartTime" >
				<s:param name="value">
					<s:date name="planStartTime" format="yyyy-MM-dd" />
				</s:param>
				</s:textfield>
				<s:textfield name="planEndTime" label="计划完成时间：" id="planEndTime" >
				<s:param name="value">
					<s:date name="planEndTime" format="yyyy-MM-dd" />
				</s:param>
				</s:textfield>
				<s:textfield name="startTime" label="实际启动时间：" id="startTime" >
				<s:param name="value">
					<s:date name="startTime" format="yyyy-MM-dd" />
				</s:param>
				</s:textfield>
				<s:textfield name="endTime" label="实际完成时间：" id="endTime" >
				<s:param name="value">
					<s:date name="endTime" format="yyyy-MM-dd" />
				</s:param>
				</s:textfield>
				<%-- <s:textfield name="isDelay" label="是否延误：" /> --%>
				<%-- <s:radio cssStyle="float:left;width:50px" name="isDelay"
					list="#{1:'否',2:'是'}" label="是否延误："></s:radio> --%>
				<s:textfield name="delayTime" label="延误时间：" />
				<s:textfield name="remark" label="备注：" />
				<s:submit value="提交" cssStyle="float:left;"/><s:submit type="button" value="返回" onclick="history.go(-1);" />
			</s:form>
			<input type="button" value="返回2" onclick="history.go(-1);">
		</center>
	</table>
</body>
</html>