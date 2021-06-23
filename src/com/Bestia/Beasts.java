package com.Bestia;


import com.Personajes;

public class Beasts extends Personajes {
    public final String ID = "BEASTS";
    public Beasts(String nombre){
        super(nombre);
    }

    @Override
    public int ataque(String enemyType){
        int ataque = dadosAleatorios(90, 0);
        return ataque;
    }
}
