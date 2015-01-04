<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>

	<meta charset="utf-8">
	<!--[if IE]>
		<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
	<![endif]-->
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<title>Grocery Shoppe Stores - Bootstrap 3 Template</title>
	<base href='<c:url value="/"/>' />
        
	<!-- Bootstrap Core CSS -->
	<link href="resources/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- Google Web Fonts -->
	<link href="http://fonts.googleapis.com/css?family=Roboto+Condensed:300italic,400italic,700italic,400,300,700" rel="stylesheet" type="text/css">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
	
	<!-- CSS Files -->
	<link href="resources/font-awesome/css/font-awesome.min.css" rel="stylesheet">
	<link href="resources/css/owl.carousel.css" rel="stylesheet">
	<link href="resources/css/style.css" rel="stylesheet">
	<link href="resources/css/responsive.css" rel="stylesheet">
	
	<!--[if lt IE 9]>
		<script src="resources/js/ie8-responsive-file-warning.js"></script>
	<![endif]-->
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	
	
</head>
<body>
<!-- Wrapper Starts -->
	
	<!-- Header Section Starts -->
        <%@include file="../header.jsp" %>
        <h1>List of Customers</h1>
        <table id="tablelist" border="1">
            <tr><th>ID</th><th>Name</th><th>Email</th><th>ContactNumber</th><th>Date</th><th>Credit Card Number</th><th>Expiration Date</th><th>CVV2</th><th>Card Holder Name</th><th>Address1</th><th>Address2</th><th>City</th><th>State</th><th>zipCode</th></tr>
                    <c:forEach items="${customers}" var="customer">
                <tr><td>${customer.id}</td> <td>${customer.customerName}</td><td>${customer.customerEmail}</td>
                    <td>${customer.customerContact}</td>
                    <td>${customer.creationDate}</td>
                    <td>${customer.customerCreditCardNumber}</td>
                    <td>${customer.expirationDate}</td>
                    <td>${customer.cvv2}</td>
                    <td>${customer.cardHolderName}</td>
                    <td>${customer.address1}</td>
                    <td>${customer.address2}</td>
                    <td>${customer.city}</td>
                    <td>${customer.state}</td>
                    <td>${customer.zipcode}</td>
                    <td><a href="customer/edit/${customer.id}">Edit</a></td><td><a href="customer/delete/${customer.id}">Delete</a></td></tr>
                    </c:forEach>          
            
        </table>
        
     <%@include file="../footer.jsp" %>
	<!-- Footer Section Ends -->		
	
<!-- Wrapper Ends -->
<!-- Copyright Area Starts -->
<%@include file="../foot.jsp" %>
</body>
</html>

        
        