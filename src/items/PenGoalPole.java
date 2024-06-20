package items;

import resourcesManager.ImageManager;

import javax.swing.*;
import java.awt.*;

public class PenGoalPole implements needLandAble{
    public static final ImageIcon imageIcon = ImageManager.getImageIcon(ImageManager.ImageName.PEN_GOAL_POLE);
    private int x;
    private int y;
    private int ground;
    public static final int width = 70;
    public static final int height = 150;

    public PenGoalPole(int x, int y){
        this.x = x;
        this.y = y;
        LandUpdate();
    }
    public void paint(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics.create();
        g2d.drawImage(imageIcon.getImage(),x, y, width, height, null);
        g2d.drawImage(brokenCube.image.getImage(),x+width/5,y+height-Cube.height,Cube.width,Cube.height,null);
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

    @Override
    public void LandUpdate() {
        new Thread(()->{
            while (true){
                if ( y < ground){
                    y++;
                }
                try {
                    Thread.sleep(2);
                }catch (Exception e){

                }
            }
        }).start();
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
}