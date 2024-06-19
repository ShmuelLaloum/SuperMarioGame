package items;

import resourcesManager.ImageManager;

import javax.swing.*;
import java.awt.*;

public class bigTube implements groundAble, Cloneable{
    public enum type{enemy,ground}
    private int x;
    private int y;
    private int width;
    private int height;
    public static final ImageIcon imageIcon = new ImageIcon("src/gameResources/kube.png");
    private type status;
    private CarnivorousPlant carnivorousPlant = null;
    private int d;
    public bigTube(int x , int y , int width , int height, type type){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        status = type;
        d = x/15;

        if (status == bigTube.type.enemy){
            carnivorousPlant = new CarnivorousPlant(x+d,y+y/50,width/2,width/2);
        }
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
    public void setX(int newX){
        x = newX;
        if (carnivorousPlant != null){
            carnivorousPlant.setX(newX + d);
        }
    }
    public Rectangle upperArea(){
        Rectangle rectangle = new Rectangle(x,y,width,height/15);
        return rectangle;
    }

    public void paint(Graphics graphics){
        if (carnivorousPlant != null){
            carnivorousPlant.paint(graphics);
        }
        Graphics2D g2d = (Graphics2D) graphics.create();
        g2d.drawImage(ImageManager.getImageIcon(ImageManager.ImageName.KUBE).getImage(),x,y, width, height, null);
        g2d.dispose();
    }
    public int getWidth(){
        return width;
    }
    public Rectangle body(){
        Rectangle rectangle = new Rectangle(x,y,width,height);
        return rectangle;

    }
    public void takeDown(){
        if (carnivorousPlant != null){
            carnivorousPlant.setY(y+y/50);
        }
    }
    public type getStatus(){
        return status;
    }
    public CarnivorousPlant getCarnivorousPlant(){
        return carnivorousPlant;
    }
    public String toString(){
        return carnivorousPlant+"";
    }
    public void setCarnivorousPlant(){
        carnivorousPlant = new CarnivorousPlant(10,05,5,55);
    }
    public bigTube clone() throws CloneNotSupportedException{
        bigTube temp = (bigTube)super.clone();
        if (carnivorousPlant != null)
            temp.carnivorousPlant = carnivorousPlant.clone();
        return temp;
    }
    public void setActive(boolean newActive){
        if (carnivorousPlant != null) {
            carnivorousPlant.setActive(newActive);
        }
    }
}