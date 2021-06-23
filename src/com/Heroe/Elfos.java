package com.Heroe;


public class Elfos extends Heroes {
    public Elfos(String nombre){
        super(nombre);
        setValores(250, 55, "Elfo");
    }

    @Override
    public int ataque(String enemyType){
        int ataque = super.ataque(enemyType);
        if(enemyType.equals("Orco")){
            ataque += 10;
        }
        return ataque;
    }
}