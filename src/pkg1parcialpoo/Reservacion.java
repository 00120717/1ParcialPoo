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

    public String getPaquete() {
        return paquete;
    }

    public void setPaquete(String paquete) {
        this.paquete = paquete;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public Reservacion(int NumDias) {
        this.NumDias = NumDias;
    }

    public int getNumDias() {
        return NumDias;
    }

    public void setNumDias(int NumDias) {
        this.NumDias = NumDias;
    }
 
 public double precioTotal(){
     double precioFin;
     precioFin=precio.getPrecioBase()*NumDias;
     return precioFin;
 }

   public void MostrarPaquetes(){
        System.out.println("Seleccione una opcion");
        System.out.println("1. Basico");
        System.out.println("2. Premium");
        System.out.println("3. Ninguno");
}
 public void seleccPaquete(){
          int opc=0;
        Scanner leer= new Scanner(System.in);
        while(opc!=4){
            MostrarPaquetes();
            try{
                switch(opc){
                    case 1:
                        System.out.println("-Acceso a la picina."
                                + "-Internet ilimitado.");
                        setPaquete("basico");
                        break;
                    case 2:
                        System.out.println("-Acceso al buffet de desayuno."
                                + "-Acceso inlimitado a la picina."
                                + "-Servicio a la habitacion."
                                + "Acceso ilimitado al mini bar."
                                + "Internet ilimitado.");
                        setPaquete("Premium");
                        break;
                    case 3:
                        System.out.println("Sin Paquete");
                        setPaquete("Ninguno");
                        break;
                    default:
                        System.out.println("Infrese una opcion valida.");
                }
            }
            catch(InputMismatchException err){
                System.err.println("Ingrese un numero");
                leer.nextLine();
            }
        }
        
    }

 public int[][] hab = new int[6][10]; 
 public void verificarHabitacion(){
      
         for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                hab[i][j]=1;
            }
 
 }}

}
