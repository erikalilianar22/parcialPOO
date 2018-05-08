/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcialpoo;

import java.util.ArrayList;

/**
 *
 * @author rafa
 */
public class Habitacion {
    public char piso;
    public int Numero;
    public Pack pack;
    public boolean tipo;
    public boolean cargo;
    public boolean reservada;
    //public boolean enUso;
    public boolean disponible;
    public int precioBase;
    public int total;
    public Cliente cliente;
    public int diaInicio;
    public int diaFin;
    public ArrayList<Integer> dias;

    
    public Habitacion(){
        dias = new ArrayList<>();
    tipo = cargo = reservada = false;
    disponible=true;
    total=0;
    pack=null;
    cliente=null;
    precioBase=0;
    }
    public void addDias(){
        for(int dia=diaInicio;dia<=diaFin;dia++){
            dias.add(dia);
        }
        
        
    }
    
    
    
}