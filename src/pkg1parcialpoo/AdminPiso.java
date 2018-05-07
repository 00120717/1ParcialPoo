/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1parcialpoo;

import java.util.ArrayList;

/**
 *
 * @author R.Fuentes,00161617
 */
public class AdminPiso {
  public static boolean[][] pisosHabitaciones = new boolean[6][10];
    public static ArrayList<String> pisosHabilitados;
    
    public AdminPiso(){
        
        pisosHabilitados = new ArrayList<>();
        
        pisosHabilitados.add("a");
        pisosHabilitados.add("b");
        pisosHabilitados.add("c");
        pisosHabilitados.add("d");
        pisosHabilitados.add("e");
        pisosHabilitados.add("f");
        
        for (int i=0; i<6;i++){
            for (int j=0; j<10;j++){
                pisosHabitaciones[i][j]=true;
            }
        }
        
    }
    
    public static boolean verificarPisosHabitacion(String letra, int numHabitacion){
        switch (letra){
            case "a": 
                return pisosHabitaciones[0][numHabitacion];
            case "b":
                return pisosHabitaciones[1][numHabitacion];
            case "c":
                return pisosHabitaciones[2][numHabitacion];
            case "d":
                return pisosHabitaciones[3][numHabitacion];
            case "e":
                return pisosHabitaciones[4][numHabitacion];
            case "f":
                return pisosHabitaciones[5][numHabitacion];
            default: 
                System.out.println("Error");
                return false;

                
        }
        
    }
    
    public static void deshabilitarPisoHabitacion(String letra, int numHabitacion){
        switch (letra){
            case "a": 
                pisosHabitaciones[0][numHabitacion] = false;
                break;
            case "b":
                pisosHabitaciones[1][numHabitacion] = false;
                break;
            case "c":
                pisosHabitaciones[2][numHabitacion] = false;
                break;
            case "d":
                pisosHabitaciones[3][numHabitacion] = false;
                break;
            case "e":
                pisosHabitaciones[4][numHabitacion] = false;
                break;
            case "f":
                pisosHabitaciones[5][numHabitacion] = false;
                break;

                
        }
    
}
    
     public static void habilitarPisoHabitacion(String letra, int numHabitacion){
        switch (letra){
            case "a": 
                pisosHabitaciones[0][numHabitacion] = true;
                break;
            case "b":
                pisosHabitaciones[1][numHabitacion] = true;
                break;
            case "c":
                pisosHabitaciones[2][numHabitacion] = true;
                break;
            case "d":
                pisosHabitaciones[3][numHabitacion] = true;
                break;
            case "e":
                pisosHabitaciones[4][numHabitacion] = true;
                break;
            case "f":
                pisosHabitaciones[5][numHabitacion] = true;
                break;

                
        }
    
}
    
    
    public static boolean deshabilitarPiso(String a){
        if (pisosHabilitados.contains(a)){
            pisosHabilitados.remove(a);
            return true;
        }
        else return false;
    }
    
    public static boolean habilitarPiso(String a){
        if (! pisosHabilitados.contains(a)){
            pisosHabilitados.add(a);
            return true;
        }
        else return false;
    }

    
    
}
