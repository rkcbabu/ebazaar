<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <c:import url="/layout/head"/>
    <body>
        <c:import url="/layout/header"/>
        <section >
            <!--form-->
            <div class="container">
                <div class="row">
                    <c:import url="/layout/sidebar"/>
                    <div class="col-sm-4 col-sm-offset-1">
                        <div class="signup-form">
                            <h2> Vendor Registration</h2>
                            <form:form commandName="user" method="post">
                                <form:errors path="firstName" element="div" cssClass="error" />
                                <form:input path="firstName" placeholder="vendor Name" />
                                <%-- <form:errors path="lastName" element="div" cssClass="error" />
                                        <form:input path="lastName" placeholder="Last Name" /> --%>

                                <form:errors path="username" element="div" cssClass="error" />
                                
                                <input type="hidden" id="role" name="role" value="ROLE_VENDOR">
                                <form:input path="username" placeholder="Username" />
                                
                                <form:errors path="password" element="div" cssClass="error" />
                                <form:password path="password" placeholder="password" />

                                <form:errors path="phone" element="div" cssClass="error" />
                                <form:input path="phone" placeholder="Phone" />

                                <form:errors path="email" element="div" cssClass="error" />
                                <form:input path="email" placeholder="Email" />

                                <form:errors path="address.street" element="div" cssClass="error" />
                                <form:input path="address.street" placeholder="Street" />

                                <form:errors path="address.city" element="div" cssClass="error" />
                                <form:input path="address.city" placeholder="City" />

                                <form:errors path="address.state" element="div" cssClass="error" />
                                <form:input path="address.state" placeholder="State" />

                                <form:errors path="address.zipcode" element="div" cssClass="error" />
                                <form:input path="address.zipcode" placeholder="Zipcode" />

                                <button type="submit" class="btn btn-default">Signup</button>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--/form-->
        <br>
        <c:import url="/layout/footer"/>
    </body>
</html>