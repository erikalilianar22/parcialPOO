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
 * @author erikav
 */
public class ListaReserva {
    private ArrayList<Reserva> reservas;
    public ListaCliente clientes;
    public ListaHabitacion habitaciones;
    public ListaPack packs;
    public int total;
    public int diaInicio;
    public int diaFin;
    
    public ListaReserva(){
        reservas=new ArrayList<>();
    }
    
        public ListaReserva(ListaCliente clientes, ListaHabitacion habitaciones, ListaPack packs) {
        this.clientes = clientes;
        this.habitaciones = habitaciones;
        this.packs = packs;
    }
    
    
    
    
    public void nuevaReserva(){
        Reserva reserva=new Reserva();
        reservas.add(reserva);
        reserva.cliente=nuevoCliente();
        if (reserva.cliente != null){
        reserva.habitacion=nuevaHabitacion();
        reserva.habitacion.cliente=reserva.cliente;
        reserva.pack=nuevoPack();
        total=reserva.habitacion.total;
        
        if(reserva.pack !=null){
            total+= reserva.pack.getPrecio();
        }
        reserva.diaInicio=diaInicio;
        reserva.diaFin=diaFin;
        reserva.Total=total*(Math.abs(diaInicio-diaFin)+1);
        }
        else reservas.remove(reserva);
    }
    
    public ListaReserva(ArrayList<Reserva> reservas){
        this.reservas=reservas;
    }
    
    public Cliente nuevoCliente(){
        Scanner leer=new Scanner(System.in);
        System.out.println("INGRESAR NOMBRE DE CLIENTE: ");
        String nombre= leer.nextLine();
        
        if (clientes.buscar(nombre)){
            System.out.println("¡EL CLIENTE YA TIENE UNA RESERVACION!");
        }
        else{
            return clientes.nuevoCliente(nombre);
        }
        
        return null;
    }
    
    public Habitacion nuevaHabitacion(){
        System.out.println("DIAS A RESERVAR(MAXIMO 7 DIAS): ");
        System.out.println("DIA INICIAL: ");
        Utils util= new Utils();
        diaInicio=util.pedirEntero()%7;
        diaFin=util.pedirEntero("DIA A FINALIZAR: ")%7;
        if (diaFin<diaInicio){
            int temp= diaFin;
            diaFin= diaInicio;
            diaInicio= diaFin;
        }
        Habitacion nueva;
        while(true){
            nueva= habitaciones.buscar(diaInicio,diaFin);
            nueva.diaFin= diaFin;
            nueva.diaInicio=diaInicio;
            nueva.addDias();
            return nueva;
        }
    }
    
    public Pack nuevoPack(){
        System.out.println("DESEA AGREGAR UN PAQUETE ADICIONAL A LA RESERVACION S/N: ");
        Scanner leer=new Scanner(System.in);
        String flag=leer.nextLine();
        
        if ("S".equals(flag)||"s".equals(flag)){
            packs.mostrar();
            System.out.println("INGRESE PAQUETE A ELEGIR: ");
            Utils util= new Utils();
            return packs.elejirPack(util.pedirEntero());
        }
        return null;
    }
    
    public void mostrar(){
        int i=1;
        
        for(Reserva e: reservas){
            String paquete="";
            if(e.pack !=null){
                paquete="  PAQUETE: "+e.pack.getNombre();
            }
            System.out.println(i+"). CLIENTE: "+e.cliente.nombre+"  HABITACION: "+e.habitacion.piso+e.habitacion.Numero+"  del dia "
                    +e.diaInicio+" al "+ e.diaFin+paquete);
            i++;
        }
    }
    
    public void eliminar(int reserva){
        int i=1;
        
        for(Reserva e: reservas){
            if (i==reserva){
                e.habitacion.cliente=null;
                e.pack=null;
                reservas.remove(e);
            }
            i++;
        }
    }
    
    public void Cumplir(int reserva){
        int i=1;
        
        for(Reserva e: reservas){
            if (i==reserva){
                e.habitacion.cliente=null;
                e.pack=null;
                System.out.println("total a cancelar: " +e.Total);
                reservas.remove(e);
            }
            i++;
        }
    }
    
    public void modificarReserva(){
        mostrar();
        System.out.println("INGRESE LA RESERVA QUE DESEA MODIFICAR: ");
        Utils util= new Utils();
        Reserva reserva= devolverReserva(util.pedirEntero());
        reserva.habitacion=nuevaHabitacion();
        reserva.habitacion.cliente=reserva.cliente;
        reserva.pack=nuevoPack();
        total=reserva.habitacion.total;
        if(reserva.pack !=null){
            total+= reserva.pack.getPrecio();
        }
        reserva.Total=total*Math.abs(diaInicio-diaFin); 
    }
    
    public Reserva devolverReserva(int reserva){
        int i=1;
        
        for(Reserva e: reservas){
            if(i==reserva){
                return e;
            }
            i++;
        }
        return null;
    }    
}
