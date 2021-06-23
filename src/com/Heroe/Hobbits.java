package com.Heroe;

public class Hobbits extends Heroes {
    public Hobbits(String nombre){
        super(nombre);
        setValores(200, 45, "Hobbit");
    }
    @Override
    public int ataque(String enemyType){
        int ataque = super.ataque(enemyType);
        if(enemyType.equals("Trasgo")){
            ataque -= 5;
        }
        return ataque;
    }
}
