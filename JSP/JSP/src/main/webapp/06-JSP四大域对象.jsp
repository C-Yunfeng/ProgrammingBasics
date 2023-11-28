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
            // 设置page范围域对象
            pageContext.setAttribute("name1","NoneAutumn");
            // 设置request范围域对象
            request.setAttribute("name1","NoneAutumn");
            // 设置session范围域对象
            session.setAttribute("name1","NoneAutumn");
            // 设置application范围域对象
            application.setAttribute("name1","NoneAutumn");
        %>

        <%-- JSP服务端跳转 --%>
<%--        <jsp:forward page="06-JSP四大域对象2.jsp"></jsp:forward>--%>

        <%--客户端跳转--%>
        <a href="06-JSP四大域对象2.jsp">跳转</a>


    </body>
</html>
