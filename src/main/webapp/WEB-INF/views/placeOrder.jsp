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
<h1>Fill up the details to continue checkout</h1>
<sform:form action="placeOrder" method="post" modelAttribute="order">

<sform:input path="orderId" placeholder="DoorNumber" type="hidden" />
<sform:input path="doorNumber" placeholder="DoorNumber" />
<sform:input  path="streetName" placeholder="StreetName"  />
  <sform:input  path="city" placeholder="City"  />
<sform:input  path="state" placeholder="State"  />
<sform:input  path="country" placeholder="Country" />
<sform:input  path="zipcode" placeholder="Zipcode"  />
<input type="submit"  value="Submit" class="btn" />
 </sform:form>

</body>
</html>