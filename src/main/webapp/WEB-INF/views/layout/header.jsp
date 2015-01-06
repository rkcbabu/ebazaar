<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib  prefix="sec" uri="http://www.springframework.org/security/tags" %>
<header id="header"><!--header-->
    <div class="header_top"><!--header_top-->
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <div class="contactinfo">
                        <ul class="nav nav-pills">
                            <li><a href="#"><i class="fa fa-phone"></i> +2 95 01 88 821</a></li>
                            <li><a href="#"><i class="fa fa-envelope"></i> info@ebazaar.com</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="social-icons pull-right">
                        <ul class="nav navbar-nav">
                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                            <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                            <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div><!--/header_top-->

    <div class="header-middle"><!--header-middle-->
        <div class="container">
            <div class="row">
                <div class="col-sm-4">
                    <div class="logo pull-left">
                        <a href="<c:url value="/"/>"><span>E</span>-bazaar</a>
                    </div>
                </div>
                <div class="col-sm-8">
                    <div class="shop-menu pull-right">
                        <ul class="nav navbar-nav">

                            <c:if test="${pageContext.request.userPrincipal.name != null}">
                                <li><a href="<c:url value="/profile"/>">
                                        <i class="fa fa-user"></i>${pageContext.request.userPrincipal.name}</a>
                                </li>
                            </c:if>
                            <!--<li><a href="#"><i class="fa fa-star"></i> Wishlist</a></li>-->
                            <li><a href="<c:url value="/template/checkout"/>"><i class="fa fa-crosshairs"></i>Checkout</a></li>
                            <li><a href="<c:url value="/cart"/>"><i class="fa fa-shopping-cart"></i>Cart
                                    <c:if test="${not empty cartItemCount}">
                                        (${cartItemCount})
                                    </c:if></a>
                            </li>

                            <li><c:if test="${pageContext.request.userPrincipal.name != null}">
                                    <form action="<c:url value="/j_spring_security_logout"/>" method="post" id="logoutForm">
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                    </form>
                                    <a onclick="document.getElementById('logoutForm').submit()" href="#"><i class="fa fa-lock"></i>Logout</a>


                                </c:if>
                                <c:if test="${pageContext.request.userPrincipal.name == null}">
                                    <a href="<c:url value="/login"/>"><i class="fa fa-lock"></i> Sign in</a>
                                </c:if>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div><!--/header-middle-->

    <div class="header-bottom"><!--header-bottom-->
        <div class="container">
            <div class="row">
                <div class="col-sm-9">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>
                    <div class="mainmenu pull-left">
                        <ul class="nav navbar-nav collapse navbar-collapse">
                            <li>
                                <c:if test="${pageContext.request.userPrincipal != null}" >
                                    <sec:authorize access="hasRole('ROLE_VENDOR')">
                                        <a href="<c:url value="/vendor"/>" class="active">Home</a>
                                    </sec:authorize>
                                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                                        <a href="<c:url value="/admin"/>" class="active">Home</a>
                                    </sec:authorize>
                                    <sec:authorize access="hasRole('ROLE_CUSTOMER')">
                                        <a href="<c:url value="/profile"/>" class="active">Home</a>
                                    </sec:authorize>
                                </c:if>
                                <c:if test="${pageContext.request.userPrincipal == null}" >
                                    <a href="<c:url value="/"/>" class="active">Home</a>
                                </c:if>
                            </li>
                            <li class="dropdown"><a href="#">Shop<i class="fa fa-angle-down"></i></a>
                                <ul role="menu" class="sub-menu">
                                    <li><a href="<c:url value="/shop"/>">Products</a></li>
                                    <li><a href="<c:url value="/product-details"/>">Product Details</a></li> 
                                    <li><a href="<c:url value="/template/checkout"/>">Checkout</a></li> 
                                    <li><a href="<c:url value="/cart"/>">Cart</a></li> 
                                    <li><a href="<c:url value="/login"/>">Login</a></li> 
                                </ul>
                            </li> 
                            <li class="dropdown"><a href="#">Blog<i class="fa fa-angle-down"></i></a>
                                <ul role="menu" class="sub-menu">
                                    <li><a href="<c:url value="/blog"/>">Blog List</a></li>
                                    <li><a href="<c:url value="/blog-single"/>">Blog Single</a></li>
                                </ul>
                            </li> 
                            <li><a href="<c:url value="/page404"/>">404</a></li>
                            <li><a href="<c:url value="/contact-us"/>">Contact</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="search_box pull-right">
                        <input type="text" placeholder="Search"/>
                    </div>
                </div>
            </div>
        </div>
    </div><!--/header-bottom-->
</header><!--/header-->