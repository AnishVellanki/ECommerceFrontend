<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="c" items="${orderList}">
<td>${c.userOrderId}</td>
<td>${c.date}</td>
<td>${c.grandTotal}</td>
<td>${c.user.address.streetName}</td>

</c:forEach>
</body>
</html>