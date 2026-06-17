package com.pe.vet.veterinaria.dao;

import com.pe.vet.veterinaria.model.Producto;
import com.pe.vet.veterinaria.util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

        public List<Producto> listar() {
            List<Producto> lista = new ArrayList<>();
            String sql = "SELECT * FROM productos ";

            try (Connection con = Conexion.getConexion();
                 PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()){

                while (rs.next()) {
                    Producto p = new Producto();
                    p.setId(rs.getInt("id"));
                    p.setNombre(rs.getString("nombre"));
                    p.setPrecio(rs.getDouble("precio"));
                    p.setStock(rs.getInt("stock"));
                    p.setCategoria(rs.getString("categoria"));
                    p.setEstado(rs.getBoolean("estado"));
                    lista.add(p);

                }

            } catch (Exception e){

                e.printStackTrace();

            }
            return lista;

        }

        public boolean registrar(Producto p){

            String sql = "INSERT INTO productos (nombre, estado, precio, stock, categoria) VALUES (?,?,?,?,?)";


            try (Connection con = Conexion.getConexion();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1,p.getNombre());
                ps.setBoolean(2,p.isEstado());
                ps.setDouble(3,p.getPrecio());
                ps.setInt(4, p.getStock());
                ps.setString(5, p.getCategoria());

                return ps.executeUpdate()>0;

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }


        public boolean actualizar (Producto p){
            String sql = "UPDATE productos SET nombre=?, estado=?, precio=?, stock=? , categoria = ? WHERE id=?";


            try (Connection con = Conexion.getConexion();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1,p.getNombre());
                ps.setBoolean(2,p.isEstado());
                ps.setDouble(3,p.getPrecio());
                ps.setInt(4, p.getStock());
                ps.setString(5, p.getCategoria());
                ps.setInt(6, p.getId());

                return ps.executeUpdate()>0;

            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
    }



        public boolean eliminar (int id) {
            String sql = "DELETE FROM productos WHERE id=?";

            try (Connection con = Conexion.getConexion();

                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setInt(1, id);

                int filas = ps.executeUpdate();
                return filas > 0;


                } catch (Exception e) {
                System.out.println("Error al elimnar producto: " + e.getMessage());
                return false;
             }
            }
    }

