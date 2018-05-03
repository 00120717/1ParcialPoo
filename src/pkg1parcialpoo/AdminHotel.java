/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1parcialpoo;
import java.util.Scanner;
/**
 *
 * @author R.Fuentes
 */
public class AdminHotel {
   
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
       double precio;
        System.out.println("Ingrese Precio: ");
        precio =input.nextDouble();
}        Precio.precioBase.setPrecioBase(precio);

    public void modificarPaquete(){
}
    public void modificarHabitacion(){
}
    public void modificarPiso(){
}
    
}
