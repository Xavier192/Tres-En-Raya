/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tres_en_retxa;

/**
 *
 * @author Test
 */
public class Taulell {
UI ui=new UI();
    public String[][] caselles = new String[3][3];

    public Taulell() {
        int fil, col;
        
        
        
        
        
        for (fil = 0; fil < caselles.length ; fil++) {
            for (col = 0; col < caselles.length; col++) {
                    
                    this.caselles[fil][col]=" - ";
               
            }
            
    }
    }

    public boolean validarMovimiento(Posicion p) {//Valida si una posicio esta disponible
    
    if(p.getCol()>2 || p.getCol()<0  || p.getFil()<0 || p.getFil()>2){//valida si el valor introducido es válido.
        return false;
    }
    else{
        return this.caselles[p.getFil()][p.getCol()].equals(" - ");//valida si la posicion esta ocupada por alguna ficha.
    }
    }

    
    

    public String[][] getCaselles() {
        return caselles;
    }

    public String consultar(Posicion p) {
        
        return this.caselles[p.getFil()][p.getCol()];
    }
     public String consultar(int f, int c) {
        
        return this.caselles[f][c];
    }

    public boolean complet() {
        int contar, fil, col;
        contar = 0;
        for (fil = 0; fil < 3; fil++) {
            for (col = 0; col < 3; col++) {
                if (this.caselles[fil][col].equals(" - ")) {
                    contar++;
                }
            }

        }
        return (contar == 0);
    }
    
  


}
