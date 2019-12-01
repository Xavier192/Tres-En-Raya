/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tres_en_retxa;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Test
 */
public class JugadorIA extends Jugador {
    private String fitxaContrari;
    protected Taulell taulellIA;
    
    
    
    public JugadorIA(UI interfaz){
    super(interfaz);
    this.nombre="1";
    }
    
    public String tipoFicha (){
        
        return tipoFicha;
    }
    @Override
  public Posicion movimiento(){
    int f,c;
    Posicion p=new Posicion();
    boolean libre=false;
    for (f=0 ; f<3 ; f++){
        for (c=0 ; c<3 ; c++){
        if (this.taulellIA.consultar(f,c).equals(" - ") && !libre){
         p.setCol(c);
         p.setFila(f);
         libre=true;
        }    
        }
    }
    return p;
}

   

    public void setTaulellIA(Taulell taulellIA) {
        this.taulellIA = taulellIA;
    }

    public String getFitxaContrari() {
        return fitxaContrari;
    }

    public void setFitxaContrari(String fitxaContrari) {
        this.fitxaContrari = fitxaContrari;
    }

    
    
  
    
    
    
    
    
    
  
    
    
    
    
    
    
}
