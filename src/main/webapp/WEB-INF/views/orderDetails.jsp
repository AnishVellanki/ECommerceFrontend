<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Order Data</h1>
<table  border="1">
<tr>
<th>
Order Date
</th>
<th>
User Email
</th>
<th>
Grand Total
</th>
<th>
Address
</th>
</tr>
<sform:form modelAttribute="userData" >

<td>${userData.date}</td>
<td>${userData.user.email}</td>
<td>${userData.grandTotal}</td>
<td></td>
</sform:form>
</body>
</html>