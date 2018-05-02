<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
 <style>

div.ex1 {
    padding: 50px 100px 0px 100px;
}

div.ex2 {
    padding: 0px 100px 10px 100px;
}

div.ex3 {
    padding: 50px 100px 0px 115px;
}

div.ex4 {
    padding: 50px 0px 10px 0px;
}

div.ex5 {
    padding: 0px 0px 30px 0px;
}
div.ex6 {
    padding: 50px 100px 0px 90px;
}


.cellContainer {
  width: 25%;
  float: left;
}
</style>

 
</head>
<body>

<div class="container">
  <div class="page-header">
    <h2>Example Page Header</h2>      
  </div>
  <p></p>      
  <p></p>      
</div>

<div class="container">
  <h4></h4>
  <ul class="nav nav-tabs">
    <li class="active"><a href="#">Home</a></li>
    <li class="dropdown">
      <a class="dropdown-toggle" data-toggle="dropdown" href="#">Menu 1 <span class="caret"></span></a>
      <ul class="dropdown-menu">
        <li><a href="#">Submenu 1-1</a></li>
        <li><a href="#">Submenu 1-2</a></li>                       
      </ul>
    </li>
	<li><a href="#">User Data </a></li>
	<li><a href="#">Entry Status</a></li>
	<li><a href="#">Download</a></li>   
    <li><a href="#">Contuct Us</a></li>
  </ul>
</div>

<div class="ex1">
		<div class="well">
			<h4>
				<c:out value="${sucessMagssage}" />
			</h4>
			<div
				style="float: right; font-size: 120%; position: relative; top: -10px">
				<a href="<%=request.getContextPath()%>/logout"> Log Out </a>
			</div>
		</div>
	</div>

<div class="container">  
  <div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" href="#collapse1">Create Coupon Code</a>
        </h4>
      </div>
   <div id="collapse1" class="panel-collapse collapse">
  <div class="row">
 <form:form  action="createCoupon" method="post" commandName="couponCode">
       
	   
      <div class="col-sm-6">
	   <div class="ex3">	  
       <form:select class="form-control" path="clubData" items="${clubDataList}" />
       
        
             <input type="text" class="form-control" id="persent" name="persent" placeholder="Enter discount persent(%)" required="autofocus"/>                                        
            
		<div style="color: red"> ${clubcouponCodeError} </div>
		<div class="ex6">
		<label class="btn btn-danger">Submit<input type="submit" id="creatrColubcouponcode" style="display: none;" name="action" value="createClubCoupon"  /></label>
		</div>
		<div class="ex5"></div>
	   </div>
	   </div>
	   </form:form>
	  <form:form  action="createCoupon" method="post" commandName="couponCode">
	   <div class="col-sm-6">
	   <div class="ex3">
	   <div class="form-group">
    		
    		<div class=style="margin-bottom: 25px" class="form-group col-md-12 redplaceholder">
    			<input type="text" class="form-control" id="userId" name="userId" placeholder="Enter perticipant id" required="autofocus">
    		</div>
    		 <div class="cellContainer"></div>
    		 <div style="margin-bottom: 25px" class="form-group col-md-12 redplaceholder"> 
             <input type="text" class="form-control" id="persent" name="persent" placeholder="Enter discount persent(%)" required="autofocus"/>                                        
            </div>
            
    	</div>
    	<div style="color: red"> ${couponCodeError} </div>
		 <label class="btn btn-danger">Submit<input type="submit" id="creatrsinglecouponcode" style="display: none;" name="action" value="createSigle"  /></label>
		<div class="ex5"></div>
	   </div>
	   </div>
	   
         <!--end of row -->
        </form:form>
        </div>
      </div>          
    </div>
  </div>
</div>



</body>
</html>