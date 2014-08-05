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
		项目进度修改记录
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

	<%-- 	<input class="btn btn-small btn-primary" type="button" value="新增"
		onclick="location.href='beforeAdd?projectId=<s:property value="#request.projectId"/>&projectName=<s:property value="projectName"/>'">&nbsp;&nbsp;
	<input class="btn btn-inverse" type="button" onclick="location.href='findAllProjectInfo'"
		value="返回"/> --%>
	<!-- 批量删除功能暂时不做 -->
	<!-- <input type="button" value="删除"
		onclick="window.location='deleteAnyContract'"> -->
	<br>
	<br>
	<table name="projectProgressHistory" border="0"
		class="table table-striped">
		<tr>
			<td>项目id</td>
			<td>项目名称</td>
			<td>项目在建年份</td>
			<td>项目进度修改记录id</td>
			<td>项目进度id</td>
			<td>项目进度</td>
			<td>原计划启动时间</td>
			<td>修改后计划启动时间</td>
			<td>原计划完成时间</td>
			<td>修改后计划完成时间</td>
			<td>修改人</td>
			<td>修改时间</td>
			<td>备注</td>
		</tr>
		<s:iterator value="showList">
			<tr>
				<td align="center"><s:property value="proProgress.projectId" /></td>
				<td align="center"><s:property value="proInfo.projectName" /></td>
				<td><s:date name="proInfo.year" format="yyyy-MM-dd" /></td>
				<td align="center"><s:property value="ppHistory.id" /></td>
				<td align="center"><s:property
						value="ppHistory.projectProgressId" /></td>
				<%-- <td align="center"><s:property value="progressType" /></td> --%>
				<s:set name="progressType" value="proProgress.progressType" />
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
				<%-- <td align="center"><s:property value="planStartTime" /></td> --%>
				<td><s:date name="ppHistory.changedPlanST" format="yyyy-MM-dd" /></td>
				<td><s:date name="proProgress.planStartTime"
						format="yyyy-MM-dd" /></td>
				<%-- <td align="center"><s:property value="planEndTime" /></td> --%>
				<td><s:date name="ppHistory.changedPlanET" format="yyyy-MM-dd" /></td>
				<%-- <td align="center"><s:property value="startTime" /></td> --%>
				<td><s:date name="proProgress.planEndTime" format="yyyy-MM-dd" /></td>
				<%-- <td align="center"><s:property value="endTime" /></td> --%>

				<td align="center"><s:property value="ppHistory.editor" /></td>
				<td align="center"><s:property value="ppHistory.editTime" /></td>
				<td align="center"><s:property value="proProgress.remark" /></td>
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