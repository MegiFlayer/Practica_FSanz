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
    
        public double pX;
        public double pXhlp;
        public int ciclos = 0;
        
    @Override
    public void init() {
        
    }

    @Override
    public void draw(Graphics2D gd) {
        
        gd.setColor(Color.orange);
        gd.fillRect(100,100,100,100);
        gd.setColor(Color.white);
        gd.fillOval(110, 105, 30, 40);
        gd.fillOval(160, 105, 30, 40);
        gd.setColor(Color.red);
        gd.drawLine(120,175,180,175);
        gd.setColor(Color.green);
        gd.fillOval((int) (120 + pX - pXhlp),120,10,10);
        gd.fillOval((int) (170 + pX - pXhlp),120,10,10);

    }

    @Override
    public void update(double d) {
        
        if (pX < 10 ){
        
        pX += 5*d;
            
        }else{
        
        if (pXhlp < 20){
            
            pXhlp =+ 5*d;
            ciclos =+ 1;

            System.out.print(ciclos);
            
        }else{
            
            pX = 0;
            
        }
        
        }
        
        
        
        
        
        
        
        
        
        
        
        
    }
        
        
    }
    
