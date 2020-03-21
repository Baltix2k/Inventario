/**
 * Asignación del programa: Inventario
 * @author Omar Baltazar Islas
 * Fecha: 17/03/2020
 * Descripción: Esta clase contiene los distintos mensajes que se muestran durante el programa
 **/  

package vista;

import java.util.Iterator;
import java.util.List;
import modelo.ProductoVO;

public class Mensajes{
    Teclado teclado;
    
    public Mensajes(){
        this.teclado = new Teclado();
    }
    
    /**
     * Este método devuelve la opción seleccionada en formato int
     * @return int Devuelve la opción seleccionada por el usuario 
    **/
    public int opcionEntero(){
        int opcion = 0;
        System.out.print("Introduce un numero: ");
        opcion = teclado.leerEntero();
        return opcion;
    }
    
    /**
     * Este método muestra el menu principal del programa
    **/
    public void menu(){
        System.out.println("Elige un opcion");
        System.out.println("1) Agregar");
        System.out.println("2) Mostrar");
        System.out.println("3) Modificar");
        System.out.println("4) Eliminar");
        System.out.println("5) Generar venta");
        System.out.println("6) Aumentar cantidad existente de producto");
        System.out.println("7) Disminuir cantidad existente de producto");
        System.out.println("8) Salir");
    }
    
    /**
     * Este método muestra el menu de la opción de modificar prducto
    **/
    public void menuModificar(){
        System.out.println("Elige un opcion");
        System.out.println("1) Clave");
        System.out.println("2) Nombre");
        System.out.println("3) Descirpcion");
        System.out.println("4) Unidad");
        System.out.println("5) Cantidad");
        System.out.println("6) Precio");
    }
    
    /**
     * Este método muestra elmensaje de confrimación de producto agrgado
    **/
    public void agregarMensaje(){
        System.out.println("Ingresando producto...");
    }
    
    /**
     * Este método muestra elmensaje de confrimación de producto modificado
    **/
    public void modificarMensaje(){
        System.out.println("Modificar producto...");
    }
    
    //Lectura de atributos........................................
    /**
     * Este método lee una clave ingresada por un usuario
     * @return int Devuelve la clave ingresada
    **/
    public int leerClave(){
        int clave = 0;
        System.out.print("Introduce la clave: ");
        clave = teclado.leerEntero();
        
        return clave;
    }
    
    /**
     * Este método lee un nombre ingresado por un usuario
     * @return String Devuelve el nombre ingresado
    **/
    public String leerNombre(){
        String nombre;
        System.out.print("Introduce un nombre: ");
        nombre = teclado.leerCadena();
        
        return nombre;
    }
    
    /**
     * Este método lee una descripción ingresada por un usuario
     * @return String Devuelve la descripción ingresada
    **/
    public String leerDescripcion(){
        String descrip;
        System.out.print("Introduce una descripcion: ");
        descrip = teclado.leerCadena();
        
        return descrip;
    }
    
    /**
     * Este método lee la unidad del producto ingresada por un usuario
     * @return String Devuelve la unidad ingresada
    **/
    public String leerUnidad(){
        String unidad;
        System.out.print("Introduce la unidad del producto: ");
        unidad = teclado.leerCadena();
        
        return unidad;
    }
    
    /**
     * Este método lee una cantidad ingresada por un usuario
     * @return int Devuelve la cantidad ingresada
    **/
    public int leerCantidad(){
        int cant = 0;
        System.out.print("Introduce la cantidad: ");
        cant = teclado.leerEntero();
        
        return cant;
    }
    
    /**
     * Este método lee un preicio inresado por un usuario
     * @return float Devuelve el precio ingresado
    **/
    public float leerPrecio(){
        float precio;
        System.out.print("Introduce el precio del producto: ");
        precio = teclado.leerFlotante();
        
        return precio;
    }
    
    /**
     * Este método lee una una opción de ingreso de otro producto a la venta generada por un usuario
     * @return int Devuelve la opción seleccionada
    **/
    public int otroProducto(){
        int opcion;
        System.out.print("Deseas agregar más productos? [Si = 1 / No = 0: ");
        opcion = teclado.leerEntero();
        
        return opcion;
    }
    
    /**
     * Este método lee una clave ingresada por un usuario
    **/
    public void mostrarProductos(List<ProductoVO> lista){
        System.out.println("\t PRODUCTOS: ");
        Iterator<ProductoVO> iteradorE = lista.iterator();
        
        while(iteradorE.hasNext()){
            System.out.println("\t \t "+iteradorE.next());
        }
    }

    public void resultadoOperacion(boolean resultado, String operacion){
        if(resultado){
            System.out.println(" \n     Resultado Exitoso al "+ operacion +"\n");
        }else{
            System.out.println(" \n     Resultado Fallido al "+ operacion +"\n");
        }
    }
}
