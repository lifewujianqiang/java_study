package servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * author:MarryCheck
 * create 2018-11-22 8:15
 * comment:
 */

public class ServletTest01 implements Servlet {
    /**
     *在servlet中不要定义可修改的成员变量，会有线程安全问题
     */
    public void init(ServletConfig config) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("hello servlet ...");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
