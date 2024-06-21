package items;

import resourcesManager.ImageManager;

import javax.swing.*;
import java.awt.*;

public class Cube implements groundAble {
    public enum type{LAND,GRASS,WOOD,OTHER}
    private ImageIcon image;
    public static final ImageIcon imageGrassCube = ImageManager.getImageIcon(ImageManager.ImageName.GRASS_CUBE);
    public static final ImageIcon imageWoodCube = ImageManager.getImageIcon(ImageManager.ImageName.WOOD_CUBE);
    public static final ImageIcon imageLandCube = ImageManager.getImageIcon(ImageManager.ImageName.LAND_CUBE);
    private int x;
    private int y;
    public static final int width = 30;
    public static final int height = 30;

    public Cube(int x,int y,type type){
        this.x = x;
        this.y = y;
        if (type == Cube.type.GRASS){
            image = imageGrassCube;
        }else if (type == Cube.type.WOOD){
            image = imageWoodCube;
        }else if (type == Cube.type.LAND){
            image = imageLandCube;
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
    public ImageIcon getImage(){
        return image;
    }
    public Rectangle rightField(){
        return new Rectangle(x+width,y ,width/15,height);
    }
    public Rectangle leftField(){
        return new Rectangle(x,y,width/15,height);
    }
}