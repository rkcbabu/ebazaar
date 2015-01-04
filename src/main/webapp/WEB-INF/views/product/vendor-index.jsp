<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
    <jsp:include page="/WEB-INF/views/includes/head.jsp"/>

    <body>
        <jsp:include page="/WEB-INF/views/includes/header.jsp"/>

        <section id="cart_items">
            <div class="container">
                <div class="breadcrumbs">
                    <ol class="breadcrumb">
                        <li><a href="<c:url value="/vendor"/>">Home</a></li>
                        <li class="active">Vendor Panel</li>
                    </ol>
                </div>
                <a class="btn btn-default update" href='<c:url value="/vendor/addproduct"/>'>Add Product</a>
                <hr>
                <div class="table-responsive cart_info">
                    <table class="table table-condensed">
                        <thead>
                            <tr class="cart_menu">
                                <!--<td class="image">Item</td>-->
                                <td class="description">Product Title</td>
                                <td class="price">Price</td>
                                <td class="quantity">Quantity</td>
                                <td class="total">Availability</td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${products}" var="product">
                                <tr>
<!--                                    <td class="cart_product">
                                        <a href=""><img src="../productpic/${product.id}" alt=""></a>
                                    </td>-->

                                    <td class="cart_description">
                                        <p>${product.name}</p>
                                    </td>
                                    <td class="cart_price">
                                        <!--<p>$59</p>-->
                                        <p>${product.price}</p>
                                    </td>
                                    <td class="cart_quantity">
                                        <p>${product.quantity}</p>
                                    </td>
                                    <td class="cart_total">
                                        <p>${product.availability}</p>
                                    </td>
                                    <td class="cart_delete">
                                        <a class="cart_quantity_button" href="<c:url value="/vendor/editproduct"/>/${product.id}" >
                                            <i class="fa fa-edit"></i></a>
                                        <a class="cart_quantity_delete" href=""  onclick="$(this).closest('form').submit();">
                                                <i class="fa fa-times"></i></a>
                                        <form action="<c:url value="/vendor/deleteproduct"/>/${product.id}" method="get" id="deleteForm">
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>


                        </tbody>
                    </table>
                </div>
            </div>
        </section> <!--/#cart_items-->



        <jsp:include page="/WEB-INF/views/includes/footer.jsp"/>
    </body>
</html>