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
 * @author LuisT23
 */
public class ListaPack {
    private ArrayList<Pack> packs;
    public ListaPack(){
    packs=new ArrayList<>();
    }
    
    public void nuevoPack(){
        Scanner leer= new Scanner(System.in);
        Utils util= new Utils();
        Pack pack = new Pack();
        packs.add(pack);
        pack.setPrecio(util.pedirEntero("ingrese el precio de paquete"));
        System.out.println("ingrese el nombre del paquete ");
        pack.setNombre(leer.nextLine());
        while (true){
            System.out.println("ingrese veneficio de paquete: ");
            pack.addVeneficio(leer.nextLine());
            System.out.println("desea ingresar otro veneficio s/n");
            String flag=leer.nextLine();
            if ("n".equals(flag)){
            break;
            }
        }
        
    }
    public void mostrar(){
        int i = 1;
        for (Pack e: packs){
            System.out.println(i + ") . $"+ e.getPrecio() + " " + e.getNombre());
            System.out.println("Veneficios: ");
            e.veneficios();
            i++;
        }
    }
    public void removePack(){
        System.out.println("seleccione pack a eliminar:");
        mostrar();
        Utils util=new Utils();
        int i=util.pedirEntero();
        int j=1;
        for (Pack e: packs){
            if(j==i){
                packs.remove(e);
                break;
            }else j++;
        }
        
    }
    public void editarPack(){
        System.out.println("seleccione pack a editar:");
        mostrar();
        Utils util=new Utils();
        int i=util.pedirEntero();
        int j=1;
        for (Pack e: packs){
            if(j==i){
                editarPack(e);
                break;
            }else j++;
        }
    }
    public void editarPack(Pack e){
        opcionesEdicion();
        int opcion =4;
        Utils util= new Utils();
        Scanner leer=new Scanner(System.in);
        while (opcion != 4) {
            opcionesEdicion();
                opcion = util.pedirEntero();

                switch (opcion) {
                    case 1:
                        e.setPrecio(util.pedirEntero("ingrese precio nuevo"));
                        break;
                    case 2:
                        e.addVeneficio(leer.nextLine());
                        break;
                    case 3:
                        e.removeServicio(leer.nextLine());
                        break;
                    case 4:
                        System.out.println("adios :v");
                        break;
                    default:
                        System.out.println("Por favor ingrese una opcion valida");
                }
            
    }
    }
    public void opcionesEdicion(){
        System.out.println("1. editar precio");
        System.out.println("2. agregar veneficio");
        System.out.println("3. eliminar veneficio");
        System.out.println("4. salir");
    }
    
    public void add(Pack nuevo){
        packs.add(nuevo);
                
    }
    public Pack elejirPack(int pack){
        int flag=1;
        for (Pack e : packs){
            if (flag==pack){
                return e;
            }
            flag++;
        }
        return null;
    }
}
