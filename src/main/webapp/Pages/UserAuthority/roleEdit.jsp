<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<% String scriptCatalog="/Scal.PIMS/Scripts"; %>
<% String styleCatalog="/Scal.PIMS/Style"; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<%=styleCatalog %>/bootstrap-cerulean.css" type="text/css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script>
	function validate(f){
		if(f.roleName.value==null||f.roleName.value==""||f.roleName.value.replace(/^\s+|\s+$/g,"").length==0){
			alert("角色名称不能为空！") ;
			return false ;
		}
		return true ;
	}
</script>
</head>
<body>
<center>
<br><br>
<h3>角色信息修改</h3><br>

<s:form action="updateRole" onSubmit="return validate(this)">
	<s:hidden name="roleId" label="角色ID"></s:hidden>
	<s:textfield name="roleName" label="角色名   "></s:textfield>
	<s:select name="dataMark" list="#{0:'   ---   停用   ---',1:'   ---   启用   ---'}" label="状态" value="1">
	</s:select>
	<s:textarea name="remarks" label="备注   "></s:textarea>
	<s:submit cssClass="btn btn-small btn-primary" value="提交"/>
</s:form>
<input class="btn btn-inverse" type="button" onclick="history.go(-1);" value="返回">
</center>
</body>
</html>