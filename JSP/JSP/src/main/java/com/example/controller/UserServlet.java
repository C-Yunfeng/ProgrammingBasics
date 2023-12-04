package com.example.controller;

import com.example.po.User;
import com.example.service.UserService;
import com.example.vo.MessageModel;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/login")
public class UserServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.接收客户端的请求
        String uname = req.getParameter("uname");
        String upwd = req.getParameter("upwd");
        // 2.调用service层,返回消息对象
        MessageModel messageModel = userService.userLogin(uname,upwd);
        // 3.判断对象状态码
        if (messageModel.getStatus() == 1){
            // - 若非空,请求转发至登陆页面,并设置到session
            req.getSession().setAttribute("user",messageModel.getObject());
            resp.sendRedirect("index.jsp");
        } else {
            // - 若为空,则通过消息模型对象返回结果(设置状态/提示信息/回显数据),并设置对象到request
            req.setAttribute("messageModel",messageModel);
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }

    }

}
