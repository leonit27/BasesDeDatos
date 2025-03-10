package ejercicio2;

import java.sql.*;

public class LineaFac {

    private int num_f;
    private int num_l;
    private int cod_a;
    private int quant;
    private double preu;
    private double dte;

    public LineaFac(int num_f, int num_l, int cod_a, int quant, double preu, double dte){

        this.num_f = num_f;
        this.num_l = num_l;
        this.cod_a = cod_a;
        this.quant = quant;
        this.preu = preu;
        this.dte = dte;
    }

    public void agregarArticle(int num_f, int num_l, int cod_a, int quant, double preu, double dte){
        PreparedStatement st = null;
        Connection con = null;

        String sql = "INSERT INTO article(num_f, num_l, cod_a, quant, preu, dte) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            con = DatabaseConnectionFac2.getConnection();
            st = con.prepareStatement(sql);

            st.setInt(1, num_f);
            st.setInt(2, num_l);
            st.setInt(3, cod_a);
            st.setInt(4, quant);
            st.setDouble(5, preu);
            st.setDouble(6, dte);
            st.executeUpdate();
        } catch (SQLException ex){
            System.out.println("Error "+ ex.getMessage());
        } finally {
            try {
                if (st != null && !st.isClosed()){
                    st.close();
                }
            }catch (SQLException ex) {
                System.out.println("No se ha podido cerrar el Statement por alguna razón");
            }

            try {
                if (con != null && !con.isClosed()){
                    con.close();
                }
            }catch (SQLException ex) {
                System.out.println("No se ha podido cerrar la conexion por alguna razón");
            }
        }
    }

    public static void listarLineaFac(){

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = DatabaseConnectionFac2.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM linia_fac");

            System.out.println("num_f \tnum_l \tcod_a \tquant \tpreu \tdte");
            System.out.println("--------------------------------------------");

            while (rs.next()) {
                System.out.print(rs.getInt(1) + "\t");
                System.out.print(rs.getInt(2) + "\t\t");
                System.out.print(rs.getString(3) + "\t\t");
                System.out.print(rs.getInt(4) + "\t");
                System.out.print(rs.getDouble(5) + "\t");
                System.out.println(rs.getDouble(6));
            }

        }catch (SQLException ex){
            System.out.println("Se ha producido un error al leer la linea de la factura: " + ex.getMessage());
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
}
