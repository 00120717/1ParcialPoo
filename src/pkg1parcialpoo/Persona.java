/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1parcialpoo;

/**
 *
 * @author Marvin Ramirez
 */
public class Persona {
     private Nombre nombre;
    private DUI dui;
    private int edad;
    
    public Persona(){};  

    public Persona(Nombre nombre) {
        this.nombre = nombre;
    }
     
    public Persona(DUI dui) {
        this.dui = dui;    
    }

    public Persona(int edad) {
        this.edad = edad;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public void setNombre(Nombre nombre) {
        this.nombre = nombre;
    }

    public DUI getDui() {
        return dui;
    }

    public void setDui(DUI dui) {
        this.dui = dui;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    
}
