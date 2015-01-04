<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
    <jsp:include page="/WEB-INF/views/includes/head.jsp"/>

    <body>
        <jsp:include page="/WEB-INF/views/includes/header.jsp"/>

        <section id="cart_items">
            <div class="container">
                <div class="breadcrumbs">
                    <ol class="breadcrumb">
                        <li><a href="#">Admin</a></li>
                        <li class="active">Panel</li>
                    </ol>
                </div>
                <div class="table-responsive cart_info">
                    <table class="table table-condensed">
                        <thead>
                            <tr class="cart_menu">
                                <td class="image">User's name</td>
                                <!--<td class="description">User's name</td>-->
                                <td class="price">username</td>
                                <td class="quantity">Role</td>
                                <td class="total">Total</td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${users}" var="user">
                                <tr>
                                    <td class="cart_product">
                                        <p>${user.firstName} ${user.lastName}</p>
                                    </td>
                                    <td class="cart_price">
                                         <p>${user.username}</p>
                                    </td>
                                    <td class="cart_total">
                                        <p>${user.role}</p>
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

        <jsp:include page="/WEB-INF/views/includes/footer.jsp"/>
    </body>
</html>