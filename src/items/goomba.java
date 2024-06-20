package items;

import resourcesManager.ImageManager;
import resourcesManager.SoundManager;

import javax.swing.*;
import java.awt.*;

public class goomba implements enemyAble,needLandAble {
    public static final ImageIcon imageMarioGoesLeft = ImageManager.getImageIcon(ImageManager.ImageName.GOOMBA_GO_LEFT);
    public static final ImageIcon imageMarioGoesRight = ImageManager.getImageIcon(ImageManager.ImageName.GOOMBA_GO_RIGHT);
    private ImageIcon imageIcon;
    private int x;
    private int y;
    private int Ground;
    public static final int width = 35;
    public static final int height = 35;
    private int direction = -1;
    private boolean running = true;
    private boolean alive;
    private boolean active;
    public goomba(int x, int y){
        this.x = x;
        this.y = y;
        alive = true;
        active = true;
        imageIcon = imageMarioGoesLeft;
        move();
        LandUpdate();
    }
    public void paint(Graphics graphics){
        Graphics2D g2d = (Graphics2D) graphics.create();
        g2d.drawImage(imageIcon.getImage(), x, y+(!running ? height/2 : 0), width, (!running ? height/2 : height), null);
        g2d.dispose();
    }

    public void move(){
        new Thread(()->{
            while (running) {
                if (active) {
                    this.x += direction;
                }
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                }
            }
        }).start();
    }
    public void ChangeDirection(){
        imageIcon = imageIcon == imageMarioGoesLeft ? imageMarioGoesRight : imageMarioGoesLeft;
        x += direction < 0 ? 5 : -5;
        direction *=-1;
    }
    public Rectangle body(){
        return new Rectangle(x,y,width,height);
    }
    public Rectangle ceilingArea(){
        return new Rectangle(x+width/15,y-height/15 ,width-width/15,height/15);
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
    public void die(){
        running = false;
        SoundManager.playSound(SoundManager.SoundName.GOOMBA_DIE,6.0f);
        imageIcon = ImageManager.getImageIcon(ImageManager.ImageName.GOOMBA_DIE);
        new Thread(()->{
            try {
                Thread.sleep(300);
            }catch (Exception e){
            }
            alive = false;
        }).start();
    }
    @Override
    public void LandUpdate(){
        new Thread(()->{
            while (isAlive()){
                if (active) {
                    if (y < Ground) {
                        y++;
                    }
                }
                try {
                    Thread.sleep(2);
                } catch (Exception e) {

                }
            }
        }).start();
    }
    public void setGround(int newG){
        this.Ground = newG;
    }
    public int getHeight(){
        return  height;
    }
    public boolean isAlive(){
        return alive;
    }
    public int getWidth(){
        return width;
    }
    public void setActive(boolean newActive){
        active = newActive;
    }
}