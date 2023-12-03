<%--
  Created by IntelliJ IDEA.
  User: chenyunfeng
  Date: 2023/12/3
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>测试登陆功能</title>
    </head>
    <body>
      <form action="loginServlet" method="post">
          <input type="text" name="user">用户名</br>
          <input type="password" name="password">密码</br>
          <button>提交</button>
          <span style="color: red;font-size: 12px"><%=request.getAttribute("msg")%></span>
      </form>
    </body>
</html>
