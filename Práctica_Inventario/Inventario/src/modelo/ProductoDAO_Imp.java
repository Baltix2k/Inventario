package modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO_Imp implements ProductoDAO{
    @Override
    public boolean create (ProductoVO producto){
        boolean created = false;
        Statement stm = null;
        Connection con = null;
        String sql = "INSERT INTO producto values ("+producto.getClave()+",'"+producto.getNombre()+"','"+producto.getDescripcion()+"','"+producto.getUnidad()+"',"+producto.getCantidad()+","+producto.getPrecio()+");";
        ConexionBD cc = new ConexionBD();
        try{
            con = cc.conectarMySQL();
            stm = con.createStatement();
            stm.execute(sql);
            created = true;
            stm.close();
            con.close();
        }catch(SQLException e){
            System.out.println("Error al agregar producto, método registrar");
            e.printStackTrace();
        }
        return created;
    }
    
    @Override
    public List<ProductoVO> readAll(){
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM producto ORDER BY clave";
        
        List<ProductoVO> listaProductos = new ArrayList<ProductoVO>();
        
        try{
            con = new ConexionBD().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()){
                ProductoVO p = new ProductoVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getFloat(6));
                listaProductos.add(p);
            }
            stm.close();
            rs.close();
            con.close();
        }catch(SQLException e){
            System.out.println("Error: Clase ProductoDAO_Imp, metodo readAll");
        }
        return listaProductos;
    }
    
    @Override
    public boolean modificar(String sentencia) {
        boolean modif = false;
        Statement stm = null;
        Connection con = null;
        String sql = sentencia;
        ConexionBD cc = new ConexionBD();
        try{
            con = cc.conectarMySQL();
            stm = con.createStatement();
            stm.executeUpdate(sql);
            stm.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error al modificar estudiante, método modificar");
            e.printStackTrace();
        }
        return modif;
    }
    
    @Override
    public boolean eliminar(int clave){
        boolean elim = false;
        Statement stm = null;
        Connection con = null;
        String sql = "DELETE FROM producto WHERE clave = "+clave+";";
        ConexionBD cc = new ConexionBD();
        try{
            con = cc.conectarMySQL();
            stm = con.createStatement();
            stm.execute(sql);
            stm.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error al modificar producto, método modificar");
            e.printStackTrace();
        }
        return elim;
    }
    
    /*@Override
    public float obtenerPrecio(int clave){
        float precio = 0;
        Statement stm = null;
        Connection con = null;
        String sql = "SELECT precio FROM producto WHERE clave = "+clave+";";
        try{
            con = new ConexionBD().conectarMySQL();
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            precio = rs.getFloat(6);
            
            stm.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error al obtener precio, método obtenerPrecio");
            e.printStackTrace();
        }
        
        return precio;
    }
    
    @Override
    public int obtenerCantidad(int clave){
        int cant = 0;
        Statement stm = null;
        Connection con = null;
        String sql = "SELECT cantidad FROM producto WHERE clave = "+clave+";";
        try{
            con = new ConexionBD().conectarMySQL();
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            cant = rs.getInt(5);
            
            stm.close();
            con.close();
        }catch(Exception e){
            System.out.println("Error al obtener cantidad, método obtenerCantidad");
            e.printStackTrace();
        }
        
        return cant;
    }*/
    
    @Override
    public ProductoVO readOne(int clave){
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM producto WHERE clave = "+clave+";";
        ProductoVO product = new ProductoVO();
        
        try{
            con = new ConexionBD().conectarMySQL();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            
            product.setClave(rs.getInt(1));
            product.setNombre(rs.getString(2));
            product.setDescripcion(rs.getString(3));
            product.setUnidad(rs.getString(4));
            product.setCantidad(rs.getInt(5));
            product.setPrecio(rs.getFloat(6));
            
            stm.close();
            rs.close();
            con.close();
        }catch(SQLException e){
            System.out.println("Error: Clase ProductoDAO_Imp, metodo readAll");
        }
        return product;
    }
    
    @Override
    public boolean cantidadExistente (ProductoVO producto, int cantSolicitada){
        boolean cantidadSufieciente = false;
        if (cantSolicitada > producto.getCantidad()){
            System.out.println("Cantidad insuficiente");
        }else{
            cantidadSufieciente = true;
            Statement stm = null;
            Connection con = null;
            String sql = "UPDATE producto SET cantidad = "+(producto.getCantidad() - cantSolicitada)+" WHERE clave = "+producto.getClave()+";";
            ConexionBD cc = new ConexionBD();
            try{
                con = cc.conectarMySQL();
                stm = con.createStatement();
                stm.executeUpdate(sql);
                stm.close();
                con.close();
            }catch(Exception e){
                System.out.println("Error al actualizar cantidad producto, método cantidadExistente");
                e.printStackTrace();
            }
        }
        return cantidadSufieciente;
    }
    
    @Override
    public int getCantidad(int clave){
        int cantidad=0;
        Connection con=null;
        Statement stm=null;
        ResultSet rs=null;
        String sql="SELECT cantidad FROM producto WHERE clave='"+clave+"'";
        try{
            con=new ConexionBD().conectarMySQL();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            rs.next();
            cantidad=rs.getInt(1);
            stm.close();
            rs.close();
            con.close();
        }catch(SQLException e){
            System.out.println("ERROR. Clase Producto_DAO_Imp, metodo getCantidad");
            e.printStackTrace();
        }
        return cantidad;
    }
    
    @Override
    public double getPrecio(int clave){
        float precio=0;
        Connection con=null;
        Statement stm=null;
        ResultSet rs=null;
        String sql="SELECT precio FROM producto WHERE clave='"+clave+"'";
        try{
            con=new ConexionBD().conectarMySQL();
            stm=con.createStatement();
            rs=stm.executeQuery(sql);
            rs.next();
            precio=rs.getFloat(1);
            stm.close();
            rs.close();
            con.close();
        }catch(SQLException e){
            System.out.println("ERROR. Clase Producto_DAO_Imp, metodo getPrecio");
            e.printStackTrace();
        }
        return precio;
    }
    
    @Override
    public boolean aumentar (int clave, int cantidad, float precio){
        boolean aumentado=false;
        int cantidadTotal=this.getCantidad(clave)+cantidad;
        double precioTotal=((this.getPrecio(clave)*(cantidadTotal-cantidad))+(cantidad*precio))/cantidadTotal;
        Connection con=null;
        Statement stm=null;
        String sql="UPDATE producto SET cantidad='"+cantidadTotal+"', precio='"+precioTotal+"' WHERE clave='"+clave+"'";
        ConexionBD cc= new ConexionBD();
        try{
            con=cc.conectarMySQL();
            stm=con.createStatement();
            stm.execute(sql);
            aumentado=true;
            stm.close();
            con.close();
        }catch (SQLException e){
            System.out.println("ERROR. No se pudo actualizar la cantidad del producto, metodo aumentar");
            e.printStackTrace();
        }
        return aumentado;
    }
    
    @Override
    public boolean disminuir (int clave, int cantidad){
        boolean disminuido=false;
        int cantidadActual=this.getCantidad(clave);
        if ((cantidadActual-cantidad)>0){
            cantidadActual=cantidadActual-cantidad;
            Connection con=null;
            Statement stm=null;
            String sql="UPDATE producto SET cantidad='"+cantidadActual+"' WHERE clave='"+clave+"'";
            ConexionBD cc= new ConexionBD();
            try{
                con=cc.conectarMySQL();
                stm=con.createStatement();
                stm.execute(sql);
                disminuido=true;
                stm.close();
                con.close();
            }catch (SQLException e){
                System.out.println("ERROR. No se pudo actualizar la cantidad del producto, metodo aumentar");
                e.printStackTrace();
            }
        }
        return disminuido;
    }
}
