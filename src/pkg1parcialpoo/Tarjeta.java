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

    public Tarjeta(int[] codigo) {
        this.codigo = codigo;
    }

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
    public void Verificar(){
        System.out.println("Inserte tarjeta");
        
        for(int i=0; i<16; i++){
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
            System.out.println("Tarjeta valida");
        }else{
            System.out.println("Tarjeta no valida");
        }
    }   
    
}
