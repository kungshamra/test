<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户添加</title>
<script>
	function validate(f){
		if(f.loginName.value==null||f.loginName.value==""||f.loginName.value.replace(/^\s+|\s+$/g,"").length==0){
			alert("登录名不能为空！") ;
			return false ;
		}else if(!f.loginName.value.match("[0-9]{6}")){
			alert("请输入正确的登录名！") ;
			return false ;
		}
		if(f.trueName.value==null||f.trueName.value==""||f.trueName.value.replace(/^\s+|\s+$/g,"").length==0){
			alert("真实姓名不能为空！") ;
			return false ;
		}
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
</head>
<body>
	<center>
		<br>
		<h3>
			<s:property value="message" />
		</h3>
		<br>
		<h3>用户添加</h3>
		<br>
		<s:form action="addUser" onSubmit="return validate(this)">
			<s:textfield name="loginName" label="登录名   " value="工号" required="true"></s:textfield>
			<s:textfield name="trueName" label="真实姓名   " value="输入工号后自动关联"></s:textfield>
			<s:textfield name="department" label="部门   " value="信息服务部"></s:textfield>
			<s:textfield name="officeNumber" label="办公电话   " value=""></s:textfield>
			<s:textfield name="mobile" label="手机   " value=""></s:textfield>
			<s:textfield name="email" label="电子邮件   " value=""></s:textfield>
			<s:select name="dataMark"
				list="#{0:'   ---   停用   ---',1:'   ---   启用   ---'}" label="状态"
				value="1">
			</s:select>
			<s:textarea name="remarks" label="备注   " value=""></s:textarea>
			<s:submit cssClass="btn btn-small btn-primary" value="提交" />
		</s:form>
		<input class="btn btn-inverse" type="button"
			onclick="window.location='findUser?page=1'" value="返回"> 
	</center>
</body>
</html>