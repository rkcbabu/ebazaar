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
                    </ol>-->
                <!--</div>/breadcrums-->

                <div class="step-one">
                    <h1 class="heading"><span class="or-class" style="padding : 10px;">&nbsp3&nbsp</span>  Confirmation</h1>
                </div>
                  <div style="background: #F0F0E9; border:0; color: #696763; padding: 5px; width: 100%; 
                                                 border-radius: 0; box-shadow: 2px 2px 4px #1A1A1A;">
                                                <hr>
                                                <h3>Congrats you have successfully place your order</h3>
                                                <label>
                                                    Your confirmation number: <b>${confirmation}</b><br/>
                                                    Total charge to your card: $${totalPrice+0.1*totalPrice}
                                                </label>
                                            </div>
                
                <div class="payment-options">
                </div>
            </div>
        </section> <!--/#cart_items-->



        <c:import url="/layout/footer"/>
    </body>
</html>