<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<% String scriptCatalog="/Scal.PIMS/Scripts"; %>
<% String styleCatalog="/Scal.PIMS/Style"; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<s:text name="搜索条件"/>
<s:form action="searchProjectBudget">
	<s:textfield label="%{getText('10604')}" /><br>
	<s:textfield label="%{getText('10606')}" /><br>
	<s:textfield label="%{getText('10607')}" /><br>
	 <s:select list="#{1:getText('10717'),2:getText('10718'),3:getText('10719')}" label="%{getText('10105')}"/><br>
	<s:textfield label="%{getText('10704')}" name="min"/><s:text name="——"/><s:textfield name="max"/><br>
	<s:textfield label="%{getText('10617')}" /><s:text name="——"/><s:textfield /><br>
	<s:textfield label="%{getText('10618')}" /><s:text name="——"/><s:textfield /><br>
	<s:date name="10703" format="yyyy-MM-dd"/><br>
	<s:submit key="10206" />
</s:form>

</body>
</html>