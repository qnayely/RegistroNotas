<%@page import="com.emergentes.modelo.Estudiante"%>
<%
    Estudiante reg = (Estudiante) request.getAttribute("misession");
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
        <table border="1" cellspacing="0" style="margin: 0 auto;" width="500" height="200">
            <tr><td>
                    <form action="MainServlet" method="post">
                        <table style="margin: 0 auto;">
                            <tr>
                                <td align="right">ID</td>
                                <td><input type="text" name="id" value="<%=reg.getId()%>" size="2" readonly></td>             
                            </tr>
                            <tr>
                                <td align="right">Nombre del estudiante:</td>
                                <td><input type="text" name="nombre" value="<%=reg.getNombre()%>"></td>
                            </tr>
                            <tr>
                                <td align="right">Primer parcial(sobre 30pts)</td>
                                <td><input type="text" name="p1" value="<%=reg.getP1()%>"></td>
                            </tr>
                            <tr>
                                <td align="right">Segundo parcial(sobre 30pts)</td>
                                <td><input type="text" name="p2" value="<%=reg.getP2()%>"></td>
                            </tr>
                            <tr>
                                <td align="right">Examen final(sobre 40pts)</td>
                                <td><input type="text" name="ef" value="<%=reg.getEF()%>"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" value="Enviar"></td>
                            </tr>
                        </table>
                    </form>
                </td></tr>
        </table>
    </body>
</html>