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
public class JugadorIA3 extends JugadorIA2 {

    public JugadorIA3(UI interfaz) {
        super(interfaz);
    }

    @Override
    public Posicion movimiento() {
        if (this.verGanador(this.tipoFicha) != null) {
            return this.verGanador(this.tipoFicha); // =======================>
        }
        if (this.verGanador(this.getFitxaContrari()) != null) {
            return this.verGanador(this.getFitxaContrari()); //====================>
        }
        return this.arrayPrioridades();
    }

}
