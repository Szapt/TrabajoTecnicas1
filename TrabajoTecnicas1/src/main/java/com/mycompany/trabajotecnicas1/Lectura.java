package com.mycompany.trabajotecnicas1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author HP
 */
import java.util.Scanner;

public class Lectura {
    Scanner sc = new Scanner(System.in);
    
    public int leerInt(String mensaje){
        System.out.println(mensaje+": ");
        int dato = sc.nextInt();
        return dato;
    }
    public double leerDoble(String mensaje){
        System.out.println(mensaje);
        double dato = sc.nextDouble();
        return dato;
    }
    
    public float leerFloat(String mensaje){
        System.out.println(mensaje);
        float dato = sc.nextFloat();
        return dato;
    }
    
    public String leerString(String mensaje){
        System.out.println(mensaje+": ");
        String dato = sc.next();     // Esta aqui la maricada
        return dato;
    }

    public int leeryValidarInt(String mensaje) {
        int dato;
        do {
            System.out.print(mensaje +" debe ser número entero positivo: ");
            while (!sc.hasNextInt()) {
                System.out.println("Valor no válido");
                sc.next();
                System.out.print("Debe ser número entero positivo, los meses y dias de tu existencia no interesan: ");
            }
            dato = sc.nextInt();
            if(dato <= 0){
                System.out.println("El número debe ser positivo, pués tu vida existe y avanza");
            }
        } while (dato <= 0);
       // System.out.println("La edad ingresada como entero positivo es : " + dato);
        return dato;
    }
}


