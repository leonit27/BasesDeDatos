package ejercicioSQLite;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

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

            //Creamos el frame con sus respectivas características
            JFrame frameMostrarDatosConsultaReserva = new JFrame("Datos " + idReserva);
            frameMostrarDatosConsultaReserva.setLayout(new GridLayout(2, 5));
            frameMostrarDatosConsultaReserva.setSize(600, 200);
            frameMostrarDatosConsultaReserva.setResizable(false);
            frameMostrarDatosConsultaReserva.setLocationRelativeTo(null);

            //Creamos las etiquetas que encabezan la tabla
            JLabel labelIDReserva = new JLabel("ID Reserva");
            JLabel labelDNICliente = new JLabel("DNI Cliente");
            JLabel labelTituloPelicula = new JLabel("Título Película");
            JLabel labelFechaInicio = new JLabel("Fecha Inicio");
            JLabel labelFechaFinal = new JLabel("Fecha Final");

            //Centramos el texto de las etiquetas
            labelIDReserva.setHorizontalAlignment(SwingConstants.CENTER);
            labelDNICliente.setHorizontalAlignment(SwingConstants.CENTER);
            labelTituloPelicula.setHorizontalAlignment(SwingConstants.CENTER);
            labelFechaInicio.setHorizontalAlignment(SwingConstants.CENTER);
            labelFechaFinal.setHorizontalAlignment(SwingConstants.CENTER);

            //Ponemos borde a las etiquetas
            labelIDReserva.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelDNICliente.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelTituloPelicula.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelFechaInicio.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelFechaFinal.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            //Definimos las etiquetas opacas para poder cambiarles el color
            labelIDReserva.setOpaque(true);
            labelDNICliente.setOpaque(true);
            labelTituloPelicula.setOpaque(true);
            labelFechaInicio.setOpaque(true);
            labelFechaFinal.setOpaque(true);

            //Cambiamos el color de las etiquetas
            labelIDReserva.setBackground(new Color(125, 210, 181));
            labelDNICliente.setBackground(new Color(125, 210, 181));
            labelTituloPelicula.setBackground(new Color(125, 210, 181));
            labelFechaInicio.setBackground(new Color(125, 210, 181));
            labelFechaFinal.setBackground(new Color(125, 210, 181));

            //Añadimos las etiquetas al frame
            frameMostrarDatosConsultaReserva.add(labelIDReserva);
            frameMostrarDatosConsultaReserva.add(labelDNICliente);
            frameMostrarDatosConsultaReserva.add(labelTituloPelicula);
            frameMostrarDatosConsultaReserva.add(labelFechaInicio);
            frameMostrarDatosConsultaReserva.add(labelFechaFinal);

            //Creamos las etiquetas con la información
            JLabel labelIDReservaConsultada = new JLabel();
            JLabel labelDNIClienteReservaConsultada = new JLabel();
            JLabel labelTituloPeliculaReservaConsultada = new JLabel();
            JLabel labelFechaInicioReservaConsultada = new JLabel();
            JLabel labelFechaFinalReservaConsultada = new JLabel();

            //Centramos el texto de las etiquetas
            labelIDReservaConsultada.setHorizontalAlignment(SwingConstants.CENTER);
            labelDNIClienteReservaConsultada.setHorizontalAlignment(SwingConstants.CENTER);
            labelTituloPeliculaReservaConsultada.setHorizontalAlignment(SwingConstants.CENTER);
            labelFechaInicioReservaConsultada.setHorizontalAlignment(SwingConstants.CENTER);
            labelFechaFinalReservaConsultada.setHorizontalAlignment(SwingConstants.CENTER);

            //Definimos las etiquetas opacas para poder cambiarles el color
            labelIDReservaConsultada.setOpaque(true);
            labelDNIClienteReservaConsultada.setOpaque(true);
            labelTituloPeliculaReservaConsultada.setOpaque(true);
            labelFechaInicioReservaConsultada.setOpaque(true);
            labelFechaFinalReservaConsultada.setOpaque(true);

            //Cambiamos el color de las etiquetas
            labelIDReservaConsultada.setBackground(new Color(198, 232, 210));
            labelDNIClienteReservaConsultada.setBackground(new Color(198, 232, 210));
            labelTituloPeliculaReservaConsultada.setBackground(new Color(198, 232, 210));
            labelFechaInicioReservaConsultada.setBackground(new Color(198, 232, 210));
            labelFechaFinalReservaConsultada.setBackground(new Color(198, 232, 210));

            while (rs.next()) {
                //Añadimos información a las etiquetas según la base de datos
                labelIDReservaConsultada.setText(rs.getString(1));
                labelDNIClienteReservaConsultada.setText(rs.getString(2));
                labelTituloPeliculaReservaConsultada.setText(rs.getString(3));
                labelFechaInicioReservaConsultada.setText(rs.getString(4));
                labelFechaFinalReservaConsultada.setText(rs.getString(5));
            }

            //Añadimos las etiquetas al frame
            frameMostrarDatosConsultaReserva.add(labelIDReservaConsultada);
            frameMostrarDatosConsultaReserva.add(labelDNIClienteReservaConsultada);
            frameMostrarDatosConsultaReserva.add(labelTituloPeliculaReservaConsultada);
            frameMostrarDatosConsultaReserva.add(labelFechaInicioReservaConsultada);
            frameMostrarDatosConsultaReserva.add(labelFechaFinalReservaConsultada);

            //Hacemos el frame visible
            frameMostrarDatosConsultaReserva.setVisible(true);
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

            sql = "UPDATE reservas SET DNIcliente = '" + DNIcliente + "', TituloPelicula = '" + tituloPelicula + "', FechaInicio = '" + fechaInicio + "', FechaFinal = '" + fechaFinal + "' WHERE idReserva = '" + idReserva + "'";
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

    public static void eliminarReservas(String idReserva) {
        Connection conn = null;
        Statement st = null;
        String sql;

        try {
            conn = DatabaseConnectionVideoclub.getConnection();
            st = conn.createStatement();

            sql = "DELETE FROM reservas WHERE idReserva = '" + idReserva + "'";
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
            rs = st.executeQuery("SELECT * FROM reservas");

            //Creamos el frame con sus respectivas características
            JFrame frameMostrarTodasReservas = new JFrame("Mostrar Todas Reservas");
            frameMostrarTodasReservas.setSize(900, 600);
            frameMostrarTodasReservas.setResizable(false);
            frameMostrarTodasReservas.setLocationRelativeTo(null);

            //Creamos las etiquetas que encabezan la tabla
            JLabel labelIDReserva = new JLabel("ID Reserva");
            JLabel labelDNICliente = new JLabel("DNI Cliente");
            JLabel labelTituloPelicula = new JLabel("Título Película");
            JLabel labelFechaInicio = new JLabel("Fecha Inicio");
            JLabel labelFechaFinal = new JLabel("Fecha Final");

            //Centramos el texto de las etiquetas
            labelIDReserva.setHorizontalAlignment(SwingConstants.CENTER);
            labelDNICliente.setHorizontalAlignment(SwingConstants.CENTER);
            labelTituloPelicula.setHorizontalAlignment(SwingConstants.CENTER);
            labelFechaInicio.setHorizontalAlignment(SwingConstants.CENTER);
            labelFechaFinal.setHorizontalAlignment(SwingConstants.CENTER);

            //Ponemos borde a las etiquetas
            labelIDReserva.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelDNICliente.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelTituloPelicula.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelFechaInicio.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelFechaFinal.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            //Definimos las etiquetas opacas para poder cambiarles el color
            labelIDReserva.setOpaque(true);
            labelDNICliente.setOpaque(true);
            labelTituloPelicula.setOpaque(true);
            labelFechaInicio.setOpaque(true);
            labelFechaFinal.setOpaque(true);

            //Cambiamos el color de las etiquetas
            labelIDReserva.setBackground(new Color(125, 210, 181));
            labelDNICliente.setBackground(new Color(125, 210, 181));
            labelTituloPelicula.setBackground(new Color(125, 210, 181));
            labelFechaInicio.setBackground(new Color(125, 210, 181));
            labelFechaFinal.setBackground(new Color(125, 210, 181));

            //Añadimos las etiquetas al frame
            frameMostrarTodasReservas.add(labelIDReserva);
            frameMostrarTodasReservas.add(labelDNICliente);
            frameMostrarTodasReservas.add(labelTituloPelicula);
            frameMostrarTodasReservas.add(labelFechaInicio);
            frameMostrarTodasReservas.add(labelFechaFinal);
            
            //Creamos el contador para saber cuantas filas tendrá el layout
            int contadorFilas = 2;
            
            while (rs.next()) {
                //Modificamos el layout según las filas que tenga la tabla
                frameMostrarTodasReservas.setLayout(new GridLayout(contadorFilas++, 5));

                //Creamos las etiquetas con la información
                JLabel labelIDReservaMostrada = new JLabel();
                JLabel labelDNIClienteMostrado = new JLabel();
                JLabel labelTituloPeliculaMostrada = new JLabel();
                JLabel labelFechaInicioMostrada = new JLabel();
                JLabel labelFechaFinalMostrada = new JLabel();

                //Centramos el texto de las etiquetas
                labelIDReservaMostrada.setHorizontalAlignment(SwingConstants.CENTER);
                labelDNIClienteMostrado.setHorizontalAlignment(SwingConstants.CENTER);
                labelTituloPeliculaMostrada.setHorizontalAlignment(SwingConstants.CENTER);
                labelFechaInicioMostrada.setHorizontalAlignment(SwingConstants.CENTER);
                labelFechaFinalMostrada.setHorizontalAlignment(SwingConstants.CENTER);

                //Definimos las etiquetas opacas para poder cambiarles el color
                labelIDReservaMostrada.setOpaque(true);
                labelDNIClienteMostrado.setOpaque(true);
                labelTituloPeliculaMostrada.setOpaque(true);
                labelFechaInicioMostrada.setOpaque(true);
                labelFechaFinalMostrada.setOpaque(true);

                //Cambiamos el color de las etiquetas
                labelIDReservaMostrada.setBackground(new Color(198, 232, 210));
                labelDNIClienteMostrado.setBackground(new Color(198, 232, 210));
                labelTituloPeliculaMostrada.setBackground(new Color(198, 232, 210));
                labelFechaInicioMostrada.setBackground(new Color(198, 232, 210));
                labelFechaFinalMostrada.setBackground(new Color(198, 232, 210));

                //Vamos añadiendo información a las etiquetas según la base de datos
                labelIDReservaMostrada.setText(rs.getString(1));
                labelDNIClienteMostrado.setText(rs.getString(2));
                labelTituloPeliculaMostrada.setText(rs.getString(3));
                labelFechaInicioMostrada.setText(rs.getString(4));
                labelFechaFinalMostrada.setText(rs.getString(5));

                //Añadimos las etiquetas al frame
                frameMostrarTodasReservas.add(labelIDReservaMostrada);
                frameMostrarTodasReservas.add(labelDNIClienteMostrado);
                frameMostrarTodasReservas.add(labelTituloPeliculaMostrada);
                frameMostrarTodasReservas.add(labelFechaInicioMostrada);
                frameMostrarTodasReservas.add(labelFechaFinalMostrada);
            }

            //Hacemos el frame visible
            frameMostrarTodasReservas.setVisible(true);
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
