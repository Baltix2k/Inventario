package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static Connection conn;
    //Libreria de MySQL com.mysql.jdbc.Driver
    public String driver = "com.mysql.jdbc.Driver";
    
    //Nombre de la base de datos
    public String database = "Inventario";
    
    //Host
    public String hostname = "localhost";
    
    //Puerto
    public String port = "3306";
    
    //Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    public String url = "jdbc:mysql://"+hostname+":"+port+"/"+database+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    //Nombre de usuario 
    public String username = "root";
    
    //Clave de usuario
    public String password = "Jinchuriki2k";
    
    public Connection conectarMySQL(){
        conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username, password);
            System.out.println("Se establecio la conexion a la base de datos");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error en la conexion de la base de datos");
            e.printStackTrace();
        }
        
        return conn;
    }
    
     public Connection getConnection(){
        return conn;
    }
    
    public void desconectar(){
        conn=null;
    }
}
