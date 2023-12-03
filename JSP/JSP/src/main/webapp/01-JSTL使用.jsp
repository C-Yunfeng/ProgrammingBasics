<%@ page import="java.sql.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.*" %>
<%--TODO:导入包是会报错--%>

<%--<%@ page import="com.example.po.User" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: chenyunfeng
  Date: 2023/12/3
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>JSTL使用</title>
    </head>
    <body>
        <%
            // if和choose
            request.setAttribute("cnt",10);
            request.setAttribute("score",60);
            // forEach
            List<String> list = new ArrayList<>();
            for(int i=0;i<=10; i++ ){
                list.add("A:" + i);
            }
            pageContext.setAttribute("lst",list);
        %>
        <%--if和choose--%>
        <c:if test="${cnt > 1}">
            cnt>1
        </c:if>
        <c:choose>
            <c:when test="${score <60}">
                <h2>score<60</h2>
                <%--when和otherwise标签里可以嵌套其他标签--%>
                <c:if test="${1==1}">1==1</c:if>
            </c:when>
            <c:when test="${score ==60}">
                <h2>score=60</h2>
            </c:when>
            <%--otherwise必须放到最后--%>
            <c:otherwise>
                <h2>score>60</h2>
            </c:otherwise>
        </c:choose>

        <%--forEach--%>
        <c:forEach var="i" begin="0" end="10" step="2">
            ${i} &nbsp;
        </c:forEach>
        <c:forEach items="${lst}" var="item">
            ${item} &nbsp;
        </c:forEach>

        <%--// forEach遍历对象--%>
<%--        <%--%>
<%--            List<User> userList = new ArrayList<User>();--%>
<%--            User user = new User(1, "ZhangSan", "123456");--%>
<%--            User user2 = new User(2, "LiSi", "123456");--%>
<%--            userList.add(user);--%>
<%--            userList.add(user2);--%>
<%--            request.setAttribute("userList",userList);--%>
<%--        %>--%>
<%--        &lt;%&ndash;判断非空&ndash;%&gt;--%>
<%--        <c:if test="${!empty userList}">--%>
<%--            <table align="center" width="800" border="1" style="border-collapse: collapse;">--%>
<%--                <tr>--%>
<%--                    <td>用户编号</td>--%>
<%--                    <td>用户名称</td>--%>
<%--                    <td>用户密码</td>--%>
<%--                    <td>用户操作</td>--%>
<%--                </tr>--%>
<%--                &lt;%&ndash;遍历数组&ndash;%&gt;--%>
<%--                <c:forEach items="${userList}" var="user">--%>
<%--                    <tr align="center">--%>
<%--                        <td>${user.userId}</td>--%>
<%--                        <td>${user.userName}</td>--%>
<%--                        <td>${user.userPwd}</td>--%>
<%--                        <td><button>修改</button></td>--%>
<%--                    </tr>--%>
<%--                </c:forEach>--%>
<%--            </table>--%>
<%--        </c:if>--%>

        <%--循环map--%>
        <%
            HashMap<String, Object> map = new HashMap<>();
            map.put("name","zs");
            map.put("age",22);
            pageContext.setAttribute("map",map);
        %>
        <c:forEach items="${map}" var="m">
            key: ${m.key} , value: ${m.value} <br>
        </c:forEach>

    </body>
</html>
