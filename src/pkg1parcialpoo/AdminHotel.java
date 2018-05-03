/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1parcialpoo;
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
    public void verReservacion(int id){
        for (Reservacion reservacion : reservaciones){
            if (reservacion.idReservacion == id){
                Nombre nombre =reservacion.huesped.getNombre();
                System.out.println("Nombre: " + nombre.getNombres() + nombre.getApellidos());
                
                NumCorrelativo numCorrelativo = reservacion.habitacion.getIdHabitacion();
                System.out.println("Habitacion: " + numCorrelativo.getPiso() + numCorrelativo.getNumHabitacion());
                
                System.out.println("Fecha: " + reservacion.Fecha.getDia() +"/" +  reservacion.Fecha.getMes() + "/"+  reservacion.Fecha.getAnnio() );            
                System.out.println("Estadia: " + reservacion.getNnumDias());
                System.out.println("Precio por Dia: " + reservacion.precioPorDia.getPrecioBase());
                System.out.println("Precio Total: " + reservacion.precioTotal.getPrecioBase());  
                break;
            }
            System.out.println("El Id no se encuentra registrado en el sistema");
        }
        
    }
    
   
    public void modificarReservacion(int id){
        
       System.out.println("Que Desea Modificar? ");
       System.out.println("1) Nombre ");
       System.out.println("2) Habitacion");
       System.out.println("3) Estadia");
       System.out.println("4) Fecha");
       System.out.println("5) Paquete");
       System.out.print("Ingrese una Opcion: ");
       Scanner leer = new Scanner(System.in);
       String name = leer.next();
       int opcion = Integer.parseInt(name);
       
           
       
        for (Reservacion reservacion : reservaciones){
            if (reservacion.idReservacion == id){
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
                    
                    //Cambiar Habitacion
                    case 2: 
                        
                        //Cambiar Estadia
                    case 3: System.out.println("Ingrese numero de dias: ");
                    Scanner leer4 = new Scanner(System.in);
                    String newEstadia= leer4.next();
                    int estadia = Integer.parseInt(newEstadia);
                    reservacion.setNumDias(estadia);
                    break;
                    //Cambiar Fecha
                    case 4: System.out.println("Ingrese dia: ");
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
                    
                    case 5:
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
