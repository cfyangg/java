<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<%
	String op=request.getParameter("op");
	String id=request.getParameter("id");
	String src0="./img/"+id;
%>
<body>
<%
	if("0".equals(op))
	{
%>
<form action="${pageContext.request.contextPath }/servlet/UploadPhoto" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value=<%=id %>> <br>
		文件：<input type="file" name="file1"> <br>
               <input type="submit" />
</form>
<%
	}
	else
	{
%>
<img src=<%=src0 %> alt="" height="100" weight="100"><br>
上传图片成功保存
<%
	response.setHeader("Refresh","2;URL="+request.getContextPath()+"/listBook.jsp?page=1");        
	}
%>
</body>
</html>