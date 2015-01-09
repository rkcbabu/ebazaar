<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
                        <li class="active">Check out</li>
                    </ol>
                </div><!--/breadcrums-->

                <div class="step-one">
                    <h1 class="heading"><span class="or-class" style="padding : 10px;">&nbsp1&nbsp</span>  SHIPPING</h1>
                </div>
                <div class="checkout-options">
                    <div class="shopper-informations">
                        <div class="row">
                            <div class="col-sm-5">
                                <div class="shopper-info">
                                    <p>WHERE CAN WE SHIP YOUR ORDER</p>
                                    <div class="order-message">
                                        <div style="background: #F0F0E9; border:0; color: #696763; padding: 5px; width: 100%; 
                                             border-radius: 0; box-shadow: 2px 2px 4px #1A1A1A;">
                                            <h3>Address</h3>
                                            <hr>
                                            <h3>${currUser.firstName} &nbsp ${currUser.lastName} </h3>
                                            <label>
                                                ${currUser.address.street}<br/>
                                                ${currUser.address.city},&nbsp ${currUser.address.state} <br/>
                                                ${currUser.address.zipcode}<br/>
                                                <a class="btn btn-default"  data-toggle="modal" data-target="#myModalAddress">Edit</a>
                                            </label>
                                        </div><br/>
                                        <script>
                                            $('#myModalAddress').on('shown.bs.modal', function () {
                                                $('#myInput').focus();
                                            });

                                        </script>
                                       
                                        <h3 style="color: black;">Credit Card</h3><br/>
                                        <div style="background: #F0F0E9; border:0; color: #696763; padding: 5px; width: 100%; 
                                             border-radius: 0; box-shadow: 2px 2px 4px #1A1A1A;">
                                            <h3>Default</h3>
                                            <hr>
                                            <h3>${currUser.card.type}</h3>
                                            <label>
                                                ${currUser.card.creditCardNo}<br/>
                                                <a class="btn btn-default"  data-toggle="modal" data-target="#myModalCard">Edit</a>
                                            </label>
                                        </div>
                                    </div>
                                        <a class="btn btn-default check_out" href="<c:url value="/placeOrder"/>">Place Order</a>
                                    <!--<b><a class="btn btn-primary" href="/placeOrder" data-selector>Place Order</a></b>-->
                                </div>
                            </div>
                            <div class="col-sm-7 clearfix">
                                <div class="review-payment">
                                    <h2>Review & Payment</h2>
                                </div>
                                <div class="table-responsive cart_info">
                                    <div style="background-color: #2F2F2F;color: #ADBAC8; margin-top: 0px;">
                                        <h1 style="padding-left: 20px;">ORDER SUMMARY</h1>
                                        <ul>

                                            <li>Cart Sub Total <span style="float: right; padding-right:20px;">$ <fmt:formatNumber type="number" 
                                                              maxFractionDigits="3" value="${totalPrice}" /></span></li>
                                            <li>Sales Tax <span style="float: right; padding-right:20px;">$ <fmt:formatNumber type="number" 
                                                              maxFractionDigits="3" value="${totalPrice*0.1}" /></span></li>
                                            <li>Shipping Cost <span style="float: right; padding-right:20px;">Free</span></li>
                                            <li><b>Total After Tax <span style="float: right; padding-right:20px;">$<fmt:formatNumber type="number" 
                                                              maxFractionDigits="3" value="${(totalPrice*0.1)+totalPrice}"/></span></b></li>
                                        </ul>
                                    </div>
                                    <table class="table table-striped" >
                                        <thead>
                                            <tr>
                                                <td class="image"></td>
                                                <td class="quantity"></td>
                                                <td class="total" style="float: right; text-decoration: underline;"><a href="<c:url value="/cart"/>">Edit Cart</td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${cart.orderItems}" var="item">
                                                <tr style="height: 80px;">
                                                    <td class="cart_product">
                                                        <a href=""><img  style="height: 100px; width: 100px;" src="<c:url 
                                                                             value="/productpic/"/>${item.product.id}" alt=""></a>
                                                    </td>
                                                    <td class="quantity" style="width: 200px;">
                                                        <h4><a href="">${item.product.name}</a></h4>
                                                        <p>Web ID: ${item.product.productID}<br/>
                                                            Qty: ${item.quantity}<br/>
                                                            $${item.product.price}</p>
                                                    </td>


                                                    <td class="cart_total">
                                                        <p class="cart_total_price">$${item.product.price*item.quantity}</p>
                                                    </td>

                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>

                <div class="payment-options">
                </div>
            </div>
        </section> <!--/#cart_items-->

        <!-- Modal -->
        <div class="modal fade" id="myModalAddress" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <!--<h4 class="modal-title" id="myModalLabel">Modal title</h4>-->
                        <h5>RETURN CUSTOMERS</h5>  
                        <span style="font-size: 9px; float: left; font-weight: bold;"> Sign in now to check out using your saved info</span>
                    </div>
                    <div class="modal-body">
                        <div class="login-form" style="float: left">

                            <form:form method="POST" action= "updateAdd/${currUser.id}" commandName="currUser" modelAttribute="currUser">
                                <form:errors element="div" cssClass="errors" path="*"/>
                                <form:input path="address.street" placeholder="Street"/>
                                <form:input path="address.city" placeholder="City"/>
                                <form:input path="address.state" placeholder="State"/>
                                <form:input path="address.zipcode" placeholder="Zipcode"/>
                                <button type="submit" class="btn btn-primary">Update</button>
                                <!--<button type="submit" class="btn btn-primary">Cancel</button>-->
                                <a href="<c:url value="/checkout"/>" class="btn btn-primary">Cancel</a>
                            </form:form>

                        </div>


                    </div>
                    <div class="modal-footer">
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="myModalCard" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <!--<h4 class="modal-title" id="myModalLabel">Modal title</h4>-->
                        <h5>RETURN CUSTOMERS</h5>  
                        <span style="font-size: 9px; float: left; font-weight: bold;"> Edit/Add Card</span>
                    </div>
                    <div class="modal-body">
                        <div class="login-form" style="float: left">
                               
                                 <form:form method="POST" action= "updateCard/${currUser.id}" commandName="currUser" modelAttribute="currUser">
                                <form:errors element="div" cssClass="errors" path="*"/>
                                    <form:input path="card.type" placeholder="Card Type" />
                                    <form:input path="card.creditCardNo" placeholder="Card Number" />
                                    <form:input path="card.cardCV" placeholder="CVC" />
                                    <form:input path="card.expiryDate" placeholder="Expiration" />
                                    Billing Address
                                    <form:input path="firstName" placeholder="First Name" />
                                    <form:input path="lastName" placeholder="Last Name" />
                                    <form:input path="address.street" placeholder="Street"/>
                                    <form:input path="address.city" placeholder="City"/>
                                    <form:input path="address.state" placeholder="State"/>
                                    <form:input path="address.zipcode" placeholder="Zipcode"/>
                               
                                <button type="submit" class="btn btn-primary">Update</button>
                                <a href="<c:url value="/checkout"/>" class="btn btn-primary">Cancel</a>
                            </form:form>
                                 

                        </div>


                    </div>
                    <div class="modal-footer">
                         </div>
                </div>
            </div>
        </div>


        <c:import url="/layout/footer"/>
    </body>
</html>