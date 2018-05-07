/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialpoo;

import java.util.InputMismatchException;
import java.util.Scanner;
import utils.Utils;

/**
 *
 * @author LuisT23
 */
public class Menu {
    private static Menu menu;
    public ListaPack listaPack;
    public ListaReserva listaReserva;
    public ListaHabitacion listaHabitacion;
    
    private Menu(){}
    
    
    public static Menu getInstance() {
        if (menu == null) {
            menu = new Menu();
        }
        return menu;
    }
    
    public void opciones() {
        System.out.println("----- Menu -----");
        System.out.println("1. Menu de Reservaciones");
        System.out.println("2. Administrar Hotel");
        System.out.println("3. Salir");
    }
     public void opcionesReserva(){
         System.out.println("1. Mostar reservaciones de la semana");
         System.out.println("2. crear nueva reservacion");
         System.out.println("3. editar reservacion existente");
         System.out.println("4. eliminar reservacion");
         System.out.println("5. regresar a menu principal");  
     }
     public void opcionesAdministracion(){
         System.out.println("1. habilitar habitacion");
         System.out.println("2. habilitar piso");
         System.out.println("3. habilitar todo");
         System.out.println("4. deshabilitar habitacion");
         System.out.println("5. deshabilitar piso");
         System.out.println("6. cambiar precio base de habitacion");
         System.out.println("7. modificar paquete");
         System.out.println("8. regresar a menu principal");
     }
     public void opcionesPack(){
         System.out.println("1. crear Pack");
         System.out.println("2. eliminar Pack");
         System.out.println("3. editar Pack");
         System.out.println("4. volver al menu de administracion");
     }
    public void mostrar() {
        int opcion = 4;
        Scanner leer = new Scanner(System.in);
        
        while (opcion != 3) {
            opciones();
            try {
                opcion = leer.nextInt();

                switch (opcion) {
                    case 1:
                        reservas();
                        break;
                    case 2:
                        administracion();
                        break;
                    case 3:
                        System.out.println("Adios :(");
                        break;
                    default:
                        System.out.println("Por favor ingrese una opcion valida");
                }
            } catch (InputMismatchException e) {
                System.err.println("Por favor, Ingrese un número");
                leer.nextLine();
            }
        }
    }
    public void packetes(){
        System.out.println("------SubMenu Packetes------");
        int opcion = 5;
        Scanner leer = new Scanner(System.in);
        
        while (opcion!=4) {
            System.out.println(opcion);
            opcionesPack();
            try {
                opcion = leer.nextInt();

                switch (opcion) {
                    case 1:
                        listaPack.nuevoPack();
                        break;
                    case 2:
                        listaPack.removePack();
                        System.out.println("listo :)");
                        break;
                    case 3:
                        listaPack.editarPack();
                        break;
                    case 4:
                        System.out.println("adios :v");
                        //mostrar();
                        break;
                    default:
                        System.out.println("Por favor ingrese una opcion valida");
                }
            } catch (InputMismatchException e) {
                System.err.println("Por favor, Ingrese un número");
                leer.nextLine();
            }
        }
    }
    
    //editar
    public void reservas(){
        System.out.println("------SubMenu Reservaciones------");
        int opcion = 4;
        Scanner leer = new Scanner(System.in);
        
        while (opcion != 5) {
            opcionesReserva();
            try {
                opcion = leer.nextInt();

                switch (opcion) {
                    case 1:
                        listaReserva.mostrar();;
                        //System.out.println("mostrar reservaciones de la semana");
                        break;
                    case 2:
                        listaReserva.nuevaReserva();
                        break;
                    case 3:
                        listaReserva.modificarReserva();;
                        //System.out.println("editar reservacion existente");
                        break;
                    case 4:
                        listaReserva.mostrar();
                        System.out.println("que reserva desea eliminar:");
                        Utils util=new Utils();
                        listaReserva.eliminar(util.pedirEntero());
                        //System.out.println("eliminar reseravcion");
                        break;
                    case 5:
                        System.out.println("adios");
                        break;
                    default:
                        System.out.println("Por favor ingrese una opcion valida");
                }
            } catch (InputMismatchException e) {
                System.err.println("Por favor, Ingrese un número");
                leer.nextLine();
            }
        }
    }
    
    //editar
    public void administracion(){
        System.out.println("------SubMenu Administrador------");
        int opcion = 4;
        Scanner leer = new Scanner(System.in);
        
        while (opcion != 8) {
            opcionesAdministracion();
            try {
                opcion = leer.nextInt();

                switch (opcion) {
                    case 1:
                        listaHabitacion.habilitarHabitacion(listaHabitacion.buscar());
                        System.out.println("listo :)");
                        break;
                    case 2:
                        System.out.println("ingrese pisoa habilitar: ");
                        listaHabitacion.habilitarPiso(leer.next().charAt(0));
                        System.out.println("listo :)");
                        //System.out.println("habilitar piso");
                        break;
                    case 3:
                        listaHabitacion.habilitarTodo();
                        System.out.println("listo :)");
                        //System.out.println("habilitar todo");
                        break;
                    case 4:
                        listaHabitacion.deshabilitarHabitacion(listaHabitacion.buscar());
                        System.out.println("listo :)");
                        //System.out.println("deshabilitar habitacion");
                        break;
                    case 5:
                        System.out.println("ingrese pisoa deshabilitar: ");
                        listaHabitacion.deshabilitarPiso(leer.next().charAt(0));
                        System.out.println("listo :)");
                        //System.out.println("deshabilitar piso");
                        break;
                    case 6:
                        listaHabitacion.modificarPrecio();
                        System.out.println("listo :)");
                        //System.out.println("cambiar precio base");
                        break;
                    case 7:
                        packetes();
                        break;
                    case 8: 
                        System.out.println("adios ");
                        break;
                    default:
                        System.out.println("Por favor ingrese una opcion valida");
                }
            } catch (InputMismatchException e) {
                System.err.println("Por favor, Ingrese un número");
                leer.nextLine();
            }
        }
    }
    
}
