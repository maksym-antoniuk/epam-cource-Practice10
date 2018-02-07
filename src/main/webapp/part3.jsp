<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maxim
  Date: 16.01.18
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Part3</title>
</head>
<body>
<nav>
    <a href="part1.jsp">Part1</a>
    <a href="part2.jsp">Part2</a>
    <a href="part3.jsp">Part3</a>
    <h4 style="alignment: center">you are logged as ${sessionScope.user.role} ${sessionScope.user.login}</h4>
</nav>
<form method="post" action="part3">
    <input name="lol" type="text" id="lol"/>
    <input type="submit">
</form>
<ul>
    <c:forEach items="${sessionScope.mylist}" var="i">
        <li>${i}</li>
    </c:forEach>
</ul>
<form method="post" action="delete">
    <input type="submit">
</form>

</body>
</html>
