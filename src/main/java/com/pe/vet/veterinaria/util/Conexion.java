package com.pe.vet.veterinaria.util;
import java.sql.*;

public class Conexion {
    private static final String URL = "jdbc:mysql://Localhost:3307/db_veterinaria"; // Puerto 3307 y BD correcta
    private static final String USER = "root";
    private static final String PASSWORD = ""; // El que usas en MySQL

    public static Connection getConexion() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }
}

