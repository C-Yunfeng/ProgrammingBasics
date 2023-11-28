<%--
  Created by IntelliJ IDEA.
  User: chenyunfeng
  Date: 2023/11/28
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>JSP4大域对象</title>
    </head>
    <body>
        <%
            // 获取page范围域对象
            out.print("page范围" + pageContext.getAttribute("name1") + "<br>");
            // 获取request范围域对象
            out.print("request范围" + request.getAttribute("name1") + "<br>");
            // 获取session范围域对象
            out.print("session范围" + session.getAttribute("name1") + "<br>");
            // 获取application范围域对象
            out.print("application范围" + application.getAttribute("name1") + "<br>");
        %>

    </body>
</html>
