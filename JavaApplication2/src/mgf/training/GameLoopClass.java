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
        public int penX = 0;
        public int penY = 0;
        public boolean moveXp = false;
        public boolean moveXn = false;
        public boolean moveYp = false;
        public boolean moveYn = false;
        
        
    @Override
    public void init() {
        
    }

    @Override
    public void draw(Graphics2D gd) {
        
        gd.setColor(Color.BLUE);
        gd.fillPolygon(new int []{(100 + penX),(200 + penX),(150 + penX),(50 + penX),(0 + penX)},new int []{(100 + penY),(200 + penY),(300 + penY),(300 + penY),(200 + penY)},5);
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
        
        
        
        if (moveXp == true && penX < 1280){
        
            penX += 500 * d;
            
        }
        if (moveXn == true && penX > 0){
        
            penX -= 500 * d;
            
        }else if(penX < 0){
        
            penX = 0;
        
        }
        if (moveYp == true){
        
            penY += 500 * d;
            
        }
        if (moveYn == true && penY > -100){
        
            penY -= 500 * d;
            
        }else if(penY < -100){
        
            penY = -100;
        
        }
        
    }

    @Override
    public void dispatchEvent(InputEvent ie) {
        
        //if (ie.isPressed()){System.out.println(ie);}
        
        if(ie.getIdType() == InputId.KEYBOARD_TYPE){
        
            int code = ie.getCode();
            
            if (Keycode.VK_RIGHT == code && ie.isPressed()){
            
                moveXp = true;
            
            }else if(Keycode.VK_RIGHT == code && ie.isReleased()){
            
                moveXp = false;
            
            }
            if (Keycode.VK_LEFT == code && ie.isPressed()){
            
                moveXn = true;
            
            }else if(Keycode.VK_LEFT == code && ie.isReleased()){
            
                moveXn = false;
            
            }
            if (Keycode.VK_UP == code && ie.isPressed()){
            
                moveYn = true;
            
            }else if(Keycode.VK_UP == code && ie.isReleased()){
            
                moveYn = false;
            
            }
            if (Keycode.VK_DOWN == code && ie.isPressed()){
            
                moveYp = true;
            
            }else if(Keycode.VK_DOWN == code && ie.isReleased()){
            
                moveYp = false;
            
            }
            
        }
        
    }
           
}
    
