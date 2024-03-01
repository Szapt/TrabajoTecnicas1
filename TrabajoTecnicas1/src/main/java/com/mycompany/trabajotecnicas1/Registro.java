/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajotecnicas1;

/**
 *
 * @author HP
 * 
 */

public class Registro {
    
    Lectura le = new Lectura();
    static Cliente[] cliente;
    static int aforo;
    static int cont = 0;

    public Registro(int aforo)
    {
        this.aforo = aforo;
        this.cliente = new Cliente[aforo];
    }
    
    public void menu()
    {
        boolean seguir = true;
        do
        {
            System.out.println("Que operación deseas hacer ahora? \n 1.Agregar otro cliente \n 2.Ver datos de un cliente \n 3.Cambiar datos de un cliente \n 4. Salir");
            int opcion = le.leeryValidarInt("selecciona una opción");
            if(opcion == 4)
            {
                seguir = false;
            }
            else if(validarOp(opcion))
            {
                gestionarOp(opcion);
            }
        }while(!seguir);
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
            cliente[cont] = pedirDatos();
            cont +=1;
        }
    }
    
    public Cliente pedirDatos(){
        Cliente aux;
        
        String nombre = le.leerString("Escriba el nombre del cliente: ");
        String id = le.leerString("Escriba su id: ");
        String telefono = le.leerString("Escriba su telefono: ");
        String direccion = le.leerString("Escriba su direccion: ");
        int numPiezas = le.leeryValidarInt("Escriba el numero de piezas: ");
        
        aux = new Cliente(nombre, id, telefono, direccion, numPiezas);
        return aux;
    }
    
    public int buscarCliente(String numBuscar){
        for (int i = 0; i<cont; i++){
            if(cliente[i].getId() == numBuscar){
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
                System.out.println("Que dato desea cambiar? \n 1. Nombre \n 2. Id \n 3. Telefono \n 4. Direccion \n 5. numPiezas");
                int num = le.leeryValidarInt("Ingrese una opcion: ");
                if(num<0 && num>5){
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
        if(num == 5){
            cliente[i].setNumPiezas(le.leeryValidarInt("Ingrese el nuevo numero de piezas"));
        }
    }
}

