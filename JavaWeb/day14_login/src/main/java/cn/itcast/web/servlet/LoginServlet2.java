package cn.itcast.web.servlet;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet2",value = "/loginServlet2")
public class LoginServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 设置编码
        req.setCharacterEncoding("utf-8");
        // 2. 获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 3. 封装user对象
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
        // 4. 调用UserDao的login方法
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
        // 5. 判断user
        if(user==null){
            // 失败
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }else {
            // 成功
            req.setAttribute("user",user);
            req.getRequestDispatcher("successServlet").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
