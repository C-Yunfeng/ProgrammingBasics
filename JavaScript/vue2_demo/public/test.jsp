<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head><title>Hello World</title></head>
<body>
Hello World!<br/>
<%
out.println("Your IP address is " + request.getRemoteAddr());
%>
</body>

    <label for="dropdown">Choose a number:</label>
    <select id="dropdown">
        <c:forEach var="i" begin="1" end="12">
            <option value="${i}">${i}</option>
        </c:forEach>
    </select>
    <input type="submit" value="Submit">
</html>