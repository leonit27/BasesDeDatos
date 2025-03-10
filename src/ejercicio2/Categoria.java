package ejercicio2;

import java.sql.*;

public class Categoria {
    private int cod_cat;
    private String descripcio;

    public Categoria(int cod_cat,String descripcio){
        this.cod_cat = cod_cat;
        this.descripcio = descripcio;
    }

    public void agregarCategoria(int cod_cat,String descripcio){
        PreparedStatement st = null;
        Connection con = null;

        String sql = "INSERT INTO article(cod_cat, descripcio) VALUES (?, ?)";

        try {
            con = DatabaseConnectionFac2.getConnection();
            st = con.prepareStatement(sql);

            st.setInt(1,cod_cat);
            st.setString(2,descripcio);
            st.executeUpdate();

        }catch (SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }finally {
            try {
                if (st != null && !st.isClosed()){
                    st.close();
                }
            }catch (SQLException ex) {
                System.out.println("No se ha podido cerrar el Statement");
            }

            try {
                if (con != null && !con.isClosed()){
                    con.close();
                }
            }catch (SQLException ex) {
                System.out.println("No se ha podido cerrar la conexion");
            }
        }

    }

    public static void listarCategoria(){
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = DatabaseConnectionFac2.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM categoria");

            System.out.println("cod_cat \t\t\tdescripcio");
            System.out.println("--------------------------------------------");

            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t\t\t");
                System.out.println(rs.getString(2));
            }
        }catch (SQLException ex){
            System.out.println("Se ha producido un error al leer la categoria: " + ex.getMessage());
        }finally {
            try {
                if (st != null && !st.isClosed()){
                    st.close();
                }
            }catch (SQLException ex) {
                System.out.println("Se ha producido un error al cerrar el Statement " + ex.getMessage());
            }

            try {
                if (con != null && !con.isClosed()){
                    con.close();
                }
            }catch (SQLException ex) {
                System.out.println("Se ha producido un error al cerrar la conexión." + ex.getMessage());
            }

            try {
                if (rs != null && !rs.isClosed()){
                    rs.close();
                }
            }catch (SQLException ex) {
                System.out.println("Se ha producido un error al cerrar el ResultSet " + ex.getMessage());
            }
        }
    }
}
