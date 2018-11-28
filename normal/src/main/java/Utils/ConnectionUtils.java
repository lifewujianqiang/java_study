package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * author:MarryCheck
 * create 2018-11-21 7:22
 * comment: utils的第二种方式写法
 */

public class ConnectionUtils {
    private static String driverClass;
    private static String url;
    private static String username;
    private static String passwd;

    static {
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        driverClass = rb.getString("driverClass");
        url = rb.getString("url");
        username = rb.getString("username");
        passwd = rb.getString("passwd");
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,passwd);
    }
}
