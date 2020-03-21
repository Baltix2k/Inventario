package modelo;

public interface VentaDAO {
    public boolean crear (VentaVO venta);
    public int obtenerVenta();
    public void finalizarVenta(int folio, float iva, float total);
    public float calculartotal (int folio);
}
