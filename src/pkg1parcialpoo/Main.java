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
        // TODO code application logic here
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Menu {
     private static Menu menu;

    private Menu() {
    }

    public static Menu getInstance() {
        if (menu == null) {
            menu = new Menu();
        }
        return menu;
    }

    public void opciones() {
        System.out.println("----- Bienvenido a Hotel Viña Rafinha -----");
        System.out.println("1. Agregar Cliente");
        System.out.println("2. Administrar Hotel");
        System.out.println("3. Administrar Reservacion");
    }

    public void mostrar() {
        int opcion = 4;
        Scanner leer = new Scanner(System.in);
        
        while (opcion != 3) {
            opciones();
            try {
                opcion = leer.nextInt();

                switch (opcion) {
                    case 1:
                        estudiantes.add();
                        break;
                    case 2:
                        estudiantes.mostrar();
                        break;
                    case 3:
                        System.out.println("Adios :(");
                        break;
                    default:
                        System.out.println("Por favor ingrese una opcion valida");
                }
            } catch (InputMismatchException e) {
                System.err.println("Por favor, Ingrese un número");
                leer.nextLine();
            }
        }
    }

}

        
        
    }
    
}
