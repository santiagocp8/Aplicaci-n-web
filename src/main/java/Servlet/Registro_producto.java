/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

 
import Beans.Producto;
import CRUD.ManejoProducto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Santiago C
 */
@WebServlet(name = "registro_producto", urlPatterns = {"/registro_producto"})
public class Registro_producto extends HttpServlet {

    private final ManejoProducto manejo;
    
    
    public Registro_producto(){
        this.manejo = new ManejoProducto();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre=request.getParameter("nombre");
        String calificacion=request.getParameter("calificacion");
        String año=request.getParameter("año");
        String genero=request.getParameter("genero");
        float precio=Float.parseFloat(request.getParameter("precio"));
        
        
        Producto juego = new Producto(nombre,calificacion,año,genero,precio);
        manejo.insertarJuego(juego);
      
        
        response.sendRedirect("profile.html");
        

    
    }
}
