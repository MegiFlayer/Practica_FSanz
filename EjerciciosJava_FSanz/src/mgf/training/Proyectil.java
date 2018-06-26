/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgf.training;

import java.awt.Graphics2D;
import kp.jngg.math.Vector2;
import kp.jngg.sprite.Sprite;

/**
 *
 * @author ferna
 */
public class Proyectil {
    
    private final Vector2 position;
    private final Vector2 size;
    private final Vector2 speed;
    private boolean shootAble;
    private Sprite sprite;
    
    public Proyectil() {
        position = new Vector2();
        size = new Vector2(50, 50);
        speed = new Vector2();
        sprite = null;
    }
    
    public void setPosition(double x, double y) {
        if(x < 0){
            x = 0;
        }
        if(y < 0){
            y = 0;
        }
        position.set(x, y);
    }
    
    public void setSize(double width, double height){
        if(width < 1){
            width = 1;
        }
        if (height < 1){
            height = 1;
        }
        size.set(width, height);
    }
    
    public void setSprite(Sprite s1){
        sprite = s1;
    }
    
    public void draw(Graphics2D g) {
        if (sprite != null) {
            sprite.draw(g, position.x, position.y, size.x, size.y);
        }
    }

    public void update(double delta) {
        sprite.update(delta);
    }
    
}