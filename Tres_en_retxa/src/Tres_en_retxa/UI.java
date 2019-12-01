package Tres_en_retxa;

import java.util.Scanner;

/**
 *
 * @author Test
 */
public class UI {
protected Taulell taulellUI;
    public UI() {
    
    }
    
    

    


    public int imprimirMenu() {
        int respuesta;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una de las siguientes opciones: ");
        System.out.println("1.Jugar contra IA nivel 0");
        System.out.println("2.Jugar contra IA nivel 1");
        System.out.println("3.Jugar contra IA nivel 2");
        System.out.println("4.Jugar contra IA nivel 3");
        System.out.println("5.Jugar contra IA nivel 4");
        System.out.println("6.Salir");
        System.out.print("Elige: ");
        respuesta = sc.nextInt();
        return respuesta;
    }
    
  

    public String definirNombre() {
        String nombre;
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce tu nombre: ");
        nombre = sc.nextLine();

        return nombre;
    }

    public void verMarcador(int empats, int victories, int derrotes) {
        System.out.println("Empates: " + empats);
        System.out.println("Victorias: " + victories);
        System.out.println("Derrotas: " + derrotes);
    }

    public Posicion movimiento() {//Mètode de la ui que retorna una posició, es cridat desde el mètode(movimiento) de Jugador.
        int f, c;
        Scanner sc = new Scanner(System.in);
        Posicion p = new Posicion();
        System.out.print("Fila-->");
        f = sc.nextInt();
        System.out.print("Columna--> ");
        c = sc.nextInt();

        p.setFila(f);
        p.setCol(c);
        
        return p;
    }

    private void mostrarTablero() {
        int j, i;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                System.out.print(this.taulellUI.caselles[i][j]);
            }
            System.out.println();
        }
        
    }
    
    public void ponerFicha(Posicion p,String tipoFitxa) {//Coloca la fitxa
        this.taulellUI.caselles[p.getFil()][p.getCol()]=tipoFitxa;
        this.mostrarTablero();
    }

    public void warning(String mensaje) {
        System.out.println(mensaje);
    }
    
    public void setTaulellUI(Taulell taulellUI) {
        this.taulellUI = taulellUI;
    }
    
    public void iniciar (){
        System.out.println("Empezando partida...");
        this.mostrarTablero();
    }

}
