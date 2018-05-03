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
public class Piso {
    private char idPiso;
    private boolean estado;

    
    public Piso(char idPiso, boolean estado) {
        this.idPiso = idPiso;
        this.estado = estado;
    }
    
    public char getIdPiso() {
        return idPiso;
    }

    public void setIdPiso(char idPiso) {
        this.idPiso = idPiso;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
