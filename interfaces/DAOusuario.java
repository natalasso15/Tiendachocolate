/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tiendachocolate.interfaces;
import com.chocolateTienda.models.Usuario;
import java.util.List;
/**
 *
 * @author NATALIA LASSO
 */
public interface DAOusuario {
        public void registrar(Usuario user) throws Exception;
       public void sancionar(Usuario user) throws Exception;
    public void eliminar(int userId) throws Exception;
    public List<Usuario> listar(String name) throws Exception;
    public Usuario getUserById(int userId) throws Exception;
    public Usuario login (String nombre,String pass) throws Exception;
    public Usuario VerificacionUsuario (String nombre,String pass) throws Exception;
    
}
