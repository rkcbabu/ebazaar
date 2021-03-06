<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">
    <c:import url="/layout/head"/>

    <body>
        <c:import url="/layout/header"/>
        <!-- Main Menu Ends -->

        <h1>Customer Registration Form</h1>
        <form:form method="POST" action="user/save" commandName="user">
            <form:errors element="div" cssClass="errors" path="*"/>
                <%--<form:input type="hidden" path="id"/>--%>
            <table> 
                <tr>
                    <td><label>Username:</label></td>
                    <td><form:input path="username" /></td>
                    <td><form:errors path="username" element="div" cssClass="error" /></td>
                </tr>
                <tr>
                    <td> <label> password:</label></td>
                    <td><form:input path="password" /></td>
                    <td><form:errors path="password" element="div" cssClass="error"/></td>   
                </tr>
            </table>
            <input type="submit" value="Submit"/>

        </form:form>

        <c:import url="/layout/footer"/>                   
    </body>
</html>
