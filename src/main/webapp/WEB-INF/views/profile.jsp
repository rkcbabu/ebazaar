<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

    <jsp:include page="/WEB-INF/views/includes/head.jsp" />

    <body>
        <jsp:include page="/WEB-INF/views/includes/header.jsp" />

        <section id="cart_items">
            <div class="container">
                
                <div class="row">
                    <div class="col-sm-3">
                        <div class="shopper-info">
                            <p>Edit  Profile</p>
                            <form:form method="POST" action= "profile/${currUser.id}" commandName="currUser">
                                <form:errors element="div" cssClass="errors" path="*"/>
                                <form:input path="username" placeholder="User Name" />
                                <form:input path="firstName" placeholder="First Name" />
                                <form:input path="lastName" placeholder="Last Name" />
                                <form:input path="phone" placeholder="Phone" />
                                <form:input path="email" placeholder="Email" />
                                <form:input path="address.street" placeholder="Street"/>
                                <form:input path="address.city" placeholder="City"/>
                                <form:input path="address.state" placeholder="State"/>
                                <form:input path="address.zipcode" placeholder="Zipcode"/>
                                <hr>
                                <button type="submit" class="btn btn-primary">Update</button>
                                <!--<button type="submit" class="btn btn-primary">Cancel</button>-->
                                <a href="<c:url value="/successPage"/>" class="btn btn-primary">Cancel</a>
                            </form:form>
                        </div>
                    </div>

                </div>

                <hr>        


                </section>
                <!--/#cart_items-->

                <jsp:include page="/WEB-INF/views/includes/footer.jsp" />
                </body>
                </html>