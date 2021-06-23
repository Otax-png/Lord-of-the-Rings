package com;

import java.util.*;
import com.Bestia.*;
import com.Heroe.*;

public class Juego {
    private int cantidadHeroes = 0;
    private int cantidadBeasts = 0;
    private Heroes heroes[] = new Heroes[20];
    private Beasts beasts[] = new Beasts[20];

    public void jugar(){
        crearEjercitos();
        int index = 0;
        int ataque;
        do{
            System.out.println("Lucha entre:");
            System.out.println(heroes[index].ID + " " + heroes[index].nombre + " (Vida=" +heroes[index].getPuntosDeVida() + ")");
            System.out.println(beasts[index].ID + " " + beasts[index].nombre + " (Vida=" +beasts[index].getPuntosDeVida() + ")");
            ataque = heroes[index].ataque(beasts[index].type);
            beasts[index].setPuntosDeVida(ataque,heroes[index].type);
            if(beasts[index].getPuntosDeVida() <= 0){
                System.out.println(beasts[index].ID + " " + beasts[index].nombre + " ha muerto");
                moverPosisiones(index, beasts,cantidadBeasts);
                cantidadBeasts--;
            }
            else {
                ataque = beasts[index].ataque(heroes[index].type);
                heroes[index].setPuntosDeVida(ataque, beasts[index].type);
            }
            if(heroes[index].getPuntosDeVida() <= 0){
                System.out.println(heroes[index].ID + " " + heroes[index].nombre + " ha muerto");
                moverPosisiones(index, heroes, cantidadHeroes);
                cantidadHeroes--;
            }
            System.out.println("Fin de la pelea:");
            System.out.println(heroes[index].ID + " " + heroes[index].nombre + " (Vida=" +heroes[index].getPuntosDeVida() + ")");
            System.out.println(beasts[index].ID + " " + beasts[index].nombre + " (Vida=" +beasts[index].getPuntosDeVida() + ")");
            index++;
            if(index >= Math.min(cantidadBeasts, cantidadHeroes)){
                index = 0;
            }
            if(cantidadHeroes == 0){
                System.out.println("Bestias ganan");
                break;
            }
            else if(cantidadBeasts == 0){
                System.out.println("Heroes ganan");
                break;
            }
        }while(true);
    }
    public void crearEjercitos(){
        Scanner scanner = new Scanner(System.in);
        int tamaño = pedirEnteros("Ingrese el tamaño de los ejercitos");
        int i = 0;
        String nombre;
        cantidadBeasts = tamaño;
        cantidadHeroes = tamaño;
        System.out.println("Heroes");
        int valor;
        do{
            System.out.println(i+1);
            valor = pedirEnteros("1. Elfo\n2.Hobbit\n3.Humano");
            switch (valor){
                case 1:
                    System.out.println("Ingrese el nombre del Elfo");
                    nombre = scanner.nextLine();
                    Elfos elfo = new Elfos(nombre);
                    heroes[i] = elfo;
                    i++;
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del Hobbit");
                    nombre = scanner.nextLine();
                    Hobbits hobbit = new Hobbits(nombre);
                    heroes[i] = hobbit;
                    i++;
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del Humano");
                    nombre = scanner.nextLine();
                    Humanos humano = new Humanos(nombre);
                    heroes[i] = humano;
                    i++;
                    break;
            }
        }while(i < tamaño);
        i = 0;
        do{
            System.out.println(i+1);
            valor = pedirEnteros("1. Orco\n2.Trasgo");
            switch (valor){
                case 1:
                    System.out.println("Ingrese el nombre del Orco");
                    nombre = scanner.nextLine();
                    Orcos orco = new Orcos(nombre);
                    beasts[i] = orco;
                    i++;
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del Trasgo");
                    nombre = scanner.nextLine();
                    Trasgos trago = new Trasgos(nombre);
                    beasts[i] = trago;
                    i++;
                    break;
            }
        }while(i < tamaño);

    }
    public Personajes[] moverPosisiones(int index, Personajes[] personajes, int cantidadPersonajes){
        for(int x = index; x < cantidadPersonajes - 1; x++){
            personajes[x] = personajes[x+1];
        }
        return personajes;
    }

    private int pedirEnteros(String mensaje){
        Scanner scanner = new Scanner(System.in);
        int numero = 0;
        boolean validar = false;
        do{
            try{
                System.out.println(mensaje);
                numero = Integer.parseInt(scanner.nextLine());
                validar = true;
            }
            catch (Exception ex){
                System.out.println("Valor no válido");
                validar = false;
            }
        }while(!validar);
        return numero;
    }
}