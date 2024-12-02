/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import CRUD.ManejoProducto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Santiago C
 */
@WebServlet(name = "BorrarJuegoServlet", urlPatterns = {"/eliminar_juego"})
public class BorrarJuegoServlet extends HttpServlet {
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");

        ManejoProducto manejoProducto = new ManejoProducto();

        try {
            manejoProducto.eliminarJuego(nombre);
            response.sendRedirect("listar_juegos"); // Redirige de nuevo a la lista de juegos
        } catch (Exception e) {
            request.setAttribute("error", "No se pudo eliminar el juego: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
   
}
