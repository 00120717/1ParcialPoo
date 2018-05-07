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
public class Paquete {
    //1=Basico, 2=Premium, 3=Ninguno
    public int paquete;
    public static double precioBasico=10;
    public static double precioPremium=150;
    
    public void Paquete(){}
    
    public void MostrarPaquetes(){
        System.out.println("Paquetes Disponibles");
        System.out.println("1. Basico");
        System.out.println("2. Premium");
        System.out.println("3. Ninguno");
}
    
    public int seleccPaquete(){
        MostrarPaquetes();
        
        int opc=0;
        
        
        while(opc==0){
            try{
                System.out.print("Seleccione Una Opcion: ");
                Scanner leer= new Scanner(System.in);
                String packSelect = leer.next();
                opc = Integer.parseInt(packSelect);
                switch(opc){
                    case 1:
                        System.out.println("");
                        System.out.println("Paquete Basico Contiene:");
                        System.out.println("-Acceso a la picina");
                        System.out.println("-Internet ilimitado");
                        System.out.println("");
                        return opc;
                    case 2:
                        System.out.println("-Acceso al buffet de desayuno."
                                + "-Acceso inlimitado a la picina."
                                + "-Servicio a la habitacion."
                                + "Acceso ilimitado al mini bar."
                                + "Internet ilimitado.");
                        return opc;
                    case 3:
                        return opc;
                    default:
                        System.out.println("Infrese una opcion valida.");
                        opc=0;
                }
            }
            catch(InputMismatchException err){
                System.err.println("Ingrese un numero");
                opc=0;
                
            }
        }
        return 0;
        
    }

    public int getPaquete() {
        return paquete;
    }

    public void setPaquete(int paquete) {
        this.paquete = paquete;
    }
    
    
}
