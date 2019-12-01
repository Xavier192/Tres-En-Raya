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
public class JugadorIA4 extends JugadorIA3 {
    
    public JugadorIA4 (UI interfaz){
        super(interfaz);
    }
  @Override
public Posicion arrayPrioridades(){
    int prioridades[][]={{0,0,0},{0,0,0},{0,0,0}};
    this.prioridad(prioridades);
    return this.movimientoEstrategico(prioridades);
    
}
public void prioridad (int prioridades[][]){
    int col;
    int fila;
    for(fila=0 ; fila<3 ; fila++){
        for (col=0 ; col<3 ; col++){
            
       prioridades[fila][col]+=calcularFila(fila);
       prioridades[fila][col]+=calcularColumna(col);
       prioridades[fila][col]+=calcularDiagonal1(fila,col);
       prioridades[fila][col]+=calcularDiagonal2(fila,col);
            
            
       
        }
    }
    
}


public int calcularFila(int fila){
    int col;
    
    for(col=0 ; col<3 ; col++){
        if(this.taulellIA.consultar(fila,col).equals(this.getFitxaContrari())){
            return 0;
        }
    }
    return 1;
}
public int calcularColumna(int col){
    int fila;
    for(fila=0 ; fila<3 ; fila++){
        if(this.taulellIA.consultar(fila,col).equals(this.getFitxaContrari())){
         return 0;   
        }
    }
    return 1;
}

public int calcularDiagonal1 (int fila, int col){
    int fila_col;
   if(fila!=col){
       return 0;
   } 
   
   for (fila_col=0 ; fila_col<3 ; fila_col++){
       if(this.taulellIA.consultar(fila_col,fila_col).equals(this.getFitxaContrari())){
        return 0;   
       }
   }
   return 1;
}

public int calcularDiagonal2 (int fila,int col){
    int s_fila;
    int s_col;
  if(!((fila==0 && col==2) || (fila==1 && col==1) || (fila==2 && col==0))){
      return 0;
  }
for (s_fila=0,s_col=2 ; s_fila<3 ; s_fila++ ,s_col-- ){
    if(this.taulellIA.consultar(s_fila,s_col).equals(this.getFitxaContrari())){
        return 0;
    }
}
return 1;
}

}
