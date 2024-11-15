
package tiendachocolate.models;


public class carritocompra {
    private String producto;
    private int total;
    private int codigo;
    private int cantidad;
    private int codigoUsuario;
    

    public String getProducto() {
        return producto;
    }
    public void setProducto(String producto) {
        this.producto = producto;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public int getcodigo() {
        return codigo;
    }
    public void setcodigo(int codigo) {
        this.codigo = codigo;
    }
    public int getcantidad() {
        return cantidad;
    }
    public void setcantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public int getcodigoUsuario() {
        return codigoUsuario;
    }
    public void setcodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }
    
}
