package com.pe.vet.veterinaria.service;

import com.pe.vet.veterinaria.dao.CitaDAO;
import com.pe.vet.veterinaria.dto.CitaDTO;
import com.pe.vet.veterinaria.model.Cita;
import java.util.ArrayList;
import java.util.List;

public class CitaService {
    private final CitaDAO dao = new CitaDAO();

    public List<CitaDTO> listarCitas() {
        List<Cita> citas = dao.listar();
        List<CitaDTO> citasDto = new ArrayList<>();

        for (Cita cita : citas) {
            CitaDTO dto = new CitaDTO();
            dto.setId(cita.getId());
            dto.setCliente(cita.getCliente());
            dto.setMascota(cita.getMascota());
            dto.setFecha(cita.getFecha());
            dto.setHora(cita.getHora());
            dto.setMotivo(cita.getMotivo());
            citasDto.add(dto);
        }

        return citasDto;
    }

    public boolean registrarCita(CitaDTO dto) {
        if (!esCitaValida(dto)) {
            return false;
        }

        Cita cita = new Cita();
        cita.setCliente(dto.getCliente().trim());
        cita.setMascota(dto.getMascota().trim());
        cita.setFecha(dto.getFecha().trim());
        cita.setHora(dto.getHora().trim());
        cita.setMotivo(normalizar(dto.getMotivo()));

        return dao.registrar(cita);
    }

    public boolean actualizarCita(CitaDTO dto) {
        if (dto == null || dto.getId() <= 0) {
            return false;
        }

        if (!esCitaValida(dto)) {
            return false;
        }

        Cita cita = new Cita();
        cita.setId(dto.getId());
        cita.setCliente(dto.getCliente().trim());
        cita.setMascota(dto.getMascota().trim());
        cita.setFecha(dto.getFecha().trim());
        cita.setHora(dto.getHora().trim());
        cita.setMotivo(normalizar(dto.getMotivo()));

        return dao.actualizar(cita);
    }

    public boolean eliminarCita(int id) {
        if (id <= 0) {
            return false;
        }

        return dao.eliminar(id);
    }

    private boolean esCitaValida(CitaDTO dto) {
        if (dto == null) {
            return false;
        }
        if (dto.getCliente() == null || dto.getCliente().trim().isEmpty()) {
            return false;
        }
        if (dto.getMascota() == null || dto.getMascota().trim().isEmpty()) {
            return false;
        }
        if (dto.getFecha() == null || dto.getFecha().trim().isEmpty()) {
            return false;
        }
        if (dto.getHora() == null || dto.getHora().trim().isEmpty()) {
            return false;
        }
        return true;
    }

    private String normalizar(String valor) {
        if (valor == null) {
            return null;
        }
        return valor.trim();
    }
}
