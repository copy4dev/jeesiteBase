<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>省级地址管理</title>
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
		<li class="active"><a href="${ctx}/debug/adr/dictProvinces/">省级地址列表</a></li>
		<shiro:hasPermission name="debug:adr:dictProvinces:edit"><li><a href="${ctx}/debug/adr/dictProvinces/form">省级地址添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="dictProvinces" action="${ctx}/debug/adr/dictProvinces/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>省级ID：</label>
				<form:input path="provinceid" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>省份名：</label>
				<form:input path="province" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>省级ID</th>
				<th>省份名</th>
				<shiro:hasPermission name="debug:adr:dictProvinces:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="dictProvinces">
			<tr>
				<td><a href="${ctx}/debug/adr/dictProvinces/form?id=${dictProvinces.id}">
					${dictProvinces.provinceid}
				</a></td>
				<td>
					${dictProvinces.province}
				</td>
				<shiro:hasPermission name="debug:adr:dictProvinces:edit"><td>
    				<a href="${ctx}/debug/adr/dictProvinces/form?id=${dictProvinces.id}">修改</a>
					<a href="${ctx}/debug/adr/dictProvinces/delete?id=${dictProvinces.id}" onclick="return confirmx('确认要删除该省级地址吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>