/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialpoo;

/**
 *
 * @author CarlosPaz
 */
public class Cliente {
    
    public String nombre;
    public int edad;
    public String tarjeta_credito;
    public String telefono;
    public String correo;
    public String DUI;
    public String pasaporte;
    
    public Cliente(){}
    
    public Cliente( String nombre, int edad, String tarjeta_credito, String telefono, String correo, String DUI,String pasaporte){
     
        this.nombre = nombre;
        this.edad = edad;
        this.tarjeta_credito =tarjeta_credito;
        this.telefono = telefono;
        this.correo = correo;
        this.DUI = DUI;
        this.pasaporte = pasaporte;
        
    }

}
