<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                        <li class="active">Shopping Cart</li>
                    </ol>
                </div>
                <div class="chose_area">
                    <a class="btn btn-default check_out" href="<c:url value="/"/>">Continue Shopping</a>
                    <button type="button" class="btn btn-default check_out pull-right" data-toggle="modal" data-target="#myModal" >
                                Checkout
                            </button>
<!--                    <a class="btn btn-default check_out" href="<c:url value="/checkout"/>">Checkout</a>-->
                </div>
                <hr>

                <div class="table-responsive cart_info">
                    <table class="table table-condensed">
                        <thead>
                            <tr class="cart_menu">
                                <td class="image">Item</td>
                                <td class="description"></td>
                                <td class="price">Price</td>
                                <td class="quantity">Quantity</td>
                                <td class="total">Total</td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${cart.orderItems}" var="item">
                                <tr>
                                    <td class="cart_product">
                                        <a href=""><img  style="height: 100px; width: 100px;" src="<c:url 
                                                             value="/productpic/"/>${item.product.id}" alt=""></a>
                                    </td>
                                    <td class="cart_description">
                                        <h4><a href="">${item.product.name}</a></h4>
                                        <p>Web ID: ${item.product.productID}</p>
                                    </td>
                                    <td class="cart_price">
                                        <p>US$ ${item.product.price}</p>
                                    </td>
                                    <td class="cart_quantity">
                                        <div class="cart_quantity_button">
                                            <a class="cart_quantity_up" href=""> + </a>
                                            <input class="cart_quantity_input" type="text" name="quantity" 
                                                   value="${item.quantity}" autocomplete="off" size="2">
                                            <a class="cart_quantity_down" href=""> - </a>
                                        </div>
                                    </td>
                                    <td class="cart_total">
                                        <p class="cart_total_price">${item.product.price*item.quantity}</p>
                                    </td>
                                    <td class="cart_delete">
                                        <a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </section> <!--/#cart_items-->

        <section id="do_action">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 pull-right">
                        <div class="total_area">
                            <ul>
                                <li>Cart Sub Total <span>$ <fmt:formatNumber type="number" 
                                                  maxFractionDigits="3" value="${totalPrice}" /></span></li>
                                <li>Sales Tax <span>$ <fmt:formatNumber type="number" 
                                                  maxFractionDigits="3" value="${totalPrice*0.1}" /></span></li>
                                <li>Shipping Cost <span>Free</span></li>
                                <li>Total <span>$<fmt:formatNumber type="number" 
                                                  maxFractionDigits="3" value="${(totalPrice*0.1)+totalPrice}"/></span></li>
                            </ul>
                            <script>
                                $('#myModal').on('shown.bs.modal', function () {
                                    $('#myInput').focus();
                                });

                            </script>
<!--                            <a  class="btn btn-default check_out pull-right" ata-toggle="modal" data-target="#myModal"
                                href="<c:url value="/checkout"/>">Checkout</a>
                            -->
                            <!-- Button trigger modal -->
                            <button type="button" class="btn btn-default check_out pull-right" data-toggle="modal" data-target="#myModal" >
                                Checkout
                            </button>

                            <!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <!--<h4 class="modal-title" id="myModalLabel">Modal title</h4>-->
                                             <h5>RETURN CUSTOMERS</h5>  
                                             <span style="font-size: 9px; float: left; font-weight: bold;"> Sign in now to check out using your saved info</span>
                                        </div>
                                        <div class="modal-body">
                                            <div class="login-form" style="width: 49%; float: left">
                                               
                                                
                                               <form name='loginForm'
							action="<c:url value='/j_spring_security_check' />" method='POST'>
							<%--<form:input path="username" placeholder="Username"/>--%>
							<input type='text' name='username' placeholder="Username">
							<br/>
                                                        <input type='password' name='password' placeholder="Password">
							<%--<form:password path="password" placeholder="password" />--%>
							
							<button type="submit" class="btn btn-default">Login</button>
						</form> 
                                        </div>
                                                        <div style="width: 49%; float: left; padding-left: 10px; text-align: center;">
                                                            <h5>GUESTS</h5>  
                                                            <span>
                                                                check out fast and secure. You can create and account later.
                                                            </span>
                                                             <a  class="btn btn-default check_out" href="<c:url value="/checkout"/>">Continue</a>
                                                        </div>
                                        
                                        </div>
                                        <div class="modal-footer">
<!--                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-primary">Save changes</button>-->
                                        </div>
                                    </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </section><!--/#do_action-->

        <c:import url="/layout/footer"/>
    </body>
</html>