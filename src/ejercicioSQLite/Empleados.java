package ejercicioSQLite;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

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

            //Creamos el frame con sus respectivas características
            JFrame frameMostrarDatosConsultaEmpleado = new JFrame("Datos " + IDempleado);
            frameMostrarDatosConsultaEmpleado.setLayout(new GridLayout(2, 4));
            frameMostrarDatosConsultaEmpleado.setSize(600, 200);
            frameMostrarDatosConsultaEmpleado.setResizable(false);
            frameMostrarDatosConsultaEmpleado.setLocationRelativeTo(null);

            //Creamos las etiquetas que encabezan la tabla
            JLabel labelIDEmpleado = new JLabel("ID Empleado");
            JLabel labelDNIEmpleado = new JLabel("DNI");
            JLabel labelNombre = new JLabel("Nombre");
            JLabel labelApellidos = new JLabel("Apellidos");

            //Centramos el texto de las etiquetas
            labelIDEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
            labelDNIEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
            labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
            labelApellidos.setHorizontalAlignment(SwingConstants.CENTER);

            //Ponemos borde a las etiquetas
            labelIDEmpleado.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelDNIEmpleado.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelNombre.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelApellidos.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            //Definimos las etiquetas opacas para poder cambiarles el color
            labelIDEmpleado.setOpaque(true);
            labelDNIEmpleado.setOpaque(true);
            labelNombre.setOpaque(true);
            labelApellidos.setOpaque(true);

            //Cambiamos el color de las etiquetas
            labelIDEmpleado.setBackground(new Color(125, 210, 181));
            labelDNIEmpleado.setBackground(new Color(125, 210, 181));
            labelNombre.setBackground(new Color(125, 210, 181));
            labelApellidos.setBackground(new Color(125, 210, 181));

            //Añadimos las etiquetas al frame
            frameMostrarDatosConsultaEmpleado.add(labelIDEmpleado);
            frameMostrarDatosConsultaEmpleado.add(labelDNIEmpleado);
            frameMostrarDatosConsultaEmpleado.add(labelNombre);
            frameMostrarDatosConsultaEmpleado.add(labelApellidos);

            //Creamos las etiquetas con la información
            JLabel labelIDEmpleadoConsultado = new JLabel();
            JLabel labelDNIEmpleadoConsultado = new JLabel();
            JLabel labelNombreEmpleadoConsultado = new JLabel();
            JLabel labelApellidosEmpleadoConsultado = new JLabel();

            //Centramos el texto de las etiquetas
            labelIDEmpleadoConsultado.setHorizontalAlignment(SwingConstants.CENTER);
            labelDNIEmpleadoConsultado.setHorizontalAlignment(SwingConstants.CENTER);
            labelNombreEmpleadoConsultado.setHorizontalAlignment(SwingConstants.CENTER);
            labelApellidosEmpleadoConsultado.setHorizontalAlignment(SwingConstants.CENTER);

            //Definimos las etiquetas opacas para poder cambiarles el color
            labelIDEmpleadoConsultado.setOpaque(true);
            labelDNIEmpleadoConsultado.setOpaque(true);
            labelNombreEmpleadoConsultado.setOpaque(true);
            labelApellidosEmpleadoConsultado.setOpaque(true);

            //Cambiamos el color de las etiquetas
            labelIDEmpleadoConsultado.setBackground(new Color(198, 232, 210));
            labelDNIEmpleadoConsultado.setBackground(new Color(198, 232, 210));
            labelNombreEmpleadoConsultado.setBackground(new Color(198, 232, 210));
            labelApellidosEmpleadoConsultado.setBackground(new Color(198, 232, 210));

            while (rs.next()) {
                //Añadimos información a las etiquetas según la base de datos
                labelIDEmpleadoConsultado.setText(rs.getString(1));
                labelDNIEmpleadoConsultado.setText(rs.getString(2));
                labelNombreEmpleadoConsultado.setText(rs.getString(3));
                labelApellidosEmpleadoConsultado.setText(rs.getString(4));
            }

            //Añadimos las etiquetas al frame
            frameMostrarDatosConsultaEmpleado.add(labelIDEmpleadoConsultado);
            frameMostrarDatosConsultaEmpleado.add(labelDNIEmpleadoConsultado);
            frameMostrarDatosConsultaEmpleado.add(labelNombreEmpleadoConsultado);
            frameMostrarDatosConsultaEmpleado.add(labelApellidosEmpleadoConsultado);

            //Hacemos visible el frame
            frameMostrarDatosConsultaEmpleado.setVisible(true);
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

            sql = "UPDATE empleados SET DNI = '" + DNI + "', Nombre = '" + nombre + "', Apellidos = '" + apellidos + "' WHERE IDempleado = '" + IDempleado + "'";
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

            //Creamos el frame con sus respectivas características
            JFrame frameMostrarTodosEmpleados = new JFrame("Mostrar Todos Empleados");
            frameMostrarTodosEmpleados.setSize(900, 600);
            frameMostrarTodosEmpleados.setResizable(false);
            frameMostrarTodosEmpleados.setLocationRelativeTo(null);

            //Creamos las etiquetas que encabezan la tabla
            JLabel labelIDEmpleado = new JLabel("ID Empleado");
            JLabel labelDNIEmpleado = new JLabel("DNI");
            JLabel labelNombre = new JLabel("Nombre");
            JLabel labelApellidos = new JLabel("Apellidos");

            //Centramos el texto de las etiquetas
            labelIDEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
            labelDNIEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
            labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
            labelApellidos.setHorizontalAlignment(SwingConstants.CENTER);

            //Ponemos borde a las etiquetas
            labelIDEmpleado.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelDNIEmpleado.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelNombre.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelApellidos.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            //Definimos las etiquetas opacas para poder cambiarles el color
            labelIDEmpleado.setOpaque(true);
            labelDNIEmpleado.setOpaque(true);
            labelNombre.setOpaque(true);
            labelApellidos.setOpaque(true);

            //Cambiamos el color de las etiquetas
            labelIDEmpleado.setBackground(new Color(125, 210, 181));
            labelDNIEmpleado.setBackground(new Color(125, 210, 181));
            labelNombre.setBackground(new Color(125, 210, 181));
            labelApellidos.setBackground(new Color(125, 210, 181));

            //Añadimos las etiquetas al frame
            frameMostrarTodosEmpleados.add(labelIDEmpleado);
            frameMostrarTodosEmpleados.add(labelDNIEmpleado);
            frameMostrarTodosEmpleados.add(labelNombre);
            frameMostrarTodosEmpleados.add(labelApellidos);

            //Creamos el contador para saber cuantas filas tendrá el layout
            int contadorFilas = 2;
            
            while (rs.next()) {
                //Modificamos el layout según las filas que tenga la tabla
                frameMostrarTodosEmpleados.setLayout(new GridLayout(contadorFilas++, 4));

                //Creamos las etiquetas con la información
                JLabel labelIDEmpleadoMostrado = new JLabel();
                JLabel labelDNIEmpleadoMostrado = new JLabel();
                JLabel labelNombreMostrado = new JLabel();
                JLabel labelApellidosMostrados = new JLabel();

                //Centramos el texto de las etiquetas
                labelIDEmpleadoMostrado.setHorizontalAlignment(SwingConstants.CENTER);
                labelDNIEmpleadoMostrado.setHorizontalAlignment(SwingConstants.CENTER);
                labelNombreMostrado.setHorizontalAlignment(SwingConstants.CENTER);
                labelApellidosMostrados.setHorizontalAlignment(SwingConstants.CENTER);

                //Definimos las etiquetas opacas para poder cambiarles el color
                labelIDEmpleadoMostrado.setOpaque(true);
                labelDNIEmpleadoMostrado.setOpaque(true);
                labelNombreMostrado.setOpaque(true);
                labelApellidosMostrados.setOpaque(true);

                //Cambiamos el color de las etiquetas
                labelIDEmpleadoMostrado.setBackground(new Color(198, 232, 210));
                labelDNIEmpleadoMostrado.setBackground(new Color(198, 232, 210));
                labelNombreMostrado.setBackground(new Color(198, 232, 210));
                labelApellidosMostrados.setBackground(new Color(198, 232, 210));

                //Vamos añadiendo información a las etiquetas según la base de datos
                labelIDEmpleadoMostrado.setText(rs.getString(1));
                labelDNIEmpleadoMostrado.setText(rs.getString(2));
                labelNombreMostrado.setText(rs.getString(3));
                labelApellidosMostrados.setText(rs.getString(4));

                //Añadimos las etiquetas al frame
                frameMostrarTodosEmpleados.add(labelIDEmpleadoMostrado);
                frameMostrarTodosEmpleados.add(labelDNIEmpleadoMostrado);
                frameMostrarTodosEmpleados.add(labelNombreMostrado);
                frameMostrarTodosEmpleados.add(labelApellidosMostrados);
            }

            //Hacemos el frame visible
            frameMostrarTodosEmpleados.setVisible(true);
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