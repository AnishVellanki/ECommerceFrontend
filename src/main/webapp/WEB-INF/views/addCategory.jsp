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
<sform:form action="addCategory" method="post" modelAttribute="cat">
<sform:input path="categoryName" placeholder="Category Name" />
<sform:input  path="categoryDescription" placeholder="Category Description"  />
  <sform:input  path="categoryId" placeholder="Category Id"  type="hidden"/>
<input type="submit"  value="${button}" class="btn" />

 </sform:form>
</body>
</html>