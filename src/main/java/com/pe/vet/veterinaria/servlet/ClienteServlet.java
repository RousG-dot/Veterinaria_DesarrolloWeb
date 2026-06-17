package com.pe.vet.veterinaria.servlet;

import com.pe.vet.veterinaria.dto.ClienteDTO;
import com.pe.vet.veterinaria.service.ClienteService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

    private final ClienteService clienteService = new ClienteService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<ClienteDTO> listaClientes = clienteService.listarClientes();
        request.setAttribute("listaClientes", listaClientes);
        request.getRequestDispatcher("cliente.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if ("registrar".equals(accion)) {
            ClienteDTO cliente = new ClienteDTO();
            cliente.setNombre(request.getParameter("txtnombre"));
            cliente.setApellido(request.getParameter("txtapellido"));
            cliente.setDni(request.getParameter("txtdni"));
            cliente.setTelefono(request.getParameter("txttelefono"));
            cliente.setCorreo(request.getParameter("txtcorreo"));
            boolean registrado = clienteService.registrarCliente(cliente);
            if (registrado) {
                response.sendRedirect("ClienteServlet?msg=registrado");
            } else {
                response.sendRedirect("registroCliente.jsp?error=datos_invalidos"
                        + "&txtnombre=" + encode(request.getParameter("txtnombre"))
                        + "&txtapellido=" + encode(request.getParameter("txtapellido"))
                        + "&txtdni=" + encode(request.getParameter("txtdni"))
                        + "&txttelefono=" + encode(request.getParameter("txttelefono"))
                        + "&txtcorreo=" + encode(request.getParameter("txtcorreo")));
            }
            return;

        } else if ("actualizar".equals(accion)) {
            ClienteDTO cliente = new ClienteDTO();
            cliente.setId(parseEntero(request.getParameter("id")));
            cliente.setNombre(request.getParameter("txtnombre"));
            cliente.setApellido(request.getParameter("txtapellido"));
            cliente.setDni(request.getParameter("txtdni"));
            cliente.setTelefono(request.getParameter("txttelefono"));
            cliente.setCorreo(request.getParameter("txtcorreo"));
            clienteService.actualizarCliente(cliente);

        } else if ("eliminar".equals(accion)) {
            int id = parseEntero(request.getParameter("id"));
            clienteService.eliminarCliente(id);
        }

        response.sendRedirect("ClienteServlet");
    }

    private int parseEntero(String valor) {
        try {
            return Integer.parseInt(valor);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private String encode(String valor) {
        if (valor == null) {
            return "";
        }
        return URLEncoder.encode(valor, StandardCharsets.UTF_8);
    }
}
