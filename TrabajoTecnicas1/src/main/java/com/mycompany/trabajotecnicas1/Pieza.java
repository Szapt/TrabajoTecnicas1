/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajotecnicas1;

/**
 *
 * @author HP
 */
public class Pieza {
    private int numPieza;
    private int capPieza;
    private String nomPieza;
    private boolean ocupada = false;

    public Pieza(int numPieza, int capPieza, String nomPieza) {
        this.numPieza = numPieza;
        this.capPieza = capPieza;
        this.nomPieza = nomPieza;
     
        
    }

    public int getNumPieza() {
        return numPieza;
    }

    public void setNumPieza(int numPieza) {
        this.numPieza = numPieza;
    }

    public int getCapPieza() {
        return capPieza;
    }

    public void setCapPieza(int capPieza) {
        this.capPieza = capPieza;
    }

    public String getNomPieza() {
        return nomPieza;
    }

    public void setNomPieza(String nomPieza) {
        this.nomPieza = nomPieza;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
    
}
