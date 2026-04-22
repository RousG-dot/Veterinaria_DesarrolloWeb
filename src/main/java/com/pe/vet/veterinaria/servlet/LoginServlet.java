package com.pe.vet.veterinaria.servlet;

import com.pe.vet.veterinaria.dao.UsuarioDAO;
import com.pe.vet.veterinaria.model.Usuario;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Recibimos los datos del formulario
        String email = request.getParameter("txtemail");
        String password = request.getParameter("txtpass");

        // 2. Usamos el DAO para validar contra la BD
        UsuarioDAO dao = new UsuarioDAO();
        Usuario user = dao.validar(email, password);

        // 3. Lógica de acceso
        if (user != null) {
            // SI DATOS CORRECTOS: Creamos sesión y vamos al panel
            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogueado", user);
            response.sendRedirect("panelAdmin.jsp");
        } else {
            // SI DATOS INCORRECTOS: Enviamos mensaje de error al login
            request.setAttribute("error", "Correo o contraseña incorrectos");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}