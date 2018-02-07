<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 16.01.18
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Part2</title>
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
        <c:forEach begin='1' end='9' var='j'>
            <td> ${j} </td>
        </c:forEach>
        <c:forEach begin='1' end='9' var='j'>
            <tr>
                <td> ${j} </td>
                <c:forEach begin='1' end='9' var='i'>
                    <td>${i*j}</td>
                </c:forEach>
            </tr>
        </c:forEach>
    </tr>
</table>
</body>
</html>
