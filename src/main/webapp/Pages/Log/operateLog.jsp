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
<link href="<%=styleCatalog%>/jquery-ui-1.10.3.custom.min.css"
	type="text/css" rel="stylesheet">
<!-- 分页所需开始 -->
<link href="<%=styleCatalog%>/page.css" type="text/css" rel="stylesheet">
<!-- 分页所需结束-->
<script src="<%=scriptCatalog%>/jquery-1.9.1.js"></script>
<script src="<%=scriptCatalog%>/jquery-ui-1.10.3.custom.min.js"></script>
<script src="<%=scriptCatalog%>/jquery.myPagination.js"></script>
<!-- 分页所需开始 -->
<%-- <script src="<%=scriptCatalog%>/jquery-cutPage.js"></script> --%>
<!-- 分页所需结束 -->
<script>
	$(function() {
		$("#datepicker").datepicker({
			changeYear : true,
			changeMonth : true,
			showOtherMonths : true,
			selectOtherMonths : true,
		});

		$("#from").datepicker({
			defaultDate : "+1w",
			changeYear : true,
			changeMonth : true,
			numberOfMonths : 1,
			onClose : function(selectedDate) {
				$("#to").datepicker("option", "minDate", selectedDate);
			}
		});

		$("#to").datepicker({
			defaultDate : "+1w",
			changeYear : true,
			changeMonth : true,
			numberOfMonths : 1,
			onClose : function(selectedDate) {
				$("#from").datepicker("option", "maxDate", selectedDate);
			}
		});
		<!-- 分页所需开始 -->
		var curpage = "";
		curpage = $("#curpage").val();
		var pageCount = "";
		pageCount = $("#pageCount").val();
		$("#page").myPagination({
			currPage : curpage,
			pageCount : pageCount,
			pageSize : 6			
		});
		<!-- 分页所需结束  -->
		
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<center>
		<h2>搜索条件</h2>
		<div style="width: 100%">
			<s:form action="searchLog?page=1" cssStyle="float:left"
				theme="simple">
				<input type="hidden" name="flag" value="1" />
				操作人：<s:textfield cssStyle="width:70px" name="trueName" label="操作人"></s:textfield>
				操作模块：<s:textfield cssStyle="width:100px" name="moduleName"
					label="操作模块"></s:textfield>
				操作类型：<s:select cssStyle="width:70px"
					list="#{0:'———',1:'新增',2:'删除',3:'修改'}" label="%{getText('10105')}"
					name="operateType" />
				关键字：<s:textfield cssStyle="width:100px" name="keyWord" label="关键字"></s:textfield>
				操作时间：<s:textfield cssStyle="width:100px" name="startTime"
					label="操作时间" id="from">
					<s:param name="value">
						<s:date name="startTime" format="yyyy-MM-dd" />
					</s:param>
				</s:textfield>
				至<s:textfield cssStyle="width:100px" name="endTime" id="to">
					<s:param name="value">
						<s:date name="endTime" format="yyyy-MM-dd" />
					</s:param>
				</s:textfield>
				IP：<s:textfield cssStyle="width:100px" name="ipAddress" label="IP"></s:textfield>
				<s:submit value="查询" cssStyle="margin-bottom:10px;" />

				<input type="reset" value="重置" style="margin-bottom: 10px;" />
			</s:form>
		</div>
	</center>
	<br>

	<table class="table table-striped">
		<thead>
			<tr>
				<%-- <th style="width: 4%"><s:text name="10101" /></th> --%>
				<%-- <th style="width: 4%"><s:text name="10102" /></th> --%>
				<th style="width: 10%"><s:text name="10403" /></th>
				<th style="width: 15%"><s:text name="10404" /></th>
				<%-- <th><s:text name="10414" /></th> --%>
				<th style="width: 10%"><s:text name="10405" /></th>
				<th style="width: 20%"><s:text name="10406" /></th>
				<%-- <th style="width: 41%"><s:text name="10407" /></th> --%>
				<th style="width: 15%"><s:text name="10013" /></th>
				<th style="width: 15%"><s:text name="操作" /></th>
			</tr>
		</thead>
		<s:iterator value="list" status="list">
			<tbody>
				<tr class="odd">
					<!-- <td class="center"><input type="checkbox"></td> -->
					<%-- <td class="center"><s:property value="#list.count" /></td> --%>
					<td class="center"><s:property value="trueName" /></td>
					<td class="center"><s:property value="moduleName" /></td>
					<%-- <td class="center"><s:property value="keyWord" /></td> --%>
					<td class="center"><s:if test="operateType==1">新增</s:if> <s:elseif
							test="operateType==2">删除</s:elseif> <s:elseif
							test="operateType==3">修改</s:elseif></td>
					<td class="center"><s:date name="operateTime"
							format="yyyy-MM-dd HH:mm:ss" /></td>
					<%-- 	<td class="center"><s:property value="operateInfo" /></td> --%>
					<td class="center"><s:property value="ipAddress" /></td>
					<td class="center"><a class="btn btn-success"
						href="logDetail?id=<s:property value="id"/>">查看详情</a></td>
				</tr>
			</tbody>
		</s:iterator>

	</table>
	<div id="page" class="menu"></div>
	<!-- 分页所需开始 -->
	<input type="hidden" id="curpage" name="curpage"
		value="<s:property value="#request.page"/>" />
	<input type="hidden" id="pageCount" name="pageCount"
		value="<s:property value="totalPage"/>" />

	<!-- 分页所需结束 -->

</body>
</html>