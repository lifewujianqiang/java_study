import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * author:MarryCheck
 * create 2018-11-27 21:43
 * comment:
 */

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        String usernam = "";
        String password = "";
        Cookie[] cookies = req.getCookies();
        for (int i = 0; cookies!=null && i< cookies.length; i++) {
            if ("username".equals(cookies[i].getName())) {
                usernam = cookies[i].getValue();
            }
            if ("password".equals(cookies[i].getName())) {
                password = cookies[i].getValue();
            }
        }
            // 判断cookie中的用户名和密码是否匹配
            if ("admin".equals(usernam) && "123456".equals(password)){
                out.write("登录成功！");
            }else {
                //构造表单
                out.write("<html><head></head><body>");
                out.write("<form action='" +req.getContextPath() + "' method='post'>");
                out.write("用户名:<input type='text' name='username'>");
                out.write("<br/>");
                out.write("密码:<input type='password' name='password'>");
                out.write("<br>");
                out.write("<input type='checkbox' name='remember'> 十天免登陆");
                out.write("<br>");
                out.write("<input type='submit' name='登录'>");
                out.write("</form></body></html>");
            }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
