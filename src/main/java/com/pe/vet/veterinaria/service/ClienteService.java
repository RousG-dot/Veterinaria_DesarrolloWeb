package com.pe.vet.veterinaria.service;

import com.pe.vet.veterinaria.dao.ClienteDAO;
import com.pe.vet.veterinaria.dto.ClienteDTO;
import com.pe.vet.veterinaria.model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private final ClienteDAO dao = new ClienteDAO();

    public List<ClienteDTO> listarClientes() {
        List<Cliente> clientes = dao.listar();
        List<ClienteDTO> clientesDto = new ArrayList<>();

        for (Cliente cliente : clientes) {
            ClienteDTO dto = new ClienteDTO();
            dto.setId(cliente.getId());
            dto.setNombre(cliente.getNombre());
            dto.setApellido(cliente.getApellido());
            dto.setDni(cliente.getDni());
            dto.setTelefono(cliente.getTelefono());
            dto.setCorreo(cliente.getCorreo());
            clientesDto.add(dto);
        }

        return clientesDto;
    }

    public boolean registrarCliente(ClienteDTO dto) {
        if (!esClienteValido(dto)) {
            return false;
        }

        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre().trim());
        cliente.setApellido(dto.getApellido().trim());
        cliente.setDni(dto.getDni().trim());
        cliente.setTelefono(dto.getTelefono().trim());
        cliente.setCorreo(normalizar(dto.getCorreo()));

        return dao.registrar(cliente);
    }

    public boolean actualizarCliente(ClienteDTO dto) {
        if (dto == null || dto.getId() <= 0) {
            return false;
        }

        if (!esClienteValido(dto)) {
            return false;
        }

        Cliente cliente = new Cliente();
        cliente.setId(dto.getId());
        cliente.setNombre(dto.getNombre().trim());
        cliente.setApellido(dto.getApellido().trim());
        cliente.setDni(dto.getDni().trim());
        cliente.setTelefono(dto.getTelefono().trim());
        cliente.setCorreo(normalizar(dto.getCorreo()));

        return dao.actualizar(cliente);
    }

    public boolean eliminarCliente(int id) {
        if (id <= 0) {
            return false;
        }

        return dao.eliminar(id);
    }

    private boolean esClienteValido(ClienteDTO dto) {
        if (dto == null) {
            return false;
        }
        if (dto.getNombre() == null || dto.getNombre().trim().isEmpty()) {
            return false;
        }
        if (dto.getApellido() == null || dto.getApellido().trim().isEmpty()) {
            return false;
        }
        if (dto.getDni() == null || dto.getDni().trim().length() != 8) {
            return false;
        }
        if (dto.getTelefono() == null || !dto.getTelefono().trim().matches("\\d{9}")) {
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
