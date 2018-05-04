<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.self.bean.Book" %>
<%@ page import="org.springframework.ui.ModelMap" %><%--
  Created by IntelliJ IDEA.
  User: 666666
  Date: 2018/5/2
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>listBookId</title>
</head>
<body>
<h1>One v More  :listBookId</h1>
<h2>session基本参数：<br>
    <%=session.getId()%>;<%=session.getCreationTime()%>;<%=session.isNew()%><br>
    request中的参数个数 :&nbsp;<%=request.getParameterMap().size()%><br>
    request中的参数: <br>
    <c:forEach items="<%=request.getParameterMap().keySet()%>"
               varStatus="status" var="item">
        ${status.count}:${item}<br>
    </c:forEach>
    <c:forEach items="<%=request.getParameterMap()%>"
               varStatus="status" var="item">
        ${status.count}:${item.key}=${item.value[0]}<br>
    </c:forEach>
    session中的模型对象:<br>
    <c:forEach items="<%=session.getAttributeNames()%>"
               var="item" varStatus="status" >
        ${status.count}:${item}<br>
    </c:forEach>
    session中获取：<br>
    <%=session.getAttribute("book0")%>&nbsp;
    <%=((Book)session.getAttribute("book0")).getBookId()%>&nbsp;
    <%=((Book)session.getAttribute("book0")).getName()%>&nbsp;<br>
    requestScope中获取：<br>
    ${requestScope.book0}&nbsp;
    ${requestScope.book0.bookId}&nbsp;
    ${requestScope.book0.name}
</h2>

<form action="${pageContext.request.contextPath}/Book.do">
    方法：<input type="text" name="method" value="book"/>
    从后台获取session保存的模型对象
    <input type="submit"/>
</form>
<form action="${pageContext.request.contextPath}/Book.do">
    方法：<input type="text" name="method" value="process"/>
    清空session保存的模型对象
    <input type="submit"/>
</form>
</body>
</html>
