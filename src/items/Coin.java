package items;

import resourcesManager.ImageManager;
import resourcesManager.SoundManager;

import javax.swing.*;
import java.awt.*;


public class Coin implements Cloneable{
    private int x;
    private int y;
    public static final int width = 30;
    public static final int height = 30;
    private boolean startCollected = false;
    private boolean finishedCollected = false;
    public static final ImageIcon imageIcon = new ImageIcon("src/gameResources/coin.png");
    private boolean active;

    public Coin(int x, int y){
        this.x = x;
        this.y = y;
        active = true;
    }
    public void paint(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics.create();
        g2d.drawImage(ImageManager.getImageIcon(ImageManager.ImageName.COIN).getImage(),x, y, width, height, null);
        g2d.dispose();
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

    public void collected(){
        SoundManager.stopSound(SoundManager.SoundName.MARIO_COLLECTS_COIN);
        startCollected = true;
        new Thread(()->{
            SoundManager.playSound(SoundManager.SoundName.MARIO_COLLECTS_COIN,-15.0f);
            int sum = 0;
            while (x < 1500 /*705*/ || y > 60) {
                if (active) {
                    if (x < 1500) {
                        x++;
                        sum++;
                    }
                    if (y > 60 && sum == 2 || x == 1500) {
                        y--;
                        sum = 0;
                    }
                }
                try {
                    Thread.sleep(2);
                } catch (Exception e) {
                }
            }
            finishedCollected = true;
        }).start();
    }
    public boolean isStartCollected(){
        return startCollected;
    }
    public boolean isFinishedCollecting(){
        return finishedCollected;
    }
    public void upAndDown(){
        new Thread(()->{
            int sum = 0;
            while (sum < 100){
                if (active) {
                    if (sum < 50) {
                        y--;
                    } else {
                        y++;
                    }
                    sum++;
                }
                try {
                    Thread.sleep(2);
                } catch (Exception e) {

                }

            }
        }).start();
    }
    public Coin clone() throws CloneNotSupportedException{
        return (Coin)super.clone();
    }
    public void setActive(boolean newActive){
        active = newActive;
    }
}