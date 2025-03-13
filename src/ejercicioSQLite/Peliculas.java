package ejercicioSQLite;

import java.sql.*;
import java.util.Scanner;

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

    public static void menuPeliculas(int opcionSeleccionada, Scanner s) {
        while (opcionSeleccionada != 0) {
            System.out.println("Menú de gestión de películas\n" +
                    "------------------------------");

            System.out.print("0. Volver atrás\n" +
                    "1. Agregar una película\n" +
                    "2. Mostrar los datos de una película\n" +
                    "3. Modificar datos de una película\n" +
                    "4. Eliminar película\n" +
                    "5. Mostrar todas las películas\n" +
                    "Elige una opción: ");
            opcionSeleccionada = s.nextInt();
            s.nextLine();

            switch (opcionSeleccionada) {
                case 0:
                    System.out.println("Saliendo del menú de gestión de películas...");
                    break;
                case 1:
                    System.out.print("Título: ");
                    String tituloAgregado = s.nextLine();

                    System.out.print("Director: ");
                    String directorAgregado = s.nextLine();

                    System.out.print("Año: ");
                    int anyoAgregado = s.nextInt();
                    s.nextLine();

                    System.out.print("Género: ");
                    String generoAgregado = s.nextLine();

                    System.out.print("Rating: ");
                    double ratingAgregado = s.nextDouble();
                    s.nextLine();

                    Peliculas.agregarPeliculas(tituloAgregado, directorAgregado, anyoAgregado, generoAgregado, ratingAgregado);
                    break;
                case 2:
                    System.out.print("Introduce el título de la película que quieras ver los datos: ");
                    String tituloVisualizado = s.nextLine();

                    Peliculas.mostrarPelicula(tituloVisualizado);
                    break;
                case 3:
                    System.out.print("Introduce el título de la película que quieras modificar los datos: ");
                    String tituloModificado = s.nextLine();

                    System.out.print("Nuevo director: ");
                    String directorModificado = s.nextLine();

                    System.out.print("Nuevo año: ");
                    int anyoModificado = s.nextInt();
                    s.nextLine();

                    System.out.print("Nuevo género: ");
                    String generoModificado = s.nextLine();

                    System.out.print("Nuevo rating: ");
                    double ratingModificado = s.nextDouble();
                    s.nextLine();

                    Peliculas.modificarPelicula(tituloModificado, directorModificado, anyoModificado, generoModificado, ratingModificado);
                    break;
                case 4:
                    System.out.print("Introduce el título de la película que deseas eliminar: ");
                    String tituloEliminado = s.nextLine();

                    Peliculas.eliminarPelicula(tituloEliminado);
                    break;
                case 5:
                    Peliculas.mostrarTabla();
                    break;
                default:
                    System.out.println("Número introducido incorrecto, vuelve a intentarlo");
            }
        }
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

            System.out.println("Título\t\t\tDirector\t\t\tAño\t\tGénero\t\tRating\n" +
                    "----------------------------------------------------------------");

            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.print(rs.getInt(3) + "\t");
                System.out.print(rs.getString(4) + "\t");
                System.out.println(rs.getDouble(5));
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

            System.out.println("Título\t\t\tDirector\t\t\tAño\t\tGénero\t\tRating\n" +
                    "----------------------------------------------------------------");

            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.print(rs.getInt(3) + "\t");
                System.out.print(rs.getString(4) + "\t");
                System.out.println(rs.getDouble(5));
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
