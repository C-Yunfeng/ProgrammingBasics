package cn.itcast.day14_request;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

        System.out.println("------Method:" + request.getMethod());
        // 权限控制框架时有用
        System.out.println("------URI:" + request.getRequestURI());
        System.out.println("------URL:" + request.getRequestURL());

        System.out.println("------IP:" + request.getRemoteHost());
    }

    public void destroy() {
    }
}