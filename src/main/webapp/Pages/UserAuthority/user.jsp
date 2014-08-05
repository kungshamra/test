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
<link href="<%=styleCatalog%>/page.css" type="text/css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<%=scriptCatalog%>/jquery-1.9.1.js"></script>
<script src="<%=scriptCatalog%>/jquery.myPagination.js"></script>
<script type="text/javascript">
	function checkAll() {
		if (confirm('你确定要删除该记录吗？')) {
			var string = "";
			for (var i = 0; i < document.getElementsByName("selectFlag").length; i++) {
				if (document.getElementsByName("selectFlag")[i].checked) {
					string += document.getElementsByName("selectFlag")[i].value
							+ "A";
				}
			}
			window.location.href = "deleteAnyUser?s=" + string + "'";
		}
	}
	$(function() {
		var curpage = "";
		curpage = $("#curpage").val();
		var pageCount = "";
		pageCount = $("#pageCount").val();
		$("#page").myPagination({
			currPage : curpage,
			pageCount : pageCount,
			pageSize : 6
		});
	});
</script>
<title></title>
</head>
<body>
	<h3>搜索条件</h3>
	<%--  	<form action="findUserByCondition" method="post">
		登录名：<input type="text" name="loginName" value="<s:property name="loginName"/>">&nbsp;&nbsp;&nbsp; 真实姓名：<input
			type="text" name="trueName" value="<s:property name="trueName"/>">&nbsp;&nbsp;&nbsp; 办公电话：<input
			type="text" name="officeNumber" value="<s:property name="officeNumber"/>">&nbsp;&nbsp;&nbsp; <input
			class="btn btn-small btn-primary" type="submit" value="查询">
	</form> --%>
	<s:form action="findUserByCondition?page=1" theme="simple">
		<input type="hidden" name="flag" value="1" />
		登录名 :  <s:textfield name="loginName" label="登录名  "
			cssStyle="width:180px"></s:textfield>
		真实姓名 :  <s:textfield name="trueName" label="真实姓名  "
			cssStyle="width:180px"></s:textfield>
		办公电话 :  <s:textfield name="officeNumber" label="办公电话  "
			cssStyle="width:180px"></s:textfield>
		<s:submit value="查询" />
	</s:form>
	<hr width="100%" align="left">
	<h3>用户管理</h3>
<!-- 	<input class="btn btn-small btn-primary" type="button" value="新增"
		onclick="window.location='Pages/UserAuthority/userAdd.jsp'">&nbsp;&nbsp; -->
	<input class="btn btn-small btn-primary" type="button" value="新增"
		onclick="window.location='beforeAddUser'">&nbsp;&nbsp;
	<input class="btn btn-inverse" type="button" onclick="history.go(-1);"
		value="返回">&nbsp;&nbsp;
	<input class="btn btn-small btn-danger" type="button" value="删除"
		onclick="checkAll()">
	<br>
	<br>
	<table class="table table-striped">
		<tr>
			<th>选择</th>
			<!-- <th>序号</th> -->
			<th>登录名</th>
			<th>真实姓名</th>
			<th>部门</th>
			<th>角色</th>
			<th>办公电话</th>
			<!-- <th>手机</th> -->
			<th>状态</th>
			<th>操作</th>
		</tr>
		<s:iterator value="userRoleList" status="userlist">
			<tr class="odd">
				<td align="center"><input type="checkbox" name="selectFlag"
					id="selectFlag" value="<s:property value="user.memberId"/>"></td>
				<%-- <td align="center"><s:property value="user.memberId" /></td> --%>
				<%-- <td align="center"><s:property value="#userlist.count" /></td> --%>
				<td align="center"><s:property value="user.loginName" /></td>
				<td align="center"><s:property value="user.trueName" /></td>
				<td align="center"><s:property value="user.department" /></td>
				<%-- <td align="center">
					<s:iterator value="role">
						<table align="center">
							<tr>
								<td><s:property value="roleName" /></td>
							</tr>
						</table>
					</s:iterator>
				</td> --%>
				<td><s:iterator value="role">
						<s:property value="roleName" />
						</br>
					</s:iterator></td>
				<td align="center"><s:property value="user.officeNumber" /></td>
				<%-- <td align="center"><s:property value="user.mobile" /></td> --%>
				<td align="center"><s:property
						value="user.dataMark==1?'启用':'停用'" /></td>
				<td align="center"><a class="btn btn-success"
					href="userDetail?memberId=<s:property value="user.memberId"/>">查看详情</a>&nbsp;&nbsp;
					<a class="btn btn-success"
					href="beforeUpdateUserRole?memberId=<s:property value="user.memberId"/>">角色分配</a>&nbsp;&nbsp;
					<a class="btn btn-info"
					href="beforeUpdateUser?memberId=<s:property value="user.memberId"/>">编辑</a>
					<%-- <a class="btn btn-small btn-danger" onclick="return confirm('你确定要删除该记录吗？');"
					href="deleteUser?memberId=<s:property value="user.memberId"/>">删除</a></td> --%>
			</tr>
		</s:iterator>
	</table>
	<input type="hidden" id="curpage" name="curpage"
		value="<s:property value="#request.page"/>" />
	<input type="hidden" id="pageCount" name="pageCount"
		value="<s:property value="totalPage"/>" />
	<div id="page" class="menu"></div>
</body>
</html>