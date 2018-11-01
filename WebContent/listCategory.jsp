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
<title>种类列表</title>
</head>
<%
	CategoryDao cd = new CategoryDaoImpl();
	List<Categories> categories = cd.findAll();
%>
<body>
<div align="center">
<form method="post" name="updateCategoryForm">
	<table>
		<tr>
			<td></td>
			<td>Id</td>
			<td>Name</td>
		</tr>
		<%
		for(Categories category : categories)
		{
		%>
		<tr>
			<td><input type="radio" name="id" value=<%=category.getId() %>></td>
			<td><%=category.getId() %></td>
			<td><%=category.getName() %></td>
		</tr>
		<%
		}
		%>
	</table>
	<input type="submit" value="add" onclick="updateCategoryForm.action='${pageContext.request.contextPath }/addCategory.jsp';updateCategoryForm.submit()">	
	<input type="submit" value="update" onclick="updateCategoryForm.action='${pageContext.request.contextPath }/updateCategory.jsp';updateCategoryForm.submit()">
	<input type="submit" value="delete" onclick="updateCategoryForm.action='${pageContext.request.contextPath }/servlet/AdminServlet?op=updateCategory&op0=delete';updateCategoryForm.submit()">
</form>
<br>
	<a href="index0.jsp" ><button>back</button></a>
</div>
</body>
</html>