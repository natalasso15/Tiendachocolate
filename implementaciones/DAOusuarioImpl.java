/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendachocolate.implementaciones;


import com.chocolateTienda.interfaces.DAOusuario;
import com.chocolateTienda.models.Usuario;
import con.chocolateTienda.DBtienda.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import tiendachocolate.interfaces.DAOusuario;

/**
 *
 * @author NATALIA LASSO
 */
public class DAOusuarioImpl extends Database implements DAOusuario {

    @Override
    public void registrar(Usuario user) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO users (Name, Password,TipoUsuario) VALUES(?,?,?);");
            st.setString(1, user.getNombre());
            st.setString(2, user.getPassword());
            System.out.print("Registrar"+ user.getPassword());
            st.setString(3, "Cliente");
            st.executeUpdate();
            st.close();
        } catch(Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void sancionar(Usuario user) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE users SET Name = ?, Password = ? WHERE id = ?");
            st.setString(1, user.getNombre());
            st.setString(2, user.getPassword());
       
            st.setInt(3, user.getid());
            st.executeUpdate();
            st.close();
        } catch(Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(int userId) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM users WHERE id = ?;");
            st.setInt(1, userId);
            st.executeUpdate();
            st.close();
        } catch(Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<Usuario> listar(String name) throws Exception {
        List<Usuario> lista = null;
        try {
            this.Conectar();
            String Query = name.isEmpty() ? "SELECT * FROM users;" : "SELECT * FROM users WHERE Name LIKE '%" + name + "%';";
            PreparedStatement st = this.conexion.prepareStatement(Query);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
while(rs.next()) {
                Usuario user = new Usuario();
                user.setid(rs.getInt("id"));
                user.setNombre(rs.getString("Name"));
                user.setPassword(rs.getString("Password"));
        
                lista.add(user);
            }
rs.close();
            st.close();
        } catch(Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    @Override
    public Usuario getUserById(int userId) throws Exception {
       Usuario user = null;
        
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM users WHERE id = ? LIMIT 1;");
            st.setInt(1, userId);
            
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                user = new Usuario();
                user.setid(rs.getInt("id"));
                user.setNombre(rs.getString("Name"));
                user.setPassword(rs.getString("Password"));
            }
rs.close();
            st.close();
        } catch(Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return user;
    }

    @Override
    public Usuario login(String nombre, String pass) throws Exception {
       this.Conectar();
        PreparedStatement st= this.conexion.prepareStatement("SELECT * FROM users WHERE Name = ? AND Password = ?");
        st.setString(1, nombre);
        st.setString(2, pass);

        ResultSet rs = st.executeQuery();
if (rs.next()) {
            // Si se encuentra el usuario, devuelve un objeto User
            Usuario user=new Usuario();
            user.setid(rs.getInt("id"));
            user.setNombre(rs.getString("Name"));
            user.setPassword(rs.getString("Password"));
            user.setTipoUsuario(rs.getString("TipoUsuario"));
            return  user;
    }else {
            // Si no se encuentra el usuario, devuelve null
            return null;
        }
}
    @Override
    public Usuario VerificacionUsuario(String nombre, String pass) throws Exception {
       this.Conectar();
        PreparedStatement st= this.conexion.prepareStatement("SELECT * FROM users WHERE Name = ?");
        st.setString(1, nombre);

        ResultSet rs = st.executeQuery();
if (rs.next()) {
            // Si se encuentra el usuario, devuelve un objeto User
            Usuario user=new Usuario();
            user.setid(rs.getInt("id"));
            
            user.setNombre(rs.getString("Name"));
            user.setPassword(rs.getString("Password"));
            user.setTipoUsuario(rs.getString("TipoUsuario"));
            
            return  user;
} else {
            // Si no se encuentra el usuario, devuelve null
            return null;
        }
    }
    
}
