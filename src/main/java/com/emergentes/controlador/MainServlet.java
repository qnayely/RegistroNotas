package com.emergentes.controlador;

import com.emergentes.modelo.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * NAYELY QUISPE MAMANI -------------- RU: 200050788
 */
@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        Estudiante session = new Estudiante();
        int id, pos;
        
        HttpSession ses = request.getSession();
        ArrayList<Estudiante> lista = (ArrayList<Estudiante>)ses.getAttribute("listanota");
        
        switch(op){
            case "nuevo":
                request.setAttribute("misession", session);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
                
            case "editar":
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarPorIndice(request,id);
                session = lista.get(pos);
                request.setAttribute("misession", session);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
                
            case "eliminar":
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarPorIndice(request,id);
                if (pos >=0) {
                    lista.remove(pos);
                } 
                request.setAttribute("misession", lista);
                response.sendRedirect("index.jsp");
                break;
            default:
                
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int id = Integer.parseInt(request.getParameter("id"));
       HttpSession ses = request.getSession();
       ArrayList<Estudiante> lista = (ArrayList<Estudiante>) ses.getAttribute("listanota");
       Estudiante session = new Estudiante();
       session.setId(id);
       session.setNombre(request.getParameter("nombre"));
       session.setP1(Integer.parseInt(request.getParameter("p1")));
       session.setP2(Integer.parseInt(request.getParameter("p2")));
       session.setEF(Integer.parseInt(request.getParameter("ef")));
       session.calcularNotaTotal();
       
       if(id==0){
           int idNuevo = obtenerId(request);
           session.setId(idNuevo);
           lista.add(session);
       }else{
           int pos = buscarPorIndice(request, id);
           lista.set(pos, session);
       }
       request.setAttribute("listanota", lista);
       response.sendRedirect("index.jsp");
    }
    
    public int buscarPorIndice(HttpServletRequest request, int id){
        HttpSession ses = request.getSession();
        ArrayList<Estudiante> lista = (ArrayList<Estudiante>) ses.getAttribute("listanota");
    
        int pos =-1;
        
        if(lista != null){
            for(Estudiante ele:lista){
                ++pos;
                if(ele.getId() == id){
                  break;  
                }
            }
        }
        return pos;
    }
    
    public int obtenerId(HttpServletRequest request){
        HttpSession ses = request.getSession();
        ArrayList<Estudiante> lista = (ArrayList<Estudiante>) ses.getAttribute("listanota");
        
        int idn = 0;
        for(Estudiante ele:lista){
            idn = ele.getId();
        }
        return idn+1;
    }

}
