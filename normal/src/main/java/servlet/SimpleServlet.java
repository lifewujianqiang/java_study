package servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * author:MarryCheck
 * create 2018-11-22 22:32
 * comment:
 */

public class SimpleServlet extends GenericServlet{
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("simple servlet");
    }

    //建议重写GenericServlet中的无参init方法，避免出错
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("自己重写的init方法");
    }
}
