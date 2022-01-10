/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Crud;
import modelo.Destinos;

/**
 *
 * @author DAW-A
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String op = request.getParameter("op");
        if (op.equals("listar")) {
            request.setAttribute("mensaje", "");
            List<Destinos> listaDestinos = Crud.getDestinos();
            request.setAttribute("listado", listaDestinos);
            request.getRequestDispatcher("lista.jsp").forward(request, response);
        }
        if (op.equals("insertar")) {
            request.setAttribute("operacion", "insertardatos");
            request.setAttribute("mensaje", "Insertar Destino");
            request.getRequestDispatcher("actualizar.jsp").forward(request, response);
        }
        if (op.equals("insertardatos")) {
            String lugar = request.getParameter("lugar");
            String zona = request.getParameter("zona");
            Destinos d = new Destinos();
            d.setLugar(lugar);
            d.setZona(zona);
            Crud.insertaDestino(d);
            request.setAttribute("mensaje", "");
            List<Destinos> listaDestinos = Crud.getDestinos();
            request.setAttribute("listado", listaDestinos);
            request.getRequestDispatcher("lista.jsp").forward(request, response);
        }
        if (op.equals("actualizar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Destinos miDestino = Crud.getDestino(id);
            request.setAttribute("destino", miDestino);
            request.setAttribute("mensaje", "Actualizar Destino");
            request.setAttribute("operacion", "actualizardatos");
            request.getRequestDispatcher("actualizar.jsp").forward(request, response);
        }
        if (op.equals("actualizardatos")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String lugar = request.getParameter("lugar");
            String zona = request.getParameter("zona");
            Destinos d = new Destinos();
            d.setId(id);
            d.setLugar(lugar);
            d.setZona(zona);
            Crud.actualizaDestino(d);
            if (Crud.actualizaDestino(d) > 0) {
                request.setAttribute("mensaje2", "Destino con id " + id + " actualizado");
            } else {
                request.setAttribute("mensaje2", "No se ha actualizaro ningun destino");
            }
            request.setAttribute("mensaje", "Actualizar Destino");
            request.setAttribute("operacion", "actualizardatos");
            request.setAttribute("destino", d);
            request.getRequestDispatcher("actualizar.jsp").forward(request, response);
        }

        if (op.equals("borrar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            if (Crud.destroyDestino(id) > 0) {
                request.setAttribute("mensaje", "Destino con ID:" + id + " borrado.");
            } else {
                request.setAttribute("mensaje", "Destino con ID:" + id + " no se ha podido borrar.");
            }
            List<Destinos> listaDestinos = Crud.getDestinos();
            request.setAttribute("listado", listaDestinos);
            request.getRequestDispatcher("lista.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
