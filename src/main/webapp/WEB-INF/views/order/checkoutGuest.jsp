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
                        <li><a href="#">Payment</a></li>
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
                                <c:set var="userName" value="userGuest"/>
                                <c:set var="password" value="passwordGuest"/>
                                <form:form modelAttribute="currUser" method="post" action="createGuest" enctype="multipart/form-data">
                                    <form:errors path="*" cssClass="error" />
                                        <form:input path="firstName" placeholder="First Name"/>
                                        <form:errors path="firstName" element="div" cssClass="error" />
                                        <form:input path="lastName" placeholder="Last Name"/>
                                        <form:input path="address.street" placeholder="Street"/>
                                        <form:input path="address.city" placeholder="City"/>
                                        <form:input path="address.State" placeholder="State"/>
                                        <form:input path="address.zipcode" placeholder="Zip Code"/>
                                       <%--<form:input path="username" placeholder="${userName}"/>--%>
                                        <%--<form:errors path="username" element="div" cssClass="error" />--%>
                                        <%--<form:input path="password" placeholder="${password}"/>--%>
                                        <%--<form:errors path="password" element="div" cssClass="error" />--%>
                                       <select id="shipping" >
                                            <option>Standard (5-7 Bus Days) (Free)</option>
                                            <option>Second Day (2 Bus Days) ($15.00)</option>
                                            <option>Overnight Day (1 Bus Day) ($21.00)</option>
                                            
                                        </select><br/>
                                        <br/><br/>
                                        <h4><b> CONTACT INFO  </b></h4>
                                        <form:input path="phone" placeholder="Phone Number"/>
                                        <form:input path="email" placeholder="Email"/>
                                        <!--<input type="text" placeholder="Confirm Email"/>-->
                                        <button type="submit" class="btn btn-primary">SAVE AND GO TO PAYMENT</button>
                                    </form:form>
                                
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



        <c:import url="/layout/footer"/>
    </body>
</html>