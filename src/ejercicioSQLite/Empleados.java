package ejercicioSQLite;

import java.sql.*;
import java.util.Scanner;

public class Empleados {
    private String IDempleado;
    private String DNI;
    private String nombre;
    private String apellidos;

    public Empleados(String IDempleado, String DNI, String nombre, String apellidos) {
        this.IDempleado =  IDempleado;
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public static void menuEmpleados(int opcionSeleccionada, Scanner s) {
        while (opcionSeleccionada != 0) {
            System.out.println("Menú de gestión de empleados\n" +
                    "------------------------------");

            System.out.print("0. Volver atrás\n" +
                    "1. Agregar un empleado\n" +
                    "2. Mostrar los datos de un empleado\n" +
                    "3. Modificar datos de un empleado\n" +
                    "4. Eliminar empleado\n" +
                    "5. Mostrar todos los empleados\n" +
                    "Elige una opción: ");
            opcionSeleccionada = s.nextInt();
            s.nextLine();

            switch (opcionSeleccionada) {
                case 0:
                    System.out.println("Saliendo del menú de gestión de empleados...");
                    break;
                case 1:
                    System.out.print("IDempleado: ");
                    String IDempleadoAgregado = s.nextLine();

                    System.out.print("DNI: ");
                    String DNIagregado = s.nextLine();

                    System.out.print("Nombre: ");
                    String nombreAgregado = s.nextLine();

                    System.out.print("Apellidos: ");
                    String apellidosAgregados = s.nextLine();

                    Empleados.agregarEmpleados(IDempleadoAgregado, DNIagregado, nombreAgregado, apellidosAgregados);
                    break;
                case 2:
                    System.out.print("Introduce el IDempleado del empleado que quieras ver los datos: ");
                    String IDempleadoVisualizado = s.nextLine();

                    Empleados.mostrarEmpleado(IDempleadoVisualizado);
                    break;
                case 3:
                    System.out.print("Introduce el IDempleado del empleado que quieras modificar los datos: ");
                    String IDempleadoModificado = s.nextLine();

                    System.out.print("Nuevo DNI: ");
                    String DNImodificado = s.nextLine();

                    System.out.print("Nuevo nombre: ");
                    String nombreModificado = s.nextLine();

                    System.out.print("Nuevos apellidos: ");
                    String apellidosModificados = s.nextLine();

                    Empleados.modificarEmpleado(IDempleadoModificado, DNImodificado, nombreModificado, apellidosModificados);
                    break;
                case 4:
                    System.out.print("Introduce el IDempleado del empleado que deseas eliminar: ");
                    String IDempleadoEliminado = s.nextLine();

                    Empleados.eliminarEmpleado(IDempleadoEliminado);
                    break;
                case 5:
                    Empleados.mostrarTabla();
                    break;
                default:
                    System.out.println("Número introducido incorrecto, vuelve a intentarlo");
            }
        }
    }

    public static void crearTablaEmpleados() {
        Connection conn = null;
        Statement st = null;
        String sql;

        try {
            conn = DatabaseConnectionVideoclub.getConnection();
            st = conn.createStatement();

            sql = "CREATE TABLE empleados(IDempleado varchar(10) CONSTRAINT IDempleado PRIMARY KEY, DNI varchar(9), Nombre varchar(20), Apellidos varchar(50))";
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

    public static void eliminarTablaEmpleados() {
        Connection conn = null;
        Statement st = null;
        String sql;

        try {
            conn = DatabaseConnectionVideoclub.getConnection();
            st = conn.createStatement();

            sql = "DROP TABLE empleados";
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

    public static void agregarEmpleados(String IDempleado, String DNI, String nombre, String apellidos) {
        PreparedStatement st = null;
        Connection conn = null;

        String sql = "INSERT INTO empleados(IDempleado, DNI, Nombre, Apellidos) VALUES (?, ?, ?, ?)";

        try {
            conn = DatabaseConnectionVideoclub.getConnection();
            st = conn.prepareStatement(sql);

            st.setString(1, IDempleado);
            st.setString(2, DNI);
            st.setString(3, nombre);
            st.setString(4, apellidos);
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

    public static void mostrarEmpleado(String IDempleado) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnectionVideoclub.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM empleados WHERE IDempleado = '" + IDempleado + "'");

            System.out.println("IDempleado\t\tDNI\t\tNombre\t\tApellidos" +
                    "----------------------------------------------");

            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.print(rs.getString(3) + "\t");
                System.out.println(rs.getString(4));
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

    public static void modificarEmpleado(String IDempleado, String DNI, String nombre, String apellidos) {
        Connection conn = null;
        Statement st = null;
        String sql;

        try {
            conn = DatabaseConnectionVideoclub.getConnection();
            st = conn.createStatement();

            sql = "UPDATE empleados SET IDempleado = '" + IDempleado + "', DNI = '" + DNI + "', Nombre = " + nombre + ", Apellidos = '" + apellidos + "'";
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

    public static void eliminarEmpleado(String IDempleado) {
        Connection conn = null;
        Statement st = null;
        String sql;

        try {
            conn = DatabaseConnectionVideoclub.getConnection();
            st = conn.createStatement();

            sql = "DELETE FROM empleados WHERE IDempleado = '" + IDempleado + "'";
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
            rs = st.executeQuery("SELECT * FROM empleados");

            System.out.println("IDempleado\t\tDNI\t\tNombre\t\tApellidos" +
                    "-----------------------------------------");

            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.print(rs.getString(3) + "\t");
                System.out.println(rs.getString(4));
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
