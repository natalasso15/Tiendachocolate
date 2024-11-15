/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendachocolate.implementaciones;
import com.chocolateTienda.interfaces.DAOcarritocompra;
import com.chocolateTienda.models.carritocompra;
import com.chocolateTienda.models.producto;
import con.chocolateTienda.DBtienda.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import tiendachocolate.interfaces.DAOcarritocompra;
import tiendachocolate.models.carritocompra;
import tiendachocolate.models.producto;

/**
 *
 * @author NATALIA LASSO
 */
public class DAOcarritocompraImpl extends Database implements DAOcarritocompra {

    @Override
    public void registrar(carritocompra productos, int id) throws Exception {
     producto user = null;
     
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM producto WHERE codigo = ? LIMIT 1;");
            st.setInt(1, productos.getcodigo());
            
            ResultSet rs = st.executeQuery();
            while(rs.next()) {  
            System.out.print(rs.getString("Nombre"));
            try {
            PreparedStatement sto = this.conexion.prepareStatement("INSERT INTO carritocompra(Producto, Total,Cantidad,CodigoUsuario) VALUES(?,?,?,?);");
            sto.setString(1,rs.getString("Nombre") );
            sto.setInt(2,rs.getInt("Precio") );
            sto.setInt(3,productos.getcantidad());
            sto.setInt(4,id);
            sto.executeUpdate();
            sto.close();
             } catch(Exception e) {
            throw e;
        }finally {
          this.Cerrar();
        }
            }
            rs.close();
            st.close();
        } catch(Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        }   
            
    @Override
    public void modificar(carritocompra productos) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE carritocompra SET Cantidad = ? WHERE Codigo = ?");
            st.setInt(1, productos.getcantidad());
            st.setInt(2, productos.getcodigo());
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
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM carritocompra WHERE codigo = ?;");
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
    public List<carritocompra> listar(String Codigo) throws Exception {
        List<carritocompra> lista = new ArrayList<>();
       

        try {
            this.Conectar();

            String query = "SELECT * FROM carritocompra WHERE CodigoUsuario LIKE ?";
            PreparedStatement st = this.conexion.prepareStatement(query);
            st.setString(1, "%" + Codigo + "%");

            ResultSet rs = st.executeQuery();
            
while (rs.next()) {
                
                System.out.print(rs.getString("Producto"));
                carritocompra user = new carritocompra();
                user.setcodigo(rs.getInt("Codigo"));
                user.setProducto(rs.getString("Producto"));
                user.setTotal(rs.getInt("Total"));
                
                user.setcantidad(rs.getInt("Cantidad")); // Asegúrate de que el nombre de la columna es "Cantidad"
                lista.add(user);
            }
rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }

        return lista;
    }

    @Override
    public carritocompra getProductCarritoById(int codigo) throws Exception {
        carritocompra user = null;
        
        try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM carritocompra WHERE codigo = ? LIMIT 1;");
            st.setInt(1, codigo);
            
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                user = new carritocompra();
                user.setcodigo(rs.getInt("Codigo"));
                user.setcantidad(rs.getInt("Cantidad"));
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
    public void vaciarCarrito(int Codigo) throws Exception {
          try {
            this.Conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE FROM carritocompra WHERE CodigoUsuario = ?;");
            st.setInt(1, Codigo);
            st.executeUpdate();
            st.close();
        } catch(Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}