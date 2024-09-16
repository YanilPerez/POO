package pe.edu.upeu.calcfx.modelo;

import java.awt.Color;

import javax.swing.*;

public class Tablero extends JPanel {
    private int anchoCI;
    private int altutaCI;
    private int margen;
    private Color colorTablero;
    private Color colorCI;

    private Jugador jugador1;
    private Jugador jugador2;

    public Tablero(){
        init();
    }
    private void  init(){
        anchoCI=80;
        altutaCI=80;
        colorCI=Color.BLUE;
        colorTablero=Color.RED;
        margen=6;
        jugador1=new Jugador();
        jugador2=new Jugador();
    }
    public void crearTablero(){
        setLayout(null); //modificartablero
        setSize(anchoCI*3+margen*4,altutaCI*3+margen*4);
        setBackground(colorTablero);
    }
    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }
}
