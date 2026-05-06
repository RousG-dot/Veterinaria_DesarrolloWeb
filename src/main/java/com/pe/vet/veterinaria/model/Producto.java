package com.pe.vet.veterinaria.model;

public class Producto {


    private int id;
    private String nombre;
    private boolean estado;
    private double precio;
    private int stock;
    private String categoria;


    // constructor vacio, obligatorio para instanciar
    public Producto() {

    }


    // constructor para crear el orden de los atributos

    public Producto(int id, String nombre, boolean  estado, double precio, int stock, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
