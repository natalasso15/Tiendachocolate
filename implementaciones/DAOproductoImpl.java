
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendachocolate.implementaciones;

import com.chocolateTienda.interfaces.DAOproducto;
import com.chocolateTienda.models.producto;
import con.chocolateTienda.DBtienda.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import tiendachocolate.interfaces.DAOproducto;
import tiendachocolate.models.producto;

/**
 *
 * @author NATALIA LASSO
 */
public class DAOproductoImpl extends Database implements DAOproducto {

    @Override
    public void registrar(producto productos) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO producto(Nombre, Precio) VALUES(?,?);");
            st.setString(1, productos.getNombre());
            st.setInt(2, productos.getPrecio());
            st.executeUpdate();
            st.close();
        } catch(Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        } 
    }

    @Override
    public void modificar(producto productos) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE producto SET Nombre = ?, Precio = ? WHERE Codigo = ?");
            st.setString(1, productos.getNombre());
            st.setInt(2, productos.getPrecio());
            st.setInt(3, productos.getcodigo());
            st.executeUpdate();
            st.close();
        } catch(Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(int codigo) throws Exception {
     try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM producto WHERE codigo = ?;");
            st.setInt(1, codigo);
            st.executeUpdate();
            st.close();
        } catch(Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }  
    }

    @Override
    public List<producto> listar(String Nombre) throws Exception {
        List<producto> lista = null;
        try {
            this.Conectar();
            String Query = Nombre.isEmpty() ? "SELECT * FROM producto;" : "SELECT * FROM producto WHERE Nombre LIKE '%" + Nombre + "%';";
            PreparedStatement st = this.conexion.prepareStatement(Query);
lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                producto user = new producto();
                user.setcodigo(rs.getInt("codigo"));
                user.setNombre(rs.getString("Nombre"));
String precioString = rs.getString("Precio"); // Obtiene el valor de la columna "Precio" como String
                int precio = Integer.parseInt(precioString); // Convierte el String a int
                user.setPrecio(precio); // Establece el precio
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
    public producto getProductById(int codigo) throws Exception {
        producto user = null;
        
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM producto WHERE codigo = ? LIMIT 1;");
            st.setInt(1, codigo);
ResultSet rs = st.executeQuery();
            while(rs.next()) {
                user = new producto();
                user.setcodigo(rs.getInt("Codigo"));
                user.setNombre(rs.getString("Nombre"));
                String precioString = rs.getString("Precio"); // Obtiene el valor de la columna "Precio" como String
                int precio = Integer.parseInt(precioString); // Convierte el String a int
                user.setPrecio(precio); // Establece el precio
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
    
}