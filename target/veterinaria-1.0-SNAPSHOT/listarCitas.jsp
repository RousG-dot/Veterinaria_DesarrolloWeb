<%-- 
    Document   : listarCitas
    Created on : 21 may. 2026, 1:14:01
    Author     : jhurtado
--%>

<%@ page import="java.util.List" %>
<%@ page import="com.pe.vet.veterinaria.model.Cita" %>

<%
    List<Cita> lista = (List<Cita>) request.getAttribute("listaCitas");
%>

<h1>Listado de Citas</h1>

<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Cliente</th>
        <th>Mascota</th>
        <th>Fecha</th>
        <th>Hora</th>
        <th>Motivo</th>
        <th>Acciones</th>
    </tr>
    <%
        if (lista != null) {
            for (Cita c : lista) {
    %>
    <tr>
        <td><%= c.getId() %></td>
        <td><%= c.getCliente() %></td>
        <td><%= c.getMascota() %></td>
        <td><%= c.getFecha() %></td>
        <td><%= c.getHora() %></td>
        <td><%= c.getMotivo() %></td>
        <td>
            <!-- Botón Editar -->
            <form action="CitaServlet" method="post" style="display:inline;">
                <input type="hidden" name="id" value="<%= c.getId() %>">
                <button type="submit" name="accion" value="Editar">Editar</button>
            </form>
            <!-- Botón Eliminar -->
            <form action="CitaServlet" method="post" style="display:inline;">
                <input type="hidden" name="id" value="<%= c.getId() %>">
                <button type="submit" name="accion" value="Eliminar">Eliminar</button>
            </form>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

