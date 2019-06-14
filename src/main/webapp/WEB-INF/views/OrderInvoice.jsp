<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<script type="text/css">
.invoice-title h2, .invoice-title h3 {
    display: inline-block;
}

.table > tbody > tr > .no-line {
    border-top: none;
}

.table > thead > tr > .no-line {
    border-bottom: none;
}

.table > tbody > tr > .thick-line {
    border-top: 2px solid;
}
</script>
<title>Insert title here</title>
</head>
<body>


<div class="container">
<sform:form modelAttribute="userData" >
    <div class="row">
        <div class="col-xs-12">
    		<div class="invoice-title">
    			<h2>Invoice</h2><h3 class="pull-right">Order # 12345</h3>
    		</div>
    		<hr>
    		<div class="row">
    			<div class="col-xs-6">
    				<address>
    				<strong>Billed To:</strong><br>
    					${userData.user.userName}<br>
    					${userData.shippingAddress.doorNumber}<br>
 						${userData.shippingAddress.streetName}<br>
						${userData.shippingAddress.city}<br>
						${userData.shippingAddress.state}<br>
						${userData.shippingAddress.country}<br>
						${userData.shippingAddress.zipcode}
 						   			
    					
     			</address>
    			</div>
    			<div class="col-xs-6 text-right">
    				<address>
        			<strong>Shipped To:</strong><br>
    					${userData.user.userName}<br>
    					${userData.shippingAddress.doorNumber}<br>
 						${userData.shippingAddress.streetName}<br>
						${userData.shippingAddress.city}<br>
						${userData.shippingAddress.state}<br>
						${userData.shippingAddress.country}<br>
						${userData.shippingAddress.zipcode}

    				</address>
    			</div>
    		</div>
    		<div class="row">
    			<div class="col-xs-6">
    				<address>
    					<strong>Payment Method:</strong><br>
    					Visa ending **** 4242<br>
    					${userData.user.email}@gmail.com
    				</address>
    			</div>
    			<div class="col-xs-6 text-right">
    				<address>
    					<strong>Order Date:</strong><br>
    					${userData.date}<br><br>
    				</address>
    			</div>
    		</div>
    	</div>
    </div>
   
    <div class="row">
    	<div class="col-md-12">
    		<div class="panel panel-default">
    			<div class="panel-heading">
    				<h3 class="panel-title"><strong>Order summary</strong></h3>
    			</div>
    			<div class="panel-body">
    				<div class="table-responsive">
    					<table class="table table-condensed">
    						<thead>
                                <tr>
        							<td><strong>Item</strong></td>
        							<td class="text-center"><strong>Price</strong></td>
        							<td class="text-center"><strong>Quantity</strong></td>
        							<td class="text-right"><strong>Totals</strong></td>
                                </tr>
    						</thead>
    						<c:forEach var="c" items="${cartList}">
    						<tbody>
    							<!-- foreach ($order->lineItems as $line) or some such thing here -->
    							
    							<tr>
    								<td>${c.productName}</td>
    								<td class="text-center">${c.productPrice}</td>
    								<td class="text-center">${c.quantity}</td>
    								<td class="text-right">${c.totalPrice}</td>
    							</tr>
    							</c:forEach>
    							
    							<tr>
    								<td class="no-line"></td>
    								<td class="no-line"></td>
    								<td class="no-line text-center"><strong>Total</strong></td>
    								<td class="no-line text-right"><strong>${userData.grandTotal}</strong></td>
    							</tr>
    						</tbody>
    							    					</table>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
     </sform:form>
</div>
</body>
</html>