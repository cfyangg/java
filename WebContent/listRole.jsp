<%@ page language="java" import="java.util.List" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="cn.tf.domain.*,cn.tf.dao.*,cn.tf.dao.impl.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="./css/bootstrapv3.css">
<script src="./js/jquery-1.9.1.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<script src="./js/bootstrap-paginator.min.js"></script>
<title>角色列表</title>
</head>
<%
	RoleDao rd = new RoleDaoImpl();
	List<Role> roles = rd.find();
%>
<body>
<div align="center">
<form method="post" name="updateRoleForm">
	<table>
		<tr>
			<td></td>
			<td>ID</td>
			<td>RoleName</td>
			<td>DelFlag</td>
			<td>RoleType</td>
			<td>SubTime</td>
			<td>Remark</td>
		</tr>
<%
	for(Role role : roles)
	{
%>
		<tr>
			<td><input type="radio" name="id" value=<%=role.getID() %>></td>
			<td><%=role.getID() %></td>
			<td><%=role.getRoleName() %></td>
			<td><%=role.getDelFlag() %></td>
			<td><%=role.getRoleType() %></td>
			<td><%=role.getSubTime() %></td>
			<td><%=role.getRemark() %></td>
		</tr>
<%
	}
%>
	</table>
	<input type="submit" value="add" onclick="updateRoleForm.action='${pageContext.request.contextPath }/addRole.jsp';updateRoleForm.submit()">	
	<input type="submit" value="update" onclick="updateRoleForm.action='${pageContext.request.contextPath }/updateRole.jsp';updateRoleForm.submit()">
	<input type="submit" value="delete" onclick="updateRoleForm.action='${pageContext.request.contextPath }/servlet/AdminServlet?op=updateRole&op0=delete';updateRoleForm.submit()">
</form>
<br>
	<a href="index0.jsp" ><button>back</button></a>
</div>
</body>
</html>