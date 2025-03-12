package ejercicioSQLite;

import java.sql.*;

public class Clientes {
    private String DNI;
    private String nombre;
    private String apellidos;

    public Clientes(String DNI, String nombre, String apellidos) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public static void crearTablaClientes() {
        Connection conn = null;
        Statement st = null;
        String sql;

        try {
            conn = DatabaseConnectionVideoclub.getConnection();
            st = conn.createStatement();

            sql = "CREATE TABLE clientes(DNI varchar(9) CONSTRAINT DNI PRIMARY KEY, Nombre varchar(20), Apellidos varchar(50))";
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                if (st != null && !st.isClosed()) st.close();
            } catch (SQLException ex) {
                System.out.println("No se ha podido cerrar el Statement por alguna razón");
            }
            try {
                if (conn != null && !conn.isClosed()) conn.close();
            } catch (SQLException ex) {
                System.out.println("No se ha podido cerrar la connexion por alguna razón");
            }
        }
    }

    public static void agregarClientes(String DNI, String nombre, String apellidos) {
        PreparedStatement st = null;
        Connection conn = null;

        String sql = "INSERT INTO clientes(DNI, Nombre, Apellidos) VALUES (?, ?, ?)";

        try {
            conn = DatabaseConnectionVideoclub.getConnection();
            st = conn.prepareStatement(sql);

            st.setString(1, DNI);
            st.setString(2, nombre);
            st.setString(3, apellidos);
            st.executeUpdate();
        } catch (SQLException ex){
            System.out.println("Error "+ ex.getMessage());
        } finally {
            try {
                if (st != null && !st.isClosed()) st.close();
            } catch (SQLException ex) {
                System.out.println("No se ha podido cerrar el Statement por alguna razón");
            }
            try {
                if (conn != null && !conn.isClosed()) conn.close();
            } catch (SQLException ex) {
                System.out.println("No se ha podido cerrar la connexion por alguna razón");
            }
        }
    }

    public static void mostrarCliente(String DNI) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnectionVideoclub.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM clientes WHERE DNI = '" + DNI + "'");

            System.out.println("DNI\t\tNombre\t\tApellidos" +
                    "----------------------------------------------");

            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.println(rs.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                if (st != null && !st.isClosed()) st.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido un error al cerrar el Statement: " + ex.getMessage());
            }

            try {
                if (conn != null && !conn.isClosed()) conn.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido un error al cerrar la conexión: " + ex.getMessage());
            }

            try {
                if (rs != null && !rs.isClosed()) rs.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido un error al cerrar el ResultSet: " + ex.getMessage());
            }
        }
    }

    public static void modificarCliente(String DNI, String nombre, String apellidos) {
        Connection conn = null;
        Statement st = null;
        String sql;

        try {
            conn = DatabaseConnectionVideoclub.getConnection();
            st = conn.createStatement();

            sql = "UPDATE peliculas SET DNI = '" + DNI + "', Nombre = " + nombre + ", Apellidos = '" + apellidos + "'";
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                if (st != null && !st.isClosed()) st.close();
            } catch (SQLException ex) {
                System.out.println("No se ha podido cerrar el Statement por alguna razón");
            }
            try {
                if (conn != null && !conn.isClosed()) conn.close();
            } catch (SQLException ex) {
                System.out.println("No se ha podido cerrar la connexion por alguna razón");
            }
        }
    }

    public static void eliminarCliente(String DNI) {
        Connection conn = null;
        Statement st = null;
        String sql;

        try {
            conn = DatabaseConnectionVideoclub.getConnection();
            st = conn.createStatement();

            sql = "DELETE FROM peliculas WHERE DNI = '" + DNI + "'";
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                if (st != null && !st.isClosed()) st.close();
            } catch (SQLException ex) {
                System.out.println("No se ha podido cerrar el Statement por alguna razón");
            }
            try {
                if (conn != null && !conn.isClosed()) conn.close();
            } catch (SQLException ex) {
                System.out.println("No se ha podido cerrar la connexion por alguna razón");
            }
        }
    }

    public static void mostrarTabla() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnectionVideoclub.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM clientes");

            System.out.println("DNI\t\tNombre\t\tApellidos" +
                    "-----------------------------------------");

            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.print(rs.getString(3));
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                if (st != null && !st.isClosed()) st.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido un error al cerrar el Statement: " + ex.getMessage());
            }

            try {
                if (conn != null && !conn.isClosed()) conn.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido un error al cerrar la conexión: " + ex.getMessage());
            }

            try {
                if (rs != null && !rs.isClosed()) rs.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido un error al cerrar el ResultSet: " + ex.getMessage());
            }
        }
    }
}
