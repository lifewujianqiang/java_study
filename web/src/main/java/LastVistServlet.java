import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * author:MarryCheck
 * create 2018-11-27 21:26
 * comment:
 * <p>
 * <p>
 * 问题：
 * 实现获取用户上一次访问时间的功能，即当用户访问服务器，如果是非第一次访问的话，
 * 需要将上一次访问服务器的时间给用户显示出来。
 * <p>
 * 分析：
 * 当用户第一次访问服务器时，将时间记录下来并放到cookie中，用户第二次访问时，
 * 会将该cookie发送到服务器，服务器拿到后就可以获取到上次访问的时间了，
 * 将上次访问的时间响应给浏览器并将新的访问时间放到cookie中。
 */


public class LastVistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //防止乱码
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        // 获取客户端所有的cookie
        Cookie[] cookies = req.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if ("lastVistTime".equalsIgnoreCase(cookies[i].getValue())) {
                long time = Long.parseLong(cookies[i].getValue());
                out.write("你的上次访问时间是：" + new Date(time).toLocaleString());
            }
        }

        // 创建cookie
        Cookie c = new Cookie("lastVistTime",System.currentTimeMillis() + "");
        c.setMaxAge(60*60); //设置失效时间为一小时
        resp.addCookie(c);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
