
package tiendachocolate.models;

/**
 *
 * @author NATALIA LASSO
 */
public class producto {
    private String nombre;
    private int precio;
    private int codigo;

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
     }
    public int getcodigo() {
        return codigo;
    }

    public void setcodigo(int codigo) {
        this.codigo = codigo;
    }
    
}
