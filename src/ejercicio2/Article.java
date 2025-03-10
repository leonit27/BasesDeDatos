package ejercicio2;

import java.sql.*;

public class Article {

    private int cod_a;
    private String descrip;
    private double preu;
    private int stock;
    private String categoria;
    private int cod_cat;

    public Article (int cod_a,String descrip,double preu, int stock, String categoria){
        this.cod_a = cod_a;
        this.descrip = descrip;
        this.preu = preu;
        this.stock = stock;
        this.categoria = categoria;
    }

    public static void agregarArticle(int cod_a, String descrip, double preu, int stock, String categoria){
        PreparedStatement st = null;
        Connection con = null;

        String sql = "INSERT INTO article(cod_a, descrip, preu, stock, categoria) VALUES (?, ?, ?, ?, ?)";

        try {
            con = DatabaseConnectionFac2.getConnection();
            st = con.prepareStatement(sql);

            st.setInt(1,cod_a);
            st.setString(2,descrip);
            st.setDouble(3,preu);
            st.setInt(4,stock);
            st.setString(5, categoria);
            st.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Error "+ ex.getMessage());
        }finally {
            try {
                if (st != null && !st.isClosed()){
                    st.close();
                }
            }catch (SQLException ex) {
                System.out.println(" No se ha podido cerrar el Statement por alguna razón");
            }

            try {
                if (con != null && !con.isClosed()){
                    con.close();
                }
            }catch (SQLException ex) {
                System.out.println(" No se ha podido cerrar la conexion por alguna razón");
            }

        }
    }

    public static void listarArticle(){

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = DatabaseConnectionFac2.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM article");

            System.out.println("cod_a \tdescrip \t\t\t\t\t\tpreu \tstock \tcategoria");
            System.out.println("-------------------------------------------------------------------");

            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.print(rs.getDouble(3) + "\t");
                System.out.print(rs.getInt(4) + "\t");
                System.out.println(rs.getString(6));
            }
        }catch (SQLException ex){
            System.out.println("Se ha producido un error al leer los articulos: " + ex.getMessage());
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
                System.out.println(" No se ha producido un error al cerrar la conexión." + ex.getMessage());
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

    public static void eliminarArticle(int cod_a){
        PreparedStatement st = null;
        Connection con = null;

        String sql = "DELETE FROM article WHERE cod_a = "+ cod_a;

        try {
            con = DatabaseConnectionFac2.getConnection();
            st = con.prepareStatement(sql);

            st.executeUpdate();
        }catch (SQLException ex){
            System.out.println("Error "+ ex.getMessage());
        }finally {
            try {
                if (st != null && !st.isClosed()){
                    st.close();
                }
            }catch (SQLException ex) {
                System.out.println(" No se ha podido cerrar el Statement por alguna razón");
            }

            try {
                if (con != null && !con.isClosed()){
                    con.close();
                }
            }catch (SQLException ex) {
                System.out.println(" No se ha podido cerrar la conexion por alguna razón");
            }
        }
    }

    public static void modificarArticle(double preu){
        Connection con = null;
        Statement st = null;
        String sql;

        try {
            con = DatabaseConnectionFac2.getConnection();
            st = con.createStatement();

            sql = "UPDATE article SET preu = preu * " + preu;
            st.executeUpdate(sql);


        }catch (SQLException ex){
            System.out.println("Error "+ ex.getMessage());
        }finally {
            try {
                if (st != null && st.isClosed()){
                    st.close();
                }
            }catch (SQLException ex){
                System.out.println("No se a podido cerrar el Statement por alguna razón");
            }

            try {
                if (con != null && con.isClosed()){
                    con.close();
                }
            }catch (SQLException ex){
                System.out.println("No se a podido cerrar la conexión por alguna razón");
            }
        }
    }

}
