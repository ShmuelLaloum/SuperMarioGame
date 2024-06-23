package gameScreens;

import items.Mario;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {
    private boolean rightPressed = false;
    private boolean leftPressed = false;
    private boolean jumpPressed = false;
    private boolean active = false;
    private Mario mario;
    private GameFrame gameFrame;
    private Thread updateMovementThread;

    public Controller(Mario mario, GameFrame gameFrame) {
        this.mario = mario;
        this.gameFrame = gameFrame;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
            rightPressed = true;
        } else if (keyCode == KeyEvent.VK_LEFT  || keyCode == KeyEvent.VK_A ) {
            leftPressed = true;
        } else if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
            jumpPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
            rightPressed = false;
        }else if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
            leftPressed = false;
        } else if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
            jumpPressed = false;
        }
    }

    private void updateMovement() {
        while (mario.isAlive() && active) {
            if (jumpPressed) {
                if (rightPressed) {
                    if (mario.isCanGoRight()) {
                        mario.moveRight();
                        gameFrame.moveScreen(-Mario.walkingDistance);
                    }
                    mario.jump();
                } else if (leftPressed) {
                    if (mario.isCanGoLeft()) {
                        mario.moveLeft();
                        gameFrame.moveScreen(Mario.walkingDistance);
                    }
                    mario.jump();
                } else {
                    mario.jump();
                }
            } else {
                if (rightPressed && mario.isCanGoRight()) {
                    mario.moveRight();
                    gameFrame.moveScreen(-Mario.walkingDistance);
                } else if (leftPressed && mario.isCanGoLeft()) {
                    mario.moveLeft();
                    gameFrame.moveScreen(Mario.walkingDistance);
                }
            }
            try {
                Thread.sleep(30);
            } catch (Exception e) {
            }
        }
    }
    private void createThread() {
        updateMovementThread = new Thread(this::updateMovement);
    }
    public synchronized void setActive(boolean newActive) {
        if (newActive && !active){
            active = true;
            createThread();  // יצירת התרדים מחדש כדי שנוכל להפעילם שוב
            updateMovementThread.start();
        } else if (!newActive && active) {
            active = false;
            updateMovementThread.interrupt();
        }
    }
}