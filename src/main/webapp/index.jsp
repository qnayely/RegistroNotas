<%@page import="com.emergentes.modelo.Estudiante"%>
<%@page import="java.util.ArrayList"  %>
<%@page import="jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator"%>
<%

    if (session.getAttribute("listanota") == null) {
        ArrayList<Estudiante> lisaux = new ArrayList<Estudiante>();
        session.setAttribute("listanota", lisaux);
    }
    ArrayList<Estudiante> lista = (ArrayList<Estudiante>) session.getAttribute("listanota");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1" cellspacing="0" style="margin: 0 auto;" width="400" height="100">
            <tr>
                <th align="center">PRIMER PARCIAL TEM-742<br> Nombre: Nayely Quispe Mamani<br>Carnet: 12768327</th>
            </tr>
        </table>
        <h1 align="center">REGISTRO DE CALIFICACIONES</h1>
        <button onclick="window.location.href = 'MainServlet?op=nuevo'">Nuevo</button>
        <br><br>
        <table border="1" cellspacing="0" >
            <tr>
                <th align="center">Id</th>
                <th align="center">Nombre</th>
                <th align="center">P1(30)</th>
                <th align="center">P2(30)</th>
                <th align="center">EF(40)</th>
                <th align="center">Nota</th>
                <th align="center"></th>
                <th align="center"></th>
            </tr>
            <%
                if (lista != null) {
                    for (Estudiante item : lista) {

                
            %>

            <tr>
                <td><%= item.getId() %></td>
                <td><%= item.getNombre() %></td>
                <td><%= item.getP1() %></td>
                <td><%= item.getP2() %></td>
                <td><%= item.getEF() %></td>
                <td><%= item.getNota() %></td>
                <td>
                    <a href="MainServlet?op=editar&id=<%= item.getId() %>">Editar</a>
                </td>
                <td>
                    <a href="MainServlet?op=eliminar&id=<%= item.getId() %>"
                       onclick="return(confirm('Esta seguro de eliminar?'))" 
                       >Eliminar</a>
                </td>
            </tr>
            
            <%
                }
            }
            %>
        </table>
    </body>
</html>
