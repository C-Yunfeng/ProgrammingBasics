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
          <%--获取后台显示到数据,并展示--%>
          <span style="color: red;font-size: 12px"><%=request.getAttribute("msg")%></span>
      </form>

        <%--对登陆参数进行前端校验--%>
        <div style="text-align: center">
            <form action="/login" method="post" id="loginForm">
                用户:<input type="text" name="uname" id="uname"> </br>
                密码:<input type="password" name="upwd" id="upwd"> </br>
                <span id="msg" style="color: red;font-size: 12px"></span>
                <button id="loginBtn">登陆</button>
                <button>注册</button>
            </form>
        </div>
    </body>

    <%--引入jquery--%>
    <script type="text/javascript" src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript">
        /**
         * 1.给按钮绑定事件
         * 2.获得页面输入的参数
         * 3.参数为空时处理
         * 4.校验参数是否匹配数据库
         * 5.登陆成功后处理
         **/
        $("#loginBtn").click(function (){
            //获取参数
            var uname = $("#uname").val();
            var upwd = $("#upwd").val();

            // 判断用户是否为空
            if (isEmpty(uname)){
                $("#msg").html("用户名不能为空");
                return;
            }

            // 判断密码是否为空
            if (isEmpty(upwd)){
                $("#msg").html("密码不能为空");
                return;
            }

            // 若都非空,则提交表单
            $("#loginForm").submit();

        });

        /**
         * 判断字符串是否为空
         *  若为空则返回true
         *  若非空则返回false
         * @param str
         * @returns {boolean}
         */
        function isEmpty(str) {
            if (str == null || str.trim() == ""){
                return true;
            }
            return false;
        }

    </script>
</html>
