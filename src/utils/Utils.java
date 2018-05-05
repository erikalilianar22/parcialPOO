/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author LuisT23
 */
public class Utils {
    
    public Utils(){
        
    }
    
    /**
     * Validar pedido de un numero con mensaje personalizado
     * @param mensaje
     * @return 
     */
    public int pedirEntero(String mensaje){
        int opcion = 0;
        Scanner leer = new Scanner(System.in);
        while(true) {
         try {
             System.out.println(mensaje);
        opcion = leer.nextInt();
        break;
        
        } catch (InputMismatchException e) {
                System.err.println("no ingreso un numero valido, vuelva a intentarlo");
                leer.nextLine();}}
        return opcion;
    }
    
    public int pedirEntero(){
        int opcion = 0;
        Scanner leer = new Scanner(System.in);
        while(true) {
         try {
        opcion = leer.nextInt();
        break;
        
        } catch (InputMismatchException e) {
                System.err.println("no ingreso un numero valido, vuelva a intentarlo");
                leer.nextLine();}}
        return opcion;
    }
    
    
    
    
    
    
    
    
    
    
}
