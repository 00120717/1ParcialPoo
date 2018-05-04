/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1parcialpoo;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
/**
 *
 * @author Marvin Ramirez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int opcion;
        AdminHotel Armin = new AdminHotel();
        
        
        System.out.println("Ingrese la opcion que desea realizar"
                + "1.Añadir reservacion"
                + "2.Ver reservacion"
                + "3.Modificar reservacion"
                + "4.cancelar reservacion"
                + "5.Modificar paquete"
                + "6.Modificar habitacion"
                + "7.Modificar piso"
                + "8.SALIR");
        
        Scanner leer = new Scanner(System.in);
        opcion = leer.nextInt();
        
        switch(opcion){
            case 1:
                Reservacion reserva= new Reservacion();
                Persona huesped= new Persona();
                int id=0,edad=0,NumDias=0;
                Nombre nombre = null;
                String nom=null, apell=null;
                System.out.println("Ingrese id de la reservacion");
           
                id = leer.nextInt();
                reserva.setIdReservacion(id);
                System.out.println("Ingrese nombres del cliente");
                nom = leer.next();
                nombre.setNombres(nom);
                System.out.println("Ingrese nombres del cliente");
                apell = leer.next();
                nombre.setApellidos(apell);
     
                reserva.huesped.setNombre(nombre);
                System.out.println("Ingrese la edad del cliente");
                edad = leer.nextInt();
                reserva.huesped.setEdad(edad);
                System.out.println("Ingrese la cantidad de dias de la reservacion");
                NumDias = leer.nextInt();
                reserva.setNumDias(NumDias);
                
                reserva.precio.getPrecioBase();
                System.out.println("Seleccione paquete");
                reserva.seleccPaquete();
                
                
                Armin.addReservacion(reserva);
                break;
            case 2:
                System.out.println("Ingrese Id de la habitacion");
                id = leer.nextInt();
                Armin.verReservacion(id);
                break;
            case 3:
                System.out.println("Ingrese Id de la habitacion");
                id = leer.nextInt();
                Armin.modificarReservacion(id);
                break;
            case 4:
                System.out.println("Ingrese Id de la habitacion");
                id = leer.nextInt();
                Armin.cancelarReservacion(id);
                break;
            case 5:
                Armin.modificarPaquete();
                break;
            case 6:
                Armin.modificarHabitacion();
                break;
            case 7:
                Armin.modificarPiso();
                break;
            default:
                System.out.println("Ingrese una opcion de las anteriores");
                
        }
    }
    
}
