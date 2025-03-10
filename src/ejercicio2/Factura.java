package ejercicio2;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Factura {
    private int num_f;
    private String data;
    private int cod_cli;
    private String cod_ven;
    private double iva;
    private double dte;

    public Factura(int num_f,String data,int cod_cli,int cod_ven,double iva, double dte){
        this.num_f=num_f;
        this.cod_cli=cod_cli;
        this.cod_ven= null;
        this.iva=iva;
        this.dte=dte;
    }

    public void agregarFactura(int num_f,String data,int cod_cli,int cod_ven,double iva,double dte){
        PreparedStatement st = null;
        Connection con = null;

        String sql = "INSERT INTO article(num_f, data, cod_cli, cod_ven, iva, dte) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            con = DatabaseConnectionFac2.getConnection();
            st = con.prepareStatement(sql);

            st.setInt(1,num_f);
            st.setString(2,data);
            st.setInt(3,cod_cli);
            st.setInt(4,cod_ven);
            st.setDouble(5,iva);
            st.setDouble(6,dte);
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
}
