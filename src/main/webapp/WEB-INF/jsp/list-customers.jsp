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

        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>email</th>
            </tr>

            <c:forEach items="${customers}"
                       var="customer"
                       varStatus="loop">
            <tr>
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
                <td>${customer.email}</td>
            </tr>
            </c:forEach>
        </table>



    </div>
</div>






</body>
</html>
