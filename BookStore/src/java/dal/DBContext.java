package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBContext {
    protected Connection connection;

    public DBContext() {
        try {
            // Sử dụng tùy chọn để tắt SSL và bật chứng chỉ tự ký
            String url = "jdbc:sqlserver://localhost:1433;databaseName=BOOKSTORE;encrypt=false;trustServerCertificate=true";
            String username = "sa";
            String password = "1111";

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

}
