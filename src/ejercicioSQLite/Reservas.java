package ejercicioSQLite;

import java.sql.*;
import java.util.Scanner;

public class Reservas {
    private String idReserva;
    private String DNIcliente;
    private String tituloPelicula;
    private String fechaInicio;
    private String fechaFinal;

    public Reservas(String idReserva, String DNIcliente, String tituloPelicula, String fechaInicio, String fechaFinal) {
        this.idReserva = idReserva;
        this.DNIcliente = DNIcliente;
        this.tituloPelicula = tituloPelicula;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    public static void menuReservas(int opcionSeleccionada, Scanner s) {
        while (opcionSeleccionada != 0) {
            System.out.println("Menú de gestión de reservas\n" +
                    "------------------------------");

            System.out.print("0. Volver atrás\n" +
                    "1. Agregar una reserva\n" +
                    "2. Mostrar los datos de una reserva\n" +
                    "3. Modificar datos de una reserva\n" +
                    "4. Eliminar reserva\n" +
                    "5. Mostrar todas las reservas\n" +
                    "6. Imprimir reserva por ID\n" +
                    "Elige una opción: ");
            opcionSeleccionada = s.nextInt();
            s.nextLine();

            switch (opcionSeleccionada) {
                case 0:
                    System.out.println("Saliendo del menú de gestión de reservas...");
                    break;
                case 1:
                    System.out.print("ID Reserva: ");
                    String idReservaAgregado = s.nextLine();

                    System.out.print("DNIcliente: ");
                    String DNIclienteagregado = s.nextLine();

                    System.out.print("Título de la película: ");
                    String tituloPeliculaAgregada = s.nextLine();

                    System.out.print("Fecha Inicio: ");
                    String fechaInicioAgregada = s.nextLine();

                    System.out.print("Fecha Final: ");
                    String fechaFinalAgregada = s.nextLine();

                    Reservas.agregarReservas(idReservaAgregado, DNIclienteagregado, tituloPeliculaAgregada, fechaInicioAgregada, fechaFinalAgregada);
                    break;
                case 2:
                    System.out.print("Introduce el ID de la reserva que quieras ver los datos: ");
                    String idReservaVisualizado = s.nextLine();

                    Reservas.mostrarReserva(idReservaVisualizado);
                    break;
                case 3:
                    System.out.print("Introduce el ID de la reserva que quieras modificar los datos: ");
                    String idReservaModificado = s.nextLine();

                    System.out.print("Nuevo DNI del cliente: ");
                    String DNIclienteModificado = s.nextLine();

                    System.out.print("Nuevo título de la película: ");
                    String tituloPeliculaModificado = s.nextLine();

                    System.out.print("Nueva fecha de inicio: ");
                    String fechaInicioModificada = s.nextLine();

                    System.out.print("Nueva fecha final: ");
                    String fechaFinalModificada = s.nextLine();

                    Reservas.modificarReserva(idReservaModificado, DNIclienteModificado, tituloPeliculaModificado, fechaInicioModificada, fechaFinalModificada);
                    break;
                case 4:
                    System.out.print("Introduce el ID de la reserva que deseas eliminar: ");
                    String idReservaEliminada = s.nextLine();

                    Reservas.eliminarReservas(idReservaEliminada);
                    break;
                case 5:
                    Reservas.mostrarTabla();
                    break;
                case 6:
                    System.out.print("Introduce el ID de la reserva que deseas imprimir: ");
                    String idReservaImpreso = s.nextLine();

                    Reservas.imprimirReservaPorID(idReservaImpreso);
                    break;
                default:
                    System.out.println("Número introducido incorrecto, vuelve a intentarlo");
            }
        }
    }

    public static void crearTablaReservas() {
        Connection conn = null;
        Statement st = null;
        String sql;

        try {
            conn = DatabaseConnectionVideoclub.getConnection();
            st = conn.createStatement();

            sql = "DROP TABLE reservas; CREATE TABLE reservas(idReserva varchar(9) CONSTRAINT idReserva PRIMARY KEY, DNIcliente varchar(9), " +
                    "TituloPelicula varchar(50), FechaInicio varchar(10), FechaFinal varchar(10), CONSTRAINT DNIcliente FOREIGN KEY (DNIcliente) REFERENCES clientes(DNI), "+
                    "CONSTRAINT TituloPelicula FOREIGN KEY (TituloPelicula) REFERENCES peliculas(Título))";
            st.executeUpdate(sql);
            System.out.println("Tabla creada correctamente.");
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

    public static void eliminarTablaReservas() {
        Connection conn = null;
        Statement st = null;
        String sql;

        try {
            conn = DatabaseConnectionVideoclub.getConnection();
            st = conn.createStatement();

            sql = "DROP TABLE reservas";
            st.executeUpdate(sql);

            System.out.println("Tabla eliminada correctamente.");
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

    public static void agregarReservas(String idReserva, String DNIcliente, String tituloPelicula, String fechaInicio, String fechaFinal) {
        PreparedStatement st = null;
        Connection conn = null;

        String sql = "INSERT INTO reservas(idReserva, DNIcliente, TituloPelicula, FechaInicio, FechaFinal) VALUES (?, ?, ?, ?, ?)";

        try {
            conn = DatabaseConnectionVideoclub.getConnection();
            st = conn.prepareStatement(sql);

            st.setString(1, idReserva);
            st.setString(2, DNIcliente);
            st.setString(3, tituloPelicula);
            st.setString(4, fechaInicio);
            st.setString(5, fechaFinal);
            st.executeUpdate();

            System.out.println("Reserva agregada correctamente.");
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

    public static void mostrarReserva(String idReserva) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnectionVideoclub.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM reservas WHERE idReserva = '" + idReserva + "'");

            System.out.println("idReserva\t\tDNIcliente\t\tTituloPelicula\t\tFechaInicio\t\tFechaFinal\n" +
                    "-------------------------------------------------------");

            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.print(rs.getString(3) + "\t");
                System.out.print(rs.getString(4) + "\t");
                System.out.println(rs.getString(5));
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

    public static void modificarReserva(String idReserva, String DNIcliente, String tituloPelicula, String fechaInicio, String fechaFinal) {
        Connection conn = null;
        Statement st = null;
        String sql;

        try {
            conn = DatabaseConnectionVideoclub.getConnection();
            st = conn.createStatement();

            sql = "UPDATE reservas SET idReserva = '" + idReserva + "', DNIcliente = " + DNIcliente + ", TituloPelicula = '" + tituloPelicula + "', FechaInicio = '" + fechaInicio + "', FechaFinal = '" + fechaFinal + "'";
            st.executeUpdate(sql);

            System.out.println("Reserva modificada correctamente.");
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

    public static void eliminarReservas(String idReserva) {
        Connection conn = null;
        Statement st = null;
        String sql;

        try {
            conn = DatabaseConnectionVideoclub.getConnection();
            st = conn.createStatement();

            sql = "DELETE FROM reservas WHERE idReserva = '" + idReserva + "'";
            st.executeUpdate(sql);

            System.out.println("Reserva eliminada correctamente.");
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
            rs = st.executeQuery("SELECT * FROM reservas");

            System.out.println("idReserva\t\tDNIcliente\t\tTituloPelicula\t\tFechaInicio\t\tFechaFinal\n" +
                    "-------------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.print(rs.getString(3) + "\t");
                System.out.print(rs.getString(4) + "\t");
                System.out.println(rs.getString(5));
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

    public static void imprimirReservaPorID(String idReserva) {
        String sql = "SELECT idReserva, Nombre as Cliente, Título, FechaInicio, FechaFinal FROM reservas JOIN clientes ON reservas.DNIcliente = DNI " +
                "JOIN peliculas ON reservas.TituloPelicula = Título " +
                "WHERE idReserva = ?";

        try (Connection conn = DatabaseConnectionVideoclub.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, idReserva);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                System.out.println("╔════════════════════════════════════════╗");
                System.out.println("║           DETALLE DE RESERVA           ║");
                System.out.println("╠════════════════════════════════════════╣");
                System.out.printf("║ %15s: %-20s  ║\n", "ID reserva", rs.getString("idReserva"));
                System.out.printf("║ %15s: %-20s  ║\n", "Cliente", rs.getString("Cliente"));
                System.out.printf("║ %15s: %-20s  ║\n", "Título", rs.getString("Título"));
                System.out.printf("║ %15s: %-20s  ║\n", "FechaInicio", rs.getString("FechaInicio"));
                System.out.printf("║ %15s: %-20s  ║\n", "FechaFinal", rs.getString("FechaFinal"));
                System.out.println("╚════════════════════════════════════════╝");

            } else System.out.println("No se encontró una reserva con ese ID");
        } catch (SQLException ex) {
            System.out.println("Error al consultar la reserva: " + ex.getMessage());
        }
    }
}
