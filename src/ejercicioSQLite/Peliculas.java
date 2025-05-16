package ejercicioSQLite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;

public class Peliculas {
    private String titulo;
    private String director;
    private int anyo;
    private String genero;
    private double rating;
    
    public Peliculas(String titulo, String director, int anyo, String genero, double rating) {
        this.titulo = titulo;
        this.director = director;
        this.anyo = anyo;
        this.genero = genero;
        this.rating = rating;
    }

    public static void agregarPeliculas(String titulo, String director, int anyo, String genero, double rating) {
        PreparedStatement st = null;
        Connection conn = null;
        
        String sql = "INSERT INTO peliculas(Título, Director, Año, Género, Rating) VALUES (?, ?, ?, ?, ?)";
        
        try {
            conn = DatabaseConnectionVideoclub.getConnection();
            st = conn.prepareStatement(sql);
            
            st.setString(1, titulo);
            st.setString(2, director);
            st.setInt(3, anyo);
            st.setString(4, genero);
            st.setDouble(5, rating);
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

    public static void mostrarPelicula(String titulo) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnectionVideoclub.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM peliculas WHERE Título = '" + titulo + "'");

            //Creamos el frame con sus respectivas características
            JFrame frameMostrarDatosConsultaPelicula = new JFrame("Datos " + titulo);
            frameMostrarDatosConsultaPelicula.setLayout(new GridLayout(2, 5));
            frameMostrarDatosConsultaPelicula.setSize(600, 200);
            frameMostrarDatosConsultaPelicula.setResizable(false);
            frameMostrarDatosConsultaPelicula.setLocationRelativeTo(null);

            //Creamos las etiquetas que encabezan la tabla
            JLabel labelTituloPelicula = new JLabel("Título");
            JLabel labelDirectorPelicula = new JLabel("Director");
            JLabel labelAnyoPelicula = new JLabel("Año");
            JLabel labelGeneroPelicula = new JLabel("Género");
            JLabel labelRatingPelicula = new JLabel("Rating");

            //Centramos el texto de las etiquetas
            labelTituloPelicula.setHorizontalAlignment(SwingConstants.CENTER);
            labelDirectorPelicula.setHorizontalAlignment(SwingConstants.CENTER);
            labelAnyoPelicula.setHorizontalAlignment(SwingConstants.CENTER);
            labelGeneroPelicula.setHorizontalAlignment(SwingConstants.CENTER);
            labelRatingPelicula.setHorizontalAlignment(SwingConstants.CENTER);

            //Ponemos borde a las etiquetas
            labelTituloPelicula.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelDirectorPelicula.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelAnyoPelicula.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelGeneroPelicula.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelRatingPelicula.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            //Definimos las etiquetas opacas para poder cambiarles el color
            labelTituloPelicula.setOpaque(true);
            labelDirectorPelicula.setOpaque(true);
            labelAnyoPelicula.setOpaque(true);
            labelGeneroPelicula.setOpaque(true);
            labelRatingPelicula.setOpaque(true);

            //Cambiamos el color de las etiquetas
            labelTituloPelicula.setBackground(new Color(125, 210, 181));
            labelDirectorPelicula.setBackground(new Color(125, 210, 181));
            labelAnyoPelicula.setBackground(new Color(125, 210, 181));
            labelGeneroPelicula.setBackground(new Color(125, 210, 181));
            labelRatingPelicula.setBackground(new Color(125, 210, 181));

            //Añadimos las etiquetas al frame
            frameMostrarDatosConsultaPelicula.add(labelTituloPelicula);
            frameMostrarDatosConsultaPelicula.add(labelDirectorPelicula);
            frameMostrarDatosConsultaPelicula.add(labelAnyoPelicula);
            frameMostrarDatosConsultaPelicula.add(labelGeneroPelicula);
            frameMostrarDatosConsultaPelicula.add(labelRatingPelicula);

            //Creamos las etiquetas con la información
            JLabel labelTituloPeliculaConsultada = new JLabel();
            JLabel labelDirectorPeliculaConsultada = new JLabel();
            JLabel labelAnyoPeliculaConsultada = new JLabel();
            JLabel labelGeneroPeliculaConsultada = new JLabel();
            JLabel labelRatingPeliculaConsultada = new JLabel();

            //Centramos el texto de las etiquetas
            labelTituloPeliculaConsultada.setHorizontalAlignment(SwingConstants.CENTER);
            labelDirectorPeliculaConsultada.setHorizontalAlignment(SwingConstants.CENTER);
            labelAnyoPeliculaConsultada.setHorizontalAlignment(SwingConstants.CENTER);
            labelGeneroPeliculaConsultada.setHorizontalAlignment(SwingConstants.CENTER);
            labelRatingPeliculaConsultada.setHorizontalAlignment(SwingConstants.CENTER);

            //Definimos las etiquetas opacas para poder cambiarles el color
            labelTituloPeliculaConsultada.setOpaque(true);
            labelDirectorPeliculaConsultada.setOpaque(true);
            labelAnyoPeliculaConsultada.setOpaque(true);
            labelGeneroPeliculaConsultada.setOpaque(true);
            labelRatingPeliculaConsultada.setOpaque(true);

            //Cambiamos el color de las etiquetas
            labelTituloPeliculaConsultada.setBackground(new Color(198, 232, 210));
            labelDirectorPeliculaConsultada.setBackground(new Color(198, 232, 210));
            labelAnyoPeliculaConsultada.setBackground(new Color(198, 232, 210));
            labelGeneroPeliculaConsultada.setBackground(new Color(198, 232, 210));
            labelRatingPeliculaConsultada.setBackground(new Color(198, 232, 210));

            while (rs.next()) {
                //Añadimos información a las etiquetas según la base de datos
                labelTituloPeliculaConsultada.setText(rs.getString(1));
                labelDirectorPeliculaConsultada.setText(rs.getString(2));
                labelAnyoPeliculaConsultada.setText(String.valueOf(rs.getInt(3)));
                labelGeneroPeliculaConsultada.setText(rs.getString(4));
                labelRatingPeliculaConsultada.setText(String.valueOf(rs.getDouble(5)));
            }

            //Añadimos las etiquetas al frame
            frameMostrarDatosConsultaPelicula.add(labelTituloPeliculaConsultada);
            frameMostrarDatosConsultaPelicula.add(labelDirectorPeliculaConsultada);
            frameMostrarDatosConsultaPelicula.add(labelAnyoPeliculaConsultada);
            frameMostrarDatosConsultaPelicula.add(labelGeneroPeliculaConsultada);
            frameMostrarDatosConsultaPelicula.add(labelRatingPeliculaConsultada);

            //Hacemos el frame visible
            frameMostrarDatosConsultaPelicula.setVisible(true);
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

    public static void modificarPelicula(String titulo, String director, int anyo, String genero, double rating) {
        Connection conn = null;
        Statement st = null;
        String sql;

        try {
            conn = DatabaseConnectionVideoclub.getConnection();
            st = conn.createStatement();

            sql = "UPDATE peliculas SET Director = '" + director + "', Año = " + anyo + ", Género = '" + genero + "', Rating = " + rating +
                    " WHERE Título = '" + titulo + "'";
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

    public static void eliminarPelicula(String titulo) {
        Connection conn = null;
        Statement st = null;
        String sql;

        try {
            conn = DatabaseConnectionVideoclub.getConnection();
            st = conn.createStatement();

            sql = "DELETE FROM peliculas WHERE Título = '" + titulo + "'";
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
            rs = st.executeQuery("SELECT * FROM peliculas");

            //Creamos el frame con sus respectivas características
            JFrame frameMostrarTodasPeliculas = new JFrame("Mostrar Todas Películas");
            frameMostrarTodasPeliculas.setSize(900, 600);
            frameMostrarTodasPeliculas.setResizable(false);
            frameMostrarTodasPeliculas.setLocationRelativeTo(null);

            //Creamos las etiquetas que encabezan la tabla
            JLabel labelTituloPelicula = new JLabel("Título");
            JLabel labelDirectorPelicula = new JLabel("Director");
            JLabel labelAnyoPelicula = new JLabel("Año");
            JLabel labelGeneroPelicula = new JLabel("Género");
            JLabel labelRatingPelicula = new JLabel("Rating");

            //Centramos el texto de las etiquetas
            labelTituloPelicula.setHorizontalAlignment(SwingConstants.CENTER);
            labelDirectorPelicula.setHorizontalAlignment(SwingConstants.CENTER);
            labelAnyoPelicula.setHorizontalAlignment(SwingConstants.CENTER);
            labelGeneroPelicula.setHorizontalAlignment(SwingConstants.CENTER);
            labelRatingPelicula.setHorizontalAlignment(SwingConstants.CENTER);

            //Ponemos borde a las etiquetas
            labelTituloPelicula.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelDirectorPelicula.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelAnyoPelicula.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelGeneroPelicula.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelRatingPelicula.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            //Definimos las etiquetas opacas para poder cambiarles el color
            labelTituloPelicula.setOpaque(true);
            labelDirectorPelicula.setOpaque(true);
            labelAnyoPelicula.setOpaque(true);
            labelGeneroPelicula.setOpaque(true);
            labelRatingPelicula.setOpaque(true);

            //Cambiamos el color de las etiquetas
            labelTituloPelicula.setBackground(new Color(125, 210, 181));
            labelDirectorPelicula.setBackground(new Color(125, 210, 181));
            labelAnyoPelicula.setBackground(new Color(125, 210, 181));
            labelGeneroPelicula.setBackground(new Color(125, 210, 181));
            labelRatingPelicula.setBackground(new Color(125, 210, 181));

            //Añadimos las etiquetas al frame
            frameMostrarTodasPeliculas.add(labelTituloPelicula);
            frameMostrarTodasPeliculas.add(labelDirectorPelicula);
            frameMostrarTodasPeliculas.add(labelAnyoPelicula);
            frameMostrarTodasPeliculas.add(labelGeneroPelicula);
            frameMostrarTodasPeliculas.add(labelRatingPelicula);

            //Creamos el contador para saber cuantas filas tendrá el layout
            int contadorFilas = 2;

            while (rs.next()) {
                //Modificamos el layout según las filas que tenga la tabla
                frameMostrarTodasPeliculas.setLayout(new GridLayout(contadorFilas++, 5));

                //Creamos las etiquetas con la información
                JLabel labelTituloPeliculaMostrada = new JLabel();
                JLabel labelDirectorPeliculaMostrada = new JLabel();
                JLabel labelAnyoPeliculaMostrada = new JLabel();
                JLabel labelGeneroPeliculaMostrada = new JLabel();
                JLabel labelRatingPeliculaMostrada = new JLabel();

                //Centramos el texto de las etiquetas
                labelTituloPeliculaMostrada.setHorizontalAlignment(SwingConstants.CENTER);
                labelDirectorPeliculaMostrada.setHorizontalAlignment(SwingConstants.CENTER);
                labelAnyoPeliculaMostrada.setHorizontalAlignment(SwingConstants.CENTER);
                labelGeneroPeliculaMostrada.setHorizontalAlignment(SwingConstants.CENTER);
                labelRatingPeliculaMostrada.setHorizontalAlignment(SwingConstants.CENTER);

                //Definimos las etiquetas opacas para poder cambiarles el color
                labelTituloPeliculaMostrada.setOpaque(true);
                labelDirectorPeliculaMostrada.setOpaque(true);
                labelAnyoPeliculaMostrada.setOpaque(true);
                labelGeneroPeliculaMostrada.setOpaque(true);
                labelRatingPeliculaMostrada.setOpaque(true);

                //Cambiamos el color de las etiquetas
                labelTituloPeliculaMostrada.setBackground(new Color(198, 232, 210));
                labelDirectorPeliculaMostrada.setBackground(new Color(198, 232, 210));
                labelAnyoPeliculaMostrada.setBackground(new Color(198, 232, 210));
                labelGeneroPeliculaMostrada.setBackground(new Color(198, 232, 210));
                labelRatingPeliculaMostrada.setBackground(new Color(198, 232, 210));

                //Vamos añadiendo información a las etiquetas según la base de datos
                labelTituloPeliculaMostrada.setText(rs.getString(1));
                labelDirectorPeliculaMostrada.setText(rs.getString(2));
                labelAnyoPeliculaMostrada.setText(String.valueOf(rs.getInt(3)));
                labelGeneroPeliculaMostrada.setText(rs.getString(4));
                labelRatingPeliculaMostrada.setText(String.valueOf(rs.getDouble(5)));

                //Añadimos las etiquetas al frame
                frameMostrarTodasPeliculas.add(labelTituloPeliculaMostrada);
                frameMostrarTodasPeliculas.add(labelDirectorPeliculaMostrada);
                frameMostrarTodasPeliculas.add(labelAnyoPeliculaMostrada);
                frameMostrarTodasPeliculas.add(labelGeneroPeliculaMostrada);
                frameMostrarTodasPeliculas.add(labelRatingPeliculaMostrada);
            }

            //Hacemos el frame visible
            frameMostrarTodasPeliculas.setVisible(true);
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
