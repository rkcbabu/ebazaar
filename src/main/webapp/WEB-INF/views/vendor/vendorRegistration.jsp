<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="/WEB-INF/views/includes/head.jsp" />
<body>
	<jsp:include page="/WEB-INF/views/includes/header.jsp" />

	<section id="form">
		<!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
				<h2> Vendor Registration</h2>
				
					<%-- <div class="login-form">	                   
						 <form name='loginForm'
							action="<c:url value='/j_spring_security_check' />" method='POST'>
							<form:input path="username" placeholder="Username"/>
							<input type='text' name='username' placeholder="Username">
							<input type='password' name='password' placeholder="Password">
							<form:password path="password" placeholder="password" />
							<span> <input type="checkbox" class="checkbox">
								Keep me signed in
							</span>
							<button type="submit" class="btn btn-default">Login</button>
						</form> 
					</div> --%>

				</div>
				
				<div class="col-sm-4">
					<div class="signup-form">
						
					<form:form commandName="user" method="post" action="/vendorRegistration">


							 <form:errors path="firstName" element="div" cssClass="error" />
							<form:input path="firstName" placeholder="vendor Name" />

						<%-- <form:errors path="lastName" element="div" cssClass="error" />
							<form:input path="lastName" placeholder="Last Name" /> --%>

							<form:errors path="username" element="div" cssClass="error" />
							<form:input path="username" placeholder="Username" />

							<form:errors path="password" element="div" cssClass="error" />
							<form:password path="password" placeholder="password" />

							<form:errors path="phone" element="div" cssClass="error" />
							<form:input path="phone" placeholder="Phone" />

							<form:errors path="email" element="div" cssClass="error" />
							<form:input path="email" placeholder="Email" />

							<form:errors path="address.street" element="div" cssClass="error" />
							<form:input path="address.street" placeholder="Street" />

							<form:errors path="address.city" element="div" cssClass="error" />
							<form:input path="address.city" placeholder="City" />

							<form:errors path="address.state" element="div" cssClass="error" />
							<form:input path="address.state" placeholder="State" />

					  <form:errors path="address.zipcode" element="div"
								cssClass="error" />
							<form:input path="address.zipcode" placeholder="Zipcode" />

							<button type="submit" class="btn btn-default">Signup</button>
						</form:form>
					</div>
				
				</div>
			</div>
		</div>
	</section>
	<!--/form-->


	<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
</body>
</html>