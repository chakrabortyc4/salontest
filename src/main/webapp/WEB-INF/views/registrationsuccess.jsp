<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="<c:url value="/resources/javaScript/utility.js" />"></script>
<script
	src="<c:url value="/resources/javaScript/dissableBackBotton.js" />"></script>
	
<link href="http://hayageek.github.io/jQuery-Upload-File/4.0.11/uploadfile.css" rel="stylesheet">
<script src="http://hayageek.github.io/jQuery-Upload-File/4.0.11/jquery.uploadfile.min.js"></script>
<style>
div.ex1 {
	padding: 50px 100px 0px 100px;
}

div.ex2 {
	padding: 0px 100px 10px 100px;
}

div.ex3 {
	padding: 50px 10px 0px 115px;
}

div.ex4 {
	padding: 0px 100px 10px 700px;
}

div.ex5 {
	padding: 0px 100px 10px 100px;
}
</style>




</head>
<body onload="dissableField(); dissablePayField();dissableImageArea();lockPage(); ">

	<div class="container">
		<div class="page-header">
			<h2>Example Page Header</h2>
		</div>
		<p></p>
		<p></p>
	</div>


<script type="text/javascript">
		var isDisabledAll = "${statue}";
</script>


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

	<!-- Start of row colour -->

	<div class="ex2">
		 <div class="page-header">
			  <h4>Colour</h4>
		 </div>
	</div>
	
	<div class="row">

	    <div class="col-sm-4">
			  <div class="ex2">
				   <div class="col-sm-12">
						<b>Title :</b><input id="titelcolour1" class="form-control" placeholder="Enter Title" value="${titel_color1}" 
						<c:if test="${not empty titel_color1 }">disabled="disabled"</c:if> />	  
				   </div>
			  </div>
			   <div class="ex3">
			   <c:choose>
					<c:when test="${empty titel_color1}">
				    <div id="upload_image_color1"></div>
				    </c:when>
					<c:otherwise>
				        <button type="button" class="btn btn-danger">Delete</button>
				    </c:otherwise>
				</c:choose>
			   </div>
		 </div>

		 <div class="col-sm-2">
              <img alt=" " id="col1img" style="float: left; width: 100px; height: 100px;" src="data:image/jpg;base64,<c:out value='${image_color1}'/>" />
	     </div>


		<div class="col-sm-4">
		     <div class="ex2">
				  <div class="col-sm-12">
					   <b>Title :</b><input id="titelcolour2" class="form-control" placeholder="Enter Title" value="${titel_color2}"
					   <c:if test="${not empty titel_color2 }">disabled="disabled"</c:if> />
				  </div>
			 </div> 
				
			 <div class="ex3">
			  <c:choose>
					<c:when test="${empty titel_color2}">
				     <div id="upload_image_color2"></div>
				    </c:when>
					<c:otherwise>
				        <button type="button" class="btn btn-danger">Delete</button>
				    </c:otherwise>
				</c:choose>
			 </div>
		</div>
		                               
		<div class="col-sm-2">
			 <img alt=" " id="col2img" style="float: left; width: 100px; height: 100px;" src="data:image/jpg;base64,<c:out value='${image_color2}'/>" />
		</div>
	</div>	
				
	<!-- End of row one of colour -->
	
	<!-- Start of row tow of colour -->

	<div class="ex2">
		 <div class="page-header">
			  <h4></h4>
		 </div>
	</div>

	<div class="row">

	    <div class="col-sm-4">
			  <div class="ex2">
				   <div class="col-sm-12">
						<b>Title :</b><input id="titelcolour3" class="form-control" placeholder="Enter Title" value="${titel_color3}" 
						<c:if test="${not empty titel_color3 }">disabled="disabled"</c:if>/>	  
				   </div>
			  </div>
			   <div class="ex3">
			   <c:choose>
					<c:when test="${empty titel_color3}">
				    <div id="upload_image_color3"></div>
				    </c:when>
					<c:otherwise>
				        <button type="button" class="btn btn-danger">Delete</button>
				    </c:otherwise>
				</c:choose>
			   </div>
		 </div>

		 <div class="col-sm-2">
              <img alt=" " id="col3img" style="float: left; width: 100px; height: 100px;" src="data:image/jpg;base64,<c:out value='${image_color3}'/>" />
	     </div>


		<div class="col-sm-4">
		     <div class="ex2">
				  <div class="col-sm-12">
					   <b>Title :</b><input id="titelcolour4" class="form-control" placeholder="Enter Title" value="${titel_color4}" 
					   <c:if test="${not empty titel_color4 }">disabled="disabled"</c:if>/>
				  </div>
			 </div> 
				
			 <div class="ex3">
				<c:choose>
					<c:when test="${empty titel_color4}">
				      <div id="upload_image_color4"></div>
				    </c:when>
					<c:otherwise>
				        <button type="button" class="btn btn-danger">Delete</button>
				    </c:otherwise>
				</c:choose>
			 </div>
		</div>
		                               
		<div class="col-sm-2">
			 <img alt=" " id="col4img" style="float: left; width: 100px; height: 100px;" src="data:image/jpg;base64,<c:out value='${image_color4}'/>" />
		</div>
	</div>		
	
	<!-- End of row tow -->
	<!-- End of row colour -->


	<!-- Start of row moncrome -->
	
	
	<div class="ex2">
		<div class="page-header">
			<h4></h4>
		</div>
	</div>
	
	
	<div class="ex2">
		<div class="page-header">
			<h4>Monocrome</h4>
		</div>
	</div>

	<div class="row">
		<div class="col-sm-4">
			<div class="ex2">
				<div class="col-sm-12">
					<input type="monoTitel1" class="form-control" id="monoTitel1"
						name="monoTitel1" placeholder="Enter Titel" required autofocus>
				</div>
			</div>
			<div class="ex3">
				<button type="button" class="btn">Select</button>
				<button type="button" class="btn btn-success">Upload</button>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<div class="col-sm-2">
			<!-- space for pto -->
		</div>
		<div class="col-sm-4">
			<div class="ex2">
				<div class="col-sm-12">
					<input type="monoTitel1" class="form-control" id="monoTitel1"
						name="monoTitel1" placeholder="Enter Titel" required autofocus>
				</div>
			</div>
			<div class="ex3">
				<button type="button" class="btn">Select</button>
				<button type="button" class="btn btn-success">Upload</button>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<div class="col-sm-2">
			<!-- space for pto -->
		</div>
	</div>
	<!-- End of row one -->

	<div class="ex2">
		<div class="page-header">
			<h4></h4>
		</div>
	</div>

	<div class="row">
		<div class="col-sm-4">
			<div class="ex2">
				<div class="col-sm-12">
					<input type="monoTitel1" class="form-control" id="monoTitel1"
						name="monoTitel1" placeholder="Enter Titel" required autofocus>
				</div>
			</div>
			<div class="ex3">
				<button type="button" class="btn">Select</button>
				<button type="button" class="btn btn-success">Upload</button>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<div class="col-sm-2">
			<!-- space for pto -->
		</div>
		<div class="col-sm-4">
			<div class="ex2">
				<div class="col-sm-12">
					<input type="monoTitel1" class="form-control" id="monoTitel1"
						name="monoTitel1" placeholder="Enter Titel" required autofocus>
				</div>
			</div>
			<div class="ex3">
				<button type="button" class="btn">Select</button>
				<button type="button" class="btn btn-success">Upload</button>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<div class="col-sm-2">
			<!-- space for pto -->
		</div>
	</div>
	<!-- End of row tow -->
	<!-- End of row moncrome -->


	<!-- Start of row Nature -->
	<div class="ex2">
		<div class="page-header">
			<h4></h4>
		</div>
	</div>
	<div class="ex2">
		<div class="page-header">
			<h4>Nature</h4>
		</div>
	</div>

	<div class="row">
		<div class="col-sm-4">
			<div class="ex2">
				<div class="col-sm-12">
					<input type="monoTitel1" class="form-control" id="monoTitel1"
						name="monoTitel1" placeholder="Enter Titel" required autofocus>
				</div>
			</div>
			<div class="ex3">
				<button type="button" class="btn">Select</button>
				<button type="button" class="btn btn-success">Upload</button>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<div class="col-sm-2">
			<!-- space for pto -->
		</div>
		<div class="col-sm-4">
			<div class="ex2">
				<div class="col-sm-12">
					<input type="monoTitel1" class="form-control" id="monoTitel1"
						name="monoTitel1" placeholder="Enter Titel" required autofocus>
				</div>
			</div>
			<div class="ex3">
				<button type="button" class="btn">Select</button>
				<button type="button" class="btn btn-success">Upload</button>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<div class="col-sm-2">
			<!-- space for pto -->
		</div>
	</div>
	<!-- End of row one -->

	<div class="ex2">
		<div class="page-header">
			<h4></h4>
		</div>
	</div>

	<div class="row">
		<div class="col-sm-4">
			<div class="ex2">
				<div class="col-sm-12">
					<input type="monoTitel1" class="form-control" id="monoTitel1"
						name="monoTitel1" placeholder="Enter Titel" required autofocus>
				</div>
			</div>
			<div class="ex3">
				<button type="button" class="btn">Select</button>
				<button type="button" class="btn btn-success">Upload</button>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<div class="col-sm-2">
			<!-- space for pto -->
		</div>
		<div class="col-sm-4">
			<div class="ex2">
				<div class="col-sm-12">
					<input type="monoTitel1" class="form-control" id="monoTitel1"
						name="monoTitel1" placeholder="Enter Titel" required autofocus>
				</div>
			</div>
			<div class="ex3">
				<button type="button" class="btn">Select</button>
				<button type="button" class="btn btn-success">Upload</button>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<div class="col-sm-2">
			<!-- space for pto -->
		</div>
	</div>
	<!-- End of row tow -->
	<!-- End of row Nature -->



	<!-- Start of row Travel -->
	<div class="ex2">
		<div class="page-header">
			<h4></h4>
		</div>
	</div>
	<div class="ex2">
		<div class="page-header">
			<h4>Travel</h4>
		</div>
	</div>

	<div class="row">
		<div class="col-sm-4">
			<div class="ex2">
				<div class="col-sm-12">
					<input type="monoTitel1" class="form-control" id="monoTitel1"
						name="monoTitel1" placeholder="Enter Titel" required autofocus>
				</div>
			</div>
			<div class="ex3">
				<button type="button" class="btn">Select</button>
				<button type="button" class="btn btn-success">Upload</button>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<div class="col-sm-2">
			<!-- space for pto -->
		</div>
		<div class="col-sm-4">
			<div class="ex2">
				<div class="col-sm-12">
					<input type="monoTitel1" class="form-control" id="monoTitel1"
						name="monoTitel1" placeholder="Enter Titel" required autofocus>
				</div>
			</div>
			<div class="ex3">
				<button type="button" class="btn">Select</button>
				<button type="button" class="btn btn-success">Upload</button>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<div class="col-sm-2">
			<!-- space for pto -->
		</div>
	</div>
	<!-- End of row one -->

	<div class="ex2">
		<div class="page-header">
			<h4></h4>
		</div>
	</div>

	<div class="row">
		<div class="col-sm-4">
			<div class="ex2">
				<div class="col-sm-12">
					<input type="monoTitel1" class="form-control" id="monoTitel1"
						name="monoTitel1" placeholder="Enter Titel" required autofocus>
				</div>
			</div>
			<div class="ex3">
				<button type="button" class="btn">Select</button>
				<button type="button" class="btn btn-success">Upload</button>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<div class="col-sm-2">
			<!-- space for pto -->
		</div>
		<div class="col-sm-4">
			<div class="ex2">
				<div class="col-sm-12">
					<input type="monoTitel1" class="form-control" id="monoTitel1"
						name="monoTitel1" placeholder="Enter Titel" required autofocus>
				</div>
			</div>
			<div class="ex3">
				<button type="button" class="btn">Select</button>
				<button type="button" class="btn btn-success">Upload</button>
				<button type="button" class="btn btn-danger">Delete</button>
			</div>
		</div>
		<div class="col-sm-2">
			<!-- space for pto -->
		</div>
	</div>
	<!-- End of row tow -->
	<!-- End of row Travel -->

	<!--<div class="ex2"><div class="page-header"><h4></h4> </div></div> -->

	<script type="text/javascript">
		var isDisabledPayment = "${size}";
	</script>


	<div class="ex2">
		<div class="page-header">
			<h4></h4>
		</div>
	</div>
	<div class="ex5">
		<div class="page-header">
			<h4>Payment Area</h4>
		</div>
	</div>

	<%-- <form:form id="mypayment_form" action="payment" method="post" --%>
	<form:form id="mypayment_form" action="payment" method="post" commandName="paymentDetail">
		
		<div class="col-sm-2"></div>
		<div class="col-sm-6">
			<div class="ex5">
				<div class="col-sm-12" required autofocus>
					<form:input path="couponCode" id="couponCodeId"
						class="form-control" placeholder="Enter coupon code if available" />
				</div>
			</div>
			<div class="ex5">
				<div class="col-sm-12">
					<!-- <input type="image" id="paySubmit" name="action" value="payment"
						src="<c:url value="/resources/image/pay.jpg" />" width="400"
						height="80" border="0" /> -->
						<a href='<c:url value="/payment/${payurl}" />'>Home</a>
						
				</div>
			</div>
			<div class="ex3">
				<div class="page-header">
					<h4></h4>
				</div>
			</div>
		</div>
	</form:form>


</body>
<script>
$(document).ready(function()
{
	$("#upload_image_color1").uploadFile({
	url:"json/saveimage",
	multiple:false,
	maxFileCount:1,
	fileName:"images",
	acceptFiles:"image/*",
	showPreview:true,
	previewHeight: "100px",
	previewWidth: "100px",
	allowedTypes:"jpg,jpeg",
	maxFileSize:20848820,
	formData: {"catagoryName":"color","positionName":"color1","action":"save"},
	dynamicFormData: function()
	{
		var title = $('#titelcolour1').val();
		return {"titel":title};
	},
	onSubmit:function(files)
	{
		$("#eventsmessage").html($("#eventsmessage").html()+"<br/>Submitting:"+JSON.stringify(files));
		//return false;
	}
	});
	
	$("#upload_image_color2").uploadFile({
		url:"json/saveimage",
		method:"post",
		multiple:false,
		maxFileCount:1,
		fileName:"images",
		acceptFiles:"image/*",
		showPreview:true,
		previewHeight: "100px",
		previewWidth: "100px",
		allowedTypes:"jpg,jpeg",
		maxFileSize:20848820,
		formData: {"catagoryName":"color","positionName":"color2","action":"save"},
		dynamicFormData: function()
		{
			var title = $('#titelcolour2').val();
			return {"titel":title};
		}
		});
	
	$("#upload_image_color3").uploadFile({
		url:"json/saveimage",
		multiple:false,
		maxFileCount:1,
		fileName:"images",
		acceptFiles:"image/*",
		showPreview:true,
		previewHeight: "100px",
		previewWidth: "100px",
		allowedTypes:"jpg,jpeg",
		maxFileSize:20848820,
		formData: {"catagoryName":"color","positionName":"color3","action":"save"},
		dynamicFormData: function()
		{
			var title = $('#titelcolour3').val();
			return {"titel":title};
		}
		});
	
	$("#upload_image_color4").uploadFile({
		url:"json/saveimage",
		multiple:false,
		maxFileCount:1,
		fileName:"images",
		acceptFiles:"image/*",
		showPreview:true,
		previewHeight: "100px",
		previewWidth: "100px",
		allowedTypes:"jpg,jpeg",
		maxFileSize:20848820,
		formData: {"catagoryName":"color","positionName":"color4","action":"save"},
		dynamicFormData: function()
		{
			var title = $('#titelcolour4').val();
			return {"titel":title};
		}
		});
	//delete button ajax call
	
});
</script>
</html>