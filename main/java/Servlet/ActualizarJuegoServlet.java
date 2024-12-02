/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Beans.Producto;
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
@WebServlet(name = "ActualizarJuegoServlet", urlPatterns = {"/actualizar_juego"})
public class ActualizarJuegoServlet extends HttpServlet {
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");

        ManejoProducto manejoProducto = new ManejoProducto();
        try {
            Producto juego = manejoProducto.BuscarPorNombre(nombre);
            if (juego == null) {
            request.setAttribute("error", "El juego no existe.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
            }
            request.setAttribute("juego", juego);
            request.getRequestDispatcher("/actualizar_juego.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "No se pudo cargar el juego: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String calificacion = request.getParameter("calificacion");
        String año = request.getParameter("anio");
        String genero = request.getParameter("genero");
        String precio = request.getParameter("precio");

        ManejoProducto manejoProducto = new ManejoProducto();

        try {
            manejoProducto.ActualizarInfo(new Producto(nombre, calificacion, año, genero, precio));
            response.sendRedirect("listar_juegos");
        } catch (Exception e) {
            request.setAttribute("error", "No se pudo actualizar el juego: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
  
}
