package CRUD;


import Beans.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Utils.Conexion; 
import static Utils.Conexion.getConnection;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author santiago.castanop
 */

public class ManejoProducto {
    
 
  
  private static final String INSERTAR_JUEGO = "INSERT INTO aplicacionweb (Nombre, Calificacion, AñoPublicacion, Genero,Precio) VALUES (?, ?, ?, ?, ?)";
  private static final String BUSCAR_JUEGO_NOMBRE = "SELECT * FROM aplicacionweb WHERE Nombre = ?";
  private static final String ELIMINAR_JUEGO = "DELETE FROM aplicacionweb WHERE Nombre = ?";
  private static final String ACTUALIZAR_JUEGO = "UPDATE aplicacionweb SET Calificacion = ?, AñoPublicacion = ?, Genero = ?, Precio = ?,  WHERE Nombre = ?";
  Connection con = Conexion.getConnection();
  public void insertarJuego(Producto nuevoProducto) {
    try (
        Connection conexion = getConnection();
        PreparedStatement preparedStatement = conexion.prepareStatement(INSERTAR_JUEGO)) {
      preparedStatement.setString(2, nuevoProducto.getNombre());
      preparedStatement.setString(3, nuevoProducto.getCalificacion());
      preparedStatement.setString(4, nuevoProducto.getAño());
      preparedStatement.setString(5, nuevoProducto.getGenero());
      preparedStatement.setFloat(6, nuevoProducto.getPrecio());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error al insertar un juego: " + e.getMessage());
    }
  }
    public Producto BuscarPorNombre(String nombre) {
     Producto pro = null;
     try (Connection conexion = getConnection();
        PreparedStatement preparedStatement = conexion.prepareStatement(BUSCAR_JUEGO_NOMBRE )) {
      preparedStatement.setString(1, nombre);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        pro = new Producto();
        pro.setNombre(resultSet.getString("Nombre"));
        pro.setCalificacion(resultSet.getString("Calificacion"));
        pro.setAño(resultSet.getString("Año"));
        pro.setGenero(resultSet.getString("Genero"));
        pro.setPrecio(resultSet.getFloat("Precio"));
      }
    } catch (SQLException e) {
      System.out.println("Error al seleccionar un juego por nombre: " + e.getMessage());
    }
    return pro;
  }
  


  public void eliminarJuego(String nombre) {
    try (Connection conexion = getConnection();
      PreparedStatement preparedStatement = conexion.prepareStatement(ELIMINAR_JUEGO)) {
      preparedStatement.setString(2, nombre);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error al eliminar un juego por nombre: " + e.getMessage());
    }
  }
  
  public void ActualizarInfo(Producto pro){
          try (
        Connection conexion = getConnection();
        PreparedStatement preparedStatement = conexion.prepareStatement(ACTUALIZAR_JUEGO)) {
      preparedStatement.setString(2, pro.getNombre());
      preparedStatement.setString(3, pro.getCalificacion());
      preparedStatement.setString(4, pro.getAño());
      preparedStatement.setString(5, pro.getGenero());
      preparedStatement.setFloat(6, pro.getPrecio());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      System.out.println("Error al actualizar un juego: " + e.getMessage());
    }
  }

}


    

