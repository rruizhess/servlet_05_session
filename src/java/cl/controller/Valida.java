/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.controller;

import cl.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author roman
 */
@WebServlet(name = "Valida", urlPatterns = {"/validar.do"})
public class Valida extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //CAPTURAR DATOS
        String rut = request.getParameter("rut");
        String clave = request.getParameter("clave");
        //OBTENER LISTA
        ArrayList<User> lista = (ArrayList<User>) 
                                        getServletContext().getAttribute("listauser");
        //BUSCAR USER
        User user=null;
        for (User u : lista) {
            if (u.getRut().equals(rut) && u.getClave().equals(clave)) {
                user = u;
            }
        }
        //VALIDAR
        if (user != null) {
            //CREAR COOKIE
            Cookie cookie=new Cookie("rut",rut);
            cookie.setMaxAge(60*10);
            cookie.setPath("/");
            response.addCookie(cookie);
            //CREAR SESION y REDIRECCIONAR A MENU
            request.getSession().setAttribute("user", user);
            response.sendRedirect("menu.jsp");
        } else {
            //REDIRECCIONAR ERROR A INDEX
            request.setAttribute("error", "Usuario Incorrecto");
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
