package servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * author:MarryCheck
 * create 2018-11-22 21:45
 * comment:
 */

public class ContextTest01 implements Servlet {
    private ServletConfig config;
    
    public void init(ServletConfig config) throws ServletException {


    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ServletContext application = this.config.getServletContext();
        String driver = application.getInitParameter("driver");
        System.out.println(driver);

    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
