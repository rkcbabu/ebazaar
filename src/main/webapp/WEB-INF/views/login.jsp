<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="/WEB-INF/views/includes/head.jsp"/>

    <body>
        <jsp:include page="/WEB-INF/views/includes/header.jsp"/>

        <section id="form"><!--form-->
            <div class="container">
                <div class="row">
                    <div class="col-sm-4 col-sm-offset-1">
                        <div class="login-form"><!--login form-->
                            <h2>Login to your account</h2>
                            <form:form method="POST" action="user/loginA" commandName="user">
                                <form:input path="username" placeholder="Username"/>
                                <form:password path="password" placeholder="password" />
                                <span>
                                    <input type="checkbox" class="checkbox"> 
                                    Keep me signed in
                                </span>
                                <button type="submit" class="btn btn-default">Login</button>
                            </form:form>
                        </div><!--/login form-->
                    </div>
                    <div class="col-sm-1">
                        <h2 class="or-class">OR</h2>
                    </div>
                    <div class="col-sm-4">
                        <div class="signup-form"><!--sign up form-->
                            <h2>New User Signup!</h2>
                            <%--<form:form modelAttribute="newAdmin" method="post">--%>
                            <form:form method="POST" action="user/save" commandName="user">
                                <%--<form:errors element="div" cssClass="errors" path="*"/>--%>
                                
                                <form:input path="firstName"  placeholder="First Name" />
                                <form:input path="lastName" placeholder="Last Name" />
                                <form:input path="username" placeholder="Username"/>
                                <form:password path="password" placeholder="password" />
                                <%--<form:errors path="username" element="div" cssClass="error" />--%>

                                <form:input path="phone" placeholder="Phone"/>
                                <form:input path="email" placeholder="Email"/>
                                <%--<form:input path="city" />--%>
                                <%--<form:input path="state" />--%>
                                <%--<form:input path="zipcode" />--%>

                                <!-- <input type="text" placeholder="Name"/>
                                <input type="email" placeholder="Email Address"/>
                                <input type="password" placeholder="Password"/> -->
                                <button type="submit" class="btn btn-default">Signup</button>
                            </form:form>
                        </div><!--/sign up form-->
                    </div>
                </div>
            </div>
        </section><!--/form-->


        <jsp:include page="/WEB-INF/views/includes/footer.jsp"/>
    </body>
</html>