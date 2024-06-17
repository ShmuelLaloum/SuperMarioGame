package items;

import resourcesManager.ImageManager;

import javax.swing.*;
import java.awt.*;

public class mushroom implements needLandAble {
    public enum type{RED}
    public static final ImageIcon imageRED = new ImageIcon("src/gameResources/mushroomRED.png");
    private ImageIcon imageIcon;
    private int x;
    private int y;
    private int Ground;
    public static final int width = 35;
    public static final int height = 35;
    private int direction = -1;

    public mushroom(int x, int y,type type){
        this.x = x;
        this.y = y;
        Ground = y;
        imageIcon = ImageManager.getImageIcon(ImageManager.ImageName.MUSHROOM_RED);
        LandUpdate();
        move();
    }
    public void paint(Graphics graphics){
        Graphics2D g2d = (Graphics2D) graphics.create();
        g2d.drawImage(imageIcon.getImage(),x,y, width, height, null);
        g2d.dispose();
    }
    @Override
    public void LandUpdate() {
        new Thread(()->{
            while (true){
                if ( y < Ground){
                    y++;
                }
                try {
                    Thread.sleep(2);
                }catch (Exception e){

                }
            }
        }).start();
    }
    public void move(){
        new Thread(()->{
            while (true) {
                this.x+=direction;
                try {
                    Thread.sleep(30);
                }catch (Exception e){

                }
            }
        }).start();
    }
    public void ChangeDirection() {
        x += direction < 0 ? 4 : -4;
        direction *= -1;
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
    public int getGround(){
        return  Ground;
    }
    public boolean collision (Rectangle rect1, Rectangle rect2) {
        return rect1.intersects(rect2);
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
    public Rectangle rightField(){
        return new Rectangle(x+width,y ,width/15,height);
    }
    public Rectangle leftField(){
        return new Rectangle(x,y ,width/15,height);
    }
    public Rectangle floorSpace(){
        return new Rectangle(x+width/15,y+height ,width-width/15,height/15);
    }
}