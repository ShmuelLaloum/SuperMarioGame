package items;

import resourcesManager.ImageManager;

import javax.swing.*;
import java.awt.*;

public class brokenCube extends Cube {
    //public static final ImageIcon imageIcon = new ImageIcon("src/gameResources/brokenCube.png");

    public brokenCube(int x, int y) {
        super(x, y, Cube.type.OTHER);
        setImage(ImageManager.getImageIcon(ImageManager.ImageName.BROKEN_CUBE));
    }
    public Rectangle floorSpace(){
        return new Rectangle(getX()+ Cube.width/15,getY()+ Cube.height , Cube.width- Cube.width/15, Cube.height/15);
    }
    public brokenCube clone() throws CloneNotSupportedException{
        return (brokenCube)super.clone();
    }
}