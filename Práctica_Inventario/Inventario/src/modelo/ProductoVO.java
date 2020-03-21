package modelo;

public class ProductoVO {
    int clave;
    String nombre;
    String descripcion;
    String unidad;
    int cantidad;
    float precio;
    
    public ProductoVO(){
        this.clave = 0;
        this.nombre = "";
        this.descripcion = "";
        this.unidad = "";
        this.cantidad = 0;
        this.precio = 0;   
    }

    public ProductoVO(int clave, String nombre, String descripcion, String unidad, int cantidad, float precio) {
        this.clave = clave;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidad = unidad;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUnidad() {
        return unidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getPrecio() {
        return precio;
    }
    
    @Override
    public String toString(){
        return "Producto\nClave: "+clave+"\nNombre: "+nombre+"\nDescripcion: "+descripcion+"\nUnidad: "+unidad+"\nCantidad: "+cantidad+"\nPrecio: "+precio;
    }
}
