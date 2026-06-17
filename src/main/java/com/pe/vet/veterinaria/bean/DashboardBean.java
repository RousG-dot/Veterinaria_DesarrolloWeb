package com.pe.vet.veterinaria.bean;

import com.pe.vet.veterinaria.dao.CitaDAO;
import com.pe.vet.veterinaria.dao.ClienteDAO;
import com.pe.vet.veterinaria.dao.MascotaDAO;
import com.pe.vet.veterinaria.dao.ProductoDAO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class DashboardBean {

    private final int totalClientes;
    private final int totalMascotas;
    private final int totalProductos;
    private final int totalCitas;

    public DashboardBean() {
        totalClientes = new ClienteDAO().listar().size();
        totalMascotas = new MascotaDAO().listar().size();
        totalProductos = new ProductoDAO().listar().size();
        totalCitas = new CitaDAO().listar().size();
    }

    public int getTotalClientes() {
        return totalClientes;
    }

    public int getTotalMascotas() {
        return totalMascotas;
    }

    public int getTotalProductos() {
        return totalProductos;
    }

    public int getTotalCitas() {
        return totalCitas;
    }
}
