/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tres_en_retxa;

import java.util.Random;


/**
 *
 * @author Test
 */
public class Sessio {

    private GUI interfaz;
    private Partida p1;
    private Jugador j1;
    private JugadorIA jIA;
    private Marcador m1;

    Sessio() {
        this.interfaz = new GUI();
        this.j1 = new Jugador(this.interfaz);
        this.jIA = new JugadorIA(this.interfaz);
        this.m1 = new Marcador(this.j1, this.jIA);

    }

    public boolean menuDificultat() {
        int respuesta;
        respuesta = interfaz.imprimirMenu();
        switch (respuesta) {
            case 1:

                this.jIA = new JugadorIA(this.interfaz);
                return false;

            case 2:

                this.jIA = new JugadorIA1(this.interfaz);

                return false;
            case 3:

                this.jIA = new JugadorIA2(this.interfaz);
                return false;

            case 4:

                this.jIA = new JugadorIA3(this.interfaz);
                return false;

            case 5:

                this.jIA = new JugadorIA4(this.interfaz);
                
                return false;

            case 6:
                return true; //============= Acabar ==========================>

            default:
                System.out.println("Introduce una opción válida");
                menuDificultat();
                return false;
        }
        

    }

    public void iniciarSessio() {
        boolean salir;
        this.j1.setNombre(this.interfaz.definirNombre());
        salir = this.menuDificultat();
        while (!salir) {
            
            if (sorteo() == 0) {
                this.p1 = new Partida(this.m1, this.j1, this.jIA, this.interfaz);
            } else {
                this.p1 = new Partida(this.m1, this.jIA, this.j1, this.interfaz);
            }
            this.interfaz.setTaulellUI(this.p1.getTaulell1());
            this.jIA.setTaulellIA(this.p1.getTaulell1());
            this.jIA.setFitxaContrari(this.j1.getTipoFicha());
            this.p1.jugar();
            
            salir = this.menuDificultat();
        }
    }

    public int sorteo() {
        Random random1 = new Random();

        return (random1.nextInt(2));
    }

}
