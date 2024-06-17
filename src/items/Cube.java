package items;

import resourcesManager.ImageManager;

import javax.swing.*;
import java.awt.*;

public class Cube implements groundAble,Cloneable {
    public enum type{LAND,GRASS,WOOD,OTHER}
    private ImageIcon image;
    public static final ImageIcon imageGrassCube = new ImageIcon("src/gameResources/grassCube.jpg");
    public static final ImageIcon imageWoodCube = new ImageIcon("src/gameResources/woodCube.jpg");
    public static final ImageIcon imageLandCube = new ImageIcon("src/gameResources/landCube.jpg");
    private int x;
    private int y;
    public static final int width = 30;
    public static final int height = 30;

    public Cube(int x,int y,type type){
        this.x = x;
        this.y = y;
        if (type == Cube.type.GRASS){
            image = ImageManager.getImageIcon(ImageManager.ImageName.GRASS_CUBE);
        }else if (type == Cube.type.WOOD){
            image = ImageManager.getImageIcon(ImageManager.ImageName.WOOD_CUBE);
        }else if (type == Cube.type.LAND){
            image = ImageManager.getImageIcon(ImageManager.ImageName.LAND_CUBE);
        }
    }
    public void setImage(ImageIcon newImage){
        image = newImage;
    }
    public void paint(Graphics graphics){
        Graphics2D g2d = (Graphics2D) graphics.create();
        g2d.drawImage(image.getImage(),x, y, width, height, null);
        g2d.dispose();
    }

    public int getY(){
        return y;
    }
    public int getX(){
        return x;
    }
    public int getHeight(){
        return height;
    }
    public Rectangle upperArea(){
        Rectangle rectangle = new Rectangle(x,y,width,height/15);
        return rectangle;
    }
    public void setY(int newY){
        y = newY;

    }
    public Rectangle body(){
        Rectangle rectangle = new Rectangle(x,y,width,height);
        return rectangle;
    }
    public void setX(int newX){
        x = newX;
    }
    public int getWidth(){
        return width;
    }
    public Cube clone() throws CloneNotSupportedException{
        return (Cube)super.clone();
    }
    public ImageIcon getImage(){
        return image;
    }
}