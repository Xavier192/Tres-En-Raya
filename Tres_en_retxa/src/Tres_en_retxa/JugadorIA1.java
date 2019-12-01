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
public class JugadorIA1 extends JugadorIA {

 public JugadorIA1(UI interfaz){
     super (interfaz);
 }   
    
    
    
    
    
    @Override
public Posicion movimiento(){
    
    return this.arrayPrioridades();
}



public Posicion arrayPrioridades(){
 int prioridad [][]={{8,2,7},{4,9,3},{5,1,6}};
 return movimientoEstrategico(prioridad);
    
}
    public Posicion movimientoEstrategico(int prioridad[][]) {
        Posicion pos = new Posicion();
        int i, j;
        int weight;
        weight = 0;

        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if ((this.taulellIA.consultar(i, j).equals(" - ")) && prioridad[i][j] >= weight) {
                    weight = prioridad[i][j];
                    pos.setFila(i);
                    pos.setCol(j);
                  
                    
                }
            }
        }

        return pos;
    }
}
