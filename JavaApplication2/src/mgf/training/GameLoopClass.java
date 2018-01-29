/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgf.training;


import java.awt.Color;
import java.awt.Graphics2D;
import kp.jngg.GameLoop;
/**
 *
 * @author ferna
 */
public class GameLoopClass implements GameLoop{
    
        private double pX;

    @Override
    public void init() {
        
    }

    @Override
    public void draw(Graphics2D gd) {
        
        gd.setColor(Color.CYAN);
        gd.drawString("Me cago en todo", 100, 10);
        
    }

    @Override
    public void update(double d) {
        
    }
        
        
    }
    
