package jdbc;

import javax.servlet.*;
import java.io.IOException;

/**
 * author:MarryCheck
 * create 2018-11-22 8:30
 * comment:
 */

public class LifeServlet implements Servlet {
    public void LifeServlet() {
        System.out.println("无参构造方法");
    }

    public void init(ServletConfig config) throws ServletException {
        System.out.println("调用init方法");
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("调用service方法");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {
        System.out.println("调用destroy方法");
    }
}
