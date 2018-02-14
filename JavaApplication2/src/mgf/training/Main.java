/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgf.training;

import kp.jngg.Display;
import kp.jngg.DisplayMode;
import kp.jngg.GameLoop;

/**
 *
 * @author ferna
 */
public class Main {
    
    public static void main (String [] args){
    
        Display ventana = Display.create("Práctica", DisplayMode.getDisplayMode(1280, 720));
    
        ventana.setGameLoop(new GameLoopClass());
        ventana.start();
        
    }
    
    
    
}
