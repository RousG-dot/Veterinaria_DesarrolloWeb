package com.pe.vet.veterinaria;
import com.pe.vet.veterinaria.util.Conexion;
import java.sql.Connection;


public class TestConexion {
    public static void main(String[] args) {
        Connection con = Conexion.getConexion();

        if (con != null) {
            System.out.println("TODO OK 🔥");
        } else {
            System.out.println("FALLO ❌");
        }
    }
}
    
