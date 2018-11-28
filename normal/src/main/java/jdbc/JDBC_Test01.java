package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * author:MarryCheck
 * create 2018-11-20 21:59
 * comment: 连接的自动关闭，try(需要关闭的代码){...}
 */

public class JDBC_Test01 {
    public static void main(String[] args) {
        Connection conn = null;
        // Statement stmt = null;
        PreparedStatement stmt = null;
        ResultSet re = null;
        String sql = "SELECT * FROM  test WHERE username=? AND passwd=?";
        try {
            // 反射  注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "123456");
            // stmt = conn.createStatement();  //可能造成SQL注入的问题，尽量使用下面的
            stmt = conn.prepareStatement(sql);


            stmt.setString(1,"");
            stmt.setString(2,"");


            re = stmt.executeQuery();
            List<User> userList = new ArrayList<User>();
            while (re.next()) {
                User u = new User();  // 这里每次循环必须新建一个对象
                u.setId(re.getInt("id"));
                u.setName(re.getString("name"));
                u.setBirthday(re.getString("birthday"));
                u.setUser(re.getString("user"));
                userList.add(u);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    if (re != null) {
                        re.close();
                    }
                    if (stmt != null) {
                        stmt.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
