package game;

import java.awt.*;
import java.lang.Math.*;
import java.awt.event.KeyEvent;

import static utilities.GDV5.KeysPressed;

public class Paddle extends Rectangle {
    private Color color;
    private int dX = 5, dY = 5;
    private int direction = 0;

    public Paddle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void draw(Graphics2D pb) {
        pb.setColor(color);
        pb.draw(this);
        pb.fill(this);
    }

    public void ai(Ball ball) {
        if ((ball.getxFlag() < 0) && (this.y > 400) && (ball.x > 600)) {
            if ((int) (Math.random() * (25)) == 1) this.y += 25;
            else this.y -= dY;
        } else if ((ball.getxFlag() < 0) && (this.y < 400) && (ball.x > 600)) {
            if ((int) (Math.random() * (25)) == 1) this.y -= 25;
            else this.y += dY;
        } else if ((ball.getxFlag() >= 0) && (ball.y > this.y) && (ball.x > 600)) {
            if ((int) (Math.random() * (25)) == 1) this.y -= 25;
            else this.y += dY;
        } else if ((ball.getxFlag() >= 0) && (ball.y < this.y) && (ball.x > 600)) {
            if ((int) (Math.random() * (25)) == 1) this.y += 25;
            else this.y -= dY;
        }
    }

    public void speedUp() {
        dX += 1;
        dY += 1;
    }

    public int getDirection() {
        return direction;
    }

    public void arrowkeysMove() {
        direction = 0;
        if (KeysPressed[KeyEvent.VK_UP] && y > 0) {
            y -= dY;
            direction = -1;
        } else if (KeysPressed[KeyEvent.VK_DOWN] && y < 720) {
            y += dY;
            direction = 1;
        }
    }

    public void wasdMove() {
        direction = 0;
        if (KeysPressed[KeyEvent.VK_W] && y > 0) {
            y -= dY;
            direction = -1;
        } else if (KeysPressed[KeyEvent.VK_S] && y < 720) {
            y += dY;
            direction = 1;
        }
    }
}