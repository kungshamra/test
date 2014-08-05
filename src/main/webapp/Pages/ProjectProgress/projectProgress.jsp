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
<script>
	$(function() {
		var curpage = "";
		curpage = $("#curpage").val();
		var pageCount = "";
		pageCount = $("#pageCount").val();
		if (pageCount < 1) {
			$("#page").hide();
		}
		$("#page").myPagination({
			currPage : curpage,
			pageCount : pageCount,
			pageSize : 6
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<h3>
		<s:property value="projectName" />
		项目进度信息
	</h3>
	<!-- <s:textfield id="pId" name="projectId" label="项目id：" />
	<script language="javascript">
		function getId() {
			var id = getElementById("pId").value
			return id
		}
	</script> -->


	<!-- <input type="button" value="新增"
		onclick="location.href='addProgressInfo?projectId=out.println('<script language='javascript'>getId();</script>')'">&nbsp;&nbsp; -->

	<input class="btn btn-small btn-primary" type="button" value="新增"
		onclick="location.href='beforeAdd?projectId=<s:property value="#request.projectId"/>&projectName=<s:property value="#request.projectName"/>'">&nbsp;&nbsp;
	<input class="btn btn-inverse" type="button"
		onclick="location.href='findAllProjectInfo?page=1'" value="返回" />
	<!-- 批量删除功能暂时不做 -->
	<!-- <input type="button" value="删除"
		onclick="window.location='deleteAnyContract'"> -->
	<br>
	<br>
	<table name="projectProgress" border="0" class="table table-striped">
		<tr>
			<td>全选</td>
			<td>项目进度id</td>
			<td>项目id</td>
			<td>项目进度</td>
			<td>状态</td>
			<td>计划启动时间</td>
			<td>计划完成时间</td>
			<td>实际启动时间</td>
			<td>实际完成时间</td>
			<td>是否延误</td>
			<td>延误时间</td>
			<td>备注</td>
			<td colspan="2" align="center">操作</td>
		</tr>
		<s:iterator value="list">
			<tr>
				<td align="center"><input type="checkbox" name="item"
					value="<s:property value="id"/>"></td>
				<td align="center"><s:property value="id" /></td>
				<td align="center"><s:property value="projectId" /></td>
				<%-- <td align="center"><s:property value="progressType" /></td> --%>
				<s:set name="progressType" value="progressType" />
				<td><s:if test="#progressType==1">
						<s:property value="'项目启动'" />
					</s:if> <s:elseif test="#progressType==2">
						<s:property value="'调研及需求'" />
					</s:elseif> <s:elseif test="#progressType==3">
						<s:property value="'项目评审'" />
					</s:elseif> <s:elseif test="#progressType==4">
						<s:property value="'项目报批'" />
					</s:elseif> <s:elseif test="#progressType==5">
						<s:property value="'项目招投标'" />
					</s:elseif> <s:elseif test="#progressType==6">
						<s:property value="'合同签署'" />
					</s:elseif> <s:elseif test="#progressType==7">
						<s:property value="'项目实施'" />
					</s:elseif> <s:elseif test="#progressType==8">
						<s:property value="'项目试运行'" />
					</s:elseif> <s:elseif test="#progressType==9">
						<s:property value="'项目验收'" />
					</s:elseif> <s:else>
						<s:property value="" />
					</s:else></td>
				<td align="center"><s:property value="status" /></td>
				<%-- <td align="center"><s:property value="planStartTime" /></td> --%>
				<td><s:date name="planStartTime" format="yyyy-MM-dd" /></td>
				<%-- <td align="center"><s:property value="planEndTime" /></td> --%>
				<td><s:date name="planEndTime" format="yyyy-MM-dd" /></td>
				<%-- <td align="center"><s:property value="startTime" /></td> --%>
				<td><s:date name="startTime" format="yyyy-MM-dd" /></td>
				<%-- <td align="center"><s:property value="endTime" /></td> --%>
				<td><s:date name="endTime" format="yyyy-MM-dd" /></td>
				<td align="center"><s:property value="isDelay" /></td>
				<td align="center"><s:property value="delayTime" /></td>
				<td align="center"><s:property value="remark" /></td>
				<td align="center"><a class="btn btn-info"
					href="beforeEditProgressInfo?id=<s:property value="id"/>&projectName=<s:property value="projectName"/>">编辑</a></td>
				<td align="center"><a class="btn btn-small btn-danger"
					href="deleteProgressInfo?id=<s:property value="id"/>"
					onclick="return confirm('你确定要删除该记录吗？');">删除</a></td>
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