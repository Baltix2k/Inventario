package modelo;

public class RegistroVO {
    int folio;
    int clave;
    int cantidad;
    float totalProducto;

    public RegistroVO(int folio, int clave, int cantidad, float totalProducto) {
        this.folio = folio;
        this.clave = clave;
        this.cantidad = cantidad;
        this.totalProducto = totalProducto;
    }
    
    public RegistroVO(){
        this.folio = 0;
        this.clave = 0;
        this.cantidad = 0;
        this.totalProducto = 0;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setTotalProducto(float totalProducto) {
        this.totalProducto = totalProducto;
    }

    public int getFolio() {
        return folio;
    }

    public int getClave() {
        return clave;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getTotalProducto() {
        return totalProducto;
    }
    
}
