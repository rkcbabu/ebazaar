<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="/WEB-INF/views/includes/head.jsp" />

<body>
	<jsp:include page="/WEB-INF/views/includes/header.jsp" />

	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li class="active">Vendor Add Product</li>
				</ol>
			</div>

		</div>

		
			<form:form method="POST" action="./addproduct"
				enctype="multipart/form-data" commandName="product">
				<%--<form:errors element="div" cssClass="errors" path="*"/>--%>

				<form:input path="productID" placeholder="Product Id" />
				<form:input path="name" placeholder="Product Name" />
				<form:input path="quantity" placeholder="quantity" />
				<form:input path="price" placeholder="price" />
				<form:input path="availability" placeholder="availability" />
				<input type="file" name="file" id="file" />

				<button type="submit" class="btn btn-default">Signup</button>
			</form:form>



	</section>
	<!--/#cart_items-->

	<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
</body>
</html>