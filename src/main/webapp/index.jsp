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
<form action="${pageContext.request.contextPath}/listBookName.do">
    编号：<input type="text" name="id"/><%=request.getContextPath()%>
    <input type="submit"/>
</form>
<dev>One v More</dev>
<form action="${pageContext.request.contextPath}/Book.do">
    方法：<input type="text" name="method" value="listAllBook"/>
    <input type="submit"/>
</form>
<form action="${pageContext.request.contextPath}/Book.do">
    方法：<input type="text" name="method" value="listBookName"/>
    <input type="text" name="ID" />
    <input type="text" name="bookId"/>
    <input type="text" name="name"/>
    <input type="submit"/>
</form>
<form action="${pageContext.request.contextPath}/Book.do" method="post">
    方法：<input type="text" name="method" value="listBookId"/>
    <input type="text" name="Id" />
    <input type="text" name="bookId"/>
    <input type="text" name="name"/>
    <input type="submit"/>
</form>
<form action="${pageContext.request.contextPath}/Book.do">
    使用自定义对象解析 &nbsp;
    方法：<input type="text" name="method" value="selfSys"/>

    <input type="submit"/>
</form>
</body>
</html>
