package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    // Definimos la variable de conexión
    Connection con;

    // Estos datos deben coincidir con tu MySQL
    // Puerto 3307 según lo que configuramos ayer
    String url = "jdbc:mysql://localhost:3306/db_veterinaria";
    String user = "root";
    String pass = "root"; // Tu contraseña de MySQL (si no tienes, déjalo vacío "")

    public Connection getConnection() {
        try {
            // Buscamos el driver de MySQL (el conector)
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Intentamos conectar
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("¡Conexión exitosa a la veterinaria!");
        } catch (Exception e) {
            // Si hay error, nos dirá qué pasó en la consola
            System.err.println("Error de conexión: " + e);
        }
        return con;
    }
}