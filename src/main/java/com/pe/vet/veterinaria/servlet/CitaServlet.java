
package com.pe.vet.veterinaria.servlet;
import com.pe.vet.veterinaria.dao.CitaDAO;
import com.pe.vet.veterinaria.model.Cita;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CitaServlet")
public class CitaServlet extends HttpServlet {
    private CitaDAO dao = new CitaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cita> lista = dao.listar();
        request.setAttribute("listaCitas", lista);
        request.getRequestDispatcher("listarCitas.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if ("Agregar".equals(accion)) {
            Cita c = new Cita();
            c.setCliente(request.getParameter("cliente"));
            c.setMascota(request.getParameter("mascota"));
            c.setFecha(request.getParameter("fecha"));
            c.setHora(request.getParameter("hora"));
            c.setMotivo(request.getParameter("motivo"));
            dao.registrar(c);
            response.sendRedirect("CitaServlet");
        }

        if ("Editar".equals(accion)) {
            Cita c = new Cita();
            c.setId(Integer.parseInt(request.getParameter("id")));
            c.setCliente(request.getParameter("cliente"));
            c.setMascota(request.getParameter("mascota"));
            c.setFecha(request.getParameter("fecha"));
            c.setHora(request.getParameter("hora"));
            c.setMotivo(request.getParameter("motivo"));
            dao.actualizar(c);
            response.sendRedirect("CitaServlet");
        }

        if ("Eliminar".equals(accion)) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.eliminar(id);
            response.sendRedirect("CitaServlet");
        }
    }
}

