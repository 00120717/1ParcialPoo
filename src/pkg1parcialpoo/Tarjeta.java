/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1parcialpoo;

import java.util.Scanner;

/**
 *
 * @author Marvin Ramirez
 */
public class Tarjeta {
    private int[] codigo = new int[16];
    
    
    public Tarjeta() {}

    public int[] getCodigo() {
        return codigo;
    }

    public void setCodigo(int[] codigo) {
        this.codigo = codigo;
    }
    
    int[] verificador = new int[16];
    int dato=0,suma=0;
    Scanner leer = new Scanner (System.in);
     
    //metodo verificar tarjeta
    public boolean Verificar(){
        
        for(int i=0; i<16; i++){
            System.out.println("Ingrese digito " + (i+1) + " de la tarjeta ");
            dato= leer.nextInt();
            codigo[i]=dato;
        }
        
        for(int i=0;i<16;i++){
            if((i%2)==0){
                verificador[i]=codigo[i]*2;
                if(verificador[i]>9){
                    verificador[i]=verificador[i]-9;
                }
            }else{
                verificador[i]=codigo[i];
            }
            
        }
        for(int i=0;i<16;i++){
            suma+=verificador[i];
            
        }
        
        
        if(suma%10==0){
            
            return true;
            
        }else{
            
            return false;
            
        }
    }   

}
