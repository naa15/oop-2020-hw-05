<%@page import="ManagerPackage.ProductManager"%>
<%@page import="ManagerPackage.Product"%>

<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Store</title>
</head>
<body>
<%ProductManager manager = (ProductManager)getServletContext().getAttribute("manager"); 
	List<Product> list = manager.getProducts();
%>
	<h1>Student Store</h1>
	<p>Items availiable:</p>
	<ul>
	<%
	for (Product product : list) {
		%><li>
		<a href="show-products.jsp?id=<%=product.getID() %>"><%=product.getName() %></a>
		</li>		
		<%
		
	}
	%>
	</ul>
</body>
</html>