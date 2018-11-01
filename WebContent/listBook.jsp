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
<title>书目列表</title>
<style>
.td{width:100px;overflow:auto }
</style>
</head>
<%
	String page0=request.getParameter("page");
	System.out.println(page0);
	int pages = Integer.parseInt(page0);
	System.out.println(pages);
	BookDao bd = new BookDaoImpl();
	List<Books> books = bd.find();
	int totalnum=books.size();
	int totalpagess=totalnum/10;
%>
<body>
<div align="center">
<form method="post" name="updateBookForm">
	<table>
		<tr>
			<td></td>
			<td>Id</td>
			<td>Title</td>
			<td>Author</td>
			<td>PublisherId</td>
			<td>PublishDate</td>
			<td>ISBN</td>
			<td>WordsCount</td>
			<td>UnitPrice</td>
			<td>CategoryId</td>
			<td>Clicks</td>
		</tr>
		<%
		for(int i=pages*10-10;i<pages*10;i++)
		{
		%>
		<tr>
			<td><input type="radio" name="id" value=<%=books.get(i).getId() %>></td>
			<td><%=books.get(i).getId() %></td>
			<td><%=books.get(i).getTitle() %></td>
			<td><%=books.get(i).getAuthor() %></td>
			<td><%=books.get(i).getPublisherId() %></td>
			<td><%=books.get(i).getPublishDate() %></td>
			<td><%=books.get(i).getISBN() %></td>
			<td><%=books.get(i).getWordsCount() %></td>
			<td><%=books.get(i).getUnitPrice() %></td>
			<td><%=books.get(i).getCategoryId() %></td>
			<td><%=books.get(i).getClicks() %></td>
		</tr>
		<%
		}
		%>
		</table>
		
			<input type="submit" value="add" onclick="updateBookForm.action='${pageContext.request.contextPath }/addBook.jsp';updateBookForm.submit()">	
			<input type="submit" value="update" onclick="updateBookForm.action='${pageContext.request.contextPath }/updateBook.jsp';updateBookForm.submit()">
			<input type="submit" value="delete" onclick="updateBookForm.action='${pageContext.request.contextPath }/servlet/AdminServlet?op=updateBooks&op0=delete';updateBookForm.submit()">	
</form>
<br>
	<a href="index0.jsp" ><button>back</button></a>
</div>	
<div align="center">
                              <ul class="pagination" id="paginator"></ul>
                          </div>
<!-- jQuery Plugins -->
		
		<script src="js/slick.min.js"></script>
		<script src="js/nouislider.min.js"></script>
		<script src="js/jquery.zoom.min.js"></script>
		<script src="js/main.js"></script>

                          
                               
       
    
         <script type='text/javascript'>
            var options = {
                    
                    bootstrapMajorVersion: 3,    //bootstrap版本
                    size: 'normal',
                    itemTexts: function (type, page, current) {
                        switch (type) {
                        case "first":
                            return "首页";
                        case "prev":
                            return "<i class='fa fa-caret-left'></i> 上一页";
                        case "next":
                            return "下一页 <i class='fa fa-caret-right'></i>";
                        case "last":
                            return "末页";
                        case "page":
                            return page;
                        }
                    },
                    tooltipTitles: function (type, page, current) {
                        switch (type) {
                        case "first":
                            return "首页";
                        case "prev":
                            return "上一页";
                        case "next":
                            return "下一页";
                        case "last":
                            return "末页";
                        case "page":
                            return "第" + page + "页";
                        }
                    },
                    pageUrl: function(type, page, current){
                        return "listBook.jsp?page="+page;    //跳转到选定页面
                    },
                    numberOfPages: 5,    //显示“第几页”的选项数目
                    currentPage: <%=pages %>,    //当前页数
                    totalPages: <%=totalpagess %>    //总页数
                   }
    
            $('#paginator').bootstrapPaginator(options);
        </script>
</body>
</html>