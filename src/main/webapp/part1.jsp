<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 16.01.18
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Part1</title>
</head>
<body>
<nav>
    <a href="part1.jsp">Part1</a>
    <a href="part2.jsp">Part2</a>
    <a href="part3.jsp">Part3</a>
    <h4 style="align-content: right">you are logged as ${sessionScope.user.role} ${sessionScope.user.login}</h4>
</nav>
<table border="1">
    <tr>
        <td></td>
        <% for(int i = 1; i < 10; i++) { %>
        <td> <%=i%> </td>
        <% } %>
    </tr>
    <% for(int i = 1; i < 10; i++) { %>
    <tr>
        <td> <%=i%> </td>
        <% for(int j = 1; j < 10; j++) { %>
        <td> <%=i * j%> </td>
        <% } %>
    </tr>
    <% } %>
    <br>
</table>


</body>
</html>
