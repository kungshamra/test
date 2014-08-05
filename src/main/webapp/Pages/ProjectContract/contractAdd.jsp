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
		$("#contractTime").datepicker({
			changeYear : true,
			changeMonth : true,
			showOtherMonths : true,
			selectOtherMonths : true,
		});
	});
	function validate(f){
		if(f.contractName.value==null||f.contractName.value==""||f.contractName.value.replace(/^\s+|\s+$/g,"").length==0){
			alert("合同名称不能为空！") ;
			return false ;
		}
		if(f.contractAmount.value==null||f.contractAmount.value==""||f.contractAmount.value.replace(/^\s+|\s+$/g,"").length==0){
			alert("合同金额不能为空！") ;
			return false ;
		}
		if(f.contractTime.value==null||f.contractTime.value==""){
			alert("合同签订时间不能为空！") ;
			return false ;
		}
		return true ;
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<center>
		<br>
		<br>
		<h3><s:property value="projectName"/>项目合同信息添加</h3>
		<br>
		<s:form name="myform" action="addContract" onSubmit="return validate(this)">
			<s:textfield name="contractName" label="合同名称   " value=""></s:textfield>
			<s:hidden name="projectId" label="项目ID   "></s:hidden>
			<s:radio list="#{'1':'软件','0':'硬件'}" name="contractType"
				label="合同类型   " value="1" cssStyle="float:left;width:35px;"/>
			<s:textfield name="contractAmount" label="合同金额   " value=""></s:textfield>
			<s:textfield name="contractTime" label="签订时间   " value=""
				id="contractTime"></s:textfield>
			<s:textarea name="remarks" label="合同备注   " value=""></s:textarea>
			<s:submit cssClass="btn btn-small btn-primary" value="提交" />
		</s:form>
		<input class="btn btn-inverse" type="button" onclick="history.go(-1);" value="返回">
	</center>
</body>
</html>