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
<script type="text/javascript">
function checkAll() {
		if(confirm('你确定要删除该记录吗？')){
			var string = "" ;
	  		for (var i = 0; i < document.getElementsByName("selectFlag").length; i++) {
	   			if(document.getElementsByName("selectFlag")[i].checked){
	   	   			string += document.getElementsByName("selectFlag")[i].value + "A" ;
	   			}
	  		}
	  		window.location.href="deleteAnyRole?s=" + string + "'";
	    }
 	}
</script>
<title></title>
</head>
<body>
	<h3>角色维护</h3>
	<input class="btn btn-small btn-primary" type="button" value="新增"
		onclick="window.location='Pages/UserAuthority/roleAdd.jsp'">&nbsp;&nbsp;
	<input class="btn btn-inverse" type="button" onclick="history.go(-1);"
		value="返回">&nbsp;&nbsp;
	<input class="btn btn-small btn-danger" type="button" value="删除"
		onclick="checkAll()">
	<br>
	<br>
	<table class="table table-striped">
		<tr>
			<th>全选</th>
			<th>序号</th>
			<th>角色名</th>
			<th>功能名</th>
			<th>状态</th>
			<th>备注</th>
			<th>操作</th>
		</tr>
		<s:iterator value="raList" status="ra">
			<tr class="odd">
				<td align="center"><input type="checkbox" name="selectFlag" id="selectFlag"
					value="<s:property value="role.roleId"/>"></td>
				<td align="center"><s:property value="#ra.count" /></td>
				<td align="center"><s:property value="role.roleName" /></td>

				<%-- <td align="center"><s:iterator value="authority">

						<table align="center">
							<tr>
								<td><s:property value="authorityName" /></td>
							</tr>
						</table>

					</s:iterator></td> --%>
				<td><s:iterator value="authority"><s:property value="authorityName" /><br></s:iterator></td>
				<td align="center"><s:property value="role.dataMark==1?'启用':'停用'" />
				</td>
				<td align="center"><s:property value="role.remarks" /></td>
				<td align="center"><a class="btn btn-info"
					href="beforeUpdateRoleAuthority?roleId=<s:property value="role.roleId"/>">功能授权</a>&nbsp;&nbsp;
					<a class="btn btn-info"
					href="beforeUpdateRole?roleId=<s:property value="role.roleId"/>">编辑</a>
					<%-- <a class="btn btn-small btn-danger"
					href="deleteRole?roleId=<s:property value="role.roleId"/>">删除</a></td> --%>
			</tr>
		</s:iterator>
	</table>
</body>
</html>