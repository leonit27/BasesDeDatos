package ejercicioSQLite;

import ejercicio2.DatabaseConnectionFac2;

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
            conn = DatabaseConnectionPelis.getConnection();
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
            conn = DatabaseConnectionPelis.getConnection();
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
            conn = DatabaseConnectionPelis.getConnection();
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
            conn = DatabaseConnectionPelis.getConnection();
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
            conn = DatabaseConnectionPelis.getConnection();
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
