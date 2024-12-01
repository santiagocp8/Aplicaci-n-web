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
@WebServlet(name = "RegistroProductoServlet", urlPatterns = {"/registro_producto"})
public class RegistroProductoServlet extends HttpServlet {

   private ManejoProducto manejo;
    @Override
   public void init() throws ServletException {
    super.init();
    this.manejo = new ManejoProducto();
   }
    
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre=request.getParameter("nombre");
        String calificacion=request.getParameter("calificacion");
        String año=request.getParameter("anio");
        String genero=request.getParameter("genero");
        String precio=request.getParameter("precio");
        
        System.out.println(nombre);
        System.out.println(calificacion);
        System.out.println(año);
        System.out.println(genero);
        System.out.println(precio);
        
        
        Producto juego = new Producto(nombre,calificacion,año,genero,precio);
        manejo.insertarJuego(juego);
      
        
        response.sendRedirect("profile.html");
        

    
    }

}
