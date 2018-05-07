/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1parcialpoo;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author R.Fuentes
 */
public class Reservacion {
    public int idReservacion;
    public Persona huesped;
    public Habitacion habitacion;
    public Precio precio;
    public Paquete paquete;
    public int NumDias;
    public Fecha fecha;
    public Fecha fechaSalida;
    
    
    public Reservacion() {
    }

    public int getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(int idReservacion) {
        this.idReservacion = idReservacion;
    }

    public Persona getHuesped() {
        return huesped;
    }

    public void setHuesped(Persona huesped) {
        this.huesped = huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Precio getPrecio() {
        return precio;
    }

    public void setPrecio(Precio precio) {
        this.precio = precio;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    

    public int getNumDias() {
        return NumDias;
    }

    public void setNumDias(int NumDias) {
        this.NumDias = NumDias;
    }
 
 public double precioEstadia(){
     double precioFin;
     precioFin=precio.getPrecioBase()*NumDias;
     return precioFin;
 }
 
 public double precioTotal(){
     double precioEstadia, precioPaquete=0;
     precioEstadia=precio.getPrecioBase()*NumDias;
     switch(paquete.paquete){
         case 1: 
             precioPaquete = paquete.precioBasico * NumDias;
             break;
        case 2: 
             precioPaquete = paquete.precioPremium * NumDias;
             break;
        case 3: 
             precioPaquete = 0;
             break;
        default:
            System.out.println("");
             
     
     }
     return precioEstadia + precioPaquete;
             
             
    }

}