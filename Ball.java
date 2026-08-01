package game;
import javax.sound.sampled.SourceDataLine;
import java.awt.*;
import java.awt.event.KeyEvent;

import static utilities.GDV5.KeysPressed;

public class Ball extends Rectangle {

    private Color color1;
    private Color color2;
    private int dX = 5, dY = 5;
    private int xFlag = 1;
    private int yFlag = 1;

    public Ball(int x, int y, int width, int height) {
        super(x, y, width, height);
        color1 = Color.red;
        color2 = Color.blue;
    }
    public void move() {
       x += dX * xFlag;
       y += dY * yFlag;
       if (y <= 0 || y + height >= 800) {
           yFlag *= -1;
            }
    }
    public void speedUp(){
        dX += 1;
        dY += 1;
    }
    public void startingPos() {
        x =  600;
        y = 400;
        dX = 3;
        dY = 3;
        xFlag = -xFlag;
    }
    public int getPos() {
        return x;
    }
    public int setX(int x) {
        this.x = x;
        return x;
    }
    public int setY(int dY) {
        this.y = y;
        return y;
    }
    public void collision() {
        xFlag = -xFlag;
    }
    public int getxFlag(){
        return xFlag;
    }
    public void updateBall(Paddle paddle) {
        if (this.intersects(paddle)) {
            this.collision();
            if (paddle.x > 600) this.x = paddle.x - paddle.width;
            else this.x = paddle.x + paddle.width;
            this.speedUp();
            paddle.speedUp();
        }
    }
    public String smashball(Paddle paddle) {
        if (this.intersects(paddle)) {
            if ((paddle.getDirection() > 0 && yFlag < 0) || (paddle.getDirection() < 0 && yFlag > 0)) {
                dY = -dY * 2;
                if (Math.abs(dY) > 10) dY = 12;
                dX = Math.min(8, dX + 1);
                return "Smashball!";
            }
        }
        return "";
    }
    public void scoreCheck(Scoreboard scoreboard) {
        if (this.getX() <= 0) {
            scoreboard.leftMiss();
            this.startingPos();
        }
        if (this.getX() >= 1200) {
            scoreboard.rightMiss();
            this.startingPos();
        }
    }
    public void draw(Graphics2D pb) {
        if (this.x > 600) pb.setColor(color1);
        else if (this.x <= 600) pb.setColor(color2);
        pb.drawOval(x, y, width, height);
        pb.fillOval(x, y, width, height);
    }
    public Color getColor() {return color1;}
}
