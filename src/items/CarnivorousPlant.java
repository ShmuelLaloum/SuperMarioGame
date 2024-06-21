package items;

import resourcesManager.ImageManager;

import javax.swing.*;
import java.awt.*;

public class CarnivorousPlant implements enemyAble {
    public static final ImageIcon imageIcon = ImageManager.getImageIcon(ImageManager.ImageName.CARNIVOROUS_PLANT);
    private int up;
    private int x;
    private int y;
    private int width; //50;
    private int height; //50;
    private int sum = 0;
    private int direction = 1;

    private volatile boolean active = false;
    private Thread moveThread;

    public CarnivorousPlant(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        up = height;
    }

    public void paint(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics.create();
        g2d.drawImage(imageIcon.getImage(), x, y, width, height, null);
        g2d.dispose();
    }

    private void createThreads() {
        moveThread = new Thread(this::moveUpAndDown);
    }

    private void moveUpAndDown() {
        while (active) {
            if (sum % up == 0) {
                direction *= -1;
                sum = 0;
            }
            y += direction;
            sum++;

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void setY(int newY) {
        y = newY;
    }

    public void setX(int newX) {
        x = newX;
    }

    public int getX() {
        return x;
    }

    public Rectangle body() {
        return new Rectangle(x, y, width, height);
    }
    public synchronized void setActive(boolean newActive) {
        if (newActive && !active) {
            active = true;
            createThreads();  // יצירת התרד מחדש
            moveThread.start();
        } else if (!newActive && active) {
            active = false;
            moveThread.interrupt();
        }
    }
}
