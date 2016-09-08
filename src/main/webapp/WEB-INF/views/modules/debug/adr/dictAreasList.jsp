<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>区县级地址管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/debug/adr/dictAreas/">区县级地址列表</a></li>
		<shiro:hasPermission name="debug:adr:dictAreas:edit"><li><a href="${ctx}/debug/adr/dictAreas/form">区县级地址添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="dictAreas" action="${ctx}/debug/adr/dictAreas/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>区县级ID：</label>
				<form:input path="areaid" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>区县名：</label>
				<form:input path="area" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>市级ID：</label>
				<form:input path="cityid" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>区县级ID</th>
				<th>区县名</th>
				<th>市级ID</th>
				<shiro:hasPermission name="debug:adr:dictAreas:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="dictAreas">
			<tr>
				<td><a href="${ctx}/debug/adr/dictAreas/form?id=${dictAreas.id}">
					${dictAreas.areaid}
				</a></td>
				<td>
					${dictAreas.area}
				</td>
				<td>
					${dictAreas.cityid}
				</td>
				<shiro:hasPermission name="debug:adr:dictAreas:edit"><td>
    				<a href="${ctx}/debug/adr/dictAreas/form?id=${dictAreas.id}">修改</a>
					<a href="${ctx}/debug/adr/dictAreas/delete?id=${dictAreas.id}" onclick="return confirmx('确认要删除该区县级地址吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>