package com.pe.vet.veterinaria.dao;

import com.pe.vet.veterinaria.model.Cita;
import com.pe.vet.veterinaria.util.Conexion; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO {

    // Listar todas las citas
    public List<Cita> listar() {
        List<Cita> lista = new ArrayList<>();
        String sql = "SELECT * FROM citas";
        
        // Uso de Try-With-Resources: Java cierra automáticamente la conexión y el statement
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cita c = new Cita();
                c.setId(rs.getInt("id"));
                c.setCliente(rs.getString("cliente"));
                c.setMascota(rs.getString("mascota"));
                c.setFecha(rs.getString("fecha"));
                c.setHora(rs.getString("hora"));
                c.setMotivo(rs.getString("motivo"));
                lista.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Registrar nueva cita
    public boolean registrar(Cita c) {
        String sql = "INSERT INTO citas (cliente, mascota, fecha, hora, motivo) VALUES (?,?,?,?,?)";
        
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getCliente());
            ps.setString(2, c.getMascota());
            ps.setString(3, c.getFecha());
            ps.setString(4, c.getHora());
            ps.setString(5, c.getMotivo());

            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Actualizar cita
    public boolean actualizar(Cita c) {
        String sql = "UPDATE citas SET cliente=?, mascota=?, fecha=?, hora=?, motivo=? WHERE id=?";
        
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getCliente());
            ps.setString(2, c.getMascota());
            ps.setString(3, c.getFecha());
            ps.setString(4, c.getHora());
            ps.setString(5, c.getMotivo());
            ps.setInt(6, c.getId());

            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar cita
    public boolean eliminar(int id) {
        String sql = "DELETE FROM citas WHERE id=?";
        
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}