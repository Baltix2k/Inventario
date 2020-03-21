package controlador;


import java.util.List;
import modelo.ProductoDAO_Imp;
import modelo.ProductoVO;
import modelo.RegistroDAO_Imp;
import modelo.VentaDAO_Imp;
import modelo.VentaVO;
import vista.Mensajes;

public class Operaciones {
    Mensajes ms;
    ProductoDAO_Imp productDAOImp;
    VentaDAO_Imp ventaDAOImp;
    RegistroDAO_Imp registroDAOImp;
    
    public Operaciones(){
        this.ms = new Mensajes();
        this.productDAOImp = new ProductoDAO_Imp();
    }
    
    public void guardar(int clave,String nombre,String descrip, String unidad, int cantidad, float precio){
        ProductoVO ep = new ProductoVO(clave,nombre, descrip, unidad, cantidad, precio);
        ProductoDAO_Imp ei = new ProductoDAO_Imp();
        ei.create(ep);
    }
    
    public void mostrar(){
        List<ProductoVO> lista = productDAOImp.readAll();
        ms.mostrarProductos(lista);
    }
    
    public String modificar(int clave, int indice){
        String sentencia = "";
        String newString;
        int newInt;
        float newFloat;
        switch(indice){
            case 1:
                newInt = ms.leerClave();
                sentencia = "UPDATE producto SET calve = "+newInt+" WHERE clave = "+clave+";";
            break;

            case 2:
                newString = ms.leerNombre();
                sentencia = "UPDATE producto SET nombre = '"+newString+"' WHERE clave = "+clave+";";
            break;
                
            case 3:
                newString = ms.leerDescripcion();
                sentencia = "UPDATE producto SET descripcion = '"+newString+"' WHERE clave = "+clave+";";
            break;
                
            case 4:
                newString = ms.leerUnidad();
                sentencia = "UPDATE producto SET unidad = '"+newString+"' WHERE clave = "+clave+";";
            break;
                
            case 5:
                newInt = ms.leerCantidad();
                sentencia = "UPDATE producto SET cantidad = "+newInt+" WHERE clave = "+clave+";";
            break;
                
            case 6:
                newFloat = ms.leerPrecio();
                sentencia = "UPDATE producto SET precio = "+newFloat+" WHERE clave = "+clave+";";
            break;

            default:
                System.out.println("Opcion invalida");
        }
        return sentencia;
    }
    
    public void ejecutarAplicacion(){
        int opcion = 0;
        do{
            ms.menu();
            opcion = ms.opcionEntero();
            switch(opcion){
                case 1:
                {
                    ms.agregarMensaje();
                    int clave = ms.leerClave();
                    String nombre = ms.leerNombre();
                    String descrip = ms.leerDescripcion();
                    String unidad = ms.leerUnidad();
                    int cantidad = ms.leerCantidad();
                    float precio = ms.leerPrecio();
                    ProductoVO producto = new ProductoVO(clave,nombre,descrip,unidad,cantidad,precio);
                    boolean creado = this.productDAOImp.create(producto);
                    ms.resultadoOperacion(creado, "crear");
                }
                break;
                
                case 2:
                    List<ProductoVO> lista = this.productDAOImp.readAll();
                    ms.mostrarProductos(lista);
                    
                break;
                    
                case 3:
                {
                    ms.modificarMensaje();
                    int clav = ms.leerClave();
                    ms.menuModificar();
                    int op = 0;
                    op = ms.opcionEntero();
                    boolean modificar = this.productDAOImp.modificar(this.modificar(clav, op));
                    ms.resultadoOperacion(modificar, "modificar");
                }
                break;
                    
                case 4:
                {
                    int clave = ms.leerClave();
                    boolean eliminado = this.productDAOImp.eliminar(clave);
                    ms.resultadoOperacion(eliminado, "eliminar");
                }
                break;
                  
                case 5:
                {
                    int opc = 0;
                    float total = 0;
                    
                    VentaVO venta = new VentaVO();
                    boolean creada = this.ventaDAOImp.crear(venta); //Crear venta en BD
                    ms.resultadoOperacion(creada, "crear"); 
                    venta.setFolio(this.ventaDAOImp.obtenerVenta()); //Usar folio creado
                    
                       
                    do{
                        int clave = ms.leerClave();
                        int cantSolicitada = ms.leerCantidad();
                        ProductoVO producComprado = this.productDAOImp.readOne(clave);
                        boolean suficiente = this.productDAOImp.cantidadExistente(producComprado, cantSolicitada);
                        boolean registrar = this.registroDAOImp.crearRegistro(venta.getFolio(), producComprado, cantSolicitada);
                        opc = ms.otroProducto();
                    }while(opc != 0);
                    total = this.ventaDAOImp.calculartotal(venta.getFolio());
                    float iva = (float) (total * .16);
                    this.ventaDAOImp.finalizarVenta(venta.getFolio(), iva, (total+iva));
                    System.out.println("Total a pagar: "+(total+iva));
                    System.out.println("IVA: "+iva);
                }
                break;
                    
                case 6:
                {
                    //ms.aumentar();
                    System.out.println("Aumentar cantidad");
                    int clave = ms.leerClave();
                    int cantidad = ms.leerCantidad();
                    float  precio = ms.leerPrecio();
                    boolean aumentado= this.productDAOImp.aumentar(clave, cantidad, precio);
                    ms.resultadoOperacion(aumentado, "Aumentar cantidad.");
                break;
                }
                case 7:
                {
                    //ms.disminuir();
                    System.out.println("Disminuir cantidad");
                    int clave= ms.leerClave();
                    int cantidad= ms.leerCantidad();
                    boolean disminuido= this.productDAOImp.disminuir(clave, cantidad);
                    ms.resultadoOperacion(disminuido, "Disminuir cantidad");
                break;
                }
                    
                case 8:
                    System.out.println("Saliendo del sistema...");
                break;
                    
                default:
                    System.out.println("Opción inválida");
                break;
                    
            }
        }while(opcion != 8);
    }
}
