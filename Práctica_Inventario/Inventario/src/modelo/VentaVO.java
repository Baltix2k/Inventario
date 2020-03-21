package modelo;

public class VentaVO {
    int folio;
    String fecha;
    float iva;
    float totalPagado;
    
    public VentaVO(){
        this.folio = 0;
        this.fecha = " ";
        this.iva = 0;
        this.totalPagado = 0;
    }

    public VentaVO(int folio, String fecha, float iva, float totalPagado) {
        this.folio = folio;
        this.fecha = fecha;
        this.iva = iva;
        this.totalPagado = totalPagado;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public void setTotalPagado(float totalPagado) {
        this.totalPagado = totalPagado;
    }

    public int getFolio() {
        return folio;
    }

    public String getFecha() {
        return fecha;
    }

    public float getIva() {
        return iva;
    }

    public float getTotalPagado() {
        return totalPagado;
    }
}
