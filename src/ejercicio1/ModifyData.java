package ejercicio1;

import java.sql.*;

public class ModifyData {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        String sql;

        try {
            con = DatabaseConnectionFac.getConnection();
            st = con.createStatement();

            sql = "UPDATE EMPLEADOS SET sueldo = sueldo * 1.05";
            st.executeUpdate(sql);

            sql = "UPDATE EMPLEADOS SET departamento = 20 WHERE num = 3";
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            try {
                if (st != null && !st.isClosed()) st.close();
            } catch (SQLException ex) {
                System.out.println("No se ha podido cerrar el Statement por alguna razón");
            }
            try {
                if (con != null && !con.isClosed()) con.close();
            } catch (SQLException ex) {
                System.out.println("No se ha podido cerrar la conexión por alguna razón");
            }
        }
    }
}
