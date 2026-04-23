package com.pe.vet.veterinaria.servlet;

import com.pe.vet.veterinaria.dao.MascotaDAO;
import com.pe.vet.veterinaria.model.Mascota;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MascotaServlet", urlPatterns = {"/MascotaServlet"})
public class MascotaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        MascotaDAO dao = new MascotaDAO();

        if ("registrar".equals(accion)) {
            // Recoger datos del JSP
            String nom = request.getParameter("txtnombre");
            String esp = request.getParameter("txtespecie");
            String raz = request.getParameter("txtraza");
            String due = request.getParameter("txtdueño");

            Mascota m = new Mascota();
            m.setNombre(nom);
            m.setEspecie(esp);
            m.setRaza(raz);
            m.setDueño(due);

            dao.registrar(m);

        } else if ("actualizar".equals(accion)) {
            // Recoger datos + id
            int id  = Integer.parseInt(request.getParameter("id"));
            String nom = request.getParameter("txtnombre");
            String esp = request.getParameter("txtespecie");
            String raz = request.getParameter("txtraza");
            String due = request.getParameter("txtdueño");

            Mascota m = new Mascota();
            m.setId(id);
            m.setNombre(nom);
            m.setEspecie(esp);
            m.setRaza(raz);
            m.setDueño(due);

            dao.actualizar(m);

        } else if ("eliminar".equals(accion)) {
            // Solo necesita el id
            int id = Integer.parseInt(request.getParameter("id"));
            dao.eliminar(id);
        }

        response.sendRedirect("mascotas.jsp");
    }
}