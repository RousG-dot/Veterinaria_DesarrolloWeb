package com.pe.vet.veterinaria.dao;
import com.pe.vet.veterinaria.model.Usuario;
import com.pe.vet.veterinaria.util.Conexion;
import java.sql.*;

public class UsuarioDAO {
    public Usuario validar(String correo, String password) {
        Usuario u = null;
        String sql = "SELECT * FROM usuarios WHERE correo=? AND password=?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, correo);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setCorreo(rs.getString("correo"));
                u.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u; // Si no lo encuentra, devuelve null
    }
}
    
       
        
        
    

