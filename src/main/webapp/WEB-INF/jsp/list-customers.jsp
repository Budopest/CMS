<%--
  Created by IntelliJ IDEA.
  User: budopest
  Date: 9/26/20
  Time: 6:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title><spring:message code="customers.list.title"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

<div id="wrapper">
    <div id="header">
        CRM- Customer Management Service
    </div>
</div>

<div id="container">
    <div id="content">

        <security:authorize access="hasRole('ADMIN')">
        <input type="button" value="Add Customer"
               onclick="window.location.href='addCustomerForm';return false;"
        class="add-button">
        </security:authorize>

        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>email</th>
                <th>Actions</th>
            </tr>

            <c:forEach items="${customers}"
                       var="customer"
                       varStatus="loop">
            <tr>
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
                <td>${customer.email}</td>
                <security:authorize access="hasRole('ADMIN')">
                <td>
                    <a href="${pageContext.request.contextPath}/customers/update?customerid=${customer.id}">update</a>
                    |
                    <a href="${pageContext.request.contextPath}/customers/delete?customerid=${customer.id}"
                    onclick="if(!(confirm('Are you sure you want to delete this customer, deleted data canoot be retrieved.'))) return false"
                    >delete</a>
                </td>
                </security:authorize>
            </tr>
            </c:forEach>
        </table>
    </div>
</div>
<br>
<!-- Add a logout button -->
<form:form action="${pageContext.request.contextPath}/logout"
           method="POST">

    <input type="submit" value="Logout" />
</form:form>


<br>
<table align="left" style="padding-left: 300px;">
    <tr>
        <td>
            <b>Language:</b>
            <a
                    href="${pageContext.request.contextPath}/customers/list?lang=en_US">English(US)</a>
            |
            <a
                    href="${pageContext.request.contextPath}/customers/list?lang=ar_EG">Arabic(EG)</a>

            <br> <b>Locale:</b>
            <c:out value="${currentLocale}" />
        </td>
    </tr>
</table>



</body>
</html>
