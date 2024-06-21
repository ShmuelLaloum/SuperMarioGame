package items;

import resourcesManager.ImageManager;

import javax.swing.*;
import java.awt.*;

public class mushroom implements needLandAble {
    public enum type{RED}
    public static final ImageIcon imageRED = ImageManager.getImageIcon(ImageManager.ImageName.MUSHROOM_RED);
    private ImageIcon imageIcon;
    private int x;
    private int y;
    private int Ground;
    public static final int width = 35;
    public static final int height = 35;
    private int direction = -1;
    private volatile boolean active = false;  // מתחיל כ-false
    private Thread moveThread;
    private Thread landUpdateThread;

    public mushroom(int x, int y,type type){
        this.x = x;
        this.y = y;
        Ground = y;
        imageIcon = imageRED;
    }
    public void paint(Graphics graphics){
        Graphics2D g2d = (Graphics2D) graphics.create();
        g2d.drawImage(imageIcon.getImage(),x,y, width, height, null);
        g2d.dispose();
    }
    private void createThreads() {
        moveThread = new Thread(this::move);
        landUpdateThread = new Thread(this::LandUpdate);
    }
    @Override
    public void LandUpdate() {
        while (active){
            if (y < Ground) {
                y++;
            }
        }
        try {
            Thread.sleep(2);
        } catch (Exception e) {
        }
    }

    public void move(){
        while (active) {
            this.x += direction;

            try {
                Thread.sleep(30);
            } catch (Exception e) {
            }
        }
    }
    public void ChangeDirection() {
        x += direction < 0 ? 4 : -4;
        direction *= -1;
    }
    public void setActive(boolean newActive){
        if (newActive && !active){
            active = true;
            createThreads();  // יצירת התרדים מחדש כדי שנוכל להפעילם שוב
            moveThread.start();
            landUpdateThread.start();
        } else if (!newActive && active) {
            active = false;
            moveThread.interrupt();
            landUpdateThread.interrupt();
        }
    }
    public int getDirection(){
        return direction;
    }
    public int getGround(){
        return Ground;
    }


    public void  setGround(int newG){
        this.Ground = newG;
    }
    public int getHeight(){
        return  height;
    }
    public int getWidth(){
        return width;
    }
    public int getY(){
        return y;
    }
    public Rectangle body(){
        return new Rectangle(x,y,width,height);
    }
    public void setX(int newX){
        x = newX;
    }
    public int getX(){
        return x;
    }
    public Rectangle floorSpace(){
        return new Rectangle(x+width/15,y+height ,width-width/15,height/15);
    }
    public Rectangle rightField() {
        return new Rectangle(x + width, y, width / 15, height);
    }

    public Rectangle leftField() {
        return new Rectangle(x, y, width / 15, height);
    }
}