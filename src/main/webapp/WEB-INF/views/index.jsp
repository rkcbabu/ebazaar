<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<c:import url="/layout/head"/>
    <body>
        <c:import url="/layout/header"/>
        <section>
            <div class="container">
                <div class="row">
                    <c:import url="/layout/sidebar"/>

                    <div class="col-sm-9 padding-right">
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
                                                <a href="<c:url value="/addtocart"/>/${product.id}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                            </div>
                                            <div class="product-overlay">
                                                <div class="overlay-content">
                                                    <h2>$ ${product.price}</h2>
                                                    <p>${product.name}</p>
                                                    <a href="<c:url value="/addtocart"/>/${product.id}" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
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
        <c:import url="/layout/footer"/>
    </body>
</html>