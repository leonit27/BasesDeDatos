package ejercicioSQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionVideoclub {
    private static String URL = "jdbc:sqlite:BaseDeDatosVideoclub";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
