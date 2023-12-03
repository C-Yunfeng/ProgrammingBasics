<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: chenyunfeng
  Date: 2023/12/3
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入格式化标签库--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <title>格式化标签</title>
    </head>
    <body>
        <%--formatNumber--%>
        <h2>formatNumber</h2>
        <fmt:formatNumber value="10" type="number" var="num"/> ${num} <br>
        <fmt:formatNumber value="10" type="percent" /> <br>
        <fmt:formatNumber value="10" type="currency" /> <br>

        <%--formatDate(常用)--%>
        <h2>formatDate</h2>
        <%
          request.setAttribute("myDate",new Date());
        %>
        <fmt:formatDate value="${myDate}" /><br>
        <fmt:formatDate value="${myDate}" type="date" /><br>
        <fmt:formatDate value="${myDate}" type="time" /><br>
        <fmt:formatDate value="${myDate}" type="both" /><br>
        <fmt:formatDate value="${myDate}" pattern="yyyyMMdd"/><br>

        <h2>parseNumber</h2>
        <fmt:parseNumber value="10" /> ${num} <br>
        <fmt:parseNumber value="10%" type="percent" /> <br>

        <h2>parseDate</h2>
        <fmt:parseDate value="2022-01-01" type="date" /><br>
        <fmt:parseDate value="2022/01/02" pattern="yyyy/MM/dd" /><br>
    </body>
</html>
