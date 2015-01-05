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
                <div class="row">
                    <div class="col-sm-3">
                        <div class="shopper-info">
                            <p>Edit  Product</p>
                            <form:form method="POST" action= "../editproduct/${product.id}"
                                       enctype="multipart/form-data" commandName="product">
                                <form:errors element="div" cssClass="errors" path="*"/>
                                <form:input path="productID" placeholder="Product Id" />
                                <form:input path="name" placeholder="Product Name" />
                                <form:input path="quantity" placeholder="quantity" />
                                <form:input path="price" placeholder="price" />
                                <form:select path="availability"  >
                                    <%--<form:option value="NONE" label="--- Availability ---"/>--%>
                                    <form:option value="YES" />
                                    <form:option value="NO" />
                                </form:select>
                                
                                 <hr>
                                <form:select path="category.id">
                                <%--<form:option value="NONE" label="--- Select category ---"/>--%>
                                    <form:options items="${categoryList}" itemValue="id" itemLabel="name"/>
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

                <jsp:include page="/WEB-INF/views/includes/footer.jsp" />
                </body>
                </html>