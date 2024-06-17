package items;

import resourcesManager.ImageManager;

import javax.swing.*;
import java.awt.*;

public class CarnivorousPlant implements enemyAble, Cloneable{
    public static final ImageIcon imageIcon = new ImageIcon("src/gameResources/CarnivorousPlant.gif");
    private int up;
    private int x;
    private int y;
    private int width; //50;
    private int height; //50;

    public CarnivorousPlant(int x, int y,int width,int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        up = (int)(height);
        moveUpAndDown();
    }

    public void paint(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics.create();
        g2d.drawImage(ImageManager.getImageIcon(ImageManager.ImageName.CARNIVOROUS_PLANT).getImage(),x, y, width, height, null);
        g2d.dispose();
    }
    public void moveUpAndDown(){
        new Thread(()->{
            int sum = 0;
            int g = 1;
            while (true){
                if (sum % up == 0){
                    g *=-1;
                    sum = 0;
                }
                y+=g;
                sum++;
                try {
                    Thread.sleep(30);
                }catch (Exception e){

                }
            }
        }).start();
    }
    public void setY(int newY){
        y = newY;
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
    public CarnivorousPlant clone() throws CloneNotSupportedException{
        return (CarnivorousPlant)super.clone();
    }
}