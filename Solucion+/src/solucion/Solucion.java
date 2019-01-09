/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solucion;

/**
 *
 * @author Administrador
 */
public class Solucion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player jugador1=new Player();
        Player jugador2=new Player();
        Juego juego=new Juego(jugador1,jugador2);
        //Se selecciona las rondas a jugar
        juego.jugar(100);
        
    }
    
}
