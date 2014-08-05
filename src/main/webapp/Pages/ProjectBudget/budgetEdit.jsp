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
<link href="<%=styleCatalog%>/bootstrap-cerulean.css" type="text/css"
	rel="stylesheet">
<link href="<%=styleCatalog%>/jquery-ui-1.10.3.custom.min.css"
	type="text/css" rel="stylesheet">
<%-- <link href="<%=styleCatalog%>/page.css" type="text/css" rel="stylesheet"> --%>
<link href="<%=styleCatalog%>/simple-canleder.css" type="text/css"
	rel="stylesheet">
<script src="<%=scriptCatalog%>/jquery-1.9.1.js"></script>
<script src="<%=scriptCatalog%>/jquery-ui-1.10.3.custom.min.js"></script>
<script src="<%=scriptCatalog%>/simple-canleder.js"></script>
<%-- <script src="<%=scriptCatalog%>/jquery-cutPage.js"></script> --%>
<script>
	$(function() {
		$("#applyYear").simpleCanleder();
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<caption>
		<h3 align="center">
			<s:property value="projectName" />项目信息编辑
		</h3>
	</caption>
	<center>
		<s:form action="editProjectBudget" method="post"
			enctype="multipart/form-data">
			<s:textfield name="id" label="项目预算id：" />
			<s:textfield name="projectId" label="项目id：" />
			<s:textfield label="%{getText('10703')}" name="year">
				<%-- 				<s:param name="value">
					<s:date name="year" format="yyyy" />
				</s:param> --%>
			</s:textfield>
			<s:select
				list="#{1:getText('10717'),2:getText('10718'),3:getText('10719')}"
				label="%{getText('10105')}" name="type" />
			<!-- 这里就不用维护各项金额了，这些金额都在子系统里面去维护 后这里来提取，但是否可以手动修改？-->
			<s:textfield label="%{getText('10704')}" name="totalInvestment1" />
			<s:textfield label="%{getText('10706')}" name="carryOver" />
			<s:textfield label="%{getText('10707')}" name="newlyInvestment" />
			<s:textfield label="%{getText('10705')}" name="totalInvestment2" />
			<%-- <s:file label="项目组成立报告" name="excelPath" acceptor="text/xls*" /> --%>
			<s:label label="已上传项目组成立报告" name="excelPath"></s:label>
			<!-- 这里要判断一下之前是否上传过文件，如果有就提示是否覆盖，没有就不提示 -->
			<s:set name="whetherUpload1" value="excelPath" />
			<s:if test="#whetherUpload1==null">
				<s:file label="项目组成立报告" name="file1" />
			</s:if>
			<s:else>
				<s:file label="项目组成立报告" name="file1"
					onclick="return confirm('确定覆盖原上传文件吗？');" />
			</s:else>


			<%-- 			<s:a href="beforeEditProjectBudget?id=#request.id" onclick="return confirm('确定要删除该上传文件吗？');">删除</s:a> --%>
			<!-- 前台不用显示的给用户一个删除按钮，当之前有上传文件用户再次上传的时候前台提示会覆盖，确定后后台就做物理删除文件 -->
			<%-- <s:submit type="button" value="删除"
				onclick="return confirm('确定要删除该上传文件吗？');" method="deleteUpload" /> --%>
			<s:label label="已上传可研报告" name="result"></s:label>
			<!-- 这里要判断一下之前是否上传过文件，如果有就提示是否覆盖，没有就不提示 -->
			<s:set name="whetherUpload2" value="result" />
			<s:if test="#whetherUpload2==null">
				<s:file label="可研报告" name="file2" />
			</s:if>
			<s:else>
				<s:file label="可研报告" name="file2"
					onclick="return confirm('确定覆盖原上传文件吗？');" />
			</s:else>

			<!-- 前台不用显示的给用户一个删除按钮，当之前有上传文件用户再次上传的时候前台提示会覆盖，确定后后台就做物理删除文件 -->
			<%-- <s:submit type="button" value="删除"
				onclick="return confirm('确定要删除该上传文件吗？');" method="deleteUpload" /> --%>
			<s:textarea label="%{getText('10103')}1" name="remark1" />
			<s:textarea label="%{getText('10103')}2" name="remark2" />

			<br />
			<%-- <s:submit key="10209" cssStyle="float:left;"/> --%>
			<s:submit value="确定" cssStyle="float:left;" />
			<%-- <s:submit type="button" value="返回" onclick="history.go(-1);"/> --%>
		</s:form>
		<input type="button" onclick="history.go(-1);" value="返回">
	</center>
</body>
</html>