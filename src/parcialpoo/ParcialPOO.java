/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialpoo;

/**
 *
 * @author LuisT23
 */
public class ParcialPOO {

     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Menu menu = null;
        System.out.println("contraseña por defecto: 2018");
        ListaPack listaPack= new ListaPack();
        paquetesIniciales(listaPack);//inicializando los paquetes
        ListaCliente listaClientes=new ListaCliente();
        ListaHabitacion listaHabitacion=new ListaHabitacion();
        habitaciones(listaHabitacion);
        //3listaHabitacion.mostrar();
        
        ListaReserva listaReserva= new ListaReserva();
        listaReserva.clientes=listaClientes;
        listaReserva.habitaciones=listaHabitacion;
        listaReserva.packs=listaPack;
        
        Menu menu = Menu.getInstance();
        menu.listaPack=listaPack;
        menu.listaHabitacion=listaHabitacion;
        menu.listaReserva=listaReserva;
                
        menu.mostrar();
    }
    
    public static void paquetesIniciales(ListaPack lista){
        Pack nuevo= new Pack();
        nuevo.setPrecio(150);
        nuevo.setNombre("PREMIUM");
        nuevo.addVeneficio("Acceso a Buffet");
        nuevo.addVeneficio("Acceso a Piscina");
        nuevo.addVeneficio("Servicio a la Habitacion");
        nuevo.addVeneficio("Acceso a Minibar");
        nuevo.addVeneficio("Acceso a Internet");
        nuevo.addVeneficio("Acceso a Buffet");
        Pack nuevo2=new Pack();
        nuevo2.setNombre("Basico");
        nuevo2.setPrecio(10);
        nuevo2.addVeneficio("Acceso a Piscina");
        nuevo2.addVeneficio("Acceso a Internet");
        lista.add(nuevo);
        lista.add(nuevo2);
        
    }
    public static void habitaciones(ListaHabitacion listaHabitacion){
        for (char alphabet = 'A'; alphabet<='F';alphabet++){
            //System.out.println(alphabet);
            for (int i=1;i<=10;i++){
                int total=(i%2!=0) ? 100 : 100+50;
                int precio=total;
                boolean doble= (i%2!=0) ? false : false;
                boolean cargo= (alphabet>='E');
                total +=(cargo) ? (total*0.1) : 0;
                listaHabitacion.add(alphabet, precio, i, total, cargo, doble);
                //System.out.println("se añadio habitacion: " + alphabet + i);
            }
        }
    }
}
