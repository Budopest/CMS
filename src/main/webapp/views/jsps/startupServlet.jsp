<%--
  Created by IntelliJ IDEA.
  User: budopest
  Date: 9/25/20
  Time: 7:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Test Servlet</title>
</head>
<body>
${requestScope.message}
<h2>
    <%=request.getAttribute("message") %>
</h2>
</body>
</html>
