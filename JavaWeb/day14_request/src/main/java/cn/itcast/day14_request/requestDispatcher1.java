package cn.itcast.day14_request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "requestDispatcher1", value = "/requestDispatcher1")
public class requestDispatcher1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置域数据
        request.setAttribute("msg","OHHHHHHHHH");
        // 请求转发
        request.getRequestDispatcher("/requestDispatcher2").forward(request,response);
    }
}
