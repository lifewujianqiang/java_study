import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * author:MarryCheck
 * create 2018-11-27 22:21
 * comment: 用户登录
 */

public class DoLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        // 获取表单数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remenber = req.getParameter("remember");

        //判断用户是否输入正确的用户名和密码
        if("admin".equals(username) && "123456".equals(password)){
            out.write("登录成功！！！");
            if(remenber != null){
                Cookie cookie1 = new Cookie("username",username);
                Cookie cookie2 = new Cookie("password", password);
                //设置过期时间为10天
                cookie1.setMaxAge(60*60*24*10);
                cookie2.setMaxAge(60*60*24*10);
                cookie1.setPath("/");
                cookie2.setPath("/");
                resp.addCookie(cookie1);
                resp.addCookie(cookie2);

            }
        }else {
            out.write("登录失败！用户名或密码错误！");
            //跳转
            resp.setHeader("refresh","2;url=" + req.getContextPath() + "/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
