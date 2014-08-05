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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<center>
		<h2>XXX项目预算信息</h2>
		<s:form action="addProjectBudget">
		<!-- 页面一定要加上下面这个项目预算id点提交的时候才能在action中取得到这个id的值 -->
		<s:textfield name="id" label="项目预算id：" />
			<s:textfield name="projectId" label="项目id：" />
			<s:textfield label="%{getText('10703')}" name="year" value="" />
			<s:select
				list="#{1:getText('10717'),2:getText('10718'),3:getText('10719')}"
				label="%{getText('10105')}" name="type" value=""/>
				<!-- 这里就不用维护各项金额了，这些金额都在子系统里面去维护 -->
			<%-- <s:textfield label="%{getText('10704')}" name="totalInvestment1" value=""/>
			<s:textfield label="%{getText('10706')}" name="carryOver" value=""/>
			<s:textfield label="%{getText('10707')}" name="newlyInvestment" value=""/>
			<s:textfield label="%{getText('10705')}" name="totalInvestment2" value=""/> --%>
			<s:file name="excelPath" acceptor="text/xls*" />
			<s:textarea label="%{getText('10103')}1" name="remark1" value=""/>
			<s:textarea label="%{getText('10103')}2" name="remark2" value=""/>
			<s:submit key="10209" />
		</s:form>

	</center>
</body>
</html>