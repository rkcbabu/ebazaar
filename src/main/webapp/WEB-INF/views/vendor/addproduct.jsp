<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<c:import url="/layout/head"/>

<body>
	<c:import url="/layout/header"/>

	<section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li class="active">Vendor Add Product</li>
				</ol>
			</div>


			<div class="row">
				<div class="col-sm-3">
					<div class="shopper-info">
						<p>Add New Product</p>
						<form:form method="POST" action="../vendor/addproduct"
							enctype="multipart/form-data" commandName="product">

							<form:errors element="div" cssClass="errors" path="productID" />
							<form:input path="productID" placeholder="Product Id" />

							<form:errors element="div" cssClass="errors" path="name" />
							<form:input path="name" placeholder="Product Name" />

							<form:errors element="div" cssClass="errors" path="quantity" />
							<form:input path="quantity" placeholder="quantity" />

							<form:errors element="div" cssClass="errors" path="price" />
							<form:input path="price" placeholder="price" />


							<form:select path="availability">
								<%-- <form:option value="NONE" label="--- Availability ---" /> --%>
								<form:option value="YES" />
								<form:option value="NO" />
							</form:select>
							<hr>


							<form:select path="category.id">
								<%-- <form:option value="NONE" label="--- Select category ---" /> --%>
								<form:options items="${categoryList}" itemValue="id"
									itemLabel="name" />
							</form:select>
							<hr>


							<input type="file" name="file" id="file" />
							<button type="submit" class="btn btn-primary">Save</button>
						</form:form>
					</div>
				</div>

			</div>

			<hr>
	</section>
	<!--/#cart_items-->

	<c:import url="/layout/footer"/>
</body>
</html>