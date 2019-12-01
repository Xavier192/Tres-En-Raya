/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tres_en_retxa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Test
 */
public class GUI extends UI implements ActionListener {

    private JFrame ventana;
    private JButton[][] botones;
    private JPanel panelBotones;
    private JPanel marcador;
    private JLabel labelEmpates;
    private JLabel labelVictorias;
    private JLabel labelDerrotas;
    private JLabel labelMarcador;
    private JPanel dificultat;
    private JPanel iniciar;
    private JPanel estadoPartida;
    private JLabel textoEmpates;
    private JLabel textoVictorias;
    private JLabel textoDerrotas;
    private JRadioButton[] seleccio;
    private JLabel resultadoEstado;
    private JLabel nombre;
    private int buzon;
    private Posicion buzonPos;
    private JButton botoIniciar;
    private JButton botoCancelar; 
    private JLabel ganar;
    private Font font;

    public GUI() {
        this.ventana = new JFrame("Tres en Raya");
        this.nombre = new JLabel(" ",SwingConstants.CENTER);
        construirVentana();
    }

    private JPanel panelBotones() {//cream el panell de botons (taulell).
        this.panelBotones = new JPanel();
        this.font=new Font("Arial", Font.BOLD,30);
        
        GridLayout grid = new GridLayout(5, 5);
        grid.setHgap(5);
        grid.setVgap(5);
        this.panelBotones.setLayout(grid);
        this.botones = new JButton[4][4];
        for (int i = -1; i < 4; i++) {
            for (int j = -1; j < 4; j++) {

                if (i == -1 || i ==3 || j == -1 || j == 3 ) {
                    this.panelBotones.add(new JPanel());
                } else {
                    this.botones[i][j] = new JButton();
                    this.botones[i][j].setBackground(Color.CYAN);
                    this.panelBotones.add(this.botones[i][j]);
                    this.botones[i][j].addActionListener(this);
                    this.botones[i][j].setFont(this.font);

                }
            }
        }
        return this.panelBotones;
    }

    private JPanel crearMarcador() {
        this.marcador = new JPanel();
        this.labelEmpates = new JLabel("Empates");
        this.labelVictorias = new JLabel("Victorias");
        this.labelDerrotas = new JLabel("Derrotas");
        this.labelMarcador = new JLabel("Marcador");
        this.textoVictorias = new JLabel();
        this.textoDerrotas = new JLabel();
        this.textoEmpates = new JLabel();
        GridLayout gridMarcador = new GridLayout(10, 2);
        this.marcador.setLayout(gridMarcador);

        for (int i = 0; i < 1; i++) {
            this.marcador.add(new JPanel());
        }

        this.marcador.add(new JPanel());
        this.marcador.add(this.labelMarcador);
        this.marcador.add(new JPanel());
        this.marcador.add(this.labelVictorias);
        this.marcador.add(new JPanel());
        this.marcador.add(this.textoVictorias);
        this.marcador.add(new JPanel());
        this.marcador.add(this.labelDerrotas);
        this.marcador.add(new JPanel());
        this.marcador.add(this.textoDerrotas);
        this.marcador.add(new JPanel());
        this.marcador.add(this.labelEmpates);
        this.marcador.add(new JPanel());
        this.marcador.add(this.textoEmpates);

        return this.marcador;
    }

    private JPanel dificultat() {
        this.dificultat = new JPanel();
        this.seleccio = new JRadioButton[5];
        JLabel dificultad=new JLabel("Dificultat    ");
        ButtonGroup grupo=new ButtonGroup();

        for (int i = 0; i < 5; i++) {
            this.seleccio[i] = new JRadioButton(String.valueOf(i));
        }

        GridLayout grid = new GridLayout(11, 2);
        this.dificultat.setLayout(grid);

        for (int i = 0; i < 5; i++) {
            this.dificultat.add(new JPanel());
        }
           
        for (int i = 0; i < 5; i++) {
            if(i==0){
                this.dificultat.add(dificultad);                
                this.dificultat.add(new JPanel());   
            }
            else{
                this.dificultat.add(this.seleccio[i]);
            grupo.add(this.seleccio[i]);
            this.dificultat.add(new JPanel());
            }
            
        }

        for (int i = 0; i < 3; i++) {
            this.dificultat.add(new JPanel());
        }
        

        return this.dificultat;

    }

    private JPanel crearIniciar() {
        this.iniciar = new JPanel();
        this.botoIniciar = new JButton("Iniciar");
        this.botoCancelar = new JButton("Cancelar");
        GridLayout botones = new GridLayout(1, 25);
        this.iniciar.setLayout(botones);
        this.iniciar.add(this.botoIniciar);
        this.iniciar.add(this.botoCancelar);
        this.botoIniciar.addActionListener(this);
        this.botoCancelar.addActionListener(this);
        
        return this.iniciar;
    }

    public void warning(String texto){
   
   
    this.ganar.setText(texto); 
    this.estadoPartida.add(ganar);   
    }
    private JPanel estadoPartida() {
        
       JLabel bien=new JLabel("Bienvenido", SwingConstants.CENTER);
        GridLayout grid = new GridLayout(6, 1);
        this.ganar=new JLabel("",SwingConstants.CENTER);
        this.estadoPartida = new JPanel();
        this.resultadoEstado = new JLabel("",SwingConstants.CENTER);
        this.estadoPartida.setLayout(grid);
        this.estadoPartida.add(new JPanel());
        
        this.estadoPartida.add(this.resultadoEstado);
        this.estadoPartida.add(bien);
        this.estadoPartida.add(this.nombre);
        return this.estadoPartida;
    }

    @Override
    public void verMarcador(int empats, int victories, int derrotes) {
        this.textoVictorias.setText(String.valueOf(victories));
        this.textoDerrotas.setText(String.valueOf(derrotes));
        this.textoEmpates.setText(String.valueOf(empats));
    }

    @Override
    public void iniciar() {
        int i;
        int j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                this.botones[i][j].setText("");
                this.resultadoEstado.setText("La partida ha empezado"); 
            }
        }
        
    }

    @Override
    public String definirNombre() {
        
        String nombres = JOptionPane.showInputDialog("Introduce tu nombre: ");
        this.nombre.setText(nombres);
        return nombres;
    }

    @Override
    public int imprimirMenu() {
    this.buzon=-1;
    while(this.buzon==-1){
        try{
          Thread.sleep(50);  
        }catch(InterruptedException u){
            System.out.println("Algo ha ido muy mal");
        }
    }
     return this.buzon;
    }

    @Override
    public Posicion movimiento() {
        
        this.buzonPos = null;
        while (this.buzonPos == null) {
            try {
                Thread.sleep(50);
               
            } catch (InterruptedException e) {
                System.out.println("Algo falló");
            }
        }
        return this.buzonPos;
    }

    private void construirVentana() {
        this.ventana.add(this.panelBotones(), BorderLayout.CENTER);
        this.ventana.add(this.crearMarcador(), BorderLayout.EAST);
        this.ventana.add(this.dificultat(), BorderLayout.WEST);
        this.ventana.add(this.crearIniciar(), BorderLayout.SOUTH);
        this.ventana.add(this.estadoPartida(), BorderLayout.NORTH);
        this.ventana.setBackground(Color.blue);
        this.ventana.setBounds(0, 0, 700, 600);
        this.ventana.setResizable(false);
        this.ventana.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton boton = (JButton) ae.getSource();
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.botones[i][j] == boton) {
                    this.buzonPos = new Posicion();
                    this.buzonPos.setFila(i);
                    this.buzonPos.setCol(j);
                }
            }
        }
        
        if(this.botoIniciar==boton){
           for(int i=0 ; i<5 ; i++){   
           if(this.seleccio[i].isSelected()){
               this.buzon=i+1;
           }
           } 
        }
        if(this.botoCancelar==boton){
         System.exit(0);   
        }
        
        
       
    }

    public void ponerFicha(Posicion posActual, String tipoFicha) {
        
        this.taulellUI.caselles[posActual.getFil()][posActual.getCol()] = tipoFicha;
        this.botones[posActual.getFil()][posActual.getCol()].setText(tipoFicha);
    }
    
  
}
