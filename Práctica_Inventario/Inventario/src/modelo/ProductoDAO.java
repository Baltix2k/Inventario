package modelo;

import java.util.List;

public interface ProductoDAO {
    public boolean create (ProductoVO producto);
    public List<ProductoVO> readAll();
    public boolean modificar(String sentencia);
    public boolean eliminar(int clave);
    //public float obtenerPrecio(int clave);
    //public int obtenerCantidad(int clave);
    public ProductoVO readOne(int clave);
    public boolean cantidadExistente (ProductoVO producto, int cantSolicitada);
    public int getCantidad(int clave);
    public double getPrecio(int clave);
    public boolean aumentar (int clave, int cantidad, float precio);
    public boolean disminuir (int clave, int cantidad);
}
