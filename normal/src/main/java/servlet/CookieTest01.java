package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * author:MarryCheck
 * create 2018-11-27 7:46
 * comment:
 */

public class CookieTest01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        Cookie cookie1 = new Cookie("username","admin");
        Cookie cookie2 = new Cookie("passwd","123456");

        //设置cookie的路径  手动设置
        cookie1.setPath(req.getContextPath() + "/aaa");

        //设置cookie的失效时间,单位为秒
        cookie1.setMaxAge(60*60*24);


        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
