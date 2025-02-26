package ejercicio1;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTabla {
    static Connection con = null;

    public static void main(String[] args) {
        Statement st = null;
        String sql  = "CREATE TABLE empleados (" +
                " num INTEGER PRIMARY KEY, " +
                " nombre VARCHAR(255), " +
                " departamento INTEGER, " +
                " edad INTEGER, " +
                " sueldo REAL);";

        try {
            con = DatabaseConnectionFac.getConnection();
            st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            try {
                if (st != null && !st.isClosed()) st.close();
            } catch (SQLException ex) {
                System.out.println("No se a podido cerrar el Statement por alguna razón");
            }
        }
    }
}