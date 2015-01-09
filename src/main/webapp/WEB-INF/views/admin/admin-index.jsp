<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<c:import url="/layout/head"/>
    <body>
        <c:import url="/layout/header"/>

        <section id="cart_items">
            <div class="container">
                <div class="breadcrumbs">
                    <ol class="breadcrumb">
                        <li><a href="<c:url value="/admin"/>">Admin</a></li>
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
                                <td class="total"></td>
                                <td class="total">Edit</td>
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
                                        <a class="cart_quantity_button" href="" title="${user.enabled ? "Disable Vendor":"Enable Vendor"}"
                                           onclick='$("#toggle${user.id}").submit()'
                                           >
                                            <i class='fa ${user.enabled?"fa-user":"fa-ban"}'></i></a>
                                            <form:form modelAttribute="user" action="getEdit/${user.id}" method="post">
                                                <input type="hidden" name="id" value="${user.id}"/>
                                                
                                            </form:form>
                                            
                                    </td>
                                    <td>
                                        <form:form action="admin/getEdit" method="get">
                                                <input type="hidden" name="id" value="${user.id}"/>
                                                <button type="submit" class="btn btn-primary">Edit</button>
                                            </form:form>
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