/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Santiago C
 */
public class Conexion {
  

  // Conexión a la base de datos
  public static Connection getConnection() {
       String URL = "jdbc:mysql://localhost:3306/aplicacionweb";
       String USER = "root";
       String PASSWORD = "root";
     Connection conexion = null;
    try {
     
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("Conectando a la base de datos...");
      conexion = DriverManager.getConnection(URL, USER, PASSWORD);
      System.out.println(conexion);
    } catch (ClassNotFoundException e) {
      System.out.println("Error:  JDBC Driver no encontrado.");
    } catch (SQLException e) {
      System.out.println("Error al conectar a la base de datos: " + e.getMessage());
      e.printStackTrace();
    }
      
    return conexion;
  }
}
