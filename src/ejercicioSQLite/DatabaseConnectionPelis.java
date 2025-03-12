package ejercicioSQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionPelis {
    private static String URL = "jdbc:sqlite:BaseDeDatosPeliculas";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
