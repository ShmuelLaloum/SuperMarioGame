package items;

import resourcesManager.ImageManager;

import javax.swing.*;
import java.awt.*;

public class castle implements needLandAble {
    public static final ImageIcon imageIcon = ImageManager.getImageIcon(ImageManager.ImageName.CASTLE);
    private int x;
    private int y;
    private int ground;
    public static final int width = 200;
    public static final int height = 200;
    private volatile boolean active = false;  // מתחיל כ-false
    private Thread landUpdateThread;

    public castle(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void paint(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics.create();
        g2d.drawImage(imageIcon.getImage(),x, y, width, height, null);
        g2d.dispose();
    }
    private void createThread() {
        landUpdateThread = new Thread(this::LandUpdate);
    }
    public void setX(int newX){
        x = newX;
    }
    public int getX(){
        return x;
    }
    public Rectangle body(){
        return new Rectangle(x,y,width,height);
    }

    @Override
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

    @Override
    public void setGround(int newG) {
        ground = newG;
    }

    @Override
    public Rectangle floorSpace() {
        return new Rectangle(x+width/15,y+height ,width-width/15,height/15);
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }
    public synchronized void setActive(boolean newActive) {
        if (newActive && !active){
            active = true;
            createThread();  // יצירת התרדים מחדש כדי שנוכל להפעילם שוב
            landUpdateThread.start();
        } else if (!newActive && active) {
            active = false;
            landUpdateThread.interrupt();
        }
    }
}