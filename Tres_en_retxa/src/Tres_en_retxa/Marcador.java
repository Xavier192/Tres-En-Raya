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
public class Marcador {

    private int empates;
    private int victoriaA, victoriaB;
    private Jugador ja;
    private JugadorIA jIA;

    public Marcador(Jugador j1, JugadorIA j2) {
        this.ja = j1;
        this.jIA = j2;
    }

    public UI mostrar() {//Mostra el marcador
        UI interficie=new UI();
        interficie.verMarcador(empates, victoriaA,victoriaB);
        return interficie;
    }

   
    public void victoria (){
        victoriaA++;  
    }
    
    public void derrota (){
        victoriaB++;
    }
    
    public void empat(){
        this.empates++;
    }

    public int getEmpates() {
        return empates;
    }

    public int getVictoriaA() {
        return victoriaA;
    }

    public int getVictoriaB() {
        return victoriaB;
    }

}
