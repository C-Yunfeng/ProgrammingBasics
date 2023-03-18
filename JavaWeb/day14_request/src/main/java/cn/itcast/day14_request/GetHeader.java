package cn.itcast.day14_request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetHeader", value = "/GetHeader")
public class GetHeader extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String agent = request.getHeader("user-agent");
        if(agent.contains("Chrome")){
            System.out.println("This is Chrome.");
        } else if (agent.contains("Firefox")) {
            System.out.println("This is Firefox");
        }else {
            System.out.println("nothing...");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
