/*kii
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
public class Jugador {
    protected String nombre;
    protected String tipoFicha;
    private UI ui;
   
    public Jugador(UI interfaz){
        
        this.ui=interfaz;
    }
    
    public Posicion movimiento(){
    
    return this.ui.movimiento();
    }

    public String getTipoFicha() {
        
        return tipoFicha;
    }

    public void setTipoFicha(String tipoFicha) {
        this.tipoFicha = tipoFicha;
    }
    
    
  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
    
}
