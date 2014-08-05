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
<link href="<%=styleCatalog%>/cutpage-style.css" type="text/css"
	rel="stylesheet">
<link href="<%=styleCatalog%>/simple-canleder.css" type="text/css"
	rel="stylesheet">
<link href="<%=styleCatalog%>/page.css" type="text/css" rel="stylesheet">
<script src="<%=scriptCatalog%>/jquery-1.9.1.js"></script>
<script src="<%=scriptCatalog%>/jquery-ui-1.10.3.custom.min.js"></script>
<script src="<%=scriptCatalog%>/jquery.myPagination.js"></script>
<script src="<%=scriptCatalog%>/simple-canleder.js"></script>
<script>
	$(function() {
		/* 		$("#myDate").simpleCanleder(); */
		$("#applyStartDate").simpleCanleder();
		$("#applyEndDate").simpleCanleder();
		$("#approveStartDate").simpleCanleder();
		$("#approveEndDate").simpleCanleder();
	});
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
<title><s:text name="10602" /></title>
</head>
<body>
	<center>
		<h2>搜索条件</h2>
		<div>
			<s:form action="searchBudgetInfo" cssStyle="float:left"
				theme="simple">
				项目名称：<s:textfield cssStyle="width:8%" name="projectName"
					label="项目名称"></s:textfield>
				项目申报 年份：<s:textfield cssStyle="width:8%" name="applyYear"
					label="项目申报 年份">
					<s:param name="value">
						<s:date name="applyYear" format="yyyy" />
					</s:param>
				</s:textfield>
				类别：<s:select cssStyle="width:8%" name="projectType"
					list="#{0:'---',1:'数据中心',2:'基础设施',3:'五大平台'}" label="类别"></s:select>
				 
				
				平台：<s:select cssStyle="width:8%" name="projectPlatform"
					list="#{0:'---',1:'营销平台',2:'运行平台',3:'ME平台',4:'综合平台'}" label="平台"></s:select>
					
					性质：<s:select cssStyle="width:8%" name="type"
					list="#{0:'---',1:'新建',2:'升级',3:'改造'}" label="性质" />
					
				总投资额：
					<s:textfield cssStyle="width:8%" name="totalInvestment1a" value=""
					label="总投资额"></s:textfield>				
				---
					<s:textfield cssStyle="width:8%" name="totalInvestment1b" value=""
					label="总投资额"></s:textfield>
			 预算申报时间：<s:textfield cssStyle="width:8%" name="applyTimeStart"
					label=" 预算申报时间" id="applyStartDate">
					<s:param name="value">
						<s:date name="applyTimeStart" format="yyyy-MM-dd" />
					</s:param>
				</s:textfield>
				至<s:textfield cssStyle="width:8%" name="applyTimeEnd"
					id="applyEndDate">
					<s:param name="value">
						<s:date name="applyTimeEnd" format="yyyy-MM-dd" />
					</s:param>
				</s:textfield>
		 预算批准时间：<s:textfield cssStyle="width:8%" name="approvalTimeStart"
					label=" 预算批准时间" id="approveStartDate">
					<s:param name="value">
						<s:date name="approvalTimeStart" format="yyyy-MM-dd" />
					</s:param>
				</s:textfield>
				至<s:textfield cssStyle="width:8%" name="approvalTimeEnd"
					id="approveEndDate">
					<s:param name="value">
						<s:date name="approvalTimeEnd" format="yyyy-MM-dd" />
					</s:param>
				</s:textfield>
				<s:submit value="查询" />
				<s:reset value="重置" />
			</s:form>
		</div>
	</center>
	<h2>
		<s:text name="10701" />
	</h2>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>全选</th>
				<th>序号(预算id)</th>
				<th>项目id</th>
				<th>项目申报年份</th>
				<th>类别</th>
				<th>平台</th>
				<th>信息化项目名称</th>
				<th>子系统</th>
				<th>性质</th>
				<th>总投资额</th>
				<th>结转</th>
				<th>新增投资额</th>
				<th>总投资</th>
				<th>预算申报时间</th>
				<th>预算批准时间</th>
				<th>备注1</th>
				<th>备注2</th>
				<th>项目组成立报告名字</th>
				<th>可研报告名字</th>
				<th>项目组成立报告</th>
				<th>可研报告</th>
				<th colspan="3" align="center">操作</th>
			</tr>
		</thead>
		<s:iterator value="showlist">
			<tbody>
				<tr class="odd">
					<td class="center"><input type="checkbox"></td>
					<td class="center"><s:property value="proBudget.id" /></td>
					<td class="center"><s:property value="proBudget.projectId" /></td>
					<%-- 					<td class="center"><s:property value="proBudget.year" /></td>
 --%>
					<td><s:date name="proBudget.year" format="yyyy" /></td>
					<%-- <td class="center"><s:property value="proInfo.projectType" /></td> --%>
					<s:set name="projectType" value="proInfo.projectType" />
					<td><s:if test="#projectType==1">
							<s:property value="'数据中心'" />
						</s:if> <s:elseif test="#projectType==2">
							<s:property value="'基础设施'" />
						</s:elseif> <s:elseif test="#projectType==3">
							<s:property value="'五大平台'" />
						</s:elseif> <s:else>
							<s:property value="" />
						</s:else></td>
					<%-- <td class="center"><s:property value="proInfo.projectPlatform" /></td> --%>
					<s:set name="projectPlatform" value="proInfo.projectPlatform" />
					<td><s:if test="#projectPlatform==1">
							<s:property value="'营销平台'" />
						</s:if> <s:elseif test="#projectType==2">
							<s:property value="'运行平台'" />
						</s:elseif> <s:elseif test="#projectType==3">
							<s:property value="'M&E平台'" />
						</s:elseif> <s:elseif test="#projectType==4">
							<s:property value="'服务平台'" />
						</s:elseif> <s:elseif test="#projectType==5">
							<s:property value="'综合平台'" />
						</s:elseif> <s:else>
							<s:property value="" />
						</s:else></td>
					<td class="center"><s:property value="proInfo.projectName" /></td>
					<td class="center"><a
						href="findSystemBudget.action?budgetId=<s:property value="proBudget.id" />&projectName=<s:property value="proInfo.projectName" />&page=1&flag=1">查看</a></td>
					<%-- <td class="center"><s:property value="proBudget.type" /></td> --%>
					<s:set name="proBudget" value="proBudget.type" />
					<td><s:if test="#proBudget==1">
							<s:property value="'新建'" />
						</s:if> <s:elseif test="#proBudget==2">
							<s:property value="'升级'" />
						</s:elseif> <s:elseif test="#proBudget==3">
							<s:property value="'改造'" />
						</s:elseif> <s:else>
							<s:property value="" />
						</s:else></td>
					<td class="center"><s:property
							value="proBudget.totalInvestment1" /></td>
					<td class="center"><s:property value="proBudget.carryOver" /></td>
					<td class="center"><s:property
							value="proBudget.newlyInvestment" /></td>
					<td class="center"><s:property
							value="proBudget.totalInvestment2" /></td>
					<td><s:date name="proInfo.budgetApplyTime" format="yyyy-MM" /></td>
					<%--<td class="center"><s:property value="proInfo.budgetApplyTime" /></td>
 --%>
					<td><s:date name="proInfo.budgetApprovalTime" format="yyyy-MM" /></td>
					<%-- 	<td class="center"><s:property
							value="proInfo.budgetApprovalTime" /></td> --%>
					<td class="center"><s:property value="proBudget.remark1" /></td>
					<td class="center"><s:property value="proBudget.remark2" /></td>
					<td class="center"><s:property value="proBudget.excelPath" /></td>
					<td class="center"><s:property value="proBudget.result" /></td>
					<%-- <td class="center"><a class="btn btn-small btn-primary"
						href="beforeAddProjectBudget?id=<s:property value="proBudget.id"/>">新增</a></td> --%>

					<td class="center"><a class="btn btn-small btn-primary"
						href="fileDownload?fileName=<s:property value="proBudget.excelPath" />">项目组成立报告下载</a></td>

					<td class="center"><a class="btn btn-small btn-primary"
						href="fileDownload?fileName=<s:property value="proBudget.result" />">可研报告下载</a></td>

					<td class="center"><a class="btn btn-info"
						href="beforeEditProjectBudget?id=<s:property value="proBudget.id"/>&projectName=<s:property value="proInfo.projectName" />">编辑</a>
					</td>
					<!--下面的fileName需要动态的传文件名，这就只能在上传的时候把文件名取到并存入数据库，这里再动态的取出来并迭代。 -->
					<%-- <td class="center"><a class="btn btn-small btn-primary"
						href="fileDownload?fileName=<s:property value="proBudget.excelPath" />">从数据库取名字下载</a></td> --%>
					<!-- <td class="center"><a class="btn btn-small btn-primary"
						href="fileDownload?fileName=《信息服务部分册》02-00版.pdf">下载GettingThingsDone.pdf</a></td>   -->

					<%-- 					<!-- 循环显示上传成功文件名 -->
					<s:iterator value="fileFileName" status="fn">
						<tr>
							<td>
								<!-- 上传成功文件名 --> <s:property />
							</td>
							<!-- 下载文件链接内容为定义的下载Action -->
							<!-- 下载文件名作为链接参数fileName值，用OGNL表达式表达 -->
							<td class="center"><a class="btn btn-small btn-primary"
								href="<s:url value='fileDownload.action'>                 
                    <s:param name='fileName'value='fileFileName[#fn.getIndex()]'></s:param>    
                 </s:url>">下载</a></td>
						</tr>
					</s:iterator> --%>

					<!-- 	<td class="center"><a class="btn btn-small btn-primary"
						href="./Pages/ProjectBudget/budgetAdd.jsp">查看</a></td> -->

				</tr>

			</tbody>
		</s:iterator>

	</table>
	<input type="hidden" id="curpage" name="curpage"
		value="<s:property value="#request.page"/>" />
	<input type="hidden" id="pageCount" name="pageCount"
		value="<s:property value="totalPage"/>" />
	<div id="page" class="menu"></div>
</body>
</html>