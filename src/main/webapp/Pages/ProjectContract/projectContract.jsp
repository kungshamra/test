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
<script src="<%=scriptCatalog%>/jquery-1.9.1.js"></script>
<script src="<%=scriptCatalog%>/jquery.myPagination.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function getParameter(param) {
		var query = window.location.search;
		var iLen = param.length;
		var iStart = query.indexOf(param);
		if (iStart == -1)
			return "";
		iStart += iLen + 1;
		var iEnd = query.indexOf("&", iStart);
		if (iEnd == -1)
			return query.substring(iStart);
		return query.substring(iStart, iEnd);
	}
	function checkAll() {
		if(confirm('你确定要删除该记录吗？')){
			var string = "";
			for (var i = 0; i < document.getElementsByName("selectFlag").length; i++) {
				if (document.getElementsByName("selectFlag")[i].checked) {
					string += document.getElementsByName("selectFlag")[i].value
							+ "A";
				}
			}
			var name = getParameter("projectId");
			window.location.href = "deleteAnyContract?projectId=" + name + "&s="
					+ string + "'";
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
	<h3><s:property value="projectName" />项目合同信息</h3>
	<input class="btn btn-small btn-primary" type="button" value="新增"
		onclick="window.location='beforeAddContract?projectId=<s:property value="#request.projectId"/>&projectName=<s:property value="#request.projectName"/>'">&nbsp;&nbsp;
	<input class="btn btn-inverse" type="button" onclick="history.go(-1);"
		value="返回">&nbsp;&nbsp;
	<input type="button" value="删除" class="btn btn-small btn-danger"
		onclick="checkAll()">
	<br>
	<br>
	<table class="table table-striped">
		<tr>
			<td>全选</td>
			<td>合同ID</td>
			<td>合同名称</td>
			<td>合同类型</td>
			<td>合同金额</td>
			<td>签订时间</td>
			<!-- <td>备注</td> -->
			<td colspan="2" align="center">操作</td>
		</tr>
		<s:iterator value="list">
			<tr>
				<td align="center"><input type="checkbox" name="selectFlag"
					id="selectFlag" value="<s:property value="id"/>"></td>
				<td align="center"><s:property value="id" /></td>
				<td align="center"><s:property value="contractName" /></td>
				<td align="center"><s:property
						value="contractType==1?'软件':'硬件'" /></td>
				<td align="center"><s:property value="contractAmount" /></td>
				<td><s:date name="contractTime" format="yyyy-MM-dd" /></td>
				<%-- <td align="center"><s:property value="remarks" /></td> --%>
				<td align="center">
					<a class="btn btn-success"
					href="contractDetail?id=<s:property value="id"/>">合同详情</a>&nbsp;&nbsp;
					<a class="btn btn-info"
					href="beforeUpdateContract?id=<s:property value="id"/>&projectName=<s:property value="#request.projectName"/>">编辑</a></td>
				<%-- <td align="center"><a class="btn btn-small btn-danger"
					href="deleteContract?id=<s:property value="id"/>"
					onclick="return confirm('你确定要删除该记录吗？');">删除</a></td> --%>
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