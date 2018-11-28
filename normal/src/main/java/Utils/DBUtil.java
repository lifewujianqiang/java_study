package Utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * author:MarryCheck
 * create 2018-11-21 7:34
 * comment: 第二种方式util 类
 */

public class DBUtil {
    private static String driverClass;
    private static String url;
    private static String username;
    private static String passwd;
    private static final String jdbc_path = "jdbc.properties";

    static {
        Properties pro = new Properties();
        InputStream in = DBUtil.class.getClassLoader().getResourceAsStream(jdbc_path);
        try {
            pro.load(in);
            driverClass = pro.getProperty("driverClass");
            url = pro.getProperty("url");
            username = pro.getProperty("username");
            passwd = pro.getProperty("username");
            driverClass = pro.getProperty("driverClass");

            Class.forName(driverClass);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Connection get_connection() throws SQLException {
        return DriverManager.getConnection(url,username,passwd);
    }

    public void release(Connection conn, PreparedStatement stmt, ResultSet re){
            try {
                if (re != null) {
                    re.close();
                }
                if (stmt != null){
                    stmt.close();
                }
                if (conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }
}
