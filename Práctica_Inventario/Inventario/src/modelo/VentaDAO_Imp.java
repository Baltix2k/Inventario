package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class VentaDAO_Imp implements VentaDAO{
    @Override
    public boolean crear (VentaVO venta){
        boolean created = false;
        Statement stm = null;
        Connection con = null;
        String sql = "INSERT INTO venta values (NULL, "+venta.getFecha()+", "+venta.getIva()+", "+venta.getTotalPagado()+");";
        //String sql = "INSERT INTO venta values (NULL, NULL, NULL, NULL);";
        ConexionBD cc = new ConexionBD();
        try{
            con = cc.conectarMySQL();
            stm = con.createStatement();
            stm.executeQuery(sql);
            created = true;
            stm.close();
            con.close();
        }catch(SQLException e){
            System.out.println("Error al generar venta, metodo crear");
        }        
        return created;
    }
    
    @Override
    public int obtenerVenta(){
        int folio = 0;
        Statement stm = null;
        Connection con = null;
        ResultSet rs = null;
        String sql = "SELECT folio FROM venta;";
        try{
            con = new ConexionBD().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
                folio = rs.getInt(1);
            }
            stm.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error al obtener venta, método obtenerVenta");
            e.printStackTrace();
        }
        
        return folio;
    }   
    
    @Override
    public void finalizarVenta(int folio, float iva, float total){
        Statement stm = null;
        Connection con = null;
        String sql = "UPDATE venta SET iva = "+iva+", totalPagado = "+total+" WHERE folio = "+folio+";";
        ConexionBD cc = new ConexionBD();
        try{
            con = cc.conectarMySQL();
            stm = con.createStatement();
            stm.executeUpdate(sql);
            stm.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error al finalizar compra, método finalizarCompra");
            e.printStackTrace();
        }
    }
    
    @Override
    public float calculartotal (int folio){
        float totalProducto = 0;
        float pagoTotal = 0;
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT totalProducto FROM venta_producto WHERE folio = "+folio+";";
        
        try{
            con = new ConexionBD().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
                totalProducto = rs.getFloat(1);
                pagoTotal = pagoTotal+totalProducto;
            }
            stm.close();
            rs.close();
            con.close();
        }catch(SQLException e){
            System.out.println("Error: Clase ProductoDAO_Imp, metodo readAll");
        }
        return pagoTotal;
    } 
}
