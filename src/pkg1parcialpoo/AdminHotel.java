/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1parcialpoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Date;

/**
 *
 * @author R.Fuentes, 00161617
 */
public class AdminHotel {

    private ArrayList<Reservacion> reservaciones;
    public static int id =0;
    Scanner input = new Scanner(System.in);

    
    
    public AdminHotel() {
        AdminPiso administradorDePiso = new AdminPiso();
        reservaciones = new ArrayList<>();
        
        while(true){
            /*
        System.out.println("Menu Principal");
        System.out.println("1) Modificar Precio de Habitacion");
        System.out.println("2) Habilitar o Deshabilitar Piso");
        System.out.println("3) Crear Nueva Reservacion");
        System.out.println("4) Ver Reservacion");
        System.out.println("5) Modificar Reservacion");
        System.out.println("6) Cancelar Reservacion");
        System.out.print("Ingrese Una Opcion: ");
            */
        
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
            case 1: modificarPrecioDeHabitacion();
            break;
            case 2: modificarPiso();
            break;
            case 3: crearReservacion();
            break;
            case 4: 
                System.out.println("Ingrese El ID de la Reservacion: ");
                Scanner leerIdReservacion = new Scanner(System.in);
                String id = leerIdReservacion.next();
                int idReservacion = Integer.parseInt(id);
                verReservacion(idReservacion);
            break;
            case 5: 
                System.out.print("Ingrese Id de la Reservacion a Modificar: ");
                Scanner leerIdReservacion2 = new Scanner(System.in);
                String id2 = leerIdReservacion2.next();
                int idReservacion2 = Integer.parseInt(id2);
                modificarReservacion(idReservacion2);
            break;
            case 6: 
                System.out.print("Ingrese Id de la Reservacion a Cancelar: ");
                Scanner leerIdReservacion3 = new Scanner(System.in);
                System.out.print("el id antes : "+leerIdReservacion3 );
                 int id3 = leerIdReservacion3.nextInt();
           
                System.out.print("el id que se mando: "+id3 );
                cancelarReservacion(id3);
            break;
            case 7: 
                verReservacionesSemana();
                
            break;
            default: System.err.println("Error, Ingrese una opcion valida!");
            break;
        }
        
    }
 }
    
   public void verReservacionesSemana() {
    
    Date date = new Date();
    java.time.LocalDate localDate = date.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
    
    
    
    //java.time.LocalDate test = localDate.plusDays(7);

    for (int i=0; i<7;i++){
            java.time.LocalDate test = localDate.plusDays(i);
            int year  = test.getYear();
            int month = test.getMonthValue();
            int day   = test.getDayOfMonth();
            //System.out.println("Ahora la fecha es: " + day + " "+month+" "+year);
            
        for (Reservacion reserv: reservaciones){
            if((reserv.fecha.getDia()== day)&&(reserv.fecha.getMes()== month)&&(reserv.fecha.getAnnio()== year)){
                verReservacion(reserv.idReservacion);
                System.out.println("");
            }
        }
    }

   }


    public void modificarPrecioDeHabitacion() {
        double precio;
        System.out.println("Ingrese Nuevo Precio: ");
        precio = input.nextDouble();

        //Precio newPrecio = new Precio();
        
        //newPrecio.setPrecioBase(precio);
        Habitacion.precioInicial=precio;
    }

    public void modificarPaquete() {

    }


    public void modificarPiso() {
        
        System.out.println("1) Deshabilitar Piso");
        System.out.println("2) Habilitar Piso");
        Scanner leer = new Scanner(System.in);
        String opcion = leer.next();
        int option = Integer.parseInt(opcion);
        
        switch(option){
            case 1:
                
                System.out.println("Pisos Actualmente Habilitado: ");
                System.out.println(AdminPiso.pisosHabilitados.toString());
                System.out.println("Ingrese letra del nivel a deshabilitar: ");
                Scanner leer2 = new Scanner(System.in);
                String letra = leer.next();
                if (AdminPiso.deshabilitarPiso(letra)) {
                    System.out.println("Piso ha sido deshabilitado");
                } else {
                    System.out.println("Error");
                }
                break;
            case 2:
                System.out.println("Ingrese letra del nivel a habilitar: ");
                Scanner leer3 = new Scanner(System.in);
                String letra2 = leer.next();
                if (AdminPiso.habilitarPiso(letra2)) {
                    System.out.println("Piso ha sido habilitado");
                } else {
                    System.out.println("Error");
                }
                break;
        }
    }

    public void addReservacion(Reservacion reservacion) {
        reservaciones.add(reservacion);

    }

    public void verReservacion(int id) {
        for (Reservacion reservacion : reservaciones) {
            if (reservacion.idReservacion == id) {
                Nombre nombre = reservacion.huesped.getNombre();
                System.out.println("Nombre: " + nombre.getNombres() + " " +  nombre.getApellidos());

                NumCorrelativo numCorrelativo = reservacion.habitacion.getIdHabitacion();
                System.out.println("Habitacion: " + numCorrelativo.piso.getLetra() + numCorrelativo.getNumHabitacion());
                if(numCorrelativo.numHabitacion%2 ==0) System.out.println("Tipo de Habitacion: Doble");
                else System.out.println("Tipo de Habitacion: Sencilla");
                
                System.out.println("Estadia: " + reservacion.getNumDias() + " Dias");
                System.out.println("Fecha de Ingreso: " + reservacion.fecha.dia + " / " + reservacion.fecha.mes + " / " + reservacion.fecha.annio);
                System.out.println("Paquete: " + reservacion.paquete.paquete);
                System.out.println("Precio Por Dia: " + reservacion.habitacion.precio.precioBase);
                System.out.println("Precio de la Estadia: $" + (reservacion.habitacion.precio.precioBase * reservacion.NumDias));
                if (reservacion.paquete.paquete == 1){
                        System.out.println("Precio Total: $" + (reservacion.habitacion.precio.precioBase + Paquete.precioBasico)* reservacion.NumDias);
                }
                if (reservacion.paquete.paquete == 2){
                        System.out.println("Precio Total: $" + (reservacion.habitacion.precio.precioBase + Paquete.precioPremium)* reservacion.NumDias);
                }
                if (reservacion.paquete.paquete == 3){
                        System.out.println("Precio Total Por Cobrar a Tarjeta de Credito: $" + (reservacion.habitacion.precio.precioBase )* reservacion.NumDias);
                }
                
                System.out.println("Id de la Reservacion: " + reservacion.idReservacion);
                break;
            }
            
        }
        //System.out.println("El Id no se encuentra registrado en el sistema");

    }

    public void modificarReservacion(int id) {

        for (Reservacion reservacion : reservaciones) {
            if (reservacion.idReservacion == id) {
                System.out.println("Que Desea Modificar? ");
                System.out.println("1) Nombre ");
                System.out.println("2) Estadia");
                System.out.println("3) Fecha");
                System.out.println("4) Paquete");
                System.out.println("5) Habitacion de la reservacion");
                System.out.print("Ingrese una Opcion: ");
                Scanner leer = new Scanner(System.in);
                String name = leer.next();
                int opcion = Integer.parseInt(name);

                switch (opcion) {

                    //Cambiar Nombre
                    case 1:
                        System.out.println("Ingrese nuevos nombres: ");
                        Scanner leer2 = new Scanner(System.in);
                        String newName = leer2.next();
                        System.out.println("Ingrese nuevos apellidos: ");
                        Scanner leer3 = new Scanner(System.in);
                        String newApellidos = leer3.next();
                        reservacion.huesped.nombre.setNombres(newName);
                        reservacion.huesped.nombre.setApellidos(newApellidos);
                        break;
                    //Cambiar Estadia
                    case 2:
                        System.out.println("Ingrese numero de dias: ");
                        Scanner leer4 = new Scanner(System.in);
                        String newEstadia = leer4.next();
                        int estadia = Integer.parseInt(newEstadia);
                        reservacion.setNumDias(estadia);
                        break;
                    //Cambiar Fecha
                    case 3:
                        System.out.println("Ingrese dia: ");
                        Scanner leer5 = new Scanner(System.in);
                        String dia = leer5.next();
                        int newDia = Integer.parseInt(dia);

                        System.out.println("Ingrese mes: ");
                        Scanner leer6 = new Scanner(System.in);
                        String mes = leer6.next();
                        int newMes = Integer.parseInt(mes);

                        System.out.println("Ingrese annio: ");
                        Scanner leer7 = new Scanner(System.in);
                        String annio = leer7.next();
                        int newAnnio = Integer.parseInt(annio);

                        reservacion.fecha.setDia(newDia);
                        reservacion.fecha.setMes(newMes);
                        reservacion.fecha.setAnnio(newAnnio);

                        break;

                    case 4:
                        reservacion.paquete.MostrarPaquetes();
                        System.out.println("Ingrese nuevo paquete: ");
                        Scanner leer8 = new Scanner(System.in);
                        String paquete = leer8.next();
                        int newPaquete = Integer.parseInt(paquete);
                        reservacion.paquete.setPaquete(newPaquete);

                        break;
                        
                    case 5: 
                    System.out.println("Pisos disponibles");
                    for(String x: AdminPiso.pisosHabilitados){
                        System.out.println(x);
                    }
                    
                    int a =0;
                    String newPiso = "";
                    while(a == 0){
                    System.out.println("Ingrese el nuevo piso: ");
                    Scanner leerPiso = new Scanner(System.in);
                    newPiso = leerPiso.next();
                    newPiso= newPiso.toLowerCase();
                    if (! AdminPiso.pisosHabilitados.contains(newPiso)){
                        System.out.println("Debe Ingresar un piso valido");
                        }
                    else{
                        a = 1;
                     }
                    }
                     System.out.println("Piso Seleccionado: " + newPiso);
                     
                     
                    int b=0;
                    while(b==0){
                    System.out.println("Ingrese el nuevo numero de habitacion: ");
                    Scanner leerHab = new Scanner(System.in);
                    String newHab = leerHab.next();
                    int newHab2 = Integer.parseInt(newHab);
                    if ((newHab2 >= 1 ) && (newHab2 <= 10) && (AdminPiso.verificarPisosHabitacion(newPiso, newHab2))){
                        reservacion.habitacion.idHabitacion.piso.setLetra(newPiso);
                        reservacion.habitacion.idHabitacion.setNumHabitacion(newHab2);
                        AdminPiso.deshabilitarPisoHabitacion(newPiso, newHab2);
                        b=1;
                    }
                    else{
                        System.out.println("Error ");
                    }
                   }
                    
                    
                    
                    

                }
            }
        }
    }

    public void cancelarReservacion(int id) {

        for (Reservacion reservacion : reservaciones) {
            System.out.println(reservacion.idReservacion);
            if (reservacion.getIdReservacion() == id) {
                reservaciones.remove(reservacion);
            }
        }
    }

}
