package cn.itcast.day13_tomcat;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

// 3.0及以上版本不需要在web.xml里配置servlet,使用注解即可
// @WebServlet(name = "helloServlet", value = "/hello-servlet")
@WebServlet("/demo1")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        // Servlet是单例模式,存在线程安全问题.因此尽量不要在servlet中定义成员变量/不赋值/final修饰
        System.out.println("init...");
        message = "Hello World!";
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("doGet...");
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost...");
    }

    public void destroy() {
        System.out.println("destroy...");
    }
}