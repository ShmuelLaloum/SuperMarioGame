package items;

import resourcesManager.ImageManager;

import javax.swing.*;
import java.awt.*;

public class luckyCube extends Cube{
    public enum type{coin,redMushroom}
   public static final ImageIcon imageNotTake = ImageManager.getImageIcon(ImageManager.ImageName.LUCKY_CUBE);
    public static final ImageIcon imageTake = ImageManager.getImageIcon(ImageManager.ImageName.LUCKY_CUBE_BEEN_TAKEN);
    private boolean taken = false;
    private type throwing;
    private int up = 0;
    private boolean active;
    public luckyCube(int x, int y, type type) {
        super(x, y, Cube.type.OTHER);
        active = true;
        setImage(imageNotTake);
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
        setImage(imageTake);
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
    public synchronized void setActive(boolean newActive){
        active = newActive;
    }
}