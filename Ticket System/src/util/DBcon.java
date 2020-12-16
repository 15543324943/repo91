package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBcon {

    // 绾跨▼鍗曚緥
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    private static String url;
    private static String driver;
    private static String username;
    private static String password;

    static {
        Properties props = new Properties();
        try {
            // 浠庡睘鎬ф枃浠朵腑璇诲彇鏁版嵁搴撻厤缃俊鎭紝浠ュ姞杞界被鐨勬柟寮忓姞杞介厤缃枃浠�
            props.load(
                    DBcon.class.getClassLoader()
                    .getResourceAsStream("db_mysql.properties"));

        } catch (IOException e) {
        }
        if (props != null) {
            url = props.getProperty("url");
            driver = props.getProperty("driver");
            username = props.getProperty("username");
            password = props.getProperty("password");

            // 瑁呰浇骞舵敞鍐屾暟鎹簱椹卞姩
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection con = tl.get();
        if (con == null) {
            con = DriverManager.getConnection(url, username, password);
            tl.set(con);
        }
        return con;
    }

    public static void closeConnection() {
        Connection con = tl.get();
        try {
            if (con != null) {
                con.close();
                tl.set(null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeStatement(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void closeAll(Statement stmt, ResultSet rs){
        closeConnection();
        closeStatement(stmt);
        closeResultSet(rs);
    }
    
}