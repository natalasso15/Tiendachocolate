
package tiendachocolate.interfaces;

import com.chocolateTienda.models.producto;
import java.util.List;

/**
 *
 * @author NATALIA LASSO
 */
public interface DAOproducto {
    public void registrar(producto productos) throws Exception;
    public void modificar(producto productos) throws Exception;
    public void eliminar(int codigo) throws Exception;
    public List<producto> listar(String Nombre) throws Exception;
    public producto getProductById(int codigo) throws Exception;
    
}
