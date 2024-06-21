package items;

import resourcesManager.ImageManager;

import javax.swing.*;
import java.awt.*;

public class BillBlaster implements groundAble, needLandAble {
    public static final ImageIcon image = ImageManager.getImageIcon(ImageManager.ImageName.BILL_BLASTER);
    public enum directionBill {right, left}
    private int x;
    private int y;
    public static final int width = 50;
    public static final int height = 50;
    private int distance = 1;
    private int direction;
    private int ground;
    private BulletBill bullet;
    private Thread moveThread;
    private Thread landUpdateThread;
    private volatile boolean active = false;  // מתחיל כ-false

    public BillBlaster(int x, int y, directionBill directionBill) {
        this.x = x;
        this.y = y;
        direction = directionBill == BillBlaster.directionBill.right ? -1 : 1;
        bullet = new BulletBill(direction == -1 ? x + 30 : x, y, directionBill);
    }

    public void paint(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics.create();
        bullet.paint(graphics);
        g2d.drawImage(image.getImage(), x, y, width, height, null);
        g2d.dispose();
    }

    private void createThreads() {
        moveThread = new Thread(this::moveBall);
        landUpdateThread = new Thread(this::LandUpdate);
    }

    public void moveBall() {
        while (active) {
            if (distance % 300 == 0) {
                distance = direction == -1 ? -6 : 6;
                bullet.setY(y);
            }
            distance += direction;
            bullet.setX((direction == -1 ? x + 30 : x) - distance);

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void LandUpdate() {
        while (active) {
            if (y < ground) {
                y++;
            }
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void setGround(int newG) {
        this.ground = newG;
    }

    public Rectangle floorSpace() {
        return new Rectangle(x + width / 15, y + height, width - width / 15, height / 15);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Rectangle body() {
        return new Rectangle(x, y, width, height);
    }

    public BulletBill getBullet() {
        return bullet;
    }

    public void StopsBullet() {
        distance = direction == -1 ? -6 : 6;
        bullet.setX((direction == -1 ? x + 30 : x) - distance);
    }

    public Rectangle rightField() {
        return new Rectangle(x + width, y, width / 15, height);
    }

    public Rectangle leftField() {
        return new Rectangle(x, y, width / 15, height);
    }
    public int getY() {
        return y;
    }
    public void setX(int newX){
        this.x = newX;
    }
    public int getX(){
        return this.x;
    }
    public Rectangle upperArea() {
        return  new Rectangle(x,y,width,height/15);
    }
    public void setActive(boolean newActive) {
        if (newActive && !active) {
            active  = true;
            createThreads();  // יצירת התרד מחדש
            moveThread.start();
            landUpdateThread.start();
        } else if (!newActive && active){
            active  = false;
            moveThread.interrupt();
            landUpdateThread.interrupt();
        }
    }

}