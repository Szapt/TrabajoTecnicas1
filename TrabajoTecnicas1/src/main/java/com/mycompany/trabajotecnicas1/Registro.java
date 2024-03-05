/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajotecnicas1;
import java.time.LocalDate;


/**
 *
 * @author HP
 * 
 */

public class Registro {
    
    Lectura le = new Lectura();
    Pieza[] pieza;
    Cliente[] cliente;
    int aforo;
   
    static int cont = 0;

    public Registro( int camasDobles, int camasSencillas)
    {
        this.aforo = camasDobles + camasSencillas;
       
        cliente  =  new Cliente[aforo];
        pieza = new Pieza[camasDobles + camasSencillas];
        for ( int i = 0; i < camasDobles; i++)
        {
            pieza[i] =  new Pieza(i, 2,"Doble");
        }
        for ( int i = 0; i < camasSencillas; i++)
        {
            pieza[i + camasDobles] =  new Pieza(i + camasDobles, 1,"Sencilla");
        }
    }
    
    public void menu()
    {
        boolean seguir = true;
        do
        {
            System.out.println("Que operación deseas hacer \n 1.Agregar un cliente \n 2.Ver datos de un cliente \n 3.Cambiar datos de un cliente \n 4. Salir");
            int opcion = le.leeryValidarInt("selecciona una opción");
            if(opcion == 4)
            {
                seguir = false;
            }
            else if(validarOp(opcion))
            {
                gestionarOp(opcion);
            }
        }while(seguir);
    }
    
    public boolean validarOp (int opcion)
    {
        if(opcion > 4 || opcion <= 0)
        {
            System.out.println("Ingresaste una opción no válida, por favor vuelve a ingresar");
            return false;
        }
        return true;
    } 
    
    public void gestionarOp(int opcion)
    {
        if(opcion == 1){
            agregarCliente();
        }
        if(opcion == 2)
        {
            String numBuscar = le.leerString("Ingrese el id de la persona que desea buscar; ");
            int num = buscarCliente(numBuscar);
            if(num == -1){
                System.out.println("El numero de id que ingresaste no esta registrado");
                
            }
            else{
                System.out.println(cliente[num].toString());
            }
        }
        if (opcion == 3)
        {
            cambiarDatos();
            
            
        }
        if(opcion == 4)
        {
        System.exit(0);
       
        }
    }
    
    public void agregarCliente()
    {
        if(cont >= aforo){
            System.out.println("No se pueden registrar mas clientes");
        }
        else{
            pedirDatos();
            
            cont +=1;
        }
    }
    
    public void pedirDatos(){
        
        String nombre = le.leerString("Escriba el nombre del cliente: ");
        String id = le.leerString("Escriba su id: ");       
        String telefono = le.leerString("Escriba su telefono: ");        
        String direccion = le.leerString("Escriba su direccion: ");        
        int numDias = le.leeryValidarInt("Cuantos dias se desea quedar ");
        int tipoCama = le.leeryValidarInt("Que tipo de cama quieres? \n 1. Sencilla \n 2. Doble");
        int numPieza = asignarCama(tipoCama);
        
        if (numPieza == -1)
        {
            System.out.println("Tipo de pieza no Disponible");
        }
        else
        {
            
            LocalDate fecha = LocalDate.now();
            LocalDate fechaFinal = fecha.plusDays(numDias);
            cliente[cont] = new Cliente(nombre, id, telefono, direccion, numPieza, pieza[numPieza].getNomPieza(), fecha, fechaFinal);
            pieza[numPieza].setOcupada(true);
        }
        
    }
    
    public int asignarCama(int tipoCama)
    {
        int numPieza = -1;
        if (tipoCama == 1)
        {
          for (int i = 0; i < aforo ; i++)  
          {
              if (!pieza[i].isOcupada() &&  pieza[i].getNomPieza().equals("Sencilla") )
              {
                  numPieza = i;
                  break;
              }
          }
        }
        if (tipoCama == 2)
        {
          for (int i = 0; i < aforo ; i++)  
          {
              if (!pieza[i].isOcupada() && pieza[i].getNomPieza().equals("Doble") )
              {
                  numPieza = i;
                  break;
              }
          }
        }
        return numPieza;
       
    }
    
    
    public int buscarCliente(String numBuscar){
        for (int i = 0; i<cont; i++){
            if(cliente[i].getId().equals(numBuscar)){
                return i;
            }
        }
        return -1;
    }
    
    public void cambiarDatos(){
        int numCam = buscarCliente(le.leerString("Ingrese el id de la persona que deseas cambiar un dato: "));
        if(numCam == -1){
            System.out.println("El id de la persona que ingreso no esta registrada");
        }
        else{
            boolean repetir = true;
            do{
                System.out.println("Que dato desea cambiar? \n 1. Nombre \n 2. Id \n 3. Telefono \n 4. Direccion ");
                int num = le.leeryValidarInt("Ingrese una opcion: ");
                if(num<0 && num>4){
                    System.out.println("Ingrese un valor valido");
                }
                else{
                    repetir = false;
                    gestionarDatos(num, numCam);
                }
            }while(repetir);
        }
    }
    
    public void gestionarDatos(int num, int i)
    {
        if(num == 1){
            cliente[i].setNombre(le.leerString("Ingrese el nuevo nombre"));
        }
        if(num == 2){
            cliente[i].setId(le.leerString("Ingrese el nuevo id"));
        }
        if(num == 3){
            cliente[i].setTelefono(le.leerString("Ingrese el nuevo numero de telefono"));
        }
        if(num == 4){
            cliente[i].setDireccion(le.leerString("Ingrese la nueva direccion"));
        }
        
    }
 
}

