<%@ page language="java" import="java.util.List" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="cn.tf.domain.*,cn.tf.dao.*,cn.tf.dao.impl.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加页面</title>
</head>
<%
	PublisherDao pd=new PublisherDaoImpl();
	List<Publishers> publisher=pd.find();
	CategoryDao cd=new CategoryDaoImpl();
	List<Categories> category=cd.findAll();
%>
<body>
<div align="center">
<form method="post" action="${pageContext.request.contextPath }
		/servlet/AdminServlet?op=updateBooks&op0=add">
Title:<input type="text" name="Title" ><br>
Author:<input type="text" name="Author" ><br>
PublisherId:
<select name="PublisherId">
<%
	for(Publishers pub : publisher) {
%>
	<option value=<%=pub.getId() %>><%=pub.getName() %></option>
<%
	}
%>
</select><br>
PublishDate:<input type="text" name="PublishDate" ><br>
ISBN:<input type="text" name="ISBN" ><br>
WordsCount:<input type="text" name="WordsCount" ><br>
UnitPrice:<input type="text" name="UnitPrice" ><br>
ContentDescription:<input type="text" name="ContentDescription" ><br>
AurhorDescription:<input type="text" name="AurhorDescription" ><br>
EditorComment:<input type="text" name="EditorComment" ><br>
TOC:<input type="text" name="TOC" ><br>
CategoryId:
<select name="CategoryId" >
<%
	for(Categories pub : category) {
%>
	<option value=<%=pub.getId() %>><%=pub.getName() %></option>
<%
	}
%>
</select>
<br>
Clicks:<input type="text" name="Clicks" ><br>
<input type="submit" value="提交">
</form>
</div>
</body>
</html>