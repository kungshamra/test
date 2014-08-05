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
<script type="text/javascript">
	function checkAll() {
		if(confirm('你确定要删除该记录吗？')){
			var string = "" ;
	  		for (var i = 0; i < document.getElementsByName("selectFlag").length; i++) {
	   			if(document.getElementsByName("selectFlag")[i].checked){
	   	   			string += document.getElementsByName("selectFlag")[i].value + "A" ;
	   			}
	  		}
	  		window.location.href="deleteAnyAuthority?s=" + string + "'";
	    }
 	}
</script>
<title></title>
</head>
<body>
<h3>权限维护</h3>
	<input class="btn btn-small btn-primary" type="button" value="新增"
		onclick="window.location='Pages/UserAuthority/authorityAdd.jsp'">&nbsp;&nbsp;
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
			<th>权限组</th>
			<th>权限名称</th>
			<th>状态</th>
			<th>备注</th>
			<th>操作</th>
		</tr>
		<s:iterator value="list" status="al">
			<tr class="odd">
				<td align="center"><input type="checkbox" name="selectFlag" id="selectFlag"
					value="<s:property value="authorityId"/>"></td>
				<td align="center"><s:property value="#al.count" /></td>
				<td align="center"><s:property value="authorityGroup" /></td>
				<td align="center"><s:property value="authorityName" /></td>
				<td align="center"><s:property value="dataMark==1?'启用':'停用'" /></td>
				<td align="center"><s:property value="remarks" /></td>
				<td align="center">
					<a class="btn btn-info"
					href="beforeUpdateAuthority?authorityId=<s:property value="authorityId"/>">编辑</a>
					<%-- <a class="btn btn-small btn-danger"
					href="deleteAuthority?authorityId=<s:property value="authorityId"/>">删除</a></td> --%>
			</tr>
		</s:iterator>
	</table>
</body>
</html>