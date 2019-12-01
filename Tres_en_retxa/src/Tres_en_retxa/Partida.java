/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tres_en_retxa;

import java.util.Scanner;

/**
 *
 * @author Test
 */
public class Partida {

    private GUI interfaz;
    private Marcador marcador;
    private Jugador jugador[] = {null, null};
    private Taulell taulell;

    public Partida(Marcador m, Jugador j1, Jugador j2, GUI ui) {
        this.taulell = new Taulell();
       
        this.marcador = m;
        this.jugador[0] = (j1);
        this.jugador[1] = (j2);
        this.jugador[0].setTipoFicha(" X ");
        this.jugador[1].setTipoFicha(" O ");
        this.interfaz = ui;
    }

    public void iniciar() {//Inicia el juego.
        jugar();
    }

    public Jugador comprovarGuanyador() {//Comprova si s'ha fet 3 en retxa.

        for (int fila = 0; fila < 3; fila++) {
            if ((this.taulell.consultar(fila, 0).equals(this.taulell.consultar(fila, 1)))
                    && (this.taulell.consultar(fila, 1).equals(this.taulell.consultar(fila, 2)))) {
                return this.caculaGanador(this.taulell.consultar(fila, 0));
            }
        }

        for (int columna = 0; columna < 3; columna++) {
            if ((this.taulell.consultar(0, columna).equals(this.taulell.consultar(1, columna)))
                    && (this.taulell.consultar(1, columna).equals(this.taulell.consultar(2, columna)))) {
                return this.caculaGanador(this.taulell.consultar(0, columna));//=>

            }
        }

        if ((this.taulell.consultar(0, 0).equals(this.taulell.consultar(1, 1)))
                && (this.taulell.consultar(1, 1).equals(this.taulell.consultar(2, 2)))) {
            return this.caculaGanador(this.taulell.consultar(1, 1));// ========>
        }

        if ((this.taulell.consultar(0, 2).equals(this.taulell.consultar(1, 1)))
                && (this.taulell.consultar(1, 1).equals(this.taulell.consultar(2, 0)))) {
            return this.caculaGanador(this.taulell.consultar(1, 1));// ========>
        }

        return null;
    }

    public void jugar() {//Mètode principal on es juguen les partides.
        int torn;
        Posicion pos;
        Jugador guanyador;
        boolean fiPartida;
        
        guanyador = null;
        torn = 0;
        pos = null;
        fiPartida = false;
        this.interfaz.iniciar();
        while (!fiPartida) {
            
            pos = this.jugador[torn].movimiento();

            if (this.taulell.validarMovimiento(pos)) {
                // Moviment valid
                this.interfaz.ponerFicha(pos, this.jugador[torn].getTipoFicha());
                

                guanyador = comprovarGuanyador();
                fiPartida = (guanyador != null) || this.taulell.complet();
                System.out.println();
            } else {
                // Moviment NO valid
                
                fiPartida = true;
                guanyador = this.jugador[(torn + 1) % 2];
            }

            torn = (torn + 1) % 2;
        }

        // Actualitzar marcador
        if (guanyador == null) {
            this.marcador.empat();
        } else if (guanyador instanceof JugadorIA) {
            this.marcador.derrota();
        } else {
            this.marcador.victoria();
        }
        
        this.interfaz.verMarcador(this.marcador.getEmpates(), this.marcador.getVictoriaA(), this.marcador.getVictoriaB());
        //Guanya la IA.
        if(guanyador instanceof JugadorIA){//passa Strings amb els missatges de victoria o derrota a la classe UI.
            this.interfaz.warning("Has perdut la partida, guanya la IA");
        }
        //Guanya el jugador
        else if(guanyador instanceof Jugador){
           this.interfaz.warning("Has guanyat "+guanyador.nombre);
        }
        //empat
        else{
            this.interfaz.warning("Has empatat");
        }
        
    }

    private Jugador caculaGanador(String ficha) {
        if (ficha.equals(this.jugador[1].getTipoFicha())) {
            return this.jugador[1]; // ========================================>
        } else if (ficha.equals(this.jugador[0].getTipoFicha())) {
            return this.jugador[0]; // ============================================>
        }
        return null;
    }

    public void setTaulell(Taulell taulell) {
        this.taulell = taulell;
    }

    public Marcador getMarcador() {
        return marcador;
    }

    public Taulell getTaulell1() {
        return taulell;
    }

}
