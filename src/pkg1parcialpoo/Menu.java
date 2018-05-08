/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1parcialpoo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Oscar Lovato
 */
public class Menu {
    private static Menu menu;

    public Menu() {
    }
    
    public static Menu getInstance(){
        if(menu==null){
            menu=new Menu();
        }
        return menu;
    }
    public void opciones(){
        AdminHotel adminHotel=new AdminHotel();
        while(true){    
        int option=0;
           while(option==0){
            try{
                System.out.println("");
                System.out.println("Menu Principal");
                System.out.println("1) Modificar Precio de Habitacion");
                System.out.println("2) Habilitar o Deshabilitar Piso");
                System.out.println("3) Crear Nueva Reservacion");
                System.out.println("4) Ver Reservacion");
                System.out.println("5) Modificar Reservacion");
                System.out.println("6) Cancelar Reservacion");
                System.out.println("7) Ver Reservaciones de la Siguiente Semana");
                System.out.println("8) Mostrar habitaciones disponibles");
                System.out.println("9) Salir");
                System.out.print("Ingrese Una Opcion: ");
                Scanner leerOpcion = new Scanner(System.in);
                String opcion = leerOpcion.next();
                option = Integer.parseInt(opcion);
            }
            catch(Exception ex){
                System.err.println("Error, Ingrese un Digito! /n");
            }
        }
        
        switch(option){
            case 1: adminHotel.modificarPrecioDeHabitacion();
            break;
            case 2: adminHotel.modificarPiso();
            break;
            case 3: adminHotel.crearReservacion();
            break;
            case 4: 
                System.out.println("Ingrese El ID de la Reservacion: ");
                Scanner leerIdReservacion = new Scanner(System.in);
                String id = leerIdReservacion.next();
                int idReservacion = Integer.parseInt(id);
               adminHotel.verReservacion(idReservacion);
            break;
            case 5: 
                System.out.print("Ingrese Id de la Reservacion a Modificar: ");
                Scanner leerIdReservacion2 = new Scanner(System.in);
                String id2 = leerIdReservacion2.next();
                int idReservacion2 = Integer.parseInt(id2);
                adminHotel.modificarReservacion(idReservacion2);
            break;
            case 6: 
                System.out.print("Ingrese Id de la Reservacion a Cancelar: ");
                Scanner leerIdReservacion3 = new Scanner(System.in);
                 int hol = leerIdReservacion3.nextInt();
           
                adminHotel.cancelarReservacion(hol);
            break;
            case 7: 
                System.out.println("Reservaciones de la proxima semana");
                System.out.println("--------------------------------------");
                adminHotel.verReservacionesSemana();
   
            break;
            case 8:
                AdminPiso.MostrarHabitacionesDisponibles();
                break;
            case 9:
                System.exit(0);
                break;
            default: System.err.println("Error, Ingrese una opcion valida!");
            break;
        }
        
    }
    }
}
