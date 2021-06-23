package com.Heroe;

import com.Personajes;

public class Heroes extends Personajes {
    public final String ID = "HEROES";
    public Heroes(String nombre){
        super(nombre);
    }

    @Override
    public void setPuntosDeVida(int ataqueEnemigo, String enemyType) {
        if(enemyType.equals("Orco")){
            int armadura = (int)(getResistenciaArmadura()* 0.90);
            if(ataqueEnemigo > armadura){
                setPuntosDeVida(ataqueEnemigo - armadura);
            }
        }
        else{
            super.setPuntosDeVida(ataqueEnemigo, enemyType);
        }
    }
}
