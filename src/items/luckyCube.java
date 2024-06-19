package items;

import resourcesManager.ImageManager;

import javax.swing.*;
import java.awt.*;

public class luckyCube extends Cube{
    public enum type{coin,redMushroom}
   // public static final BufferedImage imageNotT = new ImageIcon("src/gameResources/luckyCube.gif");
    //public static final BufferedImage imageT = new ImageIcon("src/gameResources/luckyCubeT.png");
    private boolean taken = false;
    private type throwing;
    private int up = 0;
    private boolean active;
    public luckyCube(int x, int y, type type) {
        super(x, y, Cube.type.OTHER);
        active = true;
        setImage(ImageManager.getImageIcon(ImageManager.ImageName.LUCKY_CUBE));
        throwing = type;
    }
    public void paint(Graphics graphics){
        Graphics2D g2d = (Graphics2D) graphics.create();
        g2d.drawImage(super.getImage().getImage(),getX(), getY()+up, width, height, null);
        g2d.dispose();
    }

    public boolean isTaken(){
        return taken;
    }
    public Object hasTaken(){
        Object throwItem;
        if (throwing == type.coin) {
            throwItem = new Coin(getX(), getY() - Coin.height - Coin.height / 3);
        }else {
            throwItem = new mushroom(getX(), getY()- mushroom.height-21, mushroom.type.RED);
        }

        taken = true;
        setImage(ImageManager.getImageIcon(ImageManager.ImageName.LUCKY_CUBE_BEEN_TAKEN));
        new Thread(()->{
            int sum = 0;
            while (sum < 40){
                if (active) {
                    if (sum < 20) {
                        up -= 1;
                    } else {
                        up += 1;
                    }

                    sum++;
                }

                try {
                    Thread.sleep(2);
                } catch (Exception e) {
                }

            }
        }).start();
        return throwItem;
    }
    public Rectangle floorSpace(){
        return new Rectangle(getX()+width/15,getY()+height ,width-width/15,height/15);
    }
    public luckyCube clone() throws CloneNotSupportedException{
        return (luckyCube) super.clone();
    }
    public void setActive(boolean newActive){
        active = newActive;
    }
}