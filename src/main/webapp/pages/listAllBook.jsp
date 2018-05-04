<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 666666
  Date: 2018/5/4
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>listAllBook</title>
</head>
<body>
<h2>
message:${requestScope.message} <br>
book=[${requestScope.book.bookId},${requestScope.book.name}] <br>
<c:forEach items="${requestScope.books}" var="item" >
    ${item.bookId} ；${item.name}<br>
</c:forEach>
</h2>
</body>
</html>
