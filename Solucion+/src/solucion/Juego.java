/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solucion;

import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class Juego {
    private ArrayList<String> Obejtos;
    private Player jugador1;
    private Player jugador2;
    private int roundPlayed=0;
    private String ganar="gano";
    private String empate="empate";
    private String perdio="perdio";
    
    public Juego(Player jugador1,Player jugador2){
        this.jugador1=jugador1;
        this.jugador2=jugador2;
    }
    
    public void jugar(int numRondas){
        inciarArray();
        while(this.roundPlayed<numRondas){
            System.out.println("Ronda # "+this.roundPlayed);
            playerChoice();
            ganador();
            this.roundPlayed++;
            System.out.println("");
        }
        eligirGandorFinal();
    }
    private void inciarArray(){
        this.Obejtos=new ArrayList<>();
        this.Obejtos.add("paper");
        this.Obejtos.add("rock");
        this.Obejtos.add("scissors");
    }
    private void playerChoice(){
        int n=(int)(Math.random()*3);
        this.jugador1.setObjeto(this.Obejtos.get(n));
        System.out.println("El jugador 1 saco "+this.jugador1.getObjeto());
        n=(int)(Math.random()*3);
        this.jugador2.setObjeto(this.Obejtos.get(n));
        System.out.println("El jugador 2 saco "+this.jugador2.getObjeto());
    }
 
    private void ganador(){
        String Obj1=this.jugador1.getObjeto();
        String con=ganoOPerdioJugador1(Obj1);
        daPuntos(con);
        
    }
    
    private void eligirGandorFinal(){
        if(this.jugador1.getWins()<this.jugador2.getWins()){
            System.out.println("El ganador final es el jugador2");
        }else if(this.jugador1.getWins()>this.jugador2.getWins()){
            System.out.println("El ganador final es el jugador1");
        }else
            System.out.println("Al final quedaron Empate");
    }
    //Se da puntos con respecto al jugador 1
    private void daPuntos(String resul){
        if(resul.equalsIgnoreCase(this.ganar)){
            this.jugador1.aumentarWins();
            System.out.println("El jugador que gano es jugador 1");
        }else if(resul.equalsIgnoreCase(this.perdio)){
            this.jugador2.aumentarWins();
            System.out.println("El jugador que gano es jugador 2");
        }else{
            System.out.println("Quedaron empates");
        }
            
    }
    
    //Se ve el ganador con respecto al jugador1
    private String ganoOPerdioJugador1(String ob){
        String Obj2=this.jugador2.getObjeto();
        switch (ob){
            case "paper":
                return resultadoConPaper(Obj2);
            case "rock":
                return resultadoConRock(Obj2);
            default:
                return resultadoConScissors(Obj2);
        }
    }
    private String resultadoConPaper(String com){
        if(this.Obejtos.get(0).equalsIgnoreCase(com)){
            return this.empate;
        }else if(com.equalsIgnoreCase("rock")){
            return this.ganar;
        }else
            return this.perdio;
    }
    
    private String resultadoConRock(String com){
        if(this.Obejtos.get(1).equalsIgnoreCase(com)){
            return this.empate;
        }else if(com.equalsIgnoreCase("scissors")){
            return this.ganar;
        }else
            return this.perdio;
    }
    
    private String resultadoConScissors(String com){
        if(this.Obejtos.get(2).equalsIgnoreCase(com)){
            return this.empate;
        }else if(com.equalsIgnoreCase("paper")){
            return this.ganar;
        }else
            return this.perdio;
    }
    
}
