package com.example.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置客户端字符集
        req.setCharacterEncoding("UTF-8");
        // 获取参数
        String user = req.getParameter("user");
        String password = req.getParameter("password");
        // 判断用户名是否为空
        if(user == null || "".equals(user.trim())){
            // 提示弹窗
            req.setAttribute("msg","用户名不能为空");
            // 请求转发到login.jsp
            req.getRequestDispatcher("login.jsp").forward(req,resp);
            return;
        }
        // 判断密码是否为空
        if(password == null || "".equals(password.trim())){
            // 提示弹窗
            req.setAttribute("msg","密码不能为空");
            // 请求转发到login.jsp
            req.getRequestDispatcher("login.jsp").forward(req,resp);
            return;
        }

        // 判断用户名和密码是否正确
        if(!"admin".equals(user) || !"admin".equals(password)){
            req.setAttribute("msg","登陆失败");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
            return;
        }

        // 登陆成功
        // 将登陆信息存储到session作用域
        req.getSession().setAttribute("user",user);
        // 跳转到index.jsp
        resp.sendRedirect("index.jsp");



    }
}
