<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <jsp:include page="/WEB-INF/views/includes/head.jsp"/>

    <body>
        <jsp:include page="/WEB-INF/views/includes/header.jsp"/>
        <section>
            <div class="container">
                <div class="row">
                    <c:if test="${not empty displaySidebar}">
                    <div class="col-sm-3" >
                        <div class="left-sidebar">
                            <h2>Category</h2>
                            <div class="panel-group category-products" id="accordian"><!--category-productsr-->
                                <c:forEach items="${categoryList}" var="category">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title"><a href="#">${category.name}</a></h4>
                                        </div>
                                    </div>
                                </c:forEach>      
                            </div><!--/category-products-->

                            <div class="brands_products"><!--brands_products-->
                                <h2>Brands</h2>
                                <div class="brands-name">
                                    <ul class="nav nav-pills nav-stacked">
                                        <c:forEach items="${vendorList}" var="vendor">
                                            <li><a href="#"> <!--<span class="pull-right">(50)</span>-->${vendor.firstName}</a></li>
                                            </c:forEach>
                                    </ul>
                                </div>
                            </div><!--/brands_products-->

                        </div>
                    </div>
                    </c:if>

                    <div class="<c:out value="${not empty displaySidebar? 'col-sm-9' :'col-sm-12'}"/> padding-right">
                        <div class="features_items"><!--features_items-->
                            <h2 class="title text-center">Features Items</h2>
                            <c:forEach items="${productList}" var="product">
                                <div class="col-sm-4">
                                    <div class="product-image-wrapper">
                                        <div class="single-products">
                                            <div class="productinfo text-center">
                                                <img src="<c:url value="/productpic"/>/${product.id}" alt="" />
                                                <h2>$ ${product.price}</h2>
                                                <p>${product.name}</p>
                                                <a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                            </div>
                                            <div class="product-overlay">
                                                <div class="overlay-content">
                                                    <h2>$ ${product.price}</h2>
                                                    <p>${product.name}</p>
                                                    <a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="choose">
                                            <ul class="nav nav-pills nav-justified">
                                                <li><a href="<c:url value="/product-details"/>/${product.id}">
                                                        <i class="fa fa-plus-square"></i>Product Details</a></li>
                                               <!--<li><a href="#"><i class="fa fa-plus-square"></i>Add to wishlist</a></li>-->
                                            </ul>
                                        </div>
                                    </div>
                                                    </div>
                                </c:forEach>
                            

                        </div><!--features_items-->


                    </div>
                </div>
            </div>
        </section>

        <jsp:include page="/WEB-INF/views/includes/footer.jsp"/>
    </body>
</html>