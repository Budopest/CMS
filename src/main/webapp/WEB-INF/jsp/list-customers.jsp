<%--
  Created by IntelliJ IDEA.
  User: budopest
  Date: 9/26/20
  Time: 6:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customers list</title>
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

        <input type="button" value="Add Customer"
               onclick="window.location.href='addCustomerForm';return false;"
        class="add-button">

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
                <td><a href="${pageContext.request.contextPath}/customers/update?customerid=${customer.id}">update</a>
                    |
                    <a href="${pageContext.request.contextPath}/customers/delete?customerid=${customer.id}"
                    onclick="if(!(confirm('Are you sure you want to delete this customer, deleted data canoot be retrieved.'))) return false"
                    >delete</a></td>

            </tr>
            </c:forEach>
        </table>



    </div>
</div>






</body>
</html>
