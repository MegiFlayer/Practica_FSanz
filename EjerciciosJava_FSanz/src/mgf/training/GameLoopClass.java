/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgf.training;


import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import kp.jngg.GameLoop;
import kp.jngg.math.Vector2;
import kp.jngg.input.InputEvent;
import kp.jngg.input.InputId;
import kp.jngg.input.InputListener;
import kp.jngg.input.Keycode;
import kp.jngg.sprite.AnimatedSprite;
import kp.jngg.sprite.Sprite;
import kp.jngg.sprite.SpriteLoader;
/**
 *
 * @author ferna
 */
public class GameLoopClass implements GameLoop, InputListener{
    
    private SpriteLoader sprites;
    private Sprite sprite1;
    private AnimatedSprite sprite2;
    private AnimatedSprite sprite3;
    private AnimatedSprite sprite4;
    
    
    private Entidad ent;
    
        public double pX;
        public double pY;
        public double speed = 4;
        public double incr;
        public int penX = 0;
        public int penY = 100;
        public boolean moveXp = false;
        public boolean moveXn = false;
        public boolean moveYp = false;
        public boolean moveYn = false;
        
        
    @Override
    public void init() {
        sprites = new SpriteLoader(new File("sprites"));
        try {
            sprites.loadStaticSprite("sprite_mario", "Mario.png");
            
            sprite1 = sprites.getSprite("sprite_mario");
            sprite2 = (AnimatedSprite) sprites.loadAnimatedSprite("pj_pkm", "normal.png", 60, 0, 20, 20, 4).buildSprite();
            sprite3 = (AnimatedSprite) sprites.loadAnimatedSprite("pj_pkm1", "normal.png", 120, 0, 20, 20, 1).buildSprite();
            sprite4 = (AnimatedSprite) sprites.loadAnimatedSprite("pj_pkm2", "normal.png", 80, 0, 20, 20, 1).buildSprite();
            sprite2.setLoopMode();
            sprite2.setSpeed(2);
            
            sprite2.start();
        }
        catch(IOException ex) {
            ex.printStackTrace(System.err);
        }
        
        ent = new Entidad();
        ent.setPosition(0, 620);
        ent.setSize(100, 100);
        ent.setSprite(sprite2, sprite3, sprite4);
    }

    @Override
    public void draw(Graphics2D gd) {
        
        //gd.setColor(Color.BLUE);
        //gd.fillPolygon(new int []{(100 + penX),(200 + penX),(150 + penX),(50 + penX),(0 + penX)},new int []{(0 + penY),(100 + penY),(200 + penY),(200 + penY),(100 + penY)},5);
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
        
        ent.draw(gd);
        
    }

    @Override
    public void update(double d) {
        
        ent.update(d);
        
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
            
        }
        
        if(penX < 0){
        
            penX = 0;
        
        }
        if (moveYp == true){
        
            penY += 500 * d;
            
        }
        if (moveYn == true && penY > 0){
        
            penY -= 500 * d;
            
        }else if(penY < 0){
        
            penY = 0;
        
        }
        
    }

    @Override
    public void dispatchEvent(InputEvent ie) {
        
        ent.dispatch(ie);
        //if (ie.isPressed()){System.out.println(ie);}
        
        if(ie.getIdType() == InputId.KEYBOARD_TYPE){
        
            int code = ie.getCode();
            
            if(code == Keycode.VK_P) {
                Vector2 s = ent.getSpeed();
                s.multiply(1.5);
                ent.setSpeed(s.x, s.y);
            }
            
            if(code == Keycode.VK_O) {
                Vector2 s = ent.getSpeed();
                s.multiply(0.75);
                ent.setSpeed(s.x, s.y);
            }
            
            
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
    
