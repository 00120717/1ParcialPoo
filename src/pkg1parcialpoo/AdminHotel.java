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


    public void crearReservacion() {
        
        Reservacion nuevaReservacion = new Reservacion();
        
        //Se asigna id
        
            nuevaReservacion.idReservacion = AdminHotel.id + 1;
            id++;
            //System.out.println("El Id de la Reservacion Asignado es: " + nuevaReservacion.idReservacion );
        
        //Campos de clase persona/Huesped
        Persona nuevaPersona = new Persona();
        nuevaReservacion.huesped = nuevaPersona;
        
            DUI nuevoDui = new DUI();
            nuevaPersona.dui = nuevoDui;
            
            int a = 0;
            int [] codigo=new int[8];
            int verificador;
            
        while (a == 0) {
            try{
            for (int i=0; i<8;i++){
                
                int newDui=11;
                
                while((newDui>9)||(newDui<0)){
                System.out.print("Ingrese el " + (i+1) + " Digito de el dui: ");
                Scanner leer = new Scanner(System.in);
                String dui = leer.next();
                newDui = Integer.parseInt(dui);
                codigo[i]=newDui;
                if ((newDui>9)||(newDui<0))System.err.println("Numero Ingresado Incorrecto!");
                }
              }
                System.out.print("Ingrese el 9 Digito de el dui: ");
                Scanner leer = new Scanner(System.in);
                String dui = leer.next();
                int newDui = Integer.parseInt(dui);
                verificador = newDui;
            nuevoDui.setCodigo(codigo);
            nuevoDui.setVerificador(verificador);
            
            //if (nuevoDui.verificar(codigo)) //a=1; //Verificamos el dui, si es valido salimos de buckle
            //a=1;
            
            } catch(Exception ex){
                    System.err.println("Ingrese un Digito Valido!");
                }
            
            //Verificamos si el dui se encuentra mas de 2 veces en la lista de reservaciones    
                int cont=0;
                int [] array1 = nuevaReservacion.huesped.dui.getCodigo();
                int verificador1 = nuevaReservacion.huesped.dui.getVerificador();

                  for (Reservacion flag : reservaciones){
                      int [] array2 = flag.huesped.dui.getCodigo();
                      int verificador2 = flag.huesped.dui.getVerificador();

                      if((Arrays.equals(array1,array2)) && verificador1==verificador2){
                          cont++;
                      }

                  }
                      if ((cont>=2)||( ! nuevoDui.verificar(codigo))){
                          System.err.println("Error No Se Puede Registrar a Esta Persona!");
                          a=1;
                          
                      }
                      else a=1;

        }
        
        
        System.out.println("Ingrese Nuevo Primer y Segundo Nombre: ");
        Scanner leer = new Scanner(System.in);
        String newName = leer.nextLine();
        System.out.println("Ingrese Nuevo Primer y Segundo Apellido: ");
        Scanner leer2 = new Scanner(System.in);
        String newApellido = leer2.nextLine();
        
        Nombre nombre = new Nombre();
        nuevaPersona.nombre= nombre;
        
        nombre.nombres =newName;
        nombre.apellidos=newApellido;
        
        int newEdad = 0;
        while(newEdad==0){
            try{
        System.out.print("Ingrese Edad: ");
        Scanner leer3 = new Scanner(System.in);
        String edad = leer3.next();
        newEdad = Integer.parseInt(edad);
            }
            catch (Exception ex){
                System.err.println("Numero Invalido!");
            }
        }
        
        nuevaPersona.edad=newEdad;
        
        //Campos de Habitacion
        Habitacion nuevaHabitacion = new Habitacion();
        nuevaReservacion.habitacion = nuevaHabitacion;
        
                NumCorrelativo nuevoNumCorrelativo = new NumCorrelativo();
                nuevaHabitacion.idHabitacion = nuevoNumCorrelativo;
                
                                        System.out.println("Pisos disponibles");
                                        for (String x : AdminPiso.pisosHabilitados) {
                                            System.out.println(x);
                                        }

                                        int f = 0;
                                        String newPiso = "";
                                        while (f == 0) {
                                            System.out.println("Ingrese el nuevo piso: ");
                                            Scanner leerPiso = new Scanner(System.in);
                                            newPiso = leerPiso.next();
                                            newPiso= newPiso.toLowerCase();
                                            if (!AdminPiso.pisosHabilitados.contains(newPiso)) {
                                                System.err.println("Debe Ingresar un piso valido");
                                            } else {
                                                f = 1;
                                            }
                                        }
                                        //System.out.println("Piso Seleccionado: " + newPiso);
                                        
                                        
                                        
                                          System.out.println("Habitaciones disponibles en piso: " + newPiso);
                                          switch (newPiso){
                                            case "a": 
                                                for (int i=0;i<10;i++) {
                                                    if (AdminPiso.pisosHabitaciones[0][i] == true)
                                                    System.out.print( 1+ i+ ", ");
                                                }
                                                break;
                                            case "b":
                                                for (int i=0;i<10;i++) {
                                                    if (AdminPiso.pisosHabitaciones[1][i] == true)
                                                    System.out.print(1+ i+ ", ");
                                                }
                                                break;
                                            case "c":
                                                for (int i=0;i<10;i++) {
                                                    if (AdminPiso.pisosHabitaciones[2][i] == true)
                                                    System.out.print(1 + i+ ", ");
                                                }
                                                break;
                                            case "d":
                                                for (int i=0;i<10;i++) {
                                                    if (AdminPiso.pisosHabitaciones[3][i] == true)
                                                    System.out.print(i+1+ ", ");
                                                }
                                                break;
                                            case "e":
                                                for (int i=0;i<10;i++) {
                                                    if (AdminPiso.pisosHabitaciones[4][i] == true)
                                                    System.out.print(1+ i+ ", ");
                                                }
                                                break;
                                            case "f":
                                                for (int i=0;i<10;i++) {
                                                    if (AdminPiso.pisosHabitaciones[5][i] == true)
                                                    System.out.print(1 + i + ", ");
                                                }
                                                break;
                                            default: 
                                                System.out.println("Error");
                                          }
                                        
                                        
                                        int b = 0;
                                        while (b == 0) {
                                            try{
                                            System.out.println("");
                                            System.out.println("Ingrese el nuevo numero de habitacion: ");
                                            Scanner leerHab = new Scanner(System.in);
                                            String newHab = leerHab.next();
                                            int newHab2 = Integer.parseInt(newHab);
                                            if ((newHab2 >= 1) && (newHab2 <= 10) && (AdminPiso.verificarPisosHabitacion(newPiso, newHab2-1))) {
                                                

                                                Piso nuevoPiso = new Piso();
                                                nuevaHabitacion.idHabitacion.piso = nuevoPiso;
                                                nuevoPiso.letra = newPiso;
                                                
                                                nuevaHabitacion.idHabitacion.setNumHabitacion(newHab2);
                                                AdminPiso.deshabilitarPisoHabitacion(newPiso, newHab2-1);
                                                System.out.println("Se deshabilito exitosamente el " + newPiso + newHab2 + " y ahora es "+ AdminPiso.verificarPisosHabitacion(newPiso, newHab2-1) );
                                                b = 1;
                                            } else {
                                                System.err.println("Error, Numero de habitacion no disponible! ");
                                            }
                                            } catch(Exception ex){
                                                System.err.println("Porfavor ingrese un digito valido!" + ex);
                                            }
                                        }
                //Precio nuevoPrecio = new Precio();
                //nuevaHabitacion.setPrecio(nuevoPrecio);
                
        //Campos de Fecha
        int newDia=0, newMes=0, newAnnio=0;
        int alpha=0;
        
        while(alpha==0){
            
       
        try{
            
            while((newDia<=0)||(newDia>31) ){
        Scanner leerFecha = new Scanner(System.in);
        System.out.print("Ingrese el Dia de la Fecha de Ingreso: ");
         String dia = leerFecha.next();
         newDia = Integer.parseInt(dia); 
         
         //System.out.println("newDia es: "+ String.valueOf(newDia).length());
         if((newDia<=0)||(newDia>31) ) System.err.println("Ingrese un Dia Valido!");
        }
        
                 
        while((newMes<=0) || (newMes>12)){
         Scanner leerFecha2 = new Scanner(System.in);
         System.out.print("Ingrese el Mes de la Fecha de Ingreso: ");
         String mes = leerFecha2.next();
         newMes = Integer.parseInt(mes);
         if((newMes<=0) || (newMes>12)) System.err.println("Ingrese un Mes Valido!");
        }
        
        
         while(String.valueOf(newAnnio).length() != 4){
         Scanner leerFecha3 = new Scanner(System.in);
         System.out.print("Ingrese el Año de la Fecha de Ingreso: ");
         String annio = leerFecha3.next();
         newAnnio = Integer.parseInt(annio);
         if(String.valueOf(newAnnio).length() != 4) System.err.println("Ingrese un Año Valido!");
         }
         
        Fecha fecha = new Fecha(newDia, newMes, newAnnio);
        nuevaReservacion.fecha = fecha;
        alpha=1;
            
           } catch (Exception ex){
               System.err.println(" Ingrese un registro valido");
           }
        
        }

         
        //Campos de numDias
        int flag1 =0;
        int newDias=0;
        while(flag1==0){
        try{
        //while(flag1==0){
        System.out.print("Ingrese la cantidad de dias de la estadia: ");
        Scanner leerDias= new Scanner(System.in);
         String dias = leerDias.next();
         newDias = Integer.parseInt(dias);
            if ((newDias>0)&&(newDias<=7)){
           nuevaReservacion.NumDias=newDias;
           flag1=1;
            }
           else {
                   System.out.println("Numero de dias Invalido!");
                   }
        } catch( Exception ex){
            System.err.println("Ingrese Un Numero Valido");
        }
      }
        
        //Campos de Precio (Precio total)
        Precio nuevoPrecioTotal = new Precio();
        nuevaReservacion.precio=nuevoPrecioTotal;
        
        double precioDeHabitacion = nuevaReservacion.habitacion.precio.getPrecioBase();
        nuevoPrecioTotal.setPrecioBase(precioDeHabitacion*newDias);
        
        //Campos de paquete
        Paquete nuevoPaquete = new Paquete();
        nuevaReservacion.paquete = nuevoPaquete;
        
        /*
        nuevaReservacion.paquete.MostrarPaquetes();
                        System.out.println("Ingrese paquete: ");
                        Scanner leer8 = new Scanner(System.in);
                        String paquete = leer8.next();
                        int newPaquete = Integer.parseInt(paquete);
                        nuevaReservacion.paquete.setPaquete(newPaquete);
        */
         int OpcSelecionada = nuevaReservacion.paquete.seleccPaquete();
         nuevaReservacion.paquete.setPaquete(OpcSelecionada);
                        
        
         
  //Verificamos si el dui se encuentra mas de 2 veces en la lista de reservaciones    
  int cont=0;
  int [] array1 = nuevaReservacion.huesped.dui.getCodigo();
  int verificador1 = nuevaReservacion.huesped.dui.getVerificador();
  
    for (Reservacion flag : reservaciones){
        int [] array2 = flag.huesped.dui.getCodigo();
        int verificador2 = flag.huesped.dui.getVerificador();
        
        if((Arrays.equals(array1,array2)) && verificador1==verificador2){
            cont++;
        }
        
    }
        if (cont>=2){
            System.err.println("Esta Persona Ya ha Registrado 2 Habitaciones");
        }
        else{
        addReservacion(nuevaReservacion);
        System.out.println("Reservacion Creada Exitosamente!");
        System.out.println("");
        verReservacion(id);
        }
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
