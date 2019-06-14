<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
<sform:form action="addSupplier" method="post" modelAttribute="addSup">
<h1 style="color: #FFFFFF">${form}<h1>
 <sform:input  path="supplierName" placeholder="Supplier Name" cssClass="name"  />
  <sform:input  path="supplierDescription" placeholder="Supplier Description" cssClass="email" />
 <sform:input  path="supplierId" placeholder="Supplier Id" cssClass="email" type="hidden"/>
<input type="submit"  value="${button}" class="btn" />
</sform:form>
</body>
</html>