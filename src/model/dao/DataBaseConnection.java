package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    /**
     * Datos de conexion
     */
    private static String driver = "jdbc:postgresql:";
    private static String host = "//localhost:";
    private static String porto = "5432";
    private static String sid = "postgres";
    private static String usuario = "postgres";
    private static String password = "postgres";
    private static String url = driver + host+ porto + "/" + sid;

    /**
     * Metodo que devuelve la conexion con la bd
     * @return Conexion
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, usuario, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
