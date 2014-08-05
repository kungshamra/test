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
<title></title>
</head>
<body>
	<center>
		<br> <br>
		<h3>
			【
			<s:property value="systemName" />
			】 子系统信息查看
		</h3>
		<br>
		<div style="width: 50%">
			<table class="table table-bordered table-striped table-condensed">

				<tr>
					<td>子系统名称：</td>
					<td><s:property value="systemName" /></td>
				</tr>
				<tr>
					<td>类别：</td>
					<td><s:if test="systemType==1">
							<s:property value="'数据中心'" />
						</s:if> <s:elseif test="systemType==2">
							<s:property value="'基础设施'" />
						</s:elseif> <s:elseif test="systemType==3">
							<s:property value="'五大平台'" />
						</s:elseif> <s:else>
							<s:property value="" />
						</s:else></td>
				</tr>
				<tr>
					<td>平台：</td>
					<td><s:if test="systemPlatform==1">
							<s:property value="'营销平台'" />
						</s:if> <s:elseif test="systemPlatform==2">
							<s:property value="'运行平台'" />
						</s:elseif> <s:elseif test="systemPlatform==3">
							<s:property value="'M&E平台'" />
						</s:elseif> <s:elseif test="systemPlatform==4">
							<s:property value="'服务平台'" />
						</s:elseif> <s:elseif test="systemPlatform==5">
							<s:property value="'综合平台'" />
						</s:elseif> <s:else>
							<s:property value="" />
						</s:else></td>
				</tr>
				<tr>
					<td>性质：</td>
					<td><s:if test="systemDevelopType == 1">外包</s:if> <s:else>自主</s:else></td>
				</tr>
				<tr>
					<td>子系统总投资额：</td>
					<td><s:property value="%{formatDouble(systemTotalInvest)}" /></td>
				</tr>
				<tr>
					<td>子系统结转：</td>
					<td><s:property value="%{formatDouble(systemCarryOver)}" /></td>
				</tr>
				<tr>
					<td>子系统新增投资额：</td>
					<td><s:property value="%{formatDouble(systemNewlyInvest)}" /></td>
				</tr>
				<tr>
					<td>项目组人员：</td>
					<td><s:property value="teamMember" /></td>
				</tr>
				<tr>
					<td>验收评委：</td>
					<td><s:property value="acceptors" /></td>
				</tr>
				<tr>
					<td>运维交接时间：</td>
					<td><s:date name="handoverTime" format="yyyy-MM-dd" /></td>
				</tr>
				<tr>
					<td>使用部门：</td>
					<td><s:property value="userDepartment" /></td>
				</tr>
				<tr>
					<td>功能描述：</td>
					<td><s:property value="description" /></td>
				</tr>
				<tr>
					<td>备注：</td>
					<td><s:property value="remark" /></td>
				</tr>

			</table>
		</div>
		<input class="btn btn-inverse" type="button" value="返回"
			onclick="history.go(-1)">
	</center>
</body>
</html>