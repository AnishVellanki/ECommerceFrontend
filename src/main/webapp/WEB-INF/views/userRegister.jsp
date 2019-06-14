<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>
    <%@include file="userHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sform:form action="addregdata" method="post" modelAttribute="reg">
 <sform:input  path="userName" placeholder="User Name"  />
<sform:input  path="email" placeholder="Email Id"  />
<sform:input  path="password" placeholder="Password"  />
<sform:input  path="mobileNo" placeholder="Mobile Number"  />
<sform:input  path="address.doorNumber" placeholder="doorNumber"  />
<sform:input  path="address.streetName" placeholder="StreetName"  />
<sform:input  path="address.city" placeholder="City"  />
<sform:input  path="address.state" placeholder="State"  />
<sform:input  path="address.country" placeholder="Country"  />
<sform:input  path="address.zipcode" placeholder="Zipcode"  />
<input type="submit"  value="Register" class="btn" />
</sform:form>
</body>
</html>