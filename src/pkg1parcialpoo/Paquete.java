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
    
    public void Paquete(){}
    
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
                    case 2:
                        System.out.println("-Acceso al buffet de desayuno."
                                + "-Acceso inlimitado a la picina."
                                + "-Servicio a la habitacion."
                                + "Acceso ilimitado al mini bar."
                                + "Internet ilimitado.");
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

    public int getPaquete() {
        return paquete;
    }

    public void setPaquete(int paquete) {
        this.paquete = paquete;
    }
    
    
}
