package com.pe.vet.veterinaria.model;

public class Usuario {
    private int id;
    private String correo;
    private String password;

    // Constructor vacío
    public Usuario() {
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
} // <--- Esta llave es la que cierra la clase. Asegúrate de que esté.