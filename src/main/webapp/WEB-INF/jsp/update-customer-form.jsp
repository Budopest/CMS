<%--
  Created by IntelliJ IDEA.
  User: budopest
  Date: 9/27/20
  Time: 3:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update Customer Info</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - ADD NEW CUSTOMER</h2>
    </div>
</div>

<div id="container">
    <h3>Enter customer information</h3>
    <div id="content">

        <%--@elvariable id="customer" type="customer"--%>
        <form:form action="updateCustomerForm" modelAttribute="customer" method="post">

            <form:hidden path="id"/>
            <table>
                <tbody>
 <%--               <tr>
                    <td><label>ID:</label></td>
                    <td><form:input path="id" readonly="true"/></td>
                </tr>--%>
                <tr>
                    <td><label>First Name:</label></td>
                    <td><form:input path="firstName"/></td>
                    <td class="error"><form:errors path="firstName" /></td>

                </tr>
                <tr>
                    <td><label>Last Name:</label></td>
                    <td><form:input path="lastName"/></td>
                    <td class="error"><form:errors path="lastName" /></td>

                </tr>
                <tr>
                    <td><label>email:</label></td>
                    <td><form:input path="email"/></td>
                    <td class="error"><form:errors path="email" /></td>
                </tr>
                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="update" class="save"></td>
                </tr>
                </tbody>
            </table>
            <div>
                <br>
                <<a href="${pageContext.request.contextPath}/customers/list">Back to the list</a>
            </div>

        </form:form>

    </div>


</div>

</body>
</html>
