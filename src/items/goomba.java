package items;

import resourcesManager.ImageManager;
import resourcesManager.SoundManager;

import javax.swing.*;
import java.awt.*;

public class goomba implements enemyAble, needLandAble {
    public static final ImageIcon imageMarioGoesLeft = ImageManager.getImageIcon(ImageManager.ImageName.GOOMBA_GO_LEFT);
    public static final ImageIcon imageMarioGoesRight = ImageManager.getImageIcon(ImageManager.ImageName.GOOMBA_GO_RIGHT);
    private ImageIcon imageIcon;
    private int x;
    private int y;
    private int Ground;
    public static final int width = 35;
    public static final int height = 35;
    private int direction = -1;
    private volatile boolean active = false;  // מתחיל כ-false
    private volatile boolean alive;
    private Thread moveThread;
    private Thread landUpdateThread;
    private boolean finish = false;

    public goomba(int x, int y) {
        this.x = x;
        this.y = y;
        alive = true;
        imageIcon = imageMarioGoesLeft;
    }

    private void createThreads() {
        moveThread = new Thread(this::move);
        landUpdateThread = new Thread(this::LandUpdate);
    }

    private void move() {
        while (active && alive) {
            this.x += direction;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void LandUpdate() {
        while (active && alive) {
            if (y < Ground) {
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

    public void paint(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics.create();
        g2d.drawImage(imageIcon.getImage(), x, y + (!alive ? height / 2 : 0), width, (!alive ? height / 2 : height), null);
        g2d.dispose();
    }

    public void ChangeDirection() {
        imageIcon = imageIcon == imageMarioGoesLeft ? imageMarioGoesRight : imageMarioGoesLeft;
        x += direction < 0 ? 5 : -5;
        direction *= -1;
    }

    public Rectangle body() {
        return new Rectangle(x, y, width, height);
    }

    public Rectangle rightField() {
        return new Rectangle(x + width, y, width / 15, height);
    }

    public Rectangle leftField() {
        return new Rectangle(x, y, width / 15, height);
    }

    public Rectangle ceilingArea() {
        return new Rectangle(x + width / 15, y - height / 15, width - width / 15, height / 15);
    }

    public void setX(int newX) {
        x = newX;
    }

    public int getX() {
        return x;
    }

    public Rectangle floorSpace() {
        return new Rectangle(x + width / 15, y + height, width - width / 15, height / 15);
    }

    public void die() {
        alive = false;
        if (SoundManager.isPlayMusicEffect())
            SoundManager.playSound(SoundManager.SoundName.GOOMBA_DIE, 6.0f);
        imageIcon = ImageManager.getImageIcon(ImageManager.ImageName.GOOMBA_DIE);
        new Thread(() -> {
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
            finish = true;
        }).start();
    }

    public void setGround(int newG) {
        this.Ground = newG;
    }

    public int getGround() {
        return Ground;
    }

    public int getHeight() {
        return height;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getWidth() {
        return width;
    }

    public int getY() {
        return y;
    }
    public int getDirection(){
        return direction;
    }
    public boolean isFinish(){
        return finish;
    }
    public synchronized void setActive(boolean newActive) {
        if (newActive && !active){
            active = true;
            createThreads();  // יצירת התרדים מחדש כדי שנוכל להפעילם שוב
            moveThread.start();
            landUpdateThread.start();
        } else if (!newActive && active) {
            active = false;
            moveThread.interrupt();
            landUpdateThread.interrupt();

            /*try {
                landUpdateThread.join();  // להמתין עד שהתרד יסיים
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();  // לשחזר את המצב של ה-interrupt
            }

             */
        }
    }
}