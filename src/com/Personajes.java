package com;

public class Personajes {
    public String nombre;
    private int puntosDeVida;
    private int resistenciaArmadura;
    public String type;

    public Personajes(String nombre){
        this.nombre = nombre;
    }


    public int ataque(String enemyType){
        int dado1 = dadosAleatorios(100, 0);
        int dado2 = dadosAleatorios(100, 0);
        int ataque = Math.max(dado1, dado2);
        return ataque;
    }

    public int getPuntosDeVida() {
        return puntosDeVida;
    }

    public void setValores(int puntosDeVida, int resistenciaArmadura, String type) {
        this.puntosDeVida = puntosDeVida;
        this.resistenciaArmadura = resistenciaArmadura;
        this.type = type;
    }


    public void setPuntosDeVida(int ataqueEnemigo, String enemyType) {
        if(ataqueEnemigo > resistenciaArmadura) {
            this.puntosDeVida = puntosDeVida - (ataqueEnemigo - resistenciaArmadura);
        }
    }

    public void setPuntosDeVida(int ataqueEnemigo) {
        this.puntosDeVida -= ataqueEnemigo;
    }

    public int getResistenciaArmadura(){
        return resistenciaArmadura;
    }

    public int dadosAleatorios(int max, int min){
        int aleatorio = (int)(Math.floor(Math.random()*(max - min + 1) + min));
        return aleatorio;
    }
}
