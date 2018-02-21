/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgf.training;


import java.awt.Color;
import java.awt.Graphics2D;
import kp.jngg.GameLoop;
import kp.jngg.input.InputEvent;
import kp.jngg.input.InputId;
import kp.jngg.input.InputListener;
import kp.jngg.input.Keycode;
/**
 *
 * @author ferna
 */
public class GameLoopClass implements GameLoop, InputListener{
    
        public double pX;
        public double pY;
        public double speed = 4;
        public double incr;
        
    @Override
    public void init() {
        
    }

    @Override
    public void draw(Graphics2D gd) {
        
        gd.setColor(Color.BLUE);
        gd.fillPolygon(new int []{100,200,150,50,0},new int []{100,200,300,300,200},5);
        gd.setColor(Color.orange);
        gd.fillRect(100,100,100,100);
        gd.setColor(Color.white);
        gd.fillOval(110, 105, 30, 40);
        gd.fillOval(160, 105, 30, 40);
        gd.setColor(Color.red);
        gd.drawLine(120,175,180,175);
        gd.setColor(Color.green);
        gd.fillOval((int) (120 + pX),(int) (120 + pY),10,10);
        gd.fillOval((int) (170 + pX),(int) (120 + pY),10,10);
        
    }

    @Override
    public void update(double d) {
        
        incr += d*speed;
        
        /*if (Math.abs(pX) > 10){
            
            speed *= -1;
                   
        }*/
        
        pX = Math.cos(incr)*10;
        pY = Math.sin(incr)*15;
        
    }

    @Override
    public void dispatchEvent(InputEvent ie) {
        
        if (ie.isPressed()){System.out.println(ie);}
        
        if(ie.getIdType() == InputId.KEYBOARD_TYPE){
        
            int code = ie.getCode();
            
            if (Keycode.VK_N == code && ie.isPressed()){
            
                System.out.println("N");
            
            }
            
        }
        
    }
           
}
    
