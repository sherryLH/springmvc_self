<%--
  Created by IntelliJ IDEA.
  User: 666666
  Date: 2018/4/28
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>springmvc测试</title>
</head>
<body>
<dev>One v One</dev>
<form action="/springmvc/listAllBook/2018-04-28">
    内容：<input type="text" name="context"/>
    <input type="submit"/>
</form>
<form action="/springmvc/listBookName.do">
    编号：<input type="text" name="id"/>
    <input type="submit"/>
</form>
<dev>One v More</dev>
<form action="/springmvc/Book.do">
    方法：<input type="text" name="method"/>
    <input type="submit"/>
</form>
</body>
</html>
