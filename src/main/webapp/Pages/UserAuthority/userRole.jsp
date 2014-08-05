<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<% String scriptCatalog="/Scal.PIMS/Scripts"; %>
<% String styleCatalog="/Scal.PIMS/Style"; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">  
//利用js获取选择的值，在页面中用list接收  
function selectAndSubmit(){  
var list = document.getElementById("right");  
  
 if(list.options.length == 0){  
  alert("请至少选择一项权限！"); 
  return false;  
 }  
else{  
 for (var i = 0; i < list.options.length; i++) {  
 list.options[i].selected = true;  
 }  
 document.forms[0].submit();  
 }  
}  
</script> 
<link href="<%=styleCatalog %>/bootstrap-cerulean.css" type="text/css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<center>
<br><br>
<h3>用户角色分配</h3><br>

<s:form action="addUserRole">
	<s:hidden name="memberId" label="用户ID" contenteditable="false"></s:hidden>
	<s:textfield name="loginName" label="登录名   " readonly="true" cssStyle="width:320px"></s:textfield>
	<s:textfield name="trueName" label="真实姓名   " readonly="true" cssStyle="width:320px"></s:textfield>
	<s:textfield name="officeNumber" label="办公电话   " readonly="true" cssStyle="width:320px"></s:textfield>
	<s:optiontransferselect label="角色名称   " cssStyle="width:140px;height:230px;padding:10px" 
				doubleCssStyle="width:140px;height:230px;padding:10px" labelposition="left" 
				name="leftLabel" list="leftList" leftTitle="未分配角色:"
				doubleName="rightLabel" doubleId="right" allowUpDownOnLeft="false" allowUpDownOnRight="false" allowSelectAll="false"
				doubleList="rightList" rightTitle="已分配角色:"/>
	<s:submit value="提交" cssClass="btn btn-small btn-primary" onClick="selectAndSubmit();"/>
</s:form>
<input class="btn btn-inverse" type="button" onclick="history.go(-1);" value="返回">
</center>
</body>
</html>