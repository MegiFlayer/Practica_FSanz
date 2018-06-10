/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgf.training;

import java.awt.Graphics2D;
import kp.jngg.geom.Vector2;
import kp.jngg.input.InputEvent;
import kp.jngg.input.InputId;
import kp.jngg.input.Keycode;
import kp.jngg.sprite.Sprite;

/**
 *
 * @author ferna
 */
public class Entidad
{
    /**
     * Funciones recomendadas:
     * draw: Para dibujar
     * update: Actualizar valores
     * dispatchEvents: capturar eventos de inputs
     */
    
    private Vector2 position;
    private Vector2 size;
    private Vector2 speed;
    private Sprite sprite;
    private boolean jumpAble;
    
    private int moveX;
    private int moveY;
    
    public Entidad()
    {
        position = new Vector2();
        size = new Vector2(50, 50);
        speed = new Vector2(10, 20);
        sprite = null;
    }
    
    public void setPosition(double x, double y)
    {
        position.x = x;
        position.y = y;
    }
    
    public void setSpeed(double x, double y)
    {
        speed.x = x;
        speed.y = y;
    }
    
    public Vector2 getSpeed() { return speed.copy(); }
    
    public void setSize(double width, double height)
    {
        if(width < 1)
            width = 1;
        if(height < 1)
            height = 1;
        size.set(width, height);
    }
    
    public void setSprite(Sprite s)
    {
        sprite = s;
    }
    
    public void draw(Graphics2D g)
    {
        if(sprite != null)
            sprite.draw(g, position.x, position.y, size.x, size.y);
    }
    
    public void update(double delta)
    {
        if (jumpAble == true){position.add(speed.x * moveX, speed.y * moveY);}else if (jumpAble == false){position.add(speed.x * moveX, 0);}
        if (position.y < 620){
            
            position.add(0, 7.5);
        
        }else if(position.y >= 620){
        
            position.y = 620;
            jumpAble = true;
        
        }
        if(position.y <= 420){
            jumpAble = false;
            position.y = 420;
            }
        
    }
    
    public void dispatch(InputEvent event)
    {
        if(event.getIdType() == InputId.KEYBOARD_TYPE)
        {
            int code = event.getCode();
            if(code == Keycode.VK_UP && jumpAble == true) {
                moveY += event.isPressed() ? -1 : 1;
            }
            if(code == Keycode.VK_DOWN && position.y <= 620) {
                moveY += event.isPressed() ? 1 : -1;
            }
            if(code == Keycode.VK_LEFT) {
                moveX += event.isPressed() ? -1 : 1;
            }
            if(code == Keycode.VK_RIGHT) {
                moveX += event.isPressed() ? 1 : -1;
            }
        }
    }
}
