package ejercicioSQLite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


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

    public static void agregarPeliculas (String titulo, String director, int anyo, String genero, double rating) {
        PreparedStatement st = null;
        Connection conn = null;
        
        String sql = "INSERT INTO peliculas(titulo, director, año, genero, rating) VALUES (?, ?, ?, ?, ?)";
        
        try {
            conn = DatabaseConnectionPelis.getConnection();
            st = conn.prepareStatement(sql);
            
            st.setString(1, titulo);
            st.setString(2, director);
            st.setInt(3, anyo);
            st.setString(4, genero);
            st.setDouble(5, rating);
        }catch (SQLException ex){
            System.out.println("Error "+ ex.getMessage());
        }finally {
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
}
