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
                <!--                <div class="breadcrumbs">
                                    <ol class="breadcrumb">
                                        <li><a href="#">Home</a></li>
                                        <li class="active">Check out</li>
                                        <li><a href="#">Payment</a></li>
                                    </ol>
                                </div>/breadcrums-->


                <div class="checkout-options">
                    <div class="shopper-informations">
                        <div class="row">
                            <div class="col-sm-7">
                                <div class="step-one">
                                    <h1 class="heading"><span class="or-class" style="padding : 10px;">&nbsp1&nbsp</span>  SHIPPING</h1>
                                </div><hr>
                                <div class="shopper-info">
                                    <p>WHERE CAN WE SHIP YOUR ORDER</p>
                                    <div class="order-message col-sm-6">
                                        <div style="background: #F0F0E9; border:0; color: #696763; padding: 5px; width: 100%; 
                                             border-radius: 0; box-shadow: 2px 2px 4px #1A1A1A;">
                                            <h3>SHIPPING ADDRESS</h3>
                                            <hr>
                                            <h3>${currUser.firstName} &nbsp ${currUser.lastName} </h3>
                                            <label>
                                                ${currUser.address.street}<br/>
                                                ${currUser.address.city},&nbsp ${currUser.address.state} <br/>
                                                ${currUser.address.zipcode}<br/>
                                                <a class="btn btn-default"  data-toggle="modal" data-target="#myModalAddress">Edit</a>
                                            </label>
                                        </div>
                                    </div>
                                    <div class="order-message col-sm-6">

                                        <div style="background: #F0F0E9; border:0; color: #696763; padding: 5px; width: 100%; 
                                             border-radius: 0; box-shadow: 2px 2px 4px #1A1A1A;">
                                            <h3 style="color: black;">BILLING ADDRESS</h3><br/>
                                            <h3>${currUser.firstName} &nbsp ${currUser.lastName} </h3>
                                            <label>
                                                ${currUser.address.street}<br/>
                                                ${currUser.address.city},&nbsp ${currUser.address.state} <br/>
                                                ${currUser.address.zipcode}<br/>
                                                <a class="btn btn-default"  data-toggle="modal" data-target="#myModalAddress">Edit</a>
                                            </label>
                                        </div>
                                    </div><br/><br/>
                                    <div class="order-message col-sm-12">

                                        <div class="step-one">
                                            <h1 class="heading"><span class="or-class" style="padding : 10px;">&nbsp2&nbsp</span>  PAYMENT</h1>
                                        </div><hr>
                                        <div class="form-two col-sm-5">
                                        <form:form modelAttribute="card" method="post" action="createCard">
                                            <form:errors path="*" cssClass="error" />
                                            <form:input path="creditCardNo" placeholder="Credit Card Number"/><br/><br/>
                                         
                                            <form:select path="type">
                                                 <form:option value="MASTER" >MASTER CARD</form:option>
                                                    <form:option value="VISA" >VISA CARD</form:option>
                                            </form:select>
                                            <form:select path="month">
                                                <form:option value="01" selected="selected" >01</form:option>
                                                    <form:option value="02" >02</form:option>
                                                    <form:option value="03" >03</form:option>
                                                    <form:option value="04" >04</form:option>
                                                    <form:option value="05" >05</form:option>
                                                    <form:option value="06" >06</form:option>
                                                    <form:option value="07" >07</form:option>
                                                    <form:option value="08" >08</form:option>
                                                    <form:option value="09" >09</form:option>
                                                    <form:option value="10" >10</form:option>
                                                    <form:option value="11" >11</form:option>
                                                    <form:option value="12" >12</form:option>
                                            </form:select>
                                                    <form:select path="year">
                                                            <form:option value="2015" selected="selected" >2015</form:option>
                                                            <form:option value="2016" >2016</form:option>
                                                            <form:option value="2017" >2017</form:option>
                                                            <form:option value="2018" >2018</form:option>
                                                            <form:option value="2019" >2019</form:option>
                                                            <form:option value="2020" >2020</form:option>
                                                            <form:option value="2021" >2021</form:option>
                                                            <form:option value="2022" >2022</form:option>
                                                            <form:option value="2023" >2023</form:option>
                                                            <form:option value="2024" >2024</form:option>
                                                            <form:option value="2025" >2025</form:option>
                                                    </form:select>
                                            <form:input path="cardCV" placeholder="Security Code"/><br/><br/>
                                            <input class="btn btn-primary" type="submit" value="Submit"/>
                                        </form:form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-5 clearfix">
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
                                            <br/><li><b>Total After Tax <span style="float: right; padding-right:20px;">$<fmt:formatNumber type="number" 
                                                              maxFractionDigits="3" value="${(totalPrice*0.1)+totalPrice}"/></span></b></li>
                                        </ul>
                                    </div>
                                    <table class="table table-striped" >
                                        <thead>
                                            <tr>
                                                <td class="image"></td>
                                                <td class="image"></td>
                                                <td class="image" style="float: right; text-decoration: underline;"><a href="<c:url value="/cart"/>">Edit Cart</td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${cart.orderItems}" var="item">
                                                <tr style="height: 80px;">
                                                    <td class="image">
                                                        <a href=""><img  style="height: 141px; width: 110px;" src="<c:url 
                                                                             value="/productpic/"/>${item.product.id}" alt=""></a>
                                                    </td>
                                                    <td class="image" style="width: 180px;">
                                                        <h4><a href="">${item.product.name}</a></h4>
                                                        <p>Web ID: ${item.product.productID}<br/>
                                                            Qty: ${item.quantity}<br/>
                                                            $${item.product.price}</p>
                                                    </td>


                                                    <td class="image" style="width: 80px;">
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
                    <!--                    <span>
                                            <label><input type="checkbox"> </label>
                                        </span>
                                        <span>
                                            <label><input type="checkbox"> Check Payment</label>
                                        </span>
                                        <span>
                                            <label><input type="checkbox"> Paypal</label>
                                        </span>-->
                </div>
            </div>
        </section> <!--/#cart_items-->



        <c:import url="/layout/footer"/>
    </body>
</html>