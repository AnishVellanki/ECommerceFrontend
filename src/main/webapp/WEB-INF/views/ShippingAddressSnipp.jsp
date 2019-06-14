<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/css">
img {width:100%;}
</script>
<!------ Include the above in your HEAD tag ---------->

<title>Insert title here</title>
</head>
<body>

<section class="testimonial py-5" id="testimonial">
    <div class="container">
        <div class="row ">
            <div class="col-md-4 py-5 bg-primary text-white text-center ">
                <div class=" ">
                    <div class="card-body">
                        <img src="http://www.ansonika.com/mavia/img/registration_bg.svg" style="width:30%">
                        <h2 class="py-3">Shipment Address</h2>
                        <p>You are just a few steps away from placing your order. Fill in your shipment address and get the products at your door step
</p>
                    </div>
                </div>
            </div>
            <div class="col-md-8 py-5 border">
                <h4 class="pb-4">Please fill with your details</h4>
                <sform:form action="placedOrder" method="post" modelAttribute="order">
                
                    <div class="form-row">
                        <div class="form-group col-md-6">
                          <sform:input  class="form-control" path="doorNumber" required="required" placeholder="DoorNumber"/>
                        </div>
                        <div class="form-group col-md-6">
                            <sform:input  path="streetName" placeholder="StreetName" class="form-control" required="required" type="text"/>
                        </div>
                        <div class="form-group col-md-6">
                          <sform:input  path="orderId" placeholder="DoorNumber" class="form-control"  required="required" type="hidden"/>
                        </div>
                      </div>
                    <div class="form-row">
                        
                        <div class="form-group col-md-6">
                            <sform:input  path="state" placeholder="State" class="form-control" required="required" type="text"/>
                        </div>
                              <div class="form-group col-md-6">
                          <sform:input  class="form-control" required="required" path="city" placeholder="City"  />
                        </div>                 
                    </div>
                    <div class="form-row">
                        
                        <div class="form-group col-md-6">
                            <sform:input  path="zipcode" placeholder="Zipcode" class="form-control" required="required" type="text"/>
                        </div>
                              <div class="form-group col-md-6">
                          <sform:input  class="form-control" required="required" path="country" placeholder="Country"  />
                        </div>                 
                    </div>
                    
                    <div class="form-row">
                        <button type="submit" class="btn btn-danger">Submit</button>
                    </div>
                </sform:form>
            </div>
        </div>
    </div>
</section>

</body>
</html>