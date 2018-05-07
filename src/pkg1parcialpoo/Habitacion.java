/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1parcialpoo;

/**
 *
 * @author Oscar Lovato
 */
public class Habitacion {
    public NumCorrelativo idHabitacion;
    public static Precio precio;
    public static double precioInicial = 200;

    public Habitacion() {
        Precio nuevoPrecio = new Precio();
        this.precio=nuevoPrecio;
        nuevoPrecio.setPrecioBase(precioInicial);
    }
    public NumCorrelativo getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(NumCorrelativo idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Precio getPrecio() {
        return precio;
    }

    public void setPrecio(Precio precio) {
        this.precio = precio;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    NumCorrelativo verifica=new NumCorrelativo();
    public boolean verfiEstado(){
        if(verifica.verificarEstado()){
            return true;
        }
        return false;
    }
}
