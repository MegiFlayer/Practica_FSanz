/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgf.training;

import kp.jngg.Display;
import kp.jngg.DisplayMode;
import kp.jngg.GameLoop;
import kp.jngg.input.InputEvent;
import kp.jngg.input.InputListener;
import kp.jngg.input.Keyboard;
import java.util.Scanner;

/**
 *
 * @author ferna
 */
public class Main {
    
    public static void main (String [] args){
    
        Display ventana = Display.create("Práctica", DisplayMode.getDisplayMode(1280, 720));
    
        GameLoopClass gl = new GameLoopClass();
        
        ventana.addInput(new Keyboard());
        ventana.addInputListener(gl);
        
        ventana.setGameLoop(gl);
        ventana.start();
        
        Scanner in = new Scanner(System.in);
        
        Procesos.mover();
        
    }
    
    
    
}
