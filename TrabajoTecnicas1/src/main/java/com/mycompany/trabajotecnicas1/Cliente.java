/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajotecnicas1;
import java.time.LocalDate;

/**
 *
 * @author HP
 */
public class Cliente {
    private String nombre;
    private String id;
    private String telefono;
    private String direccion;
    private int numPieza;
    private String tipoPieza;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;

    public Cliente(String nombre, String id, String telefono, String direccion, int numPieza, String tipoPieza, LocalDate fechaInicio, LocalDate fechaFinal) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.direccion = direccion;
        this.numPieza = numPieza;
        this.tipoPieza = tipoPieza;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    

    public Cliente(String id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumPieza() {
        return numPieza;
    }

    public void setNumPieza(int numPieza) {
        this.numPieza = numPieza;
    }

    public LocalDate fechaInicio(){
        return fechaInicio; 
    }

    public void setFechaInicio(LocalDate fecha){
        this.fechaInicio = fecha;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getTipoPieza() {
        return tipoPieza;
    }

    public void setTipoPieza(String tipoPieza) {
        this.tipoPieza = tipoPieza;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", id=" + id + ", telefono=" + telefono + ", direccion=" + direccion + ", numPieza=" + numPieza + ", tipoPieza=" + tipoPieza + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + '}';
    }
    
    

    

   
    

    
    
    
}
