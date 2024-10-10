package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static String driver = "jdbc:postgresql:";
    private static String host = "//localhost:"; // tamen poderia ser una ip como "192.168.1.14"
    private static String porto = "5432";
    private static String sid = "postgres";
    private static String usuario = "postgres";
    private static String password = "postgres";
    private static String url = driver + host+ porto + "/" + sid;

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, usuario, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
