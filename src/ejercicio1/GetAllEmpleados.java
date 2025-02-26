package ejercicio1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetAllEmpleados {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = DatabaseConnectionFac.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM empleados");

            System.out.println("Núm. \tNombre \tDep \tEdad \tSueldo");
            System.out.println("-----------------------------------------");

            while (rs.next()) {
                System.out.print(rs.getInt(1) + "\t\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.print(rs.getInt(3) + "\t\t");
                System.out.print(rs.getInt(4) + "\t\t");
                System.out.println(rs.getDouble(5) + "\t");
            }
        } catch (SQLException ex) {
            System.out.println("Se ha producido un error al leer los empleados. Mensaje: " + ex.getMessage());
        } finally {
            try {
                if (st != null) st.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido un error al cerrar el Statement: " + ex.getMessage());
            }

            try {
                if (rs != null) rs.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido un error al cerrar el ResultSet: " + ex.getMessage());
            }

            try {
                if (con != null) con.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido un error al cerrar la conexión: " + ex.getMessage());
            }
        }
    }
}
