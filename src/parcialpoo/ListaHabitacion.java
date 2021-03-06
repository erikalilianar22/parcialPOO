/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialpoo;

import java.util.ArrayList;
import utils.Utils;

/**
 *
 * @author rafa
 */
public class ListaHabitacion {
    private ArrayList<Habitacion> habitaciones;
    
    public ListaHabitacion(){
        habitaciones=new ArrayList<>();
    }
    
    public void add(char piso, int precio, int numero, int total, boolean cargo,boolean tipo){
        Habitacion nuevo= new Habitacion();
        habitaciones.add(nuevo);
        nuevo.Numero= numero;
        nuevo.cargo = cargo;
        nuevo.piso=piso;
        nuevo.precioBase=precio;
        nuevo.tipo=tipo;
        if (nuevo.cargo){
        nuevo.total+=(int) (precio * 0.1);}
        nuevo.total+=precio;
    }
    public Habitacion buscar(){
        mostrar();
        Utils util= new Utils();
        while (true){
        int i=util.pedirEntero("elija su habitacion de la lista: ");
        int j=1;
        for (Habitacion a : habitaciones){
            if (i==j){
                return a;
            }
            j++;
        }
            System.out.println("debe seleccionar una habitacion de la lista");
        }
    }
    public Habitacion buscar(int diaInicio, int diaFin){
        mostrar(diaInicio,diaFin);
        Utils util= new Utils();
        while (true){
        int i=util.pedirEntero("elija su habitacion disponible de la lista: ");
        int j=1;
        for (Habitacion a : habitaciones){
            boolean flag=true;
            for (int m=diaInicio;m<=diaFin;m++){
                for(int k: a.dias){
                    if(m==k){
                        flag=false;
                        break;
                    }
                }
            }
            if(flag){
                return a;
            }
            j++;}
        
            System.out.println("debe seleccionar una habitacion de la lista");}
        }
    
    public void habilitarHabitacion(Habitacion habitacion){
        habitacion.disponible=true;
    }
    public void deshabilitarHabitacion(Habitacion habitacion){
        habitacion.disponible=false;
    }
    public void habilitarPiso(char piso){
        
        for (Habitacion e: habitaciones){
            if (piso == e.piso){
                e.disponible=true;
            }}}
    public void deshabilitarPiso(char piso){
        for (Habitacion e: habitaciones){
            if (piso == e.piso){
                e.disponible=false;
            }}}
    
    public void habilitarTodo(){
        for (Habitacion e: habitaciones){
                e.disponible=true;
        }
    }
    
    public void mostrar(){
        System.out.println("habitaciones existentes: ");
        int i= 1;
        for (Habitacion e: habitaciones){
            String cliente;
            if (e.cliente!= null){
                cliente="ultimo cliente: " +e.cliente.nombre+" dias:"+e.diaInicio+" a "+e.diaFin;
                if (e.pack!=null){
                    cliente=cliente+ " pack: "+ e.pack.getNombre();
                }
            }else cliente="sin cliente actualmente";
            String disponibilidad="habilitada";
            if (!e.disponible){
                disponibilidad="deshabilitada";
            }
            System.out.println(i+ ").  "+e.piso+e.Numero+cliente+"  "+disponibilidad);
            
            i++;
        }
    }
    public void mostrar(int diaInicio, int diaFin){
        System.out.println("habitaciones existentes: ");
        int i= 1;
        for (Habitacion e: habitaciones){
            boolean flag=true;
            for (int j=diaInicio;j<=diaFin;j++){
                for(int k: e.dias){
                    if(j==k){
                        flag=false;
                        break;
                    }
                }
            }
            if (flag){
            String cliente;
            if (e.cliente!= null){
                cliente=e.cliente.nombre+" dias:"+e.diaInicio+" a "+e.diaFin;
                if (e.pack!=null){
                    cliente=cliente+ " pack: "+ e.pack.getNombre();
                }
            }else cliente="sin cliente actualmente";
            String disponibilidad="habilitada";
            if (!e.disponible){
                disponibilidad="deshabilitada";
            }
            System.out.println(i+ ").  "+e.piso+e.Numero+"   "+cliente+"  "+disponibilidad);
            i++;}
        }
    }
    
    public void modificarPrecio(){
            Utils util = new Utils();
            System.out.println("ingrese nuevo precio base habitaciones censillas:");
            int precio=util.pedirEntero();
            System.out.println("ingrese nuevo precio base habitaciones dobles:");
            int precio2=util.pedirEntero();
            int i=1;
            for (Habitacion e : habitaciones){
                if (i%2==0){
                e.precioBase=precio2;}
                else{e.precioBase=precio;}
                i++;
            }
            actualizarTotal();
        }
    public void actualizarTotal(){
        for (Habitacion e : habitaciones){
                e.total=e.precioBase;
                if(e.cargo){
                    e.total += e.total*0.1;
                }
            }
    }
    
}

