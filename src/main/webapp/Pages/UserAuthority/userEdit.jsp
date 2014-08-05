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
<script>
	function validate(f){
		if(f.department.value==null||f.department.value==""||f.department.value.replace(/^\s+|\s+$/g,"").length==0){
			alert("部门不能为空！") ;
			return false ;
		}
		if(f.email.value!=null&&f.email.value!=""&&!/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(f.email.value)){
			alert("EMAIL输入格式不正确！") ;
			return false ;
		}
		return true ;
	}
</script>
<title></title>
</head>
<body>
<center>
<br><br>
<h3>用户信息修改</h3><br>

<s:form action="updateUser" onSubmit="return validate(this)">
	<s:hidden name="memberId" label="用户ID"></s:hidden>
	<s:textfield name="loginName" label="登录名   " readonly="true"></s:textfield>
	<s:hidden name="password" label="密码"></s:hidden>
	<a href="resetPassword?memberId=<s:property value="memberId"/>">重置密码</a>
	<s:textfield name="trueName" label="真实姓名   " readonly="true"></s:textfield>
	<s:textfield name="department" label="部门   "></s:textfield>
	<s:textfield name="officeNumber" label="办公电话   "></s:textfield>
	<s:textfield name="mobile" label="手机   "></s:textfield>
	<s:textfield name="email" label="电子邮件   "></s:textfield>
	<s:select name="dataMark" list="#{0:'   ---   停用   ---',1:'   ---   启用   ---'}" label="状态" value="1">
	</s:select>
	<s:textarea name="remarks" label="备注   "></s:textarea>
	<s:submit cssClass="btn btn-small btn-primary" value="提交"/>
</s:form>
<input class="btn btn-inverse" type="button" onclick="history.go(-1);" value="返回">
</center>
</body>
</html>