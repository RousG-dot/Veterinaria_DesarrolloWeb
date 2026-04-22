package com.pe.vet.veterinaria.dao;

import com.pe.vet.veterinaria.model.Mascota;
import com.pe.vet.veterinaria.util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class MascotaDAO {

    public boolean registrar(Mascota m) {
        String sql = "INSERT INTO mascotas (nombre, especie, raza, dueno) VALUES (?,?,?,?)";
        
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, m.getNombre());
            ps.setString(2, m.getEspecie());
            ps.setString(3, m.getRaza());
            ps.setString(4, m.getDueño());
            
            int filas = ps.executeUpdate();
            return filas > 0;
            
        } catch (Exception e) {
            System.out.println("Error al registrar mascota: " + e.getMessage());
            return false;
        }
    }

    public List<Mascota> listar() {
        List<Mascota> lista = new ArrayList<>();
        String sql = "SELECT * FROM mascotas";
        
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Mascota m = new Mascota();
                m.setId(rs.getInt("id"));
                m.setNombre(rs.getString("nombre"));
                m.setEspecie(rs.getString("especie"));
                m.setRaza(rs.getString("raza"));
                m.setDueño(rs.getString("dueno"));
                lista.add(m);
            }
        } catch (Exception e) {
            System.out.println("Error al listar mascotas: " + e.getMessage());
        }
        return lista;
    }

    public boolean actualizar(Mascota m) {
        String sql = "UPDATE mascotas SET nombre=?, especie=?, raza=?, dueno=? WHERE id=?";
        
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, m.getNombre());
            ps.setString(2, m.getEspecie());
            ps.setString(3, m.getRaza());
            ps.setString(4, m.getDueño());
            ps.setInt(5, m.getId());       // El id va al final, en el WHERE
            
            int filas = ps.executeUpdate();
            return filas > 0;
            
        } catch (Exception e) {
            System.out.println("Error al actualizar mascota: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM mascotas WHERE id=?";
        
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            
            int filas = ps.executeUpdate();
            return filas > 0;
            
        } catch (Exception e) {
            System.out.println("Error al eliminar mascota: " + e.getMessage());
            return false;
        }
    }
}