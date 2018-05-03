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
 * @author R.Fuentes, 00161617
 */
public class AdminHotel {
   
    private ArrayList <Reservacion> reservaciones;
    private String id;
    Scanner  input=new Scanner(System.in);
    
    public String getId() {
        return id;
    }

    public AdminHotel(String id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public AdminHotel(){}
    
    
    public void modificarPrecio(){
       double preci;
        System.out.println("Ingrese Precio: ");
        preci =input.nextDouble();
        
       
        Precio precio =new Precio(); 
        precio.setPrecioBase(preci);
    }
    
        public void modificarPaquete(){
    
        }
        public void modificarHabitacion(){
    }
        public void modificarPiso(){
    }
        
        
        
        
        
        public void addReservacion(Reservacion reservacion){
        reservaciones.add(reservacion); 
        
    }
    public boolean verReservacion(int id){
        for (Reservacion reservacion : reservaciones){
            if (reservacion.idReservacion== id){
                Nombre nombre =reservacion.huesped.getNombre();
                System.out.println("Nombre: " + nombre.getNombres() + nombre.getApellidos());
                
                NumCorrelativo numCorrelativo = reservacion.habitacion.getIdHabitacion();
                System.out.println("Habitacion: " + numCorrelativo.getPiso() + numCorrelativo.getNumHabitacion());
                System.out.println("Fecha: " + reservacion.fecha.getDia() +"/" +  reservacion.fecha.getMes() + "/"+  reservacion.fecha.getAnnio() );            
                System.out.println("Estadia: " + reservacion.getNumDias());
                System.out.println("Precio Total: " + reservacion.precioTotal());  
                return true;
            }
            System.out.println("El Id no se encuentra registrado en el sistema");
            return false;
        }
        
    }
    
   
    public void modificarReservacion(int id){

        for (Reservacion reservacion : reservaciones){
            if (reservacion.idReservacion == id){
                System.out.println("Que Desea Modificar? ");
                System.out.println("1) Nombre ");
                System.out.println("2) Estadia");
                System.out.println("3) Fecha");
                System.out.println("4) Paquete");
                System.out.print("Ingrese una Opcion: ");
                Scanner leer = new Scanner(System.in);
                String name = leer.next();
                int opcion = Integer.parseInt(name);
       
                switch(opcion){
                    
                    //Cambiar Nombre
                    case 1: System.out.println("Ingrese nuevos nombres: ");
                    Scanner leer2 = new Scanner(System.in);
                    String newName= leer2.next();
                    System.out.println("Ingrese nuevos apellidos: ");
                    Scanner leer3 = new Scanner(System.in);
                    String newApellidos= leer3.next();
                    reservacion.huesped.nombre.setNombres(newName);
                    reservacion.huesped.nombre.setApellidos(newApellidos);
                    break;
                        //Cambiar Estadia
                    case 2: System.out.println("Ingrese numero de dias: ");
                    Scanner leer4 = new Scanner(System.in);
                    String newEstadia= leer4.next();
                    int estadia = Integer.parseInt(newEstadia);
                    reservacion.setNumDias(estadia);
                    break;
                    //Cambiar Fecha
                    case 3: System.out.println("Ingrese dia: ");
                    Scanner leer5 = new Scanner(System.in);
                    String dia= leer5.next();
                    int newDia = Integer.parseInt(dia);
                    
                    System.out.println("Ingrese mes: ");
                    Scanner leer6 = new Scanner(System.in);
                    String mes= leer6.next();
                    int newMes = Integer.parseInt(mes);
                    
                    System.out.println("Ingrese annio: ");
                    Scanner leer7 = new Scanner(System.in);
                    String annio = leer7.next();
                    int newAnnio = Integer.parseInt(annio);
                    
                    reservacion.fecha.setDia(newDia);
                    reservacion.fecha.setMes(newMes);
                    reservacion.fecha.setAnnio(newAnnio);
                    
                    break;
                    
                    case 4: reservacion.paquete.MostrarPaquetes();
                    System.out.println("Ingrese nuevo paquete: ");
                    Scanner leer8 = new Scanner(System.in);
                    String paquete = leer8.next();
                    int newPaquete = Integer.parseInt(paquete);
                    reservacion.paquete.setPaquete(newPaquete);
                    
                        break;
                    
                }
            }
        }   
    }
    public void cancelarReservacion(int id){
        
        for (Reservacion reservacion : reservaciones){
            if (reservacion.getIdReservacion() == id){
                reservaciones.remove(reservacion);
            }   
        }
    }
    
}
