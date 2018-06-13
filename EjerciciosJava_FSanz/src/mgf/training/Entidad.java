/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgf.training;

import java.awt.Color;
import java.awt.Graphics2D;
import kp.jngg.font.Font;
import kp.jngg.input.InputEvent;
import kp.jngg.input.InputId;
import kp.jngg.input.Keycode;
import kp.jngg.math.Vector2;
import kp.jngg.sprite.Sprite;

/**
 *
 * @author ferna
 */
public class Entidad {

    /**
     * Funciones recomendadas: draw: Para dibujar update: Actualizar valores
     * dispatchEvents: capturar eventos de inputs
     */
    private static final double X_SPEED = 10;
    private static final double GRAVITY = 0.1;
    private static final double FLOOR = 720;
    private static final double FRICTION = 0.25;
    
    private static final Font DEBUG_FONT = Font.getNativeFont("arial", 12, Color.GREEN);

    private final Vector2 position;
    private final Vector2 size;
    private final Vector2 speed;
    private Sprite sprite;
    private boolean jumpAble;

    private int moveX;
    private int moveY;

    public Entidad() {
        position = new Vector2();
        size = new Vector2(50, 50);
        speed = new Vector2();
        sprite = null;
    }

    public void setPosition(double x, double y) {
        position.x = x;
        position.y = y;
    }

    public void setSpeed(double x, double y) {
        speed.x = x;
        speed.y = y;
    }

    public Vector2 getSpeed() {
        return speed.copy();
    }

    public void setSize(double width, double height) {
        if (width < 1) {
            width = 1;
        }
        if (height < 1) {
            height = 1;
        }
        size.set(width, height);
    }

    public void setSprite(Sprite s) {
        sprite = s;
    }

    public void draw(Graphics2D g) {
        if (sprite != null) {
            sprite.draw(g, position.x, position.y, size.x, size.y);
        }
        drawSpecs(g);
    }

    private void drawSpecs(Graphics2D g) {
        DEBUG_FONT.print(g, "Position = " + position.scale(2), 12, 12);
        DEBUG_FONT.print(g, "Speed = " + speed.scale(2), 12, 24);
    }

    public void update(double delta) {

        speed.y += GRAVITY;

        if (jumpAble && moveY < 0) {
            speed.y = -5;
            jumpAble = false;
        }
        if (jumpAble && moveX != 0) {
            speed.x = X_SPEED * moveX;
        } else {
            if (speed.x > 0) {
                speed.x -= FRICTION * (jumpAble ? 1 : 0.25);
                if (speed.x < 0) {
                    speed.x = 0;
                }
            } else if (speed.x < 0) {
                speed.x += FRICTION * (jumpAble ? 1 : 0.25);
                if (speed.x > 0) {
                    speed.x = 0;
                }
            }
        }
        speed.ensureRangeLocal(10, 10);

        position.add(speed);

        if (position.y + size.y >= FLOOR) {
            position.y = FLOOR - size.y;
            jumpAble = true;
        } else {
            jumpAble = false;
        }

    }

    public void dispatch(InputEvent event) {
        if (event.getIdType() == InputId.KEYBOARD_TYPE) {
            int code = event.getCode();
            if (code == Keycode.VK_UP) {
                moveY += event.isPressed() ? -1 : 1;
            }

            if (code == Keycode.VK_DOWN && position.y <= 620) {
                moveY += event.isPressed() ? 1 : -1;
            }
            if (code == Keycode.VK_LEFT) {
                moveX += event.isPressed() ? -1 : 1;
            }
            if (code == Keycode.VK_RIGHT) {
                moveX += event.isPressed() ? 1 : -1;
            }
        }
    }
}
