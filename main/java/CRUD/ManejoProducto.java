package CRUD;


import Beans.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Utils.Conexion; 
import static Utils.Conexion.getConnection;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author santiago.castanop
 */

public class ManejoProducto {
 
  public void insertarJuego(Producto nuevoProducto) {
      String INSERTAR_JUEGO = "INSERT INTO infojuegos (Nombre, Calificacion, AñoPublicacion, Genero,Precio) values (?, ?, ?, ?, ?)";
    try (
        Connection conexion = Conexion.getConnection();
        PreparedStatement preparedStatement = conexion.prepareStatement(INSERTAR_JUEGO)) {
      preparedStatement.setString(1, nuevoProducto.getNombre());
      preparedStatement.setString(2, nuevoProducto.getCalificacion());
      preparedStatement.setString(3, nuevoProducto.getAño());
      preparedStatement.setString(4, nuevoProducto.getGenero());
      preparedStatement.setString(5, nuevoProducto.getPrecio());
      preparedStatement.executeUpdate();
      
    } catch (SQLException e) {
      System.out.println("Error al insertar un juego: " + e.getMessage());
    }
  }
    public Producto BuscarPorNombre(String nombre) {
     String BUSCAR_JUEGO_NOMBRE = "SELECT * FROM infojuegos WHERE Nombre = ?";
     Producto pro = null;
     try (Connection conexion = Conexion.getConnection();
        PreparedStatement preparedStatement = conexion.prepareStatement(BUSCAR_JUEGO_NOMBRE )) {
      preparedStatement.setString(1, nombre);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        pro = new Producto();
        pro.setNombre(resultSet.getString("Nombre"));
        pro.setCalificacion(resultSet.getString("Calificacion"));
        pro.setAño(resultSet.getString("AñoPublicacion"));
        pro.setGenero(resultSet.getString("Genero"));
        pro.setPrecio(resultSet.getString("Precio"));
      }
    } catch (SQLException e) {
      System.out.println("Error al seleccionar un juego por nombre: " + e.getMessage());
    }
    return pro;
  }
  


  public void eliminarJuego(String nombre) {
      String ELIMINAR_JUEGO = "DELETE FROM infojuegos WHERE Nombre = ?";
    try (Connection conexion = Conexion.getConnection();
      PreparedStatement preparedStatement = conexion.prepareStatement(ELIMINAR_JUEGO)) {
      preparedStatement.setString(1, nombre);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error al eliminar un juego por nombre: " + e.getMessage());
    }
  }
  
  public void ActualizarInfo(Producto pro){
     String ACTUALIZAR_JUEGO = "UPDATE infojuegos SET Calificacion = ?, AñoPublicacion = ?, Genero = ?, Precio = ?  WHERE Nombre = ?";

          try (
        Connection conexion = Conexion.getConnection();
        PreparedStatement preparedStatement = conexion.prepareStatement(ACTUALIZAR_JUEGO)) {
       preparedStatement.setString(1, pro.getCalificacion());
      preparedStatement.setString(2, pro.getAño());
      preparedStatement.setString(3, pro.getGenero());
      preparedStatement.setString(4, pro.getPrecio());
      preparedStatement.setString(5, pro.getNombre());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error al actualizar un juego: " + e.getMessage());
    }
  }
  
  public List<Producto> seleccionarTodos() {
    String SELECCIONAR_TODOS = "SELECT * FROM infojuegos";
    List<Producto> juegos = new ArrayList<>();
    try (Connection conexion = getConnection();
        PreparedStatement preparedStatement = conexion.prepareStatement(SELECCIONAR_TODOS)) {
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        Producto juego = new Producto();
        juego.setNombre(resultSet.getString("Nombre"));
        juego.setCalificacion(resultSet.getString("Calificacion"));
        juego.setAño(resultSet.getString("AñoPublicacion"));
        juego.setGenero(resultSet.getString("Genero"));
        juego.setPrecio(resultSet.getString("Precio"));
        juegos.add(juego);
      }
      System.out.println("Número de juegos recuperados: " + juegos.size());
    } catch (SQLException e) {
      System.out.println("Error al seleccionar todos los usuarios: " + e.getMessage());
    }
    return juegos;
  }

}


    

