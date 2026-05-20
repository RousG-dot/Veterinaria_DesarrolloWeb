package com.pe.vet.veterinaria.servlet;

import com.pe.vet.veterinaria.dao.ClienteDAO;
import com.pe.vet.veterinaria.model.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author JOSUÉ
 */

@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        ClienteDAO dao = new ClienteDAO();

        if ("registrar".equals(accion)) {
            // Recoger datos del JSP (registroCliente.jsp)
            String nom = request.getParameter("txtnombre");
            String ape = request.getParameter("txtapellido");
            String dni = request.getParameter("txtdni");
            String tel = request.getParameter("txttelefono");
            String cor = request.getParameter("txtcorreo");

            Cliente c = new Cliente();
            c.setNombre(nom);
            c.setApellido(ape);
            c.setDni(dni);
            c.setTelefono(tel);
            c.setCorreo(cor);

            dao.registrar(c);

        } else if ("actualizar".equals(accion)) {
            // Recoger datos + id (editarCliente.jsp)
            int id = Integer.parseInt(request.getParameter("id"));
            String nom = request.getParameter("txtnombre");
            String ape = request.getParameter("txtapellido");
            String dni = request.getParameter("txtdni");
            String tel = request.getParameter("txttelefono");
            String cor = request.getParameter("txtcorreo");

            Cliente c = new Cliente();
            c.setId(id);
            c.setNombre(nom);
            c.setApellido(ape);
            c.setDni(dni);
            c.setTelefono(tel);
            c.setCorreo(cor);

            dao.actualizar(c);

        } else if ("eliminar".equals(accion)) {
            // Solo necesita el id para borrarlo
            int id = Integer.parseInt(request.getParameter("id"));
            dao.eliminar(id);
        }

        // Al terminar cualquier acción, redirige a la lista de clientes
        response.sendRedirect("cliente.jsp");
    }
}

