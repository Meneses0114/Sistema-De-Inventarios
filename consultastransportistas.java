
package Modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class consultastransportistas extends conexionTransportistas{
/*-----------------------------------------------------------------*/
    public boolean registrar(transportistas pro){
        
        PreparedStatement ps =null;
        Connection con = getconexion();
        
        String sql = "INSERT INTO transportistas (nit, nombre, telefono) VALUES (?,?,?)";
        
        try{
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString (1, pro.getNit());
            ps.setString (2, pro.getTelefono());
            ps.setString (3, pro.getNombre());
            ps.execute();
            return true;
        }catch(SQLException e)
        {
            System.err.println(e);
            
        
        return false;
        }finally{
            try{
              con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }


/*-----------------------------------------------------------------*/
    public boolean modificar (transportistas pro){
        
        PreparedStatement ps =null;
        Connection con = getconexion();
        
        String sql = "UPDATE transportistas SET nombre=?, telefono=? WHERE nit=?";
        
        try{
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString (1, pro.getNit());
            ps.setString (2, pro.getTelefono());
            ps.setString (3, pro.getNombre());
            ps.execute();
            return true;
        }catch(SQLException e)
        {
            System.err.println(e);
            
        
        return false;
        }finally{
            try{
              con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    /*-----------------------------------------------------------------*/
    public boolean eliminar (transportistas pro){
        
        PreparedStatement ps =null;
        Connection con = getconexion();
        
        String sql = "DELETE FROM transportistas WHERE nit=?";
        
        try{
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString (1, pro.getNit());
            ps.execute();
            return true;
        }catch(SQLException e)
        {
            System.err.println(e);
            
        
        return false;
        }finally{
            try{
              con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
  
    /*-----------------------------------------------------------------*/
    public boolean  buscar (transportistas pro){
        
        PreparedStatement ps =null;
        ResultSet rs = null;
        Connection con = getconexion();
        
        String sql = "SELECT * FROM transportistas WHERE nit=?";
        
        try{
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString (1, pro.getNit());
            rs = ps.executeQuery();
            
            if(rs.next()){
                pro.setNit(rs.getString("nit"));
                pro.setNombre(rs.getString("nombre"));
                pro.setTelefono(rs.getString("telefono"));            
            
            
            return true;
            }
            return false;
        }catch(SQLException e)
        {
            System.err.println(e);
            
        
        return false;
        }finally{
            try{
              con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }

    private Connection getconexionTransportistas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
