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
public class JugadorIA2 extends JugadorIA1 {

  

    public JugadorIA2(UI interficie) {
        super(interficie);
        
    }

    @Override
    public Posicion movimiento() {
        if (this.verGanador(this.tipoFicha) != null) {
            return this.verGanador(this.tipoFicha);
        }
        return this.arrayPrioridades();
    }

    

    public Posicion horizontales(String ficha) {
        int contador = 0;
        int contadorVacias = 0;
        int fila, col;
        Posicion pos = new Posicion();
        for (fila = 0; fila < 3; fila++) {
            contador = 0;
            contadorVacias = 0;
            for (col = 0; col < 3; col++) {
                if (this.taulellIA.consultar(fila, col).equals(ficha)) {
                    contador++;
                } else if (this.taulellIA.consultar(fila, col).equals(" - ")) {
                    contadorVacias++;
                    pos.setFila(fila);
                    pos.setCol(col);
                }
            }
            if (contador == 2 && contadorVacias == 1) {
                return pos;
            }
        }
        return null;
    }

    public Posicion vertical(String ficha) {
        int contador = 0;
        int contadorVacias = 0;
        int fila;
        int col;
        Posicion pos = new Posicion();
        for (col = 0; col < 3; col++) {
            contador = 0;
            contadorVacias = 0;
            for (fila = 0; fila < 3; fila++) {
                if (this.taulellIA.consultar(fila, col).equals(ficha)) {
                    contador++;
                } else if (this.taulellIA.consultar(fila, col).equals(" - ")) {
                    contadorVacias++;
                    pos.setFila(fila);
                    pos.setCol(col);
                }
            }
            if (contador == 2 && contadorVacias == 1) {
                return pos;
            }

        }
        return null;
    }

    public Posicion diagonal(String ficha) {
        int contador = 0;
        int contadorVacias = 0;
        Posicion pos = new Posicion();
        int f_c;
        for (f_c = 0; f_c < 3; f_c++) {
            if (this.taulellIA.consultar(f_c, f_c).equals(ficha)) {
                contador++;
            }
            if (this.taulellIA.consultar(f_c, f_c).equals(" - ")) {
                contadorVacias++;
                pos.setFila(f_c);
                pos.setCol(f_c);

            }
            if (contador == 2 && contadorVacias == 1) {
                return pos;
            }
        }
        return null;
    }

    public Posicion otraDiagonal(String ficha) {
        int contador = 0;
        int contadorVacias = 0;
        int col, fila;
        Posicion pos = new Posicion();
        for (fila = 0, col = 2; fila < 3; fila++, col--) {
            if (this.taulellIA.consultar(fila, col).equals(ficha)) {
                contador++;
            }
            if (this.taulellIA.consultar(fila, col).equals(" - ")) {
                contadorVacias++;
                pos.setCol(col);
                pos.setFila(fila);
            }
            if (contador == 2 && contadorVacias == 1) {
                return pos;
            }

        }
        return null;
    }

    public Posicion verGanador(String ficha) {
        if (horizontales(ficha) != null) {
            return horizontales(ficha);
        }
        if (vertical(ficha) != null) {
            return vertical(ficha);
        }
        if (diagonal(ficha) != null) {
            return diagonal(ficha);
        }
        if (otraDiagonal(ficha) != null) {
            return otraDiagonal(ficha);
        }
        return null;
    }

    
    
    
}
