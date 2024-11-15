
package tiendachocolate.interfaces;


import com.chocolateTienda.models.carritocompra;
import java.util.List;

/**
 *
 * @author NATALIA LASSO
 */
public interface DAOcarritocompra {
    public void registrar(carritocompra productos, int id) throws Exception;
    public void modificar(carritocompra productos) throws Exception;
    public void eliminar(int codigo) throws Exception;
    public List<carritocompra> listar(String Codigo) throws Exception;
    public carritocompra getProductCarritoById(int codigo) throws Exception;
    public void vaciarCarrito(int Codigo) throws Exception;
    
}
