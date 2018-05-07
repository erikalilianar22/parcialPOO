/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialpoo;

import java.util.ArrayList;
import java.util.Scanner;
import utils.Utils;

/**
 *
 * @author CarlosPaz
 */
public class ListaCliente {
    public ArrayList<Cliente> clientes;
    
    public ListaCliente(){
        clientes=new ArrayList<>();
    }
    public Cliente nuevoCliene(String nombre){
        Cliente nuevo= new Cliente();
        clientes.add(nuevo);
        Scanner leer=new Scanner(System.in);
        //System.out.println("ingrese nombre:");
        nuevo.nombre=nombre;
        System.out.println("ingrese DUI: ");
        nuevo.DUI=leer.nextLine();
        System.out.println("ingrese edad: ");
        Utils util= new Utils();
        nuevo.edad=util.pedirEntero();
        System.out.println("ingrese Pasaporte: ");
        nuevo.pasaporte=leer.nextLine();
        System.out.println("ingrese Tarjeta de Credito: ");
        nuevo.tarjeta_credito=leer.nextLine();
        System.out.println("ingrese telefono: ");
        nuevo.telefono=leer.nextLine();
        System.out.println("ingrese correo: ");
        nuevo.correo=leer.nextLine();
        return nuevo;
    }
    public void eliminarCliente(String cliente){
        for (Cliente e: clientes){
            if ( e.nombre.equals(cliente)){
                clientes.remove(e);
            }
        }
    }
    public void mostrar(){
        int i=1;
        System.out.println("Clientes Registrados:");
        for (Cliente e : clientes){
            System.out.println(i + ". "+ e.nombre +" : "+e.DUI+" : "+e.telefono+" : "+e.tarjeta_credito);
            i++;
        }
    }
    public boolean buscar(String cliente){
        for (Cliente e : clientes){
            if (cliente == e.nombre){
                return true;
            }
        }
        return false;
    }
}
