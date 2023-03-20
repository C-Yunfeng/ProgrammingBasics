package cn.itcast.day14_request;

import com.sun.org.apache.xpath.internal.objects.XNull;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "GetHeader", value = "/GetHeader")
public class GetHeader extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求头
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
        // 获取请求体
        // 1.获取字符流
        BufferedReader br = request.getReader();
        String line = null;
        while ((line = br.readLine())!=null){
            System.out.println(line);
        }

        // 获取请求参数的通用方法
        Map<String, String[]> map = request.getParameterMap();
        System.out.println(map.size());
        Set<String> ks = map.keySet();
        for (String name:ks){
            String[] values = map.get(name);
            for(String value:values){
                System.out.println(value);
            }
        }
    }
}
