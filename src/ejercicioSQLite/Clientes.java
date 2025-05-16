package ejercicioSQLite;

import javax.swing.*;
import java.awt.*;
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

            //Creamos el frame con sus respectivas características
            JFrame frameMostrarDatosConsultaCliente = new JFrame("Datos " + DNI);
            frameMostrarDatosConsultaCliente.setLayout(new GridLayout(2, 3));
            frameMostrarDatosConsultaCliente.setSize(600, 200);
            frameMostrarDatosConsultaCliente.setResizable(false);
            frameMostrarDatosConsultaCliente.setLocationRelativeTo(null);

            //Creamos las etiquetas que encabezan la tabla
            JLabel labelDNICliente = new JLabel("DNI");
            JLabel labelNombre = new JLabel("Nombre");
            JLabel labelApellidos = new JLabel("Apellidos");

            //Centramos el texto de las etiquetas
            labelDNICliente.setHorizontalAlignment(SwingConstants.CENTER);
            labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
            labelApellidos.setHorizontalAlignment(SwingConstants.CENTER);

            //Ponemos borde a las etiquetas
            labelDNICliente.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelNombre.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelApellidos.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            //Definimos las etiquetas opacas para poder cambiarles el color
            labelDNICliente.setOpaque(true);
            labelNombre.setOpaque(true);
            labelApellidos.setOpaque(true);

            //Cambiamos el color de las etiquetas
            labelDNICliente.setBackground(new Color(125, 210, 181));
            labelNombre.setBackground(new Color(125, 210, 181));
            labelApellidos.setBackground(new Color(125, 210, 181));
            
            //Añadimos las etiquetas al frame
            frameMostrarDatosConsultaCliente.add(labelDNICliente);
            frameMostrarDatosConsultaCliente.add(labelNombre);
            frameMostrarDatosConsultaCliente.add(labelApellidos);

            //Creamos las etiquetas con la información
            JLabel labelDNIClienteConsultado = new JLabel();
            JLabel labelNombreClienteConsultado = new JLabel();
            JLabel labelApellidosClienteConsultado = new JLabel();

            //Centramos el texto de las etiquetas
            labelDNIClienteConsultado.setHorizontalAlignment(SwingConstants.CENTER);
            labelNombreClienteConsultado.setHorizontalAlignment(SwingConstants.CENTER);
            labelApellidosClienteConsultado.setHorizontalAlignment(SwingConstants.CENTER);

            //Definimos las etiquetas opacas para poder cambiarles el color
            labelDNIClienteConsultado.setOpaque(true);
            labelNombreClienteConsultado.setOpaque(true);
            labelApellidosClienteConsultado.setOpaque(true);

            //Cambiamos el color de las etiquetas
            labelDNIClienteConsultado.setBackground(new Color(198, 232, 210));
            labelNombreClienteConsultado.setBackground(new Color(198, 232, 210));
            labelApellidosClienteConsultado.setBackground(new Color(198, 232, 210));

            while (rs.next()) {
                //Añadimos información a las etiquetas según la base de datos
                labelDNIClienteConsultado.setText(rs.getString(1));
                labelNombreClienteConsultado.setText(rs.getString(2));
                labelApellidosClienteConsultado.setText(rs.getString(3));
            }

            //Añadimos las etiquetas al frame
            frameMostrarDatosConsultaCliente.add(labelDNIClienteConsultado);
            frameMostrarDatosConsultaCliente.add(labelNombreClienteConsultado);
            frameMostrarDatosConsultaCliente.add(labelApellidosClienteConsultado);

            //Hacemos el frame visible
            frameMostrarDatosConsultaCliente.setVisible(true);
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

            sql = "UPDATE clientes SET Nombre = '" + nombre + "', Apellidos = '" + apellidos + "' WHERE DNI = '" + DNI + "'";
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

            sql = "DELETE FROM clientes WHERE DNI = '" + DNI + "'";
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

            //Creamos el frame con sus respectivas características
            JFrame frameMostrarTodosClientes = new JFrame("Mostrar Todos Clientes");
            frameMostrarTodosClientes.setSize(900, 600);
            frameMostrarTodosClientes.setResizable(false);
            frameMostrarTodosClientes.setLocationRelativeTo(null);

            //Creamos las etiquetas que encabezan la tabla
            JLabel labelDNICliente = new JLabel("DNI");
            JLabel labelNombre = new JLabel("Nombre");
            JLabel labelApellidos = new JLabel("Apellidos");

            //Centramos el texto de las etiquetas
            labelDNICliente.setHorizontalAlignment(SwingConstants.CENTER);
            labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
            labelApellidos.setHorizontalAlignment(SwingConstants.CENTER);

            //Ponemos borde a las etiquetas
            labelDNICliente.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelNombre.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelApellidos.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            //Definimos las etiquetas opacas para poder cambiarles el color
            labelDNICliente.setOpaque(true);
            labelNombre.setOpaque(true);
            labelApellidos.setOpaque(true);

            //Cambiamos el color de las etiquetas
            labelDNICliente.setBackground(new Color(125, 210, 181));
            labelNombre.setBackground(new Color(125, 210, 181));
            labelApellidos.setBackground(new Color(125, 210, 181));

            //Añadimos las etiquetas al frame
            frameMostrarTodosClientes.add(labelDNICliente);
            frameMostrarTodosClientes.add(labelNombre);
            frameMostrarTodosClientes.add(labelApellidos);

            //Creamos el contador para saber cuantas filas tendrá el layout
            int contadorFilas = 2;

            while (rs.next()) {
                //Modificamos el layout según las filas que tenga la tabla
                frameMostrarTodosClientes.setLayout(new GridLayout(contadorFilas++, 3));

                //Creamos las etiquetas con la información
                JLabel labelDNIClienteMostrado = new JLabel();
                JLabel labelNombreMostrado = new JLabel();
                JLabel labelApellidosMostrados = new JLabel();

                //Centramos el texto de las etiquetas
                labelDNIClienteMostrado.setHorizontalAlignment(SwingConstants.CENTER);
                labelNombreMostrado.setHorizontalAlignment(SwingConstants.CENTER);
                labelApellidosMostrados.setHorizontalAlignment(SwingConstants.CENTER);

                //Definimos las etiquetas opacas para poder cambiarles el color
                labelDNIClienteMostrado.setOpaque(true);
                labelNombreMostrado.setOpaque(true);
                labelApellidosMostrados.setOpaque(true);

                //Cambiamos el color de las etiquetas
                labelDNIClienteMostrado.setBackground(new Color(198, 232, 210));
                labelNombreMostrado.setBackground(new Color(198, 232, 210));
                labelApellidosMostrados.setBackground(new Color(198, 232, 210));

                //Vamos añadiendo información a las etiquetas según la base de datos
                labelDNIClienteMostrado.setText(rs.getString(1));
                labelNombreMostrado.setText(rs.getString(2));
                labelApellidosMostrados.setText(rs.getString(3));

                //Añadimos las etiquetas al frame
                frameMostrarTodosClientes.add(labelDNIClienteMostrado);
                frameMostrarTodosClientes.add(labelNombreMostrado);
                frameMostrarTodosClientes.add(labelApellidosMostrados);
            }

            //Hacemos el frame visible
            frameMostrarTodosClientes.setVisible(true);
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
