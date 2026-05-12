package com.pe.vet.veterinaria.servlet;

import com.pe.vet.veterinaria.dao.ProductoDAO;
import com.pe.vet.veterinaria.model.Producto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductoServelt" , urlPatterns = {"/ProductoServlet"})
public class ProductoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        ProductoDAO dao = new ProductoDAO();

        if ("registrar".equals(accion)) {

            //Recoge los datos del jsp con getParameter

            String nombre = request.getParameter("txtnombre");
            double precio = Double.parseDouble(request.getParameter("txtprecio"));
            int stock = Integer.parseInt(request.getParameter("txtstock"));
            String categoria = request.getParameter("txtcategoria");

            boolean estado = request.getParameter("txtestado")!=null;

                Producto p = new Producto(
                        0,
                        nombre,
                        estado,
                        precio,
                        stock,
                        categoria
                );

                dao.registrar(p);

                response.sendRedirect("inventario.jsp");

            System.out.println("ENTRÓ AL SERVLET");

        }

        else if ("actualizar".equals(accion)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            String nombre = request.getParameter("txtnombre");
            double precio = Double.parseDouble(request.getParameter("txtprecio"));
            int stock = Integer.parseInt(request.getParameter("txtstock"));
            String categoria = request.getParameter("txtcategoria");
            boolean estado = request.getParameter("txtestado") != null;

            Producto p = new Producto(
                    id,
                    nombre,
                    estado,
                    precio,
                    stock,
                    categoria
            );

            dao.actualizar(p);

            response.sendRedirect("inventario.jsp");
        }


        else if ("eliminar".equals(accion)) {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            dao.eliminar(id);

            response.sendRedirect("inventario.jsp");
        }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        ProductoDAO dao = new ProductoDAO();
        List<Producto> lista = dao.listar();

        request.setAttribute("lista", lista);
        request.getRequestDispatcher("inventario.jsp").forward(request, response);

        System.out.println("REGISTRÓ Y REDIRIGIENDO");


    }
}





















