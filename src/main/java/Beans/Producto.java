/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

/**
 *
 * @author Santiago C
 */
public class Producto {
    private int id;
    private String nombre;
    private String calificacion;
    private String año;
    private String genero;
    private float precio;

    public Producto(int id, String nombre, String calificacion, String año, String genero, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.año = año;
        this.genero = genero;
        this.precio = precio;
    }

    public Producto(String nombre, String calificacion, String año, String genero, float precio) {
        this.nombre = nombre;
        this.calificacion = calificacion;
        this.año = año;
        this.genero = genero;
        this.precio = precio;
    }

   

    public Producto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }
    
    
}
