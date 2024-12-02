/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Beans.Producto;
import CRUD.ManejoProducto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Santiago C
 */
@WebServlet(name = "Listar", urlPatterns = {"/listar_juegos"})
public class Listar extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      ManejoProducto juego = new ManejoProducto();
      List<Producto> juegos = new ArrayList<>();
    
    juegos = juego.seleccionarTodos();
    request.setAttribute("juegos", juegos);
    request.getRequestDispatcher("/lista_juegos.jsp").forward(request, response);
    

     
      
  }
}
