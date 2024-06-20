package items;

import resourcesManager.ImageManager;

import javax.swing.*;
import java.awt.*;

public class brokenCube extends Cube {
    public static final ImageIcon image =ImageManager.getImageIcon(ImageManager.ImageName.BROKEN_CUBE);

    public brokenCube(int x, int y) {
        super(x, y, Cube.type.OTHER);
        setImage(image);
    }
    public Rectangle floorSpace(){
        return new Rectangle(getX()+ Cube.width/15,getY()+ Cube.height , Cube.width- Cube.width/15, Cube.height/15);
    }
}