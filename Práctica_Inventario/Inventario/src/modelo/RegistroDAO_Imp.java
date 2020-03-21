package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class RegistroDAO_Imp implements RegistroDAO{
    @Override
    public boolean crearRegistro(int folio, ProductoVO producComprado, int cantSolicitada) {
        boolean created = false;
        Statement stm = null;
        Connection con = null;
        String sql = "INSERT INTO venta_producto values ("+folio+","+producComprado.getClave()+","+cantSolicitada+","+(producComprado.getPrecio() * producComprado.getCantidad())+");";
        ConexionBD cc = new ConexionBD();
        try{
            con = cc.conectarMySQL();
            stm = con.createStatement();
            stm.execute(sql);
            created = true;
            stm.close();
            con.close();
        }catch(SQLException e){
            System.out.println("Error al registrar producto en venta, método crearRegistro");
            e.printStackTrace();
        }
        return created;
    }

}
