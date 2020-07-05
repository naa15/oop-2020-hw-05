<%@page import="ManagerPackage.ProductManager"%>
<%@page import="ManagerPackage.Product"%>

<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>
Product
</title></head>
<body>
<%ProductManager manager = (ProductManager)getServletContext().getAttribute("manager"); 
	List<Product> list = manager.getProducts();
	String id = request.getParameter("id");
	Product product = manager.getById(id);
%>
	<h1><%=product.getName() %></h1>
	<h2><%=id %></h2>
	<img src="store-images/<%=product.getImageL()%>"/>
	$<%=product.getPrice() %>
	<form action = "cart.jsp" method="POST">
	<input name="productID" type="hidden" value="<%=product.getID()%>"/>	
			<input type="submit" value="Add to cart"></form>	
</body>
</html>