/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.vet.veterinaria.model;

/**
 *
 * @author minig
 */
public class Mascota {
   private int id;
    private String nombre;
    private String especie;
    private String raza;
    private String dueño;

    // Constructor vacío (obligatorio)
    public Mascota() {
    }

    // Constructor con parámetros (útil para crear mascotas rápido)
    public Mascota(int id, String nombre, String especie, String raza, String dueño) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.dueño = dueño;
    } 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }
}
