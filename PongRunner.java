package game;

import utilities.GDV5;
import java.awt.*;
import java.awt.event.KeyEvent;

public class PongRunner extends GDV5 {

    private Ball ball = new Ball(600, 400, 20, 20);
    private Paddle leftPaddle = new Paddle(0, 320, 20, 80);
    private Paddle rightPaddle = new Paddle(1180, 320, 20, 80);
    private Scoreboard scoreboard = new Scoreboard(0, 0);
    private int gameState = 0;
    private int mode = 0;
    private String smashballMessage = "";
    private int smashballTimer = 0;
    public static void main(String[] args) {
        PongRunner p = new PongRunner();
        p.start();
    }
    public void gameReset(){
        gameState = 0;
        mode = 0;
        scoreboard.reset();
        ball.startingPos();
    }

    @Override
    public void update() {
        ball.move();
        ball.updateBall(leftPaddle); ball.updateBall(rightPaddle);
        if (gameState != 3) ball.scoreCheck(scoreboard);
        leftPaddle.wasdMove();
        smashballMessage = ball.smashball(leftPaddle);
        if (smashballMessage.equals("")) {
            smashballMessage = ball.smashball(rightPaddle);
        } if (scoreboard.getIntLeftScore() == 7 || scoreboard.getIntRightScore() == 7) {
            gameState = 3;
        } if (gameState == 2) {
            rightPaddle.arrowkeysMove();
        } else if (gameState == 1) {
            rightPaddle.ai(ball);
        } else if (gameState == 0) {
            if (KeysPressed[KeyEvent.VK_1]) mode = 1;
            if (KeysPressed[KeyEvent.VK_2]) mode = 2;
        } if (gameState == 3 && KeysPressed[KeyEvent.VK_ENTER]) {
            gameReset();
        }
    }
    @Override
    public void draw(Graphics2D win) {
        if (gameState == 2 || gameState == 1) {
            ball.draw(win);
            win.setColor(Color.BLUE);
            leftPaddle.draw(win);
            win.setColor(Color.RED);
            rightPaddle.draw(win);
            win.setColor(Color.white);
            win.setFont(new Font("Arial", Font.BOLD, 100));
            win.drawString(scoreboard.getRightScore(), 300, 400);
            win.drawString(scoreboard.getLeftScore(), 900, 400);
            win.setFont(new Font("Arial", Font.BOLD, 30));
            win.setColor(Color.GREEN);
            if (!smashballMessage.equals("") && smashballTimer <= 0) smashballTimer = 1500;
            if (smashballTimer > 0) {
                win.drawString("Smashball!", 800, 700);
                smashballTimer--;
            }
            win.setColor(Color.WHITE);
            for (int i = 0; i < 12; i++) {
                win.setFont(new Font("Arial", Font.CENTER_BASELINE, 50));
                win.drawString("|", 600, i * 80);
            }
        }

        if (gameState == 0) {
            win.setColor(Color.white);
            win.setFont(new Font("Arial", Font.BOLD, 25));
            if (mode == 0) {
                win.drawString("Hello! Welcome to Brandon Anderson's Pong Game.", 50, 300);
                win.drawString("Press 1 for Single Player Mode and 2 for Multiplayer Mode.", 50, 500);
            }
            if (mode == 1) {
                win.drawString("Single Player Mode:", 50, 200);
                win.drawString("Use W to move up and S to move down. First to 7 points wins. Good luck!", 50, 350);
                win.drawString("Press SPACE to Begin.", 50, 500);
                if (KeysPressed[KeyEvent.VK_SPACE]) {
                    gameState = 1;
                    scoreboard.reset();
                }
            } else if (mode == 2) {
                win.drawString("Multiplayer Mode:", 50, 200);
                win.drawString("Player 1 - Use W to move up and S to move down.", 50, 275);
                win.drawString("Player 2 - Use the Up Arrow key to move up and the Down Arrow key to move down.", 50, 350);
                win.drawString("First to 7 points wins. Good luck!", 50, 425);
                win.drawString("Press SPACE to Begin.", 50, 500);
                if (KeysPressed[KeyEvent.VK_SPACE]) {
                    gameState = 2;
                    scoreboard.reset();
                }
            }
        }

        if (gameState == 3) {
            win.setColor(Color.white);
            win.setFont(new Font("Arial", Font.BOLD, 25));
            win.drawString(scoreboard.gameOver(), 200, 400);
            if (KeysPressed[KeyEvent.VK_ENTER]) {
                gameState = 0;
                mode = 0;
            }
        }
    }
}
