<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
     <%@include file="userHeader.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link rel="stylesheet" href="resources/css/login.css" >
<!-- <script type="text/javascript" src="resources/Js/loginJs.js"></script> -->
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<section class="login-block">
    <div class="container">
	<div class="row">
		<div class="col-md-4 login-sec">
		    <h2 class="text-center">Login Now</h2>
		    <sform:form action="gologin" method="post" modelAttribute="login" class="login-form">
  <div class="form-group">
    <label for="exampleInputEmail1" class="text-uppercase">Email</label>
    <sform:input type="text" path="email" class="form-control" placeholder="" />
    
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1" class="text-uppercase">Password</label>
    <sform:input type="password" path="password" class="form-control" placeholder="" />
  </div>
  
  
    <div class="form-check">
    <label class="form-check-label">
      <input type="checkbox" class="form-check-input">
      <small>Remember Me</small>
    </label>
    <button type="submit" class="btn btn-login float-right">Submit</button>
    <a href="register">Register</a>
    <h3>${loginerror}</h3>
  </div>
  </sform:form>

<div class="copy-text">Created By <i class="fa fa-heart"></i> Anish Vellanki</div>
		</div>
		<div class="col-md-8 banner-sec">
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                 <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                  </ol>
            <div class="carousel-inner" role="listbox">
    <div class="carousel-item active">
      <img class="d-block img-fluid" src="https://static.pexels.com/photos/33972/pexels-photo.jpg" alt="First slide">
      <div class="carousel-caption d-none d-md-block">
        <div class="banner-text">
            <h2>ClothIt</h2>
            <p>Why step out, when the world is in front of you. At ClothIt buy branded merchandise at an exciting discount with zero delivery charges </p>
        </div>	
  </div>
    </div>
    <div class="carousel-item">
      <img class="d-block img-fluid" src="https://images.pexels.com/photos/7097/people-coffee-tea-meeting.jpg" alt="First slide">
      <div class="carousel-caption d-none d-md-block">
        <div class="banner-text">
            <h2>This is Heaven</h2>
            <p>Why step out, when the world is in front of you. At ClothIt buy branded merchandise at an exciting discount with zero delivery charges </div>	
    </div>
    </div>
    <div class="carousel-item">
      <img class="d-block img-fluid" src="https://images.pexels.com/photos/872957/pexels-photo-872957.jpeg" alt="First slide">
      <div class="carousel-caption d-none d-md-block">
        <div class="banner-text">
            <h2>This is Heaven</h2>
            <p>Why step out, when the world is in front of you. At ClothIt buy branded merchandise at an exciting discount with zero delivery charges </div>	
    </div>
  </div>
            </div>	   
		    
		</div>
	</div>
</div>
</section>
</body>
</html>