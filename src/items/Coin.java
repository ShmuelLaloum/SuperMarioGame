package items;

import resourcesManager.ImageManager;
import resourcesManager.SoundManager;

import javax.swing.*;
import java.awt.*;


public class Coin{
    private int x;
    private int y;
    public static final int width = 30;
    public static final int height = 30;
    private boolean startCollected = false;
    private boolean finishedCollected = false;
    public static final ImageIcon imageIcon = ImageManager.getImageIcon(ImageManager.ImageName.COIN);
    private boolean active;
    private static int widthFrame;

    public Coin(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void paint(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics.create();
        g2d.drawImage(imageIcon.getImage(),x, y, width, height, null);
        g2d.dispose();
    }
    public static void setWidthFrame(int newWidth){
        widthFrame = newWidth;
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
            if (SoundManager.isPlayMusicEffect())
                SoundManager.playSound(SoundManager.SoundName.MARIO_COLLECTS_COIN,-15.0f);
            int sum = 0;
            while (x < widthFrame || y > 60) {
                if (active) {
                    if (x < widthFrame) {
                        x++;
                        sum++;
                    }
                    if (y > 60 && sum == 2 || x == widthFrame) {
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
    public synchronized void setActive(boolean newActive){
        active = newActive;
    }
}