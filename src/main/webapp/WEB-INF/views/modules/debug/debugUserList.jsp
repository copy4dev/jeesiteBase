<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>debug用户管理</title>
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
		<li class="active"><a href="${ctx}/debug/debugUser/">debug用户列表</a></li>
		<shiro:hasPermission name="debug:debugUser:edit"><li><a href="${ctx}/debug/debugUser/form">debug用户添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="debugUser" action="${ctx}/debug/debugUser/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>号账：</label>
				<form:input path="name" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>id</th>
				<th>号账</th>
				<th>码密</th>
				<th>地址</th>
				<th>注备</th>
				<shiro:hasPermission name="debug:debugUser:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="debugUser">
			<tr>
				<td><a href="${ctx}/debug/debugUser/form?id=${debugUser.id}">
					${debugUser.id}
				</a></td>
				<td>
					${debugUser.name}
				</td>
				<td>
					${debugUser.password}
				</td>
				<td>
					${debugUser.address}
				</td>
				<td>
					${debugUser.remarks}
				</td>
				<shiro:hasPermission name="debug:debugUser:edit"><td>
    				<a href="${ctx}/debug/debugUser/form?id=${debugUser.id}">修改</a>
					<a href="${ctx}/debug/debugUser/delete?id=${debugUser.id}" onclick="return confirmx('确认要删除该debug用户吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>