<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
    <c:import url="/layout/head"/>

    <body>
        <c:import url="/layout/header"/>

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
                                <td class="image">Product</td>
                                <td class="description">Title</td>
                                <td class="price">Price</td>
                                <td class="quantity">Quantity</td>
                                <td class="total">Availability</td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${products}" var="product">
                                <tr>
                                    <td class="cart_product">
                                        <!--<a href="">-->
                                            <img style="height: 100px; width: 100px;" src="<c:url value="/productpic/"/>${product.id}" alt="">
                                        <!--</a>-->
                                    </td>

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
                                        <a class="cart_quantity_delete" href="#"  onclick='$("#FormId${product.id}").submit()'>
                                                <i class="fa fa-times"></i></a>
                                        <form id="FormId${product.id}" action="<c:url value="/vendor/deleteproduct"/>" method="post">
                                            <input type="hidden" name="productId" value="${product.id}"/>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>


                        </tbody>
                    </table>
                </div>
            </div>
        </section> <!--/#cart_items-->



        <c:import url="/layout/footer"/>
    </body>
</html>